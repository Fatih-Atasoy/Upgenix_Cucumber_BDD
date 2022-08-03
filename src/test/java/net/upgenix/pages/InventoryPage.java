package net.upgenix.pages;

import net.upgenix.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryPage {

    public InventoryPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(partialLinkText = "Inventory")
    public WebElement inventoryLink;

    @FindBy(partialLinkText = "Products")
    public WebElement productsLink;

    @FindBy(xpath = "//button[@accesskey='c']")
    public WebElement createButton;

    @FindBy(xpath = "//button[@class='btn btn-primary btn-sm o_form_button_save']")
    public WebElement saveButton;

    @FindBy(xpath = "//span[@class='o_icon fa fa-3x fa-exclamation']")
    public WebElement blankMessage;

    @FindBy(xpath = "//input[@class='o_field_char o_field_widget o_input o_required_modifier']")
    public WebElement productNameInput;

    @FindBy(xpath = "//button[@class='btn btn-primary btn-sm o_form_button_edit']")
    public WebElement editButton;

    @FindBy(xpath = "//input[@class='o_searchview_input']")
    public WebElement searchInputbox;

    @FindBy(xpath = "//div[@class='oe_kanban_details']/strong/span")
    public WebElement searchResult;

    @FindBy(xpath = "(//span[@class='o_searchview_facet_label'])/../div/span")
    public WebElement searchNumber;

}
