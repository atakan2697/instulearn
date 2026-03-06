package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class EbruPage {

    public EbruPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[contains(@class,'navbar-brand')]")
    public WebElement instulearnLogo;

    @FindBy(xpath = "//a[@href='/forget-password']")
    public WebElement forgotYourPasswordLink;

    @FindBy(xpath = "//a[contains(@href,'forgot') or contains(@href,'recover') or contains(@href,'reset')]")
    public WebElement forgotLinkByHref;

    @FindBy(xpath = "//h1|//h2")
    public WebElement pageHeader;

    @FindBy(xpath = "//input[@type='email' or contains(@name,'email') or contains(@id,'email') or contains(@placeholder,'mail') or contains(@placeholder,'Email')]")
    public WebElement emailTextbox;

    @FindBy(xpath = "//button[contains(.,'Reset') and contains(.,'Password')] | //button[@type='submit']")
    public WebElement resetPasswordButton;

    @FindBy(xpath = "//*[contains(@class,'alert') or contains(@class,'toast') or contains(@role,'alert') or contains(@class,'notification')]" +
            "[contains(translate(.,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'email') " +
            "or contains(translate(.,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'sent') " +
            "or contains(translate(.,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'success') " +
            "or contains(translate(.,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'reset')]")
    public WebElement resetSuccessMessage;

    @FindBy(xpath = "//a[contains(@href,'login') or contains(text(),'Login')]")
    public WebElement backToLoginLink;

    @FindBy(xpath = "//*[contains(text(),'Featured Courses')]")
    public WebElement featuredCoursesTitle;

    @FindBy(xpath = "//*[contains(text(),'Featured Courses')]/ancestor::section[1] | //*[contains(text(),'Featured Courses')]/ancestor::div[1]")
    public WebElement featuredCoursesSection;

    // Ilk tiklanabilir link
    @FindBy(xpath = "(//*[contains(text(),'Featured Courses')]/ancestor::section[1]//a | //*[contains(text(),'Featured Courses')]/ancestor::div[1]//a)[1]")
    public WebElement featuredFirstCard;

    // Featured bolumu icindeki kartlar
    @FindBy(xpath = "//*[contains(text(),'Featured Courses')]/ancestor::section[1]//*[contains(@class,'card') or contains(@class,'course')] | //*[contains(text(),'Featured Courses')]/ancestor::div[1]//*[contains(@class,'card') or contains(@class,'course')]")
    public List<WebElement> featuredCards;

    // EbruPage.java icine EKLE

    @FindBy(xpath = "//*[contains(text(),'Newest Courses')]")
    public WebElement newestCoursesTitle;

    @FindBy(xpath = "//*[contains(text(),'Newest Courses')]/ancestor::section[1] | //*[contains(text(),'Newest Courses')]/ancestor::div[1]")
    public WebElement newestCoursesSection;

    @FindBy(xpath = "//*[contains(text(),'Newest Courses')]/ancestor::section[1]//*[contains(@class,'card') or contains(@class,'course')] | //*[contains(text(),'Newest Courses')]/ancestor::div[1]//*[contains(@class,'card') or contains(@class,'course')]")
    public java.util.List<WebElement> newestCourseCards;

    // fiyat
    @FindBy(xpath = "//*[contains(text(),'Newest Courses')]/ancestor::section[1]//*[contains(@class,'price') or contains(text(),'$') or contains(text(),'€') or contains(text(),'₺')] | //*[contains(text(),'Newest Courses')]/ancestor::div[1]//*[contains(@class,'price') or contains(text(),'$') or contains(text(),'€') or contains(text(),'₺')]")
    public java.util.List<WebElement> newestCoursePrices;

    // saat / duration
    @FindBy(xpath = "//*[contains(text(),'Newest Courses')]/ancestor::section[1]//*[contains(text(),'hour') or contains(text(),'Hours') or contains(@class,'duration')] | //*[contains(text(),'Newest Courses')]/ancestor::div[1]//*[contains(text(),'hour') or contains(text(),'Hours') or contains(@class,'duration')]")
    public java.util.List<WebElement> newestCourseDurations;

    // tarih
    @FindBy(xpath = "//*[contains(text(),'Newest Courses')]/ancestor::section[1]//*[contains(@class,'date') or contains(text(),'202') or contains(text(),'Jan') or contains(text(),'Feb') or contains(text(),'Mar') or contains(text(),'Apr') or contains(text(),'May') or contains(text(),'Jun') or contains(text(),'Jul') or contains(text(),'Aug') or contains(text(),'Sep') or contains(text(),'Oct') or contains(text(),'Nov') or contains(text(),'Dec')] | //*[contains(text(),'Newest Courses')]/ancestor::div[1]//*[contains(@class,'date') or contains(text(),'202') or contains(text(),'Jan') or contains(text(),'Feb') or contains(text(),'Mar') or contains(text(),'Apr') or contains(text(),'May') or contains(text(),'Jun') or contains(text(),'Jul') or contains(text(),'Aug') or contains(text(),'Sep') or contains(text(),'Oct') or contains(text(),'Nov') or contains(text(),'Dec')]")
    public java.util.List<WebElement> newestCourseDates;

    // instructor
    @FindBy(xpath = "//*[contains(text(),'Newest Courses')]/ancestor::section[1]//*[contains(@class,'instructor') or contains(@class,'teacher') or contains(@class,'author')] | //*[contains(text(),'Newest Courses')]/ancestor::div[1]//*[contains(@class,'instructor') or contains(@class,'teacher') or contains(@class,'author')]")
    public java.util.List<WebElement> newestCourseInstructors;

    // View all butonu
    @FindBy(xpath = "(//*[contains(text(),'Newest Courses')]/ancestor::section[1]//a[contains(.,'View all') or contains(.,'View All')] | //*[contains(text(),'Newest Courses')]/ancestor::div[1]//a[contains(.,'View all') or contains(.,'View All')])[1]")
    public WebElement newestCoursesViewAllButton;

    @FindBy(xpath = "(//*[contains(text(),'Newest Courses')]/ancestor::section[1]//*[contains(@class,'card')])[1]")
    public WebElement firstNewestCourseCard;

    @FindBy(xpath = "(//*[contains(text(),'Newest Courses')]/ancestor::section[1]//a[contains(text(),'View') or contains(text(),'All')])[1]")
    public WebElement newestViewAllButton;



    // Ana sayfadaki herhangi bir kurs karti altindaki go to card / detay ikonunu yakalamak icin
    @FindBy(xpath = "(//a[contains(@href,'course') or contains(@href,'bundle') or contains(@href,'detail')])[1]")
    public WebElement goToCardIcon;

    // Trending Categories basligi
    @FindBy(xpath = "//*[contains(text(),'Trending Categories')]")
    public WebElement trendingCategoriesTitle;

    // Trending Categories bolumu
    @FindBy(xpath = "//*[contains(text(),'Trending Categories')]/ancestor::section[1] | //*[contains(text(),'Trending Categories')]/ancestor::div[1]")
    public WebElement trendingCategoriesSection;

    // kategori kartlari
    @FindBy(xpath = "//*[contains(text(),'Trending Categories')]/ancestor::section[1]//a | //*[contains(text(),'Trending Categories')]/ancestor::div[1]//a")
    public java.util.List<WebElement> categoryCards;

    // ilk kategori
    @FindBy(xpath = "(//*[contains(text(),'Trending Categories')]/ancestor::section[1]//a | //*[contains(text(),'Trending Categories')]/ancestor::div[1]//a)[1]")
    public WebElement firstCategory;
}