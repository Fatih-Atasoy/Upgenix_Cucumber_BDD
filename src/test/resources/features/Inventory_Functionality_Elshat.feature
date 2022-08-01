Feature: Inventory Functionality

  Background Posmanager on the login page
    Given User logged as posmanager

    @AddProduct
   Scenario: Posmanager can add a new product to the inventory
     When  Posmanager click the product button
     And   Posmanager click the create button
     Then  Posmanager give the product name
     Then  Posmanager should see the product created


    @SelectTheProductType
    Scenario: Posmanager can select the product type
      When    Posmanager select the prouct type









