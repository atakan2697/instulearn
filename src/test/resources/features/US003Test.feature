@wip3
Feature: US03 - Anasayfa body alanı kontrolleri

  Scenario: TC_01 Anasayfa body bölümündeki başlık, search box ve search buton kontrolü
    Given kullanici "instulearnUrl" anasayfaya gider
    When Sayfa tamamen yüklenir
    Then Anasayfa body bölümünde "Transform Your Future with InstuLearn..." başlığı görünür olmalı
    And Anasayfa body bölümünde search box görünür ve aktif olmalı
    And Search butonu görünür ve aktif olmalı