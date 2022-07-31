package net.upgenix.pages;

import net.upgenix.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SalesPage {

    public SalesPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//a[@href=\"/web#menu_id=447&action=48\"]")
    public WebElement customersLink;

    @FindBy(xpath = "//button[@accesskey=\"c\"]")
    public WebElement createButton;

    @FindBy(xpath = "//input[@name=\"name\"]")
    public WebElement nameInputBox;

    @FindBy(xpath = "//input[@name=\"function\"]")
    public WebElement jobPositionInputBox;

    @FindBy(xpath = "//input[@name=\"phone\"]")
    public WebElement phoneInputBox;

    @FindBy(xpath = "//input[@name=\"mobile\"]")
    public WebElement mobileInputBox;

    @FindBy(xpath = "//input[@name=\"email\"]")
    public WebElement emailInputBox;

    @FindBy(xpath = "//div[@name=\"title\"]/div/input")
    public WebElement titleInputBox;

    @FindBy(xpath = "//select[@name=\"lang\"]")
    public WebElement languageDropdownButton;

    @FindBy(xpath = "//div[@class=\"o_form_sheet_bg\"]")
    public WebElement formSheet;

    @FindBy(xpath = "//ol[@class=\"breadcrumb\"]/li")
    public WebElement customersText;

    @FindBy(xpath = "//div[@class=\"o_loading\"]")
    public WebElement loadingText;

    @FindBy(xpath = "//div[@class=\"oe_kanban_global_click o_res_partner_kanban o_kanban_record\"]")
    public List<WebElement> allCustomers;

    @FindBy(xpath = "//button[@accesskey=\"s\"]")
    public WebElement saveButton;

    @FindBy(xpath = "//div[@class=\"o_notification_title\"]")
    public WebElement notificationText;

    @FindBy(xpath = "//input[@class=\"o_searchview_input\"]")
    public WebElement searchInputBox;

    @FindBy(xpath = "//div[@class=\"oe_kanban_details\"]//span")
    public WebElement createdCustomerName;


}
