Feature: US040 Dashboard sidebar kontrolu

  Scenario: TC01 Student dashboard sidebar linklerinin gorunurluk ve tiklanabilirlik kontrolu
    Given kullanici anasayfaya gider
    When arda valid bilgilerle login olur
    Then Dashboard sayfasi acilmis olmali
    And Dashboard sidebar linkleri gorunur olmalidir
    And Dashboard sidebar linkleri tiklanabilir olmalidir