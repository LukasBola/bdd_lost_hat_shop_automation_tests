@reopen_browser_for_each_test
@smoke
@account
@account_login
Feature: Personal information features

  Scenario: Change my personal information
    Given   I am on the HomePage
    When    I click sign in button on the HomePage
    And     I type email: test_777@test.com on the LoginPage
    And     I type password: pass777 on the LoginPage
    And     I click login button on the LoginPage
    And     I click view my customer account button on the HomePage
    And     I click information button on the MyAccountPage
    And     I type new name: Lukas  on the IdentityPge
    And     I type new last name: Bolasz on the IdentityPge
    And     I type password: pass777 on the IdentityPge
    And     I click save button on the IdentityPge
    Then    I am logged in as: Lukas Bolasz