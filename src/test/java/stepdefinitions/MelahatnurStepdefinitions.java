package stepdefinitions;

import io.cucumber.java.en.*;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import pages.MelahatnurPage;
import utilities.ConfigReader;
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





        // ================================== US031====================================//

    @Given("kullanici login butonuna basar ve admin olarak giris yapar")
    public void kullanici_login_butonuna_basar_ve_admin_olarak_giris_yapar() {
        melahatnurPage.logineGidisButonu.click();
        melahatnurPage.loginEmailButonu.sendKeys("melahatnur.admin@instulearn.com");

        melahatnurPage.loginSifreButonu.sendKeys(ConfigReader.getProperty("gecerliPassword"));
        melahatnurPage.loginButonu.click();

    }
    @When("slider alanini kontrol eder ve settings linkinin gorunur oldugunu kontrol eder")
    public void slider_alanini_kontrol_eder_ve_settings_linkinin_gorunur_oldugunu_kontrol_eder() {

        Assertions.assertTrue(melahatnurPage.settingsLinki.isDisplayed());

    }
    @Then("Settings linkinin tiklanabilirligini kontrol eder")
    public void settings_linkinin_tiklanabilirligini_kontrol_eder() {

        Assertions.assertTrue(melahatnurPage.settingsLinki.isEnabled());
    }

    @When("kullanici settings sayfasinda olur")
    public void kullanici_settings_sayfasinda_olur() {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].click();", melahatnurPage.settingsLinki);
    melahatnurPage.settingsLinki.click();
    }
    @When("basic information sayfasinda zorunlu alanlari gecerli verilerle doldurur")
    public void basic_information_sayfasinda_zorunlu_alanlari_gecerli_verilerle_doldurur() {

        melahatnurPage.basicInformationEmail.sendKeys("melahatnur.admin@instulearn.com");

        melahatnurPage.basicInformationName.sendKeys("Melahatnur");
        melahatnurPage.basicInformationPassword.sendKeys("gecerliPassword");
        melahatnurPage.basicInformationPasswordTekrari.sendKeys("gecerliPassword");
        melahatnurPage.basicInformationTelefonNumber.sendKeys("0544 765 78 90");


        Select langSelect = new Select(melahatnurPage.basicInformationLanguange);
        langSelect.selectByVisibleText("English");

        Select timeSelect = new Select(melahatnurPage.basicInformationTimeZone);
        timeSelect.selectByValue("UTC");

        melahatnurPage.basicInformationJoinEmail.click();
        melahatnurPage.basicInformationEnableProfil.click();

    }
    @When("kaydedip ilerler")
    public void kaydedip_ilerler() {
        melahatnurPage.saveButonu.click();
        melahatnurPage.nextButonu.click();

    }


    @When("basic information sayfasinda zorunlu alanlardan birini bos birakir")
    public void basicInformationSayfasindaZorunluAlanlardanBiriniBosBirakir() {
        melahatnurPage.basicInformationEmail.sendKeys("melahatnur.admin@instulearn.com");
        melahatnurPage.basicInformationName.sendKeys("Melahatnur");
        melahatnurPage.basicInformationTelefonNumber.sendKeys("0544 765 78 90");


        Select langSelect = new Select(melahatnurPage.basicInformationLanguange);
        langSelect.selectByVisibleText("English");

        Select timeSelect = new Select(melahatnurPage.basicInformationTimeZone);
        timeSelect.selectByValue("UTC");

        melahatnurPage.basicInformationJoinEmail.click();
        melahatnurPage.basicInformationEnableProfil.click();
    }
}








    

        




