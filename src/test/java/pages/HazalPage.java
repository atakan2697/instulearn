package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class HazalPage {

    public HazalPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//img[@alt='Home - Join as instructor']")
    public WebElement homeJoinAsInstructorBasligiLink;

    @FindBy(xpath = "//input[@id='email']")
    public WebElement loginPageEmailBox;

    @FindBy(xpath = "//a[text()='Login']")
    public WebElement homePageLoginButton;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement loginPagePasswordBox;

    @FindBy(xpath = "//button[text()='Login']")
    public WebElement loginPageLoginButton;

    @FindBy(xpath = "//span[text()='Marketing']")
    public WebElement dashboardMarketing;

    @FindBy(xpath = "//a[text()='Discounts']")
    public WebElement dashboardMarketingDiscounts;

    @FindBy(xpath = "//a[text()='Promotions']")
    public WebElement dashboardMarketingPromotions;

    @FindBy(xpath = "//h2[@class='section-title']")
    public List<WebElement> discountsPageBasliklar;

    @FindBy(xpath = "//input[@name='name']")
    public WebElement discountsPageTitle;

    @FindBy(xpath = "//select[@name='webinar_id']")
    public WebElement discountsCourseSelectMenu;

    @FindBy(xpath = "//input[@name='percent']")
    public WebElement discountsPageAmount;

    @FindBy(xpath = "//input[@name='from_date']")
    public WebElement discountsPageFrom;

    @FindBy(xpath = "//input[@name='to_date']")
    public WebElement discountsPageTo;

    @FindBy(xpath = "//button[@id='formSubmit']")
    public WebElement discountsPageCreateButton;

    @FindBy(xpath = "//tbody/tr[1]/td[4]")
    public WebElement discountsPageStatus;

    @FindBy(xpath = "//table[@class='table custom-table text-center']")
    public WebElement discountsPageTable;

    @FindBy(xpath = "//div[@class='plan-icon']")
    public List<WebElement> promotionsPagePlans;

    @FindBy(xpath = "(//button[text()='Purchase'])[1]")
    public WebElement promotionsPagePurchaseButton;

    @FindBy(xpath = "(//button[text()='Pay'])[2]")
    public WebElement promotionCoursePayButton;

    @FindBy(xpath = "//label[@for='Stripe']")
    public WebElement stripePay;

    @FindBy(xpath = "//button[@id='paymentSubmit']")
    public WebElement startPaymentButton;

    @FindBy(xpath = "//input[@id='email']")
    public WebElement paymentEmailBox;

    @FindBy(xpath = "//input[@id='cardNumber']")
    public WebElement paymentCardNumber;

    @FindBy(xpath = "//input[@id='cardExpiry']")
    public WebElement paymentCardDate;

    @FindBy(xpath = "//input[@id='cardCvc']")
    public WebElement paymentCardCvc;

    @FindBy(xpath = "//input[@id='billingName']")
    public WebElement paymentCardholderName;

    @FindBy(xpath = "//select[@id='billingCountry']")
    public WebElement paymentCountrySelectMenu;

    @FindBy(xpath = "(//div[@class='Icon Icon--md'])[2]")
    public WebElement paymentPayButton;

    @FindBy(xpath = "//h2")
    public WebElement paymentThenMessage;

    @FindBy(xpath = "//table[@class='table custom-table text-center ']")
    public WebElement promotionsHistoryTable;

    @FindBy(xpath = "(//select[@name='webinar_id'])[2]")
    public WebElement promotionsCourseSelectMenu;

    @FindBy(xpath = "//a[text()='My Panel']")
    public WebElement promotionsMyPanelButton;

    @FindBy(xpath = "//span[text()='Financial']")
    public WebElement dashboardFinancial;

    @FindBy(xpath = "//a[text()='Sales report']")
    public WebElement dashboardFinancialSalesReport;

    @FindBy(xpath = "//a[text()='Financial summary']")
    public WebElement dashboardFinancialSummary;

    @FindBy(xpath = "//a[text()='Payout']")
    public WebElement dashboardFinancialPayout;

    @FindBy(xpath = "//a[text()='Charge account']")
    public WebElement dashboardFinancialChargeAccount;

    @FindBy(xpath = "//a[text()='Subscribe']")
    public WebElement dashboardFinancialSubscribe;

    @FindBy(xpath = "//div[@class='activities-container mt-25 p-20 p-lg-35']")
    public WebElement dashboardFinancialSalesReportInformation;

    @FindBy(xpath = "//table[@class='table text-center custom-table']")
    public WebElement dashboardFinancialSalesReportSalesHistoryTable;

    @FindBy(xpath = "//input[@name='from']")
    public WebElement salesReportPageFrom;

    @FindBy(xpath = "//input[@name='to']")
    public WebElement salesReportPageTo;

    @FindBy(xpath = "(//span[@role='textbox'])[1]")
    public WebElement salesReportPageLiveClassAll;

    @FindBy(xpath = "//input[@role='searchbox']")
    public WebElement salesReportPageLiveClassAllSearchbox;

    @FindBy(xpath = "(//span[@role='textbox'])[2]")
    public WebElement salesReportPageStudentAll;

    @FindBy(xpath = "//input[@role='searchbox']")
    public WebElement salesReportPageStudentAllSearchbox;

    @FindBy(xpath = "//select[@id='type']")
    public WebElement salesReportPageTypeSelectMenu;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement salesReportPageShowResultsButton;

    @FindBy(xpath = "(//span[@class='d-block'])[1]")
    public WebElement salesReportPageSalesHistoryTableStudentIsimElementi;

    @FindBy(xpath = "//div[@class='table-responsive']")
    public WebElement financialSummaryPageFinancialDocumentsTable;

    @FindBy(xpath = "//h2[@class='section-title']")
    public WebElement financialSummaryPageFinancialDocuments;

    @FindBy(xpath = "//label[@for='Stripe']")
    public WebElement chargeAccountPagePaymentStripe;

    @FindBy(xpath = "//input[@name='amount']")
    public WebElement chargeAccountPageAmount;

    @FindBy(xpath = "//button[@id='submitChargeAccountForm']")
    public WebElement chargeAccountPagePayButton;

    @FindBy(xpath = "//a[@class='btn btn-sm btn-primary mt-20']")
    public WebElement chargeAccountMyPanelButton;

    @FindBy(xpath = "(//strong[@class='font-30 text-dark-blue font-weight-bold mt-5'])[1]")
    public WebElement chargeAccountPageCuzdanBakiyesi;

    @FindBy(xpath = "//a[text()='Register']")
    public WebElement homePageRegisterButton;

    @FindBy(xpath = "(//h2[@class='section-title'])[1]")
    public WebElement subscribesPageMyActivePlanYaziElementi;

    @FindBy(xpath = "//label[text()='Instructor']")
    public WebElement registerPageInstructorButton;

    @FindBy(xpath = "//input[@name='email']")
    public WebElement registerPageEmailBox;

    @FindBy(xpath = "//input[@name='full_name']")
    public WebElement registerPageFullNameBox;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement registerPagePasswordBox;

    @FindBy(xpath = "//input[@name='password_confirmation']")
    public WebElement registerPageRetypePasswordBox;

    @FindBy(xpath = "//span[@role='presentation']")
    public WebElement registerPageTimeZoneMenu;

    @FindBy(xpath = "//input[@type='search']")
    public WebElement registerPageTimeZoneSearchBox;

    @FindBy(xpath = "//input[@id='term']")
    public WebElement registerPageAgreeCheckbox;

    @FindBy(xpath = "(//button[@type='submit'])[2]")
    public WebElement registerPageSignUpButton;

    @FindBy(xpath = "//span[@class='font-16 user-name ml-10 text-dark-blue font-14']")
    public WebElement instructorProfilButton;

    @FindBy(xpath = "//span[text()='Dashboard']")
    public WebElement instructorProfilButtonDashboard;

    @FindBy(xpath = "(//button[@type='submit'])[3]")
    public WebElement subscribesPageSilverPurchaseButton;

    @FindBy(xpath = "//label[@for='Stripe']")
    public WebElement subscribesPaymentStripe;

    @FindBy(xpath = "//button[@id='paymentSubmit']")
    public WebElement subscribesStartPayment;

    @FindBy(xpath = "//a[text()='My Panel']")
    public WebElement subscribesMyPanelButton;



}
