package stepdefinitions;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.SevkiPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.time.Duration;

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
//-------------------------------------------------- US_41->TC_01 ---------------------------------------------------


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

    //--------------------------------------------------------US_41->TC_02------------------------------------------------


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


//--------------------------------------------------------US_41->TC_03----------------------------------------------------------



    @Then("Kurs baslıgına tıklanmalı")
    public void kurs_baslıgına_tıklanmalıdır() {

        sevkiPage.courseTitle.click();


    }

    @When("kullanici ogrenme sayfasina gider")
    public void kullanici_ogrenme_sayfasina_gider() {

        sevkiPage.learningPageButton.click();
        ReusableMethods.bekle(4);

    }

    //------------------------------------------  US_41->TC_04-------------------------------------------

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

    @When("Course Bundles menusunun gorunur ve tiklanabilir oldugu dogrulanir")
    public void courseBundlesMenusununGorunurVeTiklanabilirOlduguDogrulanir() {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    //----------------------------------------------US_23->TC_01----------------------------------------------





}




































































































































































































































































































































































































































































































































































































































































































































































































