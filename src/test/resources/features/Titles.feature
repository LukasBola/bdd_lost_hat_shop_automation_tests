@smoke
Feature: Sites smoke tests

  Scenario: Check pages title
    Then    I check if Home Page has expected Lost Hat title
    Then    I check if Login Page has expected Login title
    Then    I check if Art Page has expected Art title
    Then    I check if Clothes Page has expected Clothes title
    Then    I check if Accessories Page has expected Accessories title