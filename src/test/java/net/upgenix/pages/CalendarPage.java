package net.upgenix.pages;

import net.upgenix.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalendarPage {

    public CalendarPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (xpath = "(//td[@class='fc-widget-content'])[22]")
    public WebElement createEvent;

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

    @FindBy(xpath = "//h3[.='Responsible']")
    public WebElement ResponsibleField;


    @FindBy(xpath = "//div[@class='modal-header']")
    public WebElement CreatePage;

    @FindBy(xpath = "//input[@class='o_input']")
    public WebElement SummaryBox;

    @FindBy(xpath = "//span[.='Create']")
    public WebElement CreateButton;

    @FindBy(xpath = "//div[@class='o_field_name o_field_type_char']")
    public WebElement CreatedEventInTimeBox;

    @FindBy(xpath = "(//h4[@class='modal-title'])[1]")
    public WebElement CreatedEventDetails;





}
