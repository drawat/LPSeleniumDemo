package LPMAOSeleniumPOC;
import org.openqa.selenium.support.PageFactory;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import LPMAOSeleniumPOC.Utilities.Excel.ExcelObject;
import LPMAOSeleniumPOC.Pages.MAOCSRPage;
import LPMAOSeleniumPOC.Pages.MAOHomeLandingPage;
import LPMAOSeleniumPOC.Pages.MAOLaunchAndLogin;
import LPMAOSeleniumPOC.Pages.MAOOrderDetailPage;
import LPMAOSeleniumPOC.Utilities.Browser.JIRAIntegration;
import LPMAOSeleniumPOC.Utilities.Browser.WebPage;
import LPMAOSeleniumPOC.Utilities.Evidence.TestEvidence;
import TestUtil.TestUtil;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;


//https://oxfordinc.atlassian.net/browse/DOT-13116
public class TestLoginPage extends TestUtil{
	public ExcelObject xlsObj;

	@BeforeTest
	public void openTestDataFile() {
		//xlsObj = new ExcelObject("C:\\Users\\DRAWAT\\eclipse-workspace\\LPSeleniumDemo\\TestDataSheet\\OrderCreation.xls", "Sheet1");
		//xlsObj.openExcel();
			//System.out.println("Excel org:   " + xlsObj.readCellData(2, 1));	
	}
	
	  
	  @Test
	  public void testHomePageHasAHeader() {
		  TestEvidence testEvidence;
			String evdFileName;
			LocalDateTime timestamp = LocalDateTime.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
			String formattedTimestamp = timestamp.format(formatter);
			MAOLaunchAndLogin maoLaunchPage = new MAOLaunchAndLogin(getNewDriver("CHROME"));
			JIRAIntegration jira = new JIRAIntegration();
			 testEvidence = new TestEvidence(maoLaunchPage.getDriver());
			  testEvidence.createTestEvidenceAndAddTitle("DOT-13139: Call Center Order Creation Test Results");
		  try {
		
		 
		  maoLaunchPage.openURL();
		  MAOHomeLandingPage homePage = maoLaunchPage.Login("VPTAdminUser", "Password123!");
		  testEvidence.addTestStepDescriptionAndStatus("Step1:- Login into MAO", "Test Step: Passed");
		  testEvidence.captureScreenshotAndAttach("Login");


		 // homePage.setOrginization(xlsObj.readCellData(2, 1));
		  homePage.setOrginization("LP-US");
		  testEvidence.addTestStepDescriptionAndStatus("Step2:- Change Organization", "Test Step: Passed");
		  testEvidence.captureScreenshotAndAttach("OrgChnage");


		  MAOCSRPage csrPage = homePage.navigateToCSRUI();
		  testEvidence.addTestStepDescriptionAndStatus("Step3:- Navigate to CSR UI", "Test Step: Passed");
		  testEvidence.captureScreenshotAndAttach("CSRUI");

		  csrPage.clickItemSearch();
		 // csrPage.searchSKU(xlsObj.readCellData(2, 2));
		  csrPage.searchSKU("889069952273");
		  testEvidence.addTestStepDescriptionAndStatus("Step4:- SKU Search", "Test Step: Passed");
		  testEvidence.captureScreenshotAndAttach("SKUSearch");

		  csrPage.clickAddCheckoutBttn();
		  //csrPage.inputAndSelectCustomer(xlsObj.readCellData(2, 3));
		  csrPage.inputAndSelectCustomer("Testvpt@gmail.com");
		  testEvidence.addTestStepDescriptionAndStatus("Step5:- Customer Selection", "Test Step: Passed");
		  testEvidence.captureScreenshotAndAttach("CustomerSelection");

		  MAOOrderDetailPage ordDetailsPage=  csrPage.clickDoneBtnOnCustomerSearch();
		  testEvidence.addTestStepDescriptionAndStatus("Step6:- Proceed to Payment", "Test Step: Passed");
		  testEvidence.captureScreenshotAndAttach("ProceedToPayment");

		  ordDetailsPage.clickProceedToPayment();
		//  ordDetailsPage.enterCreditCardSecurityCode(xlsObj.readCellData(2, 4));
		  ordDetailsPage.enterCreditCardSecurityCode("123");
		  ordDetailsPage.addCCbuttonClick();
		  ordDetailsPage.clickProceedToSummaryBtn();
		  testEvidence.addTestStepDescriptionAndStatus("Step7:- Proceed to Summary after Credit Card details submission", "Test Step: Passed");
		  testEvidence.captureScreenshotAndAttach("ProceedToSummary");

		  ordDetailsPage.clickPlaceOrder();
		  testEvidence.addTestStepDescriptionAndStatus("Step8:- Place Order", "Test Step: Passed");
		  testEvidence.captureScreenshotAndAttach("PlaceOrder");

		  if (ordDetailsPage.isupdateCustomerDetailsDailogDisplayed()){
			  ordDetailsPage.clickSaveCustomerDetailsBtn();
		  }
		  
		  if (ordDetailsPage.isConfirmCustInfoDailogDisplayed()){
			  ordDetailsPage.clickDoneCustInformBtn();
		  }
		  System.out.println("Order Sucessfully placed:   " + ordDetailsPage.orderID);
		//  xlsObj.writeCellData(2, 5, ordDetailsPage.orderID);
		  testEvidence.addTestStepDescriptionAndStatus("Step9:- Order Successfully placed:   " + ordDetailsPage.orderID, "Test Step: Passed");
		  testEvidence.saveTestEvidence("DOT-13139_CC_OrderCreation_TestResults "+ ordDetailsPage.orderID );
		  
		  jira.addJIRAComments("DOT-13139", "Test Case:- Passed (Attachment: " + ordDetailsPage.orderID+ ".docx)");
		 // jira.updateJIRAStatus("DOT-13139", "31");
		  jira.uploadAttachmentToJIRA("DOT-13139", "DOT-13139_CC_OrderCreation_TestResults "+ ordDetailsPage.orderID +".docx");
		  jira.updateJIRAStatus("DOT-13139", "31");
		  Assert.assertEquals(true, true);
		  
	  }
		catch (Exception e) {
			System.out.println(e.toString());
			testEvidence.addTestStepDescriptionAndStatus("Step Error:- Delayed response or Error Occured", "Test Step: Failed");
			testEvidence.captureScreenshotAndAttach("ErrorSnapshot");
			evdFileName ="DOT-13139_CC_OrderCreation_TestResults Failed" + formattedTimestamp;
			testEvidence.saveTestEvidence(evdFileName);
			jira.addJIRAComments("DOT-13139", "Test Case:- Failed, please refer (Attachment: " + evdFileName + ".docx) for more details");
			jira.uploadAttachmentToJIRA("DOT-13139", evdFileName +".docx");
			jira.updateJIRAStatus("DOT-13139", "61");
			Assert.assertEquals(true, false);
		}

	    
	}
	  @AfterTest
	  public void closeExcel() {
			//xlsObj.saveExcel();
		//	xlsObj.closeExcel();
	  }
	  
}

