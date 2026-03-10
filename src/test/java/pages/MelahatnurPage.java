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

    @FindBy(css = ".calendar-day:not(.disabled):not(.empty)")
    public List<WebElement> musaitGunler;

    @FindBy(css = ".alert-warning, .swal2-popup, div[class*='login-required'], div[class*='alert']")
    public WebElement loginUyarisi;

    // US012 - Randevu takvim elementleri
    @FindBy(xpath = "//div[@id='appointments']//span[translate(normalize-space(text()), '0123456789', '') = '' and string-length(normalize-space(text())) >= 1 and string-length(normalize-space(text())) <= 2]")
    public List<WebElement> takvimGunler;

    @FindBy(id = "availableTimes")
    public WebElement availableTimesDiv;

    @FindBy(xpath = "//div[@id='availableTimes']//label")
    public WebElement saatLabel;

    @FindBy(xpath = "//label[@for='meetingTypeOnline']")
    public WebElement meetingTypeOnlineLabel;

    @FindBy(xpath = "//button[contains(@class,'js-submit-form')]")
    public WebElement submitFormBtn;

    @FindBy(css = ".jq-toast-single")
    public WebElement toastMesaj;

    @FindBy(css = ".time-slot:not(.disabled), .meeting-time:not(.disabled)")
    public List<WebElement> musaitSaatler;

    @FindBy(xpath = "//button[contains(text(),'Book') or contains(text(),'Confirm') or contains(text(),'Reserve')]")
    public WebElement rezervasyonOnayla;

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

    @FindBy(xpath = "//h2[text()='Image is too small.']" )
    public WebElement hataMesaji;


    @FindBy(xpath = "//textarea[@name='about']")
    public WebElement biographyBox;

    @FindBy(xpath = "//textarea[@name='bio']")
    public WebElement jobTitleBox;

    @FindBy(xpath = "//button[text()='Add education']")
    public WebElement addEducation;

    @FindBy(xpath = "//button[text()='Add education']")
    public WebElement educationEklemeBox;

    @FindBy(xpath = "//button[@id='userAddExperiences']")
    public WebElement addExperience;

    @FindBy(xpath = "(//button[@id='saveExperience'])[2]")
    public WebElement experinceSaveButon;

    @FindBy(xpath = "(//input[@id='new_experience_val'])[2]")
    public WebElement newExperienceBox;

    @FindBy(xpath = "//div[@class='checkbox-button mr-15 mt-10']")
    public List<WebElement> skillsTopicler;

    @FindBy(xpath = "//option[text()='Select account type']")
    public WebElement selectAccountType;

   @FindBy(xpath = "//textarea[@name='zoom_api_key']")
   public WebElement zoomClientID;

   @FindBy(xpath = "//textarea[@name='zoom_api_secret']")
   public WebElement zoomClientSecret;

   @FindBy(xpath = "//textarea[@name='zoom_account_id']")
   public WebElement zoomAccountID;


   @FindBy(xpath = "//input[@name='meeting_type']")
   public List<WebElement> meetingType;

    @FindBy(xpath = "//input[@name='gender']")
    public List<WebElement> genders;

   @FindBy(xpath = "//input[@name='age']")
   public WebElement age;

   @FindBy(xpath = "//input[@name='level_of_training[]']")
   public List<WebElement> trainingLevel;

   @FindBy(xpath = "//select[@name='country_id']")
   public List<WebElement> countries;

    @FindBy(xpath = "//select[@name='province_id']")
    public List<WebElement> provinces;

    @FindBy(xpath = "//select[@name='city_id']")
    public List<WebElement> cities;

    @FindBy(xpath = "//select[@name='district_id']")
    public List<WebElement> district;

    @FindBy(xpath = "//input[@name='address']")
    public WebElement adress;

    // US031 - Education modal elementleri
    @FindBy(id = "userAddEducations")
    public WebElement addEducationBtn;

    @FindBy(id = "newEducationSwlModal")
    public WebElement newEducationModal;

    @FindBy(id = "new_education_val")
    public WebElement newEducationInput;

    @FindBy(xpath = "//div[@id='newEducationSwlModal']//button[normalize-space()='Save']")
    public WebElement educationModalSaveBtn;

    @FindBy(xpath = "//div[@id='newEducationSwlModal']//button[contains(@class,'swal2-confirm')]")
    public WebElement educationModalConfirmBtn;

    @FindBy(xpath = "//a[@class='delete-action btn btn-sm btn-danger']")
    public WebElement deleteAccount;

    @FindBy(xpath = "//button[@id='swlDelete']")
    public WebElement yesIconfirm;



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
