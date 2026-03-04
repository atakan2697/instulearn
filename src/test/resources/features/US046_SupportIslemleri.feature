
Feature: US046 support testleri

  Background:
    Given kullanici "instulearnUrl" anasayfaya gider
    When login butonuna tıklanır
    Then email alanina kayitli student maili girilir
    Then password alanina "gecerliPassword" girilir
    And login butonuna tiklanir

  Scenario: TC01 sidebar support menü

    Given sidebarda support linkine tıklanır
    When new linki görünür ve aktif olmalıdır
    Then courses support linki görünür ve aktif olmalıdır
    And tickets linki görünür ve aktif olmalıdır
  @gg
  Scenario: TC02 new linki ile destek talebi oluşturma

    Given sidebarda support linkine tıklanır
    When new linkine tıklanır
    And subject alanına tıklanır ve konu girilir
    When type alanına tıklanır ve platform support secilir
    And department alanına tıklanır ve content secilir
    Then message alanına tıklanır ve mesaj yazılır
    And send message butonuna tıklanır

