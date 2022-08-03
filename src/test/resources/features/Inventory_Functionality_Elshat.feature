Feature: Default



  Scenario: Users  login for reaching other functionality
    When User login for testing other functionality


  @AddProduct
  Scenario: Posmanager can add a new product to the inventory
    When User login for testing other functionality
    When  Posmanager click the inventory button
    When  Posmanager click the product button
    And   Posmanager click the create button
    Then  Posmanager give the product name
    Then  Posmanager click the save button
    Then  Posmanager should see the product created


  @SelectTheProductType
  Scenario: Posmanager can select the product type
    When  User login for testing other functionality
    When  Posmanager click the inventory button
    When  Posmanager click the product button
    And   Posmanager click the create button
    When  Posmanager select the product type


  @SelectKategory
  Scenario: Posmanager can select the category
    When  User login for testing other functionality
    When  Posmanager click the inventory button
    When  Posmanager click the product button
    And   Posmanager click the create button
    Then  Posmanager select the category

  @GiveABarcode
  Scenario: Posmanger can give a barcode to product
    When  User login for testing other functionality
    When  Posmanager click the inventory button
    When  Posmanager click the product button
    And   Posmanager click the create button
    Then  Posmanager give the product name
    Then  Posmanager can give a barcode number to product


  @SetPrices
  Scenario: Posmanager can set the sales and cost prices
    When  User login for testing other functionality
    When  Posmanager click the inventory button
    When  Posmanager click the product button
    And   Posmanager click the create button
    And   Posmanager give the product name
    When  Posmanager set the sales price
    Then  Posmanager set the cost price


  @AllSteps
  Scenario: Posmanager do all steps in one shot
    When User login for testing other functionality
    When  Posmanager click the inventory button
    When  Posmanager click the product button
    And   Posmanager click the create button
    Then  Posmanager give the product name
    When  Posmanager select the product type
    Then  Posmanager select the category
    Then  Posmanager give the internal reference code
    Then  Posmanager can give a barcode number to product
    Then  Posmanager set the sales price
    Then  Posmanager set the cost price
    Then  Posmanager click the save button
    Then  Posmanager should see the product created
    Then  Posmanager click the product button
    #Then  Posmanager search the product that created























