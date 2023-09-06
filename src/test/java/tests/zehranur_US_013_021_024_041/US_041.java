package tests.zehranur_US_013_021_024_041;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TawAdminPage;
import utilities.ConfigReader;
import utilities.Driver;

public class US_041 {

    @Test(priority = 1)
    public void us_041_tc_01(){
        // 1. Webdriver çalıştırılarak "https://qa.tripandway.com/admin" sayfasına gidilerek giriş yapılır
        TawAdminPage tawAdminPage = new TawAdminPage();
        Driver.getDriver().get(ConfigReader.getProperty("tawAdminUrl"));

        tawAdminPage.adminEmailBox.sendKeys(ConfigReader.getProperty("adminEmail1"));
        tawAdminPage.adminPassBox.sendKeys(ConfigReader.getProperty("adminPass"));
        tawAdminPage.adminLoginButton.click();

        // 2. Açılan sayfanın https://qa.tripandway.com/admin/dashboard olduğu doğrulanır.
        String expectedTitle = ConfigReader.getProperty("adminPageTitle");
        String actulaTitle = Driver.getDriver().getTitle();

        Assert.assertEquals(expectedTitle,actulaTitle);

        // 3.Header'ın en sağindaki admin menüsüne tıklanır.
        tawAdminPage.dropDownAdminProfile.click();

        // 4. Açılan menüde Logout tıklanır.
        tawAdminPage.buttonAdminPageAdminProfileLoguotButton.click();

        // 5. Sayfadan çıkış yapılarak yeni açılan sayfanın Tripandway olduğu doğrulanır.
        String expectedTawTitle = ConfigReader.getProperty("homePageTitle");
        String actualTawTitle = Driver.getDriver().getTitle();

        Assert.assertEquals(expectedTawTitle,actualTawTitle);

        Driver.quitDriver();
    }
}
