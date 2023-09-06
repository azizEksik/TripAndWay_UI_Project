package tests.aziz_US_001_003_004_012;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TawUserHomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C12_US_012_HeaderServices {
    // US_012 >>>Sitenin hizmetler sayfasına gidebilmeliyim ve hizmetler sayfasında yer alan
    // hizmetler öğelerinin görünür ve aktif olduğunu görebildiğimi doğrulayabilmeliyim

    @Test(priority = 1)
    public void us_012_tc_01(){
        // 1. browser'ı aç
        // 2. https://qa.tripandway.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("tawUrl"));
        TawUserHomePage tawUserHomePage = new TawUserHomePage();

        // 3. sitenin header bölümünde bulunan SERVICES kısmının görünür ve erişilebilir olduğunu doğrula
        Assert.assertTrue(tawUserHomePage.linkHeaderServicesLinki.isEnabled());
        Assert.assertTrue(tawUserHomePage.linkHeaderServicesLinki.isDisplayed());

        Driver.quitDriver();
    }

    @Test(priority = 2)
    public void us_012_tc_02(){
        // 1. browser'ı aç
        // 2. https://qa.tripandway.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("tawUrl"));
        TawUserHomePage tawUserHomePage = new TawUserHomePage();

        // 3. SERVICES kısmına tıklandığında ilgili sayfanın title'ının "Services" olduğunu doğrula
        tawUserHomePage.linkHeaderServicesLinki.click();
        String expectedTitle = ConfigReader.getProperty("servicesPageTitle");
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertEquals(expectedTitle,actualTitle);

        Driver.quitDriver();
    }

    @Test(priority = 3)
    public void us_012_tc_03(){
        // 1. browser'ı aç
        // 2. https://qa.tripandway.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("tawUrl"));
        TawUserHomePage tawUserHomePage = new TawUserHomePage();
        Actions actions = new Actions(Driver.getDriver());
        tawUserHomePage.linkHeaderServicesLinki.click();
        for (int i = 0; i < 5; i++) {
            actions.sendKeys(Keys.ARROW_DOWN).perform();
        }
        ReusableMethods.wait(1);

        // 3. birinci hizmetin görünür ve erişilebilir olduğunu doğrula
        Assert.assertTrue(tawUserHomePage.servicesPageBirinciHizmet.isDisplayed());
        Assert.assertTrue(tawUserHomePage.servicesPageBirinciHizmet.isEnabled());

        // 4. logosunun görünür olduğunu doğrula
        Assert.assertTrue(tawUserHomePage.logoServicesPageBirinciHizmetLogosu.isDisplayed());

        // 5. başlık text'inin "International Tour" olduğunu ve göründüğünü doğrula
        String expectedBaslikText = ConfigReader.getProperty("homePageBodyOurServicesBirinciHizmetTitle");
        String actualBasliktitle = tawUserHomePage.labebServicesPageBirinciHizmetBaslikTexti.getText();

        Assert.assertEquals(expectedBaslikText,actualBasliktitle);
        Assert.assertTrue(tawUserHomePage.labebServicesPageBirinciHizmetBaslikTexti.isDisplayed());

        // 6. aciklama textinin göründüğünü doğrula
        Assert.assertTrue(tawUserHomePage.labebServicesPageBirinciHizmetAciklamaTexti.isDisplayed());

        // 7. tıklandığında ilgili sayfanın title'ının "International Tour" olduğunu doğrula
        tawUserHomePage.servicesPageBirinciHizmet.click();
        String expectedPageTitle = ConfigReader.getProperty("internationalTourPageTitle");
        String actualPageTitle = Driver.getDriver().getTitle();

        Assert.assertEquals(expectedPageTitle,actualPageTitle);

        Driver.quitDriver();

    }
    @Test(priority = 4)
    public void us_012_tc_04(){
        // 1. browser'ı aç
        // 2. https://qa.tripandway.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("tawUrl"));
        TawUserHomePage tawUserHomePage = new TawUserHomePage();
        Actions actions = new Actions(Driver.getDriver());
        tawUserHomePage.linkHeaderServicesLinki.click();
        for (int i = 0; i < 5; i++) {
            actions.sendKeys(Keys.ARROW_DOWN).perform();
        }
        ReusableMethods.wait(1);

        // 3. ikinci hizmetin görünür ve erişilebilir olduğunu doğrula
        Assert.assertTrue(tawUserHomePage.servicesPageIkinciHizmet.isDisplayed());
        Assert.assertTrue(tawUserHomePage.servicesPageIkinciHizmet.isEnabled());

        // 4. logosunun görünür olduğunu doğrula
        Assert.assertTrue(tawUserHomePage.logoServicesPageIkinciHizmetLogosu.isDisplayed());

        // 5. başlık text'inin "Adventure Tour" olduğunu ve göründüğünü doğrula
        String expectedBaslikText = ConfigReader.getProperty("homePageBodyOurServicesIkinciHizmetTitle");
        String actualBasliktitle = tawUserHomePage.labebServicesPageIkinciHizmetBaslikTexti.getText();

        Assert.assertEquals(expectedBaslikText,actualBasliktitle);
        Assert.assertTrue(tawUserHomePage.labebServicesPageIkinciHizmetBaslikTexti.isDisplayed());

        // 6. aciklama textinin göründüğünü doğrula
        Assert.assertTrue(tawUserHomePage.labebServicesPageIkinciHizmetAciklamaTexti.isDisplayed());

        // 7. tıklandığında ilgili sayfanın title'ının "Adventure Tour" olduğunu doğrula
        tawUserHomePage.servicesPageIkinciHizmet.click();
        String expectedPageTitle = ConfigReader.getProperty("adventureTourPageTitle");
        String actualPageTitle = Driver.getDriver().getTitle();

        Assert.assertEquals(expectedPageTitle,actualPageTitle);

        Driver.quitDriver();
    }

    @Test(priority = 5)
    public void us_012_tc_05(){
        // 1. browser'ı aç
        // 2. https://qa.tripandway.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("tawUrl"));
        TawUserHomePage tawUserHomePage = new TawUserHomePage();
        Actions actions = new Actions(Driver.getDriver());
        tawUserHomePage.linkHeaderServicesLinki.click();
        for (int i = 0; i < 5; i++) {
            actions.sendKeys(Keys.ARROW_DOWN).perform();
        }
        ReusableMethods.wait(1);

        // 3. üçüncü hizmetin görünür ve erişilebilir olduğunu doğrula
        Assert.assertTrue(tawUserHomePage.servicesPageUcuncuHizmet.isDisplayed());
        Assert.assertTrue(tawUserHomePage.servicesPageUcuncuHizmet.isEnabled());

        // 4. logosunun görünür olduğunu doğrula
        Assert.assertTrue(tawUserHomePage.logoServicesPageUcuncuHizmetLogosu.isDisplayed());

        // 5. başlık text'inin "Culture Tour" olduğunu ve göründüğünü doğrula
        String expectedBaslikText = ConfigReader.getProperty("homePageBodyOurServicesUcuncuHizmetTitle");
        String actualBasliktitle = tawUserHomePage.labebServicesPageUcuncuHizmetBaslikTexti.getText();

        Assert.assertEquals(expectedBaslikText,actualBasliktitle);
        Assert.assertTrue(tawUserHomePage.labebServicesPageUcuncuHizmetBaslikTexti.isDisplayed());

        // 6. aciklama textinin göründüğünü doğrula
        Assert.assertTrue(tawUserHomePage.labebServicesPageUcuncuHizmetAciklamaTexti.isDisplayed());

        // 7. tıklandığında ilgili sayfanın title'ının "Culture Tour" olduğunu doğrula
        tawUserHomePage.servicesPageUcuncuHizmet.click();
        String expectedPageTitle = ConfigReader.getProperty("cultureTourPageTitle");
        String actualPageTitle = Driver.getDriver().getTitle();

        Assert.assertEquals(expectedPageTitle,actualPageTitle);

        Driver.quitDriver();
    }

    @Test(priority = 6)
    public void us_012_tc_06(){
        // 1. browser'ı aç
        // 2. https://qa.tripandway.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("tawUrl"));
        TawUserHomePage tawUserHomePage = new TawUserHomePage();
        Actions actions = new Actions(Driver.getDriver());
        tawUserHomePage.linkHeaderServicesLinki.click();
        for (int i = 0; i < 5; i++) {
            actions.sendKeys(Keys.ARROW_DOWN).perform();
        }
        ReusableMethods.wait(1);

        // 3. dördüncü hizmetin görünür ve erişilebilir olduğunu doğrula
        Assert.assertTrue(tawUserHomePage.servicesPageDorduncuHizmet.isDisplayed());
        Assert.assertTrue(tawUserHomePage.servicesPageDorduncuHizmet.isEnabled());

        // 4. logosunun görünür olduğunu doğrula
        Assert.assertTrue(tawUserHomePage.logoServicesPageDorduncuHizmetLogosu.isDisplayed());

        // 5. başlık text'inin "Bussiness Tour" olduğunu ve göründüğünü doğrula
        String expectedBaslikText = ConfigReader.getProperty("homePageBodyOurServicesDorduncuHizmetTitle");
        String actualBasliktitle = tawUserHomePage.labebServicesPageDorduncuHizmetBaslikTexti.getText();

        Assert.assertEquals(expectedBaslikText,actualBasliktitle);
        Assert.assertTrue(tawUserHomePage.labebServicesPageDorduncuHizmetBaslikTexti.isDisplayed());

        // 6. aciklama textinin göründüğünü doğrula
        Assert.assertTrue(tawUserHomePage.labebServicesPageDorduncuHizmetAciklamaTexti.isDisplayed());

        // 7. tıklandığında ilgili sayfanın title'ının "Bussiness Tour" olduğunu doğrula
        tawUserHomePage.servicesPageDorduncuHizmet.click();
        String expectedPageTitle = ConfigReader.getProperty("bussinesstourPageTitle");
        String actualPageTitle = Driver.getDriver().getTitle();

        Assert.assertEquals(expectedPageTitle,actualPageTitle);

        Driver.quitDriver();
    }

    @Test(priority = 7)
    public void us_012_tc_07(){
        // 1. browser'ı aç
        // 2. https://qa.tripandway.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("tawUrl"));
        TawUserHomePage tawUserHomePage = new TawUserHomePage();
        Actions actions = new Actions(Driver.getDriver());
        tawUserHomePage.linkHeaderServicesLinki.click();
        for (int i = 0; i < 5; i++) {
            actions.sendKeys(Keys.ARROW_DOWN).perform();
        }
        ReusableMethods.wait(1);

        // 3. beşinci hizmetin görünür ve erişilebilir olduğunu doğrula
        Assert.assertTrue(tawUserHomePage.servicesPageBesinciHizmet.isDisplayed());
        Assert.assertTrue(tawUserHomePage.servicesPageBesinciHizmet.isEnabled());

        // 4. logosunun görünür olduğunu doğrula
        Assert.assertTrue(tawUserHomePage.logoServicesPageBesinciHizmetLogosu.isDisplayed());

        // 5. başlık text'inin "Health Tour" olduğunu ve göründüğünü doğrula
        String expectedBaslikText = ConfigReader.getProperty("homePageBodyOurServicesBesinciHizmetTitle");
        String actualBasliktitle = tawUserHomePage.labebServicesPageBesinciHizmetBaslikTexti.getText();

        Assert.assertEquals(expectedBaslikText,actualBasliktitle);
        Assert.assertTrue(tawUserHomePage.labebServicesPageBesinciHizmetBaslikTexti.isDisplayed());

        // 6. aciklama textinin göründüğünü doğrula
        Assert.assertTrue(tawUserHomePage.labebServicesPageBesinciHizmetAciklamaTexti.isDisplayed());

        // 7. tıklandığında ilgili sayfanın title'ının "Health Tour" olduğunu doğrula
        tawUserHomePage.servicesPageBesinciHizmet.click();
        String expectedPageTitle = ConfigReader.getProperty("healthtourPageTitle");
        String actualPageTitle = Driver.getDriver().getTitle();

        Assert.assertEquals(expectedPageTitle,actualPageTitle);

        Driver.quitDriver();

    }

    @Test(priority = 8)
    public void us_012_tc_08(){
        // 1. browser'ı aç
        // 2. https://qa.tripandway.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("tawUrl"));
        TawUserHomePage tawUserHomePage = new TawUserHomePage();
        Actions actions = new Actions(Driver.getDriver());
        tawUserHomePage.linkHeaderServicesLinki.click();
        for (int i = 0; i < 5; i++) {
            actions.sendKeys(Keys.ARROW_DOWN).perform();
        }
        ReusableMethods.wait(1);

        // 3. altıncı hizmetin görünür ve erişilebilir olduğunu doğrula
        Assert.assertTrue(tawUserHomePage.servicesPageAltinciHizmet.isDisplayed());
        Assert.assertTrue(tawUserHomePage.servicesPageAltinciHizmet.isEnabled());

        // 4. logosunun görünür olduğunu doğrula
        Assert.assertTrue(tawUserHomePage.logoServicesPageAltinciHizmetLogosu.isDisplayed());

        // 5. başlık text'inin "Religious Tour" olduğunu ve göründüğünü doğrula
        String expectedBaslikText = ConfigReader.getProperty("homePageBodyOurServicesAltinciHizmetTitle");
        String actualBasliktitle = tawUserHomePage.labebServicesPageAltinciHizmetBaslikTexti.getText();

        Assert.assertEquals(expectedBaslikText,actualBasliktitle);
        Assert.assertTrue(tawUserHomePage.labebServicesPageAltinciHizmetBaslikTexti.isDisplayed());

        // 6. aciklama textinin göründüğünü doğrula
        Assert.assertTrue(tawUserHomePage.labebServicesPageAltinciHizmetAciklamaTexti.isDisplayed());

        // 6. tıklandığında ilgili sayfanın title'ının "Religious Tour" olduğunu doğrula
        tawUserHomePage.servicesPageAltinciHizmet.click();
        String expectedPageTitle = ConfigReader.getProperty("religiousTourPageTitle");
        String actualPageTitle = Driver.getDriver().getTitle();

        Assert.assertEquals(expectedPageTitle,actualPageTitle);

        Driver.quitDriver();
    }

}
