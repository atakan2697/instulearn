package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;

import java.time.Duration;
import java.util.List;

public class NihanPage {

    public NihanPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    // -----------------------------
    // Home Page Lokasyonları
    // -----------------------------
    @FindBy(xpath = "//a[@href='/register']")
    public WebElement registerLink;

    @FindBy(xpath = "//a[@href='/login']")
    public WebElement loginLink;

    // -----------------------------
    // Register Page Alanları
    // -----------------------------

    @FindBy(xpath = "//img[@alt='Login']")
    public WebElement registerImage;

    @FindBy(xpath = "//button[@type='submit' and text()='Signup']")
    public WebElement signupButton;

    @FindBy(xpath = "//h1[text()='Signup']")
    public WebElement signupPageTitle;

    @FindBy(xpath = "//label[text()='Student']")
    public WebElement studentRadioLabel;

    @FindBy(xpath = "//label[text()='Instructor']")
    public WebElement instructorRadioLabel;

    @FindBy(xpath = "//label[text()='Organization']")
    public WebElement organizationRadioLabel;

    // Email input field
    @FindBy(id = "email")
    public WebElement emailField;


    // Full Name input field
    @FindBy(xpath = "//input[@name='full_name']")
    public WebElement fullNameField;


    // Password input field
    @FindBy(id = "password")
    public WebElement passwordField;


    // Password confirmation input field
    @FindBy(xpath = "//input[@id='confirm_password']")
    public WebElement passwordConfirmationField;

    //term Check Box
    @FindBy(id = "term")
    public WebElement termsCheckbox;

    @FindBy(id = "studentRadio")
    public WebElement studentRadioButton;

    //login Page Basligi
    @FindBy(xpath = "//h1[text()='Log in to your account']")
    public WebElement loginPageTitle;




    // -----------------------------
    // Mesajlar
    // -----------------------------


    // Terms & rules hata mesajı
    @FindBy(xpath = "//input[@id='term']/following-sibling::div[contains(@class,'invalid-feedback')]")
    public WebElement termRequiredErrorMessage;   // Email required error


    // Email required error
    @FindBy(xpath = "//div[@class='invalid-feedback' and contains(text(),'The email field is required.')]")
    public WebElement emailRequiredError;


    // Full name required error
    @FindBy(xpath = "//div[@class='invalid-feedback' and contains(text(),'The full name field is required.')]")
    public WebElement fullNameRequiredError;


    // Password required error
    @FindBy(xpath = "//div[@class='invalid-feedback' and contains(text(),'The password field is required.')]")
    public WebElement passwordRequiredError;


    // Password confirmation required error
    @FindBy(xpath = "//div[@class='invalid-feedback' and contains(text(),'The password confirmation field is required.')]")
    public WebElement passwordConfirmationRequiredError;

    //password must be at least 8 characters
    @FindBy(xpath = "//div[normalize-space(text())='The password must be at least 6 characters.']")
    public WebElement passwordMinCharacterError;

    //password confirmation and password must match
    @FindBy(xpath = "//div[normalize-space(text())='The password confirmation does not match.']")
    public WebElement passwordMismatchMessage;

    @FindBy(xpath = "//*[normalize-space(text())='The email must be a valid email address.']")
    public WebElement invalidEmailErrorMessage;

    @FindBy(css = ".alert-success")
    public WebElement successMessage;




    // -----------------------------
    // Yardımcı Metotlar
    // -----------------------------

    public void selectAccountType(String accountType) {

        switch(accountType.toLowerCase()) {
            case "student":
                studentRadioLabel.click();
                break;

            case "instructor":
                instructorRadioLabel.click();
                break;

            case "organization":
                organizationRadioLabel.click();
                break;

            default:
                throw new IllegalArgumentException("Geçersiz user type: " + accountType);
        }
    }

    public void clearAllFields() {

        emailField.clear();
        fullNameField.clear();
        passwordField.clear();
        passwordConfirmationField.clear();

    }

