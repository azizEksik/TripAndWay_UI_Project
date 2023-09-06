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

import java.util.Set;

public class C07_US_003_HomePageTeamMembers {


    // US_003 >>> Bir ziyaretçi olarak Home page sayfasının body bölümündeki fonksiyonların
    // görünür ve aktif olduğunu görüntüleyebildiğimi doğrulayabilmeliyim

    @Test(priority = 1)
    public void us_003_tc_32(){
        // 1. browser'ı aç
        // 2. https://qa.tripandway.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("tawUrl"));
        TawUserHomePage tawUserHomePage = new TawUserHomePage();
        Actions actions = new Actions(Driver.getDriver());
        for (int i = 0; i < 85; i++) {
            actions.sendKeys(Keys.ARROW_DOWN).perform();
        }
        ReusableMethods.wait(1);

        // 3. TEAM MEMBERS kısmının görünür olduğunu doğrula
        Assert.assertTrue(tawUserHomePage.homePageBodyTeamMembersAlani.isDisplayed());

        // 4. Başlığının "Team Members"  olduğunu ve  görünür olduğunu doğrula
        String expectedTitle = ConfigReader.getProperty("homePageBodyTeamMembersTitle");
        String actualTitle = tawUserHomePage.labelHomePageBodyTeamMembersBaslikTexti.getText();

        Assert.assertEquals(expectedTitle,actualTitle);
        Assert.assertTrue(tawUserHomePage.labelHomePageBodyTeamMembersBaslikTexti.isDisplayed());

        // 5. başlığın altındaki text'in görünür olduğunu doğrula
        Assert.assertTrue(tawUserHomePage.labelHomePageBodyTeamMembersAciklamaTexti.isDisplayed());

        Driver.quitDriver();

    }

    @Test(priority = 2)
    public void us_003_tc_33(){
        // 1. browser'ı aç
        // 2. https://qa.tripandway.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("tawUrl"));
        TawUserHomePage tawUserHomePage = new TawUserHomePage();
        Actions actions = new Actions(Driver.getDriver());
        for (int i = 0; i < 85; i++) {
            actions.sendKeys(Keys.ARROW_DOWN).perform();
        }

        // 3. birinci takım üyesinin görünür olduğunu doğrula
        Assert.assertTrue(tawUserHomePage.homePageBodyTeamMembersBirinciUye.isDisplayed());

        // 4. isminin "Knox Mitchell" olduğunu ve görünür olduğunu doğrula
        String expectedIsim = ConfigReader.getProperty("homePageBodyTeamMembersBirinciUyeIsim");
        String actualIsim = tawUserHomePage.labelHomePageBodyTeamMembersBirinciUyeIsimTexti.getText();

        Assert.assertEquals(expectedIsim,actualIsim);
        Assert.assertTrue(tawUserHomePage.labelHomePageBodyTeamMembersBirinciUyeIsimTexti.isDisplayed());

        // 5. görevinin "Founder" olduğunu ve görünür olduğunu doğrula
        String expectedGorev = ConfigReader.getProperty("homePageBodyTeamMembersBirinciUyeGorev");
        String actualGorev = tawUserHomePage.labelHomePageBodyTeamMembersBirinciUyeGorevTexti.getText();

        Assert.assertEquals(expectedGorev,actualGorev);
        Assert.assertTrue(tawUserHomePage.labelHomePageBodyTeamMembersBirinciUyeGorevTexti.isDisplayed());

        // 6. isim ve görev kutusunun görünür ve erişilebilir olduğunu doğrula
        Assert.assertTrue(tawUserHomePage.labelHomePageBodyTeamMembersBirinciUyeIsimVeGorevKutusu.isDisplayed());
        Assert.assertTrue(tawUserHomePage.labelHomePageBodyTeamMembersBirinciUyeIsimVeGorevKutusu.isEnabled());

        // 7. isim ve görev kutusuna tıklandığında ilgili sayfanın title'ının "Knox Mitchell" olduğunu doğrula
        tawUserHomePage.labelHomePageBodyTeamMembersBirinciUyeIsimVeGorevKutusu.click();
        String expectedTeamMembersPagetitle = ConfigReader.getProperty("knoxmitchellPageTitle");
        String actualTeamMembersPagetitle = Driver.getDriver().getTitle();

        Assert.assertEquals(expectedTeamMembersPagetitle,actualTeamMembersPagetitle);

        // 8. bir önceki sayfaya  geri dön
        Driver.getDriver().navigate().back();

        // 9. mause birinci takım üyesinin üstüne götürüldüğünde facebook-twitter-linedin ikonunun görünür ve erişilebilir olduğunu doğrula
        actions.moveToElement(tawUserHomePage.homePageBodyTeamMembersBirinciUye).perform();
        for (WebElement each : tawUserHomePage.iconHomePageBodyTeamMembersBirinciUyeTumIconlar){
            Assert.assertTrue(each.isDisplayed());
            Assert.assertTrue(each.isEnabled());
        }

        // 10. facebook ikonuna tıklandığında ilgili sayfanın Url'inin "facebook" içerdiğini doğrula
        String homePageWindowHandle = Driver.getDriver().getWindowHandle();
        actions.moveToElement(tawUserHomePage.homePageBodyTeamMembersBirinciUye).perform();
        tawUserHomePage.iconHomePageBodyTeamMembersBirinciUyeFacebookIcon.click();

        Set<String> windowHandleSet = Driver.getDriver().getWindowHandles();
        String facebookWindowHandle = "";
        for (String each : windowHandleSet){
            if (!each.equals(homePageWindowHandle)){
                facebookWindowHandle = each;
            }
        }

        Driver.getDriver().switchTo().window(facebookWindowHandle);
        String expectedFacebookUrl = ConfigReader.getProperty("facebookUrl");
        String actulaFacebookUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actulaFacebookUrl.contains(expectedFacebookUrl));
        Driver.getDriver().switchTo().window(facebookWindowHandle).close();
        Driver.getDriver().switchTo().window(homePageWindowHandle);

