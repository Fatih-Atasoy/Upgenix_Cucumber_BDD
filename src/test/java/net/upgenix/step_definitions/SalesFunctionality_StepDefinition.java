package net.upgenix.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.upgenix.pages.AccountPage;
import net.upgenix.pages.LoginPage;
import net.upgenix.pages.SalesPage;
import net.upgenix.utilities.ConfigurationReader;
import net.upgenix.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class SalesFunctionality_StepDefinition {

    private String customerName;
    AccountPage accountPage = new AccountPage();
    SalesPage salesPage = new SalesPage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 20);

    @When("user should click Sales module which is top of the navigation bar")
    public void user_should_click_sales_module_which_is_top_of_the_navigation_bar() {
        Driver.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.visibilityOf(accountPage.salesLink));
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        accountPage.salesLink.click();
    }
    @When("user should click Customers submodule left on the page")
    public void user_should_click_customers_submodule_left_on_the_page() {
        salesPage.customersLink.click();
    }
    @When("user should click Create button on the Customers page")
    public void user_should_click_create_button_on_the_customers_page() {
        wait.until(ExpectedConditions.visibilityOfAllElements(salesPage.allCustomers));
        salesPage.createButton.click();
    }
    @Then("user should see the form sheet on the page and title should be {string}")
    public void user_should_see_the_form_sheet_on_the_page_and_title_should_be_new_odoo(String title) {
        Assert.assertTrue(salesPage.formSheet.isDisplayed());
        Assert.assertEquals(title,Driver.getDriver().getTitle());
    }

    @When("user should click Save button without fullfill the name input")
    public void user_should_click_save_button_without_fullfill_the_name_input() {
        salesPage.saveButton.click();
    }
    @Then("{string} error text should be appeared on the page")
    public void the_following_fields_are_invalid_error_text_should_be_appeared_on_the_page(String notificationText) {
        Assert.assertEquals(notificationText,salesPage.notificationText.getText());
    }

    @When("user should input the name {string}")
    public void user_should_input_the_name(String customerName) {
        this.customerName = customerName;
        wait.until(ExpectedConditions.visibilityOf(salesPage.nameInputBox));
        salesPage.nameInputBox.sendKeys(customerName);
    }
    @When("user should fulfill the other requirements")
    public void user_should_fulfill_the_other_requirements() {
        salesPage.jobPositionInputBox.sendKeys("CEO");
        salesPage.phoneInputBox.sendKeys("565632564");
        salesPage.mobileInputBox.sendKeys("05487985424");
        salesPage.emailInputBox.sendKeys("moneyBank@gmail.com");
        salesPage.titleInputBox.sendKeys("CEO secretary");
        Select select = new Select(salesPage.languageDropdownButton);
        select.selectByVisibleText("English");
    }
    @Then("after clicking Save button, page includes the customer name.")
    public void after_clicking_save_button_page_includes_the_customer_name() {
        salesPage.saveButton.click();
        wait.until(ExpectedConditions.titleContains(customerName));
        Assert.assertEquals(customerName+" - Odoo",Driver.getDriver().getTitle());
    }


    @Then("new customer should be display after user search the customer")
    public void new_customer_should_be_display_after_user_search_the_customer() {
        salesPage.customersLink.click();
        wait.until(ExpectedConditions.visibilityOfAllElements(salesPage.allCustomers));
        salesPage.searchInputBox.sendKeys(customerName + Keys.ENTER);
        Assert.assertEquals(customerName,salesPage.createdCustomerName.getText());
    }


}
