package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MTX_LoginPage extends PageBase{
	
	By userNameLocator = By.id("j_username");
	By passwordLocator = By.id("j_password");
	By loginBtnLocator = By.id("idButtonLogin");
	By menuButton = By.id("idMenuButton");
	By logout = By.xpath("//*[@id=\"idSubNavBar\"]/a[2]");
	By idButtonOK = By.id("idButtonOK");
	
	
	
	WebDriverWait wait = null;
	
	
public MTX_LoginPage(WebDriver driver) {
	super(driver);
	wait = new WebDriverWait(driver,10);
}

public boolean Login(String username, String password) {
	  boolean conditionMet = false;

	  while (!conditionMet) {
			if(isDisplayed(userNameLocator)) {
				
				type(username,userNameLocator);
				type(password,passwordLocator);
				click(loginBtnLocator);
				
				conditionMet = true;
			}else {
				System.out.println("Login Page texbox was not present");

				click(logout);
				wait.until(ExpectedConditions.presenceOfElementLocated(idButtonOK));
				click(idButtonOK);
				wait.until(ExpectedConditions.presenceOfElementLocated(userNameLocator));
			}
	  }

	  try {
          wait.until(ExpectedConditions.presenceOfElementLocated(menuButton));
          return isDisplayed(menuButton);
          }catch(org.openqa.selenium.TimeoutException e) {
        	  return isDisplayed(menuButton);
        }
}


public boolean Logout() {
		if(isDisplayed(logout)) {
			wait.until(ExpectedConditions.presenceOfElementLocated(logout));
			click(logout);
			wait.until(ExpectedConditions.presenceOfElementLocated(idButtonOK));
			click(idButtonOK);
			
			wait.until(ExpectedConditions.presenceOfElementLocated(userNameLocator));
		}else {
			System.out.println("Logout xpath was not present");
		}

	return isDisplayed(userNameLocator);
}


}
