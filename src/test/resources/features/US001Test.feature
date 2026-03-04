Feature: US_001 Visitor ana sayfaya erisebilmeli


  Scenario: TC_US001_001 Visitor ana sayfaya basariyla erisir

    Given kullanici "instulearnUrl" anasayfaya gider
    When kullanici 2 saniye bekler
    Then instulearn logosunun gorunur oldugunu dogrular
    And sayfa title degerinin "Home | InstuLearn" oldugunu dogrular