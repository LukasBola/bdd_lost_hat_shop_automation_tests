@reopen_browser_for_each_test
@smoke
@account
@account_login
Feature: Personal information features

  Scenario: Change my name and lastname and then turn it back to my old name and lastname
    Given   I am on the HomePage
    When    I click sign in button on the HomePage
    And     I type email for: CUSTOMER on the LoginPage
    And     I type password for: CUSTOMER on the LoginPage
    And     I click login button on the LoginPage
    And     I click view my customer account button on the HomePage
    And     I click information button on the MyAccountPage
    And     I type name: ChangedName on the IdentityPge
    And     I type last name: ChangedLastname  on the IdentityPge
    And     I type password: pass777 on the IdentityPge
    And     I click save button on the IdentityPge
    Then    I assert I am logged in as: ChangedName ChangedLastname
    And     I click view my customer account button on the HomePage
    And     I click information button on the MyAccountPage
    And     I get email from the IdentityPge
    And     I type name: Lukas  on the IdentityPge
    And     I type last name: Bolasz on the IdentityPge
    And     I type password for: CUSTOMER on the IdentityPge
    And     I click save button on the IdentityPge
    Then    I assert I am logged in as user: CUSTOMER
    And     I click logout button on the HomePage
    And     I assert that email for ENUM user: CUSTOMER is valid
#    And     I assert that user email: test@wp.pl is valid
    Then    I am logged out