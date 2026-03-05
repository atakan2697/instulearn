

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;

import java.time.Duration;
import java.util.List;

public class SevkiPage {

    public SevkiPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }



    private final WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));


    // Başlık: h1/h2 içinde metni yakala (3 nokta vs farklı olabilir diye contains kullandım)
    private final By heroTitle = By.xpath(
            "//*[self::h1 or self::h2][contains(normalize-space(), 'Transform Your Future with InstuLearn')]"
    );

    // Search box: olası input tipleri/placeholder/aria-label (gerekirse bunu netleştirirsin)
    private final By searchBox = By.cssSelector(
            "input[type='search'], input[placeholder*='Search' i], input[aria-label*='search' i]"
    );

    // Search button: type=submit veya içinde 'Search' geçen buton
    private final By searchButton = By.xpath(
            "//button[@type='submit' or contains(.,'Search') or .//*[contains(.,'Search')]]"
    );

    public void waitForPageReady() {
        // basit stabil: başlık görünene kadar bekle
        wait.until(ExpectedConditions.visibilityOfElementLocated(heroTitle));
    }

    public boolean isHeroTitleVisible(String expectedText) {
        WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(heroTitle));
        String actual = el.getText().trim();
        // Beklenen metin 3 nokta vs farklı olabilir diye contains kontrol
        return actual.contains(expectedText.replace("...", "").trim())
                || actual.contains("Transform Your Future with InstuLearn");
    }

    public WebElement getSearchBox() {
        // Birden fazla eşleşirse ilk görünürü alalım
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(searchBox));
        List<WebElement> inputs = Driver.getDriver().findElements(searchBox);
        for (WebElement input : inputs) {
            if (input.isDisplayed()) return input;
        }
        return wait.until(ExpectedConditions.visibilityOfElementLocated(searchBox));
    }

    public WebElement getSearchButton() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(searchButton));
    }

    public boolean isSearchBoxVisibleAndEnabled() {
        WebElement box = getSearchBox();
        return box.isDisplayed() && box.isEnabled();
    }

    public boolean isSearchButtonVisibleAndEnabled() {
        WebElement btn = getSearchButton();
        return btn.isDisplayed() && btn.isEnabled();
    }

    //-------------------------------------------------------------------------------------------------------------------------------------------------------------------

    @FindBy(xpath = "//a[.//span[normalize-space()='Courses']]")
    public WebElement coursesMenu;

    @FindBy(xpath = "//a[@href='/panel/webinars/purchases']")
    public WebElement myPurchasesLink;

    @FindBy(xpath = "//h5[normalize-space()='The DevOps Essentials']")
    public WebElement firstCourseTitle;

    @FindBy(xpath = "(//div[contains(@class,'webinar-card')])[1]//a[contains(@href,'/course/')]")
    public WebElement firstCourseLink;

    @FindBy(xpath = "(//div[contains(@class,'webinar-card')])[1]//button[contains(@class,'dropdown-toggle')]")
    public WebElement firstCourseMenuButton;

    @FindBy(xpath = "(//div[contains(@class,'webinar-card')])[1]//div[contains(@class,'dropdown-menu') and contains(@class,'show')]//a[normalize-space()='Invoice']")
    public WebElement invoiceLink;

    @FindBy(xpath = "//div[contains(text(),'Item ID')]")
    public static WebElement invoiceNumber;

    @FindBy(xpath = "//h3[contains(@class,'webinar-title')]")
    public WebElement courseTitle;

    @FindBy(xpath = "//a[@class='btn btn-primary']")
    public WebElement learningPageButton;

    @FindBy(xpath = "//a[@href='/panel/webinars/favorites']")
    public WebElement favoritesButton;


    @FindBy(xpath = "(//*[name()='svg' and contains(@class,'more-vertical')])[1]")
    public WebElement firstCourseThreeDots;

    @FindBy(xpath = "//a[contains(@class,'delete-action')]")
    public WebElement removeButton;

    @FindBy(xpath = "//button[normalize-space()='Delete']")
    public WebElement deleteButton;

    @FindBy(xpath = "//a[normalize-space()='Login']")
    public WebElement loginLink;

    @FindBy(xpath = "//input[@type='email']")
    public WebElement emailInput;

    @FindBy(xpath = "//input[@type='password']")
    public WebElement passwordInput;

    @FindBy(xpath = "//button[normalize-space()='Login']")
    public WebElement loginButton;

















}

