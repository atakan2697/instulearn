package stepdefinitions;

import io.cucumber.java.en.*;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.JavascriptExecutor;
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

    @Given("Listelenen kurs kartlari görünür olmalı")
    public void listelenen_kurs_kartlari_görünür_olmalı() {
        Assertions.assertFalse(atakanPage.kursKartlariList.isEmpty());
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
        ReusableMethods.bekle(1);
       atakanPage.kursKartlariList.get(0).click();
       ReusableMethods.bekle(2);
    }
    @Then("kurs detay sayfasına yönlendirme yapar")
    public void kurs_detay_sayfasına_yönlendirme_yapar() {

    }
    @When("kurs kartında add to card ve buy now seçeneği varsa görünür ve aktif olmalıdır")
    public void kurs_kartında_add_to_card_ve_buy_now_seçeneği_varsa_görünür_ve_aktif_olmalıdır() {

    }
    @Then("kurs kartında add to card ve buy now seçeneği varsa about this course görüntülenmelidir")
    public void kurs_kartında_add_to_card_ve_buy_now_seçeneği_varsa_about_this_course_görüntülenmelidir() {

        for (int i = 0; i < atakanPage.kursKartlariList.size(); i++) {

            atakanPage.kursKartlariList.get(i).click();
            if (atakanPage.addToCardButonu.isDisplayed()){
                atakanPage.addToCardButonu.click();
            }
            else {
                Driver.getDriver().navigate().back();
                atakanPage.kursKartlariList.get(i).click();
                System.out.println(atakanPage.kursKartlariList.get(i).getText().toString());

            }
        }


    }
}
