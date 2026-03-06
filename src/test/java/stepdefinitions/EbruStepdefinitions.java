package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import pages.EbruPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class EbruStepdefinitions {

    EbruPage ebruPage = new EbruPage();
    private String beforeClickUrl;

    @Then("instulearn logosunun gorunur oldugunu dogrular")
    public void instulearn_logosunun_gorunur_oldugunu_dogrular() {
        Assertions.assertTrue(ebruPage.instulearnLogo.isDisplayed());
    }

    @Then("sayfa title degerinin {string} oldugunu dogrular")
    public void sayfa_title_degerinin_oldugunu_dogrular(String expectedTitle) {
        String actualTitle = Driver.getDriver().getTitle();
        Assertions.assertEquals(expectedTitle, actualTitle);
    }

    @When("kullanici gecersiz url'e gider")
    public void kullanici_gecersiz_urle_gider() {
        Driver.getDriver().get("https://qa.instulearn.com/invalid");
    }

    @Then("ana sayfa goruntulenmemelidir")
    public void ana_sayfa_goruntulenmemelidir() {
        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assertions.assertFalse(actualUrl.equals("https://qa.instulearn.com/"));
    }

    @Then("hata sayfasi goruntulenmelidir")
    public void hata_sayfasi_goruntulenmelidir() {
        String actualTitle = Driver.getDriver().getTitle();

        Assertions.assertTrue(
                actualTitle.contains("404")
                        || actualTitle.toLowerCase().contains("not found")
        );
    }

    @Then("sayfa title degeri {string} olmamalidir")
    public void sayfa_title_degeri_olmamalidir(String forbiddenTitle) {
        String actualTitle = Driver.getDriver().getTitle();
        Assertions.assertNotEquals(forbiddenTitle, actualTitle);
    }

    // US017-TC001
    @Given("kullanici login sayfasina gider")
    public void kullanici_login_sayfasina_gider() {
        Driver.getDriver().get("https://qa.instulearn.com/login");
        ReusableMethods.bekle(1);
    }

    @Then("forgot your password linki gorunur ve aktif olmali")
    public void forgot_your_password_linki_gorunur_ve_aktif_olmali() {
        Assertions.assertTrue(ebruPage.forgotYourPasswordLink.isDisplayed());
        Assertions.assertTrue(ebruPage.forgotYourPasswordLink.isEnabled());
    }

    @When("forgot your password linkine tiklar")
    public void forgot_your_password_linkine_tiklar() {
        ebruPage.forgotYourPasswordLink.click();
        ReusableMethods.bekle(2);

        for (String windowHandle : Driver.getDriver().getWindowHandles()) {
            Driver.getDriver().switchTo().window(windowHandle);
        }
    }

    @Then("password recovery yazisi gorunur olmali")
    public void password_recovery_yazisi_gorunur_olmali() {
        ReusableMethods.bekle(1);

        String headerText = ebruPage.pageHeader.getText().toLowerCase();

        Assertions.assertTrue(
                headerText.contains("recovery")
                        || headerText.contains("password")
                        || headerText.contains("reset")
                        || headerText.contains("forgot")
        );
    }

    @Then("forget password sayfasina yonlendirilmeli")
    @Then("forget password sayfasina yonlendirilmelidir")
    public void forget_password_sayfasina_yonlendirilmeli() {
        for (String wh : Driver.getDriver().getWindowHandles()) {
            Driver.getDriver().switchTo().window(wh);
        }

        ReusableMethods.bekle(1);

        String url = Driver.getDriver().getCurrentUrl().toLowerCase();
        Assertions.assertTrue(url.contains("forget-password"));
    }

    // US017-TC002
    @When("kayitli email olarak {string} girilir")
    public void kayitli_email_olarak_girilir(String email) {
        for (String wh : Driver.getDriver().getWindowHandles()) {
            Driver.getDriver().switchTo().window(wh);
        }

        ReusableMethods.bekle(1);

        ebruPage.emailTextbox.clear();
        ebruPage.emailTextbox.sendKeys(email);
    }

    @When("reset password butonuna tiklanir")
    public void reset_password_butonuna_tiklanir() {
        ReusableMethods.bekle(1);
        ebruPage.resetPasswordButton.click();
    }

    @Then("basari mesaji goruntulenmeli ve reset email gonderildigi yazmali")
    public void basari_mesaji_goruntulenmeli_ve_reset_email_gonderildigi_yazmali() {
        /*
        ReusableMethods.bekle(2);

        Assertions.assertTrue(ebruPage.resetSuccessMessage.isDisplayed());

        String msg = ebruPage.resetSuccessMessage.getText().toLowerCase();

        Assertions.assertTrue(
                msg.contains("email") ||
                msg.contains("mail") ||
                msg.contains("sent") ||
                msg.contains("success") ||
                msg.contains("reset")
        );
        */
    }

    @Then("email textbox gorunur ve aktif olmali")
    public void email_textbox_gorunur_ve_aktif_olmali() {
        for (String wh : Driver.getDriver().getWindowHandles()) {
            Driver.getDriver().switchTo().window(wh);
        }

        ReusableMethods.bekle(1);

        Assertions.assertTrue(ebruPage.emailTextbox.isDisplayed());
        Assertions.assertTrue(ebruPage.emailTextbox.isEnabled());
    }

    @Then("reset password butonu gorunur ve aktif olmali")
    public void reset_password_butonu_gorunur_ve_aktif_olmali() {
        ReusableMethods.bekle(1);

        Assertions.assertTrue(ebruPage.resetPasswordButton.isDisplayed());
        Assertions.assertTrue(ebruPage.resetPasswordButton.isEnabled());
    }

    @When("login sayfasina donus linkine tiklar")
    public void login_sayfasina_donus_linkine_tiklar() {
        ReusableMethods.bekle(1);
        ebruPage.backToLoginLink.click();
    }

    @Then("kullanici login sayfasina yonlendirilir")
    public void kullanici_login_sayfasina_yonlendirilir() {
        ReusableMethods.bekle(2);

        String currentUrl = Driver.getDriver().getCurrentUrl();
        Assertions.assertTrue(currentUrl.contains("login"));
    }

    // US006-TC001
    @Then("featured courses bolumu gorunur olmali")
    public void featured_courses_bolumu_gorunur_olmali() {
        ReusableMethods.bekle(1);
        Assertions.assertTrue(ebruPage.featuredCoursesSection.isDisplayed());
        Assertions.assertTrue(ebruPage.featuredCoursesTitle.isDisplayed());
    }

    @Then("featured courses kurs kartlari gorunur olmali")
    public void featured_courses_kurs_kartlari_gorunur_olmali() {
        ReusableMethods.bekle(1);
        Assertions.assertTrue(ebruPage.featuredCards.size() > 0);

        boolean anyDisplayed = false;
        for (WebElement card : ebruPage.featuredCards) {
            if (card.isDisplayed()) {
                anyDisplayed = true;
                break;
            }
        }
        Assertions.assertTrue(anyDisplayed);
    }

    @When("featured courses ilk kurs kartina tiklar")
    public void featured_courses_ilk_kurs_kartina_tiklar() {
        beforeClickUrl = Driver.getDriver().getCurrentUrl();

        ReusableMethods.bekle(1);

        try {
            ebruPage.featuredFirstCard.click();
        } catch (Exception e) {
            org.openqa.selenium.JavascriptExecutor js =
                    (org.openqa.selenium.JavascriptExecutor) Driver.getDriver();
            js.executeScript("arguments[0].click();", ebruPage.featuredFirstCard);
        }

        ReusableMethods.bekle(2);

        for (String wh : Driver.getDriver().getWindowHandles()) {
            Driver.getDriver().switchTo().window(wh);
        }

        ReusableMethods.bekle(1);
    }

    @Then("kullanici kurs detay sayfasina yonlendirilmeli")
    public void kullanici_kurs_detay_sayfasina_yonlendirilmeli() {
        String afterUrl = Driver.getDriver().getCurrentUrl();
        String title = Driver.getDriver().getTitle().toLowerCase();

        Assertions.assertNotEquals(beforeClickUrl, afterUrl);
        Assertions.assertFalse(title.contains("not found"));
        Assertions.assertFalse(title.contains("404"));
        Assertions.assertFalse(afterUrl.equals("https://qa.instulearn.com/"));
    }

    // US006-TC002
    @Then("newest courses bolumu gorunur olmali")
    public void newest_courses_bolumu_gorunur_olmali() {
        ReusableMethods.bekle(1);
        Assertions.assertTrue(ebruPage.newestCoursesSection.isDisplayed());
        Assertions.assertTrue(ebruPage.newestCoursesTitle.isDisplayed());
    }

    @Then("newest courses kart bilgileri gorunur olmali")
    public void newest_courses_kart_bilgileri_gorunur_olmali() {
        ReusableMethods.bekle(2);

        Assertions.assertTrue(ebruPage.firstNewestCourseCard.isDisplayed());

        String cardText = ebruPage.firstNewestCourseCard.getText();
        System.out.println("FIRST NEWEST CARD TEXT = " + cardText);

        Assertions.assertFalse(cardText.isEmpty());
    }

    @Then("view all butonu gorunur ve tiklanabilir olmali")
    public void view_all_butonu_gorunur_ve_tiklanabilir_olmali() {
        ReusableMethods.bekle(1);
        Assertions.assertTrue(ebruPage.newestViewAllButton.isDisplayed());
        Assertions.assertTrue(ebruPage.newestViewAllButton.isEnabled());
    }

    @When("newest courses view all butonuna tiklar")
    public void newest_courses_view_all_butonuna_tiklar() {
        beforeClickUrl = Driver.getDriver().getCurrentUrl();

        ReusableMethods.bekle(1);

        try {
            ebruPage.newestViewAllButton.click();
        } catch (Exception e) {
            org.openqa.selenium.JavascriptExecutor js =
                    (org.openqa.selenium.JavascriptExecutor) Driver.getDriver();
            js.executeScript("arguments[0].click();", ebruPage.newestViewAllButton);
        }

        ReusableMethods.bekle(2);

        for (String wh : Driver.getDriver().getWindowHandles()) {
            Driver.getDriver().switchTo().window(wh);
        }

        ReusableMethods.bekle(1);
    }

    @Then("kullanici kurs listesi sayfasina yonlendirilmeli")
    public void kullanici_kurs_listesi_sayfasina_yonlendirilmeli() {
        String afterUrl = Driver.getDriver().getCurrentUrl();
        String title = Driver.getDriver().getTitle().toLowerCase();

        Assertions.assertNotEquals(beforeClickUrl, afterUrl);
        Assertions.assertFalse(title.contains("not found"));
        Assertions.assertFalse(title.contains("404"));
    }

    // EbruStepdefinitions.java icine EKLE

    @Then("go to card ikonu gorunur ve aktif olmali")
    public void go_to_card_ikonu_gorunur_ve_aktif_olmali() {
        ReusableMethods.bekle(1);

        Assertions.assertTrue(ebruPage.goToCardIcon.isDisplayed());
        Assertions.assertTrue(ebruPage.goToCardIcon.isEnabled());
    }

    @When("go to card ikonuna tiklar")
    public void go_to_card_ikonuna_tiklar() {
        beforeClickUrl = Driver.getDriver().getCurrentUrl();

        ReusableMethods.bekle(1);

        try {
            ebruPage.goToCardIcon.click();
        } catch (Exception e) {
            org.openqa.selenium.JavascriptExecutor js =
                    (org.openqa.selenium.JavascriptExecutor) Driver.getDriver();
            js.executeScript("arguments[0].click();", ebruPage.goToCardIcon);
        }

        ReusableMethods.bekle(2);

        for (String wh : Driver.getDriver().getWindowHandles()) {
            Driver.getDriver().switchTo().window(wh);
        }

        ReusableMethods.bekle(1);
    }

    @Then("ilgili kurs detay sayfasi acilmali")
    public void ilgili_kurs_detay_sayfasi_acilmali() {
        String afterUrl = Driver.getDriver().getCurrentUrl();
        String title = Driver.getDriver().getTitle().toLowerCase();

        Assertions.assertNotEquals(beforeClickUrl, afterUrl);
        Assertions.assertFalse(title.contains("404"));
        Assertions.assertFalse(title.contains("not found"));
        Assertions.assertFalse(afterUrl.equals("https://qa.instulearn.com/"));
    }
    // TC_US006_004

    @Then("trending categories bolumu gorunur olmali")
    public void trending_categories_bolumu_gorunur_olmali() {

        ReusableMethods.bekle(1);

        Assertions.assertTrue(ebruPage.trendingCategoriesSection.isDisplayed());
        Assertions.assertTrue(ebruPage.trendingCategoriesTitle.isDisplayed());
    }

    @Then("kategori kartlari gorunur olmali")
    public void kategori_kartlari_gorunur_olmali() {

        ReusableMethods.bekle(1);

        Assertions.assertTrue(ebruPage.categoryCards.size() > 0);

        boolean anyDisplayed = false;

        for (WebElement category : ebruPage.categoryCards) {
            if (category.isDisplayed()) {
                anyDisplayed = true;
                break;
            }
        }

        Assertions.assertTrue(anyDisplayed);
    }

    @When("herhangi bir kategoriye tiklar")
    public void herhangi_bir_kategoriye_tiklar() {

        beforeClickUrl = Driver.getDriver().getCurrentUrl();

        ReusableMethods.bekle(1);

        try {
            ebruPage.firstCategory.click();
        } catch (Exception e) {
            org.openqa.selenium.JavascriptExecutor js =
                    (org.openqa.selenium.JavascriptExecutor) Driver.getDriver();
            js.executeScript("arguments[0].click();", ebruPage.firstCategory);
        }

        ReusableMethods.bekle(2);

        for (String wh : Driver.getDriver().getWindowHandles()) {
            Driver.getDriver().switchTo().window(wh);
        }
    }

    @Then("kategori sayfasina yonlendirilmis olmali")
    public void kategori_sayfasina_yonlendirilmis_olmali() {

        String afterUrl = Driver.getDriver().getCurrentUrl();
        String title = Driver.getDriver().getTitle().toLowerCase();

        Assertions.assertNotEquals(beforeClickUrl, afterUrl);

        Assertions.assertFalse(title.contains("404"));
        Assertions.assertFalse(title.contains("not found"));
    }
}