        // 11. twitter ikonuna tıklandığında ilgili sayfanın url'inin "twitter" içerdiğini doğrula
        actions.moveToElement(tawUserHomePage.homePageBodyTeamMembersBirinciUye).perform();
        tawUserHomePage.iconHomePageBodyTeamMembersBirinciUyeTwitterIcon.click();

        windowHandleSet = Driver.getDriver().getWindowHandles();
        String twitterWindowHandle = "";
        for (String each : windowHandleSet){
            if (!each.equals(homePageWindowHandle) && !each.equals(facebookWindowHandle)){
                twitterWindowHandle = each;
            }
        }

        Driver.getDriver().switchTo().window(twitterWindowHandle);
        String expectedTwitterUrl = ConfigReader.getProperty("twitterUrl");
        String actualTwitterUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actualTwitterUrl.contains(expectedTwitterUrl));
        Driver.getDriver().switchTo().window(twitterWindowHandle).close();
        Driver.getDriver().switchTo().window(homePageWindowHandle);

        // 12. linkedin ikonuna tıklandığında ilgili sayfanın Url'inin "linkedin" içerdiğini doğrula
        actions.moveToElement(tawUserHomePage.homePageBodyTeamMembersBirinciUye).perform();
        tawUserHomePage.iconHomePageBodyTeamMembersBirinciUyeLinkedInIcon.click();

        windowHandleSet = Driver.getDriver().getWindowHandles();
        String linkedInWindowHandle = "";
        for (String each : windowHandleSet){
            if (!each.equals(homePageWindowHandle) && !each.equals(facebookWindowHandle) && !each.equals(twitterWindowHandle)){
                linkedInWindowHandle = each;
            }
        }

        Driver.getDriver().switchTo().window(linkedInWindowHandle);
        String expectedKLinkedInTitle = ConfigReader.getProperty("linkedInUrl");
        String actualLinkedInTitle = Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actualLinkedInTitle.contains(expectedKLinkedInTitle));

        Driver.getDriver().switchTo().window(linkedInWindowHandle).close();
        Driver.getDriver().switchTo().window(homePageWindowHandle);

        Driver.quitDriver();
    }

    @Test(priority = 3)
    public void us_003_tc_34(){

        // 1. browser'ı aç
        // 2. https://qa.tripandway.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("tawUrl"));
        TawUserHomePage tawUserHomePage = new TawUserHomePage();
        Actions actions = new Actions(Driver.getDriver());
        for (int i = 0; i < 85; i++) {
            actions.sendKeys(Keys.ARROW_DOWN).perform();
        }
        ReusableMethods.wait(1);

        // 3. ikinci takım üyesinin görünür olduğunu doğrula
        Assert.assertTrue(tawUserHomePage.homePageBodyTeamMembersIkinciUye.isDisplayed());

        // 4. isminin "Zara Williams" olduğunu ve görünür olduğunu doğrula
        String expectedIsim = ConfigReader.getProperty("homePageBodyTeamMembersIkinciUyeIsim");
        String actualIsim = tawUserHomePage.labelHomePageBodyTeamMembersIkinciUyeIsimTexti.getText();

        Assert.assertEquals(expectedIsim,actualIsim);
        Assert.assertTrue(tawUserHomePage.labelHomePageBodyTeamMembersIkinciUyeIsimTexti.isDisplayed());

        // 5. görevinin "Chairman" olduğunu ve görünür olduğunu doğrula
        String expectedGorev = ConfigReader.getProperty("homePageBodyTeamMembersIkinciUyeGorev");
        String actualGorev = tawUserHomePage.labelHomePageBodyTeamMembersIkinciUyeGorevTexti.getText();

        Assert.assertEquals(expectedGorev,actualGorev);
        Assert.assertTrue(tawUserHomePage.labelHomePageBodyTeamMembersIkinciUyeGorevTexti.isDisplayed());

        // 6. isim ve görev kutusunun görünür ve erişilebilir olduğunu doğrula
        Assert.assertTrue(tawUserHomePage.labelHomePageBodyTeamMembersIkinciUyeIsimVeGorevKutusu.isDisplayed());
        Assert.assertTrue(tawUserHomePage.labelHomePageBodyTeamMembersIkinciUyeIsimVeGorevKutusu.isEnabled());

        // 7. isim ve görev kutusuna tıklandığında ilgili sayfanın title'ının "Zara Williams" olduğunu doğrula
        tawUserHomePage.labelHomePageBodyTeamMembersIkinciUyeIsimVeGorevKutusu.click();
        String expectedTeamMembersPagetitle = ConfigReader.getProperty("zaraWilliamsPageTitle");
        String actualTeamMembersPagetitle = Driver.getDriver().getTitle();

        Assert.assertEquals(expectedTeamMembersPagetitle,actualTeamMembersPagetitle);

        // 8. bir önceki sayfaya  geri dön
        Driver.getDriver().navigate().back();

        // 9. mause ikinci takım üyesinin üstüne götürüldüğünde facebook-twitter-linedin ikonunun görünür ve erişilebilir olduğunu doğrula
        actions.moveToElement(tawUserHomePage.homePageBodyTeamMembersIkinciUye).perform();
        for (WebElement each : tawUserHomePage.iconHomePageBodyTeamMembersIkinciUyeTumIconlar){
            Assert.assertTrue(each.isDisplayed());
            Assert.assertTrue(each.isEnabled());
        }

        // 10. facebook ikonuna tıklandığında ilgili sayfanın Url'inin "facebook" içerdiğini doğrula
        String homePageWindowHandle = Driver.getDriver().getWindowHandle();
        actions.moveToElement(tawUserHomePage.homePageBodyTeamMembersIkinciUye).perform();
        tawUserHomePage.iconHomePageBodyTeamMembersIkinciUyeFacebookIcon.click();

        Set<String> windowHandleSet = Driver.getDriver().getWindowHandles();
        String facebookWindowHandle = "";
        for (String each : windowHandleSet){
            if (!each.equals(homePageWindowHandle)){
                facebookWindowHandle = each;
            }
        }

        Driver.getDriver().switchTo().window(facebookWindowHandle);
        String expectedFacebookUrl = ConfigReader.getProperty("facebookUrl");
        String actulaFacebookUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actulaFacebookUrl.contains(expectedFacebookUrl));
        Driver.getDriver().switchTo().window(facebookWindowHandle).close();
        Driver.getDriver().switchTo().window(homePageWindowHandle);

        // 11. twitter ikonuna tıklandığında ilgili sayfanın url'inin "twitter" içerdiğini doğrula
        actions.moveToElement(tawUserHomePage.homePageBodyTeamMembersIkinciUye).perform();
        tawUserHomePage.iconHomePageBodyTeamMembersIkinciUyeTwitterIcon.click();

        windowHandleSet = Driver.getDriver().getWindowHandles();
        String twitterWindowHandle = "";
        for (String each : windowHandleSet){
            if (!each.equals(homePageWindowHandle) && !each.equals(facebookWindowHandle)){
                twitterWindowHandle = each;
            }
        }

        Driver.getDriver().switchTo().window(twitterWindowHandle);
        String expectedTwitterUrl = ConfigReader.getProperty("twitterUrl");
        String actualTwitterUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actualTwitterUrl.contains(expectedTwitterUrl));
        Driver.getDriver().switchTo().window(twitterWindowHandle).close();
        Driver.getDriver().switchTo().window(homePageWindowHandle);

        // 12. linkedin ikonuna tıklandığında ilgili sayfanın Url'inin "linkedin" içerdiğini doğrula
        actions.moveToElement(tawUserHomePage.homePageBodyTeamMembersIkinciUye).perform();
        tawUserHomePage.iconHomePageBodyTeamMembersIkinciUyeLinkedInIcon.click();

        windowHandleSet = Driver.getDriver().getWindowHandles();
        String linkedInWindowHandle = "";
        for (String each : windowHandleSet){
            if (!each.equals(homePageWindowHandle) && !each.equals(facebookWindowHandle) && !each.equals(twitterWindowHandle)){
                linkedInWindowHandle = each;
            }
        }

        Driver.getDriver().switchTo().window(linkedInWindowHandle);
        String expectedKLinkedInTitle = ConfigReader.getProperty("linkedInUrl");
        String actualLinkedInTitle = Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actualLinkedInTitle.contains(expectedKLinkedInTitle));

        Driver.getDriver().switchTo().window(linkedInWindowHandle).close();
        Driver.getDriver().switchTo().window(homePageWindowHandle);

        Driver.quitDriver();
    }

    @Test(priority = 4)
    public void us_003_tc_35(){
        // 1. browser'ı aç
        // 2. https://qa.tripandway.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("tawUrl"));
        TawUserHomePage tawUserHomePage = new TawUserHomePage();
        Actions actions = new Actions(Driver.getDriver());
        for (int i = 0; i < 85; i++) {
            actions.sendKeys(Keys.ARROW_DOWN).perform();
        }
        ReusableMethods.wait(1);

        // 3. üçüncü takım üyesinin görünür olduğunu doğrula
        Assert.assertTrue(tawUserHomePage.homePageBodyTeamMembersUcuncuUye.isDisplayed());

        // 4. isminin "Jaxon Green" olduğunu ve görünür olduğunu doğrula
        String expectedIsim = ConfigReader.getProperty("homePageBodyTeamMembersUcuncuUyeIsim");
        String actualIsim = tawUserHomePage.labelHomePageBodyTeamMembersUcuncuUyeIsimTexti.getText();

        Assert.assertEquals(expectedIsim,actualIsim);
        Assert.assertTrue(tawUserHomePage.labelHomePageBodyTeamMembersUcuncuUyeIsimTexti.isDisplayed());

        // 5. görevinin "Executive Office" olduğunu ve görünür olduğunu doğrula
        String expectedGorev = ConfigReader.getProperty("homePageBodyTeamMembersUcuncuUyeGorev");
        String actualGorev = tawUserHomePage.labelHomePageBodyTeamMembersUcuncuUyeGorevTexti.getText();

        Assert.assertEquals(expectedGorev,actualGorev);
        Assert.assertTrue(tawUserHomePage.labelHomePageBodyTeamMembersUcuncuUyeGorevTexti.isDisplayed());

        // 6. isim ve görev kutusunun görünür ve erişilebilir olduğunu doğrula
        Assert.assertTrue(tawUserHomePage.labelHomePageBodyTeamMembersUcuncuUyeIsimVeGorevKutusu.isDisplayed());
        Assert.assertTrue(tawUserHomePage.labelHomePageBodyTeamMembersUcuncuUyeIsimVeGorevKutusu.isEnabled());

        // 7. isim ve görev kutusuna tıklandığında ilgili sayfanın title'ının "Jaxon Green" olduğunu doğrula
        tawUserHomePage.labelHomePageBodyTeamMembersUcuncuUyeIsimVeGorevKutusu.click();
        String expectedTeamMembersPagetitle = ConfigReader.getProperty("jaxongreenPageTitle");
        String actualTeamMembersPagetitle = Driver.getDriver().getTitle();

        Assert.assertEquals(expectedTeamMembersPagetitle,actualTeamMembersPagetitle);

        // 8. bir önceki sayfaya  geri dön
        Driver.getDriver().navigate().back();

        // 9. mause üçüncü takım üyesinin üstüne götürüldüğünde facebook-twitter-linedin ikonunun görünür ve erişilebilir olduğunu doğrula
        actions.moveToElement(tawUserHomePage.homePageBodyTeamMembersUcuncuUye).perform();
        for (WebElement each : tawUserHomePage.iconHomePageBodyTeamMembersUcuncuUyeTumIconlar){
            Assert.assertTrue(each.isDisplayed());
            Assert.assertTrue(each.isEnabled());
        }

        // 10. facebook ikonuna tıklandığında ilgili sayfanın url'inin "facebook" içerdiğini doğrula
        String homePageWindowHandle = Driver.getDriver().getWindowHandle();
        actions.moveToElement(tawUserHomePage.homePageBodyTeamMembersUcuncuUye).perform();
        tawUserHomePage.iconHomePageBodyTeamMembersUcuncuUyeFacebookIcon.click();

        Set<String> windowHandleSet = Driver.getDriver().getWindowHandles();
        String facebookWindowHandle = "";
        for (String each : windowHandleSet){
            if (!each.equals(homePageWindowHandle)){
                facebookWindowHandle = each;
            }
        }

        Driver.getDriver().switchTo().window(facebookWindowHandle);
        String expectedFacebookUrl = ConfigReader.getProperty("facebookUrl");
        String actulaFacebookUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actulaFacebookUrl.contains(expectedFacebookUrl));
        Driver.getDriver().switchTo().window(facebookWindowHandle).close();
        Driver.getDriver().switchTo().window(homePageWindowHandle);

        // 11. twitter ikonuna tıklandığında ilgili sayfanın url'inin "twitter" içerdiğini doğrula
        actions.moveToElement(tawUserHomePage.homePageBodyTeamMembersUcuncuUye).perform();
        tawUserHomePage.iconHomePageBodyTeamMembersUcuncuUyeTwitterIcon.click();

        windowHandleSet = Driver.getDriver().getWindowHandles();
        String twitterWindowHandle = "";
        for (String each : windowHandleSet){
            if (!each.equals(homePageWindowHandle) && !each.equals(facebookWindowHandle)){
                twitterWindowHandle = each;
            }
        }

        Driver.getDriver().switchTo().window(twitterWindowHandle);
        String expectedTwitterUrl = ConfigReader.getProperty("twitterUrl");
        String actualTwitterUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actualTwitterUrl.contains(expectedTwitterUrl));
        Driver.getDriver().switchTo().window(twitterWindowHandle).close();
        Driver.getDriver().switchTo().window(homePageWindowHandle);

        // 12. linkedin ikonuna tıklandığında ilgili sayfanın Url'inin "linkedin" içerdiğini doğrula
        actions.moveToElement(tawUserHomePage.homePageBodyTeamMembersUcuncuUye).perform();
        tawUserHomePage.iconHomePageBodyTeamMembersUcuncuUyeLinkedInIcon.click();

        windowHandleSet = Driver.getDriver().getWindowHandles();
        String linkedInWindowHandle = "";
        for (String each : windowHandleSet){
            if (!each.equals(homePageWindowHandle) && !each.equals(facebookWindowHandle) && !each.equals(twitterWindowHandle)){
                linkedInWindowHandle = each;
            }
        }

        Driver.getDriver().switchTo().window(linkedInWindowHandle);
        String expectedKLinkedInTitle = ConfigReader.getProperty("linkedInUrl");
        String actualLinkedInTitle = Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actualLinkedInTitle.contains(expectedKLinkedInTitle));

        Driver.getDriver().switchTo().window(linkedInWindowHandle).close();
        Driver.getDriver().switchTo().window(homePageWindowHandle);

        Driver.quitDriver();
    }

    @Test(priority = 5)
    public void us_003_tc_36(){
        // 1. browser'ı aç
        // 2. https://qa.tripandway.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("tawUrl"));
        TawUserHomePage tawUserHomePage = new TawUserHomePage();
        Actions actions = new Actions(Driver.getDriver());
        for (int i = 0; i < 85; i++) {
            actions.sendKeys(Keys.ARROW_DOWN).perform();
        }
        ReusableMethods.wait(1);

        // 3. dördüncü takım üyesinin görünür olduğunu doğrula
        Assert.assertTrue(tawUserHomePage.homePageBodyTeamMembersDorduncuUye.isDisplayed());

        // 4. isminin "Avery Johnson" olduğunu ve görünür olduğunu doğrula
        String expectedIsim = ConfigReader.getProperty("homePageBodyTeamMembersDorduncuUyeIsim");
        String actualIsim = tawUserHomePage.labelHomePageBodyTeamMembersDorduncuUyeIsimTexti.getText();

        Assert.assertEquals(expectedIsim,actualIsim);
        Assert.assertTrue(tawUserHomePage.labelHomePageBodyTeamMembersDorduncuUyeIsimTexti.isDisplayed());

        // 5. görevinin "Marketing Officer" olduğunu ve görünür olduğunu doğrula
        String expectedGorev = ConfigReader.getProperty("homePageBodyTeamMembersDorduncuUyeGorev");
        String actualGorev = tawUserHomePage.labelHomePageBodyTeamMembersDorduncuUyeGorevTexti.getText();

        Assert.assertEquals(expectedGorev,actualGorev);
        Assert.assertTrue(tawUserHomePage.labelHomePageBodyTeamMembersDorduncuUyeGorevTexti.isDisplayed());

        // 6. isim ve görev kutusunun görünür ve erişilebilir olduğunu doğrula
        Assert.assertTrue(tawUserHomePage.labelHomePageBodyTeamMembersDorduncuUyeIsimVeGorevKutusu.isDisplayed());
        Assert.assertTrue(tawUserHomePage.labelHomePageBodyTeamMembersDorduncuUyeIsimVeGorevKutusu.isEnabled());

        // 7. isim ve görev kutusuna tıklandığında ilgili sayfanın title'ının "Avery Johnson" olduğunu doğrula
        tawUserHomePage.labelHomePageBodyTeamMembersDorduncuUyeIsimVeGorevKutusu.click();
        String expectedTeamMembersPagetitle = ConfigReader.getProperty("averyJohnsonPageTitle");
        String actualTeamMembersPagetitle = Driver.getDriver().getTitle();

        Assert.assertEquals(expectedTeamMembersPagetitle,actualTeamMembersPagetitle);

        // 8. bir önceki sayfaya  geri dön
        Driver.getDriver().navigate().back();

        // 9. mause dördüncü takım üyesinin üstüne götürüldüğünde facebook-twitter-linedin ikonunun görünür ve erişilebilir olduğunu doğrula
        actions.moveToElement(tawUserHomePage.homePageBodyTeamMembersDorduncuUye).perform();
        for (WebElement each : tawUserHomePage.iconHomePageBodyTeamMembersDorduncuUyeTumIconlar){
            Assert.assertTrue(each.isDisplayed());
            Assert.assertTrue(each.isEnabled());
        }

        // 10. facebook ikonuna tıklandığında ilgili sayfanın url'inin "facebook" içerdiğini doğrula
        String homePageWindowHandle = Driver.getDriver().getWindowHandle();
        actions.moveToElement(tawUserHomePage.homePageBodyTeamMembersDorduncuUye).perform();
        tawUserHomePage.iconHomePageBodyTeamMembersDorduncuUyeFacebookIcon.click();

        Set<String> windowHandleSet = Driver.getDriver().getWindowHandles();
        String facebookWindowHandle = "";
        for (String each : windowHandleSet){
            if (!each.equals(homePageWindowHandle)){
                facebookWindowHandle = each;
            }
        }

        Driver.getDriver().switchTo().window(facebookWindowHandle);
        String expectedFacebookUrl = ConfigReader.getProperty("facebookUrl");
        String actulaFacebookUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actulaFacebookUrl.contains(expectedFacebookUrl));
        Driver.getDriver().switchTo().window(facebookWindowHandle).close();
        Driver.getDriver().switchTo().window(homePageWindowHandle);

        // 11. twitter ikonuna tıklandığında ilgili sayfanın url'inin "twitter" içerdiğini doğrula
        actions.moveToElement(tawUserHomePage.homePageBodyTeamMembersDorduncuUye).perform();
        tawUserHomePage.iconHomePageBodyTeamMembersDorduncuUyeTwitterIcon.click();

        windowHandleSet = Driver.getDriver().getWindowHandles();
        String twitterWindowHandle = "";
        for (String each : windowHandleSet){
            if (!each.equals(homePageWindowHandle) && !each.equals(facebookWindowHandle)){
                twitterWindowHandle = each;
            }
        }

        Driver.getDriver().switchTo().window(twitterWindowHandle);
        String expectedTwitterUrl = ConfigReader.getProperty("twitterUrl");
        String actualTwitterUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actualTwitterUrl.contains(expectedTwitterUrl));
        Driver.getDriver().switchTo().window(twitterWindowHandle).close();
        Driver.getDriver().switchTo().window(homePageWindowHandle);

        // 12. linkedin ikonuna tıklandığında ilgili sayfanın Url'inin "linkedin" içerdiğini doğrula

        actions.moveToElement(tawUserHomePage.homePageBodyTeamMembersDorduncuUye).perform();
        tawUserHomePage.iconHomePageBodyTeamMembersDorduncuUyeLinkedInIcon.click();

        windowHandleSet = Driver.getDriver().getWindowHandles();
        String linkedInWindowHandle = "";
        for (String each : windowHandleSet){
            if (!each.equals(homePageWindowHandle) && !each.equals(facebookWindowHandle) && !each.equals(twitterWindowHandle)){
                linkedInWindowHandle = each;
            }
        }

        Driver.getDriver().switchTo().window(linkedInWindowHandle);
        String expectedKLinkedInTitle = ConfigReader.getProperty("linkedInUrl");
        String actualLinkedInTitle = Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actualLinkedInTitle.contains(expectedKLinkedInTitle));

        Driver.getDriver().switchTo().window(linkedInWindowHandle).close();
        Driver.getDriver().switchTo().window(homePageWindowHandle);

        Driver.quitDriver();
    }

}
