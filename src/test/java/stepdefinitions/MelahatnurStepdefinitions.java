package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.*;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.MelahatnurPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.time.Duration;
import java.time.Instant;

public class MelahatnurStepdefinitions {

    MelahatnurPage melahatnurPage = new MelahatnurPage();
    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();


    @When("Body bolumunde Instructors basliginin gorunurlugu dogrulanir")
    public void body_bolumunde_ınstructors_basliginin_gorunurlugu_dogrulanir() {
        Assertions.assertTrue(melahatnurPage.instructorBasligi.isDisplayed());
    }


    @When("Instructors bölümüne scroll yapar")
    public void instructorsBölümüneScrollYapar() {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", melahatnurPage.allInstructorButonu);

    }

    @Then("All Instructor butonunun gorunurlugu ve tiklanabilirligi dogrulanir")
    public void allInstructorButonununGorunurluguVeTiklanabilirligiDogrulanir() {

        Assertions.assertTrue(melahatnurPage.allInstructorButonu.isDisplayed());
        Assertions.assertTrue(melahatnurPage.allInstructorButonu.isEnabled());
    }

    @When("Instructor slider alanının görünür olduğunu doğrular")
    public void instructorSliderAlanınınGörünürOlduğunuDoğrular() {

        Assertions.assertTrue(melahatnurPage.instructorSliderArea.isDisplayed(), "Slider alanı görünmüyor!");
    }

    @Then("Slider noktalarını kullanarak kart geçişi yapar")
    public void sliderNoktalarınıKullanarakKartGeçişiYapar() {
        js.executeScript("arguments[0].click();", melahatnurPage.sliderNoktasi.get(1));
    }

    @And("Kartların değiştiği doğrulanır")
    public void kartlarınDeğiştiğiDoğrulanır() {
        String classDegeri = melahatnurPage.sliderNoktasi.get(1).getAttribute("class");
        Assertions.assertTrue(classDegeri.contains("active"), "Slider noktaya tıklanmasına rağmen kaymadı!");
    }


    @Then("Instructor isminin görünür olduğu doğrulanır")
    public void instructorIsmininGörünürOlduğuDoğrulanır() {

        String isim = melahatnurPage.instructorIsimleri.get(0).getText();
        Assertions.assertFalse(isim.isEmpty());
    }

    @Then("Beğeni puanının görüntülendiği doğrulanır")
    public void beğeniPuanınınGörüntülendiğiDoğrulanır() {
        Assertions.assertTrue(!melahatnurPage.instructorPuanlari.isEmpty());
    }

    @And("{string} butonunun görünür ve aktif olduğu doğrulanır")
    public void butonununGörünürVeAktifOlduğuDoğrulanır(String butonMetni) {


            Assertions.assertFalse(melahatnurPage.reserveButonu.isEmpty(), "Buton DOM'da bulunamadı!");
            WebElement buton = melahatnurPage.reserveButonu.get(0);

            // Sayfayı kaydır
            JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
            js.executeScript("arguments[0].scrollIntoView({block: 'center'});", buton);

            // Görünürlük kontrolü
            boolean isExist = buton.getSize().getWidth() > 0 && buton.getSize().getHeight() > 0;
            Assertions.assertTrue(isExist, "Buton boyutları 0'dan büyük değil!");

            // KRİTİK EKSİK: Tıklama işlemi
            // Eğer standart click() hata verirse (JS engelinden dolayı), JS click de kullanabilirsiniz.
            buton.click();
        }

    @And("instructorun takvimine erisilir")
    public void instructorunTakvimineErisilir() {

        Assertions.assertTrue(melahatnurPage.takvim.isDisplayed());

    }


    @And("randevu olusturulmak istendiginde login uyarisi verilir")
    public void randevuOlusturulmakIstendigindeLoginUyarisiVerilir() {

    }

    @And("login olduktan sonra instructora randevu olusturulur")
    public void loginOlduktanSonraInstructoraRandevuOlusturulur() {
    }




    // ================================== US031====================================//

    @Given("kullanici login butonuna basar ve admin olarak giris yapar")
    public void kullanici_login_butonuna_basar_ve_admin_olarak_giris_yapar() {
        melahatnurPage.logineGidisButonu.click();
        melahatnurPage.loginEmailButonu.sendKeys("melahatnur.admin@instulearn.com");

        melahatnurPage.loginSifreButonu.sendKeys(ConfigReader.getProperty("gecerliPassword"));
        melahatnurPage.loginButonu.click();

    }

    @When("slider alanini kontrol eder ve settings linkinin gorunur oldugunu kontrol eder")
    public void slider_alanini_kontrol_eder_ve_settings_linkinin_gorunur_oldugunu_kontrol_eder() {

        Assertions.assertTrue(melahatnurPage.settingsLinki.isDisplayed());

    }

    @Then("Settings linkinin tiklanabilirligini kontrol eder")
    public void settings_linkinin_tiklanabilirligini_kontrol_eder() {

        Assertions.assertTrue(melahatnurPage.settingsLinki.isEnabled());
    }

