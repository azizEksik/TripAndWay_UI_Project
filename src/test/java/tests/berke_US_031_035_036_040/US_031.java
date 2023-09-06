package tests.berke_US_031_035_036_040;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TawAdminPage;
import utilities.ConfigReader;
import utilities.Driver;




public class US_031 {
    TawAdminPage tawAdminPage;
    public WebElement packageSatir;
    public WebElement editButton;
    @Test
    public void TC_01(){
        tawAdminPage = new TawAdminPage();
        //1. Webdriver çalıştırılarak "https://qa.tripandway.com/admin" sayfasına gidilir ve admin hesap bilgileri ile giriş yapılır
        Driver.getDriver().get(ConfigReader.getProperty("tawAdminUrl"));

        TawAdminPage.tawAdminAccountGiris();

        //2. Admin ana sayfasında sol panelde bulunan listede packages'a tıklanır
        tawAdminPage.packagesButton.click();

        //3. Açılan sayfada "Add New" butonuna tıklanır
        tawAdminPage.packagesAddNewButton.click();

        //4. Açılan sayfada ilgili tüm alanları doldurulur ve ardından sayfanın alt kısmında bulunan "Submit" butonuna tıklayanır
        Actions actions = new Actions(Driver.getDriver());

        actions.click(tawAdminPage.packagesNameBox)
                .sendKeys(ConfigReader.getProperty("addNewPackageName")) //PackageNameBox
                .sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("addSlugForPackage")).perform(); //Slugbox

        String herkesteFarkliOlan = System.getProperty("user.dir");
        String herkesteAyniOlan = "\\src\\test\\java\\utilities\\filesForUpload\\board-361516_640.jpg";
        String dosyaYolu = herkesteFarkliOlan + herkesteAyniOlan;

        tawAdminPage.packagesChooseFileButton.sendKeys(dosyaYolu);

        actions.click(tawAdminPage.packagesDescriptionTextBox)
                .sendKeys(ConfigReader.getProperty("addNewPackageDescriptionTextBox"))
                .sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("addNewPackageShortDescriptionTextBox"))
                .sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("addNewPackageLocationTextBox"))
                .sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("addNewPackageStartDate"))
                .sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("addNewPackageEndDate"))
                .sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("addNewPackageLastBookingDate"))
                .sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("addNewPackageMapTextBox"))
                .sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("addNewPackageItineraryTextBox"))
                .sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("addNewPackagePrice"))
                .sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("addNewPackagePolicyTextBox"))
                .sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("addNewPackageTermsTextBox"))
                .sendKeys(Keys.TAB) //is Featured?
                .sendKeys(Keys.ARROW_DOWN) //yes
                .sendKeys(Keys.TAB) // Destination
                .sendKeys(Keys.ENTER) //search
                .sendKeys(Keys.ARROW_DOWN) //seçim
                .sendKeys(Keys.ENTER)
                .sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("addNewPackageSEOTitleTextBox"))
                .sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("addNewPackageSEOMetaDescriptionTextBox"))
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER).perform();


        //5. Çıkan alerts ile ya da açılan tablo yardımı ile ilgili bilgileri görüntüleyebildiğini doğrulanır
        Assert.assertTrue(tawAdminPage.newPackagesOnay.isDisplayed());

        Driver.closeDriver();

    }

    @Test
    public void TC_02(){
        tawAdminPage = new TawAdminPage();

        //1. Webdriver çalıştırılarak "https://qa.tripandway.com/admin" sayfasına gidilir ve admin hesap bilgileri ile giriş yapılır
        Driver.getDriver().get(ConfigReader.getProperty("tawAdminUrl"));

        TawAdminPage.tawAdminAccountGiris();

        //2. Admin ana sayfasında sol panelde bulunan listede packages'a tıklanır
        tawAdminPage.packagesButton.click();

        //3. Daha önce eklenen package'ın sağ tarafında bulunan sarı "Edit" butonuna tıklanır
        tawAdminPage.packagesSearchBox.sendKeys(ConfigReader.getProperty("addNewPackageName") + Keys.ENTER);
        tawAdminPage.packageEditButton.click();

        //4. Açılan sayfada ilgili tüm alanlar düzenlenir/editlenir ve ardından sayfanın alt kısmında bulunan "Submit" butonuna tıklanır
        Actions actions = new Actions(Driver.getDriver());

        actions.click(tawAdminPage.packagesNameBox)
                .sendKeys(ConfigReader.getProperty("editPackageName")) //PackageNameBox
                .sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("editSlugForPackage")).perform(); //Slugbox

        String herkesteFarkliOlan = System.getProperty("user.dir");
        String herkesteAyniOlan = "\\src\\test\\java\\utilities\\filesForUpload\\board-361516_640 - Copy.jpg";
        String dosyaYolu = herkesteFarkliOlan + herkesteAyniOlan;

        tawAdminPage.packagesChooseFileButton.sendKeys(dosyaYolu);

        actions.click(tawAdminPage.packagesEditDescriptionTextBox)
                .sendKeys(ConfigReader.getProperty("editPackageDescriptionTextBox"))
                .sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("editPackageShortDescriptionTextBox"))
                .sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("editPackageLocationTextBox"))
                .sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("editPackageStartDate"))
                .sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("editPackageEndDate"))
                .sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("editPackageLastBookingDate"))
                .sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("editPackageMapTextBox"))
                .sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("editPackageItineraryTextBox"))
                .sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("editPackagePrice"))
                .sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("editPackagePolicyTextBox"))
                .sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("editPackageTermsTextBox"))
                .sendKeys(Keys.TAB) //is Featured?
                .sendKeys(Keys.ARROW_DOWN) //yes
                .sendKeys(Keys.TAB) // Destination
                .sendKeys(Keys.ENTER) //search
                .sendKeys(Keys.ARROW_DOWN) //seçim
                .sendKeys(Keys.ENTER)
                .sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("editPackageSEOTitleTextBox"))
                .sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("editPackageSEOMetaDescriptionTextBox"))
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER).perform();

        //5. Çıkan alerts ile ya da açılan tablo yardımı ile ilgili bilgilerin editlendiği doğrulanır
        Assert.assertTrue(tawAdminPage.newPackagesOnay.isDisplayed());

        Driver.closeDriver();

    }

    @Test
    public void TC_03(){
        tawAdminPage = new TawAdminPage();

        //1. Webdriver çalıştırılarak "https://qa.tripandway.com/admin" sayfasına gidilir ve admin hesap bilgileri ile giriş yapılır
        Driver.getDriver().get(ConfigReader.getProperty("tawAdminUrl"));

        TawAdminPage.tawAdminAccountGiris();

        //2. Admin ana sayfasında sol panelde bulunan listede packages'a tıklanır
        tawAdminPage.packagesButton.click();

        //3. Daha önce eklenen package'ın sağ tarafında bulunan kırmızı"Delete" butonuna tıklanır
        tawAdminPage.packagesSearchBox.sendKeys(ConfigReader.getProperty("addNewPackageName") + Keys.ENTER);
        tawAdminPage.packageDeleteButton.click();

        //4. Yukarıda çıkan bildirim/alert ekranında "OK" butonuna basılır
        Alert alert = Driver.getDriver().switchTo().alert();
        alert.accept();

        //5. Çıkan alerts ile ya da açılan tablo yardımı ile ilgili bilgilerin silindiği/kaldırıldığı doğrulanır
        Assert.assertTrue(tawAdminPage.newPackagesOnay.isDisplayed());

        Driver.closeDriver();
    }
}
