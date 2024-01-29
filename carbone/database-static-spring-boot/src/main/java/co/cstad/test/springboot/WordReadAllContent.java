package co.cstad.test.springboot;

import org.apache.poi.xwpf.usermodel.*;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.List;
import java.util.*;

public class WordReadAllContent {

	static void traversePictures(List<XWPFPicture> pictures) throws Exception {
		for (XWPFPicture picture : pictures) {
			System.out.println(picture);
			XWPFPictureData pictureData = picture.getPictureData();
			System.out.println(pictureData);
		}
	}

	static void traverseRunElements(List<IRunElement> runElements) throws Exception {
		for (IRunElement runElement : runElements) {
			if (runElement instanceof XWPFFieldRun) {
				XWPFFieldRun fieldRun = (XWPFFieldRun) runElement;
				System.out.println(fieldRun.getClass().getName());
				System.out.println(fieldRun);
				traversePictures(fieldRun.getEmbeddedPictures());
			} else if (runElement instanceof XWPFHyperlinkRun) {
				XWPFHyperlinkRun hyperlinkRun = (XWPFHyperlinkRun) runElement;
				System.out.println(hyperlinkRun.getClass().getName());
				System.out.println(hyperlinkRun);
				traversePictures(hyperlinkRun.getEmbeddedPictures());
			} else if (runElement instanceof XWPFRun) {
				XWPFRun run = (XWPFRun) runElement;
				System.out.println(run.getClass().getName());
				System.out.println(run);
				traversePictures(run.getEmbeddedPictures());
			} else if (runElement instanceof XWPFSDT) {
				XWPFSDT sDT = (XWPFSDT) runElement;
				System.out.println(sDT);
				System.out.println(sDT.getContent());
				//ToDo: The SDT may have traversable content too.
			}
		}
	}

	static void traverseTableCells(List<ICell> tableICells) throws Exception {
		for (ICell tableICell : tableICells) {
			if (tableICell instanceof XWPFSDTCell) {
				XWPFSDTCell sDTCell = (XWPFSDTCell) tableICell;
				System.out.println(sDTCell);
				//ToDo: The SDTCell may have traversable content too.
			} else if (tableICell instanceof XWPFTableCell) {
				XWPFTableCell tableCell = (XWPFTableCell) tableICell;
				System.out.println(tableCell);
				traverseBodyElements(tableCell.getBodyElements());
			}
		}
	}

	static void traverseTableRows(List<XWPFTableRow> tableRows) throws Exception {
		for (XWPFTableRow tableRow : tableRows) {
			System.out.println(tableRow);
			traverseTableCells(tableRow.getTableICells());
		}
	}

	static void traverseBodyElements(List<IBodyElement> bodyElements) throws Exception {
		for (IBodyElement bodyElement : bodyElements) {
			if (bodyElement instanceof XWPFParagraph) {
				XWPFParagraph paragraph = (XWPFParagraph) bodyElement;
				System.out.println(paragraph);
				traverseRunElements(paragraph.getIRuns());
			} else if (bodyElement instanceof XWPFSDT) {
				XWPFSDT sDT = (XWPFSDT) bodyElement;
				System.out.println(sDT);
				System.out.println(sDT.getContent());
				//ToDo: The SDT may have traversable content too.
			} else if (bodyElement instanceof XWPFTable) {
				XWPFTable table = (XWPFTable) bodyElement;
				System.out.println(table);
				traverseTableRows(table.getRows());
			}
		}
	}

