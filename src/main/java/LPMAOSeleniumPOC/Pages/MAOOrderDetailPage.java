package LPMAOSeleniumPOC.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import LPMAOSeleniumPOC.Utilities.Browser.WebPage;

public class MAOOrderDetailPage extends WebPage{
	
	public static final String MAO_CSR_OrderDetailsURL = "https://lilyv.omni.manh.com/customerengagementfacade/app/editOrder?orderId=" + orderID;

	public MAOOrderDetailPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void openURL() {
		// TODO Auto-generated method stub
		
	}
	@FindBy(xpath="//button[@data-component-id='ProceedToPayment']")
	public WebElement proceedToPaymentBtn;
	
	@FindBy(xpath="//input[@data-component-id='CreditCardSecurityCode']")
	public WebElement CCSecurityCodeTestBox;
	
	@FindBy(xpath="//available-credit-card//button[@data-component-id='AddBtn']")
	public WebElement addCCBtn;
	
	@FindBy(xpath="//button[@data-component-id='ProceedToSummary']")
	public WebElement proceedToSummaryBtn;
	
	@FindBy(xpath="//button[@data-component-id='PlaceOrderBtn']")
	public WebElement placeOrderBtn;
	
	@FindBy(xpath="//update-customer-dialog[@class='ng-star-inserted']")
	public WebElement updateCustomerDetailsDailog;
	
	@FindBy(xpath="//button[@data-component-id='SaveBtn']")
	public WebElement saveCustomerDetailsBtn;
	
	@FindBy(xpath="//button[@data-component-id='UseThisBtn']")
	public WebElement useThisBtn;
	
	@FindBy(xpath="//customer-save-success-dialog[@class='ng-star-inserted']")
	public WebElement ConfirmCustInfoDailog;
	
	@FindBy(xpath="//button[@data-component-id='DoneBtn']")
	public WebElement doneCustInfoBtn;
	
	public void clickUseThisBtn() {
		useThisBtn.click();
	}
	
	public void clickProceedToPayment() {
		implicitWait(implicitWaitTime);
			proceedToPaymentBtn.click();
	}
	
	public void enterCreditCardSecurityCode(String securityCode) {
		implicitWait(implicitWaitTime);
		CCSecurityCodeTestBox.sendKeys(securityCode);
	}
	
	public void addCCbuttonClick() {
		implicitWait(implicitWaitTime);
		addCCBtn.click();
	}
	public void clickProceedToSummaryBtn() {
		implicitWait(implicitWaitTime);
		proceedToSummaryBtn.click();
	}
	public void clickPlaceOrder() {
		implicitWait(implicitWaitTime);
		placeOrderBtn.click();
	}
	public boolean isupdateCustomerDetailsDailogDisplayed() {
		implicitWait(implicitWaitTime);
		return updateCustomerDetailsDailog.isDisplayed();
	}
	
	public void clickSaveCustomerDetailsBtn() {
		saveCustomerDetailsBtn.click();
		implicitWait(implicitWaitTime);
	}
	public boolean isConfirmCustInfoDailogDisplayed() {
		implicitWait(implicitWaitTime);
		return ConfirmCustInfoDailog.isDisplayed();
	}
	
	public void clickDoneCustInformBtn() {
		doneCustInfoBtn.click();
		implicitWait(implicitWaitTime);
	}
}
