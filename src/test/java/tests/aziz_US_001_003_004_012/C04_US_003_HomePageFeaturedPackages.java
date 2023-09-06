package tests.aziz_US_001_003_004_012;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TawUserHomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.time.Duration;

public class C04_US_003_HomePageFeaturedPackages {

    // US_003 >>> Bir ziyaretçi olarak Home page sayfasının body bölümündeki fonksiyonların
    // görünür ve aktif olduğunu görüntüleyebildiğimi doğrulayabilmeliyim

    @Test(priority = 1)
    public void us_003_tc_14(){
        // 1. browser'ı aç
        // 2. https://qa.tripandway.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("tawUrl"));
        TawUserHomePage tawUserHomePage = new TawUserHomePage();
        Actions actions = new Actions(Driver.getDriver());
        for (int i = 0; i < 38; i++) {
            actions.sendKeys(Keys.ARROW_DOWN).perform();
        }
        ReusableMethods.wait(2);

        // 3. özel paketler(FEATURED PACKAGES) kısmının göründüğünü doğrula
        Assert.assertTrue(tawUserHomePage.featurePackagesAlani.isDisplayed());

        // 4. Başlığının "FEATURED PACKAGES" olduğunu doğrula
        String expectedTitle = ConfigReader.getProperty("homePageBodyFeaturedPackagesTitle");
        String actualtitle = tawUserHomePage.labelHomePageBodyFeaturedPackagesBaslikTexti.getText();

        Assert.assertEquals(expectedTitle,actualtitle);

        // 5. Başlık altında açıklama text'inin göründüğünü doğrula
        Assert.assertTrue(tawUserHomePage.labelHomePageBodyFeaturedPackagesAciklamaTexti.isDisplayed());

        // 6. Radio buttonlarının göründüğünü ve erişilebilir olduğunu doğrula

        for (WebElement each : tawUserHomePage.radioButtonFeaturePackagesRadioButtonlari){
            Assert.assertTrue(each.isDisplayed());
            Assert.assertTrue(each.isEnabled());
        }

        Driver.quitDriver();

    }

    @Test(priority = 2)
    public void us_003_tc_15(){

        // 1. browser'ı aç
        // 2. https://qa.tripandway.com/ adresine gits
        Driver.getDriver().get(ConfigReader.getProperty("tawUrl"));
        TawUserHomePage tawUserHomePage = new TawUserHomePage();
        Actions actions = new Actions(Driver.getDriver());
        for (int i = 0; i < 38; i++) {
            actions.sendKeys(Keys.ARROW_DOWN).perform();
        }
        ReusableMethods.wait(2);

        // 3. birinci paketin görünür olduğunu doğrula
        Assert.assertTrue(tawUserHomePage.homePageBodyFeaturedPackagesBirinciPaket.isDisplayed());

        // 4. Kişi başı fiyatının " 5000 / Person" olduğunu ve göründüğünü doğrula
        String expectedPrice = ConfigReader.getProperty("homePageBodyFeaturedPackagesBirinciPaketPrice");
        String actualPrice = tawUserHomePage.labelHomePageBodyFeaturedPackagesBirinciPaketKisiBasiFiyat.getText();

        Assert.assertEquals(expectedPrice,actualPrice);

        // 5. başlığının "3 days in Buenos Aires" olduğunu ve göründüğünü doğrula
        String  expectedFeaturedPackagesBirinciPaketTitle = ConfigReader.getProperty("homePageBodyFeaturedPackagesBirinciPakeTitle");
        String actualFeaturedPackagesBirinciPaketTitle = tawUserHomePage.labelHomePageBodyFeaturedPackagesBirinciPaketBaslik.getText();

        Assert.assertEquals(expectedFeaturedPackagesBirinciPaketTitle,actualFeaturedPackagesBirinciPaketTitle);

        // 6. başlık altındaki açıklama text'inin göründüğünü doğrula
        Assert.assertTrue(tawUserHomePage.labelHomePageBodyFeaturedPackagesBirinciPaketAciklamaTexti.isDisplayed());

        // 7. başlığın erişilebilir olduğunu ve tıklandığında gidilen sayfanın title'inin "3 days in Buenos Aires" olduğunu doğrula
        Assert.assertTrue(tawUserHomePage.labelHomePageBodyFeaturedPackagesBirinciPaketBaslik.isEnabled());
        tawUserHomePage.labelHomePageBodyFeaturedPackagesBirinciPaketBaslik.click();

        String expectedTitle = ConfigReader.getProperty("3daysInBuenosAiresPageTitle");
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertEquals(expectedTitle,actualTitle);

        Driver.quitDriver();

    }

