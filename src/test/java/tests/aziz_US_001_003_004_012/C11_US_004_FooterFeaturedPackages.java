package tests.aziz_US_001_003_004_012;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TawUserHomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C11_US_004_FooterFeaturedPackages {

    // US_004 >>> Sitenin footer bölümünde bulunan
    // Featured Packages bölümündeki öğelerin
    // görüntülenebilir ve aktif olduğunu
    // görüntüleyebildiğimi doğrulayabilmeliyim

    @Test(priority = 1)
    public void us_004_tc_01(){
        // 1. browser'ı aç
        // 2. https://qa.tripandway.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("tawUrl"));
        Actions actions = new Actions(Driver.getDriver());
        TawUserHomePage tawUserHomePage = new TawUserHomePage();
        actions.sendKeys(Keys.END).perform();
        ReusableMethods.wait(1);

        // 3. Featured Packages kısmının göründüğünü doğrula
        Assert.assertTrue(tawUserHomePage.footerFeaturedPackagesinTamami.isDisplayed());

        // 4. başlık textinin "Featured Packages" olduğunu doğrula
        String expectedTitle = ConfigReader.getProperty("footerFeaturedPacckagesTitle");
        String eactulatitle = tawUserHomePage.labelFooterFeaturedPackagesBaslikTexti.getText();

        Assert.assertEquals(expectedTitle,eactulatitle);
        Assert.assertTrue(tawUserHomePage.labelFooterFeaturedPackagesBaslikTexti.isDisplayed());

        Driver.quitDriver();
    }

    @Test(priority = 2)
    public void us_004_tc_02(){
        // 1. browser'ı aç
        // 2. https://qa.tripandway.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("tawUrl"));
        Actions actions = new Actions(Driver.getDriver());
        TawUserHomePage tawUserHomePage = new TawUserHomePage();
        actions.sendKeys(Keys.END).perform();
        ReusableMethods.wait(1);

        // 3. birinci satırındaki linkin görünür ve erişilebilir olduğunu doğrula
        Assert.assertTrue(tawUserHomePage.linkFooterFeaturePackagesBirinciLink.isDisplayed());
        Assert.assertTrue(tawUserHomePage.linkFooterFeaturePackagesBirinciLink.isEnabled());

        // 4. text'inin "3 days in Buenos Aires" olduğunu doğrula
        String expectedText = ConfigReader.getProperty("footerFeaturedPacckagesBirinciLinkText");
        String actualText = tawUserHomePage.linkFooterFeaturePackagesBirinciLink.getText();

        Assert.assertEquals(expectedText,actualText);

        // 5. tıklandığında ilgili sayfanın title'ının "3 days in Buenos Aires" olduğunu doğrula
        tawUserHomePage.linkFooterFeaturePackagesBirinciLink.click();
        String expectedPageTitle = ConfigReader.getProperty("3daysInBuenosAiresPageTitle");
        String actualPageTitle = Driver.getDriver().getTitle();

        Assert.assertEquals(expectedPageTitle,actualPageTitle);

        Driver.quitDriver();
    }

    @Test(priority = 3)
    public void us_004_tc_03(){
        // 1. browser'ı aç
        // 2. https://qa.tripandway.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("tawUrl"));
        Actions actions = new Actions(Driver.getDriver());
        TawUserHomePage tawUserHomePage = new TawUserHomePage();
        actions.sendKeys(Keys.END).perform();
        ReusableMethods.wait(1);

        // 3. ikinci satırındaki linkin görünür ve erişilebilir olduğunu doğrula
        Assert.assertTrue(tawUserHomePage.linkFooterFeaturePackagesIkinciLink.isDisplayed());
        Assert.assertTrue(tawUserHomePage.linkFooterFeaturePackagesIkinciLink.isEnabled());

        // 4. text'inin "10 days in Buenos Aires" olduğunu doğrula
        String expectedText = ConfigReader.getProperty("footerFeaturedPacckagesIkinciLinkText");
        String actualText = tawUserHomePage.linkFooterFeaturePackagesIkinciLink.getText();

        Assert.assertEquals(expectedText,actualText);

        // 5. tıklandığında ilgili sayfanın title'ının "10 days in Buenos Aires" olduğunu doğrula
        tawUserHomePage.linkFooterFeaturePackagesIkinciLink.click();
        String expectedPageTitle = ConfigReader.getProperty("10daysInBuenosAiresPageTitle");
        String actualPageTitle = Driver.getDriver().getTitle();

        Assert.assertEquals(expectedPageTitle,actualPageTitle);

        Driver.quitDriver();

    }

    @Test(priority = 4)
    public void us_004_tc_04(){
        // 1. browser'ı aç
        // 2. https://qa.tripandway.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("tawUrl"));
        Actions actions = new Actions(Driver.getDriver());
        TawUserHomePage tawUserHomePage = new TawUserHomePage();
        actions.sendKeys(Keys.END).perform();
        ReusableMethods.wait(1);

        // 3. üçüncü satırındaki linkin görünür ve erişilebilir olduğunu doğrula
        Assert.assertTrue(tawUserHomePage.linkFooterFeaturePackagesUcuncuLink.isDisplayed());
        Assert.assertTrue(tawUserHomePage.linkFooterFeaturePackagesUcuncuLink.isEnabled());

        // 4. text'inin "3 days in Bangkok" olduğunu doğrula
        String expectedText = ConfigReader.getProperty("footerFeaturedPacckagesUcuncuLinkText");
        String actualText = tawUserHomePage.linkFooterFeaturePackagesUcuncuLink.getText();

        Assert.assertEquals(expectedText,actualText);

        // 5. tıklandığında ilgili sayfanın title'ının "3 days in Bangkok" olduğunu doğrula
        tawUserHomePage.linkFooterFeaturePackagesUcuncuLink.click();
        String expectedPageTitle = ConfigReader.getProperty("3daysInBangkogPageTitle");
        String actualPageTitle = Driver.getDriver().getTitle();

        Assert.assertEquals(expectedPageTitle,actualPageTitle);

        Driver.quitDriver();
    }

    @Test(priority = 5)
    public void us_004_tc_05(){
        // 1. browser'ı aç
        // 2. https://qa.tripandway.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("tawUrl"));
        Actions actions = new Actions(Driver.getDriver());
        TawUserHomePage tawUserHomePage = new TawUserHomePage();
        actions.sendKeys(Keys.END).perform();
        ReusableMethods.wait(1);

        // 3. dördüncü satırındaki linkin görünür ve erişilebilir olduğunu doğrula
        Assert.assertTrue(tawUserHomePage.linkFooterFeaturePackagesDorduncuLink.isDisplayed());
        Assert.assertTrue(tawUserHomePage.linkFooterFeaturePackagesDorduncuLink.isEnabled());

        // 4. text'inin "7 days in Salina Island" olduğunu doğrula
        String expectedText = ConfigReader.getProperty("footerFeaturedPacckagesDorduncuLinkText");
        String actualText = tawUserHomePage.linkFooterFeaturePackagesDorduncuLink.getText();

        Assert.assertEquals(expectedText,actualText);

        // 5. tıklandığında ilgili sayfanın title'ının "7 days in Salina Island" olduğunu doğrula
        tawUserHomePage.linkFooterFeaturePackagesDorduncuLink.click();
        String expectedPageTitle = ConfigReader.getProperty("7daysInSalinaIslandPageTitle");
        String actualPageTitle = Driver.getDriver().getTitle();

        Assert.assertEquals(expectedPageTitle,actualPageTitle);

        Driver.quitDriver();
    }
}
