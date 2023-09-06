package tests.berke_US_031_035_036_040;


import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TawAdminPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US_040 {
    TawAdminPage tawAdminPage;
    @Test
    public void TC_01(){
        tawAdminPage = new TawAdminPage();
        //1. Webdriver çalıştırılarak "https://qa.tripandway.com/admin" sayfasına gidilir ve admin hesap bilgileri ile giriş yapılır
        Driver.getDriver().get(ConfigReader.getProperty("tawAdminUrl"));

        tawAdminPage.adminEmailBox.sendKeys(ConfigReader.getProperty("adminEmail1"));
        tawAdminPage.adminPassBox.sendKeys(ConfigReader.getProperty("adminPass"));
        tawAdminPage.adminLoginButton.click();

        //2. Sol tarafta bulunan panelin alt kısmında ok işaretli butona tıklanır
        tawAdminPage.sideBarToggleButton.click();

        //3. Panelin kapalı hale geldiği doğrulanır
        ReusableMethods.waitForVisibility(tawAdminPage.sideBarToggledLocate, 1);
        Assert.assertTrue(tawAdminPage.sideBarToggledLocate.isDisplayed());

        Driver.closeDriver();

    }
    @Test
    public void TC_02(){
        tawAdminPage = new TawAdminPage();
        //1. Webdriver çalıştırılarak "https://qa.tripandway.com/admin" sayfasına gidilir ve admin hesap bilgileri ile giriş yapılır
        Driver.getDriver().get(ConfigReader.getProperty("tawAdminUrl"));

        tawAdminPage.adminEmailBox.sendKeys(ConfigReader.getProperty("adminEmail1"));
        tawAdminPage.adminPassBox.sendKeys(ConfigReader.getProperty("adminPass"));
        tawAdminPage.adminLoginButton.click();

        //2. Header'ın sağ tarafında bulunan "Visit Website" butonuna tıklanır
        tawAdminPage.visitWebsiteButton.click();

        //3. Yeni bir sekme açılarak "https://qa.tripandway.com/" ana sayfasına gidildiği doğrulanır
        ReusableMethods.switchToWindow(ConfigReader.getProperty("homePageTitle"));
        String actualIcerik = Driver.getDriver().getTitle();

        Assert.assertTrue(actualIcerik.contains(ConfigReader.getProperty("homePageTitle")));

        Driver.quitDriver();
    }

}