    public void enterEmail(String email) {
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void enterFullName(String fullName) {
        fullNameField.clear();
        fullNameField.sendKeys(fullName);
    }

    public void enterPassword(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void enterRetypePassword(String password) {
        passwordConfirmationField.clear();
        passwordConfirmationField.sendKeys(password);
    }

    public void acceptTerms() {
        if(!termsCheckbox.isSelected()) {
            termsCheckbox.click();
        }
    }

    public void selectStudent() {
        if(!studentRadioButton.isSelected()) {
            studentRadioButton.click();
        }
    }

    public void clickSignup() {
        signupButton.click();
    }


    // -----------------------------
    // Instructor Page Alanları
    // -----------------------------

    // 1- Login butonu
    @FindBy(xpath = "//a[@href='/login']")
    public WebElement loginButton;

    // 2- Email input
    @FindBy(id = "email")
    public WebElement emailInput;

    // 3- Password input
    @FindBy(id = "password")
    public WebElement passwordInput;

    // 4- Login submit button
    @FindBy(xpath = "//button[@type='submit' and text()='Login']")
    public WebElement loginSubmitButton;


    // Instructors linki
    @FindBy(xpath = "//a[@href='/instructors']")
    public WebElement instructorsLink;

    // Instructors basligi
    @FindBy(xpath = "//h1[normalize-space()='Instructors']")
    public WebElement instructorsTitle;

    //searchTextBox
    @FindBy(name = "search")
    public WebElement searchTextBox;

    //searchButton
    @FindBy(xpath = "//button[@type='submit' and normalize-space()='Search']")
    public WebElement searchButton;

    @FindBy(xpath = "//h3[normalize-space()='Categories']")
    public WebElement categoriesTitle;

    @FindBy(xpath = "//*[@class='checkbox-button bordered-200 mr-20']")
    public List<WebElement> categoryCheckboxes;

    //kategori filtresinden sonra instructor listesi
    @FindBy(css = "#bestRateInstructorsSwiper .course-teacher-card")
    public List<WebElement> instructorResults;

    // kategori filtresinden sonra instructor listesi /İsimler
    @FindBy(css = "#bestRateInstructorsSwiper h3")
    public List<WebElement> instructorNames;

    // Label’lar
    @FindBy(css = "div.mt-30 input[name='categories[]'] + label")
    public List<WebElement> categoryLabels;



    @FindBy(css = "#bestRateInstructorsSwiper .course-teacher-card")
    public List<WebElement> instructorCards;

    // Kart içindeki fiyat
    @FindBy(css = ".course-teacher-card span.font-20.text-primary")
    public List<WebElement> instructorPrices;

    // İlk instructor kartındaki güncel fiyat
    @FindBy(css = ".course-teacher-card:first-of-type span.font-20.text-primary")
    public WebElement firstInstructorPrice;

    // Kart içindeki ders adı (instructor adı)
    @FindBy(css = ".course-teacher-card h3")
    public List<WebElement> instructorNames1;

    // İlk instructor kartındaki isim
    @FindBy(css = ".course-teacher-card:first-of-type h3.mt-20.font-16.font-weight-bold.text-dark-blue")
    public WebElement firstInstructorName;

    // İlk instructor kartındaki ders/unvan bilgisi
    @FindBy(css = ".course-teacher-card:first-of-type div.mt-5.font-14.text-gray")
    public WebElement firstInstructorTitle;

    // Kart içindeki beğeni (rating)
    @FindBy(css = ".course-teacher-card .badge-primary")
    public List<WebElement> instructorRatings;

    // İlk instructor kartındaki rating / beğeni bilgisi
    @FindBy(css = ".course-teacher-card:first-of-type span.badge.badge-primary")
    public WebElement firstInstructorRating;


    @FindBy(xpath = "//a[contains(@href,'/profile?tab=appointments') and contains(@class,'btn-primary')]")
    public List<WebElement> reserveMeetingButtons;



    // İlk instructor için ilk saat aralığı label
    @FindBy(xpath = "(//div[contains(@class,'course-teacher-card')]//div[contains(@class,'available-times')]//label)[1]")
    public WebElement instructorFirstTimeLabel;

    @FindBy(id = "availableTime91")
    public WebElement availableTime;


    @FindBy(name = "description")
    public WebElement descriptionTextArea;

    @FindBy(xpath = "//button[normalize-space()='Reserve a Meeting']")
    public WebElement reserveMeetingButton;





    @FindBy(id = "navbarShopingCart")
    public WebElement shoppingCartButton;

    @FindBy(xpath = "//a[normalize-space()='Go to cart']")
    public WebElement goToCartButton;

    @FindBy(css = "label[for='Stripe']")
    public WebElement checkoutButton;



    // Stripe ödeme seçeneği
    @FindBy(css = "label[for='Stripe']")
    public WebElement stripePaymentOption;

    // Offline / Account Charge ödeme seçeneği
    @FindBy(xpath = "//label[@for='offline']")
    public WebElement offlinePaymentOption;

    @FindBy(id = "paymentSubmit")
    public WebElement startPaymentButton;



    @FindBy(id = "cardNumber")
    public WebElement cardNumberInput;


    @FindBy(xpath = "//button[@type='submit']")
    public WebElement payButton;



    //Congratulations basligi
    @FindBy(xpath = "//h2[.='Congratulations!']")
    public WebElement congratulationsTitle;

    //My Panel Butonu
    @FindBy(linkText = "My Panel")
    public WebElement myPanelButton;

    @FindBy(xpath = "//h1[text()='Events']")
    public WebElement eventsPageTitle;





    // -----------------------------
    // Yardımcı Metotlar
    // -----------------------------


    // login methodu
    public void login(String email, String password){

        loginButton.click();
        emailInput.clear();
        emailInput.sendKeys(email);
        passwordInput.clear();
        passwordInput.sendKeys(password);
        loginSubmitButton.click();
    }

    public void enterLoginEmail(String email){
        emailInput.clear();
        emailInput.sendKeys(email);
    }

    public void selectCategory(String categoryName) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));
       ;

