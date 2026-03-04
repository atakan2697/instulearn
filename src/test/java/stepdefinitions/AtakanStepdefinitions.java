package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.*;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.AtakanPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.ResourceBundle;
import java.util.Set;

public class AtakanStepdefinitions {

    AtakanPage atakanPage = new AtakanPage();
    String loginWhd;
    String forgotPasswordWhd;
    String courseWhd;
    String kursProfilWhd;

    Faker faker= new Faker();
    Actions actions= new Actions(Driver.getDriver());

    JavascriptExecutor js= (JavascriptExecutor) Driver.getDriver();

    @When("login butonu gorunur ve aktif olmalidir")
    public void loginButonuGorunurVeAktifOlmalidir() {
        Assertions.assertTrue(atakanPage.loginLinki.isDisplayed());
        Assertions.assertTrue(atakanPage.loginLinki.isEnabled());
    }

    @When("login butonuna tıklanır")
    public void login_butonuna_tıklanır() {
    atakanPage.loginLinki.click();
        ReusableMethods.bekle(1);
    }
    @Then("sayfanın sol bölümündeki görsel görünür olmalıdır")
    public void sayfanın_sol_bölümündeki_görsel_görünür_olmalıdır() {
        Assertions.assertTrue(atakanPage.solTaraftakiImg.isDisplayed());
    }
    @Then("sayfanın sağ bölümünde bulunan Log in to your account texti görünür olmalıdır")
    public void sayfanın_sağ_bölümünde_bulunan_log_in_to_your_account_texti_görünür_olmalıdır() {
        Assertions.assertTrue(atakanPage.logInToYourAccount.isDisplayed());
    }
    @When("login formu icindeki email textboxı gorunur ve aktif olmalidir")
    public void login_formu_icindeki_email_textboxı_gorunur_ve_aktif_olmalidir() {
        Assertions.assertTrue(atakanPage.email.isDisplayed());
        Assertions.assertTrue(atakanPage.email.isEnabled());
    }
    @Then("login formu icindeki password textboxı gorunur ve aktif olmalidir")
    public void login_formu_icindeki_password_textboxı_gorunur_ve_aktif_olmalidir() {
        Assertions.assertTrue(atakanPage.password.isDisplayed());
        Assertions.assertTrue(atakanPage.password.isEnabled());
    }
    @Then("login formu altındaki login butonu gorunur ve aktif olmalidir")
    public void login_formu_altındaki_login_butonu_gorunur_ve_aktif_olmalidir() {
        Assertions.assertTrue(atakanPage.loginSayfasındakiLoginButonu.isDisplayed());
        Assertions.assertTrue(atakanPage.loginSayfasındakiLoginButonu.isEnabled());

    }

    @When("forgot your password? linkine tiklanir")
    public void forgot_your_password_linkine_tiklanir() {

        atakanPage.forgotYourPassword.click();
        ReusableMethods.bekle(1);

    }
    @When("forgot your password sayfasina yonlendirme yaptigi dogrulanir")
    public void forgot_your_password_sayfasina_yonlendirme_yaptigi_dogrulanir() {

        loginWhd= Driver.getDriver().getWindowHandle();
        System.out.println("Login Whd :" + loginWhd);
        Set<String> acikTumWindowlarinWhdSeti= Driver.getDriver().getWindowHandles();
        forgotPasswordWhd= "";

        for (String eachWhd:acikTumWindowlarinWhdSeti ){

            if (!eachWhd.equals(loginWhd)){
                forgotPasswordWhd= eachWhd;
            }
        }

        Driver.getDriver().switchTo().window(forgotPasswordWhd);

        String expectedForgotPasswordUrl = "https://qa.instulearn.com/forget-password";
        String actualForgotPasswordUrl = Driver.getDriver().getCurrentUrl();
        Assertions.assertEquals(expectedForgotPasswordUrl,actualForgotPasswordUrl);

    }
    @Then("forgot your password sayfasindaki login butonuna tiklanir")
    public void forgot_your_password_sayfasindaki_login_butonuna_tiklanir() {
        atakanPage.forgotSayfasindakiLoginButonu.click();
        Driver.getDriver().switchTo().window(loginWhd);
        System.out.println(loginWhd);

    }
    @Then("login sayfasinda oldugu dogrulanir")
    public void login_sayfasinda_oldugu_dogrulanir() {
        String expectedUrl = "https://qa.instulearn.com/login";
        String actualUrl= Driver.getDriver().getCurrentUrl();
        Assertions.assertEquals(expectedUrl,actualUrl);

    }

