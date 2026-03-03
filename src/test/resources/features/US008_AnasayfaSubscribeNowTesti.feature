Feature: US008 Kullanici anasayfa body bolumunde uyelik islemlerini gerceklestirir

  Scenario: TC_01 Anasayfa body bolumunde "Subscribe Now" yazisi gorunmeli.

    Given kullanici "instulearnUrl" anasayfaya gider
    When Subsribe Now yazisi gorunene kadar sayfa asagi kaydirilir
    Then Subscribe Now yazisi goruntulenebilirligi test edilir



    Scenario: TC_02 Anasayfa body bolumunde "Subscribe Now" bolumundeki butonlar gorunur olmali
    ve tiklandiginda login sayfasina yonlendirmeli

      Given kullanici "instulearnUrl" anasayfaya gider
      When Subsribe Now yazisi gorunene kadar sayfa asagi kaydirilir
      And Subscribe Now yazisi goruntulenebilirligi test edilir
      Then Bronze bolumundeki "Purchase" butonuna tiklanir
      And Login sayfasina yonlendirdigi kontrol edilir
      And kullanici 2 saniye bekler
      And Tekrar onceki sayfaya gelinir
      Then Gold bolumundeki "Purchase" butonuna tiklanir
      And kullanici 3 saniye bekler
      And Login sayfasina yonlendirdigi kontrol edilir
      Then Tekrar onceki sayfaya gelinir
      Then Silver bolumundeki "Purchase" butonuna tiklanir
      And Login sayfasina yonlendirdigi kontrol edilir



