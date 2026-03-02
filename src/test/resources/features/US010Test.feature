Feature: Home Join as Instructor link gorunurlugu ve tiklanabilirligi

  Scenario: Visitor kullanici Join as Instructor linkine ulasir
    Given kullanici "instulearnUrl" anasayfaya gider
    Then Home  Join as Instructor basligi ve linkinin gorunur oldugu dogrulanir
    And linkin tiklanabilir oldugu dogrulanir
    When kullanici Join as Instructor linkine tiklar
    Then login sayfasina yonlendirildigi dogrulanir