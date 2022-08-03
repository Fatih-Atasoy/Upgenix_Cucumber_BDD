@UPGN-361
Feature: Default

	#_*{color:#ff0000}User Story:{color}*_
	#
	#As a user, I should be able to reach and click create button in inventory page
	#
	#*_{color:#ff0000}AC1:{color}_*
	#1- Verify that User can reach New Products Form by clicking Inventory --> Products --> Create
	@UPGN-351
	Scenario: Hamdi-TC1-Verify that User can reach New Products Form by clicking Inventory --> Products --> Create
		When user clicks Inventory link on the top navigation bar
		And user clicks Product link left of the page
		And user clicks Create button
		Then user see create new product page

	#{color:#FF0000}_*User Story:*_{color} 
	#
	#As a user, I should be able to reach and click create button in inventory page
	#
	#{color:#FF0000}_*AC2:*_{color}
	#
	#2- Verify that if Product name field leaves blank, an error message "The following fields are invalid:" is appeared.
	@UPGN-358
	Scenario: Hamdi-TC2-Verify that if Product name field leaves blank, an error message "The following fields are invalid:" is appeared.
		When user clicks Inventory link on the top navigation bar
		And user clicks Product link left of the page
		And user clicks Create button
		And user clicks Save button without fullfill the name input
		Then user see 'The following fields are invalid:' error message on the page	

	#_*{color:#ff0000}User Story:{color}*_
	#
	#As a user, I should be able to reach and click create button in inventory page
	#
	#*_{color:#ff0000}AC1:{color}_*
	#3-Verify that after creating a Product, the page title includes the Product name.
	@UPGN-359
	Scenario: Hamdi-TC3-Verify that after creating a Product, the page title includes the Product name.
		When user clicks Inventory link on the top navigation bar
		And user clicks Product link left of the page
		And user clicks Create button
		And user enters product name
		And user clicks Save button
		Then user see Product name on the page title	

	#_*{color:#ff0000}User Story:{color}*_
	#
	#As a user, I should be able to reach and click create button in inventory page
	#
	#*_{color:#ff0000}AC1:{color}_*
	#
	#4- Verify that the user should be able to see created Product is listed after clicking the Products module.
	@UPGN-360
	Scenario: Hamdi-TC4-Verify that the user should be able to see created Product is listed after clicking the Products module.
		When user clicks Inventory link on the top navigation bar
		And user clicks Product link left of the page
		And user enters product name on search inputbox
		Then user see Product name on product list