@data_table_tests
Feature: Data table feature

  Scenario: Data table tests - row
    And     I provide data table test - row
      | row1 | row11 | row12 |
      | row2 | row21 | row22 |
      | row3 | row31 | row32 |
      | row4 | row41 | row42 |

  Scenario: Data table tests - asList
    And     I provide data table test - asList
      | Prześlij do  |
      | Edytuj       |
      | Teczka       |
      | Podgląd      |
      | Opcje > Usuń |

  Scenario: Data table tests - asMap
    And     I provide data table test - asMap
      | title1 | title2 | title3 |
      | row1   | row11  | row12  |
      | row2   | row21  | row22  |
      | row3   | row31  | row32  |
      | row4   | row41  | row42  |