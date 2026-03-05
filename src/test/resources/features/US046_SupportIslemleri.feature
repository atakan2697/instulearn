@gg
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

  Scenario: TC02 new linki ile destek talebi oluşturma

    Given sidebarda support linkine tıklanır
    When new linkine tıklanır
    And subject alanına tıklanır ve konu girilir
    When type alanına tıklanır ve platform support secilir
    And department alanına tıklanır ve content secilir
    Then message alanına tıklanır ve mesaj yazılır
    And send message butonuna tıklanır

  Scenario: TC03 courses support linki

    Given sidebarda support linkine tıklanır
    When courses support linkine tıklanır
    Then destek özet boardları görünür olmalıdır
    And mesaj gecmisi listesi görünür olmalıdır

  Scenario: TC04 ticketı görüntüleyebilme

    Given sidebarda support linkine tıklanır
    When tickets linkine tıklanır
    And message history bölümündeki mesaja tıklanır
    Then reply to the conversation bölümündeki message bölümü doldurulur
    And send message butonuna tıklanır
    Then açılan destek isteğini kapatmak için close request butonuna tıklanır
    And status bölümünün closed olduğu doğrulanır

  Scenario: TC05 tickets listesinde ticket bilgilerini görüntüleyebilme

    Given sidebarda support linkine tıklanır
    When tickets linkine tıklanır
    And kullanici 1 saniye bekler
    Then açılan ticketlar listede görüntülenir
    And kullanici 2 saniye bekler
    Then title bölümü görüntülenir
    And updated date bölümü görüntülenir
    Then department bölümü görüntülenir
    And status bölümü görüntülenir
    And kullanici 1 saniye bekler






