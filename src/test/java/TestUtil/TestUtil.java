package TestUtil;

import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.apache.log4j.BasicConfigurator;
import org.openqa.selenium.Capabilities;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

//import ru.stqa.selenium.factory.WebDriverPool;
import LPMAOSeleniumPOC.Utilities.Browser.*;
//import io.github.bonigarcia.wdm.WebDriverManager;


public class TestUtil {
private WebDriver driver ;
	
	public WebDriver getNewDriver(String Browser){
	//	Driver driverType = Driver.FIREFOX;
		driver  = WebPage.getNewDriver(Browser);
		return driver;
	}
	@BeforeSuite(alwaysRun = true)
	public void setupChrome() {
		//WebDriverManager.chromedriver().setup();
		BasicConfigurator.configure();
	}
	
	@AfterSuite(alwaysRun = true)
	public void teardown() throws IOException{
		try {
				driver.quit();
			} catch (Exception e){
				//swallow
			}
	}
	


}
