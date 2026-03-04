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
    }

}