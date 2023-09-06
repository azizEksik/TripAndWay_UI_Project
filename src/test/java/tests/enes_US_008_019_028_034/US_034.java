package tests.enes_US_008_019_028_034;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TawAdminPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.List;
import java.util.Set;

public class US_034 {
    // Admin girişi yaptıktan sonra Order bölümüne girerek
    // herhangi bir siparişin faturasının görüntülenebildiğini
    // doğrulayabilmeliyim

    @Test
    public void TC_01(){
        // 1. browser'ı aç
        // 2. https://qa.tripandway.com/admin adresine git
        TawAdminPage tawAdminPage = new TawAdminPage();
        Driver.getDriver().get(ConfigReader.getProperty("tawAdminUrl"));

        tawAdminPage.adminEmailBox.sendKeys(ConfigReader.getProperty("adminEmail1"));
        tawAdminPage.adminPassBox.sendKeys(ConfigReader.getProperty("adminPass"));
        tawAdminPage.adminLoginButton.click();

        // 3. Order buttonuna tıkla
        tawAdminPage.buttonOrderOrderButtonu.click();
        String firstWindowHandle = Driver.getDriver().getWindowHandle();

        // 4. random bir siparişin action sütunundaki detail butonuna tıkla
        tawAdminPage.orderPageRandomDetailButtonXpath(Driver.getDriver()).click();
        Set<String> windowHandles = Driver.getDriver().getWindowHandles();
        String secondWindowHandle = "";
        for (String each : windowHandles){
            if (!each.equals(firstWindowHandle)){
                secondWindowHandle = each;
            }
        }
        Driver.getDriver().switchTo().window(secondWindowHandle);

        // 5. acılan yeni sekmede "Order Detail" başlığının görünür olduğunu doğrula
        String expectedTitle = ConfigReader.getProperty("adminPageOrderOrderDetailTitle");
        String actualTitle = tawAdminPage.labelOrderOrderDetailTitleText.getText();

        Assert.assertEquals(expectedTitle,actualTitle);

        // 6. ödeme bilgilerinin tamamını görüntülenebildiğini doğrula
        Assert.assertTrue(tawAdminPage.orderOrderDetailButunFatura.isDisplayed());

        // 7. ödeme bilgilerindeki başlık textlerinin tamamının görünür olduğunu doğrula

        List<String> butunBasliklar = tawAdminPage.orderPageAllFaturaTitleText(Driver.getDriver());


        for (String each : butunBasliklar){
            WebElement element = Driver.getDriver().findElement(By.xpath(each));
            Assert.assertTrue(element.isDisplayed());

        }

        Driver.quitDriver();
    }
}
