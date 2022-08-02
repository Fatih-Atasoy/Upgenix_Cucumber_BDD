package net.upgenix.step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.upgenix.pages.*;

public class Inventory_Functionality_StepDev {

    InboxDashboardPage inboxDashboardPage = new InboxDashboardPage();
    InventoryPage inventoryPage = new InventoryPage();
    ProductPage productPage = new ProductPage();
    CreateProductsPage createProductsPage = new CreateProductsPage();


    @When("Posmanager click the inventory button")
    public void posmanagerClickTheInventoryButton() {
        inboxDashboardPage.inventoryButton.click();
    }

    @When("Posmanager click the product button")
    public void posmanagerClickTheProductButton() {

    }

    @And("Posmanager click the create button")
    public void posmanagerClickTheCreateButton() {
    }

    @Then("Posmanager give the product name")
    public void posmanagerGiveTheProductName() {
    }

    @Then("Posmanager click the save button")
    public void posmanagerClickTheSaveButton() {

    }

    @Then("Posmanager should see the product created")
    public void posmanagerShouldSeeTheProductCreated() {
    }



}
