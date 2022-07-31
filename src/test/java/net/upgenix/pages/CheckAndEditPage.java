package net.upgenix.pages;

import net.upgenix.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckAndEditPage {

    public CheckAndEditPage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }

        @FindBy(name = "login")
        public WebElement inputEmail;

        @FindBy(name = "password")
        public WebElement inputPassword;

        @FindBy(xpath = "//button[@type='submit']")
        public WebElement loginButton;



}
