package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.*;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.MelahatnurPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;

import static utilities.Driver.driver;

public class MelahatnurStepdefinitions {

    MelahatnurPage melahatnurPage = new MelahatnurPage();
    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
    private static String instructorPageUrl;


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

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", buton);

        boolean isExist = buton.getSize().getWidth() > 0 && buton.getSize().getHeight() > 0;
        Assertions.assertTrue(isExist, "Buton boyutları 0'dan büyük değil!");

        js.executeScript("arguments[0].click();", buton);
    }

    @And("instructorun takvimine erisilir")
    public void instructorunTakvimineErisilir() {
        Assertions.assertTrue(melahatnurPage.takvim.isDisplayed());
        instructorPageUrl = Driver.getDriver().getCurrentUrl();
    }


    @And("randevu olusturulmak istendiginde login uyarisi verilir")
    public void randevuOlusturulmakIstendigindeLoginUyarisiVerilir() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOf(melahatnurPage.takvim));
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", melahatnurPage.takvim);
        ReusableMethods.bekle(2);

        List<WebElement> tumGunler = melahatnurPage.takvimGunler;
        Assertions.assertFalse(tumGunler.isEmpty(), "Takvimde tiklanabilir gun bulunamadi!");

        int bugunNoTC06 = LocalDate.now().getDayOfMonth();
        WebElement gun1 = null;
        for (WebElement g : tumGunler) {
            int gunNo = Integer.parseInt(g.getText().trim());
            if (gunNo > bugunNoTC06) {
                gun1 = g;
                break;
            }
        }
        Assertions.assertNotNull(gun1, "Gelecekte musait gun bulunamadi!");

        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", gun1);
        js.executeScript("arguments[0].click();", gun1);
        ReusableMethods.bekle(2);

        wait.until(ExpectedConditions.visibilityOf(melahatnurPage.availableTimesDiv));
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", melahatnurPage.availableTimesDiv);
        ReusableMethods.bekle(2);

        wait.until(ExpectedConditions.elementToBeClickable(melahatnurPage.saatLabel));
        js.executeScript("arguments[0].click();", melahatnurPage.saatLabel);
        ReusableMethods.bekle(1);

        wait.until(ExpectedConditions.visibilityOf(melahatnurPage.meetingTypeOnlineLabel));
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", melahatnurPage.meetingTypeOnlineLabel);
        js.executeScript("arguments[0].click();", melahatnurPage.meetingTypeOnlineLabel);

        wait.until(ExpectedConditions.visibilityOf(melahatnurPage.submitFormBtn));
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", melahatnurPage.submitFormBtn);
        ReusableMethods.bekle(1);
        js.executeScript("arguments[0].click();", melahatnurPage.submitFormBtn);

        wait.until(ExpectedConditions.visibilityOf(melahatnurPage.toastMesaj));
        Assertions.assertTrue(melahatnurPage.toastMesaj.isDisplayed(), "Login uyarisi goruntulenmedi!");
        Assertions.assertTrue(melahatnurPage.toastMesaj.getText().contains("login"), "Toast mesaji login icermiyor!");
    }

    @And("login olduktan sonra instructora randevu olusturulur")
    public void loginOlduktanSonraInstructoraRandevuOlusturulur() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));


        Driver.getDriver().navigate().to(instructorPageUrl);
        ReusableMethods.bekle(2);

        wait.until(ExpectedConditions.visibilityOf(melahatnurPage.takvim));
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", melahatnurPage.takvim);
        ReusableMethods.bekle(2);

        List<WebElement> tumGunler2 = melahatnurPage.takvimGunler;
        Assertions.assertFalse(tumGunler2.isEmpty(), "Takvimde tiklanabilir gun bulunamadi!");

        int bugunNo = LocalDate.now().getDayOfMonth();
        WebElement gun1b = null;
        for (WebElement g : tumGunler2) {
            int gunNo = Integer.parseInt(g.getText().trim());
            if (gunNo > bugunNo) {
                gun1b = g;
                break;
            }
        }
        Assertions.assertNotNull(gun1b, "Gelecekte musait gun bulunamadi!");

        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", gun1b);
        js.executeScript("arguments[0].click();", gun1b);
        ReusableMethods.bekle(2);

        wait.until(ExpectedConditions.visibilityOf(melahatnurPage.availableTimesDiv));
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", melahatnurPage.availableTimesDiv);
        ReusableMethods.bekle(2);

        wait.until(ExpectedConditions.elementToBeClickable(melahatnurPage.saatLabel));
        js.executeScript("arguments[0].click();", melahatnurPage.saatLabel);
        ReusableMethods.bekle(1);

        wait.until(ExpectedConditions.visibilityOf(melahatnurPage.meetingTypeOnlineLabel));
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", melahatnurPage.meetingTypeOnlineLabel);
        js.executeScript("arguments[0].click();", melahatnurPage.meetingTypeOnlineLabel);

        wait.until(ExpectedConditions.visibilityOf(melahatnurPage.submitFormBtn));
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", melahatnurPage.submitFormBtn);
        ReusableMethods.bekle(1);
        js.executeScript("arguments[0].click();", melahatnurPage.submitFormBtn);

        ReusableMethods.bekle(3);
        String currentUrl = Driver.getDriver().getCurrentUrl();
        boolean rezervasyonBasarili = currentUrl.contains("meetings") || currentUrl.contains("appointments") || currentUrl.contains("booking") || currentUrl.contains("cart");
        Assertions.assertTrue(rezervasyonBasarili, "Rezervasyon tamamlanamadi! Mevcut URL: " + currentUrl);
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

    @When("kaydedip ilerler")
    public void kaydedip_ilerler() {


        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(30));
        try {
            wait.until(ExpectedConditions.invisibilityOf(melahatnurPage.toastMesaj));
        } catch (TimeoutException e) {
            ((JavascriptExecutor) Driver.getDriver()).executeScript(
                    "document.querySelectorAll('.jq-toast-single').forEach(e => e.remove());"
            );
        }

        ((JavascriptExecutor) Driver.getDriver()).executeScript(
                "arguments[0].scrollIntoView({block: 'center'});", melahatnurPage.saveButonu);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", melahatnurPage.saveButonu);

        ReusableMethods.bekle(2);

        ((JavascriptExecutor) Driver.getDriver()).executeScript(
                "arguments[0].scrollIntoView({block: 'center'});", melahatnurPage.nextButonu);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", melahatnurPage.nextButonu);
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
        melahatnurPage.basicInformationTelefonNumber.sendKeys("544 765 78 90");


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

        String bigFilePath = System.getProperty("user.dir") + "/src/test/resources/buyuk_resim.jpg";
        melahatnurPage.profileImageInput.sendKeys(bigFilePath);

    }

    @And("About kismina bilgiler girilir")
    public void aboutKisminaBilgilerGirilir() {

        Faker faker = new Faker();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20));

        ReusableMethods.bekle(2);

        WebElement biographyElement = wait.until(ExpectedConditions.elementToBeClickable(melahatnurPage.biographyBox));

        ((JavascriptExecutor) Driver.getDriver()).executeScript(
                "arguments[0].scrollIntoView({block: 'center'});", biographyElement);
        ReusableMethods.bekle(2);

        biographyElement.clear();
        biographyElement.sendKeys(faker.lorem().paragraph(2));

        WebElement jobTitleElement = wait.until(ExpectedConditions.elementToBeClickable(melahatnurPage.jobTitleBox));
        ((JavascriptExecutor) Driver.getDriver()).executeScript(
                "arguments[0].scrollIntoView({block: 'center'});", jobTitleElement);
        ReusableMethods.bekle(2);

        jobTitleElement.clear();
        jobTitleElement.sendKeys(faker.job().title());
    }


    @And("Hata mesajının görüntülendiği doğrulanır")
    public void hataMesajınınGörüntülendiğiDoğrulanır() {

        Assertions.assertTrue(melahatnurPage.hataMesaji.isDisplayed());
    }

    @And("About kismina karakter asimi bilgiler girilir")
    public void aboutKisminaKaarakterAsimiBilgilerGirilir() {
        Faker faker = new Faker();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20));

        ReusableMethods.bekle(2);

        WebElement biographyElement = wait.until(ExpectedConditions.elementToBeClickable(melahatnurPage.biographyBox));

        ((JavascriptExecutor) Driver.getDriver()).executeScript(
                "arguments[0].scrollIntoView({block: 'center'});", biographyElement);
        ReusableMethods.bekle(2);

        biographyElement.clear();
        biographyElement.sendKeys(faker.lorem().paragraph(100));

        WebElement jobTitleElement = wait.until(ExpectedConditions.elementToBeClickable(melahatnurPage.jobTitleBox));
        ((JavascriptExecutor) Driver.getDriver()).executeScript(
                "arguments[0].scrollIntoView({block: 'center'});", jobTitleElement);
        ReusableMethods.bekle(2);

        jobTitleElement.clear();
        jobTitleElement.sendKeys(faker.job().title());
        WebDriverWait toastWait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        toastWait.until(ExpectedConditions.invisibilityOf(melahatnurPage.toastMesaj));

        melahatnurPage.saveButonu.click();


    }

    @And("Education'a bilgiler girilir")
    public void educationABilgilerGirilir() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        Faker faker = new Faker();

        wait.until(ExpectedConditions.elementToBeClickable(melahatnurPage.addEducationBtn));
        melahatnurPage.addEducationBtn.click();

        wait.until(ExpectedConditions.visibilityOf(melahatnurPage.newEducationModal));

        WebElement schoolInput;
        try {
            schoolInput = wait.until(ExpectedConditions.elementToBeClickable(melahatnurPage.newEducationInput));
        } catch (TimeoutException e) {
            schoolInput = wait.until(ExpectedConditions.elementToBeClickable(
                    By.cssSelector(".swal2-popup input[type='text'], .swal2-popup input:not([type])")
            ));
        }

        schoolInput.clear();
        schoolInput.sendKeys(faker.university().name());

        wait.until(ExpectedConditions.not(
                ExpectedConditions.attributeToBe(schoolInput, "value", "")
        ));

        try {
            wait.until(ExpectedConditions.elementToBeClickable(melahatnurPage.educationModalSaveBtn));
            melahatnurPage.educationModalSaveBtn.click();
        } catch (TimeoutException e1) {
            try {
                wait.until(ExpectedConditions.elementToBeClickable(melahatnurPage.educationModalConfirmBtn));
                ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", melahatnurPage.educationModalConfirmBtn);
            } catch (TimeoutException e2) {
                WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//button[contains(@class,'swal2-confirm') and not(contains(@style,'display: none'))]")
                ));
                ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", saveBtn);
            }
        }

        wait.until(ExpectedConditions.invisibilityOfElementLocated(
                By.cssSelector(".swal2-popup")
        ));
    }

    @And("Experience bilgileri girilir")
    public void experienceBilgileriGirilir() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        Faker faker = new Faker();
        melahatnurPage.addExperience.click();
        melahatnurPage.newExperienceBox.sendKeys(faker.job().position() + "at " + faker.company().name());

        melahatnurPage.experinceSaveButon.click();

    }

    @And("Skills Topicsleri secer")
    public void skillsTopicsleriSecer() {
        Random random = new Random();
        int randomIndex = random.nextInt(melahatnurPage.skillsTopicler.size());
        WebElement secilecekTopic = melahatnurPage.skillsTopicler.get(randomIndex);
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", secilecekTopic);
        js.executeScript("arguments[0].click();", secilecekTopic);
    }

    @And("Select Account Type butonun tiklanabilir olmasi")
    public void selectAccountTypeButonunTiklanabilirOlmasi() {
        Assertions.assertTrue(melahatnurPage.selectAccountType.isEnabled());
    }

    @And("Zoom api bilgilerini girer")
    public void zoomApiBilgileriniGirer() {
        Faker faker = new Faker();
        melahatnurPage.zoomClientID.click();
        melahatnurPage.zoomClientID.clear();
        melahatnurPage.zoomClientID.sendKeys(faker.internet().uuid());
        melahatnurPage.zoomClientSecret.click();
        melahatnurPage.zoomClientSecret.clear();
        melahatnurPage.zoomClientSecret.sendKeys(faker.internet().uuid());
        melahatnurPage.zoomAccountID.click();
        melahatnurPage.zoomAccountID.clear();
        melahatnurPage.zoomAccountID.sendKeys(faker.internet().uuid());
    }

    @And("Extra Information bilgilerini girer")
    public void extraInformationBilgileriniGirer() {

        Random random = new Random();
        int randomIndex = random.nextInt(melahatnurPage.genders.size());
        js.executeScript("arguments[0].click();", melahatnurPage.genders.get(randomIndex));


        Faker faker = new Faker();
        melahatnurPage.age.click();
        melahatnurPage.age.sendKeys(String.valueOf(faker.number().numberBetween(18, 65)));

        int meetingTypeIndex = random.nextInt(melahatnurPage.meetingType.size());
        js.executeScript("arguments[0].click();", melahatnurPage.meetingType.get(meetingTypeIndex));

        int trainingLevelIndex = random.nextInt(melahatnurPage.trainingLevel.size());
        js.executeScript("arguments[0].click();", melahatnurPage.trainingLevel.get(trainingLevelIndex));

        int countriesIndex = random.nextInt(melahatnurPage.countries.size());
        js.executeScript("arguments[0].click();", melahatnurPage.countries.get(countriesIndex));

        int provinceIndex = random.nextInt(melahatnurPage.provinces.size());
        js.executeScript("arguments[0].click();", melahatnurPage.provinces.get(provinceIndex));

        int cityIndex = random.nextInt(melahatnurPage.cities.size());
        js.executeScript("arguments[0].click();", melahatnurPage.cities.get(cityIndex));

        int districtIndex = random.nextInt(melahatnurPage.district.size());
        js.executeScript("arguments[0].click();", melahatnurPage.district.get(districtIndex));

        melahatnurPage.adress.click();
        melahatnurPage.adress.sendKeys(faker.address().fullAddress());

    }

    @And("Delete account yaparak hesabi siler")
    public void deleteAccountYaparakHesabiSiler() {
        melahatnurPage.deleteAccount.click();
        melahatnurPage.yesIconfirm.click();
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










    

        




