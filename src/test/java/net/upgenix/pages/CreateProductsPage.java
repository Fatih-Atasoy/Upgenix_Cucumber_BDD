package net.upgenix.pages;

import net.upgenix.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateProductsPage {

    public CreateProductsPage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//input[@class='o_field_char o_field_widget o_input o_required_modifier']")
    public WebElement productNameField;

    @FindBy(xpath = "//button[@class='btn btn-primary btn-sm o_form_button_save']")
    public WebElement saveButton;

    @FindBy(xpath = "//strong[@class='o_thread_author ']")
    public WebElement productCreatedMessage;

    @FindBy(xpath = "//select[@class='o_input o_field_widget o_required_modifier']")
    public WebElement productSelectField;


    @FindBy(xpath = "(//input[@type='text'])[7]") // by name ?
    public WebElement barcodeField;

    @FindBy(xpath = "(//input[@class='o_input'])[1]") // by id ?
    public WebElement salesPriceField;

    @FindBy(xpath = "(//input[@class='o_input'])[2]") // by id ?
    public WebElement costPriceField;

    @FindBy(xpath = "//img[@class='img img-responsive']") // by name ?
    public WebElement photoEditField;




}


