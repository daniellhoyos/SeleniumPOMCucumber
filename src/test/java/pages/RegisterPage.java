package pages;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class RegisterPage extends PageBase{

	WebDriverWait wait = null;
	
	By usernameRegisterLocator = By.xpath("//*[@name=\"usernameRegisterPage\"]");
	By emailRegisterLocator = By.xpath("//*[@name=\"emailRegisterPage\"]");
	By passwordRegisterLocator = By.xpath("//*[@name=\"passwordRegisterPage\"]");
	By confirmPasswordRegisterPageLocator = By.xpath("//*[@name=\"confirm_passwordRegisterPage\"]");
	By firstNameRegisterPageLocator = By.xpath("//*[@name=\"first_nameRegisterPage\"]");
	By lastNameRegisterPageLocator = By.xpath("//*[@name=\"last_nameRegisterPage\"]");
	By iAgreeLocator = By.xpath("//*[@name=\"i_agree\"]");
	By registerButtonLocator = By.cssSelector("#register_btn");
	
	
	public RegisterPage(WebDriver driver) {
		super(driver);
		wait = new WebDriverWait(driver,20);
	}
	
	
	public String createNewAccount() {
		
        Random rand = new Random();
        int randomNumber = rand.nextInt(10000);
		
		wait.until(ExpectedConditions.elementToBeClickable(usernameRegisterLocator));
		type("testUser"+randomNumber,usernameRegisterLocator);
		type("testUser"+randomNumber+"@correo.com",emailRegisterLocator);

		type("Password"+randomNumber,passwordRegisterLocator);
		type("Password"+randomNumber,confirmPasswordRegisterPageLocator);
		
		type("Name"+randomNumber,firstNameRegisterPageLocator);
		type("Last Name"+randomNumber,lastNameRegisterPageLocator);
		clickelementObscures(iAgreeLocator);
		click(registerButtonLocator);
		
		return "testUser"+randomNumber;
	}
	

	
}
