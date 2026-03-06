package stepdefinitions;

import io.cucumber.java.en.*;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.YaprakPage;
import utilities.ConfigReader;
import utilities.Driver;
import org.openqa.selenium.JavascriptExecutor;
import utilities.ReusableMethods;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import java.util.List;
import io.cucumber.datatable.DataTable;
import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import static utilities.Driver.driver;


public class YaprakStepdefinitions {

YaprakPage yaprakPage = new YaprakPage();
WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
Actions action = new Actions(Driver.getDriver());
JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
Faker faker = new Faker();

//-----------------------------------------------------------------------------------------------------US15
    @When("Kullanici organizations bolumune scroll yapar")
    public void kullanici_organizations_bolumune_scroll_yapar() {
    js.executeScript("arguments[0].scrollIntoView(true);", yaprakPage.allOrganizationsBtn);
    }
    @Then("all organizations butonu gorunur ve aktif olmali")
    public void allOrganizationsButonuGorunurVeAktifOlmali() {
    assertTrue(yaprakPage.allOrganizationsBtn.isDisplayed(),
            "all organizations butonu gorunur degil");
    assertTrue(yaprakPage.allOrganizationsBtn.isEnabled(),
            "all organizations butonu aktif degil");
    ReusableMethods.bekle(10);
    }
    @When("Kullanici {string}. organizasyon kursuna tiklar")
    public void kullanici_organizasyon_kursuna_tiklar(String index) {

    int i = Integer.parseInt(index);

    List<WebElement> orgLinks = driver.findElements(
            By.xpath("//div[contains(@class,'organization-swiper-container')]//div[contains(@class,'swiper-slide') and not(contains(@class,'swiper-slide-duplicate'))]//a")
    );
    WebElement selected = orgLinks.get(i - 1);
    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", selected);
    }
    @When("Kullanici son slider butonuna tiklar")
    public void kullanici_son_slider_butonuna_tiklar() {
    wait.until(ExpectedConditions.elementToBeClickable(yaprakPage.lastSlideBtn));
    yaprakPage.lastSlideBtn.click();
    }
    @And("Kullanici sayfada kurs detaylarini goruntuler")
    public void kullanici_sayfada_kurs_detaylarini_goruntuler() {
    action.sendKeys(Keys.PAGE_DOWN).perform();
    wait.until(ExpectedConditions.elementToBeClickable(yaprakPage.coursesTab));
    yaprakPage.coursesTab.click();
    ReusableMethods.bekle(5);
    action.sendKeys(Keys.PAGE_DOWN).perform();
    ReusableMethods.bekle(4);
    assertTrue(
            yaprakPage.noCourseMessageList.isEmpty(),
            "Bug: Instructor doesn't have any course! mesaji gorundu"
    );



    }

//-----------------------------------------------------------------------------------------------------US43
    //US_043_01
    @When("Kullanici sisteme {string} olur")
    public void kullaniciSistemeLoginOlur(String login) {
    yaprakPage.ilkLoginButonu.click();
    wait.until(ExpectedConditions.visibilityOf(yaprakPage.emailKutusu));
    yaprakPage.emailKutusu.sendKeys("yaprak.user@instulearn.com");
    yaprakPage.passwordKutusu.sendKeys(ConfigReader.getProperty("gecerliPassword"));
    yaprakPage.submitLoginButonu.click();
    wait.until(ExpectedConditions.not(ExpectedConditions.urlContains("login")));
    ReusableMethods.bekle(3);

    }
    @Given("Kullanici dashboard alt menusune tiklar")
    public void kullaniciDashboardAltMenusuneTiklar() {
    yaprakPage.dashboardAltMenu.click();
    ReusableMethods.bekle(2);
    }
    @And("Kullanici Quizzes menusune tiklar")
    public void kullaniciQuizzesMenusuneTiklar() {
    js.executeScript("document.querySelector('#panel-sidebar-scroll .simplebar-content-wrapper').scrollBy(0,200);");
    yaprakPage.QuizzesMenu.click();
    ReusableMethods.bekle(2);

    }
    @Then("linklerin gorunur ve aktif oldugunu dogrular")
    public void linklerinGorunurVeAktifOldugunuDogrular() {
    assertTrue(yaprakPage.myResultsMenu.isDisplayed(),
        "My Results linki gorunur degil");
    ReusableMethods.bekle(3);
    assertTrue(yaprakPage.myResultsMenu.isEnabled(),
        "My Results linki aktif degil");
    ReusableMethods.bekle(2);
    assertTrue(yaprakPage.notParticipatedMenu.isDisplayed(),
        "Not Participated linki gorunur degil");
    ReusableMethods.bekle(1);
    assertTrue(yaprakPage.notParticipatedMenu.isEnabled(),
        "Not Participated linki aktif degil");
    ReusableMethods.bekle(3);
    }

