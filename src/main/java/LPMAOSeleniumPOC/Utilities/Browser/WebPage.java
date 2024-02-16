package LPMAOSeleniumPOC.Utilities.Browser;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.InvalidParameterException;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

//import io.github.bonigarcia.wdm.WebDriverManager;

public abstract class WebPage extends PageSupport {
	
	public static int implicitWaitTime = 5;
	
	public WebPage(WebDriver driver){
		super(driver);
	}
	
	public enum Driver{
		FIREFOX,
		SAFARI,
		IE,
		CHROME,
		FFGRID,
		HTMLUNIT;
		
	}
	
	public static WebDriver getNewDriver(Driver driverType){
		switch (driverType) {
		case FIREFOX:
//		DesiredCapabilities cp = DesiredCapabilities.firefox();
//			cp.setCapability("platform", Platform.LINUX);
//			cp.setCapability("binary", "//usr//bin//firefox");
//			return new FirefoxDriver(cp);
		
        	/*FirefoxBinary binary = new FirefoxBinary(new File("//usr//bin//firefox"));
			FirefoxProfile profile = new FirefoxProfile();
			return new FirefoxDriver(binary, profile);*/
		return new FirefoxDriver();
		case SAFARI:
			return new SafariDriver();
		case CHROME:
		//	File file = new File("//home//af832b//chromedriver");
			//ChromeDriverService chromeservice = new ChromeDriverService();
			//WebDriverManager.chromedriver().setup();
		//	WebDriverManager.chromedriver().clearDriverCache().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized");
	//		service = Service(ChromeDriverManager().install())

			/*
			 * options.addArguments("disable-infobars"); // disabling infobars
			 * options.addArguments("--disable-extensions"); // disabling extensions
			 * options.addArguments("--disable-gpu"); // applicable to Windows os only
			 * options.addArguments("--disable-dev-shm-usage"); // overcome limited resource
			 * problems options.addArguments("--no-sandbox"); // Bypass OS security model
			 * options.addArguments("--disable-in-process-stack-traces");
			 * options.addArguments("--disable-logging");
			 * options.addArguments("--log-level=3");
			 * options.addArguments("--remote-allow-origins=*");
			 */
			  
			    System.setProperty("webdriver.chrome.driver", "C:\\Users\\DRAWAT\\eclipse-workspace\\Drivers\\chromedriver.exe");
//			DesiredCapabilities ieCapabilities = DesiredCapabilities.chrome();
//			ieCapabilities.setCapability("platform", Platform.WINDOWS);
//			ieCapabilities.setCapability("binary", "//home//af832b//chromedriver");
//			ieCapabilities.setCapability(ChromeOptions.CAPABILITY, options);
			return new ChromeDriver(options);
			//return new ChromeDriver();
		case IE:			
			System.setProperty("webdriver.ie.driver", "C:\\Setups\\IEDriverServer.exe");
			return new InternetExplorerDriver();
			/*DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
			ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			ieCapabilities.setCapability("ensureCleanSession", true);
			return new InternetExplorerDriver(ieCapabilities);
			*/
			/*
			 * case FFGRID: DesiredCapabilities capability = DesiredCapabilities. try {
			 * return new RemoteWebDriver(new URL(""), capability); } catch
			 * (MalformedURLException e) { e.printStackTrace(); return null; }
			 */
		default:
			throw new InvalidParameterException("You must choose one of the defined driver types");
		}
	}
	
	public WebDriver getDriver(){
		return driver;
	}
	
	public static WebDriver getNewDriver(String Browser){
		return getNewDriver(Driver.valueOf(Browser.toUpperCase()));
	}
	
	public void refresh(){
		driver.navigate().refresh();
	}
	
	public String getCurrentURL(){
		return driver.getCurrentUrl();
	}
	
	public abstract void openURL();
	
	public void logout(){
	//	driver.findElement(By.name("signOut")).click();
		driver.findElement(By.name("signout")).click();
		implicitWait(3);
		waitForAjaxInactivity();
	//	driver.findElement(By.id("dropdown-toggle-temp")).click();
		//driver.findElement(By.xpath("//*[@id='btn-nav-menu']/span")).click();
	 //   driver.findElement(By.xpath("//*[@id='dropown-menu-temp']/li[3]/a")).click();
	//    driver.quit();
	}
	
	public void closeBrowser(){
		driver.quit();
	}

}