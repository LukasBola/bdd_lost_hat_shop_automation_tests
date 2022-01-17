@reopen_browser_for_each_test
@smoke
@account
@account_login
Feature: Login features

  @account_login_valid_credentials
  Scenario: Login with valid credentials
    Given   I am on the HomePage
    When    I click sign in button on the HomePage
    And     I type email for: CUSTOMER on the LoginPage
    And     I type password for: CUSTOMER on the LoginPage
    And     I click login button on the LoginPage
    Then    I assert I am logged in as user: CUSTOMER
    And     I click logout button on the HomePage
    Then    I am logged out

  @account_login_invalid_credentials
  Scenario: Login with invalid credentials
    Given   I am on the HomePage
    When    I click sign in button on the HomePage
    And     I type email: incorrect_mail@test.com on the LoginPage
    And     I type password: incorrect_password on the LoginPage
    And     I click login button on the LoginPage
    Then    I am not logged in

  @account_login_and_logout
  Scenario: Login with valid credentials and then log out
    Given   I am on the HomePage
    When    I click sign in button on the HomePage
    And     I type email for: APPLICANT on the LoginPage
    And     I type password for: APPLICANT on the LoginPage
    And     I click login button on the LoginPage
    Then    I assert I am logged in as user: APPLICANT
    And     I click logout button on the HomePage
    Then    I am logged out
