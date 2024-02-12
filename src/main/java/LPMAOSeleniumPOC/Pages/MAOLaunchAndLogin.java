package LPMAOSeleniumPOC.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import LPMAOSeleniumPOC.Utilities.Browser.WebPage;

public class MAOLaunchAndLogin extends WebPage {
	

	public static final String MAO_URL = "https://lilyv-auth.omni.manh.com/org_login";
	
	public MAOLaunchAndLogin(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void openURL() {
		driver.get(MAO_URL);
		waitForPageToLoad();
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
    	waitForPageToLoad();
    	return PageFactory.initElements(driver, MAOHomeLandingPage.class);
    	
    }
    
}
