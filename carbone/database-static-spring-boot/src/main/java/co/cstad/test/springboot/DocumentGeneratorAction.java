package co.cstad.test.springboot;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;


/**
 * Created by migue on 11/11/2020.
 */
public class DocumentGeneratorAction {

	public static ByteArrayInputStream generateDocument(String templatePath, JSONObject fields){
		/** used as reference: https://stackoverflow.com/a/49765239/5936443   [at 11/11/2020];
		 is method is responsible for generating a document as a ByteArrayInputStream, using an exisiting word template at templatePath
		 It replaces any keyTags in the document by the corresponding value in the JSONObject fields
		 it assumes the keyTags come preceeded by the separator "{#" and proceeded by "#}", in the following form: {#keyTag#}
		 */
		try {
			XWPFDocument doc = new XWPFDocument(OPCPackage.open(templatePath));

			// search in paragraphs
			for(XWPFParagraph p : doc.getParagraphs()){
				replaceFieldsParagraph(p, fields);
			}

			// search in tables
			for(XWPFTable t : doc.getTables()){
				replaceFieldsTable(t, fields);
			}

			ByteArrayOutputStream out = new ByteArrayOutputStream();
			doc.write(out);
			ByteArrayInputStream inputStream = new ByteArrayInputStream(out.toByteArray());
			return inputStream;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		}
		return null;
	}


	public static void replaceFieldsParagraph(XWPFParagraph paragraph, JSONObject fields){
		/** this method is responsible for replacing any ocurrences in the paragraph of any of the keyTags
		 * present in the JSONObject fields by the corresponding value */
		String text = paragraph.getText(); //all the text from each run concatenated
		String findStr;
		if( !text.contains("{#")) //paragraph doesn't have keys to replace
			return;

		// for each field to replace, search it in the curr paragraph
		for( String key : fields.keySet()){
			findStr = "{#" + key + "#}";
			// if paragraph doesn't have current key, we skip to next key
			if( text.contains(findStr)) {
				mergeRunsWithSplittedKeyTags(paragraph);
				for (XWPFRun run : paragraph.getRuns()) {
					// check if current run has current key
					checkAndReplaceFieldRun(run, findStr, String.valueOf(fields.get(key)));
				}
			}
		}
	}

	public static void replaceFieldsTable(XWPFTable table, JSONObject fields){
		/** this method is responsible for replacing any ocurrences in the table of any of the keyTags
		 * present in the JSONObject fields by the corresponding value */

		if( table.getNumberOfRows() > 0) {
			for (XWPFTableRow row : table.getRows()) {                                        // iterate over rows
				for (XWPFTableCell cell : row.getTableCells()) {                             // iterate over columns
					if (cell.getParagraphs() != null && cell.getParagraphs().size() > 0) {
						for (XWPFParagraph paragraph : cell.getParagraphs()) {                // get cell paragraphs
							replaceFieldsParagraph(paragraph, fields);                      // replacing existing keyTags in paragraph
						}
					}
				}
			}
		}
