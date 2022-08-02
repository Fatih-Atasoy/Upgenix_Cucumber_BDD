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











