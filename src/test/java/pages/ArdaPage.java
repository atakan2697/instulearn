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

    // Certificate Validation sayfa başlığı (sayfa açıldı mı kontrolü için)
    @FindBy(xpath = "//*[text()='Certificate Validation']")
    public WebElement certificateValidationTitle;
}