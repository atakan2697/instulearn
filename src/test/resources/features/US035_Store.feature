@US035
Feature: US_035 - Store linki

  Scenario: TC_01 - Store linkinin gorunurluk ve yonlendirme kontrolu
    Given kullanici "instulearnUrl" anasayfaya gider
    And kullanici 2 saniye bekler
    Then Store linkinin gorunur oldugunu dogrular
    When Store linkine tiklar
    Then Products sayfasinin acildigini dogrular

  Scenario: TC_02 - Products sayfasinda filtreleme ve arama alanlarinin kontrolu

    Given kullanici "instulearnUrl" anasayfaya gider
    And kullanici 2 saniye bekler
    When Store linkine tiklar
    Then Products sayfasinin acildigini dogrular
    And Search textbox ve Search butonunun gorunur ve aktif oldugunu dogrular
    And Filtreleme bolumunun gorunur oldugunu dogrular
    When Urun secmeden filtreleme uygular
    Then Filtreleme sonrasi urun listesinin guncellendigini dogrular

  Scenario: TC_03 - Secilen urun detaylarinin goruntulenmesi
    Given kullanici "instulearnUrl" anasayfaya gider
    And Store linkine tiklar
    Then Products sayfasinin acildigini dogrular
    When Products sayfasinda listelenen urunlerden biri secilir
    Then Secilen urune ait fiyat bilgisinin gorunur oldugu kontrol edilir
    And Satici bilgisinin gorunur oldugu kontrol edilir
    And Urun adi ve description bilgilerinin goruntulendigi dogrulanir
    And Urun detay sayfasinda puanlama rating alaninin gorunur oldugu dogrulanir
    And Urunle ilgili yorum yapilabilen alanin gorunur oldugu dogrulanir

  Scenario: TC04 Kullanici urun satin alma ve odeme adimlarini tamamlayabilmelidir
    Given kullanici anasayfaya gider
    When arda valid bilgilerle login olur
    And kullanici Store linkine tiklar
    And kullanici ilk urune tiklar
    And kullanici Buy Now butonuna tiklar
    And kullanici Checkout butonuna tiklar
    And kullanici Stripe odeme yontemini secer
    And kullanici Start Payment butonuna tiklar
    And kullanici stripe odeme bilgilerini doldurur
    Then kullanici Ode butonuna tiklar

