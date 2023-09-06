package tests.aziz_US_001_003_004_012;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.TawUserHomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.time.Duration;

public class C02_US_003_HomePageSlider {

    // US_003 >>> Bir ziyaretçi olarak Home page sayfasının body bölümündeki fonksiyonların
    // görünür ve aktif olduğunu görüntüleyebildiğimi doğrulayabilmeliyim

    @Test(priority = 1)
    public void us_003_tc_01(){
        // 1. browse'ı aç
        // 2. https://qa.tripandway.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("tawUrl"));

        // 3.Slider kısmının görünür olduğunu doğrula
        TawUserHomePage tawUserHomePage = new TawUserHomePage();
        Assert.assertTrue(tawUserHomePage.slider.isDisplayed());

        // 4. sayfanın en altına in
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.END).perform();

        // 5. yukarı kaydır buttonun görünür ve erişilir olduğunu doğrula
        Assert.assertTrue(tawUserHomePage.buttonHomePageBodyYukariKaydirButton.isDisplayed());
        Assert.assertTrue(tawUserHomePage.buttonHomePageBodyYukariKaydirButton.isEnabled());

        // 7. yukarı kaydır buttonuna tıkla
        tawUserHomePage.buttonHomePageBodyAcceptCookieButton.click();
        tawUserHomePage.buttonHomePageBodyYukariKaydirButton.click();

        // 8. Slider kısmının görünür olduğunu doğrula
        Assert.assertTrue(tawUserHomePage.slider.isDisplayed());

