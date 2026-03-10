
     Feature: US031, Kayitli bir kullanici olarak dashboard sayfasinda profil bilgilerini
     gorup yonetebilecegi bir alan olmasinin test caseleri

    Background:
      * kullanici "instulearnUrl" anasayfaya gider
      * kullanici login butonuna basar ve admin olarak giris yapar

    Scenario: TC01 Dashboard sidebarda Settings linki gorunurlugu ve aktifligi
      When slider alanini kontrol eder ve settings linkinin gorunur oldugunu kontrol eder
      Then Settings linkinin tiklanabilirligini kontrol eder

    Scenario: TC02 Basic Information basarili guncelleme
      When kullanici settings sayfasinda olur
      When basic information sayfasinda zorunlu alanlari gecerli verilerle doldurur
      And kaydedip ilerler

    Scenario: TC03 Basic Information zorunlu alani bos birakma
      When kullanici settings sayfasinda olur
      When basic information sayfasinda zorunlu alanlardan birini bos birakir
      And degisiklikler kaydedilir
      And bos birakilan alan icin uyari verilir

    Scenario: TC04 Images Fotoğraf Yükleme (Pozitif)
      When kullanici settings sayfasinda olur
      When basic information sayfasinda zorunlu alanlari gecerli verilerle doldurur
      And kaydedip ilerler
      And Desteklenen formatta bir fotograf yuklenir
      And kaydedip ilerler

    Scenario: TC05 Images Geçersiz Dosya Formatı
      When kullanici settings sayfasinda olur
      When basic information sayfasinda zorunlu alanlari gecerli verilerle doldurur
      And kaydedip ilerler
      And Desteklenmeyen formatta bir fotograf yuklenir
      And Hata mesajının görüntülendiği doğrulanır

    Scenario: TC06 About Bilgilerinin Kaydedilmesi
      When kullanici settings sayfasinda olur
      When basic information sayfasinda zorunlu alanlari gecerli verilerle doldurur
      And kaydedip ilerler
      And Desteklenen formatta bir fotograf yuklenir
      And About kismina bilgiler girilir
      And kaydedip ilerler

       Scenario: TC07 About Karakter Limit Asimi (Gelistirilebilir ozellik)
         When kullanici settings sayfasinda olur
         When basic information sayfasinda zorunlu alanlari gecerli verilerle doldurur
         And kaydedip ilerler
         And Desteklenen formatta bir fotograf yuklenir
         And About kismina karakter asimi bilgiler girilir
         And Hata mesajının görüntülendiği doğrulanır

       Scenario: TC08 About Bilgilerinin Kaydedilmesi
         When kullanici settings sayfasinda olur
         When basic information sayfasinda zorunlu alanlari gecerli verilerle doldurur
         And kaydedip ilerler
         And Desteklenen formatta bir fotograf yuklenir
         And About kismina bilgiler girilir
         And kaydedip ilerler
         And Education'a bilgiler girilir
         And kaydedip ilerler

         Scenario: TC09 Experience Bilgilerinin kaydedilmesi
           When kullanici settings sayfasinda olur
           When basic information sayfasinda zorunlu alanlari gecerli verilerle doldurur
           And kaydedip ilerler
           And Desteklenen formatta bir fotograf yuklenir
           And About kismina bilgiler girilir
           And kaydedip ilerler
           And Education'a bilgiler girilir
           And kaydedip ilerler
           And Experience bilgileri girilir
           And kaydedip ilerler

       Scenario: TC10 Skills Topic secer
         When kullanici settings sayfasinda olur
         When basic information sayfasinda zorunlu alanlari gecerli verilerle doldurur
         And kaydedip ilerler
         And Desteklenen formatta bir fotograf yuklenir
         And About kismina bilgiler girilir
         And kaydedip ilerler
         And Education'a bilgiler girilir
         And kaydedip ilerler
         And Experience bilgileri girilir
         And kaydedip ilerler
         And Skills Topicsleri secer
         And kaydedip ilerler

       Scenario: TC11 Identity & financial bilgileri girer
         When kullanici settings sayfasinda olur
         When basic information sayfasinda zorunlu alanlari gecerli verilerle doldurur
         And kaydedip ilerler
         And Desteklenen formatta bir fotograf yuklenir
         And About kismina bilgiler girilir
         And kaydedip ilerler
         And Education'a bilgiler girilir
         And kaydedip ilerler
         And Experience bilgileri girilir
         And kaydedip ilerler
         And Skills Topicsleri secer
         And kaydedip ilerler
         And Select Account Type butonun tiklanabilir olmasi
         And kaydedip ilerler


       Scenario: TC12 Zoom Api bilgilerini girer
         When kullanici settings sayfasinda olur
         When basic information sayfasinda zorunlu alanlari gecerli verilerle doldurur
         And kaydedip ilerler
         And Desteklenen formatta bir fotograf yuklenir
         And About kismina bilgiler girilir
         And kaydedip ilerler
         And Education'a bilgiler girilir
         And kaydedip ilerler
         And Experience bilgileri girilir
         And kaydedip ilerler
         And Skills Topicsleri secer
         And kaydedip ilerler
         And kaydedip ilerler
         And Zoom api bilgilerini girer
         And kaydedip ilerler

       Scenario: TC13 Extra Information bilgilerini girer
         When kullanici settings sayfasinda olur
         When basic information sayfasinda zorunlu alanlari gecerli verilerle doldurur
         And kaydedip ilerler
         And Desteklenen formatta bir fotograf yuklenir
         And About kismina bilgiler girilir
         And kaydedip ilerler
         And Education'a bilgiler girilir
         And kaydedip ilerler
         And Experience bilgileri girilir
         And kaydedip ilerler
         And Skills Topicsleri secer
         And kaydedip ilerler
         And kaydedip ilerler
         And Zoom api bilgilerini girer
         And kaydedip ilerler
         And Extra Information bilgilerini girer
         And degisiklikleri kaydeder

       Scenario: TC14 Olusturulan hesabi siler
         When kullanici settings sayfasinda olur
         When basic information sayfasinda zorunlu alanlari gecerli verilerle doldurur
         And kaydedip ilerler
         And Desteklenen formatta bir fotograf yuklenir
         And About kismina bilgiler girilir
         And kaydedip ilerler
         And Education'a bilgiler girilir
         And kaydedip ilerler
         And Experience bilgileri girilir
         And kaydedip ilerler
         And Skills Topicsleri secer
         And kaydedip ilerler
         And kaydedip ilerler
         And Zoom api bilgilerini girer
         And kaydedip ilerler
         And Extra Information bilgilerini girer
         And degisiklikleri kaydeder
         And Delete account yaparak hesabi siler