        WebElement category =
                wait.until(
                        ExpectedConditions.elementToBeClickable(By.xpath("//label[normalize-space()='" + categoryName + "']")));
        category.click();
    }

    //dinamik date methodu
    public void selectDate(String date){

        // 2026-03-18 → 2026,3,18 formatına çeviriyoruz
        String[] parts = date.split("-");
        String formattedDate = parts[0] + "," + Integer.parseInt(parts[1]) + "," + Integer.parseInt(parts[2]);

        String dynamicXpath = "//td[@data-date='" + formattedDate + "' and not(contains(@class,'disabled'))]";

        WebElement day = Driver.getDriver().findElement(By.xpath(dynamicXpath));
        day.click();
    }

    //Time secme
    public void selectTimeRange(String timeRange){

        String dynamicXpath = "//label[normalize-space()='" + timeRange + "']";

        WebElement timeElement = Driver.getDriver().findElement(By.xpath(dynamicXpath));
        timeElement.click();
    }

    public void selectMeetingType(String meetingType){

        By dynamicLocator = By.xpath(
                "//label[normalize-space()='" + meetingType + "']"
        );

        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(dynamicLocator)).click();
    }

    // Dinamik ödeme seçme methodu
    public void selectPaymentType(String paymentType) {

        switch (paymentType.toLowerCase()) {

            case "stripe":
                stripePaymentOption.click();
                break;

            case "offline":
                offlinePaymentOption.click();
                break;

            default:
                throw new IllegalArgumentException("Gecersiz odeme tipi: " + paymentType);
        }
    }

    public void enterCardNumber(String cardNumber){
        cardNumberInput.clear();
        cardNumberInput.sendKeys(cardNumber);
    }

    public void fillCardDetails( String number, String expiry, String cvc, String fullName) {

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));

        // ---------------- CARD NUMBER ----------------
        WebElement cardNumber = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("cardNumber"))
        );

        cardNumber.sendKeys(number);


        // ---------------- EXPIRY ----------------
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("cardExpiry"))).sendKeys(expiry);



        // ---------------- CVC ----------------
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("cardCvc"))).sendKeys(cvc);




        // ---------------- BILLING NAME ----------------
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("billingName")
        )).sendKeys(fullName);

    }



    // -----------------------------
    // Home Page Alanları
    // -----------------------------

    @FindBy(css = "a[href='/logout']")
    public WebElement sidebarLogoutLink;

    @FindBy(linkText = "Home")
    public WebElement homeIcon;

    @FindBy(xpath = "//span[contains(@class,'user-name')]")
    public WebElement userName;

    @FindBy(id = "panelSidebar")
    public WebElement sidebar;

    @FindBy(xpath = "//a[normalize-space(span[text()='Log out'])]")
    public WebElement logoutLink;
    // Sidebar container
    @FindBy(id = "panelSidebar")
    public WebElement sidebarContainer;

    // Örnek olarak Noticeboard element
    @FindBy(xpath = "//span[text()='Noticeboard']")
    public WebElement noticeboardItem;


    // -----------------------------
    // Yardımcı Metotlar
    // -----------------------------



