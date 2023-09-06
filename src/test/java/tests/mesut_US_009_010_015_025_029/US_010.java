package tests.mesut_US_009_010_015_025_029;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TawUserHomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US_010 {
    /*
        Bir ziyaretçi olarak sitenin
        Terms amd Conditions sayfasının görüntülenebildiğini doğrulayabilmeliyim
     */

    @Test
    public void tc_01() {
        // 1- https://qa.tripandway.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("tawUrl"));
        TawUserHomePage tawUserHomePage = new TawUserHomePage();
        ReusableMethods.wait(1);
        tawUserHomePage.websiteUsesCookiesButton.click();

        //2- Ana sayfanın en altında footer-bottom bölümünde Terms and Conditions linkinin text'i doğrulanır ve linkine tıklanır
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.END).perform();

        String expectedText = ConfigReader.getProperty("termsAndConditionsTitle");
        String actualText = tawUserHomePage.termsAndConditionsElement.getText();
        Assert.assertEquals(actualText, expectedText);
        tawUserHomePage.termsAndConditionsElement.click();

        //3- İlgili sayfanın açıldığı doğrulanır
        String expectedUrl = ConfigReader.getProperty("termsAndConditionsUrl");
        String actuallUrl = Driver.getDriver().getCurrentUrl();
        System.out.println(actuallUrl);
        Assert.assertTrue(actuallUrl.contains(expectedUrl));

        // Sekme olarak açılan sayfanın title başlığını kontrol eder
        ReusableMethods.switchToWindow("Terms and Conditions");
        // String expectedTitle="Terms and Conditions";
        String expectedTitle = ConfigReader.getProperty("termsAndConditionsTitle");
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);

        //4- Açılan sayfada belirli içerik kontrolü sağlanır
        String expectedPageTitle = ConfigReader.getProperty("termsAndConditionsPageTitle");
        String actualPageTitlTe = tawUserHomePage.termsAndConditionsTitleText.getText();
        System.out.println(actualPageTitlTe);
        Assert.assertEquals(actualPageTitlTe, expectedPageTitle);

        Driver.closeDriver();


    }
}