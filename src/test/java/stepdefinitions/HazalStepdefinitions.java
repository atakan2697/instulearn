package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.*;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.HazalPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.security.Key;

public class HazalStepdefinitions {

    HazalPage hazalPage=new HazalPage();

    // ******************************  US_010 --> TC_01 *********************************

    @Then("Home  Join as Instructor basligi ve linkinin gorunur oldugu dogrulanir")
    public void home_join_as_ınstructor_basligi_ve_linkinin_gorunur_oldugu_dogrulanir() {
        JavascriptExecutor jse=(JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].scrollIntoView(true);",hazalPage.homeJoinAsInstructorBasligiLink);

        Assertions.assertTrue(hazalPage.homeJoinAsInstructorBasligiLink.isDisplayed());

    }


    @Then("linkin tiklanabilir oldugu dogrulanir")
    public void linkin_tiklanabilir_oldugu_dogrulanir() {

        Assertions.assertTrue(hazalPage.homeJoinAsInstructorBasligiLink.isEnabled());

    }


    @When("kullanici Join as Instructor linkine tiklar")
    public void kullanici_join_as_ınstructor_linkine_tiklar() {

        hazalPage.homeJoinAsInstructorBasligiLink.click();

    }


    @Then("login sayfasina yonlendirildigi dogrulanir")
    public void login_sayfasina_yonlendirildigi_dogrulanir() {

        Assertions.assertTrue(hazalPage.loginPageEmailBox.isDisplayed());

    }

    // ********************* US_029 --> TC_01 **********************************


    @Given("kullanici login butonuna basar ve instructor olarak giris yapar")
    public void kullanici_login_butonuna_basar_ve_instructor_olarak_giris_yapar() {

        hazalPage.homePageLoginButton.click();

        hazalPage.loginPageEmailBox.sendKeys("hazal.admin@instulearn.com");
        hazalPage.loginPagePasswordBox.sendKeys(ConfigReader.getProperty("gecerliPassword"));
        hazalPage.loginPageLoginButton.click();

    }


    @When("kullanici Marketing menusunu expand eder")
    public void kullanici_marketing_menusunu_expand_eder() {

        JavascriptExecutor jse=(JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].scrollIntoView(true);",hazalPage.dashboardMarketing);

        hazalPage.dashboardMarketing.click();

    }


    @Then("Discounts linkinin gorunur ve tiklanabilir oldugu dogrulanir")
    public void discounts_linkinin_gorunur_ve_tiklanabilir_oldugu_dogrulanir() {

        Assertions.assertTrue(hazalPage.dashboardMarketingDiscounts.isEnabled());

    }


    @Then("Promotions linkinin gorunur ve tiklanabilir oldugu dogrulanir")
    public void promotions_linkinin_gorunur_ve_tiklanabilir_oldugu_dogrulanir() {

        Assertions.assertTrue(hazalPage.dashboardMarketingPromotions.isEnabled());

    }


    // *********************** US_029-->TC_02 ************************************


    @When("kullanici Marketing menusunden Discounts linkine tiklar")
    public void kullanici_marketing_menusunden_discounts_linkine_tiklar() {

        JavascriptExecutor jse=(JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].scrollIntoView(true);",hazalPage.dashboardMarketing);

        hazalPage.dashboardMarketing.click();
        hazalPage.dashboardMarketingDiscounts.click();

    }


    @Then("indirim olusturma alaninin gorunur oldugu dogrulanir")
    public void indirim_olusturma_alaninin_gorunur_oldugu_dogrulanir() {

        Assertions.assertTrue(hazalPage.discountsPageBasliklar.get(0).isDisplayed());

    }


    @When("kullanici indirim icin gerekli bilgileri girer")
    public void kullanici_indirim_icin_gerekli_bilgileri_girer() {

        hazalPage.discountsPageTitle.sendKeys("Selenium");

        Select selectCourse=new Select(hazalPage.discountsCourseSelectMenu);

        selectCourse.selectByValue("3672");

        hazalPage.discountsPageAmount.sendKeys("5");


        hazalPage.discountsPageFrom.sendKeys("2026-03-04 00:00");
        hazalPage.discountsPageTo.sendKeys("2026-03-10 00:00");

    }


