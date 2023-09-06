package tests.mesut_US_009_010_015_025_029;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TawUserHomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US_009 {

    /*
        Sitenin mail haber gurubuna(newsletter) katılabildiğimi doğrulayabilmeliyim
     */

    private JavascriptExecutor jsExecutor;
    @Test
    public void tc_01(){
        // 1- https://qa.tripandway.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("tawUrl"));
        TawUserHomePage tawUserHomePage = new TawUserHomePage();
        // 2- Ana sayfanın aşağısında bulunan Newsletter bölümüne gitmek gerekir
        jsExecutor = (JavascriptExecutor) Driver.getDriver();
        jsExecutor.executeScript("window.scrollTo(0, 6000);");
        ReusableMethods.wait(1);

        // 3- Textbox'ın aktif olduğu doğrulanmalı ve geçerli bir mail adresi girilmesi gerekir.
        Assert.assertTrue(tawUserHomePage.newsletterTextbox.isEnabled());
        tawUserHomePage.newsletterTextbox.sendKeys(ConfigReader.getProperty("newsletterEmail"));
        // tawUserHomePage.newsletterTextbox.sendKeys("me@hotmail.com");

        // 4- Submit butonuna basılır
        tawUserHomePage.newsletterSubmitButton.click();

        // Uyarı mesajının gözüktüğü doğrulanıyor
        Assert.assertTrue(tawUserHomePage.newsletterEmailSubmitAlertMessage.isDisplayed());

        // 5- Submit butonuna bastıktan sonra çıkan mesajın içeriği okunur
        String actualEmailAlertResut = tawUserHomePage.newsletterEmailSubmitAlertMessage.getText();

        // 6- E-posta adresi zaten kayıtlı ise veya yeni kayıt yapıldıysa iki farklı mesajın içerği test edilir
        String expectedConfirmEmail = ConfigReader.getProperty("newsletterConfirmEmailAlert");
        String expectedExistsEmail = ConfigReader.getProperty("newsletterExistsEmailAlert");
        Assert.assertTrue(actualEmailAlertResut.equals(expectedConfirmEmail) || actualEmailAlertResut.equals(expectedExistsEmail) );

        Driver.closeDriver();






    }
}
