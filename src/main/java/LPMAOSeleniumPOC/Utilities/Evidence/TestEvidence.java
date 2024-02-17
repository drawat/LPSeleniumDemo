package LPMAOSeleniumPOC.Utilities.Evidence;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import LPMAOSeleniumPOC.Utilities.Browser.WebPage;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class TestEvidence extends WebPage{
	
	public TestEvidence(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	

	XWPFDocument document = new XWPFDocument();
	XWPFParagraph paragraph;
	XWPFRun run;
	
	public void createTestEvidenceAndAddTitle(String strHeader) {
		 paragraph = document.createParagraph();
		  run = paragraph.createRun();
		  run.setText(strHeader);
		  run.setBold(true);

	}
	
	public void addTestStepDescriptionAndStatus(String stepDesc, String stepStatus) {
		 paragraph = document.createParagraph();
		 run = paragraph.createRun();
		  run.setText(stepDesc);
		  run.addBreak();
		  run.setText(stepStatus);
	}
	
	public void captureScreenshotAndAttach(String screenshotName) {
		try {
			// Take a screenshot
        
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        
        // Save the screenshot to a file
        File destFile = new File(screenshotName + ".png");
        
			FileUtils.copyFile(screenshotFile, destFile);
			run.addBreak();
			run.addPicture(new FileInputStream(destFile), XWPFDocument.PICTURE_TYPE_PNG, screenshotName + ".png", Units.toEMU(300), Units.toEMU(200));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void saveTestEvidence(String testEvidenceFileName) {
		try (FileOutputStream out = new FileOutputStream(testEvidenceFileName + ".docx")) {
			System.out.println(testEvidenceFileName + ".docx");
			
		      document.write(out);
		      System.out.println("Word document created successfully.");
		  }
		 catch (IOException e) {
		  System.out.println("Error occurred: " + e.getMessage());
		}
	}

	@Override
	public void openURL() {
		// TODO Auto-generated method stub
		
	}

}
