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

    // MelahatnurPage.java
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

}
