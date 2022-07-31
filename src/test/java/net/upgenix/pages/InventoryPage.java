package net.upgenix.pages;

import net.upgenix.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryPage {

    public InventoryPage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy() // product button
    public WebElement productButton;


}
