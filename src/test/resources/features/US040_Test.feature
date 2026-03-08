Feature: US040 Dashboard sidebar kontrolu

  Scenario: TC01 Student dashboard sidebar linklerinin gorunurluk ve tiklanabilirlik kontrolu
    Given kullanici anasayfaya gider
    When arda valid bilgilerle login olur
    Then Dashboard sayfasi acilmis olmali
    And Dashboard sidebar linkleri gorunur olmalidir
    And Dashboard sidebar linkleri tiklanabilir olmalidir

  Scenario: TC02 Dashboard uzerinde etkinlik ve bilgi kartlarinin goruntulenmesi
    Given kullanici anasayfaya gider
    When arda valid bilgilerle login olur
    Then Dashboard sayfasi acilmis olmali
    And View All Events linki gorunur ve aktif olmalidir
    And Dashboard bilgi karti linkleri gorunur olmalidir
    And Dashboard bilgi karti linkleri tiklanabilir olmalidir

  Scenario: TC03 Dashboard aylik ogrenme tablosunun goruntulenmesi
    Given kullanici anasayfaya gider
    When arda valid bilgilerle login olur
    Then Dashboard sayfasi acilmis olmali
    And Learning Statistics bolumu gorunur olmalidir
    And Aylik ogrenme grafigi gorunur olmalidir