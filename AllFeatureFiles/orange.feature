Feature: Orange HRM Application

  Scenario: Test browser Functionality
    Given user open "Chrome" and enter url

  Scenario: Test login fuctionality
    When enter valid username and password and click on login button
      | Admin | admin123 |
    Then verify home page title and url

  Scenario Outline: test pim page functionality
    When user click on pim link
    And validiate url
      | link |
      | pim  |
    And user click on add employee button and enter "<firstname>" , "<lastname>" and click on save button
    And user capture employee id and click on employee list
    And enter employee id and click on search button
    And select the search employee and click on delete
    And verify employee delete or not

    Examples: 
      | firstname | lastname |
      | Rekha     | Misal    |
      | Kavita    | Misal    |
