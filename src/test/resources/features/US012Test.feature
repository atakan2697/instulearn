
@melo
  Feature: US012, Bir kullanici olarak sitede ınstructorları inceleyip
    randevu olusturabilecegim bir alan olmasınınin test caseleri

    Scenario: TC01 Instructors basliginin gorunurlugu
      * kullanici "instulearnUrl" anasayfaya gider
      When Body bolumunde Instructors basliginin gorunurlugu dogrulanir

    Scenario: TC02 All Instructors gorunurlugu ve tiklanabilirligi
      * kullanici "instulearnUrl" anasayfaya gider
      When Instructors bölümüne scroll yapar
      Then All Instructor butonunun gorunurlugu ve tiklanabilirligi dogrulanir

    Scenario: TC03 Instructor slider alaninin gorunurlugu ve fonksiyonelligi
      * kullanici "instulearnUrl" anasayfaya gider
      When Instructors bölümüne scroll yapar
      When Instructor slider alanının görünür olduğunu doğrular
      Then Slider noktalarını kullanarak kart geçişi yapar
      And Kartların değiştiği doğrulanır

    Scenario: TC04 Instructor Kart İçerik Bilgilerinin Doğrulanması
      * kullanici "instulearnUrl" anasayfaya gider
      Given Instructors bölümüne scroll yapar
      * kullanici 2 saniye bekler
      Then Instructor isminin görünür olduğu doğrulanır
      Then Beğeni puanının görüntülendiği doğrulanır
      And "Reserve a live meeting" butonunun görünür ve aktif olduğu doğrulanır









