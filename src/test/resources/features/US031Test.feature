
  Feature: US031, Kayitli bir kullanici olarak dashboard sayfasinda profil bilgilerini
     gorup yonetebilecegi bir alan olmasinin test caseleri

    Scenario: TC01 Dashboard sidebarda Settings linki gorunurlugu ve aktifligi
      * kullanici "instulearnUrl" anasayfaya gider
      Given kullanici login butonuna basar ve admin olarak giris yapar
      When slider alanini kontrol eder ve settings linkinin gorunur oldugunu kontrol eder
      Then Settings linkinin tiklanabilirligini kontrol eder

      Scenario: TC02 Basic Information basarili guncelleme
        * kullanici "instulearnUrl" anasayfaya gider
        Given kullanici login butonuna basar ve admin olarak giris yapar
        When kullanici settings sayfasinda olur
        When basic information sayfasinda zorunlu alanlari gecerli verilerle doldurur
        And kaydedip ilerler

    Scenario: TC03 Basic Information zorunlu alani bos birakma
      * kullanici "instulearnUrl" anasayfaya gider
      Given kullanici login butonuna basar ve admin olarak giris yapar
      When kullanici settings sayfasinda olur
      When basic information sayfasinda zorunlu alanlardan birini bos birakir
      And degisiklikleri kaydeder



