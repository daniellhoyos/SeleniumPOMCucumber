package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends PageBase{

	WebDriverWait wait = null;
	
	By menuUserLocator = By.cssSelector("#menuUser");
	By createNewAccountLocator = By.xpath("//*[@class=\"create-new-account ng-scope\"]");
	By registerPageLocator = By.cssSelector("#registerPage");
	By signOutLocator = By.xpath("//*[@class=\"option roboto-medium ng-scope\"][contains(text(),\"Sign out\")]");
	String userLoggedInLocator = "//*[@class=\"hi-user containMiniTitle ng-binding\"][contains(text(),\"uname\")]";
	By userNameLocator = By.xpath("//input[@name=\"username\"]");
	By passwordLocator = By.xpath("//input[@name=\"password\"]");
	By signInBtnLocator = By.cssSelector("#sign_in_btn");
	String itemSelector = "//div[@class=\"shop_now_slider\"]/span[contains(text(),\"item\")]";
	By categoryLocator = By.xpath("//div[@class=\"cell categoryRight\"]");


	public MainPage(WebDriver driver) {
		super(driver);
		wait = new WebDriverWait(driver,20);
	}
	
	public boolean validateMainPage() {
		wait.until(ExpectedConditions.presenceOfElementLocated(menuUserLocator));
		if(isDisplayed(menuUserLocator)) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean enterTocreateNewAccountPage() {
		
		wait.until(ExpectedConditions.presenceOfElementLocated(menuUserLocator));
		click(menuUserLocator);
		wait.until(ExpectedConditions.presenceOfElementLocated(createNewAccountLocator));
		clickelementObscures(createNewAccountLocator);
		wait.until(ExpectedConditions.presenceOfElementLocated(registerPageLocator));
		return isDisplayed(registerPageLocator);
	}
	
	public boolean validateCreatedAccount(String userName) {
		String userLoggedInLocatorReplaced = userLoggedInLocator.replace("uname", userName);
		By newUserLoggedInLocator = By.xpath(userLoggedInLocatorReplaced);
		wait.until(ExpectedConditions.presenceOfElementLocated(newUserLoggedInLocator));
		if(isDisplayed(newUserLoggedInLocator)) {
			return true;
		}else {
			return false;
		}
	}
	
	public void signOut() {
		wait.until(ExpectedConditions.presenceOfElementLocated(menuUserLocator));
		click(menuUserLocator);
		wait.until(ExpectedConditions.presenceOfElementLocated(signOutLocator));
		click(signOutLocator);
	}
	
	public boolean enterToLoginPage() {
		wait.until(ExpectedConditions.elementToBeClickable(menuUserLocator));
		moveToElement(menuUserLocator);
		click(menuUserLocator);
		wait.until(ExpectedConditions.elementToBeClickable(userNameLocator));
		return isDisplayed(userNameLocator);
	}
	
	public boolean logIn(String userName) {
		wait.until(ExpectedConditions.elementToBeClickable(userNameLocator));
		type(userName,userNameLocator);
		String userNameReplaced = userName.replace("testUser", "Password");
		type(userNameReplaced,passwordLocator);
		clickelementObscures(signInBtnLocator);
		return validateCreatedAccount(userName);
	}
	
	public boolean selectElement(String elementName) {
		
		String elementNameReplaced = itemSelector.replace("item", elementName);
		By elementNameReplacedLocator = By.xpath(elementNameReplaced);
		wait.until(ExpectedConditions.elementToBeClickable(elementNameReplacedLocator));
		System.out.println("locator:"+elementNameReplacedLocator);
		click(elementNameReplacedLocator);
		wait.until(ExpectedConditions.elementToBeClickable(categoryLocator));
		return isDisplayed(categoryLocator);
	}
	
	
}
