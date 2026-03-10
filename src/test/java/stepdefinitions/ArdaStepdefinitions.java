package stepdefinitions;

import io.cucumber.java.en.*;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.JavascriptExecutor;
import pages.ArdaPage;
import utilities.ConfigReader;
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
    }@Given("kullanici anasayfaya gider")
    public void kullanici_anasayfaya_gider() {
        Driver.getDriver().get(ConfigReader.getProperty("instulearnUrl"));
        ReusableMethods.bekle(2);
    }

    @When("arda valid bilgilerle login olur")
    public void arda_valid_bilgilerle_login_olur() {
        ardaPage.loginLink.click();
        ReusableMethods.bekle(2);

        ReusableMethods.scrollToElement(ardaPage.loginEmailInput);
        ReusableMethods.bekle(1);

        ardaPage.loginEmailInput.click();
        ardaPage.loginEmailInput.clear();
        ardaPage.loginEmailInput.sendKeys("ardaemre.user@instulearn.com");

        ardaPage.loginPasswordInput.click();
        ardaPage.loginPasswordInput.clear();
        ardaPage.loginPasswordInput.sendKeys(ConfigReader.getProperty("gecerliPassword"));

        ReusableMethods.bekle(1);
        ardaPage.loginButton.click();
        ReusableMethods.bekle(3);
    }

    @And("kullanici Store linkine tiklar")
    public void kullanici_store_linkine_tiklar() {
        ReusableMethods.scrollToElement(ardaPage.storeLink);
        ReusableMethods.bekle(1);
        ardaPage.storeLink.click();
        ReusableMethods.bekle(2);

        Assertions.assertTrue(ardaPage.productsTitle.isDisplayed());
    }

    @And("kullanici ilk urune tiklar")
    public void kullanici_ilk_urune_tiklar() {
        ReusableMethods.scrollToElement(ardaPage.firstProduct);
        ReusableMethods.bekle(1);
        ardaPage.firstProduct.click();
        ReusableMethods.bekle(3);

        Assertions.assertTrue(ardaPage.buyNowButton.isDisplayed());
    }

    @And("kullanici Buy Now butonuna tiklar")
    public void kullanici_buy_now_butonuna_tiklar() {
        ReusableMethods.scrollToElement(ardaPage.buyNowButton);
        ReusableMethods.bekle(2);

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView({block:'center'});", ardaPage.buyNowButton);
        ReusableMethods.bekle(1);
        js.executeScript("arguments[0].click();", ardaPage.buyNowButton);

        ReusableMethods.bekle(3);
    }

    @And("kullanici Checkout butonuna tiklar")
    public void kullanici_checkout_butonuna_tiklar() {
        ReusableMethods.scrollToElement(ardaPage.checkoutButton);
        ReusableMethods.bekle(2);

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView({block:'center'});", ardaPage.checkoutButton);
        ReusableMethods.bekle(1);
        js.executeScript("arguments[0].click();", ardaPage.checkoutButton);

        ReusableMethods.bekle(3);
    }

    @And("kullanici Stripe odeme yontemini secer")
    public void kullanici_stripe_odeme_yontemini_secer() {
        ReusableMethods.scrollToElement(ardaPage.stripeLabelCard);
        ReusableMethods.bekle(2);

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView({block:'center'});", ardaPage.stripeLabelCard);
        ReusableMethods.bekle(1);
        js.executeScript("arguments[0].click();", ardaPage.stripeLabelCard);

        ReusableMethods.bekle(2);
    }

    @Then("kullanici Start Payment butonunu goruntuleyebilmelidir")
    public void kullanici_start_payment_butonunu_goruntuleyebilmelidir() {
        Assertions.assertTrue(ardaPage.startPaymentButton.isDisplayed());


        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView({block:'center'});", ardaPage.stripeLabelCard);
        ReusableMethods.bekle(1);
        js.executeScript("arguments[0].click();", ardaPage.stripeLabelCard);

        ReusableMethods.bekle(2);
    }

    @And("kullanici Start Payment butonuna tiklar")
    public void kullanici_start_payment_butonuna_tiklar() {
        ReusableMethods.scrollToElement(ardaPage.startPaymentButton);
        ReusableMethods.bekle(2);

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView({block:'center'});", ardaPage.startPaymentButton);
        ReusableMethods.bekle(1);
        js.executeScript("arguments[0].click();", ardaPage.startPaymentButton);

        ReusableMethods.bekle(4);
    }



    @And("kullanici stripe odeme bilgilerini doldurur")
    public void kullanici_stripe_odeme_bilgilerini_doldurur() {
        ReusableMethods.bekle(3);

        ardaPage.stripeEmailInput.click();
        ardaPage.stripeEmailInput.sendKeys("ardaemretest@gmail.com");
        ReusableMethods.bekle(1);

        ardaPage.cardNumberInput.click();
        ardaPage.cardNumberInput.sendKeys("4242424242424242");
        ReusableMethods.bekle(1);

        ardaPage.cardExpiryInput.click();
        ardaPage.cardExpiryInput.sendKeys("1230");
        ReusableMethods.bekle(1);

        ardaPage.cardCvcInput.click();
        ardaPage.cardCvcInput.sendKeys("123");
        ReusableMethods.bekle(1);

        ardaPage.cardHolderNameInput.click();
        ardaPage.cardHolderNameInput.sendKeys("Arda Emre Demir");
        ReusableMethods.bekle(1);

        ReusableMethods.scrollToElement(ardaPage.saveInfoCheckbox);
        ReusableMethods.bekle(1);

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].click();", ardaPage.saveInfoCheckbox);
        ReusableMethods.bekle(2);

        ardaPage.phoneNumberInput.click();
        ardaPage.phoneNumberInput.sendKeys("05555555555");
        ReusableMethods.bekle(2);
    }

    @Then("kullanici Ode butonuna tiklar")
    public void kullanici_ode_butonuna_tiklar() {
        ReusableMethods.scrollToElement(ardaPage.stripePayButton);
        ReusableMethods.bekle(2);

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView({block:'center'});", ardaPage.stripePayButton);
        ReusableMethods.bekle(1);
        js.executeScript("arguments[0].click();", ardaPage.stripePayButton);

        ReusableMethods.bekle(5);



        ardaPage.loginLink.click();
        ReusableMethods.bekle(2);

        ReusableMethods.scrollToElement(ardaPage.loginEmailInput);
        ReusableMethods.bekle(1);

        ardaPage.loginEmailInput.click();
        ardaPage.loginEmailInput.clear();
        ardaPage.loginEmailInput.sendKeys("ardaemre.user@instulearn.com");

        ardaPage.loginPasswordInput.click();
        ardaPage.loginPasswordInput.clear();
        ardaPage.loginPasswordInput.sendKeys(ConfigReader.getProperty("gecerliPassword"));

        ReusableMethods.bekle(1);
        ardaPage.loginButton.click();
        ReusableMethods.bekle(3);
    }

    @Then("Dashboard sayfasi acilmis olmali")
    public void dashboard_sayfasi_acilmis_olmali() {
        Assertions.assertTrue(Driver.getDriver().getCurrentUrl().contains("/panel"));
        Assertions.assertTrue(ardaPage.dashboardSidebarLink.isDisplayed());
    }

    @And("Dashboard sidebar linkleri gorunur olmalidir")
    public void dashboard_sidebar_linkleri_gorunur_olmalidir() {
        Assertions.assertTrue(ardaPage.dashboardSidebarLink.isDisplayed());
        Assertions.assertTrue(ardaPage.coursesSidebarLink.isDisplayed());
        Assertions.assertTrue(ardaPage.meetingsSidebarLink.isDisplayed());
        Assertions.assertTrue(ardaPage.quizzesSidebarLink.isDisplayed());
        Assertions.assertTrue(ardaPage.certificatesSidebarLink.isDisplayed());
        Assertions.assertTrue(ardaPage.financialSidebarLink.isDisplayed());
        Assertions.assertTrue(ardaPage.supportSidebarLink.isDisplayed());
        Assertions.assertTrue(ardaPage.notificationsSidebarLink.isDisplayed());
        Assertions.assertTrue(ardaPage.settingsSidebarLink.isDisplayed());
        Assertions.assertTrue(ardaPage.logoutSidebarLink.isDisplayed());
    }

    @And("Dashboard sidebar linkleri tiklanabilir olmalidir")
    public void dashboard_sidebar_linkleri_tiklanabilir_olmalidir() {
        Assertions.assertTrue(ardaPage.dashboardSidebarLink.isEnabled());
        Assertions.assertTrue(ardaPage.coursesSidebarLink.isEnabled());
        Assertions.assertTrue(ardaPage.meetingsSidebarLink.isEnabled());
        Assertions.assertTrue(ardaPage.quizzesSidebarLink.isEnabled());
        Assertions.assertTrue(ardaPage.certificatesSidebarLink.isEnabled());
        Assertions.assertTrue(ardaPage.financialSidebarLink.isEnabled());
        Assertions.assertTrue(ardaPage.supportSidebarLink.isEnabled());
        Assertions.assertTrue(ardaPage.notificationsSidebarLink.isEnabled());
        Assertions.assertTrue(ardaPage.settingsSidebarLink.isEnabled());
        Assertions.assertTrue(ardaPage.logoutSidebarLink.isEnabled());
    }@And("View All Events linki gorunur ve aktif olmalidir")
    public void view_all_events_linki_gorunur_ve_aktif_olmalidir() {
        Assertions.assertTrue(ardaPage.viewAllEventsLink.isDisplayed());
        Assertions.assertTrue(ardaPage.viewAllEventsLink.isEnabled());
    }

    @And("Dashboard bilgi karti linkleri gorunur olmalidir")
    public void dashboard_bilgi_karti_linkleri_gorunur_olmalidir() {
        Assertions.assertTrue(ardaPage.accountBalanceCard.isDisplayed());
        Assertions.assertTrue(ardaPage.purchasedCoursesLink.isDisplayed());
        Assertions.assertTrue(ardaPage.meetingsBodyLink.isDisplayed());
        Assertions.assertTrue(ardaPage.supportMessagesLink.isDisplayed());
        Assertions.assertTrue(ardaPage.commentsLink.isDisplayed());
    }

    @And("Dashboard bilgi karti linkleri tiklanabilir olmalidir")
    public void dashboard_bilgi_karti_linkleri_tiklanabilir_olmalidir() {
        Assertions.assertTrue(ardaPage.purchasedCoursesLink.isEnabled());
        Assertions.assertTrue(ardaPage.meetingsBodyLink.isEnabled());
        Assertions.assertTrue(ardaPage.supportMessagesLink.isEnabled());
        Assertions.assertTrue(ardaPage.commentsLink.isEnabled());
    }@And("Learning Statistics bolumu gorunur olmalidir")
    public void learning_statistics_bolumu_gorunur_olmalidir() {
        Assertions.assertTrue(ardaPage.learningStatisticsTitle.isDisplayed());
    }

    @And("Aylik ogrenme grafigi gorunur olmalidir")
    public void aylik_ogrenme_grafigi_gorunur_olmalidir() {
        Assertions.assertTrue(ardaPage.monthlyLearningChart.isDisplayed());
    }
}