    @When("Create butonuna tiklar")
    public void create_butonuna_tiklar() {

        hazalPage.discountsPageCreateButton.click();


    }


    @Then("indirimin basariyla olusturuldugu ve Discounts listesinde goruntulendigi dogrulanir")
    public void indirimin_basariyla_olusturuldugu_ve_discounts_listesinde_goruntulendigi_dogrulanir() {

        String expectedStatus="Active";
        String actualStatus=hazalPage.discountsPageStatus.getText();

        Assertions.assertEquals(expectedStatus,actualStatus);

        Assertions.assertTrue(hazalPage.discountsPageTable.isDisplayed());

    }


    //************************ US_029-->TC_03 ****************************************


    @When("Promotions linkine tiklar")
    public void promotions_linkine_tiklar() {

        JavascriptExecutor jse=(JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].scrollIntoView(true);",hazalPage.dashboardMarketing);

        hazalPage.dashboardMarketing.click();
        hazalPage.dashboardMarketingPromotions.click();

    }

    @Then("promosyon planlarinin listelendigi dogrulanir")
    public void promosyon_planlarinin_listelendigi_dogrulanir() {

        int promotionPlans=hazalPage.promotionsPagePlans.size();

        Assertions.assertTrue(promotionPlans>0);

    }

    @When("kullanici istedigi promosyon planinda Purchase butonuna tiklar")
    public void kullanici_istedigi_promosyon_planinda_purchase_butonuna_tiklar() {

        hazalPage.promotionsPagePurchaseButton.click();

        ReusableMethods.bekle(2);

        Select selectCourse=new Select(hazalPage.promotionsCourseSelectMenu);
        selectCourse.selectByValue("3672");
        hazalPage.promotionCoursePayButton.click();

    }

    @When("acilan sayfada odeme yontemini secer")
    public void acilan_sayfada_odeme_yontemini_secer() {

        hazalPage.stripePay.click();

        ReusableMethods.bekle(2);

        hazalPage.startPaymentButton.click();


    }

    @When("odeme bilgilerini doldurur")
    public void odeme_bilgilerini_doldurur() {

        hazalPage.paymentEmailBox.sendKeys("hazal.admin@instulearn.com");
        hazalPage.paymentCardNumber.sendKeys("4242424242424242");
        hazalPage.paymentCardDate.sendKeys("0728");
        hazalPage.paymentCardCvc.sendKeys("678");

        hazalPage.paymentCardholderName.sendKeys("wisequarter");

        Select selectCountry=new Select(hazalPage.paymentCountrySelectMenu);
        selectCountry.selectByValue("TR");

        ReusableMethods.bekle(3);

        Actions actions=new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        actions.sendKeys(Keys.PAGE_DOWN).perform();


    }


    @When("Pay butonuna tiklar")
    public void pay_butonuna_tiklar() {

        hazalPage.paymentPayButton.click();

    }


    @Then("odeme isleminin basarili oldugu dogrulanir")
    public void odeme_isleminin_basarili_oldugu_dogrulanir() {

        String expectedMessage="Congratulations!";
        String actualMessage=hazalPage.paymentThenMessage.getText();

        Assertions.assertEquals(expectedMessage,actualMessage);

    }


    @Then("secilen promosyon planinin aktif olarak goruntulendigi dogrulanir")
    public void secilen_promosyon_planinin_aktif_olarak_goruntulendigi_dogrulanir() {


        hazalPage.promotionsMyPanelButton.click();

        ReusableMethods.bekle(2);

        JavascriptExecutor jse=(JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].scrollIntoView(true);",hazalPage.dashboardMarketing);

        hazalPage.dashboardMarketing.click();
        hazalPage.dashboardMarketingPromotions.click();

        Actions actions=new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        Assertions.assertTrue(hazalPage.promotionsHistoryTable.isDisplayed());


    }


    // ****************************** US_027-->TC_01 ***************************************


    @When("kullanici dashboard sayfasindaki sidebar’da bulunan Financial menusunu goruntuler")
    public void kullanici_dashboard_sayfasindaki_sidebar_da_bulunan_financial_menusunu_goruntuler() {

        JavascriptExecutor jse=(JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].scrollIntoView(true);",hazalPage.dashboardFinancial);

    }