    @Test(priority = 3)
    public void us_003_tc_16(){
        // 1. browser'ı aç
        // 2. https://qa.tripandway.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("tawUrl"));
        TawUserHomePage tawUserHomePage = new TawUserHomePage();
        Actions actions = new Actions(Driver.getDriver());
        for (int i = 0; i < 38; i++) {
            actions.sendKeys(Keys.ARROW_DOWN).perform();
        }
        ReusableMethods.wait(2);

        // 3. ikinci paketin görünür olduğunu doğrula
        Assert.assertTrue(tawUserHomePage.homePageBodyFeaturedPackagesIkinciPaket.isDisplayed());

        // 4. Kişi başı fiyatının " 15000 / Person" olduğunu ve göründüğünü doğrula
        String expectedPrice = ConfigReader.getProperty("homePageBodyFeaturedPackagesIkinciPaketPrice");
        String actualPrice = tawUserHomePage.labelHomePageBodyFeaturedPackagesIkinciPaketKisiBasiFiyat.getText();

        Assert.assertEquals(expectedPrice,actualPrice);

        // 5. başlığının "10 days in Buenos Aires" olduğunu ve göründüğünü doğrula
        String  expectedFeaturedPackagesIkinciPaketTitle = ConfigReader.getProperty("homePageBodyFeaturedPackagesIkinciPakeTitle");
        String actualFeaturedPackagesIkinciPaketTitle = tawUserHomePage.labelHomePageBodyFeaturedPackagesIkinciPaketBaslik.getText();

        Assert.assertEquals(expectedFeaturedPackagesIkinciPaketTitle,actualFeaturedPackagesIkinciPaketTitle);

        // 6. başlık altındaki açıklama text'inin göründüğünü doğrula
        Assert.assertTrue(tawUserHomePage.labelHomePageBodyFeaturedPackagesIkinciPaketAciklamaTexti.isDisplayed());

        // 7. başlığın erişilebilir olduğunu ve tıklandığında gidilen sayfanın title'inin "10 days in Buenos Aires" olduğunu doğrula
        Assert.assertTrue(tawUserHomePage.labelHomePageBodyFeaturedPackagesIkinciPaketBaslik.isEnabled());
        tawUserHomePage.labelHomePageBodyFeaturedPackagesIkinciPaketBaslik.click();

        String expectedTitle = ConfigReader.getProperty("10daysInBuenosAiresPageTitle");
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertEquals(expectedTitle,actualTitle);

        Driver.quitDriver();
    }

