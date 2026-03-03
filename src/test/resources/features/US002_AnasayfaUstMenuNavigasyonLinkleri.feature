Feature:Kullanici anasayfa ust menusundeki linkleri bulabilmeli
@wip1
  Scenario: TC_01 Site anasayfa ust menusundeki linkler
  (Categories, Home , Courses, Instructors, Store , Blog) goruntulenebilmeli

    Given kullanici "instulearnUrl" anasayfaya gider
    When categories linkinin goruntulebilir oldugunu kontrol eder
    And  home linkinin goruntulenebilir oldugunu kontrol eder
    Then courses linkinin goruntulenebilir oldugunu kontrol eder
    And instructors linkinin goruntulenebilir oldugunu kontrol eder
    Then store linkinin goruntulenebilir oldugunu kontrol eder
    And blog linkinin goruntulenebilir oldugunu kontrol eder

  Scenario: TC_02 Site anasayfa ust menusundeki Home linki aktif olmali
ve tiklandiginda ilgili sayfaya yonlendirme kontrolu

    Given kullanici "instulearnUrl" anasayfaya gider
    When home linkinin goruntulenebilir oldugunu kontrol eder
    And home linkine tiklar
    Then anasayfaya yonlendirildigi kontrol edilir


  Scenario: TC_03 Categories menusundeki linklerin aktifligi ve dogru sayfaya yonlendirmesi kontrolu
    Given kullanici "instulearnUrl" anasayfaya gider
    When categories linkine tiklar
    And acilan menude development linkinin uzerine gelinir
    And acilan yeni menude Web Development linkine tiklanir
    Then dogru sayfaya yonlendirdigi kontrol edilir