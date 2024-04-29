package steps;
import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import io.qameta.allure.Allure;
import pages.MTX_LoginPage;
import utils.*;


public class MTX_LoginStepDefinitions extends BaseTest {

    private int successfulLogins = 0;
    private int unsuccessfulLogins = 0;
    private ScenarioContext scenarioContext;
	
    public MTX_LoginStepDefinitions(ScenarioContext scenarioContext)throws FileNotFoundException, IOException {
        this.scenarioContext = scenarioContext;
    }
    
    public MTX_LoginStepDefinitions()throws FileNotFoundException, IOException {
        this.scenarioContext = new ScenarioContext();
    }

    @When("ingreso a MXT con {string} y {string} {string} veces")
    public void ingreso_a_mxt_con_y_veces(String username, String password, String n) throws InterruptedException {
    	MTX_LoginPage mtx_LoginPage = new MTX_LoginPage(driver);
    	
    	for (int i = 0; i < Integer.parseInt(n); i++) {
			boolean resultLogin = mtx_LoginPage.Login(username,password);
			Thread.sleep(10000);
			if(resultLogin==true) {
				boolean resultLogout = mtx_LoginPage.Logout();
				successfulLogins++;
			}else {
            	unsuccessfulLogins++;
            }
        }
        
        scenarioContext.setContext("successfulLogins", successfulLogins);
        scenarioContext.setContext("unsuccessfulLogins", unsuccessfulLogins);
        screenshot("screenshot");
    }
	   
    @Then("valido el numero de login que fueron exitosos")
    public void validoElNumeroDeLoginExitoso() {
    	
    	System.out.println("Número de Login exitosos: "+scenarioContext.getContext("successfulLogins"));
    	System.out.println("Número de Login NO exitosos: "+scenarioContext.getContext("unsuccessfulLogins"));
    	screenshot("screenshot");
    }
    
    @After
    public void tearDown(Scenario scenario) {
    	//tomar captura si el scenario falla
		byte [] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    	if(scenario.isFailed()) {
    		Allure.addAttachment("Failed Screenshot", new ByteArrayInputStream(screenshot));
    	}
    }
	
}
