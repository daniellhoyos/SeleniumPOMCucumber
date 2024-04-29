package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BarcodeSearchPage extends PageBase{

	By barcodeSearchLocator = By.id("idBarcodeSearchInput");
	WebDriverWait wait = null;
	
	public BarcodeSearchPage(WebDriver driver) {
		super(driver);
		wait = new WebDriverWait(driver,10);
	}
	
	public void BarcodeSearch(String barcode) {
		if(isDisplayed(barcodeSearchLocator)) {
			wait.until(ExpectedConditions.presenceOfElementLocated(barcodeSearchLocator));
			type(barcode,barcodeSearchLocator);
			WebElement barcodeSearchElement = findElement(barcodeSearchLocator);
			barcodeSearchElement.sendKeys(Keys.ENTER);
		}else {
			System.out.println("barcodeSearchLocator was not present");
		}
	}
	
}
