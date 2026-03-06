


Feature: US036, Kayitli bir kullanici olarak sitenin bilgilerinin ve yorumlarinin bulundugu
  guncel bilgilere erisebilecegim bir blog sayfasinin olmasini istiyorum


  Scenario: TC01 Anasayfada Blog Linki Gorunurluk ve Aktivite Kontrolu
    Given kullanici "instulearnUrl" anasayfaya gider
    And kullanici login butonuna basar ve admin olarak giris yapar
    When  blog linkinin gorunur ve tiklanabilir oldugunu dogrular


  Scenario: TC02 Blog Sayfasi Baslik Kontrolu
    Given kullanici "instulearnUrl" anasayfaya gider
    And kullanici login butonuna basar ve admin olarak giris yapar
    When kullanici blog linkine tiklar
    Then blog sayfasina yonlendirildigini sayfanin ust kismindan kontrol eder

  Scenario: TC03 Search TextBox ve Search Buton Görünürlük Kontrolü
    Given kullanici "instulearnUrl" anasayfaya gider
    And kullanici login butonuna basar ve admin olarak giris yapar
    When kullanici blog linkine tiklar
    When Search textbox alanını kontrol eder
    Then Search butonunu kontrol eder

  Scenario: TC04 Blog İçinde Anahtar Kelime ile Arama (Pozitif)
    Given kullanici "instulearnUrl" anasayfaya gider
    And kullanici login butonuna basar ve admin olarak giris yapar
    When kullanici blog linkine tiklar
    Then Search textbox’a geçerli bir anahtar kelime girer
    And Search butonuna tıklar

  Scenario: TC05 Geçersiz Anahtar Kelime ile Arama
    Given kullanici "instulearnUrl" anasayfaya gider
    And kullanici login butonuna basar ve admin olarak giris yapar
    When kullanici blog linkine tiklar
    Then Search textbox’a geçersiz bir anahtar kelime girer
    And Search butonuna tıklar

  Scenario: TC06 Kategoriye Göre Blog Filtreleme
    Given kullanici "instulearnUrl" anasayfaya gider
    And kullanici login butonuna basar ve admin olarak giris yapar
    When kullanici blog linkine tiklar
    Then Herhangi bir kategori seçer


  Scenario: TC07 Kategori Seçildiğinde İçerik Yoksa Mesaj Gösterimi
    Given kullanici "instulearnUrl" anasayfaya gider
    And kullanici login butonuna basar ve admin olarak giris yapar
    When kullanici blog linkine tiklar
    Then Herhangi bir kategori seçer
    And Icerik yoksa mesaj gosterimi

  Scenario: TC08 Blog Detay Sayfası Bilgi Kontrolü
    Given kullanici "instulearnUrl" anasayfaya gider
    And kullanici login butonuna basar ve admin olarak giris yapar
    When kullanici blog linkine tiklar
    And blog listesi gorunur ve herhangi bir blog secilir

  Scenario: TC09 Bloga Yorum Yapma (Pozitif)
    Given kullanici "instulearnUrl" anasayfaya gider
    And kullanici login butonuna basar ve admin olarak giris yapar
    When kullanici blog linkine tiklar
    Then blog listesi gorunur ve herhangi bir blog secilir
    And secilen blogun yorum alanina gecerli yorum girilir
    And  post comment butonuna tiklanir

  Scenario: TC10 Boş Yorum Gönderme Kontrolü
    Given kullanici "instulearnUrl" anasayfaya gider
    And kullanici login butonuna basar ve admin olarak giris yapar
    When kullanici blog linkine tiklar
    Then blog listesi gorunur ve herhangi bir blog secilir
    And secilen blogun yorum alani bos birakilir
    And  post comment butonuna tiklanir


  Scenario: TC11 Secilen bloglarin tarih,konu,icerik,paylasan kisi bilgileri gorunur olmali
    Given kullanici "instulearnUrl" anasayfaya gider
    And kullanici login butonuna basar ve admin olarak giris yapar
    When kullanici blog linkine tiklar
    When blog listesi gorunur ve herhangi bir blog secilir
    Then blogun paylasildigi tarihin gorunurlugunu kontrol eder
    Then blogun konusunun gorunurlugunu kontrol eder
    And blogun iceriginin gorunurlugunu kontrol eder
    And blogu paylasan kisinin gorunurlugunu kontrol eder


