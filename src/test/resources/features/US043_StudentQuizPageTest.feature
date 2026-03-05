@regression
Feature: US_043 Ogrenci Quiz Sayfasi Kontrolu


  Background: Kullanıcı sisteme giriş yapmış olmalıdır
          Given kullanici "instulearnUrl" anasayfaya gider
          When Kullanici sisteme "login" olur


  @Us_43_TC01
  Scenario: Dashboard üzerindeki alt menu linklerinin kontrolü
          Given Kullanici dashboard alt menusune tiklar
          And Kullanici Quizzes menusune tiklar
          Then linklerin gorunur ve aktif oldugunu dogrular

  @Us_43_TC02
  Scenario: My Results menüsü fonksiyonların kontrolü
          Given Kullanici "Quizzes" menusunden "My Results" linkine tiklar
          Then "My Results" sayfasinin acildigini dogrular
          And Kullanici sinav istatistiklerini goruntuler
          When Kullanici sinav sonuclarini filtreler ve sonucu dogrular


  @Us_43_TC03
  Scenario: Not Participated menüsü fonksiyonların kontrolü
          Given Kullanici "Quizzes" menusunden "Not Participated" linkine tiklar
          Then "Not Participated" sayfasinin acildigini dogrular
          And Kullanici henuz girilmemis sinavlari iceren listeyi goruntuler
          When Kullanici sinav sonuclarini filtreler ve sonucu dogrular
