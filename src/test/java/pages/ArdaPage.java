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





    // Search textbox (placeholder: Search in store)
    @FindBy(xpath = "//input[@placeholder='Search in store' or @name='search']")
    public WebElement productsSearchTextbox;

    // Search button
    @FindBy(xpath = "//button[normalize-space()='Search' and (@type='submit' or contains(@class,'btn'))]")
    public WebElement productsSearchButton;



    // Product cards list (robust: any product grid card)
    @FindBy(xpath = "(//div[contains(@class,'webinar-card') or contains(@class,'product-card') or contains(@class,'course-card')])")
    public List<WebElement> productCards;

    @FindBy(xpath = "(//h3[@class='mt-15 product-title font-weight-bold font-16 text-dark-blue'])[1]")
    public WebElement firstProduct;

    @FindBy(xpath = "//h1[contains(@class,'product-title')]")
    public WebElement productName;

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
    @FindBy(css = "a[href='/login']")
    public WebElement loginLink;

    @FindBy(id = "email")
    public WebElement loginEmailInput;

    @FindBy(id = "password")
    public WebElement loginPasswordInput;

    @FindBy(css = "button[type='submit']")
    public WebElement loginButton;

    // Login olduktan sonra üstte isim alanı (Arda/Arda Emre vs). Varsa bunu doğrulamak iyi olur.
    // Login olunca sağ üstte kullanıcı adı çıkıyor demiştin.
    @FindBy(css = "a[href*='profile'], a[href*='account'], .dropdown a, .top-navbar a")
    public WebElement userMenuPossible; // projende net bir user locator varsa bunu daha spesifik yaparız


    // ===== PRODUCT DETAIL (BUY NOW) =====
    // Senin detail sayfanda Buy now butonu:
    // <button class="... js-product-direct-payment">Buy now!</button>
    @FindBy(css = "button.js-product-direct-payment")
    public WebElement buyNowButton;

    @FindBy(css = "a.btn-primary, button.btn-primary")
    public WebElement addToCartOrPrimaryBtn; // gerekirse yedek

    // ===== CART PAGE (CHECKOUT) =====
    // Senin ss'te checkout:
    // <button type="submit" class="btn btn-sm btn-primary mt-15">Checkout</button>
    @FindBy(xpath = "//button[normalize-space()='Checkout']")
    public WebElement checkoutButton;

    // ===== PAYMENT GATEWAY PAGE =====
    // Stripe radio:
    // <input type="radio" name="gateway" id="Stripe" ...>
    @FindBy(id = "Stripe")
    public WebElement stripeRadio;

    // Stripe kartına tıklamak daha stabil (label for="Stripe")
    @FindBy(css = "label[for='Stripe']")
    public WebElement stripeLabelCard;

    // Start Payment:
    // <button type="button" id="paymentSubmit" ...>Start Payment</button>
    @FindBy(id = "paymentSubmit")
    public WebElement startPaymentButton;








}