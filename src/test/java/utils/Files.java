package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Files {
	
	public void deleteFile(String fileName) throws FileNotFoundException, IOException {
		Properties properties = new Properties();
		properties.load(new FileReader("src/test/resources/config.properties"));
		File file = new File(properties.getProperty("firefox_download_path")+"\\"+fileName);

		// Check if the file exists
		if (file.exists()) {
		    // Delete the file
		    boolean isDeleted = file.delete();

		    if (isDeleted) {
		        System.out.println("File was deleted successfully.");
		    } else {
		        System.out.println("Failed to delete the file.");
		    }
		} else {
		    System.out.println("File does not exist.");
		}
	}
	
	public boolean fileExists(String fileName) throws FileNotFoundException, IOException {
		Properties properties = new Properties();
		properties.load(new FileReader("src/test/resources/config.properties"));
		File file = new File(properties.getProperty("firefox_download_path")+"\\"+fileName);
		boolean fileExist;
		// Check if the file exists
		if (file.exists()) {
		    fileExist = true;
		} else {
			fileExist = false;
		}
		return fileExist;
	}
	
	public boolean waitPdfDownload (String pdfName) throws FileNotFoundException, IOException, InterruptedException {

		Properties properties = new Properties();
		properties.load(new FileReader("src/test/resources/config.properties"));
		
		Files files = new Files();
		files.deleteFile(pdfName);
		
		String retry_interval_ms = properties.getProperty("retry_interval_ms");
		String max_retry_count = properties.getProperty("max_retry_count");
        boolean elementDisplayed = false;
        int retryCount = 0;

    	File file = new File(properties.getProperty("firefox_download_path")+"\\"+pdfName);
    	
        while (retryCount < Integer.parseInt(max_retry_count) && !file.exists()) {
	        try {
	            Thread.sleep(Integer.parseInt(retry_interval_ms)); // Wait for the specified interval before retrying
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
		    System.out.println("Esperando descarga de archivo...");
		    retryCount++;
        }
        if(file.exists()) {
        	System.out.println("Archivo Descargado");
        	elementDisplayed = true;
        }else {
        	System.out.println("Archivo no Descargado");
        	elementDisplayed = false;
        }
        return elementDisplayed;
    }
}
