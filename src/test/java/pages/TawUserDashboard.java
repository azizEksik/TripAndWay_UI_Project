package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class TawUserDashboard {

    public TawUserDashboard(){PageFactory.initElements(Driver.getDriver(), this);}


    // User Dashboad >>> Payment History
    @FindBy(xpath = "//a[@href='https://qa.tripandway.com/traveller/order']")
    public WebElement paymetHistorysElement;

    // User Dashboad >>> Payment History
    @FindBy(xpath = "//*[text()='View All Payments']")
    public WebElement viewAllPaymenstTitle;

    @FindBy(xpath = "//tbody/tr[2]/td[5]")
    public WebElement paymentHistoryPagePackageName;

    // User Dashboad >>> Payment History
    @FindBy(xpath = "(//tbody/tr[2]/td[8])/a")
    public WebElement viewAllPaymentsActionButton;

    // User Dashboad >>> Payment History >>> Order Detail
    @FindBy(xpath = "//tbody/tr[4]/td[2]")
    public WebElement orderDetailCurrencyElement;

    @FindBy(xpath = "//tbody/tr[5]/td[2]")
    public WebElement orderDetailPaidAmountElement;

    @FindBy(xpath = "//tbody/tr[11]/td[2]")
    public WebElement orderDetailPaymentStatusElement;




}
