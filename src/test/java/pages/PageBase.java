package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

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
	
	
}
