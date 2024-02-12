package LPMAOSeleniumPOC.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
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
		waitForPageToLoad();
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "/html/body/my-app/md-sidenav-layout/div[2]/md-toolbar/div/md-toolbar-row/button[1]")
	public WebElement menuButton;

	@FindBy(className = "md-select-arrow")
	public WebElement OrganizationDropDown;
	
	@FindBy(className = "md-select-arrow")
	public WebElement profileDropdown;
	
	/*
	 * public void clickMenu() { menuButton.click();
	 * 
	 * }
	 */
	public boolean menuButtonExists() {
	return	menuButton.isDisplayed();
	}
}
