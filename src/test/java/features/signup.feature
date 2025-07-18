Feature: Login and sign-up functionality

  Scenario: Create account and sign in
    Given User opens the home page
    Then User clicks on create account button
    When User enters personal details
    Then User verifies account information
    Then Close browser
    When User opens the home page
    Then User clicks on the login button
    When User enters login credentials
    Then User clicks on sign in button
    Then User verifies successful login
    Then Close browser

  Scenario: User logs in with invalid credentials
    Given User opens the home page
    Then User clicks on the login button
    When User enters invalid login credentials
    Then User clicks on sign in button
    Then User verifies error message for invalid credentials
    Then Close browser