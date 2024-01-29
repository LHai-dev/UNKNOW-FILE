package co.cstad.test.springboot;

import org.apache.poi.xwpf.usermodel.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class TestSpringBootApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(TestSpringBootApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {

	}
}
