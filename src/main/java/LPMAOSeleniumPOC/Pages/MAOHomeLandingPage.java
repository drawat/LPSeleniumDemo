package LPMAOSeleniumPOC.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import LPMAOSeleniumPOC.Utilities.Browser.WebPage;

public class MAOHomeLandingPage extends WebPage{
	
	public static final String MAO_HOME_URL = "https://lilyv.omni.manh.com/omnifacade/#/home";


	public MAOHomeLandingPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void openURL() {
		// TODO Auto-generated method stub
		driver.get(MAO_HOME_URL);
		waitForPageToLoad(MAO_HOME_URL);
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "/html/body/my-app/md-sidenav-layout/div[2]/md-toolbar/div/md-toolbar-row/button[1]")
	public WebElement menuButton;

	@FindBy(xpath = "//md-select[@aria-label='Organization']/div[@class='md-select-trigger']")
	public WebElement OrganizationDropDown;
	
	@FindBy(className = "md-select-arrow")
	public WebElement profileDropdown;
	
	@FindBy(className="md-select-trigger")
	public WebElement[] elements;
	
	@FindBy(xpath = "//div[@class='first-left tile']//div[@class='item']")
	public WebElement cusServericeURL;
	
	/*
	 * public void clickMenu() { menuButton.click();
	 * 
	 * }
	 */
	public boolean menuButtonExists() {
	return	menuButton.isDisplayed();
	}
	
	public void setOrginization(String strOrg){
	//	elements[0].click();
		driver.findElements(By.className("md-select-value")).getFirst().click();
		implicitWait(implicitWaitTime);
		waitForElement(By.id("md-input-0")).sendKeys(strOrg);
		driver.findElements(By.className("md-ripple-background")).getLast().click();
		implicitWait(implicitWaitTime);
				
	}
	/*
	 * public void setProfile(String strProfile) { List<WebElement> elements =
	 * driver.findElements(By.className("md-select-value")); WebElement
	 * specificElement = elements.getLast(); specificElement.click();
	 * implicitWait(implicitWaitTime);
	 * waitForElement(By.id("md-input-1")).sendKeys(strProfile);; }
	 */
	
	public MAOCSRPage navigateToCSRUI() {
				cusServericeURL.click();
		implicitWait(implicitWaitTime);
		switchToNewWindow();
		waitForPageToLoad(MAOCSRPage.MAO_CSR_URL);
		return PageFactory.initElements(driver, MAOCSRPage.class);
	}
}
