package net.upgenix.step_definitions;

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
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(),3);

    @When("User is on the upgenix login page")
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

    @When("User is on the dashboard")
    public void user_is_on_the_dashboard() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        employeePage.login();
    }

    @When("User clicks Employees stage")
    public void user_clicks_employees_stage() {
        employeePage.emplStage.click();
        wait.until(ExpectedConditions.titleIs(ConfigurationReader.getProperty("EmplTitle")));
        Assert.assertTrue(Driver.getDriver().getTitle().equals("Employees - Odoo"));
    }

    @When("User clicks Challenges stage")
    public void user_clicks_challenges_stage() {
        employeePage.badgesBtn.click();
        wait.until(ExpectedConditions.visibilityOf(employeePage.badgesBtn));
        employeePage.challengesBtn.click();
        wait.until(ExpectedConditions.visibilityOf(employeePage.challengesBtn));
        employeePage.goalsHistoryBtn.click();
        wait.until(ExpectedConditions.visibilityOf(employeePage.goalsHistoryBtn));
    }

    @When("User clicks Departments stage")
    public void user_clicks_departments_stage() throws InterruptedException {
        employeePage.departmentsBtn.click();
        Thread.sleep(7000);
    }
    @Then("User should see the last stage title")
    public void user_should_see_the_last_stage_title() {
        Assert.assertTrue(Driver.getDriver().getTitle().equals("Departments - Odoo"));
        //String act = Driver.getDriver().getTitle();
        //String exp = "Departments - Odoo";
        //Assert.assertEquals(exp,act);
    }

    @When("User is on the employees dashboard")
    public void user_is_on_the_employees_dashboard() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        employeePage.login();
        employeePage.emplStage.click();
    }
    @When("User creates new employees {string} in the Employees stage")
    public void user_creates_new_employees_in_the_employees_stage(String name) {
        employeePage.createBtn.click();
        wait.until(ExpectedConditions.titleIs("New - Odoo"));
        employeePage.employeesName.sendKeys(name);
    }

    @Then("User should see the {string} message under full profile")
    public void user_should_see_the_message_under_full_profile(String string) {

    }

}
