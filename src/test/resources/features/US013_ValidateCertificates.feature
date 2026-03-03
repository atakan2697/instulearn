@US013
Feature: US_013 - Validate Certificates

  Scenario: TC_01 - Validate Certificates kartinin gorunmesi ve Certificate Validation sayfasina yonlendirme
    Given kullanici "instulearnUrl" anasayfaya gider
    And kullanici 2 saniye bekler
    Then Validate Certificates kartinin gorunur oldugunu dogrular
    When Validate Certificates kartina tiklar
    Then Certificate Validation sayfasinin acildigini dogrular