    @When("email alanina gecersiz email girilir")
    public void email_alanina_gecersiz_email_girilir() {
        atakanPage.email.click();
        atakanPage.email.sendKeys("sanane@gmail.com123");
        ReusableMethods.bekle(1);

    }
    @When("password alanina {string} girilir")
    public void password_alanina_password_girilir(String password) {
        atakanPage.password.click();
        atakanPage.password.sendKeys(ConfigReader.getProperty(password));

    }
    @Then("login butonuna tiklanir")
    public void login_butonuna_tiklanir() {
        atakanPage.loginSayfasındakiLoginButonu.click();

    }
    @Then("hata mesajlari dogrulanir")
    public void hata_mesajlari_dogrulanir() {
        Assertions.assertTrue(atakanPage.emailAlanindakiHataMesaji.isDisplayed());

    }

    @When("email alanina kayitli email girilir")
    public void email_alanina_kayitli_email_girilir() {
       atakanPage.email.click();
       atakanPage.email.sendKeys("atakan.admin@instulearn.com");

    }

    @Then("kullanici basarili bir sekilde sisteme giris yaptigi dogrulanir")
    public void kullanici_basarili_bir_sekilde_sisteme_giris_yaptigi_dogrulanir() {
        String expectedurl= "https://qa.instulearn.com/panel";
        String actualUrl= Driver.getDriver().getCurrentUrl();
        Assertions.assertEquals(expectedurl,actualUrl);

    }

    @Given("courses linki görünür ve aktif olmali")
    public void courses_linki_görünür_ve_aktif_olmali() {
        Assertions.assertTrue(atakanPage.coursesLinki.isDisplayed());
        Assertions.assertTrue(atakanPage.coursesLinki.isEnabled());
    }
    @When("courses linkine tıklanır")
    public void courses_linkine_tıklanır() {
        atakanPage.coursesLinki.click();
    }

    @When("courses texti görüntülenmelidir")
    public void courses_texti_görüntülenmelidir() {
        Assertions.assertTrue(atakanPage.coursesTexti.isDisplayed());
    }

    @Given("search textbox görünür ve aktif olmalı")
    public void search_textbox_görünür_ve_aktif_olmalı() {
        Assertions.assertTrue(atakanPage.searchTexti.isDisplayed());
        Assertions.assertTrue(atakanPage.searchTexti.isEnabled());
    }
    @Given("search butonu görünür ve aktif olmalı")
    public void search_butonu_görünür_ve_aktif_olmalı() {
        Assertions.assertTrue(atakanPage.searchButonu.isDisplayed());
        Assertions.assertTrue(atakanPage.searchButonu.isEnabled());
    }

    @When("download görünür ve aktif olmalı")
    public void download_görünür_ve_aktif_olmalı() {
        Assertions.assertTrue(atakanPage.downloadSecenegi.isDisplayed());
        Assertions.assertTrue(atakanPage.downloadSecenegi.isEnabled());
    }
    @When("download butonuna tiklanir")
    public void download_butonuna_tiklanir() {
        atakanPage.downloadSecenegi.click();
        ReusableMethods.bekle(2);
    }

    @Then("sayfada tekrar scrool islemi yapilir")
    public void sayfada_tekrar_scrool_islemi_yapilir() {
        js.executeScript("window.scrollBy(0,820)");
        ReusableMethods.bekle(2);
    }

    @Then("sayfada scrool islemi yapılır")
    public void sayfada_scrool_islemi_yapılır() {
        js.executeScript("window.scrollBy(0,120)");
        ReusableMethods.bekle(2);
    }

