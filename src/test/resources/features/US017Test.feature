Feature: US_017 Kayitli kullanici sifresini unuttugunda reset islemi yapabilmeli

  @wip
  Scenario: TC_US017_001 Forgot your password linki goruntulenmeli ve forget password sayfasina yonlendirmeli

    Given kullanici login sayfasina gider
    Then forgot your password linki gorunur ve aktif olmali
    When forgot your password linkine tiklar
    Then forget password sayfasina yonlendirilmeli
    And password recovery yazisi gorunur olmali

  @wip
  Scenario: TC_US017_002 Kayitli email ile password reset talebi gonderme

    When kullanici login sayfasina gider
    When forgot your password linkine tiklar
    Then forget password sayfasina yonlendirilmeli

    And email textbox gorunur ve aktif olmali
    And reset password butonu gorunur ve aktif olmali

    When kayitli email olarak "wisequarter01@instulearn.com" girilir
    And reset password butonuna tiklanir
    Then basari mesaji goruntulenmeli ve reset email gonderildigi yazmali


  @wip
  Scenario: TC_US017_003 Password recovery sayfasindan login sayfasina geri donus

    Given kullanici login sayfasina gider
    When forgot your password linkine tiklar
    Then forget password sayfasina yonlendirilmeli

    When login sayfasina donus linkine tiklar
    Then kullanici login sayfasina yonlendirilir