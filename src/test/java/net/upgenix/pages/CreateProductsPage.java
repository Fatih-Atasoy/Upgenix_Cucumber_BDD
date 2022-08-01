package net.upgenix.pages;

import net.upgenix.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateProductsPage {

    public CreateProductsPage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "o_field_input_1406")
    public WebElement productNameField;

    @FindBy(xpath = "//div[@class='o_thread_message_content']")
    public WebElement productCreatedMessage;

    @FindBy(xpath = "//select[@class='o_input o_field_widget o_required_modifier']")
    public WebElement productSelectField;



}


