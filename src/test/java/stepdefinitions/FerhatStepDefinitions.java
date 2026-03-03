package stepdefinitions;

import io.cucumber.java.en.*;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import pages.FerhatPage;
import utilities.Driver;

public class FerhatStepDefinitions {
    FerhatPage ferhatPage = new FerhatPage();
    JavascriptExecutor jse =(JavascriptExecutor) Driver.getDriver();
    Actions actions;

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
    @When("acilan yeni menude Web Development linkine tiklanir")
    public void acilan_yeni_menude_web_development_linkine_tiklanir() {
        ferhatPage.webdevelopmentLink.click();
    }
    @Then("dogru sayfaya yonlendirdigi kontrol edilir")
    public void dogru_sayfaya_yonlendirdigi_kontrol_edilir() {
        String expectedUrl = "Web-Development";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        Assertions.assertTrue(actualUrl.contains(expectedUrl));
    }


}