    @Test(priority = 4)
    public void us_003_tc_17(){
        // 1. browser'ı aç
        // 2. https://qa.tripandway.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("tawUrl"));
        TawUserHomePage tawUserHomePage = new TawUserHomePage();
        Actions actions = new Actions(Driver.getDriver());
        for (int i = 0; i < 38; i++) {
            actions.sendKeys(Keys.ARROW_DOWN).perform();
        }
        ReusableMethods.wait(2);

        // 3. üçüncü paketin görünür olduğunu doğrula
        Assert.assertTrue(tawUserHomePage.homePageBodyFeaturedPackagesUcuncuPaket.isDisplayed());

        // 4. Kişi başı fiyatının " 5500 / Person" olduğunu ve göründüğünü doğrula
        String expectedPrice = ConfigReader.getProperty("homePageBodyFeaturedPackagesUcuncuPaketPrice");
        String actualPrice = tawUserHomePage.labelHomePageBodyFeaturedPackagesUcuncuPaketKisiBasiFiyat.getText();

        Assert.assertEquals(expectedPrice,actualPrice);

        // 5. başlığının "3 days in Bangkok" olduğunu ve göründüğünü doğrula
        String  expectedFeaturedPackagesUcuncuPaketTitle = ConfigReader.getProperty("homePageBodyFeaturedPackagesUcuncuPakeTitle");
        String actualFeaturedPackagesUcuncuPaketTitle = tawUserHomePage.labelHomePageBodyFeaturedPackagesUcuncuPaketBaslik.getText();

        Assert.assertEquals(expectedFeaturedPackagesUcuncuPaketTitle,actualFeaturedPackagesUcuncuPaketTitle);
        // 6. başlık altındaki açıklama text'inin göründüğünü doğrula
        Assert.assertTrue(tawUserHomePage.labelHomePageBodyFeaturedPackagesUcuncuPaketAciklamaTexti.isDisplayed());

        // 7. başlığın erişilebilir olduğunu ve tıklandığında gidilen sayfanın title'inin "3 days in Bangkok" olduğunu doğrula
        Assert.assertTrue(tawUserHomePage.labelHomePageBodyFeaturedPackagesUcuncuPaketBaslik.isEnabled());
        tawUserHomePage.labelHomePageBodyFeaturedPackagesUcuncuPaketBaslik.click();

        String expectedTitle = ConfigReader.getProperty("3daysInBangkogPageTitle");
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertEquals(expectedTitle,actualTitle);

        Driver.quitDriver();
    }

    @Test(priority = 5)
    public void us_003_tc_18(){

        // 1. browser'ı aç
        // 2. https://qa.tripandway.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("tawUrl"));
        TawUserHomePage tawUserHomePage = new TawUserHomePage();
        Actions actions = new Actions(Driver.getDriver());
        for (int i = 0; i < 38; i++) {
            actions.sendKeys(Keys.ARROW_DOWN).perform();
        }
        ReusableMethods.wait(2);

        // 3. dördüncü paketin görünür olduğunu doğrula
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOf(tawUserHomePage.homePageBodyFeaturedPackagesDorduncuPaket));
        Assert.assertTrue(tawUserHomePage.homePageBodyFeaturedPackagesDorduncuPaket.isDisplayed());

        // 4. Kişi başı fiyatının " 13000 / Person" olduğunu ve göründüğünü doğrula
        String expectedPrice = ConfigReader.getProperty("homePageBodyFeaturedPackagesDorduncuPaketPrice");
        String actualPrice = tawUserHomePage.labelHomePageBodyFeaturedPackagesDorduncuPaketKisiBasiFiyat.getText();

        Assert.assertEquals(expectedPrice,actualPrice);

        // 5. başlığının "7 days in Salina Island" olduğunu ve göründüğünü doğrula
        String  expectedFeaturedPackagesDorduncuPaketTitle = ConfigReader.getProperty("homePageBodyFeaturedPackagesDorduncuPakeTitle");
        String actualFeaturedPackagesDorduncuPaketTitle = tawUserHomePage.labelHomePageBodyFeaturedPackagesDorduncuPaketBaslik.getText();

        Assert.assertEquals(expectedFeaturedPackagesDorduncuPaketTitle,actualFeaturedPackagesDorduncuPaketTitle);

        // 6. başlık altındaki açıklama text'inin göründüğünü doğrula
        Assert.assertTrue(tawUserHomePage.labelHomePageBodyFeaturedPackagesDorduncuPaketAciklamaTexti.isDisplayed());

        // 7. başlığın erişilebilir olduğunu ve tıklandığında gidilen sayfanın title'inin "7 days in Salina Island" olduğunu doğrula
        Assert.assertTrue(tawUserHomePage.labelHomePageBodyFeaturedPackagesDorduncuPaketBaslik.isEnabled());
        tawUserHomePage.labelHomePageBodyFeaturedPackagesDorduncuPaketBaslik.click();

        String expectedTitle = ConfigReader.getProperty("7daysInSalinaIslandPageTitle");
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertEquals(expectedTitle,actualTitle);

        Driver.quitDriver();
    }



}
