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
    }
}