//    public static void verifyLinkVisible(String linkText) {
//
//        WebElement link = Driver.getDriver()
//                .findElement(By.xpath("//a[contains(text(),'" + linkText + "')]"));
//
//        Assertions.assertTrue(link.isDisplayed());
//    }

    public WebElement getSidebarLink(String linkText) {

        return Driver.getDriver().findElement(
                By.xpath("//div[@id='panelSidebar']//span[normalize-space()='" + linkText + "']")
        );
    }

    public WebElement getHeaderLink(String linkText){


        return Driver.getDriver()
                .findElement(By.xpath("//a[normalize-space()='" + linkText + "']"));

    }

    public WebElement getDropdownLink(String linkText){

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[contains(@class,'custom-dropdown-body')]//a[.//span[text()='" + linkText + "']]")
        ));

    }

    public void hoverUserDropdown(){
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(userName).perform();
    }










    public By sidebarLocator = By.id("panelSidebar");




    public WebElement getSidebarElementByName(String name) {
        return Driver.getDriver().findElement(By.xpath("//a[contains(text(),'" + name + "') and contains(@href,'logout')]"));
    }

    public void scrollSidebarUntilElementVisible(String elementName) {

        WebElement sidebar = Driver.getDriver().findElement(sidebarLocator);
        Actions actions = new Actions(Driver.getDriver());

        int attempts = 0;
        while (attempts < 30) { // max 30 deneme
            try {
                WebElement target = getSidebarElementByName(elementName);
                if (target.isDisplayed()) {
                    break; // görünüyorsa dur
                }
            } catch (Exception e) {
                // element henüz görünmüyorsa scroll devam eder
            }

            // Fareyi sidebar üstüne götür
            actions.moveToElement(noticeboardItem).perform();

            // Fareyi biraz aşağı sürükle (offset 0, 50 px)
            actions.moveByOffset(0, 50).perform();

            try { Thread.sleep(200); } catch (InterruptedException ignored) {}
            attempts++;
        }
    }

//    public void scrollToLogout() {
//        Actions actions = new Actions(Driver.getDriver());
//
//
//        actions.moveToElement(noticeboardItem).perform();
//        int attempts = 0;
//        while (attempts < 100) { // max 100 deneme
//            try {
//                if (logoutLink.isDisplayed()) {
//                    break; // Logout görünüyorsa dur
//                }
//            } catch (Exception e) {
//                // Logout henüz görünmüyorsa scroll devam eder
//            }
//
//            // Fareyi sidebar üzerine götür
//            actions.moveToElement(sidebarContainer).perform();
//
//            // Fareyi aşağı kaydır (Logout görünene kadar)
//            actions.moveByOffset(0, 50).perform();
//
//            try { Thread.sleep(150); } catch (InterruptedException ignored) {}
//            attempts++;
//        }
//    }




    /**
     * Sidebar üstüne fareyi getirir ve logout görünene kadar scroll yapar.
     */
    public void scrollToLogout() {
        Actions actions = new Actions(Driver.getDriver());

        // Sidebar üzerine fareyi getir
        actions.moveToElement(sidebar).perform();

        // Logout görünene kadar scroll ve stale element retry
        int maxAttempts = 5;
        int attempts = 0;

        while(attempts < maxAttempts) {
            try {
                if(logoutLink.isDisplayed()) {
                    // Görünüyorsa dur
                    break;
                } else {
                    // Görünmüyorsa JS ile biraz kaydır
                    ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView({behavior:'smooth', block:'center'});", logoutLink);
                }
            } catch(StaleElementReferenceException e) {
                // Element stale olduysa tekrar bul
                PageFactory.initElements(Driver.getDriver(), this);
            }
            attempts++;
        }
    }

    public boolean isLogoutVisible() {
        try {
            return logoutLink.isDisplayed();
        } catch (StaleElementReferenceException e) {
            PageFactory.initElements(Driver.getDriver(), this);
            return logoutLink.isDisplayed();
        }
    }

    public boolean isLogoutClickable() {
        try {
            return logoutLink.isEnabled();
        } catch (StaleElementReferenceException e) {
            PageFactory.initElements(Driver.getDriver(), this);
            return logoutLink.isEnabled();
        }
    }



}



