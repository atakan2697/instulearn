package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.YaprakPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static utilities.Driver.driver;

public class YaprakStepdefinitions {
    YaprakPage yaprakPage = new YaprakPage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
    Actions action = new Actions(Driver.getDriver());
    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
    //

    //--------------------------------------------------------------------------------------------------US15

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




}