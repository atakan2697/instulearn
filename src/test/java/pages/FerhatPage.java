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
}
