package LPXstoreSeleniumPOC.Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import LPMAOSeleniumPOC.Utilities.Browser.WebPage;

public class XstoreLogin extends WebPage{

	public static final String  XSTORE_URL = "https://lpoe1269-001.lillypulitzer.biz:8443/xstoremgwt/";
	
	public XstoreLogin(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void openURL() {
		driver.get(XSTORE_URL);
		waitForPageToLoad(XSTORE_URL);
		PageFactory.initElements(driver, this);
		// TODO Auto-generated method stub
		
	}
	@FindBy(xpath = "//*[contains(text(), 'Agree')]")
	public WebElement LicAgreeBtn;
	
	@FindBy(xpath = "//*[contains(text(), 'Change Server')]")
	public WebElement changeServerBtn;
	
	@FindBy(xpath = "(//*[contains(text(), 'Advanced')])[2]")
	public WebElement advancedBtn;
	
	@FindBy(xpath = "//input[@aria-label='Hostname']")
	public WebElement hostNameTextBox;
	
	@FindBy(xpath = "//*[contains(text(), 'Test Connection')]")
	public WebElement testConnectionBtn;
	
	@FindBy(xpath = "//*[contains(text(), 'Save')]")
	public WebElement saveBtn;
	
	@FindBy(xpath = "//div[@class='gwt-Label com-microsretail-xstoremgwt-client-widgets-MainScreenWidgetTablet_TabletUiBinderImpl_GenCss_style-backBtnLabel unselectable']")
	public WebElement backBtn;
	
	@FindBy(xpath="//div[@class='mgwt-DialogPanel']//div[@class='mgwt-DialogButton mgwt-DialogButton-cancel']")
	public WebElement sucessTestConnectionOKBtn;
	
	@FindBy(xpath = "//*[contains(text(), 'Location Details')]")
	public WebElement locationDetailsBtn;
	
	@FindBy(xpath = "//input[@aria-label='Store']")
	public WebElement storeTextBox;
	
	@FindBy(xpath = "//input[@aria-label='Register']")
	public WebElement registerTextBox;
	
	
	@FindBy(xpath = "//*[contains(text(), 'Allow Device Access')]")
	public WebElement 	allowDeviceAccessBtn;

	@FindBy(xpath = "//input[@aria-label='Employee ID']")
	public WebElement empIDTextBox;
	
	@FindBy(xpath = "//input[@aria-label='Password']")
	public WebElement pwdTextBox;
	
	@FindBy(xpath = "//div[@class='com-microsretail-xstoremgwt-client-widgets-appearances-StandardCss-mgwt-Button com-microsretail-xstoremgwt-client-widgets-appearances-StandardCss-configScreenButton com-microsretail-xstoremgwt-client-widgets-appearances-StandardCss-mgwt-Button-small']")
	public WebElement okBtn;
	
	@FindBy(xpath = "//input[@aria-label='Enter your Associate ID to sign on.']")
	public WebElement associateIDTextBox;
	
	@FindBy(xpath = "//input[@aria-label='Key your password to complete sign on.']")
	public WebElement associatePWDTextBox;
	
	@FindBy(id = "p6")
	public WebElement associateSignOnOKbtn;
	
	@FindBy(xpath = "//*[contains(text(), 'Start Sale')]")
	public WebElement startSaleBtn;
	
	@FindBy(xpath = "//input[@aria-label='Email']")
	public WebElement custEmailTextBox;
	
	@FindBy(xpath = "//*[contains(text(), 'Next')]")
	public WebElement nextBtn;
	
	@FindBy(xpath = "//ul[@class='com-microsretail-xstoremgwt-client-widgets-appearances-StandardCss-xmList mgwt-ScrollPanel-container']")
	public WebElement custList;
	
	@FindBy(xpath = "//*[contains(text(), 'Not Now')]")
	public WebElement loyaltyNotNowBtn;
	
	@FindBy(xpath = "//input[@aria-label='Scan or key a UPC #.']")
	public WebElement scanSKUTextBox; 
	
	@FindBy(id="P_AMOUNT_DUE")
	//@FindBy(xpath ="//div[@class='com-microsretail-xstoremgwt-client-widgets-SaleItemsScreenWidget_TabletUiBinderImpl_GenCss_style-amtDuePanel']")
	public WebElement amtDueBtn;
	
	@FindBy(xpath = "//div[@title='Skip']")
	public WebElement skipGWPScanBtn;
	
	@FindBy(xpath ="//div[@class='com-microsretail-xstoremgwt-client-widgets-appearances-StandardCss-tiledMenuOption'][2]")
	public WebElement creditDebitCardBtn;
	
	@FindBy(xpath = "//div[@title='OK']")
	public WebElement confirmAmtOKBtn;
	
	@FindBy(xpath = "//div[@title='Retry']")
	public WebElement retryTenderBtn;
	
	//@FindBy(id="_li_0")
	@FindBy(xpath = "//*[contains(text(), 'Pinpad 1')]")
	public WebElement pinPad1btn;
	
	@FindBy(xpath = "//div[@title='Email']")
	public WebElement emailReceiptBtn;
	
	@FindBy(xpath = "//div[@title='Email Only']")
	public WebElement emailOnlyBtn;
	
	@FindBy(xpath ="//div[@class='com-microsretail-xstoremgwt-client-widgets-appearances-StandardCss-mgwt-Button com-microsretail-xstoremgwt-client-widgets-appearances-StandardCss-mgwt-Button-small']")
	public WebElement minTenderThresholdAmtConfirmOKBtn;
	
	public void xstoreLaunchNlogin(String hostname, String store, String register, String empID, String pwd) {
		LicAgreeBtn.click();
		implicitWait(2);
		changeServerBtn.click();
		implicitWait(4);
		advancedBtn.click();
		implicitWait(2);
		hostNameTextBox.sendKeys(hostname);
		testConnectionBtn.click();
		implicitWait(2);
		sucessTestConnectionOKBtn.click();
		implicitWait(2);
		saveBtn.click();
		implicitWait(2);
		backBtn.click();
		implicitWait(2);
		locationDetailsBtn.click();
		implicitWait(2);
		storeTextBox.sendKeys(store);
		registerTextBox.sendKeys(register);
		saveBtn.click();
		implicitWait(2);
		saveBtn.click();
		implicitWait(2);
		allowDeviceAccessBtn.click();
		implicitWait(2);
		empIDTextBox.sendKeys(empID);
		pwdTextBox.sendKeys(pwd);
		implicitWait(2);
		okBtn.click();		
		implicitWait(8);
	}
	
	public void associateSignOn(String empId,String pwd) {
		 try {
				Thread.sleep(4000);
				amtDueBtn.click();
				implicitWait(2);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // 
		associateIDTextBox.sendKeys(empId);
		associateIDTextBox.sendKeys(Keys.ENTER);
		implicitWait(2);
		associatePWDTextBox.sendKeys(pwd);
		associateSignOnOKbtn.click();
		implicitWait(4);
	}
	
	public void startSale() {
		startSaleBtn.click();
		implicitWait(2);
	}
	
	public void searchNSelectCustomer(String custEmail) {
		custEmailTextBox.sendKeys(custEmail);
		nextBtn.click();
		implicitWait(4);
		custList.click();
		implicitWait(12);
		loyaltyNotNowBtn.click();
		implicitWait(6);
	}
	
	public void searchSKU(String skuID) {
		scanSKUTextBox.sendKeys(skuID);
		scanSKUTextBox.sendKeys(Keys.ENTER);
		implicitWait(4);
	}
	
	public void  clickAmountDue() {
		 
             try {
				Thread.sleep(4000);
				amtDueBtn.click();
				implicitWait(2);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // Sleep for 1 second
         
		
	}
	public void skipGWPScan() {
		if (skipGWPScanBtn.isDisplayed()) {
		skipGWPScanBtn.click();
		implicitWait(2);
		}
	}
	
	public void selectCreditCardPaymentTender() {
		creditDebitCardBtn.click();
		implicitWait(1);
		try {
			Thread.sleep(2000);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // Sleep for 1 second
     
		confirmAmtOKBtn.click();
		implicitWait(12);
		
	}
	
	public void retryTender() {
		
		try {
			Thread.sleep(10000);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // Sleep for 1 second
     
		
		if (retryTenderBtn.isDisplayed()) {
			retryTenderBtn.click();
			
		}
			
	
		
	}
	
	public void  selectPinpad() {
		
		try {
			Thread.sleep(10000);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // Sleep for 1 second
     
			pinPad1btn.click();
			implicitWait(12);
	}
	
	public void emailOnlyReciept() {
		try {
			Thread.sleep(10000);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // Sleep for 1 second
     
		emailReceiptBtn.click();
		implicitWait(2);
		emailOnlyBtn.click();
		implicitWait(2);
	}
	
	public void confirmMinTenderAmtThresholdPopup() {
		if (minTenderThresholdAmtConfirmOKBtn.isDisplayed()){
			minTenderThresholdAmtConfirmOKBtn.click();
		}
	}
	
	/*
	 * @FindBy(xpath=
	 * "//div[@id='customer-dashboard-title']//h5[@data-component-id='SelectedOrg']")
	 * public WebElement orgDropDown;
	 */
	
	/*
	 * public void agreeLicenseAgreement() { LicAgreeBtn.click(); }
	 * 
	 * public void clickChangeServer() { changeServerBtn.click(); }
	 * 
	 * public void clickAdvanced() { advancedBtn.click(); }
	 */
	
	
}
