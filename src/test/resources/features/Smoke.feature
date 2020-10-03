@smoke
Feature: Sites smoke tests

  Scenario Outline: Check pages title
    Then    I check if <page> has expected <title> title
    Examples:
      | page             | title       |
      | Home Page        | Lost Hat    |
      | Login Page       | Login       |
      | Art Page         | Art         |
      | Clothes Page     | Clothes     |
      | Accessories Page | Accessories |