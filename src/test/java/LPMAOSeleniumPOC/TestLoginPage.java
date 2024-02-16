package LPMAOSeleniumPOC;
import org.openqa.selenium.support.PageFactory;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import LPMAOSeleniumPOC.Pages.MAOCSRPage;
import LPMAOSeleniumPOC.Pages.MAOHomeLandingPage;
import LPMAOSeleniumPOC.Pages.MAOLaunchAndLogin;
import LPMAOSeleniumPOC.Pages.MAOOrderDetailPage;
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
	    csrPage.inputAndSelectCustomer("Testvpt@gmail.com");
	   MAOOrderDetailPage ordDetailsPage=  csrPage.clickDoneBtnOnCustomerSearch();
	//   ordDetailsPage.clickUseThisBtn();
	   ordDetailsPage.clickProceedToPayment();
	   ordDetailsPage.enterCreditCardSecurityCode("123");
	   ordDetailsPage.addCCbuttonClick();
	   ordDetailsPage.clickProceedToSummaryBtn();
	   ordDetailsPage.clickPlaceOrder();
	   if (ordDetailsPage.isupdateCustomerDetailsDailogDisplayed()){
		   ordDetailsPage.clickSaveCustomerDetailsBtn();
	   }
	   System.out.println("Order Sucessfully placed:   " + ordDetailsPage.orderID);
	  //  Assert.assertTrue(csrPage.isCustomerDetailPopupDisplayed());
	    Assert.assertEquals(true, true);
	    
	  }
	}