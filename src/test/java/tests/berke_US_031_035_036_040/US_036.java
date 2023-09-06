package tests.berke_US_031_035_036_040;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TawAdminPage;
import utilities.ConfigReader;
import utilities.Driver;


public class US_036 {
    TawAdminPage tawAdminPage;
    @Test
    public void TC_01(){
        tawAdminPage = new TawAdminPage();

        //1. Webdriver çalıştırılarak "https://qa.tripandway.com/admin" sayfasına gidilir ve admin hesap bilgileri ile giriş yapılır
        Driver.getDriver().get(ConfigReader.getProperty("tawAdminUrl"));

        TawAdminPage.tawAdminAccountGiris();

        //2. Admin ana sayfasında sol panelde bulunan listede "Subscribers" a tıklanır ve açılan drop down menüde "Send Email to Subscribers" butonuna tıklanır
        tawAdminPage.subscribersButton.click();
        tawAdminPage.sendEmailToSubscribersButton.click();

        //3. Açılan sayfada ilgili tüm alanları doldurulur ve ardından sayfanın alt kısmında bulunan "Submit" butonuna tıklanır
        Actions actions = new Actions(Driver.getDriver());

        actions.click(tawAdminPage.sendEmailToSubscribersSubjectBox)
                .sendKeys(ConfigReader.getProperty("sendEmailToSubscribersSubjectBox"))
                .sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("sendEmailToSubscribersMessageBox"))
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER).perform();

        //4. Gönderme işleminin ardından sağ üstte çıkan alert yardımı ile mail gönderme işleminin gerçeleştiği doğrulanır
        Assert.assertTrue(tawAdminPage.newPackagesOnay.isDisplayed());

        Driver.closeDriver();
    }
}