    @Given("Listelenen kurs kartlari görünür olmalı")
    public void listelenen_kurs_kartlari_görünür_olmalı() {
        Assertions.assertTrue(atakanPage.kursKartlariList.isDisplayed());
    }
    @Given("secilen kurs kartında fiyat, tarih, ders adi ve instructor bilgileri görünür olmalıdır")
    public void secilen_kurs_kartında_fiyat_tarih_ders_adi_ve_instructor_bilgileri_görünür_olmalıdır() {
        Assertions.assertTrue(atakanPage.kursKartlariFiyat.get(0).isDisplayed());
        Assertions.assertTrue(atakanPage.kursKartlariTarih.get(0).isDisplayed());
        Assertions.assertTrue(atakanPage.kursKartlariDersAdi.get(0).isDisplayed());
        Assertions.assertTrue(atakanPage.kursKartlariInstructorBilgileri.get(0).isDisplayed());

    }

    @When("ilk kurs kartına tıklar")
    public void ilk_kurs_kartına_tıklar() {
        js.executeScript("window.scrollBy(0,200)");
       atakanPage.kursKartlariList.click();
       ReusableMethods.bekle(1);
    }
    @Then("kurs detay sayfasına yönlendirme yapar")
    public void kurs_detay_sayfasına_yönlendirme_yapar() {
        String expectedUrl= "https://qa.instulearn.com/course/Cyber-Security";
        String actualUrl= Driver.getDriver().getCurrentUrl();
        Assertions.assertEquals(expectedUrl,actualUrl);

    }
    @When("kurs kartında add to card ve buy now seçeneği varsa görünür ve aktif olmalıdır")
    public void kurs_kartında_add_to_card_ve_buy_now_seçeneği_varsa_görünür_ve_aktif_olmalıdır() {
        Assertions.assertTrue(atakanPage.addToCardButonu.isDisplayed());
        Assertions.assertTrue(atakanPage.addToCardButonu.isEnabled());
        Assertions.assertTrue(atakanPage.buyNowButonu.isDisplayed());
        Assertions.assertTrue(atakanPage.buyNowButonu.isEnabled());
    }

    @When("about this course görünür ve aktif olmalıdır")
    public void about_this_course_görünür_ve_aktif_olmalıdır() {
        Assertions.assertTrue(atakanPage.aboutThisCourseTexti.isDisplayed());
        Assertions.assertTrue(atakanPage.aboutThisCourseTexti.isEnabled());

    }
    @Then("comments alanına tıklanarak yorum yazılmalıdır")
    public void comments_alanına_tıklanarak_yorum_yazılmalıdır() {
        ReusableMethods.bekle(1);
        js.executeScript("arguments[0].scrollIntoView(true);", atakanPage.commentsTexti);
        ReusableMethods.bekle(1);
        String commentAlaniYazisi= faker.artist().name();
        atakanPage.commentsAlani.click();
        atakanPage.commentsAlani.sendKeys(commentAlaniYazisi);
        ReusableMethods.bekle(3);

    }
    @When("post comments butonuna tıklanır")
    public void post_comments_butonuna_tıklanır() {
        atakanPage.postCommentButonu.click();
        ReusableMethods.bekle(1);

    }
    @Then("profil butonuna tıklanır")
    public void profil_butonuna_tıklanır() {
        ReusableMethods.bekle(1);
        js.executeScript("arguments[0].scrollIntoView(true);", atakanPage.kursProfilAvatarImg);
        ReusableMethods.bekle(2);
        atakanPage.kursProfilButonu.click();

    }
    @Then("instructor profil sayfası görünür olmalıdır")
    public void instructor_profil_sayfası_görünür_olmalıdır() {
        ReusableMethods.bekle(1);
        courseWhd= Driver.getDriver().getWindowHandle();
        System.out.println("Course Whd :" + courseWhd);
        Set<String> acikTumWindowlarinWhdSeti= Driver.getDriver().getWindowHandles();
        kursProfilWhd= "";

        for (String eachWhd:acikTumWindowlarinWhdSeti ){

            if (!eachWhd.equals(courseWhd)){
                kursProfilWhd= eachWhd;
            }
        }

        Driver.getDriver().switchTo().window(kursProfilWhd);

        String expectedInstructorProfilUrl = "https://qa.instulearn.com/users/934/profile";
        String actualInstructorProfilUrl = Driver.getDriver().getCurrentUrl();
        Assertions.assertEquals(expectedInstructorProfilUrl,actualInstructorProfilUrl);

    }

