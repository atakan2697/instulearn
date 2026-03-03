
package stepdefinitions;

        import io.cucumber.java.en.Then;
        import io.cucumber.java.en.When;
        import org.junit.jupiter.api.Assertions;
        import pages.EbruPage;
        import utilities.Driver;

public class EbruStepdefinitions {

    EbruPage ebruPage = new EbruPage();

    @Then("instulearn logosunun gorunur oldugunu dogrular")
    public void instulearn_logosunun_gorunur_oldugunu_dogrular() {

        Assertions.assertTrue(ebruPage.instulearnLogo.isDisplayed());

    }

    @Then("sayfa title degerinin {string} oldugunu dogrular")
    public void sayfa_title_degerinin_oldugunu_dogrular(String expectedTitle) {

        String actualTitle = Driver.getDriver().getTitle();

        Assertions.assertEquals(expectedTitle, actualTitle);

    }

    @When("kullanici gecersiz url'e gider")
    public void kullanici_gecersiz_urle_gider() {

        Driver.getDriver().get("https://qa.instulearn.com/invalid");

    }

    @Then("ana sayfa goruntulenmemelidir")
    public void ana_sayfa_goruntulenmemelidir() {

        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assertions.assertFalse(actualUrl.equals("https://qa.instulearn.com/"));
    }

    @Then("hata sayfasi goruntulenmelidir")
    public void hata_sayfasi_goruntulenmelidir() {

        String actualTitle = Driver.getDriver().getTitle();

        Assertions.assertTrue(
                actualTitle.contains("404")
                        || actualTitle.toLowerCase().contains("not found")
        );
    }

    @Then("sayfa title degeri {string} olmamalidir")
    public void sayfa_title_degeri_olmamalidir(String forbiddenTitle) {

        String actualTitle = Driver.getDriver().getTitle();
        Assertions.assertNotEquals(forbiddenTitle, actualTitle);
    }



}