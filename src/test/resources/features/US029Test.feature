Feature: Marketing yonetimi  discounts and promotions

  Scenario: Marketing menusunun ve alt linklerinin gorunurluk ve tiklanabilirlik dogrulanmasi

    Given kullanici "instulearnUrl" anasayfaya gider
    And kullanici login butonuna basar ve instructor olarak giris yapar
    When kullanici Marketing menusunu expand eder
    Then Discounts linkinin gorunur ve tiklanabilir oldugu dogrulanir
    And Promotions linkinin gorunur ve tiklanabilir oldugu dogrulanir


  Scenario: Kullanici yeni kurs indirimi olusturur

    Given kullanici "instulearnUrl" anasayfaya gider
    And kullanici login butonuna basar ve instructor olarak giris yapar
    When kullanici Marketing menusunden Discounts linkine tiklar
    Then indirim olusturma alaninin gorunur oldugu dogrulanir
    When kullanici indirim icin gerekli bilgileri girer
    And Create butonuna tiklar
    And kullanici 5 saniye bekler
    Then indirimin basariyla olusturuldugu ve Discounts listesinde goruntulendigi dogrulanir


  Scenario: Instructor mevcut promosyon planini satin alir

    Given kullanici "instulearnUrl" anasayfaya gider
    And kullanici login butonuna basar ve instructor olarak giris yapar
    When kullanici Marketing menusunu expand eder
    And Promotions linkine tiklar
    Then promosyon planlarinin listelendigi dogrulanir

    When kullanici istedigi promosyon planinda Purchase butonuna tiklar
    And acilan sayfada odeme yontemini secer
    And kullanici 2 saniye bekler
    And odeme bilgilerini doldurur
    And kullanici 5 saniye bekler
    And Pay butonuna tiklar
    And kullanici 10 saniye bekler
    Then odeme isleminin basarili oldugu dogrulanir
    And secilen promosyon planinin aktif olarak goruntulendigi dogrulanir


