Feature: US_043 Ogrenci Quiz Sayfasi Kontrolu


  Background: Kullanıcı sisteme giriş yapmış olmalıdır
    Given kullanici "url" anasayfaya gider
    Then Kullanici sisteme "login" olur



  @Us_43_TC01
  Scenario: Dashboard üzerindeki alt menu linklerinin kontrolü
    Given Kullanici dashboard alt menusune tiklar
    And Kullanici Quizzes menusune tiklar
    Then linklerin gorunur ve aktif oldugunu dogrular