Feature: Kullanıcının güvenli şekilde sistemden çıkış yapabilmesi

  Background:
    Given  kullanici_InstuLern_anasayfaya_gider
    When Kullanıcı "Instructor" olarak login olur


  Scenario: Dashboard sayfasında Logout linki görünür ve aktif
    And Kullanici sol side barda Logout gorunene kadar sayfayi asagi surukler
    Then Dashboard sayfasında Logout linki görünür olmalı
    And Dashboard sayfasında Logout linki tıklanabilir olmalı

  Scenario: Dashboard sayfasından başarılı şekilde Logout olunabilmeli
    When Kullanıcı Dashboard sayfasındaki Logout linkine tıklar
    Then Kullanıcı sistemden başarıyla çıkış yapabilmeli


  Scenario: Anasayfada profil ikonuna tıklanınca Logout linki görünür ve aktif olmalı
    Given Kullanici Header bolumundeki "Home" linkine tiklar
    When Kullanıcı header bölümündeki kullanıcı adına tıklar
    Then Dropdown içinde "Logout" linki görünür olmalı
    And Dropdown içinde "Logout" linki tiklanabilir olmalı

  Scenario: Profil menüsünden başarılı şekilde Logout olunabilmeli
    Given Kullanici Header bolumundeki "Home" linkine tiklar
    When Kullanıcı header bölümündeki kullanıcı adına tıklar
    And Kullanıcı Dropdown icindeki "Logout" linkine tıklar
    Then Kullanıcı sistemden başarıyla çıkış yapabilmeli
