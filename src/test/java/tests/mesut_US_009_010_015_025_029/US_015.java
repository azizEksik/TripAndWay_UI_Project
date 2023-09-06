package tests.mesut_US_009_010_015_025_029;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TawUserHomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class US_015 {
    /*
        About Us sayfasının sayfasının görünürlüğü kontrol edilemeli.
        Ulaşılabilir tüm öğelerin görünebilir olduğu doğrulanmalı
     */

    private JavascriptExecutor jsExecutor;
    @Test
    public void tc_01() {
        // 1- https://qa.tripandway.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("tawUrl"));
        TawUserHomePage tawUserHomePage = new TawUserHomePage();
        ReusableMethods.wait(1);
        tawUserHomePage.websiteUsesCookiesButton.click();

        // 2- Ana Sayfanın menu bölümünde About Us linkinin text'i doğrulanır ve linke tıklanır
        String expectedText = ConfigReader.getProperty("aboutUsElementTitle");
        String actualText = tawUserHomePage.aboutUsElement.getText();
        Assert.assertEquals(actualText, expectedText);
        tawUserHomePage.aboutUsElement.click();

        // 3- İlgili sayfanın açıldığı doğrulanır
        String expectedUrl = ConfigReader.getProperty("aboutUsUrl");
        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl);

        // Açılan sayfanın title başlığını kontrol eder
        String expectedTitle = ConfigReader.getProperty("aboutUsTitle");
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);

        // 4- "Hakkımızda" sayfasında, şirket genel bilgiler bulunmalıdır.
        // Bu bilgiler, OUR MISSION ve OUR VISION gibi konuları kapsadığı içerik kontrol edilmelidir.
        String expectedPageSubtext = "OUR MISSION";
        String actualPageSubtext = tawUserHomePage.aboutUsPageSubtext.getText();
        System.out.println(actualPageSubtext);
        Assert.assertEquals(actualPageSubtext,expectedPageSubtext);

        // 5- Tüm öğelerin (metinler, görseller, bağlantılar vb.) görüntülenmesi gerekmektedir.
        // Sayfa yüklenirken, herhangi bir eksik veya hatalı öğe olmamalıdır.
        // About Us sayfasındaki tüm erişilebilir öğelerin görüntülenip görüntülenmediğini kontrol etmek için gerekli
        // Örneğin, sayfadaki tüm başlıkları (h1, h2, h3 vb.) kontrol etmek için aşağıdaki kodu kullanabilirsiniz:
        scrollPageToBottom(Driver.getDriver());

        // Sayfadaki tüm öğeler Body altında olduğu için Body altındaki her tag'ı List'e ekliyoruz
        List<WebElement> allElements = Driver.getDriver().findElements(By.xpath("//body//*"));

        // List'deki Tüm tag'lar görünür ise Tag'name leri yazdırıyoruz
        for (WebElement element : allElements) {
            if (element.isDisplayed()) {
                System.out.println("Görünür öğe: " + element.getTagName());
            }
        }
        Driver.closeDriver();
    }

    // Sayfanın gözüken alanlarının tag'ları aktif olacağından dolayı tüm sayfayı
    // scroll yaparak aşağıya doğru kaydırıyoruz.
    // Böylece tag'lar aktif oluyor
    private void scrollPageToBottom(WebDriver driver) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

}