    @When("kullanici settings sayfasinda olur")
    public void kullanici_settings_sayfasinda_olur() {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].click();", melahatnurPage.settingsLinki);

    }

    @When("basic information sayfasinda zorunlu alanlari gecerli verilerle doldurur")
    public void basic_information_sayfasinda_zorunlu_alanlari_gecerli_verilerle_doldurur() {

        melahatnurPage.basicInformationEmail.clear();
        melahatnurPage.basicInformationEmail.sendKeys("melahatnur.admin@instulearn.com");

        melahatnurPage.basicInformationName.clear();
        melahatnurPage.basicInformationName.sendKeys("Melahatnur");
        melahatnurPage.basicInformationPassword.sendKeys(ConfigReader.getProperty("gecerliPassword"));
        melahatnurPage.basicInformationPasswordTekrari.sendKeys(ConfigReader.getProperty("gecerliPassword"));
        melahatnurPage.basicInformationTelefonNumber.sendKeys("0544 765 78 90");


        // 1. Language Seçimi (Çok basit)
        Select select = new Select(melahatnurPage.languageDropdown);
        select.selectByValue("EN");

        // 2. Time Zone Seçimi (Select2 olduğu için adım adım)
        melahatnurPage.timeZoneKutusu.click(); // Önce dropdown listesini açıyoruz

        // Listeden "UTC" içeren seçeneği bulup tıklıyoruz
        for (WebElement option : melahatnurPage.timeZoneSecenekleri) {
            if (option.getText().contains("UTC")) {
                option.click();
                break;
            }
        }


        melahatnurPage.basicInformationJoinEmail.click();
        melahatnurPage.basicInformationEnableProfil.click();

    }

    @When("kaydedip ilerler")
    public void kaydedip_ilerler() {

        // 1. Önce sayfanın kendine gelmesi için 2 saniye bekle
        ReusableMethods.bekle(2);

        // 2. Elementi doğrudan driver ile taze bir şekilde bul ve tıkla
        // Bu yöntem PageFactory'deki stale sorununu bypass eder
        Driver.getDriver().findElement(By.xpath("//button[text()='Save']")).click();

        // 3. Save sonrası sayfa bir daha yenileniyorsa kısa bir ara ver
        ReusableMethods.bekle(2);

        // 4. Next butonunu da aynı tazelikte bul ve tıkla
        Driver.getDriver().findElement(By.xpath("//button[text()='Next']")).click();

    }



    @And("degisiklikler kaydedilir")
    public void degisikliklerKaydedilir() {
        melahatnurPage.saveButonu.click();
    }


    @When("basic information sayfasinda zorunlu alanlardan birini bos birakir")
    public void basicInformationSayfasindaZorunluAlanlardanBiriniBosBirakir() {

        melahatnurPage.basicInformationName.sendKeys("Melahatnur");
        melahatnurPage.basicInformationPassword.sendKeys(ConfigReader.getProperty("gecerliPassword"));
        melahatnurPage.basicInformationPasswordTekrari.sendKeys(ConfigReader.getProperty("gecerliPassword"));
        melahatnurPage.basicInformationTelefonNumber.sendKeys("0544 765 78 90");


        Select select = new Select(melahatnurPage.languageDropdown);
        select.selectByValue("EN");


        melahatnurPage.timeZoneKutusu.click();


        for (WebElement option : melahatnurPage.timeZoneSecenekleri) {
            if (option.getText().contains("UTC")) {
                option.click();
                break;
            }
        }


        melahatnurPage.basicInformationJoinEmail.click();
        melahatnurPage.basicInformationEnableProfil.click();
    }

    @And("bos birakilan alan icin uyari verilir")
    public void bosBirakilanAlanIcinUyariVerilir() {
        Assertions.assertTrue(melahatnurPage.feedback.isDisplayed());
    }

    @And("Desteklenen formatta bir fotograf yuklenir")
    public void desteklenenFormattaBirFotografYuklenir() {

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

        wait.until(ExpectedConditions.refreshed(
                ExpectedConditions.elementToBeClickable(melahatnurPage.nextButonu)
        ));
        melahatnurPage.nextButonu.click();
    }

    @And("Desteklenmeyen formatta bir fotograf yuklenir")
    public void desteklenmeyenFormattaBirFotografYuklenir() {
        // yapamadmmmmmmm

        String bigFilePath = System.getProperty("user.dir") + "src/test/resources/buyuk_resim.jpg";
        melahatnurPage.profileImageInput.sendKeys(bigFilePath);

    }

    @And("About kismina bilgiler girilir")
    public void aboutKisminaBilgilerGirilir() {

            Faker faker = new Faker();
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));

            // 1. Önce elemanın görünür ve tıklanabilir olmasını bekle
            wait.until(ExpectedConditions.visibilityOf(melahatnurPage.biographyBox));

            // 2. Sayfayı elemana kaydır (Scroll) - Mac'te bazen bu gerekir
            ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", melahatnurPage.biographyBox);

            // 3. Bilgileri gir
            melahatnurPage.biographyBox.clear();
            melahatnurPage.biographyBox.sendKeys(faker.lorem().paragraph(5));

            // Job Title için de aynısını yapalım
            melahatnurPage.jobTitleBox.clear();
            melahatnurPage.jobTitleBox.sendKeys(faker.job().title());
        }













    //========================================US036==========================================//

    @When("blog linkinin gorunur ve tiklanabilir oldugunu dogrular")
    public void blogLinkininGorunurVeTiklanabilirOldugunuDogrular() {
        Assertions.assertTrue(melahatnurPage.anasayfaBlogLinki.isDisplayed());
        Assertions.assertTrue(melahatnurPage.anasayfaBlogLinki.isEnabled());
    }

    @When("kullanici blog linkine tiklar")
    public void kullaniciBlogLinkineTiklar() {
        melahatnurPage.anasayfaBlogLinki.click();

    }

    @Then("blog sayfasina yonlendirildigini sayfanin ust kismindan kontrol eder")
    public void blogSayfasinaYonlendirildiginiSayfaninUstKismindanKontrolEder() {
        ReusableMethods.bekle(2);
        Assertions.assertTrue(melahatnurPage.blogSayfasindakiBlogYazisi.isDisplayed());
    }

    @When("Search textbox alanını kontrol eder")
    public void searchTextboxAlanınıKontrolEder() {

        Assertions.assertTrue(melahatnurPage.blogSayfasindakiSearchTextBox.isDisplayed());
        Assertions.assertTrue(melahatnurPage.blogSayfasindakiSearchTextBox.isEnabled());
    }

    @Then("Search butonunu kontrol eder")
    public void searchButonunuKontrolEder() {
        Assertions.assertTrue(melahatnurPage.blogSayfasindakiSearchButonu.isDisplayed());
        Assertions.assertTrue(melahatnurPage.blogSayfasindakiSearchButonu.isEnabled());
    }

    @Then("Search textbox’a geçerli bir anahtar kelime girer")
    public void searchTextboxAGeçerliBirAnahtarKelimeGirer() {
        melahatnurPage.blogSayfasindakiSearchTextBox.sendKeys("The Growing Impact of Online Education");
        
    }

    @And("Search butonuna tıklar")
    public void searchButonunaTıklar() {
        melahatnurPage.blogSayfasindakiSearchButonu.click();
    }

    @Then("Search textbox’a geçersiz bir anahtar kelime girer")
    public void searchTextboxAGeçersizBirAnahtarKelimeGirer() {

        melahatnurPage.blogSayfasindakiSearchTextBox.sendKeys("Math");


    }

    @Then("Herhangi bir kategori seçer")
    public void herhangiBirKategoriSeçer() {
        melahatnurPage.blogSayfasindakiRastgeleKategori.click();
    }


    @And("Icerik yoksa mesaj gosterimi")
    public void icerikYoksaMesajGosterimi() {

        Assertions.assertFalse(melahatnurPage.blogPosts.isEmpty());
    }


    @Then("kategori kismindan blog secilir")
    public void kategorideBlogSecilir() {
        melahatnurPage.kategoriBlogButonu.click();
    }

    @And("blog listesi gorunur ve herhangi bir blog secilir")
    public void blogListesiGorunurHerhangiBirBlogSecilir() {
        Assertions.assertTrue(melahatnurPage.blogListeleme.isDisplayed());

        melahatnurPage.bloglardanHerhangiBiri.click();
    }

    @And("secilen blogun yorum alanina gecerli yorum girilir")
    public void secilenBlogunYorumAlaninaGecerliYorumGirilir() {

        melahatnurPage.commentAlani.sendKeys("Cok basarili bir blog olmus.");
        
    }

    @And("post comment butonuna tiklanir")
    public void postCommentButonunaTiklanir() {
        melahatnurPage.postCommentButonu.click();
    }

    @And("secilen blogun yorum alani bos birakilir")
    public void secilenBlogunYorumAlaniBosBirakilir() {
        melahatnurPage.commentAlani.sendKeys(" ");
    }

    @Then("blogun paylasildigi tarihin gorunurlugunu kontrol eder")
    public void blogunPaylasildigiTarihinGorunurlugunuKontrolEder() {
        Assertions.assertTrue(melahatnurPage.blogPaylasildigiTarih.isDisplayed());

    }

    @Then("blogun konusunun gorunurlugunu kontrol eder")
    public void blogunKonusununGorunurlugunuKontrolEder() {
        Assertions.assertTrue(melahatnurPage.blogPaylasildigiKonu.isDisplayed());
        
    }

    @And("blogun iceriginin gorunurlugunu kontrol eder")
    public void blogunIcerigininGorunurlugunuKontrolEder() {
        Assertions.assertTrue(melahatnurPage.blogPaylasildigiIcerik.isDisplayed());
        
    }

    @And("blogu paylasan kisinin gorunurlugunu kontrol eder")
    public void bloguPaylasanKisininGorunurlugunuKontrolEder() {

        Assertions.assertTrue(melahatnurPage.blogPaylasan.isDisplayed());
    }



}










    

        




