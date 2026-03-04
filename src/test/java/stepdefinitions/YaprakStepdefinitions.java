package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.YaprakPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import java.time.Duration;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static utilities.Driver.driver;

public class YaprakStepdefinitions {
    YaprakPage yaprakPage = new YaprakPage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
    Actions action = new Actions(Driver.getDriver());
    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

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

















}