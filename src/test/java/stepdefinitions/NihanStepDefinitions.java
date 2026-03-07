package stepdefinitions;

import io.cucumber.java.en.*;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.NihanPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.time.Duration;

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

    @When("Kullanıcı {string} olarak login olur")
    public void kullanici_olarak_login_olur(String role) {

        String email = "";
        String password = "Learn.123123"; // ortak password varsayalım

        if(role.equalsIgnoreCase("Student")){
            email = "nihan.user@instulearn.com";
        }
        else if(role.equalsIgnoreCase("Instructor")){
            email = "nihan.admin@instulearn.com";
        }
        else{
            throw new IllegalArgumentException("Geçersiz rol: " + role);
        }

        RegisterPage.login(email, password);
    }


    @Then("Instructors linki görünür olmalı")
    public void instructors_linki_gorunur_olmali() {
        ReusableMethods.bekle(3);
        Assertions.assertTrue(RegisterPage.instructorsLink.isDisplayed());
    }

    @Then("Instructors linki tıklanabilir olmalı")
    public void instructors_linki_tiklanabilir_olmali() {

        ReusableMethods.bekle(3);
        Assertions.assertTrue(RegisterPage.instructorsLink.isEnabled());
    }

    @Then("Kullanici Instructors linkine tıklar")
    public void kullanici_instructors_linkine_tiklar() {
        ReusableMethods.bekle(3);
        RegisterPage.instructorsLink.click();
    }

    @Then("Sayfada Instructors basligi görüntülenmeli")
    public void instructors_sayfasi_acilmalidir() {
        ReusableMethods.bekle(3);
        Assertions.assertTrue(RegisterPage.instructorsTitle.isDisplayed());
        Assertions.assertTrue(Driver.getDriver().getCurrentUrl().contains("instructors"));
    }

    @Then("Search textbox görünür olmalı")
    public void search_textbox_gorunur_olmali() {
        ReusableMethods.bekle(3);
        Assertions.assertTrue(RegisterPage.searchTextBox.isDisplayed());
    }

    @Then("Search textbox aktif olmalı")
    public void search_textbox_aktif_olmali() {
        ReusableMethods.bekle(3);
        Assertions.assertTrue(RegisterPage.searchTextBox.isEnabled());
    }

    @Then("Search butonu görünür olmalı")
    public void search_butonu_gorunur_olmali() {
        Assertions.assertTrue(RegisterPage.searchButton.isDisplayed());
    }

    @Then("Search butonu aktif olmalı")
    public void search_butonu_aktif_olmali() {
        Assertions.assertTrue(RegisterPage.searchButton.isEnabled());

    }

    @Then("Categories basligi altinda kategoriler görünür olmalı")
    public void categories_basligi_altinda_kategoriler_gorunur_olmali() {
        ReusableMethods.scrollToElement(RegisterPage.categoriesTitle);

        Assertions.assertTrue(RegisterPage.categoriesTitle.isDisplayed());

        System.out.println(RegisterPage.categoryCheckboxes);
        // Checkbox listesi boş mu?
        //Assertions.assertTrue(RegisterPage.categoryCheckboxes.size() > 0);

        // Tüm checkboxlar görünür mü?
        for (WebElement checkbox : RegisterPage.categoryCheckboxes) {
            Assertions.assertTrue(checkbox.isDisplayed());
        }
    }

    @Then("Categories basligi altinda kategoriler aktif olmalı")
    public void categories_basligi_altinda_kategoriler_aktif_olmali() {
        // Tüm checkboxlar enabled mı?
        for (WebElement checkbox : RegisterPage.categoryCheckboxes) {
            Assertions.assertTrue(checkbox.isEnabled());
        }
    }

    @When("Kullanıcı {string} adindaki kategoriyi seçer")
    public void kullanici_adindaki_kategoriyi_secer(String categoryName) {


        RegisterPage.selectCategory(categoryName);

    }

    @Then("Instructorlar seçilen kategoriye gore filtrelenmeli")
    public void instructorlar_secilen_kategoriye_gore_filtrelenmeli() {


        // Instructor sonucu var mı?
        Assertions.assertTrue(RegisterPage.instructorResults.size() > 0, "Filtrelenmiş instructor bulunamadı.");

        // İstersen isim kontrolü de ekleyebilirsin
        for (WebElement name : RegisterPage.instructorNames) {
            Assertions.assertTrue(name.isDisplayed(), "Instructor ismi görünmüyor: " + name.getText());
        }
    }

    @Then("Instructor fiyat bilgisi görünür olmalı")
    public void instructor_fiyat_bilgisi_gorunur_olmali() {

//        for (WebElement price : RegisterPage.instructorPrices) {
//            Assertions.assertTrue(price.isDisplayed(), "Instructor fiyat bilgisi görünmüyor: " + price.getText());
//        }

        Assertions.assertTrue(RegisterPage.firstInstructorPrice.isDisplayed(), "İlk instructor fiyat bilgisi görünür değil!");
        System.out.println("Fiyat: " + RegisterPage.firstInstructorPrice.getText());
    }

    @Then("Instructor ders adı görünür olmalı")
    public void instructor_ders_adi_gorunur_olmali() {
        Assertions.assertTrue(RegisterPage.firstInstructorTitle.isDisplayed(), "İlk instructor unvan/ders bilgisi görünür değil!");
        System.out.println("Ders/Unvan: " + RegisterPage.firstInstructorTitle.getText());
    }

    @Then("Instructor beğeni bilgisi görünür olmalı")
    public void instructor_begeni_bilgisi_gorunur_olmali() {
        Assertions.assertTrue(RegisterPage.firstInstructorRating.isDisplayed(), "İlk instructor rating bilgisi görünür değil!");
        System.out.println("Rating: " + RegisterPage.firstInstructorRating.getText());
    }

    @And("Kullanıcı {string}. siradaki instructori seçer")
    public void kullanici_siradaki_instructoru_secer(String siraNo) {

        int index = Integer.parseInt(siraNo) - 1; // Çünkü index 0'dan başlar


        RegisterPage.reserveMeetingButtons.get(index).click();
    }

    @When("Kullanıcı {string} tarihini secer")
    public void kullanici_tarih_secer(String tarih) {


        RegisterPage.selectDate(tarih);
    }

    @And("Kullanıcı ilk zaman araligini secer")
    public void kullanici_zaman_araligini_secer() {

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

        // 1️⃣ availableTimes div görünene kadar bekle
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("availableTimes")));

        // 2️⃣ İlk label elementin clickable olmasını bekle
        WebElement firstLabel = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("#availableTimes label:first-of-type")
        ));

        // 3️⃣ Click
        firstLabel.click();

    }

    @And("Kullanıcı meeting Type olarak {string} secer")
    public void kullanici_meeting_type_olarak_secer(String meetingType) {


        RegisterPage.selectMeetingType(meetingType);
    }

    @And("Kullanici Reserve a Meeting butonuna tiklar")
    public void kullanici_reserve_a_meeting_butonuna_tiklar() {

        RegisterPage.reserveMeetingButton.click();
    }

    @And("Kullanici bir aciklama girer")
    public void kullanici_bir_aciklama_girer() {
        RegisterPage.descriptionTextArea.sendKeys("Test description");
    }

    @And("Kullanici sepete tiklar")
    public void kullanici_sepete_tiklar() {
        RegisterPage.shoppingCartButton.click();
    }

    @And("Kullanici Go to Card butonuna tiklar")
    public void kullanici_go_to_card_butonuna_tiklar() {
        RegisterPage.goToCartButton.click();
    }

    @And("Kullanici Checkout butonuna tiklar")
    public void kullanici_checkout_butonuna_tiklar() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

        // Checkout butonunu locate et
        WebElement checkoutButton = Driver.getDriver().findElement(By.xpath("//div[contains(@class,'rounded-sm')]//button[text()='Checkout']"));

        // 1️⃣ Scroll yap
        ReusableMethods.scrollToElement(checkoutButton);

        // 2️⃣ Buton görünür olana kadar bekle
        wait.until(ExpectedConditions.visibilityOf(checkoutButton));

        // 3️⃣ Buton clickable olana kadar bekle ve click yap
        wait.until(ExpectedConditions.elementToBeClickable(checkoutButton)).click();
    }

    @When("Kullanici odeme turu olarak stripe secer")
    public void kullanici_odeme_turu_olarak_secer() {

        // ReusableMethods.scrollToElement(RegisterPage.stripePaymentOption);

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(RegisterPage.stripePaymentOption)).click();
    }

    @And("Kullanici Start Payment butonuna tiklar")
    public void kullanici_start_payment_butonuna_tiklar() {
        ReusableMethods.bekle(3);
        RegisterPage.startPaymentButton.click();
    }

    @Then("Kullanici eposta olarak {string} girer")
    public void kullanici_eposta_olarak_girer(String email) {
        RegisterPage.enterLoginEmail(email);
    }

    @Then("Kullanici odeme yontemi formunu doldurur")
    public void kullanici_kart_bilgilerini_girer() {
        RegisterPage.fillCardDetails(

                "4242 4242 4242 4242",
                "02/27",
                "123",
                "Ahmet Yilmaz"
        );


    }

    @And("Kullanici Ode butonuna tiklar")
    public void kullanici_ode_butonuna_tiklar() {

        ReusableMethods.scrollToElement(RegisterPage.payButton);
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(RegisterPage.payButton)).click();
    }

    @Then("Congratulations mesajı görüntülenmeli")
    public void congratulations_mesaji_goruntulenmeli() {

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(RegisterPage.congratulationsTitle));

        Assertions.assertTrue(RegisterPage.congratulationsTitle.isDisplayed());
    }

    @Then("My Panel butonu görünür olmalı")
    public void my_panel_butonu_gorunur_olmali() {

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(RegisterPage.myPanelButton));

        Assertions.assertTrue(RegisterPage.myPanelButton.isDisplayed());
    }

    @And("My Panel butonu tıklanabilir olmalı")
    public void my_panel_butonu_tiklanabilir_olmali() {

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(RegisterPage.myPanelButton));

        Assertions.assertTrue(RegisterPage.myPanelButton.isEnabled());
    }

    @And("My panel butonuna tiklayinca Events sayfasina gectigi dogrulanir")
    public void my_panel_butonuna_tiklayinca_events_sayfasina_gectigi_dogrulanir() {

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(RegisterPage.myPanelButton));

        RegisterPage.myPanelButton.click();

        wait.until(ExpectedConditions.visibilityOf(RegisterPage.eventsPageTitle));

        Assertions.assertTrue(RegisterPage.eventsPageTitle.isDisplayed());

        Assertions.assertTrue(Driver.getDriver().getCurrentUrl().contains("/panel"));
    }

    //---------------------------------------------------------------------------------------------------------
    //----------------- US_038_LogoutFunctionalityStepDefinitions----------------------------------------
    //---------------------------------------------------------------------------------------------------------


    @When("Kullanıcı header bölümündeki kullanıcı adına tıklar")
    public void kullanici_header_kullanici_adina_tiklar() {

        RegisterPage.hoverUserDropdown();

    }



    @And("Kullanici sol side barda {string} gorunene kadar sayfayi asagi surukler")
    public void kullanici_sol_side_barda_gorunene_kadar_sayfayi_asagi_surukler(String buton) {


        RegisterPage.scrollSidebarUntilElementVisible(buton);


    }

    @And("Dashboard sayfasında {string} linki görünür olmalı")
    public void dashboard_sayfasında_linki_görünür_olmalı(String linkText) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

        WebElement link = wait.until(ExpectedConditions.elementToBeClickable(
                RegisterPage.getSidebarLink(linkText)
        ));

        Assertions.assertTrue(RegisterPage.getSidebarLink(linkText).isDisplayed());


    }

    @And("Dashboard sayfasında {string} linki tıklanabilir olmalı")
    public void dashboard_sayfasında_linki_tıklanabilir_olmalı(String linkText) {

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

        WebElement link = wait.until(ExpectedConditions.elementToBeClickable(
                RegisterPage.getSidebarLink(linkText)
        ));
        Assertions.assertTrue(RegisterPage.getSidebarLink(linkText).isEnabled());

    }
    @And("Dashboard sayfasında Logout linki görünür olmalı")
    public void dashboard_sayfasında_Logout_linki_görünür_olmalı() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

        WebElement link = wait.until(ExpectedConditions.elementToBeClickable(
                RegisterPage.logoutLink
        ));

        Assertions.assertTrue(RegisterPage.logoutLink.isDisplayed());


    }

    @And("Dashboard sayfasında Logout linki tıklanabilir olmalı")
    public void dashboard_sayfasında_Logout_linki_tıklanabilir_olmalı() {

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

        WebElement link = wait.until(ExpectedConditions.elementToBeClickable(
                RegisterPage.logoutLink
        ));
        Assertions.assertTrue(RegisterPage.logoutLink.isEnabled());

    }

    @And("Kullanici sol side barda Logout gorunene kadar sayfayi asagi surukler")
    public void kullanici_sol_side_barda_logout_gorunene_kadar_sayfayi_asagi_surukler() {

        WebElement logoutButton = Driver.getDriver().findElement(By.xpath("//a[@href='/logout']"));
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", logoutButton);
        try { Thread.sleep(500); } catch (InterruptedException e) { e.printStackTrace(); }



    }

    @When("Kullanıcı Dashboard sayfasındaki Logout linkine tıklar")
    public void kullanıcı_dashboard_sayfasındaki_logout_linkine_tıklar() {

        WebElement logoutButton = Driver.getDriver().findElement(By.xpath("//a[@href='/logout']"));
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", logoutButton);
        try { Thread.sleep(5000); } catch (InterruptedException e) { e.printStackTrace(); }
        logoutButton.click();
    }

    @And("Kullanıcı sistemden başarıyla çıkış yapabilmeli")
    public void kullanıcı_sistemden_başarıyla_çıkış_yapabilmeli() {

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOf(RegisterPage.loginButton));

        Assertions.assertTrue(RegisterPage.loginButton.isDisplayed());
    }




    @Given("Kullanici Header bolumundeki {string} linkine tiklar")
    public void kullanici_header_bolumundeki_linkine_tiklar(String linkText) {

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOf(RegisterPage.getHeaderLink(linkText)));
        RegisterPage.getHeaderLink(linkText).click();
    }



    @Then("Dropdown içinde {string} linki görünür olmalı")
    public void dropdown_icinde_linki_gorunur_olmali(String linkText) {

        Assertions.assertTrue(RegisterPage.getDropdownLink(linkText).isDisplayed());

    }

    @Then("Dropdown içinde {string} linki tiklanabilir olmalı")
    public void dropdown_icinde_linki_tiklanabilir_olmali(String linkText) {

        Assertions.assertTrue(RegisterPage.getDropdownLink(linkText).isEnabled());

    }

    @When("Kullanıcı Dropdown icindeki {string} linkine tıklar")
    public void kullanici_dropdown_icindeki_linkine_tiklar(String linkText) {


        RegisterPage.hoverUserDropdown(); // dropdown açılır

        RegisterPage.getDropdownLink(linkText).click(); // Logout
    }


}

