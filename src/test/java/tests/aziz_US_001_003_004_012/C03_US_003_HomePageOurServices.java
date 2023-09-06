package tests.aziz_US_001_003_004_012;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TawUserHomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C03_US_003_HomePageOurServices {

    // US_003 >>> Bir ziyaretçi olarak Home page sayfasının body bölümündeki fonksiyonların
    // görünür ve aktif olduğunu görüntüleyebildiğimi doğrulayabilmeliyim

    @Test(priority = 1)
    public void us_003_tc_07(){
        // 1. browser'ı aç
        // 2. https://qa.tripandway.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("tawUrl"));
        TawUserHomePage tawUserHomePage = new TawUserHomePage();
        Actions actions = new Actions(Driver.getDriver());
        for (int i = 0; i < 16; i++) {
            actions.sendKeys(Keys.ARROW_DOWN).perform();
        }
        ReusableMethods.wait(2);

        // 3. Hizmetlerimiz(OUR SERVICES) kısmının göründüğünü doğrula
        Assert.assertTrue(tawUserHomePage.ourServicesAlani.isDisplayed());

        // 4. Hizmetlerimiz kısmının başlığının "OUR SERVICES" olduğunu ve göründüğünü doğrula
        String expectedTitle = ConfigReader.getProperty("homePageBodyOurServicesTitle");
        String actualTitle = tawUserHomePage.labelHomePageBodyOurServicesBaslikTexti.getText();

        Assert.assertEquals(expectedTitle,actualTitle);
        Assert.assertTrue(tawUserHomePage.labelHomePageBodyOurServicesBaslikTexti.isDisplayed());

        // 5. Başlığın altındaki açıklama text'inin göründüğünü doğrula
        Assert.assertTrue(tawUserHomePage.labelHomePageBodyOurservicesAciklamaTexti.isDisplayed());

        Driver.quitDriver();
    }

    @Test(priority = 2)
    public void us_003_tc_08(){
        // 1. browser'ı aç
        // 2. https://qa.tripandway.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("tawUrl"));
        TawUserHomePage tawUserHomePage = new TawUserHomePage();
        Actions actions = new Actions(Driver.getDriver());
        for (int i = 0; i < 16; i++) {
            actions.sendKeys(Keys.ARROW_DOWN).perform();
        }
        ReusableMethods.wait(2);

        // 3. Birinci hizmetin görünür ve erişilebilir olduğunu doğrula
        Assert.assertTrue(tawUserHomePage.homePageBodyOurServicesBirinciHizmet.isDisplayed());
        Assert.assertTrue(tawUserHomePage.homePageBodyOurServicesBirinciHizmet.isEnabled());

        // 4. logonun görünür olduğunu doğrula
        Assert.assertTrue(tawUserHomePage.logoHomePageBodyOurServicesBirinciHizmetLogosu.isDisplayed());

        // 5. başlık text'inin "International Tour" olduğunu ve göründüğünü doğrula
        String expectedServicesTitle = ConfigReader.getProperty("homePageBodyOurServicesBirinciHizmetTitle");
        String actualServicesTitle = tawUserHomePage.labelHomePageOurServicesBirinciHizmetBaslikTexti.getText();

        Assert.assertEquals(expectedServicesTitle,actualServicesTitle);
        Assert.assertTrue(tawUserHomePage.labelHomePageOurServicesBirinciHizmetBaslikTexti.isDisplayed());

        // 6. başlık altındaki açıklama text'inin göründüğünü doğrula
        Assert.assertTrue(tawUserHomePage.labelHomePageOurServicesBirinciHizmetAciklamaTexti.isDisplayed());

        // 7. birinci hizmete tıklandığında gidilen sayfanın title'ının "International Tour" olduğunu doğrula
        tawUserHomePage.homePageBodyOurServicesBirinciHizmet.click();

        String expectedPageTitle = ConfigReader.getProperty("internationalTourPageTitle");
        String actualPageTitle = Driver.getDriver().getTitle();

        Assert.assertEquals(expectedPageTitle,actualPageTitle);

        Driver.quitDriver();
    }

    @Test(priority = 3)
    public void us_003_tc_09(){
        // 1. browser'ı aç
        // 2. https://qa.tripandway.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("tawUrl"));
        TawUserHomePage tawUserHomePage = new TawUserHomePage();
        Actions actions = new Actions(Driver.getDriver());
        for (int i = 0; i < 16; i++) {
            actions.sendKeys(Keys.ARROW_DOWN).perform();
        }
        ReusableMethods.wait(2);

        // 3. ikinci hizmetin görünür ve erişilebilir olduğunu doğrula
        Assert.assertTrue(tawUserHomePage.homePageBodyOurServicesIkinciHizmet.isDisplayed());
        Assert.assertTrue(tawUserHomePage.homePageBodyOurServicesIkinciHizmet.isEnabled());

        // 4. logonun görünür olduğunu doğrula
        Assert.assertTrue(tawUserHomePage.logoHomePageBodyOurServicesIkinciHizmetLogosu.isDisplayed());

        // 5. başlık text'inin "Adventure Tour" olduğunu ve göründüğünü doğrula
        String expectedServicesTitle = ConfigReader.getProperty("homePageBodyOurServicesIkinciHizmetTitle");
        String actualServicestitle = tawUserHomePage.labelHomePageOurServicesIkinciHizmetBaslikTexti.getText();

        Assert.assertEquals(expectedServicesTitle,actualServicestitle);
        Assert.assertTrue(tawUserHomePage.labelHomePageOurServicesIkinciHizmetBaslikTexti.isDisplayed());

        // 6. başlık altındaki açıklama text'inin göründüğünü doğrula
        Assert.assertTrue(tawUserHomePage.labelHomePageOurServicesIkinciHizmetAciklamaTexti.isDisplayed());

        // 7. ikinci hizmete tıklandığında gidilen sayfanın title'ının "Adventure Tour" olduğunu doğrula
        tawUserHomePage.homePageBodyOurServicesIkinciHizmet.click();

        String expectedPageTitle = ConfigReader.getProperty("adventureTourPageTitle");
        String actualPageTitle = Driver.getDriver().getTitle();

        Assert.assertEquals(expectedPageTitle,actualPageTitle);

        Driver.quitDriver();

    }

    @Test(priority = 4)
    public void us_003_tc_10(){
        // 1. browser'ı aç
        // 2. https://qa.tripandway.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("tawUrl"));
        TawUserHomePage tawUserHomePage = new TawUserHomePage();
        Actions actions = new Actions(Driver.getDriver());
        for (int i = 0; i < 16; i++) {
            actions.sendKeys(Keys.ARROW_DOWN).perform();
        }
        ReusableMethods.wait(2);

        // 3. üçüncü hizmetin görünür ve erişilebilir olduğunu doğrula
        Assert.assertTrue(tawUserHomePage.homePageBodyOurServicesUcuncuHizmet.isDisplayed());
        Assert.assertTrue(tawUserHomePage.homePageBodyOurServicesUcuncuHizmet.isEnabled());

        // 4. logonun görünür olduğunu doğrula
        Assert.assertTrue(tawUserHomePage.logoHomePageBodyOurServicesUcuncuHizmetLogosu.isDisplayed());

        // 5. başlık text'inin "Culture Tour" olduğunu ve göründüğünü doğrula
        String expectedServicesTitle = ConfigReader.getProperty("homePageBodyOurServicesUcuncuHizmetTitle");
        String actualServicestitle = tawUserHomePage.labelHomePageOurServicesUcuncuHizmetBaslikTexti.getText();

        Assert.assertEquals(expectedServicesTitle,actualServicestitle);
        Assert.assertTrue(tawUserHomePage.labelHomePageOurServicesUcuncuHizmetBaslikTexti.isDisplayed());

        // 6. başlık altındaki açıklama text'inin göründüğünü doğrula
        Assert.assertTrue(tawUserHomePage.labelHomePageOurServicesUcuncuHizmetAciklamaTexti.isDisplayed());

        // 7. ikinci hizmete tıklandığında gidilen sayfanın title'ının "Culture Tour" olduğunu doğrula
        tawUserHomePage.homePageBodyOurServicesUcuncuHizmet.click();

        String expectedPageTitle = ConfigReader.getProperty("cultureTourPageTitle");
        String actualPageTitle = Driver.getDriver().getTitle();

        Assert.assertEquals(expectedPageTitle,actualPageTitle);

        Driver.quitDriver();
    }

    @Test(priority = 5)
    public void us_003_tc_11(){
        // 1. browser'ı aç
        // 2. https://qa.tripandway.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("tawUrl"));
        TawUserHomePage tawUserHomePage = new TawUserHomePage();
        Actions actions = new Actions(Driver.getDriver());
        for (int i = 0; i < 16; i++) {
            actions.sendKeys(Keys.ARROW_DOWN).perform();
        }
        ReusableMethods.wait(2);

        // 3. dördüncü hizmetin görünür ve erişilebilir olduğunu doğrula
        Assert.assertTrue(tawUserHomePage.homePageBodyOurServicesDorduncuHizmet.isDisplayed());
        Assert.assertTrue(tawUserHomePage.homePageBodyOurServicesDorduncuHizmet.isEnabled());

        // 4. logonun görünür olduğunu doğrula
        Assert.assertTrue(tawUserHomePage.logoHomePageBodyOurServicesDorduncuHizmetLogosu.isDisplayed());

        // 5. başlık text'inin "Bussiness Tour" olduğunu ve göründüğünü doğrula
        String expectedServicesTitle = ConfigReader.getProperty("homePageBodyOurServicesDorduncuHizmetTitle");
        String actualServicestitle = tawUserHomePage.labelHomePageOurServicesDorduncuHizmetBaslikTexti.getText();

        Assert.assertEquals(expectedServicesTitle,actualServicestitle);
        Assert.assertTrue(tawUserHomePage.labelHomePageOurServicesDorduncuHizmetBaslikTexti.isDisplayed());

        // 6. başlık altındaki açıklama text'inin göründüğünü doğrula
        Assert.assertTrue(tawUserHomePage.labelHomePageOurServicesDorduncuHizmetAciklamaTexti.isDisplayed());

        // 7. ikinci hizmete tıklandığında gidilen sayfanın title'ının "Bussiness Tour" olduğunu doğrula
        tawUserHomePage.homePageBodyOurServicesDorduncuHizmet.click();

        String expectedPageTitle = ConfigReader.getProperty("bussinesstourPageTitle");
        String actualPageTitle = Driver.getDriver().getTitle();

        Assert.assertEquals(expectedPageTitle,actualPageTitle);

        Driver.quitDriver();
    }

    @Test(priority = 6)
    public void us_003_tc_12(){
        // 1. browser'ı aç
        // 2. https://qa.tripandway.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("tawUrl"));
        TawUserHomePage tawUserHomePage = new TawUserHomePage();
        Actions actions = new Actions(Driver.getDriver());
        for (int i = 0; i < 16; i++) {
            actions.sendKeys(Keys.ARROW_DOWN).perform();
        }
        ReusableMethods.wait(2);


        // 3. beşinci hizmetin görünür ve erişilebilir olduğunu doğrula
        Assert.assertTrue(tawUserHomePage.homePageBodyOurServicesBesinciHizmet.isDisplayed());
        Assert.assertTrue(tawUserHomePage.homePageBodyOurServicesBesinciHizmet.isEnabled());

        // 4. logonun görünür olduğunu doğrula
        Assert.assertTrue(tawUserHomePage.logoHomePageBodyOurServicesBesinciHizmetLogosu.isDisplayed());

        // 5. başlık text'inin "Health Tour" olduğunu ve göründüğünü doğrula
        String expectedServicesTitle = ConfigReader.getProperty("homePageBodyOurServicesBesinciHizmetTitle");
        String actualServicestitle = tawUserHomePage.labelHomePageOurServicesBesinciHizmetBaslikTexti.getText();

        Assert.assertEquals(expectedServicesTitle,actualServicestitle);
        Assert.assertTrue(tawUserHomePage.labelHomePageOurServicesBesinciHizmetBaslikTexti.isDisplayed());

        // 6. başlık altındaki açıklama text'inin göründüğünü doğrula
        Assert.assertTrue(tawUserHomePage.labelHomePageOurServicesBesinciHizmetAciklamaTexti.isDisplayed());

        // 7. beşinci hizmete tıklandığında gidilen sayfanın title'ının "Health Tour" olduğunu doğrula
        tawUserHomePage.homePageBodyOurServicesBesinciHizmet.click();

        String expectedPageTitle = ConfigReader.getProperty("healthtourPageTitle");
        String actualPageTitle = Driver.getDriver().getTitle();

        Assert.assertEquals(expectedPageTitle,actualPageTitle);

        Driver.quitDriver();
    }

    @Test(priority = 7)
    public void us_003_tc_13(){
        // 1. browser'ı aç
        // 2. https://qa.tripandway.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("tawUrl"));
        TawUserHomePage tawUserHomePage = new TawUserHomePage();
        Actions actions = new Actions(Driver.getDriver());
        for (int i = 0; i < 16; i++) {
            actions.sendKeys(Keys.ARROW_DOWN).perform();
        }
        ReusableMethods.wait(2);

        // 3. altıncı hizmetin görünür ve erişilebilir olduğunu doğrula
        Assert.assertTrue(tawUserHomePage.homePageBodyOurServicesAltinciHizmet.isDisplayed());
        Assert.assertTrue(tawUserHomePage.homePageBodyOurServicesAltinciHizmet.isEnabled());

        // 4. logonun görünür olduğunu doğrula
        Assert.assertTrue(tawUserHomePage.logoHomePageBodyOurServicesAltinciHizmetLogosu.isDisplayed());

        // 5. başlık text'inin "Religious Tour" olduğunu ve göründüğünü doğrula
        String expectedServicesTitle = ConfigReader.getProperty("homePageBodyOurServicesAltinciHizmetTitle");
        String actualServicestitle = tawUserHomePage.labelHomePageOurServicesAltinciHizmetBaslikTexti.getText();

        Assert.assertEquals(expectedServicesTitle,actualServicestitle);
        Assert.assertTrue(tawUserHomePage.labelHomePageOurServicesAltinciHizmetBaslikTexti.isDisplayed());

        // 6. başlık altındaki açıklama text'inin göründüğünü doğrula
        Assert.assertTrue(tawUserHomePage.labelHomePageOurServicesAltinciHizmetAciklamaTexti.isDisplayed());

        // 7. altıncı hizmete tıklandığında gidilen sayfanın title'ının "Religious Tour" olduğunu doğrula
        tawUserHomePage.homePageBodyOurServicesAltinciHizmet.click();

        String expectedPageTitle = ConfigReader.getProperty("religiousTourPageTitle");
        String actualPageTitle = Driver.getDriver().getTitle();

        Assert.assertEquals(expectedPageTitle,actualPageTitle);

        Driver.quitDriver();
    }

}
