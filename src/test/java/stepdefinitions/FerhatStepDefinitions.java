package stepdefinitions;

import io.cucumber.java.en.*;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.FerhatPage;
import utilities.Driver;

import java.time.Duration;

public class FerhatStepDefinitions {
    FerhatPage ferhatPage = new FerhatPage();
    JavascriptExecutor jse =(JavascriptExecutor) Driver.getDriver();
    Actions actions;
    WebDriverWait wait;
    @When("Subsribe Now yazisi gorunene kadar sayfa asagi kaydirilir")
    public void subsribe_now_yazisi_gorunene_kadar_sayfa_asagi_kaydirilir() {
        jse.executeScript("arguments[0].scrollIntoView({block: 'center'});"
                                                  ,ferhatPage.subcribeNowYazisi);

    }
    @Then("Subscribe Now yazisi goruntulenebilirligi test edilir")
    public void subscribe_now_yazisi_goruntulenebilirligi_test_edilir() {
        Assertions.assertTrue(ferhatPage.subcribeNowYazisi.isDisplayed());
    }
    @Then("Bronze bolumundeki {string} butonuna tiklanir")
    public void bronze_bolumundeki_butonuna_tiklanir(String string) {
        ferhatPage.subscribeNowButtonlari.get(0).click();
    }
    @Then("Login sayfasina yonlendirdigi kontrol edilir")
    public void login_sayfasina_yonlendirdigi_kontrol_edilir() {
        String expectedUrl = "login";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        Assertions.assertTrue(actualUrl.contains(expectedUrl));
    }
    @Then("Tekrar onceki sayfaya gelinir")
    public void tekrar_onceki_sayfaya_gelinir() {
        Driver.getDriver().navigate().back();
    }
    @Then("Gold bolumundeki {string} butonuna tiklanir")
    public void gold_bolumundeki_butonuna_tiklanir(String string) {
        ferhatPage.subscribeNowButtonlari.get(1).click();
    }
    @Then("Silver bolumundeki {string} butonuna tiklanir")
    public void silver_bolumundeki_butonuna_tiklanir(String string) {
        ferhatPage.subscribeNowButtonlari.get(2).click();
    }

    @When("categories linkinin goruntulebilir oldugunu kontrol eder")
    public void categories_linkinin_goruntulebilir_oldugunu_kontrol_eder() {
        ferhatPage.categoriesButton.isDisplayed();
    }
    @When("home linkinin goruntulenebilir oldugunu kontrol eder")
    public void home_linkinin_goruntulenebilir_oldugunu_kontrol_eder() {
        ferhatPage.ustBarLinkleri.get(0).isDisplayed();
    }
    @Then("courses linkinin goruntulenebilir oldugunu kontrol eder")
    public void courses_linkinin_goruntulenebilir_oldugunu_kontrol_eder() {
        ferhatPage.ustBarLinkleri.get(1).isDisplayed();
    }
    @Then("instructors linkinin goruntulenebilir oldugunu kontrol eder")
    public void instructors_linkinin_goruntulenebilir_oldugunu_kontrol_eder() {
        ferhatPage.ustBarLinkleri.get(2).isDisplayed();
    }
    @Then("store linkinin goruntulenebilir oldugunu kontrol eder")
    public void store_linkinin_goruntulenebilir_oldugunu_kontrol_eder() {
        ferhatPage.ustBarLinkleri.get(3).isDisplayed();
    }
    @Then("blog linkinin goruntulenebilir oldugunu kontrol eder")
    public void blog_linkinin_goruntulenebilir_oldugunu_kontrol_eder() {
        ferhatPage.ustBarLinkleri.get(4).isDisplayed();
    }
    @When("home linkine tiklar")
    public void home_linkine_tiklar() {
        ferhatPage.ustBarLinkleri.get(0).click();
    }
    @Then("anasayfaya yonlendirildigi kontrol edilir")
    public void anasayfaya_yonlendirildigi_kontrol_edilir() {
        String expectedTitle ="Home";
        String actualTitle = Driver.getDriver().getTitle();

        Assertions.assertTrue(actualTitle.contains(expectedTitle));
    }
    @When("categories linkine tiklar")
    public void categories_linkine_tiklar() {
        ferhatPage.categoriesButton.click();
    }
    @When("acilan menude development linkinin uzerine gelinir")
    public void acilan_menude_development_linkinin_uzerine_gelinir() {
        actions = new Actions(Driver.getDriver());
        actions.moveToElement(ferhatPage.developmentLink).perform();


    }

    @Then("dogru sayfaya yonlendirdigi kontrol edilir")
    public void dogru_sayfaya_yonlendirdigi_kontrol_edilir() {
        String expectedUrl = "Web-Development";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        Assertions.assertTrue(actualUrl.contains(expectedUrl));
    }

