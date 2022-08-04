package net.upgenix.step_definitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.bytebuddy.asm.Advice;
import net.upgenix.pages.*;
import net.upgenix.utilities.BrowserUtils;
import net.upgenix.utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Inventory_Functionality_StepDev {

    InboxDashboardPage inboxDashboardPage = new InboxDashboardPage();
    InventoryPage inventoryPage = new InventoryPage();
    ProductPage productPage = new ProductPage();
    CreateProductsPage createProductsPage = new CreateProductsPage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
    Faker faker = new Faker();



    @When("Posmanager click the inventory button")
    public void posmanagerClickTheInventoryButton() {
        inboxDashboardPage.inventoryButton.click();
        BrowserUtils.sleep(2);
    }

    @When("Posmanager click the product button")
    public void posmanagerClickTheProductButton() {
        inventoryPage.productButton.click();
    }

    @And("Posmanager click the create button")
    public void posmanagerClickTheCreateButton() {
        productPage.createButton.click();
    }

    @Then("Posmanager give the product name")
    public void posmanagerGiveTheProductName() {

        createProductsPage.productNameField.sendKeys("Iphone 14");
    }

    @Then("Posmanager click the save button")
    public void posmanagerClickTheSaveButton() {
        createProductsPage.saveButton.click();
    }

    @Then("Posmanager should see the product created")
    public void posmanagerShouldSeeTheProductCreated() {
        createProductsPage.productCreatedMessage.isDisplayed();
    }


    @When("Posmanager select the product type")
    public void posmanagerSelectTheProductType() {
        createProductsPage.productTypeSelect1.click();

    }


    @When("Posmanager set the sales price")
    public void posmanagerSetTheSalesPrice() {
        createProductsPage.salesPriceField.sendKeys("2399");
    }

    @Then("Posmanager set the cost price")
    public void posmanagerSetTheCostPrice() {
       createProductsPage.costPriceField.sendKeys("1599");
    }


    @Then("Posmanager can give a barcode number to product")
    public void posmanagerCanGiveABarcodeNumberToProduct() {
        createProductsPage.barcodeField.sendKeys(faker.numerify("###-###-####"));
    }


    @Then("Posmanager select the category")
    public void posmanagerSelectTheCategory() {
        createProductsPage.categorySelect1.click();
        createProductsPage.categorySelect2.click();
    }

    @Then("Posmanager give the internal reference code")
    public void posmanagerGiveTheInternalReferenceCode() {
        createProductsPage.internalReferenceField.sendKeys("CMD-Master");
    }



    @Then("Posmanager search the product that created")
    public void posmanagerSearchTheProductThatCreated() {
        wait.until(ExpectedConditions.visibilityOf(productPage.searchButton));
        productPage.searchButton.sendKeys("Iphone 14" + Keys.ENTER);
        BrowserUtils.sleep(2);
    }
}
