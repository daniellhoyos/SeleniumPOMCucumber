package steps;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterSuite;

import java.io.ByteArrayInputStream;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import io.qameta.allure.Allure;

public class BaseTest {
	
	static WebDriver driver = null;
	private Properties properties;

  public BaseTest() throws FileNotFoundException, IOException {
   	  if (driver == null)
	  {
  		Properties properties = new Properties();
  		properties.load(new FileReader("src/test/resources/config.properties"));
   		  
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("browser.download.folderList", 2);
		profile.setPreference("browser.download.dir", properties.getProperty("firefox_download_path"));
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/pdf");
		profile.setPreference("pdfjs.disabled", true);
		
		FirefoxOptions options = new FirefoxOptions();
		options.setProfile(profile);

		System.setProperty("webdriver.gecko.driver",properties.getProperty("firefox_webriver_path"));
		driver = new FirefoxDriver(options);
		driver.get(properties.getProperty("url_base"));
	  }
  }
  
  public void screenshot(String text) {
      Allure.addAttachment(text, new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
  }
  
  @AfterSuite
  public void teardownSuite() {
      // Cierra el navegador una vez que se hayan ejecutado todas las pruebas en la suite
      if (driver != null) {
          driver.quit();
      }
  }

}
