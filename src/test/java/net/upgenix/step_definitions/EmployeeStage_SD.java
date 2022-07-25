package net.upgenix.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.upgenix.pages.EmployeePage;
import net.upgenix.utilities.ConfigurationReader;
import net.upgenix.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EmployeeStage_SD {

    EmployeePage employeePage = new EmployeePage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);

    @Given("User is on the upgenix login page")
    public void user_is_on_the_upgenix_login_page() {
        String url = ConfigurationReader.getProperty("url");
        Driver.getDriver().get(url);
    }
    @When("User enters {string} username")
    public void user_enters_username(String username) {
        employeePage.inputLogin.sendKeys(username);
    }

    @When("User enters {string} password")
    public void user_enters_password(String password) {
        employeePage.inputPass.sendKeys(password);
    }

    @When("User clicks the login button")
    public void user_clicks_the_login_button() {
        employeePage.loginButton.click();
    }

    @Then("User should see the dashboard")
    public void user_should_see_the_dashboard() {
        Assert.assertTrue(Driver.getDriver().getTitle().equals("Odoo"));
    }

    @When("User clicks Employees stage")
    public void user_clicks_employees_stage() {
        wait.until(ExpectedConditions.titleIs(ConfigurationReader.getProperty("EmplTitle")));
        Assert.assertTrue(employeePage.titleEmpl.getText().equals("Employees - Odoo"));
    }

    @When("User clicks Challenges stage")
    public void user_clicks_challenges_stage() {
    }
    @When("User clicks Departments stage")
    public void user_clicks_departments_stage() {
    }
    @Then("User should see the title")
    public void user_should_see_the_title() {
    }
}
