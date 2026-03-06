@regression45
Feature: US_045 Öğrenci Finansal İşlemler Yönetimi

  Background: Kullanıcı sisteme giriş yapmış olmalıdır
          Given kullanici "instulearnUrl" anasayfaya gider


@Us_45_TC01
  Scenario: Finansal alt menü linklerinin kontrolü
          Given Kullanici sisteme "login" olur
          And Kullanici dashboard menusunde aşağı scroll yapar
          When Kullanici financialMenu tiklar
          Then Alt Menu linklerin gorunur ve aktif oldugunu dogrular
          | Financial Summary |
          | Sales report |
          | Charge Account |
          | Subscribe |
          | Payout |


@Us_45_TC02
  Scenario: Payout sayfasında hesap yönetimi
          Given Kullanici sisteme register olur
          And Kullanici dashboard alt menusune tiklar
          Then Kullanici dashboard menusunde aşağı scroll yapar
          And Kullanici financialMenu tiklar
          Then Kullanici Payout menusune tiklar
          And Kullanici yönlendirme uyarısını onaylar
          Then Hesap Isim IBAN doldurur
          And Kullanici "save" tıklayarak bir payout hesabı oluşturur.
          Then Yeni hesabın açıldığını doğrular

@Us_45_TC03
  Scenario: Payout sayfasında request oluşturmak
          # Kullanici Payout hesabi olan bir hesap ile sisteme giriş yapar
          Given Kullanici sisteme "login" olur
          Then Kullanici dashboard menusunde aşağı scroll yapar
          And Kullanici financialMenu tiklar
          Then Kullanici Payout menusune tiklar
          And Kullanici Payout request talebi oluşturur
          Then Payout request işleminin onaylandığını doğrular

@Us_45_TC04
  Scenario: Oluşturulan  Payout hesabın silinmesi
          Given Kullanici sisteme "login" olur
          Then Kullanici dashboard menusunde aşağı scroll yapar
          And Kullanci setting menusunden identity & financial menusune gelip
          When oluşturduğu Payout hesabını siler
          Then Hesabin silindigini doğrular

@Us_45_TC05
  Scenario: Cüzdana bakiye tanımlama (Charge Account)
          Given Kullanici sisteme "login" olur
          Then Kullanici dashboard menusunde aşağı scroll yapar
          And Kullanici financialMenu tiklar
          Then Kullanici Charge Account sayfasina gider
          When Kullanici Stripe ödeme yöntemini seçer ve tutarı "50" girer
          And Kullanici ödeme bilgilerini girer
          And Ödeme işlemini onaylar
          Then Doğrulama mesajı görüntülenmelidir

@Us_45_TC06
  Scenario: Yeni üyelik planı görüntülemek ve satın alma
          Given Kullanici sisteme "login" olur
          And Kullanici dashboard alt menusune tiklar
          Then Kullanici dashboard menusunde aşağı scroll yapar
          And Kullanici financialMenu tiklar
          Then Kullanici Subscribe menusune tiklar
          Then Kullanici mevcut planınnın görüntüler
          When Kullanici mevcut planından farklı bir plan seçer ve ödemeyi tamamlar
          Then Yeni üyelik planının aktif olduğunu doğrular