package net.upgenix.step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.upgenix.pages.*;
import net.upgenix.pages.CalendarPage;
import net.upgenix.utilities.BrowserUtils;
import net.upgenix.utilities.ConfigurationReader;
import net.upgenix.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Calendar_StepDefinition {
    String actualResult,
            expectedResult,
            eventName;

    AccountPage accountPage = new AccountPage();
    CalendarPage calendarPage = new CalendarPage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);

    @When("Logged user click calender link")
    public void logged_user_click_calender_link() {
          wait.until(ExpectedConditions.visibilityOf(accountPage.CalendarLink));
        accountPage.CalendarLink.click();
    }

    @Then("User lands on weekly display")
    public void user_lands_on_weekly_display() {
        wait.until(ExpectedConditions.titleIs(ConfigurationReader.getProperty("CalendarTitle")));
        Assert.assertTrue(calendarPage.DisplayedType.getText().contains("Week"));

    }

    @When("User clicks Day link and display Daily time")
    public void user_clicks_day_link_and_display_daily_time() {
       wait.until(ExpectedConditions.visibilityOf(calendarPage.DayButton));
        calendarPage.DayButton.click();
//        BrowserUtils.sleep(10);
        String Day = calendarPage.scheduleForDay.getText();
        int MonthNumber = Integer.parseInt(calendarPage.scheduleForMonthAndYear.getAttribute("data-month"))+1;
        String Month= (MonthNumber==1)? "January" : (MonthNumber==2)? "February" :(MonthNumber==3)? "March" :
                (MonthNumber==4)? "April" :(MonthNumber==5)? "May" :(MonthNumber==6)? "June" :
                        (MonthNumber==7)? "July" :(MonthNumber==8)? "August" :(MonthNumber==9)? "September" :
                                (MonthNumber==10)? "October" :(MonthNumber==11)? "November" : "December";

        int Year = Integer.parseInt(calendarPage.scheduleForMonthAndYear.getAttribute("data-year"));
//        System.out.println("Day = " + Day);
//        System.out.println("Month = " + Month);
//        System.out.println("Year = " + Year);
//        System.out.println("MonthNumber = " + MonthNumber);

        expectedResult="Meetings ("+Month+" "+Day+", "+Year+")";
//        //Meetings (July 22, 2022)

       // System.out.println("expectedResult = " + expectedResult);
        BrowserUtils.sleep(2);
       // wait.until(ExpectedConditions.visibilityOf());
        actualResult=calendarPage.DisplayedType.getText();
        Assert.assertEquals(actualResult,expectedResult);
       // System.out.println("actualResult = " + actualResult);
    }


    @Then("User clicks Month link and display Month time")
    public void userClicksMonthLinkAndDisplayMonthTime() {
        wait.until(ExpectedConditions.visibilityOf(calendarPage.MonthButton));
            calendarPage.MonthButton.click();
       // String Day = calendarPage.scheduleForDay.getText();
        int MonthNumber = Integer.parseInt(calendarPage.scheduleForMonthAndYear.getAttribute("data-month"))+1;
        String Month= (MonthNumber==1)? "January" : (MonthNumber==2)? "February" :(MonthNumber==3)? "March" :
                (MonthNumber==4)? "April" :(MonthNumber==5)? "May" :(MonthNumber==6)? "June" :
                        (MonthNumber==7)? "July" :(MonthNumber==8)? "August" :(MonthNumber==9)? "September" :
                                (MonthNumber==10)? "October" :(MonthNumber==11)? "November" : "December";

        int Year = Integer.parseInt(calendarPage.scheduleForMonthAndYear.getAttribute("data-year"));
//        System.out.println("Day = " + Day);
//        System.out.println("Month = " + Month);
//        System.out.println("Year = " + Year);
//        System.out.println("MonthNumber = " + MonthNumber);

        expectedResult="Meetings ("+Month+" "+Year+")";
//        //Meetings (July 2022)

        // System.out.println("expectedResult = " + expectedResult);
       // BrowserUtils.sleep(5);
       wait.until(ExpectedConditions.visibilityOf(calendarPage.ResponsibleField));
        actualResult=calendarPage.DisplayedType.getText();
        Assert.assertEquals(actualResult,expectedResult);
        // System.out.println("actualResult = " + actualResult);

    }


    @When("User clicks on time box")
    public void user_clicks_on_time_box() {
        calendarPage.createEvent.click();
        Assert.assertTrue(calendarPage.CreatePage.isDisplayed());
    }

    @And("User enters name as {string} in summary box and clicks create button")
    public void userEntersNameAsInSummaryBoxAndClicksCreateButton(String arg0) {
        eventName=arg0;
            calendarPage.SummaryBox.sendKeys(arg0);
        calendarPage.CreateButton.click();
        Assert.assertTrue(calendarPage.CreatedEventInTimeBox.isDisplayed());
        Assert.assertEquals(calendarPage.CreatedEventInTimeBox.getText(),eventName);
        System.out.println("calendarPage.CreatedEventInTimeBox.getText() = " + calendarPage.CreatedEventInTimeBox.getText());
    }



    @When("User see created event.")
    public void user_see_created_event() {
        Assert.assertTrue(calendarPage.CreatedEventInTimeBox.isDisplayed());
        Assert.assertEquals(calendarPage.CreatedEventInTimeBox.getText(),eventName);
    }

    @When("User reach events' details")
    public void user_reach_events_details() {
     //   calendarPage.CreatedEventInTimeBox.click();
       // Assert.assertTrue(calendarPage.CreatedEventDetails.isDisplayed());
      //  Assert.assertEquals(calendarPage.CreatedEventDetails.getText(),"Open: "+eventName);
    }

    @When("Users edit events")
    public void users_edit_events() {
    }

    @When("{string} see created event.")
    public void see_created_event(String string) {
    }

    @When("{string} reach events' details")
    public void reach_events_details(String string) {
    }

    @Then("{string} edit events")
    public void edit_events(String string) {
    }



}