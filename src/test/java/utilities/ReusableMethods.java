package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ReusableMethods {

    public static void bekle(int saniye){

        try {
            Thread.sleep(saniye*1000);
        } catch (InterruptedException e) {
            System.out.println("Thread.sleep komutu calismadi");
        }
    }

    public static void titleIleWindowGecisYap(WebDriver driver,String hedehWindowTitle){
        //1- acik olan tüm windowlarin Whd'lerini alip kaydedelim

        Set<String> acikWindowlarinWhdleri= driver.getWindowHandles();

        for ( String eachWhd:acikWindowlarinWhdleri){

            driver.switchTo().window(eachWhd);
            //gectiğimiz window'un title'ini alip
            //geçmek istediğimiz window'un title'ina eşit mi diye kontrol edelim

            if (driver.getTitle().equals(hedehWindowTitle)){
                //dogru window'dayiz demektir, burada kalabiliriz
                break;
            }
        }
    }

    public static void urlIleWındowGecisYap(WebDriver driver, String hedefUrl){

        //1.adım açık tüm window'larin whd'lerini alıp kaydedelim

        Set<String> acikTumWindowsWhdSeti= driver.getWindowHandles();

        for (String eachWhd:acikTumWindowsWhdSeti){
            driver.switchTo().window(eachWhd);

            if (driver.getCurrentUrl().equals(hedefUrl)){
                break;
            }
        }
    }

    public static List<String> stringListeDondur(List<WebElement> webElementListesi){
        List<String> stringList = new ArrayList<>();
        for ( WebElement eachElement : webElementListesi){
            stringList.add( eachElement.getText() );
        }
        return stringList;
    }

    public static void tumSayfaResimCek(WebDriver driver){
        //1.adım tss objesi olusturalım
        TakesScreenshot takesScreenshot= (TakesScreenshot) driver;

        //2.adım resmi kaydedeceğimiz File'ı olusturalım

        String dosyaYolu= "target/screenshots/tumSayfaResmi.jpeg";
        File tumSayfaResmi= new File(dosyaYolu);


        //3.adım screenshot'ı alıp gecici bir dosya olarak kaydedelim
        File geciciDosya= takesScreenshot.getScreenshotAs(OutputType.FILE);

        //4.adım gecici dosyayı asıl dosyaya kopyalayalım
        try {
            FileUtils.copyFile(geciciDosya,tumSayfaResmi);
        } catch (IOException e) {
            System.out.println("Resim cekilemedi");
        }
    }

    public static void tumSayfaResimCek(WebDriver driver, String raporIsmi){
        //1.adım tss objesi olusturalım
        TakesScreenshot takesScreenshot= (TakesScreenshot) driver;

        //2.adım resmi kaydedeceğimiz File'ı olusturalım

        String dosyaYolu= "target/screenshots/" + raporIsmi + ".jpeg";
        File tumSayfaResmi= new File(dosyaYolu);


        //3.adım screenshot'ı alıp gecici bir dosya olarak kaydedelim
        File geciciDosya= takesScreenshot.getScreenshotAs(OutputType.FILE);

        //4.adım gecici dosyayı asıl dosyaya kopyalayalım
        try {
            FileUtils.copyFile(geciciDosya,tumSayfaResmi);
        } catch (IOException e) {
            System.out.println("Resim cekilemedi");
        }
    }

    public static void tarihliTumSayfaResimCek(WebDriver driver){

        LocalDateTime localDateTime=LocalDateTime.now();
        DateTimeFormatter format= DateTimeFormatter.ofPattern("_yyMMdd_HHmmss");
        String tarihEtiketi= localDateTime.format(format);

        //1.adım tss objesi olusturalım
        TakesScreenshot takesScreenshot= (TakesScreenshot) driver;

        //2.adım resmi kaydedeceğimiz File'ı olusturalım

        String dosyaYolu= "target/screenshots/tumSayfaResmi"+tarihEtiketi+".jpeg";
        File tumSayfaResmi= new File(dosyaYolu);


        //3.adım screenshot'ı alıp gecici bir dosya olarak kaydedelim
        File geciciDosya= takesScreenshot.getScreenshotAs(OutputType.FILE);

        //4.adım gecici dosyayı asıl dosyaya kopyalayalım
        try {
            FileUtils.copyFile(geciciDosya,tumSayfaResmi);
        } catch (IOException e) {
            System.out.println("Resim cekilemedi");
        }
    }

    public static void tarihliTumSayfaResimCek(WebDriver driver, String raporIsmi){
        LocalDateTime localDateTime=LocalDateTime.now();
        DateTimeFormatter format= DateTimeFormatter.ofPattern("_yyMMdd_HHmmss");
        String tarihEtiketi= localDateTime.format(format);

        //1.adım tss objesi olusturalım
        TakesScreenshot takesScreenshot= (TakesScreenshot) driver;

        //2.adım resmi kaydedeceğimiz File'ı olusturalım

        String dosyaYolu= "target/screenshots/" + raporIsmi+tarihEtiketi+".jpeg";
        File tumSayfaResmi= new File(dosyaYolu);


        //3.adım screenshot'ı alıp gecici bir dosya olarak kaydedelim
        File geciciDosya= takesScreenshot.getScreenshotAs(OutputType.FILE);

        //4.adım gecici dosyayı asıl dosyaya kopyalayalım
        try {
            FileUtils.copyFile(geciciDosya,tumSayfaResmi);
        } catch (IOException e) {
            System.out.println("Resim cekilemedi");
        }
    }

    public static void webElementResimCek(WebElement webElement){
        //1.adım screenshot alacağımız webelementi locate edip kaydedelim
        //       biz parametre olarak gönderiyoruz

        //2.adım resmi kaydedeceğimiz File'ı olusturalım
        String dosyaYolu= "target/screenshots/webElementResmi.jpeg";
        File webElementResim= new File(dosyaYolu);

        //3.adım webElement'i kullanarak screenshot'ı alıp gecici bir dosya olarak kaydedelim
        File geciciDosya=webElement.getScreenshotAs(OutputType.FILE);

        //4.adım gecici dosyayı asıl dosyaya kopyalayalım
        try {
            FileUtils.copyFile(geciciDosya,webElementResim);
        } catch (IOException e) {
            System.out.println("Webelement resmi cekilemedi");
        }
    }

    public static void webElementResimCek(WebElement webElement,String raporIsmi){
        //1.adım screenshot alacağımız webelementi locate edip kaydedelim
        //       biz parametre olarak gönderiyoruz

        //2.adım resmi kaydedeceğimiz File'ı olusturalım
        String dosyaYolu= "target/screenshots/"+ raporIsmi+".jpeg";
        File webElementResim= new File(dosyaYolu);

        //3.adım webElement'i kullanarak screenshot'ı alıp gecici bir dosya olarak kaydedelim
        File geciciDosya=webElement.getScreenshotAs(OutputType.FILE);

        //4.adım gecici dosyayı asıl dosyaya kopyalayalım
        try {
            FileUtils.copyFile(geciciDosya,webElementResim);
        } catch (IOException e) {
            System.out.println("Webelement resmi cekilemedi");
        }
    }

    public static void tarihliWebElementResimCek(WebElement webElement){

        LocalDateTime localDateTime=LocalDateTime.now();
        DateTimeFormatter format= DateTimeFormatter.ofPattern("_yyMMdd_HHmmss");
        String tarihEtiketi= localDateTime.format(format);

        //1.adım screenshot alacağımız webelementi locate edip kaydedelim
        //       biz parametre olarak gönderiyoruz

        //2.adım resmi kaydedeceğimiz File'ı olusturalım
        String dosyaYolu= "target/screenshots/webElementResmi"+tarihEtiketi+".jpeg";
        File webElementResim= new File(dosyaYolu);

        //3.adım webElement'i kullanarak screenshot'ı alıp gecici bir dosya olarak kaydedelim
        File geciciDosya=webElement.getScreenshotAs(OutputType.FILE);

        //4.adım gecici dosyayı asıl dosyaya kopyalayalım
        try {
            FileUtils.copyFile(geciciDosya,webElementResim);
        } catch (IOException e) {
            System.out.println("Webelement resmi cekilemedi");
        }
    }

    public static void tarihliWebElementResimCek(WebElement webElement,String raporIsmi){

        LocalDateTime localDateTime=LocalDateTime.now();
        DateTimeFormatter format= DateTimeFormatter.ofPattern("_yyMMdd_HHmmss");
        String tarihEtiketi= localDateTime.format(format);

        //1.adım screenshot alacağımız webelementi locate edip kaydedelim
        //       biz parametre olarak gönderiyoruz

        //2.adım resmi kaydedeceğimiz File'ı olusturalım
        String dosyaYolu= "target/screenshots/"+ raporIsmi+tarihEtiketi+".jpeg";
        File webElementResim= new File(dosyaYolu);

        //3.adım webElement'i kullanarak screenshot'ı alıp gecici bir dosya olarak kaydedelim
        File geciciDosya=webElement.getScreenshotAs(OutputType.FILE);

        //4.adım gecici dosyayı asıl dosyaya kopyalayalım
        try {
            FileUtils.copyFile(geciciDosya,webElementResim);
        } catch (IOException e) {
            System.out.println("Webelement resmi cekilemedi");
        }
    }

    public static String raporaResimEkle(String testIsmi) throws IOException {

        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("_yyMMdd_HHmmss");
        String date = localDateTime.format(format); // _241219_080623

        // 1.adim tss objesi olusturalim
        //   ve takesScreenshot objesi ile gecici resmi kaydedelim
        TakesScreenshot takesScreenshot = (TakesScreenshot) Driver.getDriver();
        File geciciDosya = takesScreenshot.getScreenshotAs(OutputType.FILE);

        // Asil resmi kaydedecegimiz dosya yolunu olusturup
        // bu dosya yolu ile resmi kaydedecegimiz asil dosyayi olusturalim
        String dosyaYolu = System.getProperty("user.dir") + "/test-output/Screenshots/" + testIsmi + date + ".jpg";
        File asilResimDosyasi = new File(dosyaYolu);
        // gecici dosyayi asil dosyaya kopyalayalim
        FileUtils.copyFile(geciciDosya, asilResimDosyasi);
        return dosyaYolu;
    }

    public static void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
