
Feature: US033 courses testleri

Background:
      Given kullanici "instulearnUrl" anasayfaya gider
      When login butonuna tıklanır
      And kullanici 2 saniye bekler
      Then email alanina kayitli email girilir
      And kullanici 2 saniye bekler
      Then password alanina "gecerliPassword" girilir
      And kullanici 2 saniye bekler
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


  @E2E
  Scenario: TC06

    When kullanıcı instulearn website logosuna tıklar
    And kullanici 2 saniye bekler
    And profil simgesinin üzerine gelip logout butonuna tıklar
    And kullanici 2 saniye bekler
    Then register butonuna tiklar yeni bir instructor hesabı oluşturur
    And kullanici 2 saniye bekler
    And courses linkine tıklanır
    And kullanici 2 saniye bekler
    Then download butonuna tiklanir
    And kullanici 2 saniye bekler
    And sayfada scrool islemi yapılır
    And kullanici 2 saniye bekler
    When ilk kurs kartına tıklar
    And kullanici 2 saniye bekler
    And kurs detay sayfasına yönlendirme yapar
    And kullanici 2 saniye bekler
    When buy now butonuna tıklanr
    And kullanici 2 saniye bekler
    And stripe butonuna tıklanır
    And kullanici 2 saniye bekler
    And start payment butonuna tıklanır
    And kullanici 2 saniye bekler
    Then e-posta alanına gecerli mail adresi girilir
    And kullanici 2 saniye bekler
    And kart bilgileri alanına gecerli kart bilgileri girilir
    And kullanici 2 saniye bekler
    When kart sahibi adı alanına gecerli bilgiler girilir
    And kullanici 2 saniye bekler
    And güvenli ödeme işlemine tıklanır
    Then telefon numarası bilgileri girlir
    And kullanici 2 saniye bekler
    When öde butonuna tıklanır
    And kullanici 2 saniye bekler
    And ödemeniz başarıyla tamamlandı texti görüntülenmelidir
    And kullanici 2 saniye bekler




