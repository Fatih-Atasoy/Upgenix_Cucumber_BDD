package net.upgenix.step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.upgenix.pages.AccountPage;
import org.junit.Assert;

public class Calendar_StepDefinition {

    AccountPage accountPage = new AccountPage();

    @When("Logged in user click calender link")
    public void logged_in_user_click_calender_link() {
accountPage.CalendarLink.click();

    }
    @Then("User land on weekly display")
    public void user_land_on_weekly_display() {
     Assert.assertTrue(accountPage.weeklyDisplayed.getText().contains("Week"));
    }




    @When("user click Day link and display Daily time")
    public void user_click_day_link_and_display_daily_time() {
    }
    @Then("user click Month link and display Month time")
    public void user_click_month_link_and_display_month_time() {
    }



    @When("User lands on weekly display")
    public void user_lands_on_weekly_display() {
    }
    @When("User clicks Day link and display Daily time")
    public void user_clicks_day_link_and_display_daily_time() {
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