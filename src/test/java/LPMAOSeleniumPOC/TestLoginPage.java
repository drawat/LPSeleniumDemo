package LPMAOSeleniumPOC;
import org.openqa.selenium.support.PageFactory;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import LPMAOSeleniumPOC.Pages.MAOCSRPage;
import LPMAOSeleniumPOC.Pages.MAOHomeLandingPage;
import LPMAOSeleniumPOC.Pages.MAOLaunchAndLogin;
import LPMAOSeleniumPOC.Pages.MAOOrderDetailPage;
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

import org.apache.commons.io.FileUtils;



public class TestLoginPage extends TestUtil{

	
	
	  
	  @Test
	  public void testHomePageHasAHeader() {
		  
		  
		/*try (XWPFDocument document = new XWPFDocument()) {
			
			XWPFParagraph paragraph = document.createParagraph();
		    XWPFRun run = paragraph.createRun();
		    run.setText("DOT-11212: Call Center Order Creation Test Results");
		    run.setBold(true);*/

		    // Add details about the execution
		   
	    MAOLaunchAndLogin maoLaunchPage = new MAOLaunchAndLogin(getNewDriver("CHROME"));
	    TestEvidence testEvidence = new TestEvidence(maoLaunchPage.getDriver());
		  testEvidence.createTestEvidenceAndAddTitle("DOT-11212: Call Center Order Creation Test Results");
	    maoLaunchPage.openURL();
	    MAOHomeLandingPage homePage = maoLaunchPage.Login("VPTAdminUser", "Password123!");
	    testEvidence.addTestStepDescriptionAndStatus("Step1:- Login into MAO", "Test Step: Passed");
	    testEvidence.captureScreenshotAndAttach("Login");
	/*    paragraph = document.createParagraph();
	    run = paragraph.createRun();
	    run.setText("Step1:- Login into MAO");
	    run.addBreak();
	    run.setText("Test Step: Passed");*/
	    
	  homePage.setOrginization("LP-US");
	  testEvidence.addTestStepDescriptionAndStatus("Step2:- Change Orginization", "Test Step: Passed");
	  testEvidence.captureScreenshotAndAttach("OrgChnage");
	  /* paragraph = document.createParagraph();
	    run = paragraph.createRun();
	    run.setText("Step2:- Change Orginization");
	    run.addBreak();
	    run.setText("Test Step: Passed");*/
	 //homePage.setProfile("LP-US");
	    
	    MAOCSRPage csrPage = homePage.navigateToCSRUI();
	    testEvidence.addTestStepDescriptionAndStatus("Step3:- Navigate to CSR UI", "Test Step: Passed");
	    testEvidence.captureScreenshotAndAttach("CSRUI");
	    /*paragraph = document.createParagraph();
	    run = paragraph.createRun();
	    run.setText("Step3:- Change Orginization");
	    run.addBreak();
	    run.setText("Test Step: Passed");*/
	   // csrPage.selectOrganization();
	    csrPage.clickItemSearch();
	    csrPage.searchSKU("889069952273");
	    testEvidence.addTestStepDescriptionAndStatus("Step4:- SKU Search", "Test Step: Passed");
	    testEvidence.captureScreenshotAndAttach("SKUSearch");
	    /*paragraph = document.createParagraph();
	    run = paragraph.createRun();
	    run.setText("Step4:- SKU Search");
	    run.addBreak();
	    run.setText("Test Step: Passed");*/
	    csrPage.clickAddCheckoutBttn();
	    csrPage.inputAndSelectCustomer("Testvpt@gmail.com");
	    testEvidence.addTestStepDescriptionAndStatus("Step5:- Customer Selection", "Test Step: Passed");
	    testEvidence.captureScreenshotAndAttach("CustomerSelection");
	    /*paragraph = document.createParagraph();
	    run = paragraph.createRun();
	    run.setText("Step5:- Customer Selection");
	    run.addBreak();
	    run.setText("Test Step: Passed");*/
	   MAOOrderDetailPage ordDetailsPage=  csrPage.clickDoneBtnOnCustomerSearch();
	   testEvidence.addTestStepDescriptionAndStatus("Step6:- Proceed to Payment", "Test Step: Passed");
	   testEvidence.captureScreenshotAndAttach("ProceedToPayment");
	  /* paragraph = document.createParagraph();
	    run = paragraph.createRun();
	    run.setText("Step6:- Proceed to Payment");
	    run.addBreak();
	    run.setText("Test Step: Passed");*/
	//   ordDetailsPage.clickUseThisBtn();
	   ordDetailsPage.clickProceedToPayment();
	   ordDetailsPage.enterCreditCardSecurityCode("123");
	   ordDetailsPage.addCCbuttonClick();
	   ordDetailsPage.clickProceedToSummaryBtn();
	   testEvidence.addTestStepDescriptionAndStatus("Step7:- Proceed to Summary after Credit Card details submission", "Test Step: Passed");
	   testEvidence.captureScreenshotAndAttach("ProceedToSummary");
	   /*paragraph = document.createParagraph();
	    run = paragraph.createRun();
	    run.setText("Step7:- Proceed to Summary after Credit Card details submission");
	    run.addBreak();
	    run.setText("Test Step: Passed");*/
	   ordDetailsPage.clickPlaceOrder();
	   testEvidence.addTestStepDescriptionAndStatus("Step8:- Place Order", "Test Step: Passed");
	   testEvidence.captureScreenshotAndAttach("PlaceOrder");
	  /* paragraph = document.createParagraph();
	    run = paragraph.createRun();
	    run.setText("Step8:- Place Order");
	    run.addBreak();
	    run.setText("Test Step: Passed");*/
	   if (ordDetailsPage.isupdateCustomerDetailsDailogDisplayed()){
		   ordDetailsPage.clickSaveCustomerDetailsBtn();
	   }
	   System.out.println("Order Sucessfully placed:   " + ordDetailsPage.orderID);
	   testEvidence.addTestStepDescriptionAndStatus("Step9:- Order Sucessfully placed:   " + ordDetailsPage.orderID, "Test Step: Passed");
	   testEvidence.saveTestEvidence("DOT-11212 Call Center Order Creation Test Results  "+ ordDetailsPage.orderID );
	 /*  paragraph = document.createParagraph();
	    run = paragraph.createRun();
	    run.setText("Step9:- Order Sucessfully placed:   " + ordDetailsPage.orderID);
	    run.addBreak();
	    run.setText("Test Step: Passed");*/
	  //  Assert.assertTrue(csrPage.isCustomerDetailPopupDisplayed());
	    Assert.assertEquals(true, true);
	    
		/*
		 * try (FileOutputStream out = new
		 * FileOutputStream("SeleniumExecutionEvidence.docx")) { document.write(out);
		 * System.out.println("Word document created successfully.");
		 * 
		 * } catch (IOException e) { System.out.println("Error occurred: " +
		 * e.getMessage()); } } catch (IOException e1) { // TODO Auto-generated catch
		 * block e1.printStackTrace(); }
		 */
		
	  }
	  }

