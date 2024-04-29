package steps;
import static org.testng.Assert.assertEquals;
import java.io.FileNotFoundException;
import java.io.IOException;
import io.cucumber.java.en.*;
import pages.MTX_LoginPage;
import pages.BarcodeSearchPage;
import pages.WorkPackageDetailsPage;
import utils.*;

public class Commit_Uncommit_Work_PackageStepDefinitions extends BaseTest {
    private WorkPackageDetailsPage workPackageDetailsPage;
	private MTX_LoginPage mtx_LoginPage;
	private BarcodeSearchPage barcodeSearchPage;
    
    public Commit_Uncommit_Work_PackageStepDefinitions(ScenarioContext scenarioContext)throws FileNotFoundException, IOException {
        this.workPackageDetailsPage = new WorkPackageDetailsPage(driver);
        this.mtx_LoginPage = new MTX_LoginPage(driver);
        this.barcodeSearchPage = new BarcodeSearchPage(driver);
    }
    public Commit_Uncommit_Work_PackageStepDefinitions()throws FileNotFoundException, IOException {
    	this.workPackageDetailsPage = new WorkPackageDetailsPage(driver);
        this.mtx_LoginPage = new MTX_LoginPage(driver);
        this.barcodeSearchPage = new BarcodeSearchPage(driver);
    }
    
    @Given("ingreso a MXT con username {string} y password {string}")
    public void ingreso_a_MXT_con_y(String username, String password) {
		boolean resultLogin = mtx_LoginPage.Login(username,password);
		assertEquals(resultLogin, true);
		screenshot("screenshot");
    }
    
    @When("busco un barcode {string} desde el buscador de barcode")
    public void busco_un_desde_el_buscador_de_barcode(String barcode) {
    	barcodeSearchPage.BarcodeSearch(barcode);
    	screenshot("screenshot");
    }
	
    @When("el barcode {string} de tipo WorkPackage se encuentra en MTX")
    public void el_se_encuentra_en_MTX(String barcode) {
    	boolean resultBarcodeSearch = workPackageDetailsPage.EncontrarWorkPackage(barcode);
    	assertEquals(resultBarcodeSearch, true);
    	screenshot("screenshot");
    }
    
    @Then("realizo commit sobre el WorkPackage {string} con username {string} y password {string}")
    public void realizo_commit_sobre_el(String workPackage, String username, String password) {
    	workPackageDetailsPage.Commit(workPackage, username, password);
    	screenshot("screenshot");
    }
    
    @Then("realizo uncommit sobre el WorkPackage {string} con username {string} y password {string}")
    public void realizo_uncommit_sobre_el(String workPackage, String username, String password) {
    	workPackageDetailsPage.Uncommit(workPackage, username, password);
    	screenshot("screenshot");
    }
   
}
