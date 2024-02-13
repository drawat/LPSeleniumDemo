package LPMAOSeleniumPOC.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import LPMAOSeleniumPOC.Utilities.Browser.WebPage;

public class MAOLaunchAndLogin extends WebPage {
	

	public static final String MAO_Launch_URL = "https://lilyv.omni.manh.com/";
	
	public static final String MAO_Login_URL = "https://lilyv-auth.omni.manh.com/org_login";
	
	public MAOLaunchAndLogin(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void openURL() {
		driver.get(MAO_Launch_URL);
		waitForPageToLoad(MAO_Login_URL);
		PageFactory.initElements(driver, this);
		
	}
	//Page Object "Username"
    @FindBy(id="login-username")                                  
    public WebElement usr;
    
  //Page Object "Password"
    @FindBy(id="login-password") 
    public WebElement pwd;
  
  //Page Object "Log in button"
    @FindBy(id="login-submit") 
    public WebElement loginButton;
  
    public MAOHomeLandingPage Login(String username, String password) {
    	usr.sendKeys(username);
    	pwd.sendKeys(password);
    	loginButton.click();
    	waitForPageToLoad(MAOHomeLandingPage.MAO_HOME_URL);
    	return PageFactory.initElements(driver, MAOHomeLandingPage.class);
    	
    }
    
}