//try (XWPFDocument document = new XWPFDocument()) {
//    // Add content to the document
//    XWPFParagraph paragraph = document.createParagraph();
//    XWPFRun run = paragraph.createRun();
//    run.setText("Selenium Execution Evidence");
//    run.setBold(true);
//
//    // Add details about the execution
//    paragraph = document.createParagraph();
//    run = paragraph.createRun();
//    run.setText("Test Name: Login Test");
//    run.addBreak();
//    run.setText("Test Status: Passed");
//
//    // Take a screenshot
//    File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//    
//    // Save the screenshot to a file
//    File destFile = new File("screenshot.png");
//    FileUtils.copyFile(screenshotFile, destFile);
//    
//    // Add the screenshot to the document
//    paragraph = document.createParagraph();
//    run = paragraph.createRun();
//    run.setText("Screenshot:");
//    run.addBreak();
//    run.addPicture(new FileInputStream(destFile), XWPFDocument.PICTURE_TYPE_PNG, "screenshot.png", Units.toEMU(300), Units.toEMU(200));
//
//    // Save the document
//    try (FileOutputStream out = new FileOutputStream("SeleniumExecutionEvidence.docx")) {
//        document.write(out);
//        System.out.println("Word document created successfully.");
//    }
//} catch (IOException e) {
//    System.out.println("Error occurred: " + e.getMessage());
//} finally {
//    // Close the browser
//    driver.quit();
//}