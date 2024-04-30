package pages;

import org.openqa.selenium.interactions.Actions;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;



public class PageBase {

	private WebDriver driver;
	
	public PageBase (WebDriver driver) {
		this.driver = driver;
	}
	
	public WebDriver chromeDriverConnection() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\danie\\eclipse-workspace\\TestAutomationSaucedemo\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		return driver;
	}
	
	public WebDriver firefoxDriverConnection() {
		System.setProperty("webdriver.gecko.driver","C:\\Users\\danie\\eclipse-workspace\\TestAutomationSaucedemo\\drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		return driver;
	}
	
	
	public WebElement findElement(By locator) {
		return driver.findElement(locator);
	}
	
	
	public List<WebElement> findElements(By locator) {
		return driver.findElements(locator);
	}
	
	//Contar cantidad de elementos
	public int TotalfindElements(By locator) {
		int TotalfindElements = 0;
		return TotalfindElements = driver.findElements(locator).size();
	}
	
	
	public String getText(WebElement element) {
		return element.getText();
	}
	
	public String getText(By locator) {
		return driver.findElement(locator).getText();
	}
	
	public void type (String inputText, By locator) {
		 driver.findElement(locator).sendKeys(inputText);
	}
	
	public void click (By locator) {
		driver.findElement(locator).click();
	}
	
	public void clickelementObscures (By locator) {
		WebElement element = findElement(locator);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
	}
	
	public void clickelementObscures (WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
	}
	
	public void clicklementWithScrolling (By locator) {
		WebElement element = findElement(locator);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		element.click();
	}
	
	public void clicklementWithScrolling (WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		element.click();
	}
	
	public void clear (By locator) {
		WebElement element = findElement(locator);
		element.clear(); 
	}
	
	public Boolean isDisplayed(By locator) {
		try {
			return driver.findElement(locator).isDisplayed();
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
	}
	
	public void visit (String url) {
		driver.get(url);
	}
	
	public void refresh() {
		driver.navigate().refresh();
	}
	
	public void moveToElement(By locator) {
		WebElement element = driver.findElement(locator);
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
		actions.moveToElement(element).perform();
	}
	
	
	public void switchTab (int indexTab) {
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(indexTab));
	}
	
	public void switchWindow (By windowLocator) throws FileNotFoundException, IOException, InterruptedException {
		Thread.sleep(4000);
		Properties properties = new Properties();
		properties.load(new FileReader("src/test/resources/config.properties"));
		String max_retry_count = properties.getProperty("max_retry_count");
		String retry_interval_ms = properties.getProperty("retry_interval_ms");
        boolean elementDisplayed = false;
        int retryCount = 0;
        
        // Store the current window handle
        String mainWindowHandle = driver.getWindowHandle();

        // Get all window handles
        Set<String> windowHandles = driver.getWindowHandles();
        System.out.println("Todos los Handles que hay son: "+windowHandles );

        // Switch to the new window
        while (retryCount < Integer.parseInt(max_retry_count) && !elementDisplayed) {
		    for (String handle : windowHandles) {
		        if (!handle.equals(mainWindowHandle)) {
		            driver.switchTo().window(handle);
		            System.out.println("Se cambia de ventana a:"+handle );
		            if (isDisplayed(windowLocator)) {
		            	elementDisplayed = true;
		            	break;
		            }
		        }
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
	}
	
	public String getTitle(){
		return driver.getTitle();
	}
	
	public void close() {
		try {
			driver.quit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