    @When("kullanıcı instulearn website logosuna tıklar")
    public void kullanıcı_instulearn_website_logosuna_tıklar() {
        ReusableMethods.bekle(1);
       atakanPage.siteLogo.click();
    }
    @When("profil simgesinin üzerine gelip logout butonuna tıklar")
    public void profil_simgesinin_üzerine_gelip_logout_butonuna_tıklar() {
        ReusableMethods.bekle(1);
        actions.moveToElement(atakanPage.atakanProfilButonu).perform();
        ReusableMethods.bekle(1);
        atakanPage.logoutButonu.click();
    }
    @Then("register butonuna tiklar yeni bir instructor hesabı oluşturur")
    public void register_butonuna_tiklar_yeni_bir_instructor_hesabı_oluşturur() {
        atakanPage.registerButonu.click();
        js.executeScript("window.scrollBy(0,100)");
        atakanPage.registerInstructorSecimi.click();
        atakanPage.email.click();
        atakanPage.email.clear();
        atakanPage.email.sendKeys(faker.internet().emailAddress());
        atakanPage.registerFullName.click();
        atakanPage.registerFullName.sendKeys(faker.name().fullName());
        atakanPage.password.click();
        atakanPage.password.clear();
       // String password=ConfigReader.getProperty("gecerliPassword");
        atakanPage.password.sendKeys(ConfigReader.getProperty("gecerliPassword"));
        atakanPage.registerConfirmPassword.click();
        atakanPage.registerConfirmPassword.sendKeys(ConfigReader.getProperty("gecerliPassword"));
        js.executeScript("arguments[0].click();", atakanPage.registerIAgreeButonu);
        ReusableMethods.bekle(1);
        atakanPage.registerSignUpButonu.click();
        ReusableMethods.bekle(1);

    }

    @When("buy now butonuna tıklanr")
    public void buy_now_butonuna_tıklanr() {
        js.executeScript("window.scrollBy(0,150)");
        atakanPage.buyNowButonu.click();
        ReusableMethods.bekle(1);

    }
    @When("stripe butonuna tıklanır")
    public void stripe_butonuna_tıklanır() {
        atakanPage.stripeButonu.click();
    }
    @When("start payment butonuna tıklanır")
    public void start_payment_butonuna_tıklanır() {
        atakanPage.startPaymentButonu.click();

    }
    @Then("e-posta alanına gecerli mail adresi girilir")
    public void e_posta_alanına_gecerli_mail_adresi_girilir() {
        atakanPage.email.click();
        atakanPage.email.sendKeys(faker.internet().emailAddress());
        ReusableMethods.bekle(2);
    }
    @Then("kart bilgileri alanına gecerli kart bilgileri girilir")
    public void kart_bilgileri_alanına_gecerli_kart_bilgileri_girilir() {
        atakanPage.ödemeKartBilgileri.click();
        atakanPage.ödemeKartBilgileri.sendKeys("4242424242424242");
        atakanPage.ödemeKartCC.click();
        atakanPage.ödemeKartCC.sendKeys("1027");
        atakanPage.ödemeKartCVC.click();
        atakanPage.ödemeKartCVC.sendKeys("777");
        ReusableMethods.bekle(5);

    }
    @When("kart sahibi adı alanına gecerli bilgiler girilir")
    public void kart_sahibi_adı_alanına_gecerli_bilgiler_girilir() {
        atakanPage.ödemeKartAdıSoyadı.click();
        atakanPage.ödemeKartAdıSoyadı.sendKeys(faker.name().fullName());
        ReusableMethods.bekle(2);

    }
    @When("güvenli ödeme işlemine tıklanır")
    public void güvenli_ödeme_işlemine_tıklanır() {
        js.executeScript("arguments[0].click();", atakanPage.güvenliÖdeme);
        ReusableMethods.bekle(1);

    }
    @Then("telefon numarası bilgileri girlir")
    public void telefon_numarası_bilgileri_girlir() {
        atakanPage.ödemeTelBilgileri.click();
        atakanPage.ödemeTelBilgileri.sendKeys(faker.phoneNumber().cellPhone());
        js.executeScript("window.scrollBy(0,250)");
        ReusableMethods.bekle(3);
    }
    @When("öde butonuna tıklanır")
    public void öde_butonuna_tıklanır() {

        atakanPage.ödeButonu.click();
        ReusableMethods.bekle(1);

    }
    @When("ödemeniz başarıyla tamamlandı texti görüntülenmelidir")
    public void ödemeniz_başarıyla_tamamlandı_texti_görüntülenmelidir() {
        ReusableMethods.bekle(3);
        Assertions.assertTrue(atakanPage.ödemeBasariliTexti.isDisplayed());

    }

