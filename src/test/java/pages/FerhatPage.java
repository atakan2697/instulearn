package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class FerhatPage {
    public FerhatPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[.='Subscribe Now!']")
    public WebElement subcribeNowYazisi;

    @FindBy(xpath = "//a[@class='btn btn-primary btn-block mt-50']")
    public List<WebElement> subscribeNowButtonlari;

    @FindBy(xpath = "//li[@class='cursor-pointer user-select-none d-flex xs-categories-toggle']")
    public WebElement categoriesButton;

    @FindBy(xpath = "//li[@class='nav-item']")
    public List<WebElement> ustBarLinkleri;

    @FindBy(xpath = "//img[@alt='Development icon']")
    public WebElement developmentLink;

    @FindBy(xpath = "//div[@class='simplebar-content-wrapper']")
    public List<WebElement> altMenuler;

    @FindBy(xpath = "//img[@alt='Web Development icon']")
    public WebElement webdevelopmentLink;

    @FindBy(xpath = "//img[@alt='site logo']")
    public WebElement siteLogo;

    @FindBy(xpath = "//button[@id='navbarNotification']")
    public WebElement notificationsLink;

    @FindBy(xpath = "(//input[@type='text'])[1]")
    public WebElement searchTextbox;

    @FindBy(xpath = "//h1[@class='text-white font-30 white-space-pre-wrap']")
    public WebElement searchTextboxSonuc;

    @FindBy(xpath = "//a[normalize-space()='Start learning']")
    public WebElement startLearningButton;

    @FindBy(xpath = "(//a[normalize-space()='Login'])[1]")
    public WebElement loginLink;

    @FindBy(xpath = "//a[normalize-space()='Register']")
    public WebElement registerLink;
}
