package stepdefinitions;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.SevkiPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.time.Duration;

import static utilities.Driver.driver;

public class SevkiStepDefinitions {

    SevkiPage sevkiPage = new SevkiPage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));

    //-----------------------------------------------------US_03--------------------------------------------------------


    @When("Sayfa tamamen yüklenir")
    public void sayfa_tamamen_yuklenir() {
        sevkiPage.waitForPageReady();
    }

    @Then("Anasayfa body bölümünde {string} başlığı görünür olmalı")
    public void anasayfa_body_bolumunde_baslik_gorunur_olmali(String expectedTitle) {
        Assertions.assertTrue(
                sevkiPage.isHeroTitleVisible(expectedTitle),
                "Başlık görünür değil veya metin beklenen gibi değil!"
        );
    }

    @Then("Anasayfa body bölümünde search box görünür ve aktif olmalı")
    public void anasayfa_body_bolumunde_search_box_gorunur_ve_aktif_olmali() {
        Assertions.assertTrue(
                sevkiPage.isSearchBoxVisibleAndEnabled(),
                "Search box görünür değil veya aktif değil!"
        );
    }

    @Then("Search butonu görünür ve aktif olmalı")
    public void search_butonu_gorunur_ve_aktif_olmali() {
        Assertions.assertTrue(
                sevkiPage.isSearchButtonVisibleAndEnabled(),
                "Search butonu görünür değil veya aktif değil!"
        );
    }