    //US_043_02
    @Then("{string} sayfasinin acildigini dogrular")
    public void sayfasinin_acildigini_dogrular(String sayfaAdi) {
    ReusableMethods.bekle(3);
    String urlPart;

    switch (sayfaAdi) {

    case "My Results":
        urlPart = "my-results";
        break;

    case "Not Participated":
        urlPart = "opens";
        break;

    // Yeni menü geldiğinde buraya ekle
    default:
        throw new RuntimeException("Bu sayfa icin URL tanimli degil: " + sayfaAdi);
    }

    String expectedUrl = "/panel/quizzes/" + urlPart;

    wait.until(ExpectedConditions.urlContains(expectedUrl));

    assertTrue(
        Driver.getDriver().getCurrentUrl().contains(expectedUrl),
        "URL beklenen path'i icermiyor"
    );
    }
    @Then("Kullanici sinav istatistiklerini goruntuler")
    public void kullanici_sinav_istatistiklerini_goruntuler() {
    // Burada sadece istatistik bolumunun gorunur oldugunu kontrol et
    assertTrue(yaprakPage.resultsStatisticsTitle.isDisplayed(),
        "Sinav istatistikleri bolumu gorunmuyor");

    }
    @When("Kullanici sinav sonuclarini filtreler ve sonucu dogrular")
    public void kullanici_sinav_sonuclarini_filtreler_ve_sonucu_dogrular() {
    // From
    WebElement from = yaprakPage.fromDateInput;
    from.click();
    from.clear();
    from.sendKeys("01-03-2026");
    from.sendKeys(Keys.TAB);
    // To
    WebElement to = yaprakPage.toDateInput;
    to.click();
    to.clear();
    to.sendKeys("26-02-2026");
    to.sendKeys(Keys.TAB);

    yaprakPage.showResultsButton.click();
    ReusableMethods.bekle(2);
    action.sendKeys(Keys.PAGE_DOWN).perform();
    assertFalse(
        yaprakPage.noResult.isDisplayed(),
        "Bug: Filtrelenen tarihlere rağmen mevcut kurslar/sınavlar listelenmiyor"
    );

    }
    @Given("Kullanici {string} menusunden {string} linkine tiklar")
    public void kullanici_menusunden_linkine_tiklar(String menu, String link) {
    js.executeScript("document.querySelector('#panel-sidebar-scroll .simplebar-content-wrapper').scrollBy(0,200);");

    By anaMenuLocator = By.xpath("//*[normalize-space()='" + menu + "']");
    wait.until(ExpectedConditions.elementToBeClickable(anaMenuLocator)).click();

    // Case insensitive eşleşme
    String lowerLink = link.toLowerCase();

    By altMenuLocator = By.xpath(
        "//a[translate(normalize-space(), " +
                "'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz') = '"
                + lowerLink + "']"
    );

    wait.until(ExpectedConditions.elementToBeClickable(altMenuLocator)).click();
    ReusableMethods.bekle(3);
    }

    //@US_43_03
    @And("Kullanici henuz girilmemis sinavlari iceren listeyi goruntuler")
    public void kullaniciHenuzGirilmemisSinavlariIcerenListeyiGoruntuler() {
    List<WebElement> list = yaprakPage.alinmayanSinavlar;
    if (!list.isEmpty()) {
    System.out.println("⬇Henüz girilmemiş " + list.size() + " sınav bulundu");
    } else {
    System.out.println("Henüz girilmemiş sınav bulunamadı");
    }
    assertFalse(list.isEmpty(),
        "Henüz girilmemiş sınav listesi görünmüyor");


    }

//-----------------------------------------------------------------------------------------------------US45