    @Then("email alanina kayitli student maili girilir")
    public void emailAlaninaKayitliStudentMailiGirilir() {
        atakanPage.email.click();
        atakanPage.email.sendKeys("atakan.user@instulearn.com");
    }

    @Given("sidebarda support linkine tıklanır")
    public void sidebardaSupportLinkineTıklanır() {
        atakanPage.supportLinki.click();
        ReusableMethods.bekle(1);

    }

    @When("new linki görünür ve aktif olmalıdır")
    public void new_linki_görünür_ve_aktif_olmalıdır() {
        Assertions.assertTrue(atakanPage.newLinki.isDisplayed());
        Assertions.assertTrue(atakanPage.newLinki.isEnabled());

    }
    @Then("courses support linki görünür ve aktif olmalıdır")
    public void courses_support_linki_görünür_ve_aktif_olmalıdır() {
        Assertions.assertTrue(atakanPage.coursesSupportLinki.isDisplayed());
        Assertions.assertTrue(atakanPage.coursesSupportLinki.isEnabled());

    }
    @Then("tickets linki görünür ve aktif olmalıdır")
    public void tickets_linki_görünür_ve_aktif_olmalıdır() {
        Assertions.assertTrue(atakanPage.ticketsLinki.isDisplayed());
        Assertions.assertTrue(atakanPage.ticketsLinki.isEnabled());

    }

    @Given("new linkine tıklanır")
    public void new_linkine_tıklanır() {
        atakanPage.newLinki.click();
        ReusableMethods.bekle(1);
    }
    @Given("subject alanına tıklanır ve konu girilir")
    public void subject_alanına_tıklanır_ve_konu_girilir() {
        atakanPage.subjectAlani.click();
        atakanPage.subjectAlani.sendKeys("baglantı problemi");
        ReusableMethods.bekle(2);

    }
    @When("type alanına tıklanır ve platform support secilir")
    public void type_alanına_tıklanır_ve_platform_support_secilir() {
        Select select = new Select(atakanPage.typeAlani);
        select.selectByVisibleText("Platform support");

    }

    @And("department alanına tıklanır ve content secilir")
    public void departmentAlanınaTıklanırVeContentSecilir() {
        atakanPage.departmentAlani.click();
        ReusableMethods.bekle(1);
        atakanPage.contentSecimi.click();
        ReusableMethods.bekle(1);
    }

    @Then("message alanına tıklanır ve mesaj yazılır")
    public void messageAlanınaTıklanırVeMesajYazılır() {
        atakanPage.messasgeAlani.click();
        atakanPage.messasgeAlani.sendKeys("baglantı ile ilgili sorun yasiyorum");
    }

    @And("send message butonuna tıklanır")
    public void sendMessageButonunaTıklanır() {
        atakanPage.sendMessageButonu.click();
        ReusableMethods.bekle(1);

    }
}
