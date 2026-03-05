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

    // Login sayfasindaki "Forgot your password?" linki
    @FindBy(xpath = "//a[@href='/forget-password']")
    public WebElement forgotYourPasswordLink;

    // Alternatif: href icinde forgot/recover/reset gecen link
    @FindBy(xpath = "//a[contains(@href,'forgot') or contains(@href,'recover') or contains(@href,'reset')]")
    public WebElement forgotLinkByHref;

    @FindBy(xpath = "//h1|//h2")
    public WebElement pageHeader;

    // Password Recovery page - Email textbox
    @FindBy(xpath = "//input[@type='email' or contains(@name,'email') or contains(@id,'email') or contains(@placeholder,'mail') or contains(@placeholder,'Email')]")
    public WebElement emailTextbox;

    // Password Recovery page - Reset Password button
    @FindBy(xpath = "//button[contains(.,'Reset') and contains(.,'Password')] | //button[@type='submit']")
    public WebElement resetPasswordButton;

    // Success / info message (toast/alert/text) - genel locator
    @FindBy(xpath = "//*[contains(@class,'alert') or contains(@class,'toast') or contains(@role,'alert') or contains(@class,'notification')]" +
            "[contains(translate(.,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'email') " +
            "or contains(translate(.,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'sent') " +
            "or contains(translate(.,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'success') " +
            "or contains(translate(.,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'reset')]")
    public WebElement resetSuccessMessage;

    @FindBy(xpath = "//a[contains(@href,'login') or contains(text(),'Login')]")
    public WebElement backToLoginLink;



}