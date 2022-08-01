package net.upgenix.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.upgenix.pages.*;
import net.upgenix.utilities.ConfigurationReader;
import net.upgenix.utilities.Driver;

public class Inventory_Functionality_StepDev {

    CheckAndEditPage checkAndEditPage = new CheckAndEditPage();
    DashboardPage dashboardPage = new DashboardPage();
    InventoryPage inventoryPage = new InventoryPage();
    ProductPage productPage = new ProductPage();
    CreateProductsPage createProductsPage = new CreateProductsPage();

    @Given("User logged as posmanager")
    public void userLoggedAsPosmanager() {

        Driver.getDriver().get(ConfigurationReader.getProperty("loginPageUrl"));

        checkAndEditPage.inputEmail.sendKeys(ConfigurationReader.getProperty("username"));

        checkAndEditPage.inputPassword.sendKeys(ConfigurationReader.getProperty("password"));

        checkAndEditPage.loginButton.click();

        dashboardPage.inventoryButton.click();
    }


    @When("Posmanager click the product button")
    public void posmanager_click_the_product_button() {
        inventoryPage.productButton.click();
    }
    @When("Posmanager click the create button")
    public void posmanager_click_the_create_button() {
        productPage.createButton.click();
    }
    @Then("Posmanager give the product name")
    public void posmanager_give_the_product_name() {
        createProductsPage.productNameField.sendKeys("Ipad Pro");
    }
    @Then("Posmanager should see the product created")
    public void posmanager_should_see_the_product_created() {
        createProductsPage.productCreatedMessage.isDisplayed();
    }







}
