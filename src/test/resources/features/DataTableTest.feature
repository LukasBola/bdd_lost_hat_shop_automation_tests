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
      | columnName                 | expectedValue                |
      | Nr kontroli                | 23/234                       |
      | Termin realizacji kontroli | 2022-01-26 - 2022-02-01      |
      | Typ kontroli               | Wizyta monitoringowa         |
      | Rodzaj kontroli            | Kontrola specjalna (doraźna) |
      | Rodz test                  | Kontrola specjalna (doraźna) |

  Scenario: Data table tests - asMap2
    And     I provide data table test - asMap2
      | columnName                 | expectedValue                |
      | Nr kontroli                | 23/234                       |
      | Termin realizacji kontroli | 2022-01-26 - 2022-02-01      |
      | Typ kontroli               | Wizyta monitoringowa         |
      | Rodzaj kontroli            | Kontrola specjalna (doraźna) |
      | Rodz test                  | Kontrola specjalna (doraźna) |