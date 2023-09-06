package tests.yucel_US_017_026_032_037_038_039;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.TawUserHomePage;
import utilities.ConfigReader;
import utilities.Driver;

public class US_017 {
    TawUserHomePage tawUserHomePage;
    Faker faker;

    @Test
    public void TC_01(){
        tawUserHomePage = new TawUserHomePage();
        faker = new Faker();
        SoftAssert softAssert = new SoftAssert();

        //"1. Webdriver çalıştırılarak ""https://qa.tripandway.com""
        //sayfasına gidilir."
        Driver.getDriver().get(ConfigReader.getProperty("tawUrl"));

        //2. Header kısmında bulunan "Contact" butonuna tıklanmalı
        tawUserHomePage.contactButton.click();

        //"3. Tıklama işleminin ardından contact ekranına
        //ulaşılabildiği doğrulanmalı"
        String expectedTitle = "Contact Us";
        String actualTitle = Driver.getDriver().getTitle();
        softAssert.assertTrue(actualTitle.contains(expectedTitle));

        //4. "Contact Form" doldurulup "Submit" butonuna tıklanmalı
        Actions actions = new Actions(Driver.getDriver());

        actions.click(tawUserHomePage.contactFromNameBox)
                .sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("contactFromPhoneNumber"))
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().emailAddress())
                .sendKeys(Keys.TAB)
                .sendKeys("Test")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER).perform();

        //5. Sağ üst kısımda "Alert" geldiği doğrulanmalı
        softAssert.assertTrue(tawUserHomePage.alertOnay.isDisplayed());

        Driver.closeDriver();
    }
}
