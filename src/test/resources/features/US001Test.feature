Feature: US_001 Visitor ana sayfaya erisebilmeli

  @wip
  Scenario: TC_US001_001 Visitor ana sayfaya basariyla erisir

    Given kullanici "instulearnUrl" anasayfaya gider
    When kullanici 2 saniye bekler
    Then instulearn logosunun gorunur oldugunu dogrular
    And sayfa title degerinin "Home | InstuLearn" oldugunu dogrular

  @wip
  Scenario: TC_US001_002 Visitor gecersiz path ile ana sayfaya erisemez

    When kullanici gecersiz url'e gider
    Then ana sayfa goruntulenmemelidir
    And hata sayfasi goruntulenmelidir
    And sayfa title degeri "Home | InstuLearn" olmamalidir