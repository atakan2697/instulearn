package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class AtakanPage {

    public AtakanPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[text()='Login']")
    public WebElement loginLinki;

    @FindBy(xpath = "(//img[@class='img-cover'])[2]")
    public WebElement solTaraftakiImg;

    @FindBy(xpath = "//*[text()='Log in to your account']")
    public WebElement logInToYourAccount;

    @FindBy(xpath = "//input[@id='email']")
    public WebElement email;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement password;

    @FindBy(xpath = "(//*[text()='Login'])[2]")
    public WebElement loginSayfasındakiLoginButonu;

    @FindBy(xpath = "//*[text()='Forgot your password?']")
    public WebElement forgotYourPassword;

    @FindBy(xpath = "(//*[text()='Login'])[2]")
    public WebElement forgotSayfasindakiLoginButonu;

    @FindBy(xpath = "//div[@class='invalid-feedback']")
    public WebElement emailAlanindakiHataMesaji;

    @FindBy(xpath = "(//*[text()='Courses'])[1]")
    public WebElement coursesLinki;

    @FindBy(xpath = "text-white font-30 mb-15")
    public WebElement coursesTexti;

    @FindBy(xpath = "//*[text()='Search']")
    public WebElement searchButonu;

    @FindBy(xpath = "//*[@class='form-control border-0']")
    public WebElement searchTexti;

    @FindBy(xpath = "(//*[@class='mb-0 mr-10 cursor-pointer'])[4]")
    public WebElement downloadSecenegi;

    @FindBy (xpath = "(//div[@class='image-box'])[4]")
    public WebElement kursKartlariList;

    @FindBy(xpath = "//div[@class='webinar-price-box mt-25']")
    public List<WebElement> kursKartlariFiyat;

    @FindBy(xpath = "//span[@class='date-published font-14 ml-5']")
    public List<WebElement> kursKartlariTarih;

    @FindBy(xpath = "//span[@class='d-block font-14 mt-10']")
    public List<WebElement> kursKartlariDersAdi;

    @FindBy(xpath = "//h3[@class='mt-15 webinar-title font-weight-bold font-16 text-dark-blue']")
    public List<WebElement> kursKartlariInstructorBilgileri;

    @FindBy(xpath = "//button[@class='btn btn-primary js-course-add-to-cart-btn']")
    public WebElement addToCardButonu;

    @FindBy(xpath = "//button[@class='btn btn-outline-danger mt-20 js-course-direct-payment']")
    public WebElement buyNowButonu;

    @FindBy(xpath = "//*[text()='Register']")
    public WebElement registerButonu;

    @FindBy(xpath = "//*[@alt='site logo']")
    public WebElement siteLogo;

    @FindBy(xpath = "//span[@class='font-16 user-name ml-10 text-dark-blue font-14']")
    public WebElement atakanProfilButonu;

    @FindBy(xpath = "//*[text()='Logout']")
    public WebElement logoutButonu;

    @FindBy(xpath = "//*[text()='About this course']")
    public WebElement aboutThisCourseTexti;

    @FindBy(xpath = "//*[@name='comment']")
    public WebElement commentsAlani;

    @FindBy(xpath = "//*[text()='Post comment']")
    public WebElement postCommentButonu;

    @FindBy(xpath = "//*[text()='Comments ']")
    public WebElement commentsTexti;

    @FindBy(xpath = "//a[text()='Profile']")
    public WebElement kursProfilButonu;

    @FindBy(xpath = "//div[@class='teacher-avatar mt-5']")
    public WebElement kursProfilAvatarImg;

    @FindBy(xpath = "//input[@name='full_name']")
    public WebElement registerFullName;

    @FindBy(xpath = "//input[@id='confirm_password']")
    public WebElement registerConfirmPassword;

    @FindBy(xpath = "//*[@id='term']")
    public WebElement registerIAgreeButonu;

    @FindBy(xpath = "//button[@class='btn btn-primary btn-block mt-20']")
    public WebElement registerSignUpButonu;

    @FindBy(xpath = "//*[@for='role_teacher']")
    public WebElement registerInstructorSecimi;

    @FindBy(xpath = "//*[text()='Stripe']")
    public WebElement stripeButonu;

    @FindBy(xpath = "//*[text()='Start Payment']")
    public WebElement startPaymentButonu;

    @FindBy(xpath = "//*[text()='Link olmadan öde']")
    public WebElement linkOlmadanÖdeButonu;

    @FindBy(xpath = "//input[@autocomplete='cc-number']")
    public WebElement ödemeKartBilgileri;

    @FindBy(xpath = "//input[@autocomplete='cc-exp']")
    public WebElement ödemeKartCC;

    @FindBy(xpath = "//input[@autocomplete='cc-csc']")
    public WebElement ödemeKartCVC;

    @FindBy(xpath = "//input[@autocomplete='cc-name']")
    public WebElement ödemeKartAdıSoyadı;

    @FindBy(xpath = "//input[@id='enableStripePass']")
    public WebElement güvenliÖdeme;

    @FindBy(xpath = "//*[@id='phoneNumber']")
    public WebElement ödemeTelBilgileri;

    @FindBy(xpath = "//div[@class='SubmitButton-IconContainer']")
    public WebElement ödeButonu;

    @FindBy(xpath = "//*[text()='Your payment successfully done...']")
    public WebElement ödemeBasariliTexti;

    @FindBy(xpath = "//*[text()='Support']")
    public WebElement supportLinki;

    @FindBy(xpath = "//*[text()='New']")
    public WebElement newLinki;

    @FindBy(xpath = "//*[text()='Courses support']")
    public WebElement coursesSupportLinki;

    @FindBy(xpath = "//*[text()='Tickets']")
    public WebElement ticketsLinki;

    @FindBy(xpath = "//*[@class='form-control ']")
    public WebElement subjectAlani;

    @FindBy(xpath = "//*[@id='supportType']")
    public WebElement typeAlani;

    @FindBy(xpath = "(//*[@role='combobox'])[1]")
    public WebElement departmentAlani;

    @FindBy(xpath = "(//*[text()='Content'])[2]")
    public WebElement contentSecimi;

    @FindBy(xpath = "//*[@name='message']")
    public WebElement messasgeAlani;

    @FindBy(xpath = "//*[text()='Send Message']")
    public WebElement sendMessageButonu;

    @FindBy(xpath = "//div[@class='activities-container mt-25 p-20 p-lg-35']")
    public WebElement destekOzetBoard;

    @FindBy(xpath = "//h2[@class='text-dark-blue']")
    public WebElement youDontHaveSupportMessagesTexti;

    @FindBy(xpath = "(//div[@class='user-inline-avatar d-flex align-items-center'])[1]")
    public WebElement messagesHistoryBölümündekiLink;

    @FindBy(xpath = "//*[text()='Close request']")
    public WebElement closeRequest;

    @FindBy(xpath = "(//*[@class='text-center font-14 text-gray font-weight-500'])[1]")
    public WebElement updateDateTexti;

    @FindBy(xpath = "(//*[@class='text-center font-14 text-gray font-weight-500'])[2]")
    public WebElement departmentTexti;

    @FindBy(xpath = "(//*[@class='text-center font-14 text-gray font-weight-500'])[3]")
    public WebElement statusTexti;

    @FindBy(xpath = "(//*[text()='Closed'])[2]")
    public WebElement closedDurumu;

    @FindBy(xpath = "//div[@id='conversationsList']")
    public WebElement acilanTicketlarListesi;

    @FindBy(xpath = "//*[@class='text-left font-14 text-gray font-weight-500']")
    public WebElement titleBölümü;



}
