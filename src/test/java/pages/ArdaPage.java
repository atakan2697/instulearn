package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ArdaPage {

    public ArdaPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    // US_013 - TC_01: Validate Certificates kartı
    @FindBy(xpath = "//a[@href='/certificate_validation']")
    public WebElement validateCertificatesCard;

    // Certificate Validation sayfa başlığı
    @FindBy(xpath = "//*[text()='Certificate Validation']")
    public WebElement certificateValidationTitle;

    @FindBy(xpath = "//input[@placeholder='Certificate ID']")
    public WebElement certificateIdInput;

    @FindBy(name = "captcha")
    public WebElement captchaInput;

    @FindBy(id = "formSubmit")
    public WebElement validateButton;

    @FindBy(css = "a[href='/instructors']")
    public WebElement reserveMeetingCard;

    @FindBy(css = "section.find-instructor-section")
    public WebElement findInstructorSection;
    @FindBy(css = "img[alt='Reserve a meeting - Home']")
    public WebElement reserveMeetingCardImg;


}