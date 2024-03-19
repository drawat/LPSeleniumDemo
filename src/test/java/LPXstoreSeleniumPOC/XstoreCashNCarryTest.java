package LPXstoreSeleniumPOC;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.testng.Assert;
import org.testng.annotations.Test;

import LPMAOSeleniumPOC.Utilities.Browser.JIRAIntegration;
import LPMAOSeleniumPOC.Utilities.Evidence.TestEvidence;
import LPXstoreSeleniumPOC.Pages.XstoreLogin;
import TestUtil.TestUtil;

public class XstoreCashNCarryTest extends TestUtil{
	
	@Test
	  public void testXstoreCashNCarryOrder() {
		
		TestEvidence testEvidence;
		String evdFileName;
		LocalDateTime timestamp = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
		String formattedTimestamp = timestamp.format(formatter);
		XstoreLogin xlogin= new XstoreLogin(getNewDriver("CHROME"));
		testEvidence = new TestEvidence(xlogin.getDriver());
		JIRAIntegration jira = new JIRAIntegration();
		testEvidence.createTestEvidenceAndAddTitle("DOT-13741: CashNCarry Order Creation Test Results");
		
		try {
			xlogin.openURL();
			xlogin.xstoreLaunchNlogin("lpoe1269-001.lillypulitzer.biz", "269", "38", "9001", "Lilly1234!");
			xlogin.associateSignOn("9001", "Lilly1234!");
			testEvidence.addTestStepDescriptionAndStatus("Step1:- Pre-setup and Login into Xstore", "Test Step: Passed");
			testEvidence.captureScreenshotAndAttach("XstoreLogin");
			xlogin.startSale();
			testEvidence.addTestStepDescriptionAndStatus("Step2:- Start Sales", "Test Step: Passed");
			testEvidence.captureScreenshotAndAttach("StartSales");
			xlogin.searchNSelectCustomer("fin1test@yopmail.com");
			testEvidence.addTestStepDescriptionAndStatus("Step3:- Search and Select Customer", "Test Step: Passed");
			testEvidence.captureScreenshotAndAttach("SearchNSelectCustomer");
			xlogin.searchSKU("889069941642");
			testEvidence.addTestStepDescriptionAndStatus("Step4:- Search SKU", "Test Step: Passed");
			testEvidence.captureScreenshotAndAttach("SearchSKU");
			xlogin.clickAmountDue();
			xlogin.skipGWPScan();
			testEvidence.addTestStepDescriptionAndStatus("Step5:- Proceed to Payment", "Test Step: Passed");
			testEvidence.captureScreenshotAndAttach("ProceedToPayment");
			xlogin.selectCreditCardPaymentTender();
			xlogin.retryTender();
			xlogin.selectPinpad();
			testEvidence.addTestStepDescriptionAndStatus("Step6:- Email Reciept", "Test Step: Passed");
			testEvidence.captureScreenshotAndAttach("EmailReciept");
			xlogin.emailOnlyReciept();
			xlogin.confirmMinTenderAmtThresholdPopup();
			testEvidence.addTestStepDescriptionAndStatus("Step7:- Sale Completion", "Test Step: Passed");
			testEvidence.captureScreenshotAndAttach("SaleCompletion");
			evdFileName ="DOT-13741_CNC_OrderCreation_TestResults" + formattedTimestamp;
			testEvidence.saveTestEvidence(evdFileName);
			jira.addJIRAComments("DOT-13741", "Test Case:- Passed (Attachment: " + evdFileName + ".docx)");
			jira.uploadAttachmentToJIRA("DOT-13741", evdFileName +".docx");
			jira.updateJIRAStatus("DOT-13741", "31");
			Assert.assertEquals(true, true);
		}
		catch (Exception e) {
			System.out.println(e.toString());
			testEvidence.addTestStepDescriptionAndStatus("Step Error:- Delayed response or Error Occured", "Test Step: Failed");
			testEvidence.captureScreenshotAndAttach("ErrorSnapshot");
			evdFileName ="DOT-13741_CNC_OrderCreation_TestResults Failed" + formattedTimestamp;
			testEvidence.saveTestEvidence(evdFileName);
			jira.addJIRAComments("DOT-13741", "Test Case:- Failed, please refer (Attachment: " + evdFileName + ".docx) for more details");
			jira.uploadAttachmentToJIRA("DOT-13741", evdFileName +".docx");
			jira.updateJIRAStatus("DOT-13741", "61");
			Assert.assertEquals(true, false);
		}

	}
}
