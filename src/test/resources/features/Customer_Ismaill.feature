@UPGN-350
Feature: Default

		#@UPGN-346
		Background: user login with valid credentials
		Given User login for testing other functionality
		

	#{color:#DE350B}User Story :{color} 
	#
	#As a Sales Manager, I should be able to create and edit a new customer from "Sales" module
	#
	#{color:#DE350B}Acceptance Criteria:{color}
	#1. Verify that User can reach New Customer Form by clicking Sales --> Customers --> Create
	@UPGN-345
	Scenario: Verify that User can reach New Customer Form by clicking Sales/Customers/Create
		When user should click Sales module which is top of the navigation bar
		And user should click Customers submodule left on the page
		And user should click Create button on the Customers page
		Then user should see the form sheet on the page and title should be "New - Odoo"

	#User Story :
	#
	#As a Sales Manager, I should be able to create and edit a new customer from "Sales" module
	#
	#Acceptance Criteria:
	#2. Verify that if customer name field leaves blank, an error message "The following fields are invalid:" is appeared.
	@UPGN-347
	Scenario: Verify that if customer leaves the 'name' field blank, "The following fields are invalid:" error text should be appeared on the page.
		When user should click Sales module which is top of the navigation bar
		And user should click Customers submodule left on the page
		And user should click Create button on the Customers page
		And user should click Save button without fullfill the name input
		Then "The following fields are invalid:" error text should be appeared on the page

	#{color:#DE350B}User Story :{color}
	#
	#As a Sales Manager, I should be able to create and edit a new customer from "Sales" module
	#
	#{color:#DE350B}Acceptance Criteria:{color}
	#3. Verify that after creating a new customer, the page title includes the customer name.
	@UPGN-348
	Scenario: Verify that after creating a new customer, the page title includes the customer name.
		When user should click Sales module which is top of the navigation bar
		And user should click Customers submodule left on the page
		And user should click Create button on the Customers page
		And user should input the name "Jack Reacher2"
		And user should fulfill the other requirements
		Then after clicking Save button, page includes the customer name.

	#{color:#DE350B}User Story :{color}
	#
	#As a Sales Manager, I should be able to create and edit a new customer from "Sales" module
	#
	#{color:#DE350B}Acceptance Criteria:{color}
	#4. Verify that the user should be able to see created customer is listed after clicking the Customers module.
#	@UPGN-349
#	Scenario: Verify that the user should be able to see created customer is listed after clicking the Customers module
#		When user should click Sales module which is top of the navigation bar
#		And user should click Customers submodule left on the page
#		And user should click Create button on the Customers page
#		And user should input the name "Jack Reacher2"
#		And user should fulfill the other requirements
#		Then after clicking Save button, page includes the customer name.
#		And user should click Customers submodule left on the page
#		Then new customer should be display after user search the customer