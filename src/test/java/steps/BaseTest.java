package steps;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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
		System.setProperty("webdriver.gecko.driver",properties.getProperty("firefox_webriver_path"));
		driver = new FirefoxDriver();
		driver.get(properties.getProperty("url_base"));
	  }
  }
  
  public void screenshot(String text) {
      Allure.addAttachment(text, new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
  }

}
