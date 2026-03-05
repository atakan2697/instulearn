
Feature: US033 courses testleri

Background:
      Given kullanici "instulearnUrl" anasayfaya gider
      When login butonuna tıklanır
      Then email alanina kayitli email girilir
      Then password alanina "gecerliPassword" girilir
      And login butonuna tiklanir

  Scenario: TC01 anasayfa üzerindeki Courses linki

    Given courses linki görünür ve aktif olmali
    When courses linkine tıklanır
    And courses texti görüntülenmelidir

  Scenario: TC02 search textbox ve buton kontrolu

    Given courses linkine tıklanır
    When search textbox görünür ve aktif olmalı
    And search butonu görünür ve aktif olmalı

  Scenario: TC03 filtreleme islemleri

    Then kullanici 2 saniye bekler
    Given courses linkine tıklanır
    Then kullanici 2 saniye bekler
    When download görünür ve aktif olmalı
    Then download butonuna tiklanir
    And sayfada tekrar scrool islemi yapilir
    Then kullanici 1 saniye bekler

  Scenario: TC04 kurs kart bilgilerini goruntuleme

    Then kullanici 2 saniye bekler
    Given courses linkine tıklanır
    Then download butonuna tiklanir
    And sayfada tekrar scrool islemi yapilir
    Then kullanici 1 saniye bekler
    Given Listelenen kurs kartlari görünür olmalı
    And secilen kurs kartında fiyat, tarih, ders adi ve instructor bilgileri görünür olmalıdır
    And kullanici 2 saniye bekler


  Scenario: TC05 kurs detay sayfasına yönlendirme

    Then kullanici 2 saniye bekler
    Given courses linkine tıklanır
    Then download butonuna tiklanir
    And sayfada tekrar scrool islemi yapilir
    Then kullanici 1 saniye bekler
    When ilk kurs kartına tıklar
    Then kurs detay sayfasına yönlendirme yapar
    When kurs kartında add to card ve buy now seçeneği varsa görünür ve aktif olmalıdır
    When about this course görünür ve aktif olmalıdır
    Then comments alanına tıklanarak yorum yazılmalıdır
    When post comments butonuna tıklanır
    Then profil butonuna tıklanır
    And instructor profil sayfası görünür olmalıdır



  Scenario: TC06 kurs satın alma işlemi

    When kullanıcı instulearn website logosuna tıklar
    And profil simgesinin üzerine gelip logout butonuna tıklar
    Then register butonuna tiklar yeni bir instructor hesabı oluşturur
    And courses linkine tıklanır
    Then download butonuna tiklanir
    And sayfada scrool islemi yapılır
    When ilk kurs kartına tıklar
    And kurs detay sayfasına yönlendirme yapar
    When buy now butonuna tıklanr
    And stripe butonuna tıklanır
    And start payment butonuna tıklanır
    Then e-posta alanına gecerli mail adresi girilir
    And kart bilgileri alanına gecerli kart bilgileri girilir
    When kart sahibi adı alanına gecerli bilgiler girilir
    And güvenli ödeme işlemine tıklanır
    Then telefon numarası bilgileri girlir
    When öde butonuna tıklanır
    And ödemeniz başarıyla tamamlandı texti görüntülenmelidir




