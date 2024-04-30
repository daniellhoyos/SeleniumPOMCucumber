package steps;

import static org.testng.Assert.assertTrue;
import java.io.FileNotFoundException;
import java.io.IOException;
import io.cucumber.java.en.*;
import pages.MainPage;
import pages.RegisterPage;
import pages.ProductPage;
import utils.*;

public class Registro_Y_Compra_En_Advantage_Online_ShoppingStepDefinitions extends BaseTest{

    private MainPage mainPage;
    private RegisterPage registerPage;
    private ScenarioContext scenarioContext;
    private ProductPage productPage;
    
    public Registro_Y_Compra_En_Advantage_Online_ShoppingStepDefinitions(ScenarioContext scenarioContext)throws FileNotFoundException, IOException {
        this.mainPage = new MainPage(driver);
        this.registerPage = new RegisterPage(driver);
        this.productPage = new ProductPage(driver);
        this.scenarioContext = scenarioContext;
    }
    public Registro_Y_Compra_En_Advantage_Online_ShoppingStepDefinitions()throws FileNotFoundException, IOException {
    	this.mainPage = new MainPage(driver);
    	this.registerPage = new RegisterPage(driver);
    	this.productPage = new ProductPage(driver);
    	this.scenarioContext = new ScenarioContext();
    }
    
    @Given("que el usuario esta en la pagina de inicio")
    public void que_el_usuario_esta_en_la_pagina_de_inicio() {
    	boolean validateMainPageResult = mainPage.validateMainPage();
    	assertTrue(validateMainPageResult);
    	screenshot("screenshot");
    }

    @When("el usuario navega a la pagina de registro")
    public void el_usuario_navega_a_la_pagina_de_registro() {
    	boolean enterTocreateNewAccountPageResult = mainPage.enterTocreateNewAccountPage();
    	assertTrue(enterTocreateNewAccountPageResult);
 
    	screenshot("screenshot");
    }
    
    @And("el usuario introduce la informacion de registro requerida")
    public void el_usuario_introduce_la_información_de_registrorequerida() {
    	String createNewAccountName = registerPage.createNewAccount();
    	assertTrue(createNewAccountName.contains("testUser"));
    	scenarioContext.setContext("accountName", createNewAccountName);
    	screenshot("screenshot");
    }

    @Then("el usuario se crea exitosamente")
    public void el_usuario_se_crea_exitosamente() {
    	String accountName = (String)scenarioContext.getContext("accountName");
    	boolean evalidateCreatedAccountResult = mainPage.validateCreatedAccount(accountName);
    	assertTrue(evalidateCreatedAccountResult);
    	screenshot("screenshot");
    }
    
    @Given("que el usuario ha sido registrado exitosamente")
    public void que_el_usuario_ha_sido_registrado_exitosamente() {
    	String accountName = (String)scenarioContext.getContext("accountName");
    	boolean validateCreatedAccountResult = mainPage.validateCreatedAccount(accountName);
    	assertTrue(validateCreatedAccountResult);
    	screenshot("screenshot");
    	mainPage.signOut();
    }
    
    @When("el usuario navega a la pagina de inicio de sesion")
    public void el_usuario_navega_a_la_pagina_de_inicio_de_sesion() {
    	boolean enterToLoginPageResult = mainPage.enterToLoginPage();
    	assertTrue(enterToLoginPageResult);
 
    	screenshot("screenshot");
    }
    
    @And("el usuario inicia sesion con las credenciales registradas")
    public void el_usuario_inicia_sesion_con_las_credenciales_registradas() {
    	String accountName = (String)scenarioContext.getContext("accountName");
    	boolean logInResult = mainPage.logIn(accountName);
    	assertTrue(logInResult);
    	screenshot("screenshot");
    }
    
    @Then("el usuario debe ser llevado al perfil de su cuenta")
    public void el_usuario_debe_ser_llevado_al_perfil_de_su_cuenta() {
    	String accountName = (String)scenarioContext.getContext("accountName");
    	boolean evalidateCreatedAccountResult = mainPage.validateCreatedAccount(accountName);
    	assertTrue(evalidateCreatedAccountResult);
    	screenshot("screenshot");
    }
    
    @Given("que el usuario ha iniciado sesion exitosamente")
    public void que_el_usuario_ha_iniciado_sesion_exitosamente() {
    	el_usuario_debe_ser_llevado_al_perfil_de_su_cuenta();
    	screenshot("screenshot");
    }
    
    @When("el usuario selecciona un elemento {string}")
    public void el_usuario_selecciona_un_elemento(String elemento) {
    	boolean selectElementResult = mainPage.selectElement(elemento);
    	assertTrue(selectElementResult);
    	screenshot("screenshot");
    }
    
    @And("el usuario agrega el primer articulo al carrito de compras")
    public void el_usuario_agrega_el_primer_articulo_al_carrito_de_compras() {
    	boolean addToCartFirstItemResult = productPage.addToCartFirstItem();
    	assertTrue(addToCartFirstItemResult);
    	screenshot("screenshot");
    }
    
    @Then("el carrito de compras debe mostrar el elemento agregado")
    public void el_carrito_de_compras_debe_mostrar_el_elemento_agregado() {
    	boolean validateItemOnCartResult = productPage.validateItemOnCart();
    	assertTrue(validateItemOnCartResult);
    	screenshot("screenshot");
    }
    
    
}
