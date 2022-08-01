package net.upgenix.pages;

import net.upgenix.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CalendarPage {

    public CalendarPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//td[@class='fc-widget-content'])[22]")
    public WebElement createEvent;

    @FindBy(xpath = "//ol[@class='breadcrumb']/li")
    public WebElement DisplayedType;

    @FindBy(xpath = "//button[.='Day']")
    public WebElement DayButton;

    @FindBy(xpath = "//button[.='Month']")
    public WebElement MonthButton;

    @FindBy(xpath = "//td[@class=' ui-datepicker-days-cell-over  ui-datepicker-current-day ui-datepicker-today']")
    public WebElement scheduleForMonthAndYear;

    @FindBy(xpath = "//td[@class=' ui-datepicker-days-cell-over  ui-datepicker-current-day ui-datepicker-today']/a")
    public WebElement scheduleForDay;

    @FindBy(xpath = "//div[@data-value='all']//input")
    public WebElement EveryBodysCalendarsCheckBox;

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

    @FindBy(xpath = "//div[@class='fc-event-container']//a")
    public WebElement CreatedEvent;

    @FindBy(xpath = "//button[.='Edit']")
    public WebElement EditButton;

    @FindBy(xpath = "(//button[.='Save'])[2]")
    public WebElement SaveButton;

    @FindBy(xpath = "//input[@placeholder='e.g. Business Lunch']")
    public WebElement MeetingSubjectBox;


    @FindBy(xpath = "//div[.='Loading']")
    public WebElement LoadingWord;

}
