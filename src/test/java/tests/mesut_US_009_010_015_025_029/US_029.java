package tests.mesut_US_009_010_015_025_029;

import org.testng.annotations.Test;
import pages.TawAdminPage;
import utilities.ConfigReader;
import utilities.Driver;

public class US_029 {

    /*
        Package ödemesi tamamlandıktan sonra kullanıcı sayfasında payment historyden
         ödememi kontrol edebildiğimi doğrulayabilmeliyim
     */

    TawAdminPage tawAdminPage;

    @Test
    public void TC_01() {
        tawAdminPage = new TawAdminPage();
        //1. Webdriver çalıştırılarak "https://qa.tripandway.com/admin" sayfasına gidilir ve admin hesap bilgileri ile giriş yapılır
        Driver.getDriver().get(ConfigReader.getProperty("tawAdminUrl"));
        TawAdminPage.tawAdminAccountGiris();
        // 2- Dashboard sayfasında, "Payment History" linki olduğu doğrulanmalı ve tıklanmalıdır


        // 3- View All Payments bölümünün açıldığı görülmelidir.
        // 4- Tabloda kayıt olduğu doğrulanmalıdır
        // 5- Tablodaki ödeme bilgisinin içerikleri doğrulanmalı ve butonların aktif olduğu görülmelidir
        // 6- Action butonunun aktif olduğu doğrulanmalı ve tıklanıp order detail sayfası açılmalıdır
        // 7- Order detail sayfası görüntülendiği doğrulanmalıdır
        // 8- Payment Status Complated olduğu doğrulnmalıdır
        // 9- Package Name, Total Price, Payment Method vb. bilgilerin eşleşmesi kontrol edilmelidir

    }
}