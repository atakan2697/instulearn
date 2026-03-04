package stepdefinitions;


import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utilities.Driver;

public class Hooks {
    /*
        Cucumber'da @After... ve @Before... notasyonlarini kullanirken dikkatli olmaliyiz

        JUnit framework de @After... ve @Before... notasyonlarina sahip method'lari
        TestBase class'ina koyup,
        calismasini istedigimiz test class'larini extends ile TestBase'e child yapiyorduk
        boylece istedigimiz test class'inda TestBase'deki method'lar calisyordu,
        calismasini istemediklerimizi extends yapmadigimiz icin
        TestBase'deki method'lar calismiyordu

        Cucumber'da secim sansimiz yok
        eger stepdefinitions package'i icinde
        bir @After... ve @Before... method'u varsa
        tum scenario'lar icin calisir

        ONEMLI : @After cucumber'dan import edilmelidir
                JUnit'den import edilirse cekilen screenshot rapora eklenmez
                bagimsiz bir dosya olarak gorunur
     */

    @After
    public void tearDown(Scenario scenario) {
        WebDriver driver = Driver.getDriver();


        try {
            if (driver != null && scenario.isFailed()) {
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", "screenshot");
            }
        } catch (Exception ignored) {
            // screenshot yüzünden test düşmesin
        } finally {
            try { Driver.quitDriver(); } catch (Exception ignored) {}
        }
    }
}