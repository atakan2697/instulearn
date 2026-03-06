package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class ArdaPage {

    public ArdaPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    // US_013 - TC_01: Validate Certificates kartı
    @FindBy(xpath = "//a[@href='/certificate_validation']")
    public WebElement validateCertificatesCard;

    // Certificate Validation sayfa başlığı
    @FindBy(xpath = "//*[text()='Certificate Validation']")
    public WebElement certificateValidationTitle;

    @FindBy(xpath = "//input[@placeholder='Certificate ID']")
    public WebElement certificateIdInput;

    @FindBy(name = "captcha")
    public WebElement captchaInput;

    @FindBy(id = "formSubmit")
    public WebElement validateButton;

    @FindBy(css = "a[href='/instructors']")
    public WebElement reserveMeetingCard;

    @FindBy(css = "section.find-instructor-section")
    public WebElement findInstructorSection;
    @FindBy(css = "img[alt='Reserve a meeting - Home']")
    public WebElement reserveMeetingCardImg;

    @FindBy(xpath = "//a[@href='/products' and normalize-space()='Store']")
    public WebElement storeLink;

    @FindBy(xpath = "//h1[normalize-space()='Products']")
    public WebElement productsTitle;
    @FindBy(xpath = "//input[@placeholder='Search in store']")
    public WebElement searchTextbox;

    @FindBy(xpath = "//button[text()='Search']")
    public WebElement searchButton;

    @FindBy(xpath = "//button[contains(text(),'Filter items')]")
    public WebElement filterItemsButton;



    @FindBy(xpath = "//div[contains(@class,'product-card')]")
    public List<WebElement> productList;
    // ===== US_035 LOCATORS =====





    // ===== STORE / PRODUCTS =====

    @FindBy(xpath = "//input[@placeholder='Search in store' or @name='search']")
    public WebElement productsSearchTextbox;

    @FindBy(xpath = "//button[normalize-space()='Search' and (@type='submit' or contains(@class,'btn'))]")
    public WebElement productsSearchButton;

    @FindBy(xpath = "//div[contains(@class,'webinar-card') or contains(@class,'product-card') or contains(@class,'course-card')]")
    public List<WebElement> productCards;

    @FindBy(xpath = "(//h3[@class='mt-15 product-title font-weight-bold font-16 text-dark-blue'])[1]")
    public WebElement firstProduct;

    @FindBy(xpath = "//span[contains(text(),'$')]")
    public WebElement productPrice;

    @FindBy(xpath = "//a[@id='seller-tab']")
    public WebElement sellerTab;

    @FindBy(xpath = "//div[contains(@class,'stars-card')]")
    public WebElement ratingArea;

    @FindBy(xpath = "//textarea[@name='comment']")
    public WebElement commentBox;

    @FindBy(xpath = "(//h3[contains(@class,'product-title')])[1]")
    public WebElement productTitleFromList;

    @FindBy(xpath = "//div[@class='course-description']")
    public WebElement productDescription;







// ===== LOGIN =====

    @FindBy(css = "a[href='/login']")
    public WebElement loginLink;

    @FindBy(id = "email")
    public WebElement loginEmailInput;

    @FindBy(id = "password")
    public WebElement loginPasswordInput;

    @FindBy(xpath = "//form[@method='Post' and @action='/login']//button[normalize-space()='Login']")
    public WebElement loginButton;

    @FindBy(css = "a[href*='profile'], a[href*='account'], .dropdown a, .top-navbar a")
    public WebElement userMenuPossible;


// ===== PRODUCT DETAIL =====

    @FindBy(xpath = "//button[@type='button' and contains(@class,'js-product-direct-payment')]")
    public WebElement buyNowButton;

    @FindBy(css = "a.btn-primary, button.btn-primary")
    public WebElement addToCartOrPrimaryBtn;


// ===== CART =====

    @FindBy(xpath = "//button[normalize-space()='Checkout']")
    public WebElement checkoutButton;


// ===== PAYMENT =====

    @FindBy(id = "Stripe")
    public WebElement stripeRadio;

    @FindBy(css = "label[for='Stripe']")
    public WebElement stripeLabelCard;

    @FindBy(id = "paymentSubmit")
    public WebElement startPaymentButton;

    // ===== STRIPE / LINK SCREEN =====




// ===== STRIPE PAYMENT FORM =====

    @FindBy(id = "email")
    public WebElement stripeEmailInput;

    @FindBy(id = "cardNumber")
    public WebElement cardNumberInput;

    @FindBy(id = "cardExpiry")
    public WebElement cardExpiryInput;

    @FindBy(id = "cardCvc")
    public WebElement cardCvcInput;

    @FindBy(xpath = "//input[@placeholder='Ad ve soyadı']")
    public WebElement cardHolderNameInput;

    @FindBy(id = "enableStripePass")
    public WebElement saveInfoCheckbox;

    @FindBy(id = "phoneNumber")
    public WebElement phoneNumberInput;

    @FindBy(xpath = "//button[@data-testid='hosted-payment-submit-button']")
    public WebElement stripePayButton;

    @FindBy(xpath = "//span[normalize-space()='Dashboard']/ancestor::a")
    public WebElement dashboardSidebarLink;

    @FindBy(xpath = "//span[normalize-space()='Courses']/ancestor::a")
    public WebElement coursesSidebarLink;

    @FindBy(xpath = "//span[normalize-space()='Meetings']/ancestor::a")
    public WebElement meetingsSidebarLink;

    @FindBy(xpath = "//span[normalize-space()='Quizzes']/ancestor::a")
    public WebElement quizzesSidebarLink;

    @FindBy(xpath = "//span[normalize-space()='Certificates']/ancestor::a")
    public WebElement certificatesSidebarLink;

    @FindBy(xpath = "//span[normalize-space()='Financial']/ancestor::a")
    public WebElement financialSidebarLink;

    @FindBy(xpath = "//span[normalize-space()='Support']/ancestor::a")
    public WebElement supportSidebarLink;

    @FindBy(xpath = "//span[normalize-space()='Notifications']/ancestor::a")
    public WebElement notificationsSidebarLink;

    @FindBy(xpath = "//span[normalize-space()='Settings']/ancestor::a")
    public WebElement settingsSidebarLink;

    @FindBy(xpath = "//span[normalize-space()='Log out' or normalize-space()='Logout']/ancestor::a")
    public WebElement logoutSidebarLink;








}