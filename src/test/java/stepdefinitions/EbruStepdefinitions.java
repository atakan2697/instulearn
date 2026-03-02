
package stepdefinitions;

        import io.cucumber.java.en.Then;
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
}