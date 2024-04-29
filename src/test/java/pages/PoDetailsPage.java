package pages;

import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PoDetailsPage extends PageBase {

	String OrderDetailNumberLocator = "//*[@id=\"idPurchaseOrderNumber\"][contains(text(),'P1058678')]";
	By tituloPoLocator = By.xpath("//*[@id=\"idMxTitle\"][contains(text(),'PO Details')]");
	By editPoLinesLocator = By.xpath("//*[@id=\"idButtonEditPOLines\"]");
	By unitPriceLocator = By.xpath("//*[@id=\"idUnitPrice_1\"]");
	By buttonOKLocator = By.id("idButtonOK");
	By buttonAOGAuthorizationOverrideLocator = By.id("idButtonAOGAuthorizationOverride");
	String PoNumberLocator = "//*[@id=\"idPONumber\"][contains(text(),'P1058678')]";
	By contenedorAuthLocator = By.id("idButtonOK_Auth");
	By usernameAuthLocator = By.id("idButtonOK_ROUsername");
	By passwordAuthLocator = By.id("idButtonOK_Password");
	By buttonOKAutLocator = By.xpath("/html/body/div[4]/div[3]/div/button[1]");
	
	By buttonUnauthorizePurchaseOrderLocator = By.id("idButtonUnauthorizePurchaseOrder");
	String SubTitlePoLocator= "//*[@id=\"idMxSubTitle\"][contains(text(),'P1058678')]";
	
	WebDriverWait wait = null;
	
	public PoDetailsPage(WebDriver driver) {
		super(driver);
		wait = new WebDriverWait(driver,10);
	}
	
	public boolean ValidarPoNumber (String barcode) {
		wait.until(ExpectedConditions.presenceOfElementLocated(tituloPoLocator));
		
		String barcodeSearchLocatorStringReemplazado = OrderDetailNumberLocator.replace("P1058678", barcode);
		By nuevoBarcodeSearchLocator = By.xpath(barcodeSearchLocatorStringReemplazado);
		return isDisplayed(nuevoBarcodeSearchLocator);
	}
	
	public void EditarPrecioPo(String barcode) {
		if(ValidarPoNumber(barcode)) {
			click(editPoLinesLocator);
			String barcodeSearchLocatorStringReemplazado = OrderDetailNumberLocator.replace("P1058678", barcode);
			By nuevoBarcodeSearchLocator = By.xpath(barcodeSearchLocatorStringReemplazado);
			
			wait.until(ExpectedConditions.presenceOfElementLocated(nuevoBarcodeSearchLocator));
			WebElement unitPriceElement = findElement(unitPriceLocator);
			unitPriceElement.clear();
			
	        Random rand = new Random();
	        int randomNumber = rand.nextInt(9000) + 1000;
	        String numberAsString = String.valueOf(randomNumber);
			type(numberAsString,unitPriceLocator);
			
			click(buttonOKLocator);
			wait.until(ExpectedConditions.presenceOfElementLocated(buttonAOGAuthorizationOverrideLocator));

		}else {
			System.out.println("PO Number was not present");
		}
	}
	
	public void AuthorizationOverride(String barcode, String username, String password) {
		wait.until(ExpectedConditions.presenceOfElementLocated(buttonAOGAuthorizationOverrideLocator));
		click(buttonAOGAuthorizationOverrideLocator);
		
		String subTitlePoReemplazado = SubTitlePoLocator.replace("P1058678", barcode);
		By nuevosubTitlePoLocator = By.xpath(subTitlePoReemplazado);
		wait.until(ExpectedConditions.presenceOfElementLocated(nuevosubTitlePoLocator));
		click(buttonOKLocator);
		
		wait.until(ExpectedConditions.presenceOfElementLocated(contenedorAuthLocator));
		type(username,usernameAuthLocator);
		type(password,passwordAuthLocator);
		wait.until(ExpectedConditions.presenceOfElementLocated(buttonOKAutLocator));
		click(buttonOKAutLocator);
		
		wait.until(ExpectedConditions.presenceOfElementLocated(buttonUnauthorizePurchaseOrderLocator));
	}
	
	public void UnauthorizeOrder(String barcode, String username, String password) {
		wait.until(ExpectedConditions.presenceOfElementLocated(buttonUnauthorizePurchaseOrderLocator));
		click(buttonUnauthorizePurchaseOrderLocator);
		
		String PoNumberReemplazado = SubTitlePoLocator.replace("P1058678", barcode);
		By nuevoPoNumberLocator = By.xpath(PoNumberReemplazado);
		wait.until(ExpectedConditions.presenceOfElementLocated(nuevoPoNumberLocator));
		click(buttonOKLocator);
		
		wait.until(ExpectedConditions.presenceOfElementLocated(contenedorAuthLocator));
		type(username,usernameAuthLocator);
		type(password,passwordAuthLocator);
		wait.until(ExpectedConditions.presenceOfElementLocated(buttonOKAutLocator));
		click(buttonOKAutLocator);
		
		wait.until(ExpectedConditions.presenceOfElementLocated(buttonAOGAuthorizationOverrideLocator));
	}
	
}
