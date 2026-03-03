package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import pages.NihanPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class NihanStepDefinitions {

    //---------------------------------------------------------------------------------------------------------
    //----------------- US_004_RegistrationFunctionalityStepdefinitions----------------------------------------
    //---------------------------------------------------------------------------------------------------------


    NihanPage RegisterPage = new NihanPage();

    @Given("kullanici_InstuLern_anasayfaya_gider")
    public void kullanici_InstuLern_anasayfaya_gider() {
        Driver.getDriver().get(ConfigReader.getProperty("instulearnUrl"));

    }

    @Then("Register linki görünür olmalı")
    public void kayitLinkiGorunurOlmali() {
        Assertions.assertTrue(RegisterPage.registerLink.isDisplayed());
    }

    @Then("Register linki tıklanabilir olmalı")
    public void kayitLinkiTiklanabilirOlmali() {
        Assertions.assertTrue(RegisterPage.registerLink.isEnabled());
    }

    @When("kullanıcı Register linkine tıklar")
    public void kullaniciKayitLinkineTiklar() {
        RegisterPage.registerLink.click();
    }

    @Then("Kayıt sayfası açılmalı")
    public void kayitSayfasiAcilmali() {
        Assertions.assertTrue(RegisterPage.signupButton.isDisplayed());
    }

    @Then("Resim görünür olmalı")
    public void resimGorunurOlmali() {
        Assertions.assertTrue(RegisterPage.registerImage.isDisplayed());
    }

    @Then("SignUp formu görünür olmalı")
    public void kayitFormuGorunurOlmali() {
        Assertions.assertTrue(RegisterPage.signupPageTitle.isDisplayed());
    }

    @Then("SignUp butonu görünür olmalı")
    public void signUpButonuGorunurOlmali() {
        Assertions.assertTrue(RegisterPage.signupButton.isDisplayed());
    }

    @Then("SignUp butonu tıklanabilir olmalı")
    public void signUpButonuTiklanabilirOlmali() {
        Assertions.assertTrue(RegisterPage.signupButton.isEnabled());
    }

    @Then("Account type butonları görünür olmalı")
    public void accountTypeButonlariGorunurOlmali() {

        Assertions.assertTrue(RegisterPage.studentRadioLabel.isDisplayed());
        Assertions.assertTrue(RegisterPage.instructorRadioLabel.isDisplayed());
        Assertions.assertTrue(RegisterPage.organizationRadioLabel.isDisplayed());
    }

    @Then("Account type butonları tıklanabilir olmalı")
    public void accountTypeButonlariTiklanabilirOlmali() {
        Assertions.assertTrue(RegisterPage.studentRadioLabel.isEnabled());
        Assertions.assertTrue(RegisterPage.instructorRadioLabel.isEnabled());
        Assertions.assertTrue(RegisterPage.organizationRadioLabel.isEnabled());
    }

    // Kullanici hicbir alan doldurmadan SignUp butonuna tiklar
    @When("Kullanici zorunlu alanlari doldurmadan SignUp butonuna tiklar")
    public void zorunlu_alanlari_doldurmadankullanici_signup_butonuna_tiklar() {

        // ReusableMethods.scrollToElement(RegisterPage.signupButton);
        // RegisterPage.clearAllFields();
        ReusableMethods.bekle(2);

        RegisterPage.clickSignup();
    }


    // Email hata mesaji gorunuyor mu kontrol edilir
    @Then("Email zorunlu alan hatasi goruntulenmelidir")
    public void email_hatasi_kontrolu() {

        Assertions.assertTrue(RegisterPage.emailRequiredError.isDisplayed());
    }


    // Full Name hata mesaji kontrol edilir
    @Then("Full Name zorunlu alan hatasi goruntulenmelidir")
    public void fullname_hatasi_kontrolu() {

        Assertions.assertTrue(RegisterPage.fullNameRequiredError.isDisplayed());
    }


    // Password hata mesaji kontrol edilir
    @Then("Password zorunlu alan hatasi goruntulenmelidir")
    public void password_hatasi_kontrolu() {

        Assertions.assertTrue(RegisterPage.passwordRequiredError.isDisplayed());
    }


    // Password confirmation hata mesaji kontrol edilir
    @Then("Password confirmation zorunlu alan hatasi goruntulenmelidir")
    public void password_confirmation_hatasi_kontrolu() {

        Assertions.assertTrue(RegisterPage.passwordConfirmationRequiredError.isDisplayed());


    }

    @When("kullanıcı account type olarak {string} seçer")
    public void kullaniciAccountTypeSecer(String accountType) {
        if(accountType.equals("Student")) {
            RegisterPage.selectAccountType("student");
        }
        else if (accountType.equals("Instructor")) {
            RegisterPage.selectAccountType("instructor");
        }
        else {
            RegisterPage.selectAccountType("organization");
        }
    }

    @When("kullanıcı geçerli e-posta olarak {string} girer")
    public void kullaniciGecerliEpostaGirer(String gecerliEmail) {

        RegisterPage.enterEmail(gecerliEmail);
    }

    @When("kullanıcı geçersiz e-posta olarak {string} girer")
    public void kullaniciGecersizEpostaGirer(String gecersizEmail) {

        RegisterPage.enterEmail(gecersizEmail);
        //Email girisi icin girilen email  gecerli email kriterlerini saglamali
    }

    @When("kullanıcı tam ad olarak {string} girer")
    public void kullaniciTamAdiniGirer(String tamAd) {
        ReusableMethods.bekle(2);
        RegisterPage.enterFullName(tamAd);
    }

    @When("kullanıcı geçerli şifre olarak {string} girer")
    public void kullaniciGecerliSifreGirer(String sifre) {
        RegisterPage.enterPassword(sifre);
    }

    @When("kullanıcı şifreyi doğru şekilde {string} olarak tekrar girer")
    public void kullaniciSifreyiDogruTekrarGirer(String sifre) {
        ReusableMethods.bekle(2);
        RegisterPage.enterRetypePassword(sifre);
    }

    @When("kullanıcı şifreyi yanlis şekilde {string} olarak tekrar girer")
    public void kullaniciSifreyiYanlisTekrarGirer(String sifre) {
        RegisterPage.enterRetypePassword(sifre);
    }

    @When("kullanıcı şartlar ve kuralları kabul eder")
    public void kullaniciSartlariKabulEder() {
        WebElement checkbox = RegisterPage.termsCheckbox;

        ReusableMethods.bekle(2);
        if (!checkbox.isSelected()) {
            checkbox.click();
        }
        // Doğrulama: checkbox seçili olmamalı
        Assertions.assertTrue(checkbox.isSelected(), "Terms & Rules checkbox seçili olmamalı");

    }

    @When("kullanıcı şartlar ve kuralları kabul etmez")
    public void kullaniciSartlariKabulEtmez() {
        WebElement checkbox = RegisterPage.termsCheckbox;

        // Eğer yanlışlıkla seçiliyse, kaldır
        if (checkbox.isSelected()) {
            checkbox.click();
        }

        // Doğrulama: checkbox seçili olmamalı
        Assertions.assertFalse(checkbox.isSelected(), "Terms & Rules checkbox seçili olmamalı");


    }

    @When("kullanıcı Kayıt butonuna tıklar")
    public void kullaniciKayitButonunaTiklar() {
        RegisterPage.clickSignup();
    }

    @Then("Terms & rules alanı için zorunluluk mesajı gösterilmeli")
    public void termsFieldHatasiGosterilmeli() {

        ReusableMethods.bekle(5);

        // System.out.println(RegisterPage.termRequiredErrorMessage.getText());
        Assertions.assertTrue(RegisterPage.termRequiredErrorMessage.isDisplayed(), "Hata mesajı görünür olmalı");
        //Assertions.assertTrue(RegisterPage.termRequiredErrorMessage.getText().contains("term field is required"),
        //        "Hata mesajı doğru içeriğe sahip olmalı");
    }


    // 5 karakter password girilir (gecersiz)
    @When("Kullanici password alanina eksik olarak {string} girer")
    public void kullanici_password_alanina_eksik_karakter_girer(String sifre) {

        RegisterPage.enterPassword("sifre");
    }

    @Then("Password minimum 8 karakter hatasi goruntulenmelidir")
    public void password_min_karakter_hatasi_goruntulenmelidir() {

        Assertions.assertTrue(RegisterPage.passwordMinCharacterError.isDisplayed());
    }
    @Then("kullanıcı başarıyla kayıt olmalı")
    public void kullaniciBasariylaKayitOlmali() {
        Assertions.assertTrue(RegisterPage.successMessage.isDisplayed());
    }

    @Then("eposta hata mesajı görüntülenmeli")
    public void epostaHataMesajiGoruntulenmeli() {
        ReusableMethods.bekle(5);
        System.out.println(RegisterPage.invalidEmailErrorMessage.getText());
        Assertions.assertTrue(RegisterPage.invalidEmailErrorMessage.isDisplayed());
    }

    @Then("şifre uyuşmazlığı hatası gösterilmeli")
    public void sifreUyusmazligiHatasiGosterilmeli() {
        ReusableMethods.bekle(3);
        Assertions.assertTrue(RegisterPage.passwordMismatchMessage.isDisplayed());
    }

    @When("kullanıcı Giriş linkine tıklar")
    public void kullaniciGirisLinkineTiklar() {
        RegisterPage.loginLink.click();
    }

    @Then("Giriş sayfası açılmalı")
    public void girisSayfasiAcilmali() {
        Assertions.assertTrue(RegisterPage.loginPageTitle.isDisplayed());
    }

    //---------------------------------------------------------------------------------------------------------
    //----------------- US_034_InstructorPageFunctionalityStepDefinitions----------------------------------------
    //---------------------------------------------------------------------------------------------------------



}