    @Then("Financial menusunun gorunur ve tiklanabilir oldugu dogrulanir")
    public void financial_menusunun_gorunur_ve_tiklanabilir_oldugu_dogrulanir() {

        Assertions.assertTrue(hazalPage.dashboardFinancial.isEnabled());
    }


    @When("kullanici Financial menusunu expand eder")
    public void kullanici_financial_menusunu_expand_eder() {

        JavascriptExecutor jse=(JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].scrollIntoView(true);",hazalPage.dashboardFinancial);

        hazalPage.dashboardFinancial.click();
    }


    @Then("Sales Report linkinin gorunur ve tiklanabilir oldugu dogrulanir")
    public void sales_report_linkinin_gorunur_ve_tiklanabilir_oldugu_dogrulanir() {

        Assertions.assertTrue(hazalPage.dashboardFinancialSalesReport.isEnabled());

    }


    @Then("Financial Summary linkinin gorunur ve tiklanabilir oldugu dogrulanir")
    public void financial_summary_linkinin_gorunur_ve_tiklanabilir_oldugu_dogrulanir() {

        Assertions.assertTrue(hazalPage.dashboardFinancialSummary.isEnabled());
    }


    @Then("Payout linkinin gorunur ve tiklanabilir oldugu dogrulanir")
    public void payout_linkinin_gorunur_ve_tiklanabilir_oldugu_dogrulanir() {

        Assertions.assertTrue(hazalPage.dashboardFinancialPayout.isEnabled());

    }


    @Then("Charge Account linkinin gorunur ve tiklanabilir oldugu dogrulanir")
    public void charge_account_linkinin_gorunur_ve_tiklanabilir_oldugu_dogrulanir() {

        Assertions.assertTrue(hazalPage.dashboardFinancialChargeAccount.isEnabled());

    }


    @Then("Subscribe linkinin gorunur ve tiklanabilir oldugu dogrulanir")
    public void subscribe_linkinin_gorunur_ve_tiklanabilir_oldugu_dogrulanir() {

        Assertions.assertTrue(hazalPage.dashboardFinancialSubscribe.isEnabled());

    }


    //********************************** US_027-->TC_02 *********************************************


    @When("kullanici Financial menuden Sales Report linkine tiklar")
    public void kullanici_financial_menuden_sales_report_linkine_tiklar() {

        JavascriptExecutor jse=(JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].scrollIntoView(true);",hazalPage.dashboardFinancial);

        hazalPage.dashboardFinancial.click();
        hazalPage.dashboardFinancialSalesReport.click();

    }


    @Then("Sales statistics alaninin gorunur oldugu dogrulanir")
    public void sales_statistics_alaninin_gorunur_oldugu_dogrulanir() {

        Assertions.assertTrue(hazalPage.dashboardFinancialSalesReportInformation.isDisplayed());
    }


    @Then("sales history listesinde satis kayitlarinin goruntulendigi dogrulanir")
    public void sales_history_listesinde_satis_kayitlarinin_goruntulendigi_dogrulanir() {

        Actions actions=new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        Assertions.assertTrue(hazalPage.dashboardFinancialSalesReportSalesHistoryTable.isDisplayed());


    }


    @When("kullanici filtre kriterlerini doldurur ve filtre ikonuna basar")
    public void kullanici_filtre_kriterlerini_doldurur_ve_filtre_ikonuna_basar() {

        Actions actions=new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_UP).perform();

        hazalPage.salesReportPageFrom.sendKeys("2026-02-25");
        hazalPage.salesReportPageTo.sendKeys("2026-02-27");

        hazalPage.salesReportPageLiveClassAll.click();
        hazalPage.salesReportPageLiveClassAllSearchbox.sendKeys("Test Automation"+Keys.ENTER);

        hazalPage.salesReportPageStudentAll.click();
        hazalPage.salesReportPageStudentAllSearchbox.sendKeys("Hazal"+Keys.ENTER);

