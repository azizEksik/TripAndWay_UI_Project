package tests.aziz_US_001_003_004_012;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TawUserHomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C05_US_003_HomePageSirketBasarilari {

    // US_003 >>> Bir ziyaretçi olarak Home page sayfasının body bölümündeki fonksiyonların
    // görünür ve aktif olduğunu görüntüleyebildiğimi doğrulayabilmeliyim

    @Test(priority = 1)
    public void us_003_tc_19(){
        // 1. browser'ı aç
        // 2. https://qa.tripandway.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("tawUrl"));
        TawUserHomePage tawUserHomePage = new TawUserHomePage();
        Actions actions = new Actions(Driver.getDriver());
        for (int i = 0; i < 50; i++) {
            actions.sendKeys(Keys.ARROW_DOWN).perform();
        }
        ReusableMethods.wait(2);

        // 3. şirket başalarıları kısmının görünür olduğunu doğrula
        Assert.assertTrue(tawUserHomePage.sirketBasarilariAlani.isDisplayed());

        Driver.quitDriver();
    }
    @Test(priority = 2)
    public void us_003_tc_20(){
        // 1. browser'ı aç
        // 2. https://qa.tripandway.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("tawUrl"));
        TawUserHomePage tawUserHomePage = new TawUserHomePage();
        Actions actions = new Actions(Driver.getDriver());
        for (int i = 0; i < 50; i++) {
            actions.sendKeys(Keys.ARROW_DOWN).perform();
        }
        ReusableMethods.wait(2);

        // 3. birinci sütununun birinci satırının "575" olduğunu ve göründüğünü doğrula
        String expectedBaslikText = ConfigReader.getProperty("homePageBodySirketBasarilariBirinciBaslikText");
        String actualBaslikTitle = tawUserHomePage.labelHomePageBodySirketBasarilariBirinciBaslikTexti.getText();

        Assert.assertEquals(expectedBaslikText,actualBaslikTitle);
        Assert.assertTrue(tawUserHomePage.labelHomePageBodySirketBasarilariBirinciBaslikTexti.isDisplayed());

        // 4. birinci sütununun ikinci satırının "COMPLETED TOURS" olduğunu ve göründüğünü doğrula
        String expectedAciklamaText = ConfigReader.getProperty("homePageBodySirketBasarilariBirinciAciklamaText");
        String actualAciklamatext = tawUserHomePage.labelHomePageBodySirketBasarilariBirinciAciklamaTexti.getText();

        Assert.assertEquals(expectedAciklamaText,actualAciklamatext);
        Assert.assertTrue(tawUserHomePage.labelHomePageBodySirketBasarilariBirinciAciklamaTexti.isDisplayed());

        Driver.quitDriver();
    }

    @Test(priority = 3)
    public void us_003_tc_21(){
        // 1. browser'ı aç
        // 2. https://qa.tripandway.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("tawUrl"));
        TawUserHomePage tawUserHomePage = new TawUserHomePage();
        Actions actions = new Actions(Driver.getDriver());
        for (int i = 0; i < 50; i++) {
            actions.sendKeys(Keys.ARROW_DOWN).perform();
        }
        ReusableMethods.wait(2);

        // 3. Ikinci sütununun birinci satırının "300" olduğunu ve göründüğünü doğrula
        String expectedBaslikText = ConfigReader.getProperty("homePageBodySirketBasarilariIkinciBaslikText");
        String actualBaslikTitle = tawUserHomePage.labelHomePageBodySirketBasarilariIkinciBaslikTexti.getText();

        Assert.assertEquals(expectedBaslikText,actualBaslikTitle);
        Assert.assertTrue(tawUserHomePage.labelHomePageBodySirketBasarilariIkinciBaslikTexti.isDisplayed());

        // 4. Ikinci sütununun ikinci satırının "HAPPY CLIENTS" olduğunu ve göründüğünü doğrula
        String expectedAciklamaText = ConfigReader.getProperty("homePageBodySirketBasarilariIkinciAciklamaText");
        String actualAciklamatext = tawUserHomePage.labelHomePageBodySirketBasarilariIkinciAciklamaTexti.getText();

        Assert.assertEquals(expectedAciklamaText,actualAciklamatext);
        Assert.assertTrue(tawUserHomePage.labelHomePageBodySirketBasarilariIkinciAciklamaTexti.isDisplayed());

        Driver.quitDriver();
    }

    @Test(priority = 4)
    public void us_003_tc_22(){
        // 1. browser'ı aç
        // 2. https://qa.tripandway.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("tawUrl"));
        TawUserHomePage tawUserHomePage = new TawUserHomePage();
        Actions actions = new Actions(Driver.getDriver());
        for (int i = 0; i < 50; i++) {
            actions.sendKeys(Keys.ARROW_DOWN).perform();
        }
        ReusableMethods.wait(2);

        // 3. Ucuncu sütununun birinci satırının "70" olduğunu ve göründüğünü doğrula
        String expectedBaslikText = ConfigReader.getProperty("homePageBodySirketBasarilariUcuncuBaslikText");
        String actualBaslikTitle = tawUserHomePage.labelHomePageBodySirketBasarilariUcuncuBaslikTexti.getText();

        Assert.assertEquals(expectedBaslikText,actualBaslikTitle);
        Assert.assertTrue(tawUserHomePage.labelHomePageBodySirketBasarilariUcuncuBaslikTexti.isDisplayed());

        // 4. Ucuncu sütununun ikinci satırının "EXPERIENCED MEMBERS" olduğunu ve göründüğünü doğrula
        String expectedAciklamaText = ConfigReader.getProperty("homePageBodySirketBasarilariUcuncuiAciklamaText");
        String actualAciklamatext = tawUserHomePage.labelHomePageBodySirketBasarilariUcuncuAciklamaTexti.getText();

        Assert.assertEquals(expectedAciklamaText,actualAciklamatext);
        Assert.assertTrue(tawUserHomePage.labelHomePageBodySirketBasarilariUcuncuAciklamaTexti.isDisplayed());

        Driver.quitDriver();
    }

    @Test(priority = 5)
    public void us_003_tc_23(){
        // 1. browser'ı aç
        // 2. https://qa.tripandway.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("tawUrl"));
        TawUserHomePage tawUserHomePage = new TawUserHomePage();
        Actions actions = new Actions(Driver.getDriver());
        for (int i = 0; i < 50; i++) {
            actions.sendKeys(Keys.ARROW_DOWN).perform();
        }
        ReusableMethods.wait(2);

        // 3. dördüncü sütununun birinci satırının "45" olduğunu ve göründüğünü doğrula
        String expectedBaslikText = ConfigReader.getProperty("homePageBodySirketBasarilariDorduncuBaslikText");
        String actualBaslikTitle = tawUserHomePage.labelHomePageBodySirketBasarilariDorduncuBaslikTexti.getText();

        Assert.assertEquals(expectedBaslikText,actualBaslikTitle);
        Assert.assertTrue(tawUserHomePage.labelHomePageBodySirketBasarilariDorduncuBaslikTexti.isDisplayed());
        // 4. dördüncüsütununun ikinci satırının "AWARDS WON" olduğunu ve göründüğünü doğrula
        String expectedAciklamaText = ConfigReader.getProperty("homePageBodySirketBasarilariDorduncuAciklamaText");
        String actualAciklamatext = tawUserHomePage.labelHomePageBodySirketBasarilariDorduncuAciklamaTexti.getText();

        Assert.assertEquals(expectedAciklamaText,actualAciklamatext);
        Assert.assertTrue(tawUserHomePage.labelHomePageBodySirketBasarilariDorduncuAciklamaTexti.isDisplayed());

        Driver.quitDriver();
    }
}
