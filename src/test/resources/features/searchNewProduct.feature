Feature: Default



  @SearchNewProduct
  Scenario: Users  login for reaching other functionality
    When User login for testing other functionality
    Then  Posmanager click the inventory button
    Then  Posmanager click the product button
    Then  Posmanager search the product that created