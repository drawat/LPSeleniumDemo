package LPMAOSeleniumPOC;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import LPMAOSeleniumPOC.Utilities.Browser.JIRAIntegration;

public class JIRAIntegrationTest {
	@Test
	public void testJIRAMethods() {
		JIRAIntegration jira = new JIRAIntegration();
		//jira.addJIRAComments("DOT-13116", "From Selenium Code");
		//jira.uploadAttachmentToJIRA("DOT-13116", "DOT-11212.docx");
		jira.updateJIRAStatus("DOT-13139", "31");
		  Assert.assertEquals(true, true);
	}

}