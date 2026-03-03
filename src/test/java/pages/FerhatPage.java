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

    @FindBy(xpath = "//img[@alt='Web Development icon']")
    public WebElement webdevelopmentLink;
}
