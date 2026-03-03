Feature: Organizasyon slider ve kurs secimi


  @US15
  Scenario: TC01 Kullanici organizasyon sliderini kullanabilmeli

    Given kullanici "instulearnUrl" anasayfaya gider
    When Kullanici organizations bolumune scroll yapar
    Then all organizations butonu gorunur ve aktif olmali
    When Kullanici son slider butonuna tiklar
    And Kullanici "6". organizasyon kursuna tiklar
    And Kullanici sayfada kurs detaylarini goruntuler