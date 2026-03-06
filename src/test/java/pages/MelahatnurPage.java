package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.security.cert.X509Certificate;
import java.util.List;
import java.util.logging.XMLFormatter;

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


    @FindBy(xpath = "//div[@data-navigator]")
    public WebElement takvim;

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

    @FindBy(xpath = "//span[text()='English']")
    public WebElement basicInformationLanguange;

    @FindBy(xpath = "//span[contains(text(),'UTC')]")
    public WebElement basicInformationTimeZone;

    @FindBy(xpath = "//button[text()='Save']")
    public WebElement saveButonu;

    @FindBy(xpath = "//button[text()='Next']")
    public WebElement nextButonu;

    @FindBy(xpath = "//label[text()='Join email newsletter']")
    public WebElement basicInformationJoinEmail;

    @FindBy(xpath = "//label[text()='Enable profile messages']")
    public WebElement basicInformationEnableProfil;



    @FindBy(name = "language")
    public WebElement languageDropdown;


    @FindBy(css = ".select2-selection--single")
    public WebElement timeZoneKutusu;


    @FindBy(css = ".select2-results__option")
    public List<WebElement> timeZoneSecenekleri;

    @FindBy(xpath = "//div[@class='invalid-feedback']")
    public WebElement feedback;

    @FindBy(xpath = "//input[@type='file']")
    public WebElement profileImageInput;

    // Page Class içinde:
    @FindBy(xpath = "//textarea[@name='about']")
    public WebElement biographyBox;

    @FindBy(xpath = "//textarea[@name='bio']")
    public WebElement jobTitleBox;



    @FindBy(xpath = "//a[text()='Blog']")
    public WebElement anasayfaBlogLinki;

    @FindBy(xpath = "//h1[text()='Blog']")
    public WebElement blogSayfasindakiBlogYazisi;

    @FindBy(xpath = "//input[@class='form-control border-0']")
    public WebElement blogSayfasindakiSearchTextBox;

    @FindBy(xpath = "//button[text()='Search']")
    public WebElement blogSayfasindakiSearchButonu;

    @FindBy(xpath = "//a[text()='Sports']")
    public WebElement blogSayfasindakiRastgeleKategori;

    @FindBy(css = ".blog-post-item")
    public List<WebElement> blogPosts;

    @FindBy(xpath = "//a [@href='/blog/categories/blog']")
    public WebElement kategoriBlogButonu;

    @FindBy(xpath = "//a[@href='/blog/general-chemistry-free-course-2']")
    public WebElement bloglardanHerhangiBiri;

    @FindBy(xpath = "//span[@class='course-count-badge py-5 px-10 text-white rounded']")
    public WebElement blogListeleme;

    @FindBy(xpath = "//textarea[@name='comment']")
    public WebElement commentAlani;

    @FindBy(xpath = "//button[text()='Post comment']")
    public WebElement postCommentButonu;

    @FindBy(xpath = " //a[@class='text-white text-decoration-underline']")
    public WebElement blogPaylasan;

    @FindBy(xpath = "//span[text()='13 Feb 2026']")
    public WebElement blogPaylasildigiTarih;

    @FindBy(xpath = "//*[@id='app']/section[2]/div/div[1]/div[1]")
    public WebElement blogPaylasildigiIcerik;

    @FindBy(xpath = "//h1[@class='font-30 text-white font-weight-bold']")
    public WebElement blogPaylasildigiKonu;




}
