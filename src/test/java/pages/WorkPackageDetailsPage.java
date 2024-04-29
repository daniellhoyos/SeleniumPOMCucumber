package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class WorkPackageDetailsPage extends PageBase{
	
	String barcodeSearchLocator = "//*[@id=\"idTableWorkscope\"]/tbody/tr/td/a[contains(text(),'T00QECR5')]";
	By tituloLocator = By.xpath("//*[@id=\"idMxTitle\"][contains(text(),'Work Package Details')]");
	//Commit and Un-commit
	By commitLocator = By.id("idButtonCommitScope");
	By submitReasonLocator = By.id("idTableSubmitReasonAndNotes");
	By buttonOKLocator = By.id("idButtonOK");
	By contenedorAuthLocator = By.id("idButtonOK_Auth");
	By usernameAuthLocator = By.id("idButtonOK_ROUsername");
	By passwordAuthLocator = By.id("idButtonOK_Password");
	By buttonOKAutLocator = By.xpath("/html/body/div[4]/div[3]/div/button[1]");
	By uncommitLocator = By.id("idButtonUncommitScope");
	
	WebDriverWait wait = null;
	
	public WorkPackageDetailsPage(WebDriver driver) {
		super(driver);
		wait = new WebDriverWait(driver,10);
	}

	public boolean EncontrarWorkPackage (String WorkPackage) {
		wait.until(ExpectedConditions.presenceOfElementLocated(tituloLocator));
		
		// Extraer la parte no numérica del workPackage
		String prefix = WorkPackage.substring(WorkPackage.length()-1,WorkPackage.length());
		int numero = Integer.parseInt(prefix);
		// Incrementar el número en 1
		int numeroActualizado = numero +1;
		String cadena = String.valueOf(numeroActualizado);
		
		String cadenaReemplazada = WorkPackage.replace(prefix, cadena);
		
		String barcodeSearchLocatorStringReemplazado = barcodeSearchLocator.replace("T00QECR5", cadenaReemplazada);
		By nuevoBarcodeSearchLocator = By.xpath(barcodeSearchLocatorStringReemplazado);
		return isDisplayed(nuevoBarcodeSearchLocator);
	}
	
	public void Commit(String WorkPackage, String username, String password) {
		if(EncontrarWorkPackage(WorkPackage)) {
			click(commitLocator);
			wait.until(ExpectedConditions.presenceOfElementLocated(submitReasonLocator));
			click(buttonOKLocator);
			wait.until(ExpectedConditions.presenceOfElementLocated(contenedorAuthLocator));
			type(username,usernameAuthLocator);
			type(password,passwordAuthLocator);
			wait.until(ExpectedConditions.presenceOfElementLocated(buttonOKAutLocator));
			click(buttonOKAutLocator);
		}else {
			System.out.println("WorkPackage was not present");
		}
	}
	
	public void Uncommit(String WorkPackage, String username, String password) {
		if(EncontrarWorkPackage(WorkPackage)) {
			click(uncommitLocator);
			wait.until(ExpectedConditions.presenceOfElementLocated(submitReasonLocator));
			click(buttonOKLocator);
			wait.until(ExpectedConditions.presenceOfElementLocated(contenedorAuthLocator));
			type(username,usernameAuthLocator);
			type(password,passwordAuthLocator);
			wait.until(ExpectedConditions.presenceOfElementLocated(buttonOKAutLocator));
			click(buttonOKAutLocator);
		}else {
			System.out.println("WorkPackage was not present");
		}
	}
}
