package tests.yucel_US_017_026_032_037_038_039;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TawAdminPage;
import utilities.ConfigReader;
import utilities.Driver;

public class US_026 {
    TawAdminPage tawAdminPage;

    @Test
    public void TC_01(){
        tawAdminPage = new TawAdminPage();

        //"1. Webdriver çalıştırılarak ""https://qa.tripandway.com/admin""
        //sayfasına gidilir."
        Driver.getDriver().get(ConfigReader.getProperty("tawAdminUrl"));

        TawAdminPage.tawAdminAccountGiris();

        //"2. Admin girişinin ardından karşılandığı sayfanın yönetim
        //paneli olduğu doğrulanmalı"
        String expectedTitle = "Admin Panel";
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertTrue(actualTitle.contains(expectedTitle));

        Driver.closeDriver();

    }
}
