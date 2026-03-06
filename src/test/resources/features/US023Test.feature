Feature: US023 - Kurs paketi olusturulabilmesi ve yonetilebilmesi

  Scenario: TC_01 New linki görünür ve aktif olmalı

    Given kullanici "instulearnUrl" anasayfaya gider
    When kullanici login butonuna basar ve ınstructor olarak giris yapar
    When Course Bundles menusunun gorunur ve tiklanabilir oldugu dogrulanir
    When kullanici Course Bundles menusunu tıklar
    Then New linki görünür ve tıklanabilir olduğu doğrulanır

    Scenario: TC_02/TC_03 Basic Info icin Gerekli Form bilgileri doldurulması ve alt butonların gorunurluk ve aktiflik dogrulanmasi

      Given kullanici "instulearnUrl" anasayfaya gider
      When kullanici login butonuna basar ve ınstructor olarak giris yapar
      When kullanici Course Bundles menusunu tıklar
      When New linkine tıklanması
      And Form bilgilerinin doldurulması
      And  Previous butonunun gorunur ve tiklanabilir oldugu dogrulanir
      And  Next butonunun gorunur ve tiklanabilir oldugu dogrulanir
      And  Send for Review butonunun gorunur ve tiklanabilir oldugu dogrulanir
      And  Save as Draft butonunun gorunur ve tiklanabilir oldugu dogrulanir
      Then Next butonunun tıklanması

      Scenario: TC_04 Extra Information icin form bilgileri doldurulması

        Given kullanici "instulearnUrl" anasayfaya gider
        When kullanici login butonuna basar ve ınstructor olarak giris yapar
        When kullanici Course Bundles menusunu tıklar
        When New linkine tıklanması
        And Form bilgilerinin doldurulması
        Then Next butonunun tıklanması
        Then  Extra Information form bilgilerinin doldurulması
        Then Extra Information Next butonunun tıklanması


        Then Pricing basligi altında odeme formu doldurulması
        Then Odeme planı olusturulması
        Then Pricing Next butonunun tıklanması


















