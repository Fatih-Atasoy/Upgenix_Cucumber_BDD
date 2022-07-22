package net.upgenix.step_definitions;

import io.cucumber.java.en.When;
import net.upgenix.pages.AccountPage;
import net.upgenix.pages.LoginPage;
import net.upgenix.utilities.ConfigurationReader;
import net.upgenix.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Login_StepDefinition {
    LoginPage loginPage =new LoginPage();
    AccountPage accountPage =new AccountPage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(),3);

    @When("User login for testing other functionality")
    public void user_login_for_testing_other_functionality() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        loginPage.userName.sendKeys(ConfigurationReader.getProperty("validUsername"));
        loginPage.password.sendKeys(ConfigurationReader.getProperty("validPassword"));
        loginPage.LoginButton.click();
        wait.until(ExpectedConditions.visibilityOf(accountPage.accountName));
        Assert.assertTrue((accountPage.accountName.getText()).toLowerCase().
                contains(ConfigurationReader.getProperty("validUsername").
                        substring(0, ConfigurationReader.getProperty("validUsername").indexOf("@"))));


    }
}
