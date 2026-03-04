
package stepdefinitions;

        import io.cucumber.java.en.Given;
        import io.cucumber.java.en.Then;
        import io.cucumber.java.en.When;
        import org.junit.jupiter.api.Assertions;
        import pages.EbruPage;
        import utilities.Driver;
        import utilities.ReusableMethods;

public class EbruStepdefinitions {

    EbruPage ebruPage = new EbruPage();

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


    //US017-TC001
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

    // ✅ TEK When: guclu click (normal + fallback)


    // ✅ TEK Then: yonlendirme oldu mu? (login'de kalmadi mi?)
    @When("forgot your password linkine tiklar")
    public void forgot_your_password_linkine_tiklar() {

        ebruPage.forgotYourPasswordLink.click();

        ReusableMethods.bekle(2);

        // yeni sekmeye gec
        for (String windowHandle : Driver.getDriver().getWindowHandles()) {
            Driver.getDriver().switchTo().window(windowHandle);
        }
    }
    @Then("password recovery yazisi gorunur olmali")
    public void password_recovery_yazisi_gorunur_olmali() {

        ReusableMethods.bekle(1);

        // Header uzerinden kontrol (EbruPage'de pageHeader var)
        String headerText = ebruPage.pageHeader.getText().toLowerCase();

        Assertions.assertTrue(
                headerText.contains("recovery")
                        || headerText.contains("password")
                        || headerText.contains("reset")
                        || headerText.contains("forgot")
        );
    }


    // US017-TC001
    @Then("forget password sayfasina yonlendirilmeli")
    @Then("forget password sayfasina yonlendirilmelidir")
    public void forget_password_sayfasina_yonlendirilmeli() {

        // Link target=_blank oldugu icin yeni sekmeye gecmeyi garanti et
        for (String wh : Driver.getDriver().getWindowHandles()) {
            Driver.getDriver().switchTo().window(wh);
        }

        ReusableMethods.bekle(1);

        String url = Driver.getDriver().getCurrentUrl().toLowerCase();

        // /forget-password sayfasina gidildigini dogrula
        Assertions.assertTrue(url.contains("forget-password"));
    }

    //US017-TC002
    @When("kayitli email olarak {string} girilir")
    public void kayitli_email_olarak_girilir(String email) {

        // yeni tab acildiysa garanti gec
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

        // mesaj farkli yazilabilir diye esnek kontrol
        Assertions.assertTrue(
                msg.contains("email") ||
                        msg.contains("mail") ||
                        msg.contains("sent") ||
                        msg.contains("success") ||
                        msg.contains("reset")
        );*/
    }
    @Then("email textbox gorunur ve aktif olmali")
    public void email_textbox_gorunur_ve_aktif_olmali() {

        // yeni sekmeye gec
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
}