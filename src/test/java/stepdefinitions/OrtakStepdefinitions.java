package stepdefinitions;

import io.cucumber.java.en.*;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class OrtakStepdefinitions {


    @Given("kullanici {string} anasayfaya gider")
    public void kullanici_anasayfaya_gider(String url) {

        Driver.getDriver().get(ConfigReader.getProperty(url));
    }

    @Given("kullanici {int} saniye bekler")
    public void kullanici_saniye_bekler(Integer saniye) {

        ReusableMethods.bekle(saniye);
    }

}