    // @Us_45_TC01
    @When("Kullanici financialMenu tiklar")
    public void kullaniciFinancialMenuTiklar() {
        yaprakPage.financialMenu.click();
        ReusableMethods.bekle(2);
    }
    @And("Kullanici dashboard menusunde aşağı scroll yapar")
    public void kullaniciDashboardMenusundeAşağıScrollYapar() {
        js.executeScript("document.querySelector('#panel-sidebar-scroll .simplebar-content-wrapper').scrollBy(0,400);");
    }
    @Then("Alt Menu linklerin gorunur ve aktif oldugunu dogrular")
    public void alt_menu_linklerin_gorunur_ve_aktif_oldugunu_dogrular(DataTable dataTable) {

        List<String> menuList = dataTable.asList();

        for (String eachMenu : menuList) {

            WebElement element = null;

            switch (eachMenu) {

                case "Financial Summary":
                    element = yaprakPage.financialSummaryMenu;
                    break;

                case "Sales report":
                    element = yaprakPage.salesReportMenu;
                    break;

                case "Charge Account":
                    element = yaprakPage.chargeAccountMenu;
                    break;

                case "Subscribe":
                    element = yaprakPage.subscribeMenu;
                    break;

                case "Payout":
                    element = yaprakPage.payoutMenu;
                    break;
            }

            assertTrue(element.isDisplayed());
            assertTrue(element.isEnabled());
        }
    }

    // @Us_45_TC02
    @Given("Kullanici sisteme register olur")
    public void kullaniciSistemeRegisterOlur() {
        yaprakPage.registerMenu.click();
        js.executeScript("window.scrollBy(0,300)");
        yaprakPage.registerStudent.click();
        yaprakPage.registeremail.click();
        yaprakPage.registeremail.clear();
        yaprakPage.registeremail.sendKeys(faker.internet().emailAddress());
        yaprakPage.registerFullname.click();
        yaprakPage.registerFullname.clear();
        yaprakPage.registerFullname.sendKeys(faker.name().fullName());
        yaprakPage.registerPassword.click();
        yaprakPage.registerPassword.clear();
        yaprakPage.registerPassword.sendKeys(ConfigReader.getProperty("gecerliPassword"));
        yaprakPage.registerConfirmpassword.click();
        yaprakPage.registerConfirmpassword.clear();
        yaprakPage.registerConfirmpassword.sendKeys(ConfigReader.getProperty("gecerliPassword"));
        js.executeScript("arguments[0].click();", yaprakPage.registerIAgreeButon);
        ReusableMethods.bekle(1);
        yaprakPage.registerSignUpButon.click();
        ReusableMethods.bekle(3);
        yaprakPage.userEnter.click();
        ReusableMethods.bekle(2);

    }
    @Then("Kullanici Payout menusune tiklar")
    public void kullaniciPayoutMenusuneTiklar() {

        yaprakPage.payoutMenu.click();
    }
    @And("Kullanici yönlendirme uyarısını onaylar")
    public void kullanici_yonlendirme_uyarisini_onaylar() {
        // Ekranda çıkan payout settings linkine/uyarısına tıklar
        yaprakPage.payoutYonlendirmeSetting.click();
        ReusableMethods.bekle(2);
    }
    @Then("Hesap Isim IBAN doldurur")
    public void isim_ve_iban_doldurur() {
        Select select = new Select(yaprakPage.bankSelect);
        select.selectByVisibleText("Stripe");
        yaprakPage.bankSelect.sendKeys(Keys.TAB);
        ReusableMethods.bekle(1);
        yaprakPage.accountHolder.sendKeys(faker.name().fullName());

        yaprakPage.bankSelect.sendKeys(Keys.TAB);
        yaprakPage.accountID.sendKeys(faker.finance().iban());

        ReusableMethods.bekle(1);
    }
    @And("Kullanici {string} tıklayarak bir payout hesabı oluşturur.")
    public void kullanici_tiklayarak_bir_payout_hesabi_olusturur(String butonAdi) {
        yaprakPage.savePayoutAccount.click();
        ReusableMethods.bekle(5);

    }
    @Then("Yeni hesabın açıldığını doğrular")
    public void yeni_hesabin_acildigini_dogrular() {
        yaprakPage.dashboardAltMenu.click();
        ReusableMethods.bekle(1);
        js.executeScript("document.querySelector('#panel-sidebar-scroll .simplebar-content-wrapper').scrollBy(0,200);");
        yaprakPage.financialMenu.click();
        ;
        ReusableMethods.bekle(1);
        yaprakPage.payoutMenu.click();
        ReusableMethods.bekle(1);
        assertFalse(
                yaprakPage.payoutYonlendirmeSetting.isDisplayed(),
                "HATA: Hesap olusturuldu mesajı çıkmasına ragmen, " +
                        "payout sayfasında settings hesap açılış uyarisi hala gorunuyor. " +
                        "Hesap açılmadı!!");
    }

