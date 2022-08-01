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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Calendar_StepDefinition {
    LoginPage loginPage = new LoginPage();
    AccountPage accountPage = new AccountPage();
    CalendarPage calendarPage = new CalendarPage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);

    @When("Logged user click calender link")
    public void logged_user_click_calender_link() {
        wait.until(ExpectedConditions.titleIs("#Inbox - Odoo"));
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
        wait.until(ExpectedConditions.attributeContains(calendarPage.DayButton, "class", "active"));
        String Day = calendarPage.scheduleForDay.getText();
        int MonthNumber = Integer.parseInt(calendarPage.scheduleForMonthAndYear.getAttribute("data-month")) + 1;
        String Month = (MonthNumber == 1) ? "January" : (MonthNumber == 2) ? "February" : (MonthNumber == 3) ? "March" :
                (MonthNumber == 4) ? "April" : (MonthNumber == 5) ? "May" : (MonthNumber == 6) ? "June" :
                        (MonthNumber == 7) ? "July" : (MonthNumber == 8) ? "August" : (MonthNumber == 9) ? "September" :
                                (MonthNumber == 10) ? "October" : (MonthNumber == 11) ? "November" : "December";

        int Year = Integer.parseInt(calendarPage.scheduleForMonthAndYear.getAttribute("data-year"));

        String expectedResult = "Meetings (" + Month + " " + Day + ", " + Year + ")";

        String actualResult = calendarPage.DisplayedType.getText();

        Assert.assertEquals(actualResult, expectedResult);

    }


    @Then("User clicks Month link and display Month time")
    public void userClicksMonthLinkAndDisplayMonthTime() {
        calendarPage.MonthButton.click();
        wait.until(ExpectedConditions.attributeContains(calendarPage.MonthButton, "class", "active"));
        int MonthNumber = Integer.parseInt(calendarPage.scheduleForMonthAndYear.getAttribute("data-month")) + 1;
        String Month = (MonthNumber == 1) ? "January" : (MonthNumber == 2) ? "February" : (MonthNumber == 3) ? "March" :
                (MonthNumber == 4) ? "April" : (MonthNumber == 5) ? "May" : (MonthNumber == 6) ? "June" :
                        (MonthNumber == 7) ? "July" : (MonthNumber == 8) ? "August" : (MonthNumber == 9) ? "September" :
                                (MonthNumber == 10) ? "October" : (MonthNumber == 11) ? "November" : "December";
        String Day = calendarPage.scheduleForDay.getText();
        int Year = Integer.parseInt(calendarPage.scheduleForMonthAndYear.getAttribute("data-year"));
        String expectedResult = "Meetings (" + Month + " " + Year + ")";

        String actualResult = calendarPage.DisplayedType.getText();
        Assert.assertEquals(actualResult, expectedResult);

    }


    @When("User clicks on time box")
    public void user_clicks_on_time_box() {
        calendarPage.createEvent.click();
        Assert.assertTrue(calendarPage.CreatePage.isDisplayed());
    }

    @And("User enters name as {string} in summary box and clicks create button")
    public void userEntersNameAsInSummaryBoxAndClicksCreateButton(String str) {
        str =ConfigurationReader.getProperty("eventName");
        for (int i = 0; i < str.length(); i++) {
            calendarPage.SummaryBox.sendKeys("" + str.charAt(i));
        }
        calendarPage.CreateButton.click();
        Assert.assertTrue(calendarPage.CreatedEventInTimeBox.isDisplayed());
        Assert.assertEquals(calendarPage.CreatedEventInTimeBox.getText(), ConfigurationReader.getProperty("eventName"));
    }

    @When("User see created event.")
    public void user_see_created_event() {
        Assert.assertTrue(calendarPage.CreatedEventInTimeBox.isDisplayed());
    }

    @When("User reach events' details")
    public void user_reach_events_details() {
        calendarPage.CreatedEvent.click();
        Assert.assertTrue(calendarPage.CreatedEventDetails.isDisplayed());
    }

    @When("Users edit events")
    public void users_edit_events() {
        calendarPage.EditButton.click();
        wait.until(ExpectedConditions.visibilityOf(calendarPage.SaveButton));
        wait.until(ExpectedConditions.visibilityOf(calendarPage.MeetingSubjectBox));
        calendarPage.MeetingSubjectBox.sendKeys(" ");
        for (int i = 0; i < ConfigurationReader.getProperty("eventName").length(); i++) {
            calendarPage.MeetingSubjectBox.sendKeys("" + ConfigurationReader.getProperty("eventName").charAt(i));
        }

        calendarPage.SaveButton.click();
        wait.until(ExpectedConditions.invisibilityOf(calendarPage.LoadingWord));
        Assert.assertEquals(calendarPage.CreatedEventInTimeBox.getText(), ConfigurationReader.getProperty("eventName")+" "+ConfigurationReader.getProperty("eventName"));
    }

    @When("{string} see created event.")
    public void see_created_event(String string) {
        accountPage.UserMenu.click();
        accountPage.logoutButton.click();
        for (int i = 0; i < (string + "@info.com").length(); i++) {
            loginPage.userName.sendKeys("" + (string + "@info.com").charAt(i));
        }

        String password = "";
        if (string.charAt(0) == 'p') {
            password = "posmanager";
        } else if (string.charAt(0) == 's') {
            password = "salesmanager";
        }
        for (int i = 0; i < password.length(); i++) {
            loginPage.password.sendKeys("" + password.charAt(i));
        }
        loginPage.LoginButton.click();
        wait.until(ExpectedConditions.titleIs("#Inbox - Odoo"));
        wait.until(ExpectedConditions.visibilityOf(accountPage.CalendarLink));
        accountPage.CalendarLink.click();

        wait.until(ExpectedConditions.visibilityOf(calendarPage.DayButton));
        calendarPage.DayButton.click();
        wait.until(ExpectedConditions.attributeContains(calendarPage.DayButton, "class", "active"));

        String Day = calendarPage.scheduleForDay.getText();
        int MonthNumber = Integer.parseInt(calendarPage.scheduleForMonthAndYear.getAttribute("data-month")) + 1;
        String Month = (MonthNumber == 1) ? "January" : (MonthNumber == 2) ? "February" : (MonthNumber == 3) ? "March" :
                (MonthNumber == 4) ? "April" : (MonthNumber == 5) ? "May" : (MonthNumber == 6) ? "June" :
                        (MonthNumber == 7) ? "July" : (MonthNumber == 8) ? "August" : (MonthNumber == 9) ? "September" :
                                (MonthNumber == 10) ? "October" : (MonthNumber == 11) ? "November" : "December";

        int Year = Integer.parseInt(calendarPage.scheduleForMonthAndYear.getAttribute("data-year"));
        String expectedResult = "Meetings (" + Month + " " + Day + ", " + Year + ")";
        String actualResult = calendarPage.DisplayedType.getText();
        Assert.assertEquals(actualResult, expectedResult);
        calendarPage.EveryBodysCalendarsCheckBox.click();
        Assert.assertTrue(calendarPage.CreatedEventInTimeBox.isDisplayed());

    }

    @When("{string} reach events' details")
    public void reach_events_details(String string) {
        calendarPage.CreatedEvent.click();
        Assert.assertTrue(calendarPage.CreatedEventDetails.isDisplayed());

    }
    @Then("{string} edit events")
    public void edit_events(String string) {
        calendarPage.EditButton.click();
        wait.until(ExpectedConditions.visibilityOf(calendarPage.SaveButton));
        for (int i = 0; i < " posmanager".length(); i++) {
            calendarPage.MeetingSubjectBox.sendKeys("" + " posmanager".charAt(i));
        }
        calendarPage.SaveButton.click();
        wait.until(ExpectedConditions.invisibilityOf(calendarPage.LoadingWord));
BrowserUtils.sleep(1);
        Assert.assertEquals(calendarPage.CreatedEventInTimeBox.getText(), ConfigurationReader.getProperty("eventName")+" "+ConfigurationReader.getProperty("eventName")+" posmanager");
    }
}