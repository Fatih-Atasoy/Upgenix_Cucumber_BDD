package net.upgenix.step_definitions;



import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import net.upgenix.pages.LoginPage;
import net.upgenix.utilities.ConfigurationReader;
import net.upgenix.utilities.Driver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

LoginPage loginPage = new LoginPage();
    @Before
    public void setUPAndGoLoginPage(){
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
loginPage.userName.sendKeys(ConfigurationReader.getProperty("validUsername"));
loginPage.password.sendKeys(ConfigurationReader.getProperty("validPassword"));
loginPage.LoginButton.click();
    }



    @After
    public void teardownScenario(Scenario scenario){


        if (scenario.isFailed()){

            byte [] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());

        }


        Driver.closeDriver();

      }


}