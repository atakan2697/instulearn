
  Feature: US006 login testleri

    Background:
      Given kullanici "instulearnUrl" anasayfaya gider

    Scenario: TC01 login butonunun görüntülenmesi

      When login butonu gorunur ve aktif olmalidir
      And kullanici 2 saniye bekler

    Scenario: TC02 login sayfası UI elementleri

      When login butonuna tıklanır
      And kullanici 1 saniye bekler
      Then sayfanın sol bölümündeki görsel görünür olmalıdır
      And kullanici 2 saniye bekler
      Then sayfanın sağ bölümünde bulunan Log in to your account texti görünür olmalıdır
      And kullanici 1 saniye bekler

    Scenario: TC03 email ve password alanlarının kontrolu

      When login butonuna tıklanır
      When login formu icindeki email textboxı gorunur ve aktif olmalidir
      And kullanici 2 saniye bekler
      Then login formu icindeki password textboxı gorunur ve aktif olmalidir
      And login formu altındaki login butonu gorunur ve aktif olmalidir
      And kullanici 2 saniye bekler


    Scenario: TC04 forgot your password sayfasina yonlendirme dogrulamasi

      When login butonuna tıklanır
      When forgot your password? linkine tiklanir
      And kullanici 2 saniye bekler
      And forgot your password sayfasina yonlendirme yaptigi dogrulanir
      And kullanici 2 saniye bekler
      Then forgot your password sayfasindaki login butonuna tiklanir
      And kullanici 2 saniye bekler
      And login sayfasinda oldugu dogrulanir
      And kullanici 1 saniye bekler


    Scenario: TC05 gecersiz bilgiler ile login denemesi

      When login butonuna tıklanır
      And email alanina gecersiz email girilir
      And password alanina "gecersizPassword" girilir
      Then login butonuna tiklanir
      And kullanici 1 saniye bekler
      And hata mesajlari dogrulanir

    Scenario: TC06 gecerli bilgiler ile basarili bir sekilde login olabilme

      When login butonuna tıklanır
      And email alanina kayitli email girilir
      And password alanina "gecerliPassword" girilir
      Then login butonuna tiklanir
      And kullanici 1 saniye bekler
      And kullanici basarili bir sekilde sisteme giris yaptigi dogrulanir








