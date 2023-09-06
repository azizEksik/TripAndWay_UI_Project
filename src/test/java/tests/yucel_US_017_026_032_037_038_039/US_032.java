package tests.yucel_US_017_026_032_037_038_039;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TawAdminPage;
import utilities.ConfigReader;
import utilities.Driver;

public class US_032 {
    TawAdminPage tawAdminPage;

    @Test
    public void TC_01(){
        tawAdminPage = new TawAdminPage();

        //"1. Webdriver çalıştırılarak
        //""https://qa.tripandway.com/admin""
        //sayfasına gidilir ve admin hesap bilgileri ile giriş yapılır"
        Driver.getDriver().get(ConfigReader.getProperty("tawAdminUrl"));

        TawAdminPage.tawAdminAccountGiris();

        //2. Admin ana sayfasında "Order" butonuna tıklamalı
        tawAdminPage.orderButton.click();

        //"3. Açılan sayfada siparişlerin görüntülenebildiği
        //doğrulamalı"
        tawAdminPage.orderPageSLButton.click();

        String lastOrderNum = tawAdminPage.lastOrderNumber.getText();
        String dataTableInfo = tawAdminPage.dataTableInfoText.getText();

        Assert.assertTrue(dataTableInfo.contains(lastOrderNum));

        Driver.closeDriver();

    }
}
