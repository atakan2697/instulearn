@US013
Feature: US_013 - Validate Certificates

  Scenario: TC_01 - Validate Certificates kartinin gorunmesi ve Certificate Validation sayfasina yonlendirme
    Given kullanici "instulearnUrl" anasayfaya gider
    And kullanici 2 saniye bekler
    Then Validate Certificates kartinin gorunur oldugunu dogrular
    When Validate Certificates kartina tiklar
    Then Certificate Validation sayfasinin acildigini dogrular

  Scenario: TC_02 - Reserve a meeting karti yonlendirme kontrolu
    Given kullanici "instulearnUrl" anasayfaya gider
    And kullanici 2 saniye bekler
    Then Reserve a meeting kartinin gorunur oldugunu dogrular
    When Reserve a meeting kartina tiklar
    Then Instructors sayfasinin acildigini dogrular

  Scenario: TC_03 - Anasayfada kartlarin gorunurluk kontrolu
    Given kullanici "instulearnUrl" anasayfaya gider
    And kullanici 2 saniye bekler
    Then Validate Certificates kartinin gorunur oldugunu dogrular
    And Reserve a meeting kartinin gorunur oldugunu dogrular
    Then Her iki kartin da tiklanabilir oldugunu dogrular
