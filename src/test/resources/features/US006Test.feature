
Feature: US_006 Visitor kurs bilgilerini ana sayfada goruntuleyebilmeli

  @wip2
  Scenario: TC_US006_001 Featured Courses listesi goruntulenmeli ve yonlendirme calismali
    * kullanici "instulearnUrl" anasayfaya gider
    Then featured courses bolumu gorunur olmali
    And featured courses kurs kartlari gorunur olmali
    When featured courses ilk kurs kartina tiklar
    Then kullanici kurs detay sayfasina yonlendirilmeli


  @wip2
  Scenario: TC_US006_002 Yeni kurslar kart bilgileri ve hepsini goster buton kontrolu
    * kullanici "instulearnUrl" anasayfaya gider
    Then newest courses bolumu gorunur olmali
    And newest courses kart bilgileri gorunur olmali
    And view all butonu gorunur ve tiklanabilir olmali
    When newest courses view all butonuna tiklar
    Then kullanici kurs listesi sayfasina yonlendirilmeli

  @wip2
  Scenario: TC_US006_003 Kurs karti go to card ikonu ile yonlendirme
    * kullanici "instulearnUrl" anasayfaya gider
    Then go to card ikonu gorunur ve aktif olmali
    When go to card ikonuna tiklar
    Then ilgili kurs detay sayfasi acilmali

  @wip2
  Scenario: TC_US006_004 Kurs kategorileri goruntulenmeli ve yonlendirmeli
    * kullanici "instulearnUrl" anasayfaya gider
    Then trending categories bolumu gorunur olmali
    And kategori kartlari gorunur olmali
    When herhangi bir kategoriye tiklar
    Then kategori sayfasina yonlendirilmis olmali