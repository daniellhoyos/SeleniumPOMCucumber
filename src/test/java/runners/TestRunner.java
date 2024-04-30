package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import utils.ScenariosToBeRun;
import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "C:/Documentos/advantageonlineshopping/src/test/java/features",
        glue = {"steps"},
        plugin = {"pretty",
                "html:target/cucumber",
                "io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm",
                "json:target/cucumber.json"})
public class TestRunner extends AbstractTestNGCucumberTests{
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        ScenariosToBeRun.totalOfScenarios = super.scenarios().length;
        return super.scenarios();
    }
}