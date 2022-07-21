package net.upgenix.pages;

import net.upgenix.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage (){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (id = "password")
    public WebElement password;

    @FindBy (id = "login")
    public WebElement userName;

    @FindBy (xpath = "//button[.='Log in']")
    public WebElement LoginButton;
}
