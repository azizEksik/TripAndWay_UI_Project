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

public class C10_US_003_HomePageOurClient {

    // US_003 >>> Bir ziyaretçi olarak Home page sayfasının body bölümündeki fonksiyonların
    // görünür ve aktif olduğunu görüntüleyebildiğimi doğrulayabilmeliyim

    @Test(priority = 1)
    public void us_003_tc_44(){
        // 1. browser'ı aç
        // 2. https://qa.tripandway.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("tawUrl"));
        TawUserHomePage tawUserHomePage = new TawUserHomePage();
        Actions actions = new Actions(Driver.getDriver());
        for (int i = 0; i < 135; i++) {
            actions.sendKeys(Keys.ARROW_DOWN).perform();
        }
        ReusableMethods.wait(1);

        // 3. OUR CLIENT kısmının görünür olduğunu doğrula
        Assert.assertTrue(tawUserHomePage.homePageBodyOurClientAlani.isDisplayed());

        Driver.quitDriver();

    }

    @Test(priority = 2)
    public void us_003_tc_45(){
        // 1. browser'ı aç
        // 2. https://qa.tripandway.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("tawUrl"));
        TawUserHomePage tawUserHomePage = new TawUserHomePage();
        Actions actions = new Actions(Driver.getDriver());
        for (int i = 0; i < 135; i++) {
            actions.sendKeys(Keys.ARROW_DOWN).perform();
        }
        ReusableMethods.wait(1);

        // 3. OUR CLIENT kısmınındaki bütün logoların görünür olduğunu doğrula
        for (WebElement each : tawUserHomePage.logoHomePageBodyOurClientLogolarinTamami){
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20));
            wait.until(ExpectedConditions.visibilityOf(each));
            Assert.assertTrue(each.isDisplayed());
        }

        Driver.quitDriver();
    }
}
