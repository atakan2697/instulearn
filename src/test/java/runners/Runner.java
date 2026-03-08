package runners;

import io.cucumber.junit.platform.engine.Constants;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("src/test/java")
@ConfigurationParameter(key = Constants.FEATURES_PROPERTY_NAME,value = "src/test/resources/features")
@ConfigurationParameter(key = Constants.GLUE_PROPERTY_NAME,value = "stepdefinitions")
@ConfigurationParameter(key = Constants.FILTER_TAGS_PROPERTY_NAME,value = "@E2E")
@ConfigurationParameter(key = Constants.EXECUTION_DRY_RUN_PROPERTY_NAME,value = "false")

//@ConfigurationParameter(key = Constants.PLUGIN_PROPERTY_NAME,value = "pretty, html:target/cucumber-report/HtmlReport.html")
//@ConfigurationParameter(key = Constants.PLUGIN_PROPERTY_NAME,value = "pretty, json:target/json-reports/cucumberRapor.json")
//@ConfigurationParameter(key = Constants.PLUGIN_PROPERTY_NAME,value = "pretty, junit:target/xml-report/cucumber.xml")

public class Runner {
    /*
        Runner class'i BOS bir class'dir

        Amaci;
         - istenen feature dosyalari veya Scenario'lari calistirmak
         - feature dosyalari ile bunlari calistirmak icin ihtiyacimiz olan
           stepdefinition'lar arasinda baglanti kurmak
         - kullanisli raporlar olusturmak
         - ve test calistirma configurasyonunda ihtiyacimiz olan
           ayarlari yapmaktir

        Kendisi bos olan bir class olan Runner,
        bu kadar gorevi
        Notasyonlar sayesinde gerceklestirir

     */

    /*
    @Suite
    @IncludeEngines("cucumber")
    // JUnit'in bu dosyayi Cucumber ile calistirmasini saglar

    @SelectClasspathResource("src/test/java")
    // Testlerin calismasi icin ihtiyac duyulan Java dosyalarinin yerini gosterir
    // projede java dosyalari neredeyse 13.satira o dosya yolunu girmeliyiz
    @ConfigurationParameter(key = Constants.FEATURES_PROPERTY_NAME,value = "src/test/resources/features")
    // feature dosyalarinin bulundugu dosya yolunu gosterir
    @ConfigurationParameter(key = Constants.GLUE_PROPERTY_NAME,value = "stepdefinitions")
    // feature dosyalarina ait stepdefinition'larin bulundugu package'i tanimlar

    @ConfigurationParameter(key = Constants.FILTER_TAGS_PROPERTY_NAME,value = "@smoke")
    // bir secim yapmazsak, Runner features klasoru altindaki TUM feature dosyalarini calistirir
    // secim yapmak icin 2 alternatif var
    // 1- calisacak feature dosyalarini bir klasor altina toplayip, dosya yolu olarak o klasoru gostermek
    // 2- calisacak feature veya scenario'lari tag'larla belirlemek (daha cok bu kullanilir)

    @ConfigurationParameter(key = Constants.EXECUTION_DRY_RUN_PROPERTY_NAME,value = "false")

    //    value = false oldugunda, Runner class'i normal calisir
    //    eger value = true secilirse Runner sadece eksik adimlari bulmak icin calisir
    //    herhangi bir test yapmaz
    //    eksik adim varsa, onlar icin ihtiyac duyulan method'lari olusturur
    //    eksik adim yoksa test passed der (eksik adim yok anlamina gelir)


        @ConfigurationParameter(key = Constants.PLUGIN_PROPERTY_NAME,value = "pretty, html:target/cucumber-report/HtmlReport.html")
    //@ConfigurationParameter(key = Constants.PLUGIN_PROPERTY_NAME,value = "pretty, json:target/json-reports/cucumberRapor.json")
    //@ConfigurationParameter(key = Constants.PLUGIN_PROPERTY_NAME,value = "pretty, junit:target/xml-report/cucumber.xml")
     */
}