    // @Us_45_TC03
    @And("Kullanici Payout request talebi oluşturur")
    public void kullanici_payout_request_talebi_olusturur() {
        ReusableMethods.bekle(2);
        yaprakPage.requestPayout.click();
        ReusableMethods.bekle(1);
        js.executeScript(
                "document.querySelector('button.js-submit-payout').click();"
        );
        js.executeScript(
                "document.querySelector(\"button[class*='close-swl']\").click();"
        );
        ReusableMethods.bekle(2);
        js.executeScript("window.scrollBy(0,200)");
        ReusableMethods.bekle(2);

    }
    @Then("Payout request işleminin onaylandığını doğrular")
    public void payoutRequestIşlemininOnaylandığınıDoğrular() {
        ReusableMethods.bekle(3);
        yaprakPage.requestPayout.click();
        ReusableMethods.bekle(4);
        String status = yaprakPage.requestPayoutStatu.getText();
        if (status.equalsIgnoreCase("Waiting")) {

        }
        assertFalse(
                status.equalsIgnoreCase("Waiting"),
                "Bug: Payout request 'Waiting' durumunda kaldı."
        );

    }

    // @Us_45_TC04
    @And("Kullanci setting menusunden identity & financial menusune gelip")
    public void kullanciSettingMenusundenIdentityFinancialMenusuneGelip() {
        ReusableMethods.bekle(2);
        yaprakPage.settingsMenu.click();
        ReusableMethods.bekle(2);
        yaprakPage.identityFinancialStep.click();
    }
    @When("oluşturduğu Payout hesabını siler")
    public void oluşturduğuPayoutHesabınıSiler() {
        ReusableMethods.bekle(2);
        yaprakPage.deleteAccountButton.click();
        ReusableMethods.bekle(2);
        ReusableMethods.scrollToElement(yaprakPage.payoutConfirmDeleteButton);
        ReusableMethods.bekle(1);
        yaprakPage.payoutConfirmDeleteButton.click();
    }
    @Then("Hesabin silindigini doğrular")
    public void hesabinSilindiginiDoğrular() {
        ReusableMethods.bekle(2);
        ReusableMethods.scrollToElement(yaprakPage.deleteAccoutnSuccessPopupTitle);
        ReusableMethods.bekle(1);
        yaprakPage.deleteAccoutnSuccessPopupTitle.isDisplayed();
        Driver.getDriver().navigate().refresh();
        js.executeScript("window.scrollBy(0,-250)");
        ReusableMethods.bekle(2);
        boolean identityStillApproved = false;
        try {
            js.executeScript("window.scrollBy(0,-250)");
            identityStillApproved = yaprakPage.identityApprovedMessage.isDisplayed();
        } catch (Exception ignored) {
            identityStillApproved = false;
        }
        if (identityStillApproved) {
            ReusableMethods.tarihliTumSayfaResimCek(Driver.getDriver(), "DELETE_FAILED_IDENTITY_APPROVED");
        }
        assertFalse(
                identityStillApproved,
                "Bug: Hesap silinemedi! 'Your identity & financial information approved…' mesajı hâlâ duruyor."
        );
    }

