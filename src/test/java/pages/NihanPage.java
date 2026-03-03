package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

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
}
