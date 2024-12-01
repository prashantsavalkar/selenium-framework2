Feature: E2E Test case

  Background :
  Given Navigate to baseUrl
  @Regression
  Scenario Outline: Positive E2E test scenario
    Given Login with username <name> and password <password>
    When Added product <product> to cart and checkout
    Then Verify the details "***"

    Examples: 
      | name                         | password     | product    |
      | savalkarprashant14@gmail.com | Prashant@123 | Nikon D300 |
