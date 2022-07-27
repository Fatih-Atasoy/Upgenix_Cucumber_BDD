Feature: Upgenix app Employees module
  Account is: PosManager

  Background: As a Posmanager, I should be able to create and edit a new employee from "Employees" module

  @Login
  Scenario Outline: User enters posmanager info
    When User is on the upgenix login page
    And User enters "<username>" username
    And User enters "<password>" password
    And User clicks the login button
    Then User should see the dashboard

    Examples: PosManager's username and password
      | username              | password   |
      | posmanager50@info.com | posmanager |

    @EmployeeStage
    Scenario: Verify that all buttons work as expected at the employees stage
      When User is on the dashboard
      And User clicks Employees stage
      And User clicks Challenges stage
      And User clicks Departments stage
      Then User should see the last stage title


    @CreatingEmployee
    Scenario: Verify that the "Employee created" message appears under full profile
      When User is on the employees dashboard
      When User creates new employees in the Employees stage
      Then



    @ListedEmployee
    Scenario: Verify that the user should be able to see created employee is listed after clicking the Employees module









