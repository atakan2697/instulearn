package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class MelahatnurPage {
    public MelahatnurPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath ="//a[text()='Instructors']")
    public WebElement instructorBasligi;

    @FindBy(xpath ="//a[text()='All Instructors']")
    public WebElement allInstructorButonu;

    @FindBy(css = ".owl-dot")
    public List<WebElement> sliderNoktasi;

    @FindBy(css = ".owl-dot.active")
    public WebElement activeSliderNoktasi; // Sadece o an seçili olan aktif nokta

    @FindBy(css = ".owl-stage-outer")
    public WebElement instructorSliderArea;


    @FindBy(xpath = "//h3[contains(@class, 'text-dark-blue')]")
    public List<WebElement> instructorIsimleri;

    @FindBy(xpath = "//*[local-name()='svg']//*[local-name()='polygon']")
    public List<WebElement> instructorPuanlari;

    @FindBy(xpath = "//a[contains(text(),'Reserve a live meeting')]")
    public List<WebElement> reserveButonu;

    @FindBy(xpath = "//a[text()='Login']")
    public WebElement logineGidisButonu;

    @FindBy(xpath = "//input[@id='email']")
    public WebElement loginEmailButonu;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement loginSifreButonu;

    @FindBy(xpath = "//button[text()='Login']")
    public WebElement loginButonu;

    @FindBy(xpath = "//span[text()='Settings']")
    public WebElement settingsLinki;


    @FindBy(name = "email")
    public WebElement basicInformationEmail;

    @FindBy(name = "full_name")
    public WebElement basicInformationName;

    @FindBy(name = "password")
    public WebElement basicInformationPassword;

    @FindBy(name = "password_confirmation")
    public WebElement basicInformationPasswordTekrari;

    @FindBy(name = "mobile")
    public WebElement basicInformationTelefonNumber;

    @FindBy(name = "language")
    public WebElement basicInformationLanguange;

    @FindBy(xpath = "//span[text()='Select']")
    public WebElement basicInformationTimeZone;


    @FindBy(xpath = "//button[text()='Save']")
    public WebElement saveButonu;

    @FindBy(xpath = "//button[text()='Save']")
    public WebElement nextButonu;

    @FindBy(xpath = "//label[text()='Join email newsletter']")
    public WebElement basicInformationJoinEmail;

    @FindBy(xpath = "//label[text()='Enable profile messages']")
    public WebElement basicInformationEnableProfil;
}
