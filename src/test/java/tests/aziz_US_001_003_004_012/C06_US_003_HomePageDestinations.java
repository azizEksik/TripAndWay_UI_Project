package tests.aziz_US_001_003_004_012;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TawUserHomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C06_US_003_HomePageDestinations {

    // US_003 >>> Bir ziyaretçi olarak Home page sayfasının body bölümündeki fonksiyonların
    // görünür ve aktif olduğunu görüntüleyebildiğimi doğrulayabilmeliyim

    @Test(priority = 1)
    public void us_003_tc_24(){
        // 1. browser'ı aç
        // 2. https://qa.tripandway.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("tawUrl"));
        TawUserHomePage tawUserHomePage = new TawUserHomePage();
        Actions actions = new Actions(Driver.getDriver());
        for (int i = 0; i < 65; i++) {
            actions.sendKeys(Keys.ARROW_DOWN).perform();
        }
        ReusableMethods.wait(2);

        // 3. varış noktası(DESTINATION) kısmının görünür olduğunu doğrula
        Assert.assertTrue(tawUserHomePage.destinationsAlani.isDisplayed());

        // 4. başlığının "Destination" olduğunu ve göründüğünü doğrula
        String expectedTitle = ConfigReader.getProperty("homePageBodyDestinationsTitle");
        String actualTitle = tawUserHomePage.labelHomePageBodyDestinationsBaslikTexti.getText();

        Assert.assertEquals(expectedTitle,actualTitle);
        Assert.assertTrue(tawUserHomePage.labelHomePageBodyDestinationsBaslikTexti.isDisplayed());

        // 5. başlık altındaki açıklama text'inin göründüğünü doğrula
        Assert.assertTrue(tawUserHomePage.labelHomePageBodyDestinationsAciklamaTexti.isDisplayed());

        Driver.quitDriver();
    }

    @Test(priority = 2)
    public void us_003_tc_25(){
        // 1. browser'ı aç
        // 2. https://qa.tripandway.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("tawUrl"));
        TawUserHomePage tawUserHomePage = new TawUserHomePage();
        Actions actions = new Actions(Driver.getDriver());
        for (int i = 0; i < 65; i++) {
            actions.sendKeys(Keys.ARROW_DOWN).perform();
        }
        ReusableMethods.wait(2);

        // 3. başlığının "Bangkok, Thailand" olduğunu ve göründüğünü doğrula
        String expectedBirinciDestinationTitle = ConfigReader.getProperty("homePageBodyDestinationsBirinciDestinationTitle");
        String actualBirinciDestinationTitle = tawUserHomePage.labelHomePageDestinationsBirinciDestinationBaslikTexti.getText();

        Assert.assertEquals(expectedBirinciDestinationTitle,actualBirinciDestinationTitle);
        Assert.assertTrue(tawUserHomePage.labelHomePageDestinationsBirinciDestinationBaslikTexti.isDisplayed());

        // 4. birinci varış noktasına mause'u götürdüğümde yakınlaştır ikonunun göründüğünü ve erişilebilir olduğunu doğrula
        actions.moveToElement(tawUserHomePage.homepageBodyBirinciDestination).perform();
        Assert.assertTrue(tawUserHomePage.iconHomePageBodyDestinationsBirinciDestinationIcon.isDisplayed());
        Assert.assertTrue(tawUserHomePage.iconHomePageBodyDestinationsBirinciDestinationIcon.isEnabled());

        // 5. yakınlaştır ikonuna tıklandığında açılan sayfada fotoğrafın göründüğünü erişilebilir olduğunu doğrula
        tawUserHomePage.iconHomePageBodyDestinationsBirinciDestinationIcon.click();
        Assert.assertTrue(tawUserHomePage.imageDestinationHomePageBodyBirinciDestinationIkonunaTiklanincaAcilanImage.isDisplayed());
        Assert.assertTrue(tawUserHomePage.imageDestinationHomePageBodyBirinciDestinationIkonunaTiklanincaAcilanImage.isEnabled());

        // 6. birinci varış noktasındaki fotoğraf ile aynı olduğunu doğrula
        String expectedImage = tawUserHomePage
                .imageDestinationHomePageBodyBirinciDestinationIkonunaTiklanincaAcilanImage.getAttribute("src");
        String actualImage = tawUserHomePage.imageDestinationHomePageBodyBirinciDestinationImage.getAttribute("src");

        Assert.assertEquals(expectedImage,actualImage);

        // 7. açılan sayfada sağa ve sola git okunun göründüğünü ve erişilebilir olduğunu doğrula
        Assert.assertTrue(tawUserHomePage.buttonDestinationHomePageBodyBirinciDestinationIkonunaTiklanincaAcilanSagButton.isDisplayed());
        Assert.assertTrue(tawUserHomePage.buttonDestinationHomePageBodyBirinciDestinationIkonunaTiklanincaAcilanSagButton.isEnabled());
        Assert.assertTrue(tawUserHomePage.buttonDestinationHomePageBodyBirinciDestinationIkonunaTiklanincaAcilanSolButton.isDisplayed());
        Assert.assertTrue(tawUserHomePage.buttonDestinationHomePageBodyBirinciDestinationIkonunaTiklanincaAcilanSolButton.isEnabled());

        // 8. açılan sayfada close ikonunun göründüğünü ve erişilebilir olduğunu doğrula
        Assert.assertTrue(tawUserHomePage.iconDestinationHomePageBodyBirinciDestinationIkonunaTiklanincaAcilanCloseIcon.isDisplayed());
        Assert.assertTrue(tawUserHomePage.iconDestinationHomePageBodyBirinciDestinationIkonunaTiklanincaAcilanCloseIcon.isEnabled());

        // 9. açılan sayfada fotoğrafın altında text'in "1 of 6"  olduğunu ve göründüğünü doğrula
        String expectedSayiText = ConfigReader.getProperty("homePageBodyDestinationsBirinciDestinationSayiText");
        String actualSayiText = tawUserHomePage.labelDestinationHomePageBodyBirinciDestinationIkonunaTiklanincaAcilanSayiTexti.getText();

        Assert.assertEquals(expectedSayiText,actualSayiText);
        Assert.assertTrue(tawUserHomePage.labelDestinationHomePageBodyBirinciDestinationIkonunaTiklanincaAcilanSayiTexti.isDisplayed());

        // 10. birinci varış noktasının başlığına tıklandığında ilgili sayfanın' title'ının "Bangkok, Thailand" olduğunu doğrula
        tawUserHomePage.iconDestinationHomePageBodyBirinciDestinationIkonunaTiklanincaAcilanCloseIcon.click();
        tawUserHomePage.labelHomePageDestinationsBirinciDestinationBaslikTexti.click();

        String expectedPageTitle = ConfigReader.getProperty("bangkokThailandPageTitle");
        String actualPageTitle = Driver.getDriver().getTitle();

        Assert.assertEquals(expectedPageTitle,actualPageTitle);

        Driver.quitDriver();
    }

    @Test(priority = 3)
    public void us_003_tc_26(){
        // 1. browser'ı aç
        // 2. https://qa.tripandway.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("tawUrl"));
        TawUserHomePage tawUserHomePage = new TawUserHomePage();
        Actions actions = new Actions(Driver.getDriver());
        for (int i = 0; i < 65; i++) {
            actions.sendKeys(Keys.ARROW_DOWN).perform();
        }
        ReusableMethods.wait(2);

        // 3. başlığının "Greenville, South Carolina" olduğunu ve göründüğünü doğrula
        String expectedIkinciDestinationTitle = ConfigReader.getProperty("homePageBodyDestinationsIkinciDestinationTitle");
        String actualIkinciDestinationTitle = tawUserHomePage.labelHomePageDestinationsIkinciDestinationBaslikTexti.getText();

        Assert.assertEquals(expectedIkinciDestinationTitle,actualIkinciDestinationTitle);
        Assert.assertTrue(tawUserHomePage.labelHomePageDestinationsIkinciDestinationBaslikTexti.isDisplayed());

        Assert.assertEquals(expectedIkinciDestinationTitle,actualIkinciDestinationTitle);
        Assert.assertTrue(tawUserHomePage.labelHomePageDestinationsIkinciDestinationBaslikTexti.isDisplayed());
        // 4. ikinci varış noktasına mause'u götürdüğümde yakınlaştır ikonunun göründüğünü ve erişilebilir olduğunu doğrula
        actions.moveToElement(tawUserHomePage.homepageBodyIkinciDestination).perform();
        Assert.assertTrue(tawUserHomePage.iconHomePageBodyDestinationsIkinciDestinationIcon.isDisplayed());
        Assert.assertTrue(tawUserHomePage.iconHomePageBodyDestinationsIkinciDestinationIcon.isEnabled());

        // 5. yakınlaştır ikonuna tıklandığında açılan sayfada fotoğrafın göründüğünü erişilebilir olduğunu doğrula
        tawUserHomePage.iconHomePageBodyDestinationsIkinciDestinationIcon.click();
        Assert.assertTrue(tawUserHomePage.imageDestinationHomePageBodyIkinciDestinationIkonunaTiklanincaAcilanImage.isDisplayed());
        Assert.assertTrue(tawUserHomePage.imageDestinationHomePageBodyIkinciDestinationIkonunaTiklanincaAcilanImage.isEnabled());

        // 6.  ikinci varış noktasındaki fotoğraf ile aynı olduğunu doğrula
        String expectedImage = tawUserHomePage
                .imageDestinationHomePageBodyIkinciDestinationIkonunaTiklanincaAcilanImage.getAttribute("src");
        String actualImage = tawUserHomePage.imageDestinationHomePageBodyIkinciDestinationImage.getAttribute("src");

        Assert.assertEquals(expectedImage,actualImage);

        // 7. açılan sayfada sağa ve sola git okunun göründüğünü ve erişilebilir olduğunu doğrula
        Assert.assertTrue(tawUserHomePage.buttonDestinationHomePageBodyIkinciDestinationIkonunaTiklanincaAcilanSagButton.isDisplayed());
        Assert.assertTrue(tawUserHomePage.buttonDestinationHomePageBodyIkinciDestinationIkonunaTiklanincaAcilanSagButton.isEnabled());
        Assert.assertTrue(tawUserHomePage.buttonDestinationHomePageBodyIkinciDestinationIkonunaTiklanincaAcilanSolButton.isDisplayed());
        Assert.assertTrue(tawUserHomePage.buttonDestinationHomePageBodyIkinciDestinationIkonunaTiklanincaAcilanSolButton.isEnabled());

        // 8. açılan sayfada close ikonunun göründüğünü ve erişilebilir olduğunu doğrula
        Assert.assertTrue(tawUserHomePage.iconDestinationHomePageBodyIkinciDestinationIkonunaTiklanincaAcilanCloseIcon.isDisplayed());
        Assert.assertTrue(tawUserHomePage.iconDestinationHomePageBodyIkinciDestinationIkonunaTiklanincaAcilanCloseIcon.isEnabled());

        // 9. açılan sayfada fotoğrafın altında text'in "2 of 6"  olduğunu doğrula
        String expectedSayiText = ConfigReader.getProperty("homePageBodyDestinationsIkinciDestinationSayiText");
        String actualSayiText = tawUserHomePage.labelDestinationHomePageBodyIkinciDestinationIkonunaTiklanincaAcilanSayiTexti.getText();

        Assert.assertEquals(expectedSayiText,actualSayiText);
        Assert.assertTrue(tawUserHomePage.labelDestinationHomePageBodyIkinciDestinationIkonunaTiklanincaAcilanSayiTexti.isDisplayed());

        // 10. ikinci varış noktasının başlığına tıklandığında ilgili sayfanın' title'ının "Greenville, South Carolina" olduğunu doğrula
        tawUserHomePage.iconDestinationHomePageBodyIkinciDestinationIkonunaTiklanincaAcilanCloseIcon.click();
        tawUserHomePage.labelHomePageDestinationsIkinciDestinationBaslikTexti.click();

        String expectedPageTitle = ConfigReader.getProperty("greenvilleSouthCarolinaPageTitle");
        String actualPageTitle = Driver.getDriver().getTitle();

        Assert.assertEquals(expectedPageTitle,actualPageTitle);

        Driver.quitDriver();
    }

    @Test(priority = 4)
    public void us_003_tc_27(){
        // 1. browser'ı aç
        // 2. https://qa.tripandway.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("tawUrl"));
        TawUserHomePage tawUserHomePage = new TawUserHomePage();
        Actions actions = new Actions(Driver.getDriver());
        for (int i = 0; i < 65; i++) {
            actions.sendKeys(Keys.ARROW_DOWN).perform();
        }
        ReusableMethods.wait(2);

        // 3. başlığının "Buenos Aires, Argentina" olduğunu ve göründüğünü doğrula
        String expectedUcuncuDestinationTitle = ConfigReader.getProperty("homePageBodyDestinationsUcuncuDestinationTitle");
        String actualUcuncuDestinationTitle = tawUserHomePage.labelHomePageDestinationsUcuncuDestinationBaslikTexti.getText();

        Assert.assertEquals(expectedUcuncuDestinationTitle,actualUcuncuDestinationTitle);
        Assert.assertTrue(tawUserHomePage.labelHomePageDestinationsUcuncuDestinationBaslikTexti.isDisplayed());

        // 4. üçüncü varış noktasına mause'u götürdüğümde yakınlaştır ikonunun göründüğünü ve erişilebilir olduğunu doğrula
        actions.moveToElement(tawUserHomePage.homepageBodyUcuncuDestination).perform();
        Assert.assertTrue(tawUserHomePage.iconHomePageBodyDestinationsUcuncuDestinationIcon.isDisplayed());
        Assert.assertTrue(tawUserHomePage.iconHomePageBodyDestinationsUcuncuDestinationIcon.isEnabled());

        // 5. yakınlaştır ikonuna tıklandığında açılan sayfada fotoğrafın göründüğünü erişilebilir olduğunu doğrula
        tawUserHomePage.iconHomePageBodyDestinationsUcuncuDestinationIcon.click();
        Assert.assertTrue(tawUserHomePage.imageDestinationHomePageBodyUcuncuDestinationIkonunaTiklanincaAcilanImage.isDisplayed());
        Assert.assertTrue(tawUserHomePage.imageDestinationHomePageBodyUcuncuDestinationIkonunaTiklanincaAcilanImage.isEnabled());

        // 6.  üçüncü varış noktasındaki fotoğraf ile aynı olduğunu doğrula
        String expectedImage = tawUserHomePage
                .imageDestinationHomePageBodyUcuncuDestinationIkonunaTiklanincaAcilanImage.getAttribute("src");
        String actualImage = tawUserHomePage.imageDestinationHomePageBodyUcuncuDestinationImage.getAttribute("src");

        Assert.assertEquals(expectedImage,actualImage);

        // 7. açılan sayfada sağa ve sola git okunun göründüğünü ve erişilebilir olduğunu doğrula
        Assert.assertTrue(tawUserHomePage.buttonDestinationHomePageBodyUcuncuDestinationIkonunaTiklanincaAcilanSagButton.isDisplayed());
        Assert.assertTrue(tawUserHomePage.buttonDestinationHomePageBodyUcuncuDestinationIkonunaTiklanincaAcilanSagButton.isEnabled());
        Assert.assertTrue(tawUserHomePage.buttonDestinationHomePageBodyUcuncuDestinationIkonunaTiklanincaAcilanSolButton.isDisplayed());
        Assert.assertTrue(tawUserHomePage.buttonDestinationHomePageBodyUcuncuDestinationIkonunaTiklanincaAcilanSolButton.isEnabled());

        // 8. açılan sayfada close ikonunun göründüğünü ve erişilebilir olduğunu doğrula
        Assert.assertTrue(tawUserHomePage.iconDestinationHomePageBodyUcuncuDestinationIkonunaTiklanincaAcilanCloseIcon.isDisplayed());
        Assert.assertTrue(tawUserHomePage.iconDestinationHomePageBodyUcuncuDestinationIkonunaTiklanincaAcilanCloseIcon.isEnabled());

        // 9. açılan sayfada fotoğrafın altında text'in "3 of 6"  olduğunu doğrula
        String expectedSayiText = ConfigReader.getProperty("homePageBodyDestinationsUcuncuDestinationSayiText");
        String actualSayiText = tawUserHomePage.labelDestinationHomePageBodyUcuncuDestinationIkonunaTiklanincaAcilanSayiTexti.getText();

        Assert.assertEquals(expectedSayiText,actualSayiText);
        Assert.assertTrue(tawUserHomePage.labelDestinationHomePageBodyUcuncuDestinationIkonunaTiklanincaAcilanSayiTexti.isDisplayed());

        // 10. üçüncü varış noktasının başlığına tıklandığında ilgili sayfanın' title'ının "Buenos Aires, Argentina" olduğunu doğrula
        tawUserHomePage.iconDestinationHomePageBodyUcuncuDestinationIkonunaTiklanincaAcilanCloseIcon.click();
        tawUserHomePage.labelHomePageDestinationsUcuncuDestinationBaslikTexti.click();

        String expectedPageTitle = ConfigReader.getProperty("buenosAiresArgentinaPageTitle");
        String actualPageTitle = Driver.getDriver().getTitle();

        Assert.assertEquals(expectedPageTitle,actualPageTitle);

        Driver.quitDriver();
    }
    @Test(priority = 5)
    public void us_003_tc_28(){
        // 1. browser'ı aç
        // 2. https://qa.tripandway.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("tawUrl"));
        TawUserHomePage tawUserHomePage = new TawUserHomePage();
        Actions actions = new Actions(Driver.getDriver());
        for (int i = 0; i < 65; i++) {
            actions.sendKeys(Keys.ARROW_DOWN).perform();
        }
        ReusableMethods.wait(2);

        // 3. başlığının "Marrakesh, Morocco" olduğunu ve göründüğünü doğrula
        String expectedDorduncuDestinationTitle = ConfigReader.getProperty("homePageBodyDestinationsDorduncuDestinationTitle");
        String actualDorduncuDestinationTitle = tawUserHomePage.labelHomePageDestinationsDorduncuDestinationBaslikTexti.getText();

        Assert.assertEquals(expectedDorduncuDestinationTitle,actualDorduncuDestinationTitle);
        Assert.assertTrue(tawUserHomePage.labelHomePageDestinationsDorduncuDestinationBaslikTexti.isDisplayed());

        // 4. dördüncü varış noktasına mause'u götürdüğümde yakınlaştır ikonunun göründüğünü ve erişilebilir olduğunu doğrula
        actions.moveToElement(tawUserHomePage.homepageBodyDorduncuDestination).perform();
        Assert.assertTrue(tawUserHomePage.iconHomePageBodyDestinationsDorduncuDestinationIcon.isDisplayed());
        Assert.assertTrue(tawUserHomePage.iconHomePageBodyDestinationsDorduncuDestinationIcon.isEnabled());

        // 5. yakınlaştır ikonuna tıklandığında açılan sayfada fotoğrafın göründüğünü erişilebilir olduğunu doğrula
        tawUserHomePage.iconHomePageBodyDestinationsDorduncuDestinationIcon.click();
        Assert.assertTrue(tawUserHomePage.imageDestinationHomePageBodyDorduncuDestinationIkonunaTiklanincaAcilanImage.isDisplayed());
        Assert.assertTrue(tawUserHomePage.imageDestinationHomePageBodyDorduncuDestinationIkonunaTiklanincaAcilanImage.isEnabled());

        // 6.  dördüncü varış noktasındaki fotoğraf ile aynı olduğunu doğrula
        String expectedImage = tawUserHomePage
                .imageDestinationHomePageBodyDorduncuDestinationIkonunaTiklanincaAcilanImage.getAttribute("src");
        String actualImage = tawUserHomePage.imageDestinationHomePageBodyDorduncuDestinationImage.getAttribute("src");

        Assert.assertEquals(expectedImage,actualImage);

        // 7. açılan sayfada sağa ve sola git okunun göründüğünü ve erişilebilir olduğunu doğrula
        Assert.assertTrue(tawUserHomePage.buttonDestinationHomePageBodyDorduncuDestinationIkonunaTiklanincaAcilanSagButton.isDisplayed());
        Assert.assertTrue(tawUserHomePage.buttonDestinationHomePageBodyDorduncuDestinationIkonunaTiklanincaAcilanSagButton.isEnabled());
        Assert.assertTrue(tawUserHomePage.buttonDestinationHomePageBodyDorduncuDestinationIkonunaTiklanincaAcilanSolButton.isDisplayed());
        Assert.assertTrue(tawUserHomePage.buttonDestinationHomePageBodyDorduncuDestinationIkonunaTiklanincaAcilanSolButton.isEnabled());

        // 8. açılan sayfada close ikonunun göründüğünü ve erişilebilir olduğunu doğrula
        Assert.assertTrue(tawUserHomePage.iconDestinationHomePageBodyDorduncuDestinationIkonunaTiklanincaAcilanCloseIcon.isDisplayed());
        Assert.assertTrue(tawUserHomePage.iconDestinationHomePageBodyDorduncuDestinationIkonunaTiklanincaAcilanCloseIcon.isEnabled());

        // 9. açılan sayfada fotoğrafın altında text'in "4 of 6"  olduğunu doğrula
        String expectedSayiText = ConfigReader.getProperty("homePageBodyDestinationsDorduncuDestinationSayiText");
        String actualSayiText = tawUserHomePage.labelDestinationHomePageBodyDorduncuDestinationIkonunaTiklanincaAcilanSayiTexti.getText();

        Assert.assertEquals(expectedSayiText,actualSayiText);
        Assert.assertTrue(tawUserHomePage.labelDestinationHomePageBodyDorduncuDestinationIkonunaTiklanincaAcilanSayiTexti.isDisplayed());

        // 10. dördüncü varış noktasının başlığına tıklandığında ilgili sayfanın' title'ının "Marrakesh, Morocco" olduğunu doğrula
        tawUserHomePage.iconDestinationHomePageBodyDorduncuDestinationIkonunaTiklanincaAcilanCloseIcon.click();
        tawUserHomePage.labelHomePageDestinationsDorduncuDestinationBaslikTexti.click();

        String expectedPageTitle = ConfigReader.getProperty("marrakeshMoroccoPageTitle");
        String actualPageTitle = Driver.getDriver().getTitle();

        Assert.assertEquals(expectedPageTitle,actualPageTitle);

        Driver.quitDriver();
    }

    @Test(priority = 6)
    public void us_003_tc_29(){
        // 1. browser'ı aç
        // 2. https://qa.tripandway.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("tawUrl"));
        TawUserHomePage tawUserHomePage = new TawUserHomePage();
        Actions actions = new Actions(Driver.getDriver());
        for (int i = 0; i < 65; i++) {
            actions.sendKeys(Keys.ARROW_DOWN).perform();
        }
        ReusableMethods.wait(2);

        // 3. başlığının "Salina Island, Italy" olduğunu ve göründüğünü doğrula
        String expectedBesinciDestinationTitle = ConfigReader.getProperty("homePageBodyDestinationsBesinciDestinationTitle");
        String actualBesinciDestinationTitle = tawUserHomePage.labelHomePageDestinationsBesinciDestinationBaslikTexti.getText();

        Assert.assertEquals(expectedBesinciDestinationTitle,actualBesinciDestinationTitle);
        Assert.assertTrue(tawUserHomePage.labelHomePageDestinationsBesinciDestinationBaslikTexti.isDisplayed());

        // 4. beşinci varış noktasına mause'u götürdüğümde yakınlaştır ikonunun göründüğünü ve erişilebilir olduğunu doğrula
        actions.moveToElement(tawUserHomePage.homepageBodyBesinciDestination).perform();
        Assert.assertTrue(tawUserHomePage.iconHomePageBodyDestinationsBesinciDestinationIcon.isDisplayed());
        Assert.assertTrue(tawUserHomePage.iconHomePageBodyDestinationsBesinciDestinationIcon.isEnabled());

        // 5. yakınlaştır ikonuna tıklandığında açılan sayfada fotoğrafın göründüğünü erişilebilir olduğunu doğrula
        tawUserHomePage.iconHomePageBodyDestinationsBesinciDestinationIcon.click();
        Assert.assertTrue(tawUserHomePage.imageDestinationHomePageBodyBesinciDestinationIkonunaTiklanincaAcilanImage.isDisplayed());
        Assert.assertTrue(tawUserHomePage.imageDestinationHomePageBodyBesinciDestinationIkonunaTiklanincaAcilanImage.isEnabled());

        // 6.  beşinci varış noktasındaki fotoğraf ile aynı olduğunu doğrula
        String expectedImage = tawUserHomePage
                .imageDestinationHomePageBodyBesinciDestinationIkonunaTiklanincaAcilanImage.getAttribute("src");
        String actualImage = tawUserHomePage.imageDestinationHomePageBodyBesinciDestinationImage.getAttribute("src");

        Assert.assertEquals(expectedImage,actualImage);

        // 7. açılan sayfada sağa ve sola git okunun göründüğünü ve erişilebilir olduğunu doğrula
        Assert.assertTrue(tawUserHomePage.buttonDestinationHomePageBodyBesinciDestinationIkonunaTiklanincaAcilanSagButton.isDisplayed());
        Assert.assertTrue(tawUserHomePage.buttonDestinationHomePageBodyBesinciDestinationIkonunaTiklanincaAcilanSagButton.isEnabled());
        Assert.assertTrue(tawUserHomePage.buttonDestinationHomePageBodyBesinciDestinationIkonunaTiklanincaAcilanSolButton.isDisplayed());
        Assert.assertTrue(tawUserHomePage.buttonDestinationHomePageBodyBesinciDestinationIkonunaTiklanincaAcilanSolButton.isEnabled());

        // 8. açılan sayfada close ikonunun göründüğünü ve erişilebilir olduğunu doğrula
        Assert.assertTrue(tawUserHomePage.iconDestinationHomePageBodyBesinciDestinationIkonunaTiklanincaAcilanCloseIcon.isDisplayed());
        Assert.assertTrue(tawUserHomePage.iconDestinationHomePageBodyBesinciDestinationIkonunaTiklanincaAcilanCloseIcon.isEnabled());

        // 9. açılan sayfada fotoğrafın altında text'in "5 of 6"  olduğunu doğrula
        String expectedSayiText = ConfigReader.getProperty("homePageBodyDestinationsBesinciDestinationSayiText");
        String actualSayiText = tawUserHomePage.labelDestinationHomePageBodyBesinciDestinationIkonunaTiklanincaAcilanSayiTexti.getText();

        Assert.assertEquals(expectedSayiText,actualSayiText);
        Assert.assertTrue(tawUserHomePage.labelDestinationHomePageBodyBesinciDestinationIkonunaTiklanincaAcilanSayiTexti.isDisplayed());

        // 10. beşinci varış noktasının başlığına tıklandığında ilgili sayfanın' title'ının "Salina Island, Italy" olduğunu doğrula
        tawUserHomePage.iconDestinationHomePageBodyBesinciDestinationIkonunaTiklanincaAcilanCloseIcon.click();
        tawUserHomePage.labelHomePageDestinationsBesinciDestinationBaslikTexti.click();

        String expectedPageTitle = ConfigReader.getProperty("salinaIslandItalyPageTitle");
        String actualPageTitle = Driver.getDriver().getTitle();

        Assert.assertEquals(expectedPageTitle,actualPageTitle);

        Driver.quitDriver();
    }

    @Test(priority = 7)
    public void us_003_tc_30(){
        // 1. browser'ı aç
        // 2. https://qa.tripandway.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("tawUrl"));
        TawUserHomePage tawUserHomePage = new TawUserHomePage();
        Actions actions = new Actions(Driver.getDriver());
        for (int i = 0; i < 65; i++) {
            actions.sendKeys(Keys.ARROW_DOWN).perform();
        }
        ReusableMethods.wait(2);

        // 3. başlığının "Istanbul, Turkey" olduğunu ve göründüğünü doğrula
        String expectedAltinciDestinationTitle = ConfigReader.getProperty("homePageBodyDestinationsAltinciDestinationTitle");
        String actualAltinciDestinationTitle = tawUserHomePage.labelHomePageDestinationsAltinciDestinationBaslikTexti.getText();

        Assert.assertEquals(expectedAltinciDestinationTitle,actualAltinciDestinationTitle);
        Assert.assertTrue(tawUserHomePage.labelHomePageDestinationsAltinciDestinationBaslikTexti.isDisplayed());

        // 4. altıncı varış noktasına mause'u götürdüğümde yakınlaştır ikonunun göründüğünü ve erişilebilir olduğunu doğrula
        actions.moveToElement(tawUserHomePage.homepageBodyAltinciDestination).perform();
        Assert.assertTrue(tawUserHomePage.iconHomePageBodyDestinationsAltinciDestinationIcon.isDisplayed());
        Assert.assertTrue(tawUserHomePage.iconHomePageBodyDestinationsAltinciDestinationIcon.isEnabled());

        // 5. yakınlaştır ikonuna tıklandığında açılan sayfada fotoğrafın göründüğünü erişilebilir olduğunu doğrula
        tawUserHomePage.iconHomePageBodyDestinationsAltinciDestinationIcon.click();
        Assert.assertTrue(tawUserHomePage.imageDestinationHomePageBodyAltinciDestinationIkonunaTiklanincaAcilanImage.isDisplayed());
        Assert.assertTrue(tawUserHomePage.imageDestinationHomePageBodyAltinciDestinationIkonunaTiklanincaAcilanImage.isEnabled());

        // 6.  altıncı varış noktasındaki fotoğraf ile aynı olduğunu doğrula
        String expectedImage = tawUserHomePage
                .imageDestinationHomePageBodyAltinciDestinationIkonunaTiklanincaAcilanImage.getAttribute("src");
        String actualImage = tawUserHomePage.imageDestinationHomePageBodyAltinciDestinationImage.getAttribute("src");

        Assert.assertEquals(expectedImage,actualImage);

        // 7. açılan sayfada sağa ve sola git okunun göründüğünü ve erişilebilir olduğunu doğrula
        Assert.assertTrue(tawUserHomePage.buttonDestinationHomePageBodyAltinciDestinationIkonunaTiklanincaAcilanSagButton.isDisplayed());
        Assert.assertTrue(tawUserHomePage.buttonDestinationHomePageBodyAltinciDestinationIkonunaTiklanincaAcilanSagButton.isEnabled());
        Assert.assertTrue(tawUserHomePage.buttonDestinationHomePageBodyAltinciDestinationIkonunaTiklanincaAcilanSolButton.isDisplayed());
        Assert.assertTrue(tawUserHomePage.buttonDestinationHomePageBodyAltinciDestinationIkonunaTiklanincaAcilanSolButton.isEnabled());

        // 8. açılan sayfada close ikonunun göründüğünü ve erişilebilir olduğunu doğrula
        Assert.assertTrue(tawUserHomePage.iconDestinationHomePageBodyAltinciDestinationIkonunaTiklanincaAcilanCloseIcon.isDisplayed());
        Assert.assertTrue(tawUserHomePage.iconDestinationHomePageBodyAltinciDestinationIkonunaTiklanincaAcilanCloseIcon.isEnabled());

        // 9. açılan sayfada fotoğrafın altında text'in "6 of 6"  olduğunu doğrula
        String expectedSayiText = ConfigReader.getProperty("homePageBodyDestinationsAltinciDestinationSayiText");
        String actualSayiText = tawUserHomePage.labelDestinationHomePageBodyAltinciDestinationIkonunaTiklanincaAcilanSayiTexti.getText();

        Assert.assertEquals(expectedSayiText,actualSayiText);
        Assert.assertTrue(tawUserHomePage.labelDestinationHomePageBodyAltinciDestinationIkonunaTiklanincaAcilanSayiTexti.isDisplayed());

        // 10. altıncı varış noktasının başlığına tıklandığında ilgili sayfanın' title'ının "Istanbul, Turkey" olduğunu doğrula
        tawUserHomePage.iconDestinationHomePageBodyAltinciDestinationIkonunaTiklanincaAcilanCloseIcon.click();
        tawUserHomePage.labelHomePageDestinationsAltinciDestinationBaslikTexti.click();

        String expectedPageTitle = ConfigReader.getProperty("IstanbulTurkeyPageTitle");
        String actualPageTitle = Driver.getDriver().getTitle();

        Assert.assertEquals(expectedPageTitle,actualPageTitle);

        Driver.quitDriver();
    }

    @Test(priority = 8)
    public void us_003_tc_31(){
        // 1. browser'ı aç
        // 2. https://qa.tripandway.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("tawUrl"));
        TawUserHomePage tawUserHomePage = new TawUserHomePage();
        Actions actions = new Actions(Driver.getDriver());
        for (int i = 0; i < 65; i++) {
            actions.sendKeys(Keys.ARROW_DOWN).perform();
        }
        ReusableMethods.wait(2);

        // 3. See All Destinations buttonunun görünür ve erişilebilir olduğunu doğrula
        Assert.assertTrue(tawUserHomePage.buttonHomePageBodySeeAllDestinationsButton.isDisplayed());
        Assert.assertTrue(tawUserHomePage.buttonHomePageBodySeeAllDestinationsButton.isEnabled());

        // 4. See All Destinations buttonuna tıklandığında ilgili sayfanın title'ının "Destinations" olduğunu doğrula
        tawUserHomePage.buttonHomePageBodySeeAllDestinationsButton.click();
        String expectedTitle = ConfigReader.getProperty("destinationsPageTitle");
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertEquals(expectedTitle,actualTitle);

        Driver.quitDriver();

    }

}
