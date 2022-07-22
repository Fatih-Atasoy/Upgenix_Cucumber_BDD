package net.upgenix.step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.upgenix.pages.AccountPage;
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
            expectedResult;

    AccountPage accountPage = new AccountPage();
    CalendarPage calendarPage = new CalendarPage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 5);

    @When("Logged user click calender link")
    public void logged_user_click_calender_link() {
          wait.until(ExpectedConditions.visibilityOf(accountPage.CalendarLink));
        accountPage.CalendarLink.click();
    }

    @Then("User lands on weekly display")
    public void user_lands_on_weekly_display() {
        wait.until(ExpectedConditions.titleIs(ConfigurationReader.getProperty("CalendarTitle")));
        Assert.assertTrue(accountPage.DisplayedType.getText().contains("Week"));
    }

    @When("User clicks Day link and display Daily time")
    public void user_clicks_day_link_and_display_daily_time() {
       wait.until(ExpectedConditions.visibilityOf(accountPage.DayButton));
        accountPage.DayButton.click();
        BrowserUtils.sleep(10);
        String Day = accountPage.scheduleForDay.getText();
        int MonthNumber = Integer.parseInt(accountPage.scheduleForMonthAndYear.getAttribute("data-month"));
        String Month= (MonthNumber==1)? "January" : (MonthNumber==2)? "February" :(MonthNumber==3)? "March" :
                (MonthNumber==4)? "April" :(MonthNumber==5)? "May" :(MonthNumber==6)? "June" :
                        (MonthNumber==7)? "July" :(MonthNumber==8)? "August" :(MonthNumber==9)? "September" :
                                (MonthNumber==10)? "October" :(MonthNumber==11)? "November" : "December";

        int Year = Integer.parseInt(accountPage.scheduleForMonthAndYear.getAttribute("data-year"));

        actualResult=accountPage.DisplayedType.getText();
        expectedResult="Meetings ("+Month+" "+Day+", "+Year+")";
        //Meetings (July 22, 2022)
        Assert.assertEquals(actualResult,expectedResult);
        System.out.println("actualResult = " + actualResult);
        System.out.println("expectedResult = " + expectedResult);


    }


    @Then("User clicks Month link and display Month time")
    public void userClicksMonthLinkAndDisplayMonthTime() {
        //    accountPage.MonthButton.click();
//        Assert.assertTrue(accountPage.DisplayedType.getAttribute("innerHTML").contains("Week"));

    }


    @When("User clicks on time box")
    public void user_clicks_on_time_box() {
    }

    @When("User enters name in summary box and clicks create button")
    public void user_enters_name_in_summary_box_and_clicks_create_button() {
    }


    @When("User see created event.")
    public void user_see_created_event() {
    }

    @When("User reach events' details")
    public void user_reach_events_details() {
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