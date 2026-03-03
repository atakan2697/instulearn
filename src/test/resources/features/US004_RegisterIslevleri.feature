Feature: Kullanıcı Kaydı

  Background:
    Given kullanici_InstuLern_anasayfaya_gider

  Scenario: TC_001 Kayıt linkinin görünürlüğünü doğrulama
    Then Register linki görünür olmalı
    And Register linki tıklanabilir olmalı

  Scenario: TC_002 Kayıt sayfasına gitme
    When kullanıcı Register linkine tıklar
    Then Kayıt sayfası açılmalı
    And  Resim görünür olmalı


  Scenario: TC_003 SignUp butonunun görünürlüğünü doğrulama
    When kullanıcı Register linkine tıklar
    Then SignUp butonu görünür olmalı
    And SignUp butonu tıklanabilir olmalı


  Scenario: TC_004 Signup formu içerisinde 'Account type' butonları (Student,Instructor,Organization) gorunur ve secilebilir olmalı
    When kullanıcı Register linkine tıklar
    Then Account type butonları görünür olmalı
    And Account type butonları tıklanabilir olmalı

  Scenario: TC_005 Kullanici zorunlu alanlari ( Email ,Full Name, Password,  Retype Password) bos birakarak kayit olamaz
    When kullanıcı Register linkine tıklar
    Then Kullanici zorunlu alanlari doldurmadan SignUp butonuna tiklar
    Then Email zorunlu alan hatasi goruntulenmelidir
    And Full Name zorunlu alan hatasi goruntulenmelidir
    And Password zorunlu alan hatasi goruntulenmelidir
    And Password confirmation zorunlu alan hatasi goruntulenmelidir

  Scenario: TC_006 Register olabilmek icin 'I agree with terms & rules the term fielt is required.' checkBox'inin secilmesi zorunlu olmali
    When kullanıcı Register linkine tıklar
    Then kullanıcı account type olarak "Student" seçer
    And kullanıcı geçerli e-posta olarak "test@gmail.com" girer
    And kullanıcı tam ad olarak "Test User" girer
    And kullanıcı geçerli şifre olarak "Learn.123123" girer
    And kullanıcı şifreyi doğru şekilde "Learn.123123" olarak tekrar girer
    And kullanıcı şartlar ve kuralları kabul etmez
    And kullanıcı Kayıt butonuna tıklar
    Then Terms & rules alanı için zorunluluk mesajı gösterilmeli

  Scenario: TC_007 Geçersiz e-posta doğrulaması
    When kullanıcı Register linkine tıklar
    Then kullanıcı geçersiz e-posta olarak "gecersiz-email" girer
    And kullanıcı Kayıt butonuna tıklar
    Then eposta hata mesajı görüntülenmeli


  Scenario: TC_008 Şifre uyuşmazlığı doğrulaması
    When kullanıcı Register linkine tıklar
    When kullanıcı geçerli şifre olarak "12345678" girer
    And kullanıcı şifreyi yanlis şekilde "1234" olarak tekrar girer
    And kullanıcı Kayıt butonuna tıklar
    Then şifre uyuşmazlığı hatası gösterilmeli

  Scenario: TC_009 Kullanici 8 karakterden az password girerse hata mesaji gorur
    When kullanıcı Register linkine tıklar
    And Kullanici password alanina eksik olarak "1234" girer
    And kullanıcı şifreyi doğru şekilde "1234" olarak tekrar girer
    And kullanıcı Kayıt butonuna tıklar
    Then Password minimum 8 karakter hatasi goruntulenmelidir


  Scenario: TC_0010 Kayıt sayfasına gitme
      When kullanıcı Register linkine tıklar
      Then Kayıt sayfası açılmalı
      And SignUp formu görünür olmalı

  Scenario: TC_0011 Kayıt sayfasından Giriş sayfasına gitme
    When kullanıcı Register linkine tıklar
    When kullanıcı Giriş linkine tıklar
    Then Giriş sayfası açılmalı
