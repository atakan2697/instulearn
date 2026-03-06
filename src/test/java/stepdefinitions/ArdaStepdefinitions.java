package stepdefinitions;

import io.cucumber.java.en.*;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.JavascriptExecutor;
import pages.ArdaPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class ArdaStepdefinitions {

    ArdaPage ardaPage = new ArdaPage();
    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

    @Then("Validate Certificates kartinin gorunur oldugunu dogrular")
    public void validate_certificates_kartinin_gorunur_oldugunu_dogrular() {

        // Sayfa altlarinda oldugu icin once karta kadar scroll yap
        js.executeScript("arguments[0].scrollIntoView(true);", ardaPage.validateCertificatesCard);
        ReusableMethods.bekle(1);

        // Kartin gorunur oldugunu dogrula
        Assertions.assertTrue(ardaPage.validateCertificatesCard.isDisplayed(),
                "Validate Certificates karti gorunmuyor!");
    }

    @When("Validate Certificates kartina tiklar")
    public void validate_certificates_kartina_tiklar() {
        ardaPage.validateCertificatesCard.click();
        ReusableMethods.bekle(1);
    }

    @Then("Certificate Validation sayfasinin acildigini dogrular")
    public void certificate_validation_sayfasinin_acildigini_dogrular() {

        ReusableMethods.bekle(1);

        // URL dogrulama
        String currentUrl = Driver.getDriver().getCurrentUrl();
        Assertions.assertTrue(currentUrl.contains("certificate_validation"),
                "URL 'certificate_validation' icermiyor! Su anki URL: " + currentUrl);

        // Sayfa basligi dogrulama
        Assertions.assertTrue(ardaPage.certificateValidationTitle.isDisplayed(),
                "Certificate Validation basligi gorunmuyor!");
    }@Then("Reserve a meeting kartinin gorunur oldugunu dogrular")
    public void reserve_a_meeting_kartinin_gorunur_oldugunu_dogrular() {

        js.executeScript("arguments[0].scrollIntoView({block:'center'});", ardaPage.reserveMeetingCardImg);
        ReusableMethods.bekle(1);

        Assertions.assertTrue(ardaPage.reserveMeetingCardImg.isDisplayed(),
                "Reserve a meeting kart gorseli gorunmuyor!");
    }

    @When("Reserve a meeting kartina tiklar")
    public void reserve_a_meeting_kartina_tiklar() {

        js.executeScript("arguments[0].scrollIntoView({block:'center'});", ardaPage.reserveMeetingCardImg);
        ReusableMethods.bekle(1);

        // img'nin parent'i olan <a> elementine tikla (navbar’a gitmez)
        ardaPage.reserveMeetingCardImg.findElement(org.openqa.selenium.By.xpath("./parent::a")).click();
        ReusableMethods.bekle(1);
    }

    @Then("Instructors sayfasinin acildigini dogrular")
    public void instructors_sayfasinin_acildigini_dogrular() {
        String expectedUrl = "https://qa.instulearn.com/instructors";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assertions.assertEquals(expectedUrl, actualUrl);
    }@Then("Her iki kartin da tiklanabilir oldugunu dogrular")
    public void her_iki_kartin_da_tiklanabilir_oldugunu_dogrular() {

        // Validate Certificates clickable mı?
        Assertions.assertTrue(ardaPage.validateCertificatesCard.isEnabled(),
                "Validate Certificates karti tiklanabilir degil!");

        // Reserve a meeting clickable mı?
        // IMG isEnabled bazen true/false saçmalayabilir, o yüzden parent <a> kontrol edeceğiz
        var reserveLink = ardaPage.reserveMeetingCardImg.findElement(org.openqa.selenium.By.xpath("./parent::a"));
        Assertions.assertTrue(reserveLink.isEnabled(),
                "Reserve a meeting karti tiklanabilir degil!");

    }@Then("Store linkinin gorunur oldugunu dogrular")
    public void store_linkinin_gorunur_oldugunu_dogrular() {

        Assertions.assertTrue(ardaPage.storeLink.isDisplayed(),
                "Store linki gorunmuyor!");

        Assertions.assertTrue(ardaPage.storeLink.isEnabled(),
                "Store linki tiklanabilir degil!");
    }

    @When("Store linkine tiklar")
    public void store_linkine_tiklar() {

        ardaPage.storeLink.click();
        ReusableMethods.bekle(2);
    }

    @Then("Products sayfasinin acildigini dogrular")
    public void products_sayfasinin_acildigini_dogrular() {

        Assertions.assertTrue(ardaPage.productsTitle.isDisplayed(),
                "Products sayfasi acilmadi!");
    }@Then("Search textbox ve Search butonunun gorunur ve aktif oldugunu dogrular")
    public void search_textbox_ve_search_butonunun_gorunur_ve_aktif_oldugunu_dogrular() {

        Assertions.assertTrue(ardaPage.searchTextbox.isDisplayed());
        Assertions.assertTrue(ardaPage.searchTextbox.isEnabled());

        Assertions.assertTrue(ardaPage.searchButton.isDisplayed());
        Assertions.assertTrue(ardaPage.searchButton.isEnabled());
    }


    @Then("Filtreleme bolumunun gorunur oldugunu dogrular")
    public void filtreleme_bolumunun_gorunur_oldugunu_dogrular() {

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        js.executeScript("arguments[0].scrollIntoView(true);", ardaPage.filterItemsButton);
        ReusableMethods.bekle(1);

        Assertions.assertTrue(ardaPage.filterItemsButton.isDisplayed());
    }


    @When("Urun secmeden filtreleme uygular")
    public void urun_secmeden_filtreleme_uygular() {

        ardaPage.filterItemsButton.click();
        ReusableMethods.bekle(2);
    }


    @Then("Filtreleme sonrasi urun listesinin guncellendigini dogrular")
    public void filtreleme_sonrasi_urun_listesinin_guncellendigini_dogrular() {

        Assertions.assertFalse(ardaPage.productCards.isEmpty());
    }@When("Products sayfasinda listelenen urunlerden biri secilir")
    public void products_sayfasinda_listelenen_urunlerden_biri_secilir() {

        ReusableMethods.bekle(2);
        ardaPage.productTitleFromList.click();
    }

    @Then("Secilen urune ait fiyat bilgisinin gorunur oldugu kontrol edilir")
    public void secilen_urune_ait_fiyat_bilgisinin_gorunur_oldugu_kontrol_edilir() {

        Assertions.assertTrue(ardaPage.productPrice.isDisplayed());
    }

    @Then("Satici bilgisinin gorunur oldugu kontrol edilir")
    public void satici_bilgisinin_gorunur_oldugu_kontrol_edilir() {

        Assertions.assertTrue(ardaPage.sellerTab.isDisplayed());
    }

    @Then("Urun adi ve description bilgilerinin goruntulendigi dogrulanir")
    public void urun_adi_ve_description_bilgilerinin_goruntulendigi_dogrulanir() {

        ((JavascriptExecutor) Driver.getDriver())
                .executeScript("window.scrollBy(0,400)");

        ReusableMethods.bekle(1);

        Assertions.assertTrue(ardaPage.productDescription.isDisplayed());
    }

    @Then("Urun detay sayfasinda puanlama rating alaninin gorunur oldugu dogrulanir")
    public void urun_detay_sayfasinda_puanlama_rating_alaninin_gorunur_oldugu_dogrulanir() {

        Assertions.assertTrue(ardaPage.ratingArea.isDisplayed());
    }

    @Then("Urunle ilgili yorum yapilabilen alanin gorunur oldugu dogrulanir")
    public void urunle_ilgili_yorum_yapilabilen_alanin_gorunur_oldugu_dogrulanir() {

        ((JavascriptExecutor) Driver.getDriver())
                .executeScript("arguments[0].scrollIntoView(true);", ardaPage.commentBox);

        ReusableMethods.bekle(1);

        Assertions.assertTrue(ardaPage.commentBox.isDisplayed());
    }

}