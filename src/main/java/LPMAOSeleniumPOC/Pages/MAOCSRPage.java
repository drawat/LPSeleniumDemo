package LPMAOSeleniumPOC.Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import LPMAOSeleniumPOC.Utilities.Browser.WebPage;
public class MAOCSRPage extends WebPage{
	
	public static final String MAO_CSR_URL = "https://lilyv.omni.manh.com/customerengagementfacade/app/csrdashboard";
	
	public MAOCSRPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath = "//a[@data-component-id='ItemSearch']" )
	public WebElement itemSearchIcon;
	
	@FindBy(xpath="//input[@data-component-id='ItemSearchKeyword']")
	public WebElement itemSearchTextBox;

	@FindBy(xpath="//button[@data-component-id='AddCheckoutBtn']")
	public WebElement AddCheckoutBtn;
	
	@FindBy(xpath="//div[@data-component-id='CustomerInfoDialog']")
	public WebElement custDetailsPopup;
	
	@FindBy(xpath="//input[@id='search-input']")
	public WebElement custSearchTextBox;
	
	@FindBy(xpath="//div[@id='customer-dashboard-title']//h5[@data-component-id='SelectedOrg']")
	public WebElement orgDropDown;
	
	@FindBy(xpath="//div[@class='cdk-overlay-container']//div[@id='cdk-overlay-18']//button[2]")
	public WebElement orgSelection;
	
	@FindBy(xpath="//button[@data-component-id='DoneBtn']")
	public WebElement btnDoneCustomerSearch;

	@Override
	public void openURL() {
		// TODO Auto-generated method stub
		
	}
	public boolean isItemSearchDisplayed() {
		implicitWait(implicitWaitTime);
		return itemSearchIcon.isDisplayed();
	}
	public void clickItemSearch() {
		//switchToNewWindow();
		implicitWait(implicitWaitTime);
		itemSearchIcon.click();
	}
	
	public void searchSKU(String ItemID) {
		implicitWait(implicitWaitTime);
		itemSearchTextBox.sendKeys(ItemID);
		itemSearchTextBox.sendKeys(Keys.ENTER);
	}
	
	public void clickAddCheckoutBttn() {
		implicitWait(implicitWaitTime);
		AddCheckoutBtn.click();
	}
	
	public boolean isCustomerDetailPopupDisplayed() {
		implicitWait(implicitWaitTime);
		return custDetailsPopup.isDisplayed();
	}
	
	public void inputAndSelectCustomer(String custEmailId) {
		implicitWait(implicitWaitTime);
		custSearchTextBox.sendKeys(custEmailId);
		implicitWait(implicitWaitTime);
		driver.findElements(By.xpath("//h4[@id='customer-name']")).getFirst().click();
		
	}
	
	public MAOOrderDetailPage clickDoneBtnOnCustomerSearch() {
		implicitWait(implicitWaitTime);
		btnDoneCustomerSearch.click();
		implicitWait(implicitWaitTime);
		orderID=waitForElement(By.xpath("//h5[@data-component-id='OrderId']")).getText();
		System.out.println("Order Id:    " +  orderID);
		return PageFactory.initElements(driver, MAOOrderDetailPage.class);
	}
	/*
	 * public void selectOrganization() { implicitWait(implicitWaitTime);
	 * orgDropDown.click(); driver.switchTo().frame(driver.findElement(By.className(
	 * "cdk-overlay-container"))); System.out.println(orgSelection.isDisplayed());
	 * implicitWait(implicitWaitTime); orgSelection.click();
	 * implicitWait(implicitWaitTime); driver.switchTo().defaultContent();
	 * 
	 * 
	 * }
	 */

}
