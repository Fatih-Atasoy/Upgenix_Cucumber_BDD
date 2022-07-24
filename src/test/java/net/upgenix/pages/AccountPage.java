package net.upgenix.pages;

import net.upgenix.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {
    public AccountPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//span[@class='oe_topbar_name']")
    public WebElement accountName;


    @FindBy(xpath = "//a[@data-menu='logout']")
    public WebElement logoutButton;

    @FindBy(partialLinkText = "Calendar")
    public WebElement CalendarLink;



}
