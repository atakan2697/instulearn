Feature: Instructors Sayfası Fonksiyonel Testleri

  Background:
    Given kullanici_InstuLern_anasayfaya_gider

  Rule: Kullanici Student olarak login olur

    Scenario: TC_001 Anasayfada Instructors linki görünür ve aktif olmalı
      When Kullanıcı "Student" olarak login olur
      Then Instructors linki görünür olmalı
      And Instructors linki tıklanabilir olmalı

    Scenario: TC_002 Instructors linkine tıklandığında sayfa başlığı görüntülenmeli
      When Kullanıcı "Student" olarak login olur
      Then Kullanici Instructors linkine tıklar
      Then Sayfada Instructors basligi görüntülenmeli

    Scenario: TC_003 Instructors sayfasında arama alanları görünür ve aktif olmalı
      When Kullanıcı "Student" olarak login olur
      Then Kullanici Instructors linkine tıklar
      Then Search textbox görünür olmalı
      And Search textbox aktif olmalı
      And Search butonu görünür olmalı
      And Search butonu aktif olmalı

    Scenario: TC_004 Instructor seçmeden önce kategori seçilebilmeli
      When Kullanıcı "Student" olarak login olur
      Then Kullanici Instructors linkine tıklar
      Then Categories basligi altinda kategoriler görünür olmalı
      And Categories basligi altinda kategoriler aktif olmalı
      When Kullanıcı "Health And Fitness4" adindaki kategoriyi seçer
      Then Instructorlar seçilen kategoriye gore filtrelenmeli

    Scenario: TC_005 Seçilen instructor bilgileri görüntülenmeli
      When Kullanıcı "Student" olarak login olur
      Then Kullanici Instructors linkine tıklar
      When Kullanıcı "Health And Fitness4" adindaki kategoriyi seçer
      Then Instructor fiyat bilgisi görünür olmalı
      And Instructor ders adı görünür olmalı
      And Instructor beğeni bilgisi görünür olmalı


    Scenario: TC_006 Instructor için randevu talebi başarıyla oluşturulabilmeli
      When Kullanıcı "Student" olarak login olur
      Then Kullanici Instructors linkine tıklar
      And Kullanıcı "1". siradaki instructori seçer
      When Kullanıcı "2026-03-19" tarihini secer
       # tarih daha once reserve edilmisse testi baslatmadan once tarihi degistiriniz
      And Kullanıcı ilk zaman araligini secer
      And Kullanıcı meeting Type olarak "Online" secer
      And Kullanici Reserve a Meeting butonuna tiklar
      And Kullanici Checkout butonuna tiklar
      When Kullanici odeme turu olarak stripe secer
      And Kullanici Start Payment butonuna tiklar
      Then Kullanici eposta olarak "test@gmail.com" girer
      And Kullanici odeme yontemi formunu doldurur
      And Kullanici Ode butonuna tiklar
      Then Congratulations mesajı görüntülenmeli


    Scenario: TC_007 My Panel butonu görünür ve aktif olmali
      When Kullanıcı "Student" olarak login olur
      Then Kullanici Instructors linkine tıklar
      And Kullanıcı "1". siradaki instructori seçer
      When Kullanıcı "2026-03-26" tarihini secer
       # tarih daha once reserve edilmisse testi baslatmadan once tarihi degistiriniz
      And Kullanıcı ilk zaman araligini secer
      And Kullanıcı meeting Type olarak "Online" secer
      And Kullanici bir aciklama girer
      And Kullanici Reserve a Meeting butonuna tiklar
      And Kullanici Checkout butonuna tiklar
      When Kullanici odeme turu olarak stripe secer
      And Kullanici Start Payment butonuna tiklar
      Then Kullanici eposta olarak "test@gmail.com" girer
      And Kullanici odeme yontemi formunu doldurur
      And Kullanici Ode butonuna tiklar
      Then My Panel butonu görünür olmalı
      And My Panel butonu tıklanabilir olmalı
      And My panel butonuna tiklayinca Events sayfasina gectigi dogrulanir

  Rule:  Kullanici Instructor olarak login olur

    Scenario: TC_008 Anasayfada Instructors linki görünür ve aktif olmalı
      When Kullanıcı "Instructor" olarak login olur
      Then Instructors linki görünür olmalı
      And Instructors linki tıklanabilir olmalı

    Scenario: TC_009 Instructors linkine tıklandığında sayfa başlığı görüntülenmeli
      When Kullanıcı "Instructor" olarak login olur
      Then Kullanici Instructors linkine tıklar
      Then Sayfada Instructors basligi görüntülenmeli

    Scenario: TC_010 Instructors sayfasında arama alanları görünür ve aktif olmalı
      When Kullanıcı "Instructor" olarak login olur
      Then Kullanici Instructors linkine tıklar
      Then Search textbox görünür olmalı
      And Search textbox aktif olmalı
      And Search butonu görünür olmalı
      And Search butonu aktif olmalı

    Scenario: TC_011 Instructor seçmeden önce kategori seçilebilmeli
      When Kullanıcı "Instructor" olarak login olur
      Then Kullanici Instructors linkine tıklar
      Then Categories basligi altinda kategoriler görünür olmalı
      And Categories basligi altinda kategoriler aktif olmalı
      When Kullanıcı "Web Design" adindaki kategoriyi seçer
      Then Instructorlar seçilen kategoriye gore filtrelenmeli

    Scenario: TC_012 Seçilen instructor bilgileri görüntülenmeli
      When Kullanıcı "Instructor" olarak login olur
      Then Kullanici Instructors linkine tıklar
      Then Instructor fiyat bilgisi görünür olmalı
      And Instructor ders adı görünür olmalı
      And Instructor beğeni bilgisi görünür olmalı


    Scenario: TC_013 Instructor için randevu talebi başarıyla oluşturulabilmeli
      When Kullanıcı "Instructor" olarak login olur
      Then Kullanici Instructors linkine tıklar
      And Kullanıcı "1". siradaki instructori seçer
      When Kullanıcı "2026-03-19" tarihini secer
       # tarih daha once reserve edilmisse testi baslatmadan once tarihi degistiriniz
      And Kullanıcı ilk zaman araligini secer
      And Kullanıcı meeting Type olarak "Online" secer
      And Kullanici Reserve a Meeting butonuna tiklar
      And Kullanici Checkout butonuna tiklar
      When Kullanici odeme turu olarak stripe secer
      And Kullanici Start Payment butonuna tiklar
      Then Kullanici eposta olarak "test@gmail.com" girer
      And Kullanici odeme yontemi formunu doldurur
      And Kullanici Ode butonuna tiklar
      Then Congratulations mesajı görüntülenmeli

    Scenario: TC_014 My Panel butonu görünür ve aktif olmalı
      When Kullanıcı "Instructor" olarak login olur
      Then Kullanici Instructors linkine tıklar
      When Kullanıcı "2026-03-17" tarihini secer
      # tarih daha once reserve edilmisse testi baslatmadan once tarihi degistiriniz
      And Kullanıcı ilk zaman araligini secer
      And Kullanıcı meeting Type olarak "Online" secer
      And Kullanici Reserve a Meeting butonuna tiklar
      And Kullanici Checkout butonuna tiklar
      When Kullanici odeme turu olarak stripe secer
      And Kullanici Start Payment butonuna tiklar
      Then Kullanici eposta olarak "test@gmail.com" girer
      And Kullanici odeme yontemi formunu doldurur
      And Kullanici Ode butonuna tiklar
      Then My Panel butonu görünür olmalı
      And My Panel butonu tıklanabilir olmalı
      And My panel butonuna tiklayinca Events sayfasina gectigi dogrulanir