
Feature: Login with invalid creds


  @Sanity
  Scenario Outline: Invalid test
    Given Navigate to baseUrl
    When Login with username <name> and password <password>
    Then Verify the url of current page

    Examples: 
      | name                      | password     | 
      | savalkarprant14@gmail.com | Prant@123    | 
      