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

    // us15
    @FindBy(xpath = "//a[@href='/organizations']")
    public WebElement allOrganizationsBtn;
    @FindBy(xpath = "(//span[contains(@class,'swiper-pagination-bullet')])[last()]")
    public WebElement lastSlideBtn;
    @FindBy(xpath = "(//a[@id='webinars-tab'])[1]")
    public WebElement coursesTab;
    @FindBy(xpath = "//*[contains(text(),\"Instructor doesn't have any course!\")]")
    public List<WebElement> noCourseMessageList;
}

