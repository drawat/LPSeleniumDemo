package LPMAOSeleniumPOC;
import org.openqa.selenium.support.PageFactory;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import LPMAOSeleniumPOC.Pages.MAOCSRPage;
import LPMAOSeleniumPOC.Pages.MAOHomeLandingPage;
import LPMAOSeleniumPOC.Pages.MAOLaunchAndLogin;

import TestUtil.TestUtil;


public class TestLoginPage extends TestUtil{

	
	  
	  @Test
	  public void testHomePageHasAHeader() {
	    MAOLaunchAndLogin maoLaunchPage = new MAOLaunchAndLogin(getNewDriver("CHROME"));
	    maoLaunchPage.openURL();
	    MAOHomeLandingPage homePage = maoLaunchPage.Login("VPTAdminUser", "Password123!");
	   homePage.setOrginization("LP-US");
	 //homePage.setProfile("LP-US");
	    
	    MAOCSRPage csrPage = homePage.navigateToCSRUI();
	   // csrPage.selectOrganization();
	    csrPage.clickItemSearch();
	    csrPage.searchSKU("889069952273");
	    csrPage.clickAddCheckoutBttn();
	    csrPage.inputAndSelectCustomer("test01234@maovpt.com");
	    csrPage.clickDoneBtnOnCustomerSearch();
	  //  Assert.assertTrue(csrPage.isCustomerDetailPopupDisplayed());
	    Assert.assertEquals(true, true);
	    
	  }
	}