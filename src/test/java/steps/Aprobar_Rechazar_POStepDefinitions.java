package steps;

import static org.testng.Assert.assertEquals;
import java.io.FileNotFoundException;
import java.io.IOException;
import io.cucumber.java.en.*;
import pages.PoDetailsPage;
import utils.*;

public class Aprobar_Rechazar_POStepDefinitions extends BaseTest{

    private PoDetailsPage poDetailsPage;
    
    public Aprobar_Rechazar_POStepDefinitions(ScenarioContext scenarioContext)throws FileNotFoundException, IOException {
        this.poDetailsPage = new PoDetailsPage(driver);
    }
    public Aprobar_Rechazar_POStepDefinitions()throws FileNotFoundException, IOException {
    	this.poDetailsPage = new PoDetailsPage(driver);
    }

    @When("el barcode {string} de tipo PO se encuentra en MTX")
    public void el_se_encuentra_en_MTX(String barcode) {
    	boolean resultBarcodeSearch = poDetailsPage.ValidarPoNumber(barcode);
    	assertEquals(resultBarcodeSearch, true);
    	screenshot("screenshot");
    }
    
    @And("edito el precio de la unidad del PO {string}")
    public void editoElPrecioDeLaUnidadDelPOConUsernameYPassword(String barcode) {
    	poDetailsPage.EditarPrecioPo(barcode);
    	screenshot("screenshot");
    }

    @Then("realizo authorization override sobre el PO {string} con username {string} y password {string}")
    public void realizoAuthorizationOverrideSobreElPO(String barcode, String username, String password) {
    	poDetailsPage.AuthorizationOverride(barcode, username, password);
    	screenshot("screenshot");
    }

    @And("realizo unauthorize order sobre el PO {string} con username {string} y password {string}")
    public void realizoUnauthorizeOrderSobreElPO(String barcode, String username, String password) {
    	poDetailsPage.UnauthorizeOrder(barcode, username, password);
    	screenshot("screenshot");
    }
}
