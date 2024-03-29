package LPMAOSeleniumPOC.Utilities.Browser;


import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public abstract class PageSupport {
	
	protected WebDriver driver;
	
	
	public PageSupport(WebDriver driver){
		this.driver = driver;
	}
	
	protected WebElement waitForElement(WebElement element, int maxTimeSeconds){
		int loops = maxTimeSeconds*4;
		for (int i=0; i<loops; i++){
			try {				
				if (element.isDisplayed()){
					return element;
				}

				try {
					Thread.sleep(500L);
				} catch (InterruptedException e) {
					// try again;
				}
			} catch (Exception e) {
				// try again
				try {
					Thread.sleep(500L);
				} catch (InterruptedException e1) {
					// try again;
				}
			}
		}
		return null;
	}
	
	protected WebElement waitForElement(WebElement element){
		return waitForElement(element, 5);
	}
	
	protected void sleep(Long milliseconds){
		try {
			Thread.sleep(1000l);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	protected boolean elementExist(By by){
		try {
			driver.findElement(by);
			return true;
		}catch(org.openqa.selenium.NoSuchElementException Ex){
			return false;
		}
	}

	protected boolean elementExist(WebElement element){
		try {
			if (element.isDisplayed())
				return true;
			else
				return false;
		}catch(org.openqa.selenium.NoSuchElementException Ex){
			return false;
		}


	}
	protected void waitForNewTab() {
		Duration timeout = Duration.ofSeconds(30);
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
	}
	
 protected void switchToNewWindow() {
	 Set<String> windowHandles = driver.getWindowHandles();
     // Switch to the new window
     for (String windowHandle : windowHandles) {
         if (!windowHandle.equals(driver.getWindowHandle())) {
             driver.switchTo().window(windowHandle);
             break;
         }
     }
	 
 }
	
protected void switchToMainTab() {
	driver.switchTo().defaultContent();

}
	protected void waitForPageToLoad(String Url){
		Duration timeout = Duration.ofSeconds(30);
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.urlToBe(Url));
//		int maxTimeOutInSeconds = 20;
//		int loops = maxTimeOutInSeconds*4;
//		for (int i=0; i<loops; i++){
//			try {
//				Object result = ((JavascriptExecutor) driver).executeScript("return document.readyState;");
//				if (result.toString().equalsIgnoreCase("complete"))  break;
//					try {
//						Thread.sleep(250L);
//					} catch (InterruptedException e) {
//						// try again;
//					}
//				} catch (Exception e) {
//					// Possible page reload. Fine
//					try {
//						Thread.sleep(250L);
//					} catch (InterruptedException e1) {
//						// try again;
//					}
//				}
//	
//			}
		}
	
	protected WebElement waitForElement(By by){
		return waitForElement(by, 5);
	}
	
	protected WebElement waitForElement(By by, int maxTimeSeconds){
		int loops = maxTimeSeconds*4;
		if (0==loops){
			loops=1;
		}
		for (int i=0; i<loops; i++){
			try {
				List<WebElement> elements = driver.findElements(by);
				for (WebElement element : elements){
					if (element.isDisplayed()){
						return element;
					}
				}
				try {
					Thread.sleep(500L);
				} catch (InterruptedException e) {
					// try again;
				}
			} catch (Exception e) {
				// try again
				try {
					Thread.sleep(500L);
				} catch (InterruptedException e1) {
					// try again;
				}
			}
		}
		return null;
	}
	
	
	protected void implicitWait(int maxTimeSeconds){
		//try {
		//driver.manage().timeouts().implicitlyWait(maxTimeSeconds, TimeUnit.SECONDS);
	//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(maxTimeSeconds));

		    //thread to sleep for the specified number of milliseconds
			try {
				Thread.sleep(maxTimeSeconds * 1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		/*} catch ( java.lang.InterruptedException ie) {
		    System.out.println(ie);
		}*/
	}
    public void waitForAjaxInactivity() {

        JavascriptExecutor jsExecutor = ((JavascriptExecutor) driver);

        for (int i = 0; i <= 30; i++) {
                       if ((Boolean) jsExecutor.executeScript("return jQuery.active == 0")) {
                                      break;
                       }
                       try {
                                      Thread.sleep(1000L);
                       } catch (InterruptedException e) {
                                      // Swallow
                       }

                       if (i == 30) {
                                      throw new RuntimeException("Javascript activity did not cease within 30s - aborting");
                       }
        }
}


}