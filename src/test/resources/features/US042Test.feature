
Feature: US042 - kurslarımın group yonetebilecegim bir sayfa olması

  Scenario: TC_01 My purchases linki görünür ve aktif olmalı

    Given kullanici "instulearnUrl" anasayfaya gider
    When kullanici login butonuna basar ve student olarak giris yapar
    When Course menusunun gorunur ve tiklanabilir oldugu dogrulanir
    When kullanici Course menusunu tıklar
    Then "My purchases" linki görünür ve tıklanabilir olduğu doğrulanır


  Scenario: TC_02 Secilen kursun faturası görüntülenebilmesi
    Given kullanici "instulearnUrl" anasayfaya gider
    When kullanici login butonuna basar ve student olarak giris yapar
    When kullanici Course menusunu tıklar
    And "My purchases" linkine tıklar
    And Listeden ilk kursu seçer
    Then Kurs faturası görüntülenebilmeli