//-------------------------------------------------- US_41--------------------------------------------------------------


    @When("kullanici login butonuna basar ve student olarak giris yapar")
    public void kullaniciLoginButonunaBasarVeStudentOlarakGirisYapar() {
        sevkiPage.loginLink.click();

        sevkiPage.emailInput.sendKeys("sevki.user@instulearn.com");

        sevkiPage.passwordInput.sendKeys(ConfigReader.getProperty("gecerliPassword"));

        sevkiPage.loginButton.click();

        ReusableMethods.bekle(2);
    }

    @When("kullanici dashboard sayfasindaki sidebar’da bulunan course menusunu goruntuler")
    public void kullaniciDashboardSayfasindakiSidebarDaBulunanCourseMenusunuGoruntuler() {
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].scrollIntoView(true);", sevkiPage.coursesMenu);
    }

    @When("Course menusunun gorunur ve tiklanabilir oldugu dogrulanir")
    public void courseMenusununGorunurVeTiklanabilirOlduguDogrulanir() {
        Assertions.assertTrue(sevkiPage.coursesMenu.isEnabled());
    }

    @When("kullanici Course menusunu tıklar")
    public void kullaniciCourseMenusunuTıklar() {
        sevkiPage.coursesMenu.click();
        ReusableMethods.bekle(4);
    }

    @Then("{string} linki görünür ve tıklanabilir olduğu doğrulanır")
    public void linkiGörünürVeTıklanabilirOlduğuDoğrulanır(String arg0) {
        Assertions.assertTrue(sevkiPage.myPurchasesLink.isEnabled());
    }


    @When("{string} linkine tıklar")
    public void linkine_tıklar(String string) {
        sevkiPage.myPurchasesLink.click();
        ReusableMethods.bekle(4);
    }

    @When("Listeden ilk kursu seçer")
    public void listeden_ilk_kursu_seçer() {

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

        wait.until(ExpectedConditions.elementToBeClickable(sevkiPage.firstCourseMenuButton)).click();
        sevkiPage.invoiceLink.click();
        ReusableMethods.bekle(4);
    }

    @Then("Kurs faturası görüntülenebilmeli")
    static void kurs_faturası_görüntülenebilmeli() {
        Assertions.assertTrue(SevkiPage.invoiceNumber.isDisplayed());


    }


    @Then("Kurs baslıgına tıklanmalı")
    public void kurs_baslıgına_tıklanmalıdır() {

        sevkiPage.courseTitle.click();


    }

    @When("kullanici ogrenme sayfasina gider")
    public void kullanici_ogrenme_sayfasina_gider() {

        sevkiPage.learningPageButton.click();
        ReusableMethods.bekle(4);

    }


    @When("kullanici Favorites linkine tiklar")
    public void kullanici_favorites_linkine_tiklar() {

        sevkiPage.favoritesButton.click();

    }

    @When("Favorites listesinden ilk kursu siler")
    public void favorites_listesinden_ilk_kursu_siler() {

        sevkiPage.firstCourseThreeDots.click();
        ReusableMethods.bekle(4);

        sevkiPage.removeButton.click();
        ReusableMethods.bekle(4);

        sevkiPage.deleteButton.click();
        ReusableMethods.bekle(4);

    }

    //-------------------------------------------US_23------------------------------------------------------------------

    @When("kullanici login butonuna basar ve ınstructor olarak giris yapar")
    public void kullaniciLoginButonunaBasarVeInstructorOlarakGirisYapar() {


        sevkiPage.loginLink.click();

        sevkiPage.emailInput.sendKeys("sevki.admin@instulearn.com");

        sevkiPage.passwordInput.sendKeys(ConfigReader.getProperty("gecerliPassword"));

        sevkiPage.loginButton.click();

        ReusableMethods.bekle(2);

    }

    @When("Course Bundles menusunun gorunur ve tiklanabilir oldugu dogrulanir")
    public void courseBundlesMenusununGorunurVeTiklanabilirOlduguDogrulanir() {
        Assertions.assertTrue(sevkiPage.courseBundlesMenu.isEnabled());
    }

    @When("kullanici Course Bundles menusunu tıklar")
    public void kullaniciCourseBundlesMenusunuTıklar() {
        sevkiPage.courseBundlesMenu.click();
    }

    @Then("New linki görünür ve tıklanabilir olduğu doğrulanır")
    public void newLinkiGörünürVeTıklanabilirOlduğuDoğrulanır() {
        Assertions.assertTrue(sevkiPage.newButton.isEnabled());
    }

    @When("New linkine tıklanması")
    public void newLinkineTıklanması() {
        sevkiPage.newButton.click();
        ReusableMethods.bekle(2);

    }

    @And("Form bilgilerinin doldurulması")
    public void formBilgilerininDoldurulması() {
        sevkiPage.titleInput.sendKeys("DevOps Starter Bundle");
        sevkiPage.seoMetaDescriptionInput.sendKeys("temel kavramlar, CI/CD, Docker, Kubernetes");

        sevkiPage.thumbnailInput.sendKeys("C:\\\\Users\\\\user\\\\Desktop\\\\thumbnail.png");
        sevkiPage.coverImageUpload.sendKeys("C:\\\\Users\\\\user\\\\Desktop\\\\coverımege.png");

        sevkiPage.descriptionEditor.sendKeys("DevOps Başlangıc Paketi,  kapsamlı bir egitim paketidir");

        ReusableMethods.bekle(4);

    }

    @And("Previous butonunun gorunur ve tiklanabilir oldugu dogrulanir")
    public void previousButonununGorunurVeTiklanabilirOlduguDogrulanir() {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

        Assertions.assertTrue(sevkiPage.previousButton.isEnabled());
        ReusableMethods.bekle(4);
    }

    @And("Next butonunun gorunur ve tiklanabilir oldugu dogrulanir")
    public void nextButonununGorunurVeTiklanabilirOlduguDogrulanir() {
        Assertions.assertTrue(sevkiPage.nextButton.isEnabled());
    }


    @And("Send for Review butonunun gorunur ve tiklanabilir oldugu dogrulanir")
    public void sendForReviewButonununGorunurVeTiklanabilirOlduguDogrulanir() {

        Assertions.assertTrue(sevkiPage.sendForReviewButton.isEnabled());
    }

    @And("Save as Draft butonunun gorunur ve tiklanabilir oldugu dogrulanir")
    public void saveAsDraftButonununGorunurVeTiklanabilirOlduguDogrulanir() {

        Assertions.assertTrue(sevkiPage.saveAsDraftButton.isEnabled());
    }

    @Then("Next butonunun tıklanması")
    public void nextButonununTıklanması() {
        sevkiPage.nextButton.click();
        ReusableMethods.bekle(4);
    }

    @Then("Extra Information form bilgilerinin doldurulması")
    public void extraInformationFormBilgilerininDoldurulması() {
        sevkiPage.tagsInput.sendKeys("devops-engineer");

        Select select = new Select(sevkiPage.categoryDropdown);
        select.selectByVisibleText("DevOps");

        ReusableMethods.bekle(4);
    }

    @Then("Extra Information Next butonunun tıklanması")
    public void extraInformationNextButonununTıklanması() {

        sevkiPage.nextExtraButton.click();
    }

    @Then("Pricing basligi altında odeme formu doldurulması")
    public void pricingBasligiAltındaOdemeFormuDoldurulması() {
        sevkiPage.subscribeSwitchLabel.click();
        sevkiPage.accessPeriodInput.sendKeys("30");
        sevkiPage.priceInput.sendKeys("200");

    }

    @Then("Odeme planı olusturulması")
    public void odemePlanıOlusturulması() {

        sevkiPage.newPlanButton.click();
        sevkiPage.planTitleInput.sendKeys("Bahar Indirimi");
        sevkiPage.discountInput.sendKeys("10");
        sevkiPage.capacityInput.sendKeys("50");
        sevkiPage.startDateInput.sendKeys("2026-03-07");
        sevkiPage.endDateInput.sendKeys("2026-04-07");
        sevkiPage.savePlanButton.click();

    }
    @Then("Pricing Next butonunun tıklanması")
    public void pricingNextButonununTıklanması() {
        sevkiPage.nextPricingButton.click();

    }

    @Then("Content Next butonunun tıklanması")
    public void contentNextButonununTıklanması() {

        sevkiPage.nextContentButton.click();
        ReusableMethods.bekle(4);

    }

    @Then("FAQ baslıgı altındakibilgilerin olusturulması")
    public void faqBaslıgıAltındakibilgilerinOlusturulması() {

        sevkiPage.newFaqButton.click();
        sevkiPage.faqTitleInput.sendKeys("Bahar ındirimleri ne zaman bitecek");
        sevkiPage.faqAnswerTextarea.sendKeys("5 gün");
        sevkiPage.saveFaqButton.click();
        ReusableMethods.bekle(6);
        sevkiPage.nextFaqButton.click();

    }

    @Then("Message to reviewer baslıgı altında mesaj gonderilebilmesi")
    public void messageToReviewerBaslıgıAltındaMesajGonderilebilmesi() {

        sevkiPage.messageForReviewerTextArea.sendKeys("İnceleme için gönderildi.");
    }

    @Then("I agree with terms & rules check box görunur ve aktif olması")
    public void ıAgreeWithTermsRulesCheckBoxGörunurVeAktifOlması() {

        Assertions.assertTrue(sevkiPage.termsSwitch.isEnabled());
    }

    @Then("I agree with terms & rules check box tıklanmsı")
    public void ıAgreeWithTermsRulesCheckBoxTıklanmsı() {

        sevkiPage.rulesSwitchLabel.click();
        sevkiPage.saveMessageAsDraftButton.click();
        ReusableMethods.bekle(6);
    }

    @Then("My Bundles linki görünür ve tıklanabilir olduğu doğrulanır")
    public void myBundlesLinkiGörünürVeTıklanabilirOlduğuDoğrulanır() {

        Assertions.assertTrue(sevkiPage.myBundlesButton.isEnabled());
    }
}





































































































































































































































































































































































































































































































































































































































































































































































