        Select selectType=new Select(hazalPage.salesReportPageTypeSelectMenu);
        selectType.selectByValue("webinar");

        hazalPage.salesReportPageShowResultsButton.click();


    }


    @Then("sales history listesinin filtre sonucuna gore guncellendigi dogrulanir")
    public void sales_history_listesinin_filtre_sonucuna_gore_guncellendigi_dogrulanir() {

        Actions actions=new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        String expectedIsim="Hazal";
        String actualIsim=hazalPage.salesReportPageSalesHistoryTableStudentIsimElementi.getText();

        Assertions.assertEquals(expectedIsim,actualIsim);


    }


    @When("kullanici sales history’den bir kayit secer ve duzenleme islemi yapar")
    public void kullanici_sales_history_den_bir_kayit_secer_ve_duzenleme_islemi_yapar() {

        throw new io.cucumber.java.PendingException("Henüz implement edilmedi");

    }

    @When("degisiklikleri kaydeder")
    public void degisiklikleri_kaydeder() {
        WebElement saveBtn = Driver.getDriver().findElement(By.xpath("//button[text()='Save']"));
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView({block: 'center'});", saveBtn);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", saveBtn);
    }

    @Then("yapilan degisikligin kaydedildigi dogrulanir")
    public void yapilan_degisikligin_kaydedildigi_dogrulanir() {

        throw new io.cucumber.java.PendingException("Henüz implement edilmedi");

    }

    @When("kullanici sales history’den bir kayit secer ve silme islemi yapar")
    public void kullanici_sales_history_den_bir_kayit_secer_ve_silme_islemi_yapar() {

        throw new io.cucumber.java.PendingException("Henüz implement edilmedi");

    }

    @Then("kaydin listeden kaldirildigi dogrulanir")
    public void kaydin_listeden_kaldirildigi_dogrulanir() {

        throw new io.cucumber.java.PendingException("Henüz implement edilmedi");
    }


    //******************************* US_027-->TC_03 ************************************

    @When("kullanici Financial menuden Financial Summary linkine tiklar")
    public void kullanici_financial_menuden_financial_summary_linkine_tiklar() {

        JavascriptExecutor jse=(JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].scrollIntoView(true);",hazalPage.dashboardFinancial);

        hazalPage.dashboardFinancial.click();
        hazalPage.dashboardFinancialSummary.click();

    }


    @Then("financial documents listesinin gorunur oldugu dogrulanir")
    public void financial_documents_listesinin_gorunur_oldugu_dogrulanir() {

        Assertions.assertTrue(hazalPage.financialSummaryPageFinancialDocuments.isDisplayed());

    }


    @Then("tum finansal dokuman kayitlarinin listelendigini dogrulanir")
    public void tum_finansal_dokuman_kayitlarinin_listelendigini_dogrulanir() {

        Assertions.assertTrue(hazalPage.financialSummaryPageFinancialDocumentsTable.isDisplayed());

    }


    // ************************************ US_027-->TC_05 ******************************************

    int firstCuzdanBakiyesi;

    @When("kullanici Financial menuden Charge Account linkine tiklar ve cuzdan bakiyesini kaydeder")
    public void kullanici_financial_menuden_charge_account_linkine_tiklar_ve_cuzdan_bakiyesini_kaydeder() {

        JavascriptExecutor jse=(JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].scrollIntoView(true);",hazalPage.dashboardFinancial);

        hazalPage.dashboardFinancial.click();
        hazalPage.dashboardFinancialChargeAccount.click();

       String  firstCuzdanBakiyesiStr=hazalPage.chargeAccountPageCuzdanBakiyesi.getText();

       firstCuzdanBakiyesiStr=firstCuzdanBakiyesiStr.replaceAll("\\D","");

       firstCuzdanBakiyesi=Integer.parseInt(firstCuzdanBakiyesiStr);


    }


    @When("odeme yontemini secer, yuklenecek tutari girer ve islemi onaylar")
    public void odeme_yontemini_secer_yuklenecek_tutari_girer_ve_islemi_onaylar() {

        hazalPage.chargeAccountPagePaymentStripe.click();

        Actions actions=new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        hazalPage.chargeAccountPageAmount.sendKeys("20");
        ReusableMethods.bekle(2);
        hazalPage.chargeAccountPagePayButton.click();

    }


    @Then("secilen odeme yontemine uygun islem ekraninin acildigi dogrulanir")
    public void secilen_odeme_yontemine_uygun_islem_ekraninin_acildigi_dogrulanir() {

        Assertions.assertTrue(hazalPage.paymentEmailBox.isDisplayed());

    }



    @Then("cuzdan bakiyesinin guncellendigi dogrulanir")
    public void cuzdan_bakiyesinin_guncellendigi_dogrulanir() {

        hazalPage.chargeAccountMyPanelButton.click();

        JavascriptExecutor jse=(JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].scrollIntoView(true);",hazalPage.dashboardFinancial);

        hazalPage.dashboardFinancial.click();
        hazalPage.dashboardFinancialChargeAccount.click();

        String secondCuzdanBakiyesiStr=hazalPage.chargeAccountPageCuzdanBakiyesi.getText();
        secondCuzdanBakiyesiStr=secondCuzdanBakiyesiStr.replaceAll("\\D","");

        int secondCuzdanBakiyesi=Integer.parseInt(secondCuzdanBakiyesiStr);

        Assertions.assertTrue(secondCuzdanBakiyesi>firstCuzdanBakiyesi);


    }

    //***************************** US_027-->TC_06 ********************************

    @Given("register butonuna tiklar ve yeni bir instructor hesabi olusturur")
    public void register_butonuna_tiklar_ve_yeni_bir_instructor_hesabi_olusturur() {

        hazalPage.homePageRegisterButton.click();

        hazalPage.registerPageInstructorButton.click();

        Faker faker=new Faker();

        hazalPage.registerPageEmailBox.sendKeys(faker.internet().emailAddress());

        hazalPage.registerPageFullNameBox.sendKeys(faker.name().fullName());

        String password=ConfigReader.getProperty("gecerliPassword");

        hazalPage.registerPagePasswordBox.sendKeys(password);
        hazalPage.registerPageRetypePasswordBox.sendKeys(password);

        hazalPage.registerPageTimeZoneMenu.click();
        hazalPage.registerPageTimeZoneSearchBox.sendKeys("America"+Keys.ENTER);


        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].click();", hazalPage.registerPageAgreeCheckbox);

        hazalPage.registerPageSignUpButton.click();


    }


    @Given("kullanici sag ust kosede kendi adinin oldugu hover menuden dashboard'a tiklar")
    public void kullanici_sag_ust_kosede_kendi_adinin_oldugu_hover_menuden_dashboard_a_tiklar() {

        Actions actions=new Actions(Driver.getDriver());
        actions.moveToElement(hazalPage.instructorProfilButton).perform();

        hazalPage.instructorProfilButtonDashboard.click();

    }


    @When("Financial menuden Subscribe linkine tiklar")
    public void financial_menuden_subscribe_linkine_tiklar() {

        hazalPage.dashboardFinancialSubscribe.click();
    }


    @When("kullanici yeni bir plan secer ve Purchase butonuna tiklar")
    public void kullanici_yeni_bir_plan_secer_ve_purchase_butonuna_tiklar() {

        Actions actions=new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        hazalPage.subscribesPageSilverPurchaseButton.click();

    }


    @When("odeme yontemini secer ve Start Payment butonuna basar")
    public void odeme_yontemini_secer_ve_start_payment_butonuna_basar() {

        hazalPage.subscribesPaymentStripe.click();

        ReusableMethods.bekle(2);

        hazalPage.subscribesStartPayment.click();


    }


    @Then("yeni planin aktif olarak goruntulendigi dogrulanir")
    public void yeni_planin_aktif_olarak_goruntulendigi_dogrulanir() {

        hazalPage.subscribesMyPanelButton.click();

        JavascriptExecutor jse=(JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].scrollIntoView(true);",hazalPage.dashboardFinancial);

        hazalPage.dashboardFinancial.click();
        hazalPage.dashboardFinancialSubscribe.click();

        Assertions.assertTrue(hazalPage.subscribesPageMyActivePlanYaziElementi.isDisplayed());


    }



}
