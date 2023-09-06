package tests.mesut_US_009_010_015_025_029;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TawUserDashboard;
import pages.TawUserHomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class US_025 {
    /*
       Package ödemesi tamamlandıktan sonra kullanıcı sayfasında
        payment historyden ödememi kontrol edebildiğimi doğrulayabilmeliyim
    */
    TawUserDashboard tawUserDashboard;
    TawUserHomePage tawUserHomePage;
    private JavascriptExecutor jsExecutor;

    String expectedPackageTitle = null;
    String actualPackageTitle = null;
    String expectedTotalPaid = null;
    String actualTotalPaid = null;

    @Test
    public void tc_01() {
        // 1- http://qa.tripandway.com sayfasina gidilir
        Driver.getDriver().get(ConfigReader.getProperty("tawUrl"));
        tawUserDashboard = new TawUserDashboard();
        tawUserHomePage = new TawUserHomePage();
        ReusableMethods.wait(1);
        tawUserHomePage.websiteUsesCookiesButton.click();
        // 2- Kullanıcı login olmamış ise login olmalıdır
        tawUserHomePage.userLoginElement.click();
        // Girilecek textbox ve button elemenlerinin gözükmesi için sayfa belirli konuma gelir
        jsExecutor = (JavascriptExecutor) Driver.getDriver();
        jsExecutor.executeScript("window.scrollTo(0, 2000);");
        // User kullanıcı adı ve şifre girilerek login butonuna basılır
        tawUserHomePage.tawUserAccountLogin();

        // Package Sayfasına gidilir ve bir paket 7 Days Istanbul paketine tıklanır
        tawUserHomePage.packageElement.click();
        jsExecutor.executeScript("window.scrollTo(0, 500);");
        ReusableMethods.wait(1);
        tawUserHomePage.istanbulIn7DaysPackageElement.click();

        // Istanbul paketinde kisi sayisi belirienir ve BookYourSeatButton butonuna tiklanir
        jsExecutor.executeScript("window.scrollTo(0, 500);");
        WebElement dropdownMenuElementi = Driver.getDriver().findElement(By.xpath("//*[@id='numberPerson']"));
        Select select = new Select(dropdownMenuElementi);
        ReusableMethods.wait(1);
        select.selectByValue("3");
        tawUserHomePage.paymentBookYourSeatButton.click();

        // Tur adı ve fiyat bilgisinin değerleri okunur ve kredi kart ödeme butonuna basilir
        ReusableMethods.wait(1);
        jsExecutor.executeScript("window.scrollTo(0, 500);");
        expectedPackageTitle = tawUserHomePage.bookinDetailPackageName.getText();
        System.out.println(expectedPackageTitle);
        expectedTotalPaid = tawUserHomePage.bookingDetailTotalPaidUsd.getText();
        System.out.println(expectedTotalPaid);
        jsExecutor.executeScript("window.scrollTo(0, 500);");
        ReusableMethods.wait(1);
        tawUserHomePage.payWithCardButton.click();

        // Kart bilgileri girilir ve Pay butonuna basilir
        ReusableMethods.wait(1);
        Actions actions = new Actions(Driver.getDriver());
        WebElement frameElementi = Driver.getDriver().findElement(By.name("stripe_checkout_app"));
        Driver.getDriver().switchTo().frame(frameElementi);
        String creditCardNumber = "4242 4242 4242 4242"; // Tam kredi kartı numarası
        String script = "arguments[0].value='" + creditCardNumber + "';";
        ((JavascriptExecutor) Driver.getDriver()).executeScript(script, tawUserHomePage.creditCardNumber);
        actions.sendKeys(Keys.TAB).perform();
        actions.sendKeys(ConfigReader.getProperty("creditCardExpNumber")).sendKeys(Keys.TAB).perform();
        actions.sendKeys(ConfigReader.getProperty("creditCardCvcNumber")).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
        Driver.getDriver().switchTo().defaultContent(); // Iframe' den cikis
        ReusableMethods.wait(10);
        List<WebElement> frames = Driver.getDriver().findElements(By.tagName("frame"));
        frames.addAll(Driver.getDriver().findElements(By.tagName("iframe")));

        // Her bir frame'i kontrol ederek alert mesajını yakalayın
        for (WebElement frame : frames) {
            try {
                Driver.getDriver().switchTo().frame(frame);
                Alert alert = Driver.getDriver().switchTo().alert();

                // Alert mesajının metnini kontrol edin
                if (alert.getText().contains("Kart bilgilerinizi kaydetmek istiyor musunuz?")) {
                    // Alert mesajına "Hayır" yanıtını verin
                    alert.dismiss();
                }
                break;
            } catch (Exception e) {
                // Frame'e geçiş yapamazsa bir sonraki frame'i kontrol etmek için devam edin
                continue;
            }
        }
    }

    @Test
    public void tc_02() {

        // 1- http://qa.tripandway.com sayfasina gidilir
        Driver.getDriver().switchTo().newWindow(WindowType.TAB);
        ReusableMethods.switchToWindow("Yeni Sekme");
        Driver.getDriver().get(ConfigReader.getProperty("tawUrl"));
        //ReusableMethods.wait(1);
        //tawUserHomePage.websiteUsesCookiesButton.click();

        // 2- Kullanıcı login olmamış ise login olmalıdır
        tawUserDashboard = new TawUserDashboard();
        tawUserHomePage = new TawUserHomePage();
        jsExecutor = (JavascriptExecutor) Driver.getDriver();
        Boolean login = true;
        ReusableMethods.wait(1);

        if (login) {
            Assert.assertTrue(tawUserHomePage.dashboardElement.isDisplayed(), "Dashboard elementi görüntülenmiyor.");
            tawUserHomePage.dashboardElement.click();
        } else {
            Assert.assertTrue(tawUserHomePage.userLoginElement.isDisplayed(), "Kullanıcı giriş elementi görüntülenmiyor.");
            tawUserHomePage.userLoginElement.click();
            tawUserHomePage.tawUserAccountLogin();
        }


        // 3- Dashboard sayfasında, "Payment History" linki olduğu doğrulanmalı ve tıklanmalıdır
        Assert.assertTrue(tawUserDashboard.paymetHistorysElement.isDisplayed());
        tawUserDashboard.paymetHistorysElement.click();
        // 4- View All Payments bölümünün açıldığı görülmelidir.
        ReusableMethods.wait(2);
        Assert.assertTrue(tawUserDashboard.viewAllPaymenstTitle.isDisplayed());
        // 5- Tabloda kayıt olduğu doğrulanmalıdır

        // Tablodaki satır sayısını gösterir

        List<WebElement> satirElementleriList = Driver.getDriver().findElements(By.xpath("//tbody/tr[2]"));

        System.out.println("============================");
        /*
        String expectedUsdText = expectedTotalPaid;
        String actualUsdText = actualTotalPaid;
        String expectedPackageName = expectedPackageTitle;
        String actualPackageName = tawUserHomePage.bookinDetailPackageName;
         */
        ReusableMethods.wait(2);
        actualPackageTitle = tawUserDashboard.paymentHistoryPagePackageName.getText();
        System.out.println(actualPackageTitle + " ---Ac Package Title");
        System.out.println(expectedPackageTitle + " ---Ex Package Title");
        Assert.assertTrue(actualPackageTitle.contains(expectedPackageTitle));
/*
        for (WebElement eachSatir : satirElementleriList
        ) {
            if (actualPackageTitle.contains(expectedPackageTitle)) {
                eachSatir.getText();
                System.out.println(actualPackageTitle);
            }
            System.out.println("============================");
        }
*/
        tawUserDashboard.viewAllPaymentsActionButton.click();
        ReusableMethods.wait(1);
        jsExecutor.executeScript("window.scrollTo(0, 200);");
        List<WebElement> orderDetailList = Driver.getDriver().findElements(By.xpath("//tbody/tr/td[2]"));
        actualTotalPaid = tawUserDashboard.orderDetailPaidAmountElement.getText();
        System.out.println(actualTotalPaid + " --- Ac Total paid");
        System.out.println(expectedTotalPaid + " ---Ex Total paid");
        String expectedPaymentStatus = "Completed";
        String actualPaymentsStatus = tawUserDashboard.orderDetailPaymentStatusElement.getText();
        System.out.println(actualPaymentsStatus + " ---Ac Payment Status");
        System.out.println(expectedPaymentStatus + " ---Ex Payment Status");
        Assert.assertEquals(actualTotalPaid,expectedTotalPaid);
        Assert.assertEquals(actualPaymentsStatus,expectedPaymentStatus);

        Driver.closeDriver();
    }
}