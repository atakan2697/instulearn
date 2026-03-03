package stepdefinitions;

import io.cucumber.java.en.*;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import pages.MelahatnurPage;
import utilities.Driver;

public class MelahatnurStepdefinitions {

    MelahatnurPage melahatnurPage = new MelahatnurPage();
    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();


    @When("Body bolumunde Instructors basliginin gorunurlugu dogrulanir")
    public void body_bolumunde_ınstructors_basliginin_gorunurlugu_dogrulanir() {
        Assertions.assertTrue(melahatnurPage.instructorBasligi.isDisplayed());
    }


    @When("Instructors bölümüne scroll yapar")
    public void instructorsBölümüneScrollYapar() {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", melahatnurPage.allInstructorButonu);

    }

    @Then("All Instructor butonunun gorunurlugu ve tiklanabilirligi dogrulanir")
    public void allInstructorButonununGorunurluguVeTiklanabilirligiDogrulanir() {

        Assertions.assertTrue(melahatnurPage.allInstructorButonu.isDisplayed());
        Assertions.assertTrue(melahatnurPage.allInstructorButonu.isEnabled());
    }

    @When("Instructor slider alanının görünür olduğunu doğrular")
    public void instructorSliderAlanınınGörünürOlduğunuDoğrular() {

        Assertions.assertTrue(melahatnurPage.instructorSliderArea.isDisplayed(), "Slider alanı görünmüyor!");
    }

    @Then("Slider noktalarını kullanarak kart geçişi yapar")
    public void sliderNoktalarınıKullanarakKartGeçişiYapar() {
        js.executeScript("arguments[0].click();", melahatnurPage.sliderNoktasi.get(1));
    }

    @And("Kartların değiştiği doğrulanır")
    public void kartlarınDeğiştiğiDoğrulanır() {
        String classDegeri = melahatnurPage.sliderNoktasi.get(1).getAttribute("class");
        Assertions.assertTrue(classDegeri.contains("active"), "Slider noktaya tıklanmasına rağmen kaymadı!");
    }


    @Then("Instructor isminin görünür olduğu doğrulanır")
    public void instructorIsmininGörünürOlduğuDoğrulanır() {

        String isim = melahatnurPage.instructorIsimleri.get(0).getText();
        Assertions.assertFalse(isim.isEmpty());
    }

    @Then("Beğeni puanının görüntülendiği doğrulanır")
    public void beğeniPuanınınGörüntülendiğiDoğrulanır() {
        Assertions.assertTrue(!melahatnurPage.instructorPuanlari.isEmpty());
    }

    @And("{string} butonunun görünür ve aktif olduğu doğrulanır")
    public void butonununGörünürVeAktifOlduğuDoğrulanır(String butonMetni) {

            Assertions.assertFalse(melahatnurPage.reserveButonu.isEmpty(), "Buton DOM'da bulunamadı!");

            WebElement buton = melahatnurPage.reserveButonu.get(0);


            JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
            js.executeScript("arguments[0].scrollIntoView({block: 'center'});", buton);

            boolean isExist = buton.getSize().getWidth() > 0 && buton.getSize().getHeight() > 0;

            Assertions.assertTrue(isExist);
        }
        }








    

        




