package tests.aziz_US_001_003_004_012;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TawUserHomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C08_US_003_HomePageTestimonial {
    // US_003 >>> Bir ziyaretçi olarak Home page sayfasının body bölümündeki fonksiyonların
    // görünür ve aktif olduğunu görüntüleyebildiğimi doğrulayabilmeliyim

    @Test(priority = 1)
    public void us_003_tc_37(){
        // 1. browser'ı aç
        // 2. https://qa.tripandway.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("tawUrl"));
        TawUserHomePage tawUserHomePage = new TawUserHomePage();
        Actions actions = new Actions(Driver.getDriver());
        for (int i = 0; i < 98; i++) {
            actions.sendKeys(Keys.ARROW_DOWN).perform();
        }
        ReusableMethods.wait(1);

        // 3. TESTIMONIAL kısmının görünür olduğunu doğrula
        Assert.assertTrue(tawUserHomePage.homePageBodyTestimonialAlani.isDisplayed());

        // 4. Başlığının "Testimonial" olduğunu ve görünür olduğunu doğrula
        String expectedTitle = ConfigReader.getProperty("homePageBodyTestimonialTitle");
        String actualTitle = tawUserHomePage.labelHomePageBodyTestimonialBaslikTexti.getText();

        Assert.assertEquals(expectedTitle,actualTitle);
        Assert.assertTrue(tawUserHomePage.labelHomePageBodyTestimonialBaslikTexti.isDisplayed());

        // 5. başlığın altındaki açıklama text'inin görünür olduğunu doğrula
        Assert.assertTrue(tawUserHomePage.labelHomePageBodyTestimonialAciklamaTexti.isDisplayed());

        // 6. TESTIMONIAL kısmının altındaki radio buttonlarının görünür ve erişilebilir olduğunu doğrula
        for (WebElement each : tawUserHomePage.radioButtonHomePageBodyTestimonialButunRadioButtonlar){
            Assert.assertTrue(each.isDisplayed());
            Assert.assertTrue(each.isEnabled());
        }

        Driver.quitDriver();
    }

    @Test(priority = 2)
    public void us_003_tc_38(){
        // 1. browser'ı aç
        // 2. https://qa.tripandway.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("tawUrl"));
        TawUserHomePage tawUserHomePage = new TawUserHomePage();
        Actions actions = new Actions(Driver.getDriver());
        for (int i = 0; i < 98; i++) {
            actions.sendKeys(Keys.ARROW_DOWN).perform();
        }
        ReusableMethods.wait(1);

        // 3. birinci üyenin fotoğrafının göründüğünü doğrula
        Assert.assertTrue(tawUserHomePage.imageProfileHomePageBodyTestimonialBirinciUyeImage.isDisplayed());

        // 4. adının "Johnson Shealey" olduğunu ve göründüğünü doğrula
        String expectedIsim = ConfigReader.getProperty("homePageBodyTestimonialBirinciUyeIsim");
        String actualIsim = tawUserHomePage.labelHomePageBodyTestimonialBirinciUyeIsimTexti.getText();

        Assert.assertEquals(expectedIsim,actualIsim);
        Assert.assertTrue(tawUserHomePage.labelHomePageBodyTestimonialBirinciUyeIsimTexti.isDisplayed());

        // 5. görevinin "Information Technology Manager" olduğunu ve göründüğünü doğrula
        String expectedGorev = ConfigReader.getProperty("homePageBodyTestimonialBirinciUyeGorev");
        String actualGorev = tawUserHomePage.labelHomePageBodyTestimonialBirinciUyeGorevTexti.getText();

        Assert.assertEquals(expectedGorev,actualGorev);
        Assert.assertTrue(tawUserHomePage.labelHomePageBodyTestimonialBirinciUyeGorevTexti.isDisplayed());

        // 6. görevin altında bulunan açıklama text'inin göründüğünü doğrula
        Assert.assertTrue(tawUserHomePage.labelHomePageBodyTestimonialBirinciUyeAciklamaTexti.isDisplayed());

        Driver.quitDriver();
    }

    @Test(priority = 3)
    public void us_003_tc_39(){
        // 1. browser'ı aç
        // 2. https://qa.tripandway.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("tawUrl"));
        TawUserHomePage tawUserHomePage = new TawUserHomePage();
        Actions actions = new Actions(Driver.getDriver());
        for (int i = 0; i < 98; i++) {
            actions.sendKeys(Keys.ARROW_DOWN).perform();
        }
        ReusableMethods.wait(1);
        tawUserHomePage.radiButtonHomePageBoydTestimonialIkinciRadioButton.click();
        ReusableMethods.wait(1);

        // 3. ikinci üyenin fotoğrafının göründüğünü doğrula
        Assert.assertTrue(tawUserHomePage.imageProfileHomePageBodyTestimonialIkinciUyeImage.isDisplayed());

        // 4. adının "Dadiv Smith" olduğunu ve göründüğünü doğrula
        String expectedIsim = ConfigReader.getProperty("homePageBodyTestimonialIkinciUyeIsim");
        String actualIsim = tawUserHomePage.labelHomePageBodyTestimonialIkinciUyeIsimTexti.getText();

        Assert.assertEquals(expectedIsim,actualIsim);
        Assert.assertTrue(tawUserHomePage.labelHomePageBodyTestimonialIkinciUyeIsimTexti.isDisplayed());

        // 5. görevinin "CEO" olduğunu ve göründüğünü doğrula
        String expectedGorev = ConfigReader.getProperty("homePageBodyTestimonialIkinciUyeGorev");
        String actualGorev = tawUserHomePage.labelHomePageBodyTestimonialIkinciUyeGorevTexti.getText();

        Assert.assertEquals(expectedGorev,actualGorev);
        Assert.assertTrue(tawUserHomePage.labelHomePageBodyTestimonialIkinciUyeGorevTexti.isDisplayed());

        // 6. görevin altında bulunan açıklama text'inin göründüğünü doğrula
        Assert.assertTrue(tawUserHomePage.labelHomePageBodyTestimonialIkinciUyeAciklamaTexti.isDisplayed());

        Driver.quitDriver();
    }

    @Test(priority = 4)
    public void us_003_tc_40(){
        // 1. browser'ı aç
        // 2. https://qa.tripandway.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("tawUrl"));
        TawUserHomePage tawUserHomePage = new TawUserHomePage();
        Actions actions = new Actions(Driver.getDriver());
        for (int i = 0; i < 98; i++) {
            actions.sendKeys(Keys.ARROW_DOWN).perform();
        }
        ReusableMethods.wait(1);
        tawUserHomePage.radiButtonHomePageBoydTestimonialUcuncuRadioButton.click();
        ReusableMethods.wait(1);

        // 3. üçüncü üyenin fotoğrafının göründüğünü doğrula
        Assert.assertTrue(tawUserHomePage.imageProfileHomePageBodyTestimonialUcuncuUyeImage.isDisplayed());

        // 4. adının "Stefen Carman" olduğunu ve göründüğünü doğrula
        String expectedIsim = ConfigReader.getProperty("homePageBodyTestimonialUcuncuUyeIsim");
        String actualIsim = tawUserHomePage.labelHomePageBodyTestimonialUcuncuUyeIsimTexti.getText();

        Assert.assertEquals(expectedIsim,actualIsim);
        Assert.assertTrue(tawUserHomePage.labelHomePageBodyTestimonialUcuncuUyeIsimTexti.isDisplayed());

        // 5. görevinin "Marketing Manager" olduğunu ve göründüğünü doğrula
        String expectedGorev = ConfigReader.getProperty("homePageBodyTestimonialUcuncuUyeGorev");
        String actualGorev = tawUserHomePage.labelHomePageBodyTestimonialUcuncuUyeGorevTexti.getText();

        Assert.assertEquals(expectedGorev,actualGorev);
        Assert.assertTrue(tawUserHomePage.labelHomePageBodyTestimonialUcuncuUyeGorevTexti.isDisplayed());

        // 6. görevin altında bulunan açıklama text'inin göründüğünü doğrula
        Assert.assertTrue(tawUserHomePage.labelHomePageBodyTestimonialUcuncuUyeAciklamaTexti.isDisplayed());

        Driver.quitDriver();
    }

    @Test(priority = 5)
    public void us_003_tc_41(){
        // 1. browser'ı aç
        // 2. https://qa.tripandway.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("tawUrl"));
        TawUserHomePage tawUserHomePage = new TawUserHomePage();
        Actions actions = new Actions(Driver.getDriver());
        for (int i = 0; i < 98; i++) {
            actions.sendKeys(Keys.ARROW_DOWN).perform();
        }
        ReusableMethods.wait(1);
        tawUserHomePage.radiButtonHomePageBoydTestimonialDorduncuRadioButton.click();
        ReusableMethods.wait(1);

        // 3. dördüncü üyenin fotoğrafının göründüğünü doğrula
        Assert.assertTrue(tawUserHomePage.imageProfileHomePageBodyTestimonialDorduncuUyeImage.isDisplayed());

        // 4. adının "Jessica Rainy" olduğunu ve göründüğünü doğrula
        String expectedIsim = ConfigReader.getProperty("homePageBodyTestimonialDorduncuUyeIsim");
        String actualIsim = tawUserHomePage.labelHomePageBodyTestimonialDorduncuUyeIsimTexti.getText();

        Assert.assertEquals(expectedIsim,actualIsim);
        Assert.assertTrue(tawUserHomePage.labelHomePageBodyTestimonialDorduncuUyeIsimTexti.isDisplayed());

        // 5. görevinin "Project Manager" olduğunu ve göründüğünü doğrula
        String expectedGorev = ConfigReader.getProperty("homePageBodyTestimonialDorduncuUyeGorev");
        String actualGorev = tawUserHomePage.labelHomePageBodyTestimonialDorduncuUyeGorevTexti.getText();

        Assert.assertEquals(expectedGorev,actualGorev);
        Assert.assertTrue(tawUserHomePage.labelHomePageBodyTestimonialDorduncuUyeGorevTexti.isDisplayed());

        // 6. görevin altında bulunan açıklama text'inin göründüğünü doğrula
        Assert.assertTrue(tawUserHomePage.labelHomePageBodyTestimonialDorduncuUyeAciklamaTexti.isDisplayed());

        Driver.quitDriver();
    }

}
