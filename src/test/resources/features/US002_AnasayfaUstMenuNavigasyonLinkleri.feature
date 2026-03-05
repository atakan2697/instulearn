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


  Scenario Outline: TC_03 Categories menusundeki linklerin aktifligi ve dogru sayfaya yonlendirmesi kontrolu
    Given kullanici "instulearnUrl" anasayfaya gider
    When categories linkine tiklar
    And acilan menude "<ana-kategori>" linkinin uzerine gelinir
    And acilan menude "<alt-kategori>" linkine tiklar
    Then kullanici "<beklenen-url>" adresine yonlendirilmelidir

    Examples:
      | ana-kategori     | alt-kategori         | beklenen-url                   |
      | Development      | Web Development      | Web-Development                |
      | Development      | Programming Language | Programming-Language           |
      | Development      | DevOps               | DevOps                         |
      | Business         | Management           | Management                     |
      | Business         | Communications       | Communications                 |
      | Business         | Business Strategy    | Business-Strategy              |
      | Marketing        | Digital Marketing    | Digital-Marketing              |
      | Lifestyle        | Travel               | Travel                         |
      | Lifestyle        | Beauty & Makeup      | Beauty-and-Makeup              |
      | Health & Fitness | Health Coaching      | Health-and-Nutrition-Coaching  |
      | Health & Fitness | Fitness Masterclass  | Health-And-Fitness-Masterclass |

    Scenario: TC_04 Site logosunun gorunur ve aktif olmasi kontrolu

      Given kullanici "instulearnUrl" anasayfaya gider
      When anasayfa sol üst kosesinde bulunan anasayfa logosunun gorunur ve aktif oldugu kontrol edilir
      And anasayfa sol üst kosesinde bulunan anasayfa logosuna tiklanir
      Then anasayfanin yenilendigi kontrol edilir


    Scenario: TC_05 Site anasayfasindaki Card ve Notifications butonlari gorunur ve aktif olmasi kontrolu
      Given kullanici "instulearnUrl" anasayfaya gider
      When anasayfa sag ust kosesinde Card ve Notifications butonlarinin gorunur ve aktif oldugu kontrol edilir





    Scenario: TC_06 Site anasayfasindaki Search Textbox goruntulenebilmesi ve arama yapilabilmesi kontrolu
      Given kullanici "instulearnUrl" anasayfaya gider
      When anasayfa header kismindaki Search Textbox'a tiklar
      And Search Textbox kismina Web yazar ve enter'a basar
      Then arama sonucunda Web ile ilgili degerler bulundugunu kontrol eder



    Scenario: TC_07 Start learning ikonu gorunur olmasi ve tiklandiginda dogru sayfaya yonlendirmesi kontrolu
      Given kullanici "instulearnUrl" anasayfaya gider
      When anasayfa header kismindaki Start learning butonunun gorunur oldugunu kontrol eder ve tiklar
      And Login sayfasina yonlendirdigi kontrol edilir



    Scenario: TC_08 Site anasayfasindaki Login ve Register linklerinin gorunur olmasi kontrolu
    ve tiklandiginda dogru sayfaya yonlendirmesi kontrolu
      Given kullanici "instulearnUrl" anasayfaya gider
      When Kullanici header kismindaki Login linkine tiklar
      And Login sayfasina yonlendirdigi kontrol edilir
      Then Header kismindaki Register linkine tiklar
      And Register sayfasina yonlendirdigi kontrol edilir