	public static void main(String[] args) throws Exception {

		String inFilePath = "/home/lim-hai/Documents/Test2.doc";

		XWPFDocument document = new XWPFDocument(new FileInputStream(inFilePath));
		traverseBodyElements(document.getBodyElements());

		document.close();


		try {
			// Load the existing Word document

			FileInputStream fis = new FileInputStream("/home/lim-hai/Documents/Test2.doc");
			XWPFDocument document1 = new XWPFDocument(fis);
			// Get the current date as a dynamic date string
			Date currentDate = new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String dateString = dateFormat.format(currentDate);

			int month = 3; // Replace with your desired month (1 for January, 2 for February, etc.)
			int day = 1;
			String monthString = Month.of(month).getDisplayName(TextStyle.FULL, Locale.getDefault());
			String dayString = DayOfWeek.of(day).getDisplayName(TextStyle.FULL, Locale.getDefault());
			System.out.println("Month " + month + " is: " + monthString);
			// Define your macro replacements
			Map<String, String> macroReplacements = new HashMap<>();
			macroReplacements.put("«SOURCE_VERSION»", "MPCT_"+UUID.randomUUID().toString());
			macroReplacements.put("«DATE_TIME_DAY»", dayString);
			macroReplacements.put("«DATE_TIME_MONTH»", monthString);
			macroReplacements.put("«DATE_TIME_YEAR»", "2024");
			macroReplacements.put("«MT»", "ក្រសួងប្រៃសណីយ៍និងទូរគមនាគមន៍");
			macroReplacements.put("«DOM»", "SETH PIS ETH");
			macroReplacements.put("«DIS»", "ការគាំទ្រនឹងសមត្ថកិច្ច និងបង្កើតមុខងារប្រចាំថ្ងៃទាំងប្រទេស ជួបស្រៈនឹងការអភិវឌ្ឍន៍និងគ្រប់គ្រងនៅតាមបរិវេណមន្ត្រី។ មិនត្រូវបានបរាជ័យឬទទួលបានការគាំទ្របន្តិចជាមុនៗទេ។ ដូច្នេះ ខ្ញុំសូមបញ្ហាលុបតំរូវឲ្យមានការគាំទ្រដោយសារពលរដ្ឋនិងសារទូតប្រាក់ជាមួយសហគមន៍មុតមុខ");

			macroReplacements.put("«KVT»", "មនុស្សណាម្នាក់ ក្រុមណាមួយឬធ្វីមួយ ទាំងរូបី ទាំងអរូបី ដែលទទួលរងអំពើ (ផ្លូវកាយឬផ្លូវចិត្ត) ពីប្រធានឬអ្នកធ្វើអំពើ។ ឧ. ១-លោក ត្រូវបានលោក ប្រើប្រាស់ ដើម្បីសម្រេចបំណងរបស់ខ្លួន។ ក្នុងករណីនេះលោក គឺជាកម្មវត្ថុ ឯលោក  គឺជាប្រធាន (អ្នកធ្វើអំពី) ឧ.២-សច្ចភាពដែលក្រុមណាមួយកំពុងស្វែងរកដើម្បីដោះស្រាយជម្លោះ ឬ បញ្ហាណាមួយដែលកំពុងកើតឡើងគឺជាកម្មវត្ថុ");
			// Add more macros as needed

			// Replace macros in the document
			replaceMacrosInDocument(document1, macroReplacements);

			// Save the updated document
			File targetFile = new File("Updated.docx");
			FileOutputStream fos = new FileOutputStream(targetFile);
			document1.write(fos);

			// Close the streams
			fis.close();
			fos.close();
			Desktop.getDesktop().open(targetFile);
			System.out.println("Word document updated successfully.");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	private static void replaceMacrosInDocument(XWPFDocument document,
												Map<String, String> replacements) {
		// Replace macros in paragraphs

		for (XWPFParagraph paragraph : document.getParagraphs()) {
			replaceMacrosInParagraph(paragraph, replacements);
		}

		// Replace macros in tables
		for (XWPFTable table : document.getTables()) {
			for (XWPFTableRow row : table.getRows()) {
				for (XWPFTableCell cell : row.getTableCells()) {
					for (XWPFParagraph paragraph : cell.getParagraphs()) {
						replaceMacrosInParagraph(paragraph, replacements);
					}
				}
			}
		}

		// Replace macros in headers
		for (XWPFHeader header : document.getHeaderList()) {
			for (XWPFParagraph paragraph : header.getParagraphs()) {
				replaceMacrosInParagraph(paragraph, replacements);
			}
		}

		// Replace macros in footers
		for (XWPFFooter footer : document.getFooterList()) {
			for (XWPFParagraph paragraph : footer.getParagraphs()) {
				replaceMacrosInParagraph(paragraph, replacements);
			}
		}
	}

	private static void replaceMacrosInParagraph(XWPFParagraph paragraph,
												 Map<String, String> replacements) {
		for (XWPFRun run : paragraph.getRuns()) {
			String text = run.getText(0);

			if (text != null) {
				for (Map.Entry<String, String> entry : replacements.entrySet()) {
					text = text.replace(entry.getKey(), entry.getValue());
				}
				run.setText(text, 0);
			}
		}
	}
}
