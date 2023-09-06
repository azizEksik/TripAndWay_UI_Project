package tests.aziz_US_001_003_004_012;

import org.openqa.selenium.By;
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
import java.util.List;

public class C09_US_003_HomePageLatestBlog {

    // US_003 >>> Bir ziyaretçi olarak Home page sayfasının body bölümündeki fonksiyonların
    // görünür ve aktif olduğunu görüntüleyebildiğimi doğrulayabilmeliyim

    @Test(priority = 1)
    public void us_003_tc_42(){
        // 1. browser'ı aç
        // 2. https://qa.tripandway.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("tawUrl"));
        TawUserHomePage tawUserHomePage = new TawUserHomePage();
        Actions actions = new Actions(Driver.getDriver());
        for (int i = 0; i < 119; i++) {
            actions.sendKeys(Keys.ARROW_DOWN).perform();
        }
        ReusableMethods.wait(1);

        // 3 . LATEST BLOG kısmının görünür olduğunu doğrula
        Assert.assertTrue(tawUserHomePage.homePageBodyLatestBlogAlani.isDisplayed());

        // 4. başlığının "Latest Blog" olduğunu ve göründüğünü doğrula
        String expectedTitle = ConfigReader.getProperty("homePageBodyLatestBlogTitle");
        String actualTitle = tawUserHomePage.labelHomePageBodyLatestBlogBaslikTexti.getText();

        Assert.assertEquals(expectedTitle,actualTitle);
        Assert.assertTrue(tawUserHomePage.labelHomePageBodyLatestBlogBaslikTexti.isDisplayed());

        // 5. başlığın altındaki text'in görünür olduğunu doğrula
        Assert.assertTrue(tawUserHomePage.labelHomePageBodyLatestBlogAciklamaTexti.isDisplayed());

        // 6. sağa ve sola kaydır buttonlarının görünür ve erişilebilir olduğunu doğrula
        Assert.assertTrue(tawUserHomePage.buttonHomePageBodyLatestBlogSagaKaydirButtonu.isDisplayed());
        Assert.assertTrue(tawUserHomePage.buttonHomePageBodyLatestBlogSagaKaydirButtonu.isEnabled());
        Assert.assertTrue(tawUserHomePage.buttonHomePageBodyLatestBlogSolaKaydirButtonu.isDisplayed());
        Assert.assertTrue(tawUserHomePage.buttonHomePageBodyLatestBlogSolaKaydirButtonu.isEnabled());

        Driver.quitDriver();

    }

    @Test(priority = 2)
    public void us_003_tc_43_01(){
        // 1. browser'ı aç
        // 2. https://qa.tripandway.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("tawUrl"));
        TawUserHomePage tawUserHomePage = new TawUserHomePage();
        Actions actions = new Actions(Driver.getDriver());
        for (int i = 0; i < 119; i++) {
            actions.sendKeys(Keys.ARROW_DOWN).perform();
        }
        ReusableMethods.wait(1);

        // 3. LATEST BLOG kısmının bütün bloglarının görünür ve erişilebilir olduğunu doğrula
        List<String> butunBloglarXpath = tawUserHomePage.homePageBodyLatestBlogByutunBloglarXpath(Driver.getDriver());
        int sayac1=0;
        for (int i = 0; i < butunBloglarXpath.size(); i++) {
            WebElement element  = Driver.getDriver().findElement(By.xpath(butunBloglarXpath.get(i)));
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(30));
            wait.until(ExpectedConditions.visibilityOf(element));
            Assert.assertTrue(element.isDisplayed());
            Assert.assertTrue(element.isEnabled());
            sayac1++;
        }

        Driver.quitDriver();
    }

    @Test(priority = 3)
    public void us_003_tc_43_02(){
        // 1. browser'ı aç
        // 2. https://qa.tripandway.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("tawUrl"));
        TawUserHomePage tawUserHomePage = new TawUserHomePage();
        Actions actions = new Actions(Driver.getDriver());
        for (int i = 0; i < 119; i++) {
            actions.sendKeys(Keys.ARROW_DOWN).perform();
        }
        ReusableMethods.wait(1);

        // 4. başlığının göründüğünü doğrula
        List<String> butunBloglarBaslikXpath = tawUserHomePage.homePageBodyLatestBlogByutunBloglarBaslikText(Driver.getDriver());
        int sayac2=0;
        for (int i = 0; i < butunBloglarBaslikXpath.size(); i++) {
            WebElement element  = Driver.getDriver().findElement(By.xpath(butunBloglarBaslikXpath.get(i)));
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(30));
            wait.until(ExpectedConditions.visibilityOf(element));
            Assert.assertTrue(element.isDisplayed());
            sayac2++;
        }

        Driver.quitDriver();
    }

    @Test(priority = 4)
    public void us_003_tc_43_03(){
        // 1. browser'ı aç
        // 2. https://qa.tripandway.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("tawUrl"));
        TawUserHomePage tawUserHomePage = new TawUserHomePage();
        Actions actions = new Actions(Driver.getDriver());
        for (int i = 0; i < 119; i++) {
            actions.sendKeys(Keys.ARROW_DOWN).perform();
        }
        ReusableMethods.wait(1);

        // 5. başlık altındaki açıklama text'inin göründüğünü doğrula
        List<String> butunBloglarAciklamaXpath = tawUserHomePage.homePageBodyLatestBlogByutunBloglarAciklamaText(Driver.getDriver());
        int sayac3= 0;

        for (int i = 0; i < butunBloglarAciklamaXpath.size(); i++) {
            WebElement element  = Driver.getDriver().findElement(By.xpath(butunBloglarAciklamaXpath.get(i)));
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(30));
            wait.until(ExpectedConditions.visibilityOf(element));
            Assert.assertTrue(element.isDisplayed());
            sayac3++;
        }

        Driver.quitDriver();
    }

    @Test(priority = 5)
    public void us_003_tc_43_04(){
        // 1. browser'ı aç
        // 2. https://qa.tripandway.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("tawUrl"));
        TawUserHomePage tawUserHomePage = new TawUserHomePage();
        Actions actions = new Actions(Driver.getDriver());
        for (int i = 0; i < 119; i++) {
            actions.sendKeys(Keys.ARROW_DOWN).perform();
        }
        ReusableMethods.wait(1);

        // 6. read more buttonunun görünür ve erişilebilir olduğunu doğrula
        List<String> butunBloglarreadMoreButtonXpath = tawUserHomePage.homePageBodyLatestBlogByutunBloglarButton(Driver.getDriver());
        int saya4= 0;

        for (int i = 0; i < butunBloglarreadMoreButtonXpath.size(); i++) {
            WebElement element  = Driver.getDriver().findElement(By.xpath(butunBloglarreadMoreButtonXpath.get(i)));
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(30));
            wait.until(ExpectedConditions.visibilityOf(element));
            Assert.assertTrue(element.isDisplayed());
            Assert.assertTrue(element.isEnabled());
            saya4++;
        }

        Driver.quitDriver();
    }

}
