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


    @FindBy(xpath = "//ol[@class='breadcrumb']/li")
    public WebElement DisplayedType;

    @FindBy(xpath = "//button[.='Day']")

    public WebElement DayButton;
    @FindBy(xpath = "//button[.='Week']")
    public WebElement WeekButton;

    @FindBy(xpath = "//button[.='Month']")
    public WebElement MonthButton;


    @FindBy(xpath = "//td[@class=' ui-datepicker-days-cell-over  ui-datepicker-current-day ui-datepicker-today']")
    public WebElement scheduleForMonthAndYear;

    @FindBy(xpath = "//td[@class=' ui-datepicker-days-cell-over  ui-datepicker-current-day ui-datepicker-today']/a")
    public WebElement scheduleForDay;
}
