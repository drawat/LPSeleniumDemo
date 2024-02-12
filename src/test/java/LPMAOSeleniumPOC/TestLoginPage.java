package LPMAOSeleniumPOC;
import org.openqa.selenium.support.PageFactory;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import LPMAOSeleniumPOC.Pages.MAOHomeLandingPage;
import LPMAOSeleniumPOC.Pages.MAOLaunchAndLogin;

import TestUtil.TestUtil;


public class TestLoginPage extends TestUtil{

	
	  
	  @Test
	  public void testHomePageHasAHeader() {
	    MAOLaunchAndLogin maoLaunchPage = new MAOLaunchAndLogin(getNewDriver("CHROME"));
	    maoLaunchPage.openURL();
	    MAOHomeLandingPage homePage = maoLaunchPage.Login("VPTAdminUser", "Password123!");
	    Assert.assertTrue(homePage.menuButtonExists());
	  }
	}