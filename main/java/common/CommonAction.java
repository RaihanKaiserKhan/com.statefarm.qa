package common;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import base.BaseClass;

public class CommonAction {
	WebDriverWait wait = new WebDriverWait(BaseClass.driver, Duration.ofSeconds(10));
	JavascriptExecutor js= (JavascriptExecutor)BaseClass.driver;
		
		public void clicking(WebElement element) {
			try {
				wait.until(ExpectedConditions.elementToBeClickable(element));
				element.click();
				Reporter.log(" Clicking element is :" + element + "<br>");
			} catch (Exception e) {
				e.printStackTrace();
				Reporter.log("Element is  unable to click " + element + "\n" + e.getMessage() + "<br>");
				//Assert.fail();
			}
		}

		public void sendChar(WebElement element, CharSequence[] c) {
			try {
				wait.until(ExpectedConditions.visibilityOf(element));
				element.sendKeys(c);
				Reporter.log("Sending the value is :" + c + "in the field is :" + element + "<br>");
			} catch (Exception e) {
				e.printStackTrace();
				Reporter.log("element not found" + element + e.getMessage() + "<br>");
			//	Assert.fail();
			}		
		}
		public void sendText(WebElement element , String value) {
			try {
				wait.until(ExpectedConditions.visibilityOf(element));
				element.sendKeys(value);
				Reporter.log("Sending the value is :" + value + "in the field is :" + element + "<br>");
			} catch (Exception e) {
				e.printStackTrace();
				Reporter.log("element not found" + element + e.getMessage() + "<br>");
			//	Assert.fail();
			}		
		}

		public String getUrl() {
			String url=BaseClass.driver.getCurrentUrl();
			return url;	
		}
		
		public void dropDownByvalue(WebElement element, String value) {
//		try {
//			wait.until(ExpectedConditions.visibilityOf(element));
			Select select=new Select(element);
			select.selectByValue(value);
//			Reporter.log("drop is visible and value is "+value+"<br>");
//		} catch (Exception e) {
//			e.printStackTrace();
//			Reporter.log("drop is not visible and value is "+value+e.getMessage()+"<br>");
	//}
		}
		public void sendkeyJs() {
			js.executeScript("document.getElementById().value = 'iPad';\"");
		}
		public void dropDownBy(WebElement element, String value) {
//			try {
//				wait.until(ExpectedConditions.visibilityOf(element));
				Select select=new Select(element);
				select.selectByVisibleText(value);
}
}