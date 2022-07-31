package net.upgenix.step_definitions;

import io.cucumber.java.en.Given;
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





}