    @When("acilan menude {string} linkine tiklar")
    public void acilan_menude_linkine_tiklar(String kategoriIsmi) {
        String dinamikXpath="//a[normalize-space()='"+kategoriIsmi+"']";
        WebElement menuElemani = Driver.driver.findElement(By.xpath(dinamikXpath));
        menuElemani.click();


    }
    @Then("kullanici {string} adresine yonlendirilmelidir")
    public void kullanici_adresine_yonlendirilmelidir(String dogruUrl) {
        String expectedUrl=""+dogruUrl;
        String actualUrl = Driver.getDriver().getCurrentUrl();

        Assertions.assertTrue(actualUrl.contains(expectedUrl));
    }


    @And("acilan menude {string} linkinin uzerine gelinir")
    public void acilanMenudeLinkininUzerineGelinir(String anaKategori) {
        String dinamikXpath="//a[normalize-space()='"+anaKategori+"']";
        WebElement menuElemani = Driver.driver.findElement(By.xpath(dinamikXpath));
        actions = new Actions(Driver.getDriver());
        actions.moveToElement(menuElemani).perform();
    }
    @When("anasayfa sol üst kosesinde bulunan anasayfa logosunun gorunur ve aktif oldugu kontrol edilir")
    public void anasayfa_sol_üst_kosesinde_bulunan_anasayfa_logosunun_gorunur_ve_aktif_oldugu_kontrol_edilir() {
        Assertions.assertTrue(ferhatPage.siteLogo.isDisplayed());
        Assertions.assertTrue(ferhatPage.siteLogo.isEnabled());
    }
    @When("anasayfa sol üst kosesinde bulunan anasayfa logosuna tiklanir")
    public void anasayfa_sol_üst_kosesinde_bulunan_anasayfa_logosuna_tiklanir() {
        ferhatPage.siteLogo.click();

    }
    @Then("anasayfanin yenilendigi kontrol edilir")
    public void anasayfanin_yenilendigi_kontrol_edilir() {
        String expectedTitle ="Home";
        String actualTitle =Driver.getDriver().getTitle();

        Assertions.assertTrue(actualTitle.contains(expectedTitle));

    }
    @When("anasayfa sag ust kosesinde Card ve Notifications butonlarinin gorunur ve aktif oldugu kontrol edilir")
    public void anasayfa_sag_ust_kosesinde_card_ve_notifications_butonlarinin_gorunur_ve_aktif_oldugu_kontrol_edilir() {
        Assertions.assertTrue(ferhatPage.notificationsLink.isDisplayed());
        Assertions.assertTrue(ferhatPage.notificationsLink.isEnabled());
    }
    @When("anasayfa header kismindaki Search Textbox'a tiklar")
    public void anasayfa_header_kismindaki_search_textbox_a_tiklar() {
        ferhatPage.searchTextbox.click();
    }
    @When("Search Textbox kismina Web yazar ve enter'a basar")
    public void search_textbox_kismina_web_yazar_ve_enter_a_basar() {
        ferhatPage.searchTextbox.click();
        ferhatPage.searchTextbox.sendKeys("Web"+ Keys.ENTER);
    }
    @Then("arama sonucunda Web ile ilgili degerler bulundugunu kontrol eder")
    public void arama_sonucunda_web_ile_ilgili_degerler_bulundugunu_kontrol_eder() {
        String expectedResult="Web";
        String actualResult = ferhatPage.searchTextboxSonuc.getText();

        Assertions.assertTrue(actualResult.contains(expectedResult));

    }
    @When("anasayfa header kismindaki Start learning butonunun gorunur oldugunu kontrol eder ve tiklar")
    public void anasayfa_header_kismindaki_start_learning_butonunun_gorunur_oldugunu_kontrol_eder_ve_tiklar() {
        Assertions.assertTrue(ferhatPage.startLearningButton.isDisplayed());
        ferhatPage.startLearningButton.click();
    }

    @When("Kullanici header kismindaki Login linkine tiklar")
    public void kullanici_header_kismindaki_login_linkine_tiklar() {
        ferhatPage.loginLink.click();
    }
    @Then("Header kismindaki Register linkine tiklar")
    public void header_kismindaki_register_linkine_tiklar() {
        ferhatPage.registerLink.click();
    }
    @Then("Register sayfasina yonlendirdigi kontrol edilir")
    public void register_sayfasina_yonlendirdigi_kontrol_edilir() {
        String expectedUrl ="register";
        String actualUrl =Driver.getDriver().getCurrentUrl();
        Assertions.assertTrue(actualUrl.contains(expectedUrl));
    }


}
