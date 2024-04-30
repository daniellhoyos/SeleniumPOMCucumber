package utils;

import java.util.Properties;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.PageBase;

public class Retries extends PageBase {
	WebDriverWait wait = null;
	public Retries(WebDriver driver) {
		super(driver);
		wait = new WebDriverWait(driver,20);
	}

	public boolean retryByLocator(By locator) throws FileNotFoundException, IOException {
		
		Properties properties = new Properties();
		properties.load(new FileReader("src/test/resources/config.properties"));
		String max_retry_count = properties.getProperty("max_retry_count");
		String retry_interval_ms = properties.getProperty("retry_interval_ms");
        boolean elementDisplayed = false;
        int retryCount = 0;
		
        while (retryCount < Integer.parseInt(max_retry_count) && !elementDisplayed) {
            System.out.println("retry: "+retryCount );
            if (isDisplayed(locator)) {
            	elementDisplayed = true;
            	System.out.println("Found item: "+locator );
            	break;
            }
		    if (!elementDisplayed) {
		        try {
		            Thread.sleep(Integer.parseInt(retry_interval_ms)); // Wait for the specified interval before retrying
		        } catch (InterruptedException e) {
		            e.printStackTrace();
		        }
		        retryCount++;
		    }
        }
        
        return elementDisplayed;
	}
}
