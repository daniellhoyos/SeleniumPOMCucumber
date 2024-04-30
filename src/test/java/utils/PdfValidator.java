package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class PdfValidator {
	
	public String pdfToText(String fileName) throws FileNotFoundException, IOException{
		Properties properties = new Properties();
		properties.load(new FileReader("src/test/resources/config.properties"));
		
		PDDocument document = PDDocument.load(new File(properties.getProperty("firefox_download_path")+"\\"+fileName));
		PDFTextStripper pdfStripper = new PDFTextStripper();
		String text = pdfStripper.getText(document);
		document.close();
		
		return text;
	}
}
