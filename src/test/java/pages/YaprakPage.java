package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class YaprakPage {


    public YaprakPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    // US15
    @FindBy(xpath = "//a[@href='/organizations']")
    public WebElement allOrganizationsBtn;
    @FindBy(xpath = "(//span[contains(@class,'swiper-pagination-bullet')])[last()]")
    public WebElement lastSlideBtn;
    @FindBy(xpath = "(//a[@id='webinars-tab'])[1]")
    public WebElement coursesTab;
    @FindBy(xpath = "//*[contains(text(),\"Instructor doesn't have any course!\")]")
    public List<WebElement> noCourseMessageList;


    //US43
    @FindBy(xpath = "(//a[@href='/login'])[1]")
    public WebElement ilkLoginButonu;
    @FindBy(xpath = "//input[@id='email']")
    public WebElement emailKutusu;
    @FindBy(xpath = "//input[@id='password']")
    public WebElement passwordKutusu;
    @FindBy(xpath = "//button[text()='Login']")
    public WebElement submitLoginButonu;
    @FindBy(xpath = "//span[normalize-space()='Dashboard']")
    public WebElement dashboardAltMenu;
    // Filtre tarih alanları (From / To)
    @FindBy(name = "from")
    public WebElement fromDateInput;
    @FindBy(name = "to")
    public WebElement toDateInput;
    @FindBy(xpath = "//button[@type='submit' and contains(.,'Show Results')]")
    public WebElement showResultsButton;
    @FindBy(xpath = "//h2[contains(normalize-space(),'No result')]")
    public WebElement noResult;
    @FindBy(xpath = "//div[contains(@class,'table-responsive')]//tr")
    public List<WebElement> alinmayanSinavlar;
    @FindBy(xpath = "//span[text()=\"Quizzes\"]")
    public WebElement QuizzesMenu;
    @FindBy(xpath = "//*[text()=\"My results\"]")
    public WebElement myResultsMenu;
    @FindBy(xpath = "//*[text()=\"Not Participated\"]")
    public  WebElement notParticipatedMenu;
    @FindBy(xpath = "//h2[@class='section-title' and normalize-space()='Results statistics']")
    public WebElement resultsStatisticsTitle;

    //US45

    @FindBy(xpath = "//span[normalize-space(text())='Financial']")
    public WebElement financialMenu;
    @FindBy(xpath = "//*[text()=\"Sales report\"]")
    public WebElement salesReportMenu;
    @FindBy(xpath = "//*[text()=\"Financial summary\"]")
    public WebElement financialSummaryMenu;
    @FindBy(xpath = "//*[text()=\"Payout\"]")
    public WebElement payoutMenu;
    @FindBy(xpath = "//*[text()=\"Charge account\"]")
    public WebElement chargeAccountMenu;
    @FindBy(xpath = "//*[text()=\"Subscribe\"]")
    public WebElement subscribeMenu;
    @FindBy(xpath = "//*[@class=\"py-5 px-10 text-dark-blue font-14\"]")
    public WebElement registerMenu;
    @FindBy(xpath = "(//*[@class=\"font-12 cursor-pointer px-15 py-10\"])[1]")
    public WebElement registerStudent;
    @FindBy(xpath = "//input[@id='email']")
    public WebElement registeremail;
    @FindBy(xpath = "//input[@name='full_name']")
    public WebElement registerFullname;
    @FindBy(xpath = "//input[@id='password']")
    public WebElement registerPassword;
    @FindBy(xpath = "//input[@id='confirm_password']")
    public WebElement registerConfirmpassword;
    @FindBy(xpath = "//*[@id='term']")
    public WebElement registerIAgreeButon;
    @FindBy(xpath = "//button[@class='btn btn-primary btn-block mt-20']")
    public WebElement registerSignUpButon;
    @FindBy(xpath = "//span[contains(@class,'user-name')]")
    public WebElement userEnter;
    //payout hesabı olustur sil vs
    @FindBy(xpath = "//*[@class=\"text-decoration-underline\"]")
    public WebElement payoutYonlendirmeSetting;
    @FindBy(xpath = "//input[@type='text' and @name=\"bank_specifications[12]\"]")
    public WebElement  accountHolder;
    @FindBy(xpath = "//input[@type='text' and @name=\"bank_specifications[13]\"]")
    public WebElement accountID;
    @FindBy(name = "bank_id")
    public WebElement bankSelect;
    @FindBy(xpath = "//button[@id='saveData']")
    public  WebElement savePayoutAccount;
    @FindBy(xpath = "//*[@class=\"request-payout btn btn-sm btn-primary\"]")
    public WebElement requestPayout;
    @FindBy(xpath = "//*[text()='Waiting']")
    public WebElement requestPayoutStatu;
    @FindBy(xpath = "//span[normalize-space(text())='Settings']")
    public WebElement settingsMenu;
    @FindBy(xpath = "//a[contains(@href,'/panel/setting/step/7')]")
    public WebElement identityFinancialStep;
    @FindBy(xpath = "//a[@href='/panel/setting/deleteAccount']")
    public WebElement deleteAccountButton;
    @FindBy(xpath = "//button[normalize-space(text())='Yes, I confirm!']")
    public WebElement payoutConfirmDeleteButton;
    @FindBy(xpath = "//h2[@id='swal2-title']")
    public WebElement deleteAccoutnSuccessPopupTitle;
    @FindBy(xpath = "//p[contains(text(),'Your identity')]")
    public WebElement identityApprovedMessage;
    @FindBy(xpath = "//a[text()='Charge account']")
    public WebElement ChargeAccount;
    @FindBy(xpath = "//a[@class='btn btn-sm btn-primary mt-20']")
    public WebElement chargeAccountMyPanel;
    @FindBy(xpath = "//label[@for='Stripe']")
    public WebElement  chargestripePaymentLabel;
    @FindBy(name = "amount")
    public WebElement  chargeamountInput;
    @FindBy(xpath = "//button[@id='submitChargeAccountForm']")
    public WebElement  chargepayButton;
    @FindBy(id = "email")
    public WebElement  chargeemailInput; // yaprak.user@instulearn.com
    @FindBy(id = "cardNumber")
    public WebElement cardNumberInput; //4242 4242 4242 4242
    @FindBy(id = "cardExpiry")
    public WebElement cardExpiryInput; //02 / 30
    @FindBy(id = "cardCvc")
    public WebElement cardCvcInput; //112
    @FindBy(xpath = "//div[contains(@class,'SubmitButton-SpinnerIcon')]")
    public WebElement paymentSpinner;
    @FindBy(xpath = "//div[contains(@class,'SubmitButton-SpinnerIcon')]")
    public WebElement submitSpinner;
    @FindBy(css = "input[autocomplete='cc-name']")
    public WebElement cardHolderNameInput;
    @FindBy(xpath = "//h2[contains(text(),'Congratulations')]")
    public WebElement congratulationsText;
    @FindBy(css = "input[data-testid^='sms-code-input']")
    public List<WebElement> smsCodeInputs;
    @FindBy(xpath = "//strong[contains(@class,'font-weight-bold')]")
    public WebElement activePlanText;
    @FindBy(xpath = "//button[@type='submit' and text()='Purchase']")
    public WebElement goldPurchaseButton;

























}