    // @Us_45_TC05
    @Given("Kullanici Charge Account sayfasina gider")
    public void kullanici_charge_account_sayfasina_gider() {
        yaprakPage.ChargeAccount.click();
        ReusableMethods.bekle(2);


    }
    @When("Kullanici Stripe ödeme yöntemini seçer ve tutarı {string} girer")
    public void kullanici_stripe_odeme_yontemini_secer_ve_tutari_girer(String tutar) {
        yaprakPage.chargestripePaymentLabel.click();
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        yaprakPage.chargeamountInput.sendKeys(tutar);
        ReusableMethods.bekle(1);
        yaprakPage.chargepayButton.click();
    }
    @And("Kullanici ödeme bilgilerini girer")
    public void kullanici_odeme_bilgilerini_girer() throws InterruptedException {
        Actions actions = new Actions(driver);

        ReusableMethods.bekle(3);
        yaprakPage.cardNumberInput.sendKeys("4242424242424242");
        actions.sendKeys(Keys.TAB).perform();
        yaprakPage.cardExpiryInput.sendKeys("0230");
        actions.sendKeys(Keys.TAB).perform();
        yaprakPage.cardCvcInput.sendKeys("112");
        actions.sendKeys(Keys.TAB).perform();
        yaprakPage.cardHolderNameInput.sendKeys("yaprak ersan");
        actions.sendKeys(Keys.TAB).perform();
        actions.sendKeys(Keys.TAB).perform();
        yaprakPage.paymentSpinner.click();
        actions.sendKeys(Keys.TAB).perform();
        ReusableMethods.bekle(4);
        wait.until(ExpectedConditions.elementToBeClickable(yaprakPage.chargeemailInput))
                .sendKeys("yaprak.user@instulearn.com");
        ReusableMethods.bekle(6);
        String code = "000000";
        for (int i = 0; i < yaprakPage.smsCodeInputs.size(); i++) {
            yaprakPage.smsCodeInputs.get(i)
                    .sendKeys(String.valueOf(code.charAt(i)));
        }

        ReusableMethods.bekle(3);


    }
    @And("Ödeme işlemini onaylar")
    public void odeme_islemini_onaylar() {
        yaprakPage.submitSpinner.click();

        ReusableMethods.bekle(3);
        ReusableMethods.bekle(5);

    }
    @Then("Doğrulama mesajı görüntülenmelidir")
    public void dogrulama_mesaji_goruntulenmelidir() {
        ReusableMethods.bekle(3);
        assertTrue(
                yaprakPage.congratulationsText.isDisplayed(),
                "Başarı mesajı görülmedi!"
        );
        yaprakPage.chargeAccountMyPanel.click();
        ReusableMethods.bekle(5);

    }
    @Then("Kullanici Subscribe menusune tiklar")
    public void kullaniciSubscribeMenusuneTiklar() {
        yaprakPage.subscribeMenu.click();
        js.executeScript("window.scrollBy(0,250)");
    }
    @Then("Kullanici mevcut planınnın görüntüler")
    public void mevcut_plani_goruntule() {

        wait.until(ExpectedConditions.visibilityOf(yaprakPage.activePlanText));

        String activePlan = yaprakPage.activePlanText.getText();

        System.out.println("Aktif Plan: " + activePlan);

        Assertions.assertFalse(activePlan.isEmpty(), "Plan bilgisi boş!");
    }
    @When("Kullanici mevcut planından farklı bir plan seçer ve ödemeyi tamamlar")
    public void planSecVeOdemeYap() {
        js.executeScript("window.scrollBy(0,200)");
        yaprakPage.goldPurchaseButton.click();
        ReusableMethods.bekle(2);

        assertFalse(
                yaprakPage.goldPurchaseButton.isDisplayed(),
                "Bug: Subscribes Plan seçim butonu aktif değil, test failed"
        );
    }
    @Then("Yeni üyelik planının aktif olduğunu doğrular")
    public void yeniÜyelikPlanınınAktifOlduğunuDoğrular() {
        wait.until(ExpectedConditions.visibilityOf(yaprakPage.activePlanText));
        String activePlan = yaprakPage.activePlanText.getText();
        System.out.println("Yeni Aktif Plan: " + activePlan);
    }














}