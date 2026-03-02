package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class EbruPage {

    public EbruPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    // Navbar logo (InstuLearn yazisi / logo linki)
    @FindBy(xpath = "//a[contains(@class,'navbar-brand')]")
    public WebElement instulearnLogo;

}