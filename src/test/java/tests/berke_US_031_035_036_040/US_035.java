package tests.berke_US_031_035_036_040;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TawAdminPage;
import utilities.ConfigReader;
import utilities.Driver;

public class US_035 {
    TawAdminPage tawAdminPage;

    @Test
    public void TC_01(){
        tawAdminPage = new TawAdminPage();

        //1. Webdriver çalıştırılarak "https://qa.tripandway.com/admin" sayfasına gidilir ve admin hesap bilgileri ile giriş yapılır
        Driver.getDriver().get(ConfigReader.getProperty("tawAdminUrl"));

        TawAdminPage.tawAdminAccountGiris();

        //2. Admin ana sayfasında sol panelde bulunan listede "Subscribers" a tıklanır ve açılan drop down menüde "All Subscribers" butonuna tıklanır
        tawAdminPage.subscribersButton.click();
        tawAdminPage.allSubscribersButton.click();

        //3. Açılan sayfasa tüm sabscriber'ların göründüğü doğrulanır
        tawAdminPage.allSubscribersSLButton.click();

        String lastSubscriberNumber = tawAdminPage.lastSubscriberNumber.getText();
        String dataTableInfo = tawAdminPage.dataTableInfoText.getText();

        Assert.assertTrue(dataTableInfo.contains(lastSubscriberNumber));

        Driver.closeDriver();

    }
}
