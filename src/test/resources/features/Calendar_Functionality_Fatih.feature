@UPGN-335
Feature: Default

	#As a Posmanager, I should be able to create and to see my meetings and events on my calendar from "Calendar" module
	#
	#1. User  (As a Posmanager) first lands on weekly display
	@UPGN-329
	Scenario: Users  (As a Posmanager) first lands on weekly display.
		When Logged in user click calender link
		Then User land on weekly display	

	#As a Posmanager, I should be able to create and to see my meetings and events on my calendar from "Calendar" module
	#
	#2. Users can change display between Day-Week-Month
	@UPGN-330
	Scenario: Users can change display between options.
		When Logged in user click calender link
		And User land on weekly display
		And user click Day link and display Daily time
		Then user click Month link and display Month time	

	#As a Posmanager, I should be able to create and to see my meetings and events on my calendar from "Calendar" module
	#
	#For this ERP application, the calendar function is very crucial. Anyone in the team can contribute and plan their agenda using the calendar. To prevent any conflict, events should be created, edited and displayed by all team members.
	#
	#3. Users can create event by clicking on time box
	@UPGN-331
	Scenario: Users can create event by clicking on time box.
		When Logged in user click calender link
		And User lands on weekly display
		And User clicks Day link and display Daily time
		And User clicks on time box 
		And User enters name in summary box and clicks create button	

	#As a Posmanager, I should be able to create and to see my meetings and events on my calendar from "Calendar" module
	#
	#For this ERP application, the calendar function is very crucial. Anyone in the team can contribute and plan their agenda using the calendar. To prevent any conflict, events should be created, edited and displayed by all team members.
	#
	#4. Users can see, reach and edit events 
	@UPGN-332
	Scenario: Users can see, reach and edit events 
		When Logged in user click calender link
		And User lands on weekly display
		And User clicks Day link and display Daily time
		And User see created event.
		And User reach events' details
		And Users edit events 
		And "posmanager15" see created event.
		And "posmanager15" reach events' details
		Then "posmanager15" edit events