        Driver.quitDriver();
    }

    @Test(priority = 2)
    public void us_003_tc_02(){
        // 1. browser'ı aç
        // 2. https://qa.tripandway.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("tawUrl"));

        // 3.Slider kısmının sağa kaydır ve sola kaydır buttonlarının görünür ve erişilebilir olduğunu doğrula
        TawUserHomePage tawUserHomePage = new TawUserHomePage();
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(tawUserHomePage.sliderSagaKaydirButton.isDisplayed(),"Buttun gorunmuyor");
        softAssert.assertTrue(tawUserHomePage.sliderSagaKaydirButton.isEnabled(),"Button erisilemiyor");
        softAssert.assertTrue(tawUserHomePage.sliderSolaKaydirButton.isDisplayed(),"Buttun gorunmuyor");
        softAssert.assertTrue(tawUserHomePage.sliderSolaKaydirButton.isEnabled(),"Button erisilemiyor");

        // 4.Slider kısmının alt tarafındaki radio buttonlarının görünür ve erişilebilir olduğunu doğrula

        for (WebElement each : tawUserHomePage.radioButtonSliderButunButtonlar){
            softAssert.assertTrue(each.isDisplayed(),"Button gorunmuyor");
            softAssert.assertTrue(each.isEnabled(),"Button erisilemiyor");
        }

        softAssert.assertAll();

        Driver.quitDriver();
    }

    @Test(priority = 3)
    public void us_003_tc_03(){
        // 1. browser'ı aç
        // 2. https://qa.tripandway.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("tawUrl"));

        // 3.Slider kısmındaki ilk tanıtımın görünür olduğunu, başlık ve açıklama text'inin görünür olduğunu doğrula
        TawUserHomePage tawUserHomePage = new TawUserHomePage();

        Assert.assertTrue(tawUserHomePage.imageBackgroundSliderBirinciBackground.isDisplayed(),"Background image gorunmuyor");
        Assert.assertTrue(tawUserHomePage.labelSliderBirinciTanitimBaslikTexti.isDisplayed(),"Baslik texti gorunmuyor");
        Assert.assertTrue(tawUserHomePage.labelSliderBirinciTanitimAciklamaTexti.isDisplayed(),"Aciklama txti gorunmuyor");

        // 4.Slider kısmındaki ilk tanıtımın read more buttonunun görünür ve erişilebilir olduğunu doğrula

        Assert.assertTrue(tawUserHomePage.sliderIlkTanitimReadMoreButton.isDisplayed(),"Button gorunmuyor");
        Assert.assertTrue(tawUserHomePage.sliderIlkTanitimReadMoreButton.isEnabled(),"Button erisilemiyor");

        // 5. read more buttonuna tıklandığına gidilen sayfanın title'ının "3 days in Bangkok" olduğunu doğrula
        tawUserHomePage.sliderIlkTanitimReadMoreButton.click();
        String expectedTitle = ConfigReader.getProperty("3daysInBangkogPageTitle");
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertEquals(expectedTitle,actualTitle);

        Driver.quitDriver();
    }

    @Test(priority = 4)
    public void us_003_tc_04(){
        // 1. browser'ı aç
        // 2. https://qa.tripandway.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("tawUrl"));

        // 3.Slider kısmındaki ikinci tanıtımın görünür olduğunu, başlık ve açıklama text'inin görünür olduğunu doğrula
        TawUserHomePage tawUserHomePage = new TawUserHomePage();
        tawUserHomePage.sliderSagaKaydirButton.click();

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(40));

        wait.until(ExpectedConditions.visibilityOf(tawUserHomePage.imageBackgroundSliderIkinciBackground));
        Assert.assertTrue(tawUserHomePage.imageBackgroundSliderIkinciBackground.isDisplayed(),"Background image gorunmuyor");

        wait.until(ExpectedConditions.visibilityOf(tawUserHomePage.labelSliderIkinciTanitimBaslikTexti));
        Assert.assertTrue(tawUserHomePage.labelSliderIkinciTanitimBaslikTexti.isDisplayed(),"Baslik texti gorunmuyor");

        wait.until(ExpectedConditions.visibilityOf(tawUserHomePage.labelSliderIkinciTanitimAciklamaTexti));
        Assert.assertTrue(tawUserHomePage.labelSliderIkinciTanitimAciklamaTexti.isDisplayed(),"Aciklama txti gorunmuyor");


        // 4.Slider kısmındaki ikinci tanıtımın read more buttonunun görünür ve erişilebilir olduğunu doğrula
        wait.until(ExpectedConditions.visibilityOf(tawUserHomePage.sliderIkinciTanitimReadMoreButton));
        Assert.assertTrue(tawUserHomePage.sliderIkinciTanitimReadMoreButton.isDisplayed(),"Button gorunmuyor");
        Assert.assertTrue(tawUserHomePage.sliderIkinciTanitimReadMoreButton.isEnabled(),"Button erisilemiyor");

        // 5. read more buttonuna tıklandığına gidilen sayfanın title'ının "7 days in Istanbul" olduğunu doğrula
        tawUserHomePage.sliderIkinciTanitimReadMoreButton.click();

        String expectedTitle = ConfigReader.getProperty("7daysInIstanbulPageTitle");
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertEquals(expectedTitle,actualTitle);

        Driver.quitDriver();

    }

    @Test(priority = 5)
    public void us_003_tc_05(){
        // 1. browser'ı aç
        // 2. https://qa.tripandway.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("tawUrl"));
        TawUserHomePage tawUserHomePage = new TawUserHomePage();
        tawUserHomePage.sliderSagaKaydirButton.click();
        ReusableMethods.wait(1);
        tawUserHomePage.sliderSagaKaydirButton.click();

        // 3.Slider kısmındaki üçüncü tanıtımın görünür olduğunu, başlık ve açıklama text'inin görünür olduğunu doğrula
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),Duration.ofSeconds(40));

        wait.until(ExpectedConditions.visibilityOf(tawUserHomePage.imageBackgroundSliderUcuncuBackground));
        Assert.assertTrue(tawUserHomePage.imageBackgroundSliderUcuncuBackground.isDisplayed(),"Background image gorunmuyor");

        wait.until(ExpectedConditions.visibilityOf(tawUserHomePage.labelSliderUcuncuTanitimBaslikTexti));
        Assert.assertTrue(tawUserHomePage.labelSliderUcuncuTanitimBaslikTexti.isDisplayed(),"Baslik texti gorunmuyor");

        wait.until(ExpectedConditions.visibilityOf(tawUserHomePage.labelSliderUcuncuTanitimAciklamaTexti));
        Assert.assertTrue(tawUserHomePage.labelSliderUcuncuTanitimAciklamaTexti.isDisplayed(),"Aciklama txti gorunmuyor");

        // 4.Slider kısmındaki üçüncü tanıtımın read more buttonunun görünür ve erişilebilir olduğunu doğrula
        wait.until(ExpectedConditions.visibilityOf(tawUserHomePage.sliderUcuncuTanitimReadMoreButton));
        Assert.assertTrue(tawUserHomePage.sliderUcuncuTanitimReadMoreButton.isDisplayed(),"Button gorunmuyor");
        Assert.assertTrue(tawUserHomePage.sliderUcuncuTanitimReadMoreButton.isEnabled(),"Button erisilemiyor");

        // 5. read more buttonuna tıklandığına gidilen sayfanın title'ının "7 days in Salina Island" olduğunu doğrula
        tawUserHomePage.sliderUcuncuTanitimReadMoreButton.click();

        String expectedTitle = ConfigReader.getProperty("7daysInSalinaIslandPageTitle");
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertEquals(expectedTitle,actualTitle);

        Driver.quitDriver();
    }

    @Test(priority = 6)
    public void us_003_tc_06(){
        // 1. browser'ı aç
        // 2. https://qa.tripandway.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("tawUrl"));
        TawUserHomePage tawUserHomePage = new TawUserHomePage();
        Actions actions = new Actions(Driver.getDriver());

        // 3. silider kısmının ilk tanıtımını mause ile tutup sola  çek ve ikinci tanıtımın görünür olduğunu doğrula
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOf(tawUserHomePage.imageBackgroundSliderBirinciBackground));
        actions.moveToElement(tawUserHomePage.sliderIlkTanitimReadMoreButton)
                                             .clickAndHold(tawUserHomePage.sliderIlkTanitimReadMoreButton)
                                             .moveToElement(tawUserHomePage.sliderSagaKaydirButton)
                                             .click().perform();

        Assert.assertTrue(tawUserHomePage.imageBackgroundSliderIkinciBackground.isDisplayed(),"Bacground image gorunmuyor");

        // 4. slider kısmının ikinci tanıtımını mause ile tutup sağa çek ve birinci tanıtımın görünür olduğunu doğrula
        wait.until(ExpectedConditions.visibilityOf(tawUserHomePage.sliderIkinciTanitimReadMoreButton));
        actions.moveToElement(tawUserHomePage.sliderIkinciTanitimReadMoreButton)
                                             .clickAndHold(tawUserHomePage.sliderIkinciTanitimReadMoreButton)
                                             .moveToElement(tawUserHomePage.sliderSolaKaydirButton)
                                             .click().perform();

        wait.until(ExpectedConditions.visibilityOf(tawUserHomePage.imageBackgroundSliderBirinciBackground));
        Assert.assertTrue(tawUserHomePage.imageBackgroundSliderBirinciBackground.isDisplayed());

        Driver.quitDriver();
    }
}





























