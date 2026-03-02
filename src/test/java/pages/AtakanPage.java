package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class AtakanPage {

    public AtakanPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[text()='Login']")
    public WebElement loginLinki;

    @FindBy(xpath = "(//img[@class='img-cover'])[2]")
    public WebElement solTaraftakiImg;

    @FindBy(xpath = "//*[text()='Log in to your account']")
    public WebElement logInToYourAccount;

    @FindBy(xpath = "//input[@id='email']")
    public WebElement email;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement password;

    @FindBy(xpath = "(//*[text()='Login'])[2]")
    public WebElement loginSayfasındakiLoginButonu;

    @FindBy(xpath = "//*[text()='Forgot your password?']")
    public WebElement forgotYourPassword;

    @FindBy(xpath = "(//*[text()='Login'])[2]")
    public WebElement forgotSayfasindakiLoginButonu;

    @FindBy(xpath = "//div[@class='invalid-feedback']")
    public WebElement emailAlanindakiHataMesaji;

    @FindBy(id = "filterLanguagecourse")
    public WebElement filtrelemeCourse;

    @FindBy(xpath = "//*[text()='Type']")
    public WebElement typeTexti;

    @FindBy(xpath = "//*[text()='Filter items']")
    public WebElement filterItems;

    @FindBy(xpath = "(//*[text()='Courses'])[1]")
    public WebElement coursesLinki;

    @FindBy(xpath = "text-white font-30 mb-15")
    public WebElement coursesTexti;

    @FindBy(xpath = "//*[text()='Search']")
    public WebElement searchButonu;

    @FindBy(xpath = "//*[@class='form-control border-0']")
    public WebElement searchTexti;

    @FindBy(xpath = "(//*[@class='mb-0 mr-10 cursor-pointer'])[4]")
    public WebElement downloadSecenegi;

    @FindBy (xpath = "//div[@class='image-box']")
    public List<WebElement> kursKartlariList;

    @FindBy(xpath = "//div[@class='webinar-price-box mt-25']")
    public List<WebElement> kursKartlariFiyat;

    @FindBy(xpath = "//span[@class='date-published font-14 ml-5']")
    public List<WebElement> kursKartlariTarih;

    @FindBy(xpath = "//span[@class='d-block font-14 mt-10']")
    public List<WebElement> kursKartlariDersAdi;

    @FindBy(xpath = "//h3[@class='mt-15 webinar-title font-weight-bold font-16 text-dark-blue']")
    public List<WebElement> kursKartlariInstructorBilgileri;

    @FindBy(xpath = "//button[@class='btn btn-primary js-course-add-to-cart-btn']")
    public WebElement addToCardButonu;

    @FindBy(xpath = "//button[@class='btn btn-outline-danger mt-20 js-course-direct-payment']")
    public WebElement buyNowButonu;




}
