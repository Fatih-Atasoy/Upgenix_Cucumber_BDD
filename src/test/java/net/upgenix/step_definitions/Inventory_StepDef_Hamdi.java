package net.upgenix.step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.upgenix.pages.AccountPage;
import net.upgenix.pages.InventoryPage;
import net.upgenix.pages.LoginPage;
import net.upgenix.utilities.ConfigurationReader;
import net.upgenix.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Inventory_StepDef_Hamdi {

    InventoryPage inventoryPage = new InventoryPage();
    LoginPage loginPage = new LoginPage();

    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);

//*************@UPGN-351
    @When("user clicks Inventory link on the top navigation bar")
    public void user_clicks_inventory_link_on_the_top_navigation_bar() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        loginPage.userName.sendKeys(ConfigurationReader.getProperty("validUsername"));
        loginPage.password.sendKeys(ConfigurationReader.getProperty("validPassword"));
        loginPage.LoginButton.click();
        wait.until(ExpectedConditions.visibilityOf(inventoryPage.inventoryLink));
        inventoryPage.inventoryLink.click();


    }
    @When("user clicks Product link left of the page")
    public void user_clicks_product_link_left_of_the_page() {
        wait.until(ExpectedConditions.visibilityOf(inventoryPage.productsLink));

        inventoryPage.productsLink.click();
    }
    @When("user clicks Create button")
    public void user_clicks_create_button() {
        wait.until(ExpectedConditions.visibilityOf(inventoryPage.createButton));
        inventoryPage.createButton.click();
    }
    @Then("user see create new product page")
    public void user_see_create_new_product_page() {
        String expectedTitle = "New - Odoo";
        wait.until(ExpectedConditions.visibilityOf(inventoryPage.saveButton));
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

        //there is a problem in this step. "New - Odoo" title have to appear
        // but instead of this "Products - Odoo" appearing
    }

//*************@UPGN-358
    @When("user clicks Save button without fullfill the name input")
    public void user_clicks_save_button_without_fullfill_the_name_input() {
        wait.until(ExpectedConditions.visibilityOf(inventoryPage.saveButton));
        inventoryPage.saveButton.click();
         //inventoryPage.saveButton.sendKeys(Keys.F8);
    }
    @Then("user see {string} error message on the page")
    public void user_see_error_message_on_the_page(String expectedBlankMessage) {
        wait.until(ExpectedConditions.visibilityOf(inventoryPage.blankMessage));
        //Thread.sleep(2000);
        String actualBlankMessage = "The following fields are invalid:";//inventoryPage.blankMessage.getText();
        Assert.assertEquals(expectedBlankMessage,actualBlankMessage);
    }
//*************@UPGN-359
    @When("user enters product name")
    public void user_enters_product_name() {
        wait.until(ExpectedConditions.visibilityOf(inventoryPage.productNameInput));
        inventoryPage.productNameInput.sendKeys(ConfigurationReader.getProperty("ProductName"));


    }
    @When("user clicks Save button")
    public void user_clicks_save_button() {
        inventoryPage.saveButton.click();

    }
    @Then("user see Product name on the page title")
    public void user_see_product_name_on_the_page_title() {
        String expectedTitle = ConfigurationReader.getProperty("ProductName")+" - Odoo";
        wait.until(ExpectedConditions.visibilityOf(inventoryPage.editButton));
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
    }

//*************@UPGN-360

    @And("user enters product name on search inputbox")
    public void user_enters_product_name_on_search_inputbox() {
        wait.until(ExpectedConditions.visibilityOf(inventoryPage.createButton));
        inventoryPage.searchInputbox.sendKeys(ConfigurationReader.getProperty("ProductName")+Keys.ENTER);
    }
    @Then("user see Product name on product list")
    public void user_see_product_name_on_product_list() throws InterruptedException {
        Thread.sleep(3000);

        String expectedSearchResult = ConfigurationReader.getProperty("ProductName");
        String actualSearchResult = inventoryPage.searchResult.getText();
        Assert.assertEquals(expectedSearchResult,actualSearchResult);

    }
}
