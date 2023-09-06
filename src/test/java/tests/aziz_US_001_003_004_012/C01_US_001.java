package tests.aziz_US_001_003_004_012;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class C01_US_001 {

    // US_001 >>> Bir ziyaretçi olarak siteyi kullanabilmek icin web sitesine erişebildiğimi doğrulayabilmeliyim

    @Test
    public void us_001_tc_01(){
        // 1. browser'ı aç
        // 2. https://qa.tripandway.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("tawUrl"));

        // 3. title'ın "Tripandway" olduğunu doğrula

        String expectedTitle = ConfigReader.getProperty("homePageTitle");
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertEquals(expectedTitle,actualTitle);

        Driver.closeDriver();
    }
    //////
}
