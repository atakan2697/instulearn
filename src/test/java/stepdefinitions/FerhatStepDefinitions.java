package stepdefinitions;

import io.cucumber.java.en.*;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.JavascriptExecutor;
import pages.FerhatPage;
import utilities.Driver;

public class FerhatStepDefinitions {
    FerhatPage ferhatPage = new FerhatPage();
    JavascriptExecutor jse =(JavascriptExecutor) Driver.getDriver();

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



}
