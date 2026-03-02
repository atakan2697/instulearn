Feature: Financial Management

  Scenario: Financial menusunun ve alt linklerinin gorunurluk ve aktiflik dogrulanmasi

    Given kullanici "instulearnUrl" anasayfaya gider
    When kullanici login butonuna basar ve instructor olarak giris yapar

    When kullanici dashboard sayfasindaki sidebar’da bulunan Financial menusunu goruntuler
    Then Financial menusunun gorunur ve tiklanabilir oldugu dogrulanir

    When kullanici Financial menusunu expand eder
    Then Sales Report linkinin gorunur ve tiklanabilir oldugu dogrulanir
    And Financial Summary linkinin gorunur ve tiklanabilir oldugu dogrulanir
    And Payout linkinin gorunur ve tiklanabilir oldugu dogrulanir
    And Charge Account linkinin gorunur ve tiklanabilir oldugu dogrulanir
    And Subscribe linkinin gorunur ve tiklanabilir oldugu dogrulanir



  Scenario: Sales Report sayfasinda satis verilerinin goruntulenmesi, filtrelenmesi ve duzenlenmesi

    Given kullanici "instulearnUrl" anasayfaya gider
    When kullanici login butonuna basar ve instructor olarak giris yapar

    When kullanici Financial menuden Sales Report linkine tiklar
    Then Sales statistics alaninin gorunur oldugu dogrulanir
    And sales history listesinde satis kayitlarinin goruntulendigi dogrulanir

    When kullanici filtre kriterlerini doldurur ve filtre ikonuna basar
    Then sales history listesinin filtre sonucuna gore guncellendigi dogrulanir

    When kullanici sales history’den bir kayit secer ve duzenleme islemi yapar
    And degisiklikleri kaydeder
    Then yapilan degisikligin kaydedildigi dogrulanir

    When kullanici sales history’den bir kayit secer ve silme islemi yapar
    Then kaydin listeden kaldirildigi dogrulanir



  Scenario: Financial Summary sayfasinda finansal dokuman listesinin goruntulenmesi

    Given kullanici "instulearnUrl" anasayfaya gider
    When kullanici login butonuna basar ve instructor olarak giris yapar

    When kullanici Financial menuden Financial Summary linkine tiklar
    Then financial documents listesinin gorunur oldugu dogrulanir
    And tum finansal dokuman kayitlarinin listelendigini dogrulanir




  Scenario: Kullanici cuzdanina bakiye yukler ve odeme islemi baslatilir

    Given kullanici "instulearnUrl" anasayfaya gider
    When kullanici login butonuna basar ve instructor olarak giris yapar

    When kullanici Financial menuden Charge Account linkine tiklar ve cuzdan bakiyesini kaydeder
    And odeme yontemini secer, yuklenecek tutari girer ve islemi onaylar
    And kullanici 5 saniye bekler
    Then secilen odeme yontemine uygun islem ekraninin acildigi dogrulanir

    When odeme bilgilerini doldurur
    And Pay butonuna tiklar
    And kullanici 5 saniye bekler
    Then odeme isleminin basarili oldugu dogrulanir
    And cuzdan bakiyesinin guncellendigi dogrulanir



  Scenario: Kullanici yeni plan olusturur

    Given kullanici "instulearnUrl" anasayfaya gider
    And register butonuna tiklar ve yeni bir instructor hesabi olusturur
    And kullanici sag ust kosede kendi adinin oldugu hover menuden dashboard'a tiklar

    When kullanici Financial menusunu expand eder
    And Financial menuden Subscribe linkine tiklar

    When kullanici yeni bir plan secer ve Purchase butonuna tiklar
    And odeme yontemini secer ve Start Payment butonuna basar
    When odeme bilgilerini doldurur
    And kullanici 2 saniye bekler
    And Pay butonuna tiklar
    And kullanici 5 saniye bekler
    Then odeme isleminin basarili oldugu dogrulanir
    And yeni planin aktif olarak goruntulendigi dogrulanir