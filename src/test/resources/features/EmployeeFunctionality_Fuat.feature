Feature: Upgenix app Employees module
  Account is: PosManager

  Background: As a Posmanager, I should be able to create and edit a new employee from "Employees" module
    Given User is on the upgenix login page

  @EmployeeStage
  Scenario Outline: User enters posmanager info
    When User enters "<username>" username
    And User enters "<password>" password
    And User clicks the login button
    Then User should see the dashboard

    Examples: PosManager's username and password
      | username              | password   |
      | posmanager50@info.com | posmanager |

    Scenario: Verify that all buttons work as expected at the employees stage
      When User clicks Employees stage
      And User clicks Challenges stage
      And User clicks Departments stage
      Then User should see the title
#2. Verify that the "Employee created" message appears under full profile.
#
#3. Verify that the user should be able to see created employee is listed after clicking the Employees module.









