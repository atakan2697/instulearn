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




























}



