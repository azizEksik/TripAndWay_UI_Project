package tests.enes_US_008_019_028_034;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TawAdminPage;
import utilities.ConfigReader;
import utilities.Driver;

public class US_028 {
    // Admin girişi yaptıktan sonra Blog Section bölümünde Kategegoriler kısmına
    // yeni kategori ekleyip eklediğim kategorinin düzenlenebildiğini
    // ve silinebildiğini sırayla doğrulayabilmeliyim

    @Test(priority = 1)
    public void TC_01(){
        // 1. browser'ı aç
        // 2. https://qa.tripandway.com/admin adresine git
        TawAdminPage tawAdminPage = new TawAdminPage();
        Driver.getDriver().get(ConfigReader.getProperty("tawAdminUrl"));

        tawAdminPage.adminEmailBox.sendKeys(ConfigReader.getProperty("adminEmail1"));
        tawAdminPage.adminPassBox.sendKeys(ConfigReader.getProperty("adminPass"));
        tawAdminPage.adminLoginButton.click();

        // 3. Blog Section menüsüne tıkla
        tawAdminPage.buttonBlogSectionButton.click();

        // 4. açılan menüde Categories linkine tıkla
        tawAdminPage.buttonBlogSectionCategoriesButton.click();

        // 5. add new buttonuna tıkla
        tawAdminPage.getButtonBlogSectionCatagoriesAddNewButton.click();

        // 6. Category Name , Category Slug, Title, Meta Description bölümlerini "TEST777" ile doldur
        Actions actions = new Actions(Driver.getDriver());
        actions.click(tawAdminPage.blogSectionCategoryCategoryName).sendKeys(ConfigReader.getProperty("TEST777"))
                .sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("TEST777"))
                .sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("TEST777"))
                .sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("TEST777"))
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER).perform();

        // 7. sumbit buttonuna tıkla
        // 8. eklenen son kategorinin, göründüğünü başlığını TEST777 olduğunu doğrula
        tawAdminPage.blogSectionCategorySearchTextBox.sendKeys("TEST777");

        String expectedCategoryTitle = ConfigReader.getProperty("TEST777");
        String actulaCategorytitle = tawAdminPage.blogSectionCategoryCategoryTitle.getText();

        Assert.assertEquals(expectedCategoryTitle,actulaCategorytitle);

        Assert.assertTrue(tawAdminPage.blogSectionCategoryCategoryTitle.isDisplayed());

        Driver.quitDriver();
    }

    @Test(priority = 2)
    public void TC_02(){
        // 1. browser'ı aç
        // 2. https://qa.tripandway.com/admin adresine git
        TawAdminPage tawAdminPage = new TawAdminPage();
        Driver.getDriver().get(ConfigReader.getProperty("tawAdminUrl"));

        tawAdminPage.adminEmailBox.sendKeys(ConfigReader.getProperty("adminEmail1"));
        tawAdminPage.adminPassBox.sendKeys(ConfigReader.getProperty("adminPass"));
        tawAdminPage.adminLoginButton.click();

        // 3. Blog Section menüsüne tıkla
        tawAdminPage.buttonBlogSectionButton.click();
        // 4. açılan menüde Categories linkine tıkla
        tawAdminPage.buttonBlogSectionCategoriesButton.click();

        // 5. kategories search box'ına tıkla, TEST777 gir
        tawAdminPage.blogSectionCategorySearchTextBox.sendKeys("TEST777");

        // 6. edit buttonuna tıkla
        tawAdminPage.blogSectionCategoryEditButton.click();

        // 7. açılan sayfada update buttonunun görünür olduğunu doğrula
        Assert.assertTrue(tawAdminPage.blogSectionCategoryEditUpdateButton.isDisplayed());

        // 8. update buttonuna tıkla
        tawAdminPage.blogSectionCategoryEditUpdateButton.click();

        // 9. açılan sayfada update edildi allertinin "update" icerdigini doğrula
        String expectedUpdateText = "update";
        String actualUpdateText = tawAdminPage.blogSectionCategoryUpdateAlert.getText();

        Assert.assertTrue(actualUpdateText.contains(expectedUpdateText));

        // 10. kategories search box'ına tıkla, TEST777 gir
        tawAdminPage.blogSectionCategorySearchTextBox.sendKeys("TEST777");

        // 11. delete buttonuna tıkla
        tawAdminPage.buttonblogSectionCategoryDeleteButton.click();
        Driver.getDriver().switchTo().alert().accept();

        // 12. çıkan alertin "deleted" icerdigini doğrula
        String expectedDeleteText = "deleted";
        String actualDeleteText = tawAdminPage.blogSectionCategoryDeleteAlert.getText();

        Assert.assertTrue(actualDeleteText.contains(expectedDeleteText));

        Driver.closeDriver();

    }

}
