package common;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import base.BaseClass;

public class CommonAction {
	WebDriverWait wait = new WebDriverWait(BaseClass.driver, Duration.ofSeconds(10));
	JavascriptExecutor js = (JavascriptExecutor) BaseClass.driver;

	public void clicking(WebElement element) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(element));
			element.click();
			Reporter.log(" Clicking element is :" + element + "<br>");
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log("Element is  unable to click " + element + "\n" + e.getMessage() + "<br>");
			Assert.fail();
		}
	}

	public void inputText(WebElement element, char text) {
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			element.sendKeys(String.valueOf(text));
			Reporter.log(text + " : value passed to element : " + element + "<br>");
		} catch (Throwable e) {
			e.printStackTrace();
			Reporter.log("Element is not found : " + element + "\n" + e.getMessage() + "<br>");
			Assert.fail();
		}
	}

	public void sendText(WebElement element, String value) {
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			element.sendKeys(value);
			Reporter.log("Sending the value is :" + value + "in the field is :" + element + "<br>");
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log("element not found" + element + e.getMessage() + "<br>");
			Assert.fail();
		}
	}

	public String getUrl() {
		String url = BaseClass.driver.getCurrentUrl();
		return url;
	}

	public void dropDownByvalue(WebElement element, String value) {
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			Select select = new Select(element);
			select.selectByValue(value);
			Reporter.log("drop is visible and value is " + value + "<br>");
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log("drop is not visible and value is " + value + e.getMessage() + "<br>");
		}
	}

	public void inputUsingJSXforIdLocator(String element, String text) {
		try {
			js.executeScript("document.getElementById('" + element + "').value='" + text + "';");
			Reporter.log(text + " : value passed to element : " + element + "<br>");
		} catch (Throwable e) {
			e.printStackTrace();
			Reporter.log("Element is not found : " + element + "\n" + e.getMessage() + "<br>");
			Assert.fail();
		}
	}

	public boolean isSelected(WebElement element) {
		boolean status = false;
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			status = element.isSelected();
			if (status) {
				Reporter.log(element + " : is selected" + "<br>");
			} else {
				Reporter.log(element + " : is Not selected" + "<br>");
			}
		} catch (Throwable e) {
			e.printStackTrace();
			Reporter.log("Element Not Found : " + element + "\n" + e.getMessage() + "<br>");
			Assert.fail();
		}
		return status;
	}

	// to understand isSelect method
	public boolean iisSelected(WebElement element) {
		boolean status = false;
		status = element.isSelected();
		return status;
	}

	public boolean isPresent(By by) {
		boolean status = false;
		try {
			List<WebElement> elements = BaseClass.driver.findElements(by);
			if (elements.size() > 0) {
				status = true;
				Reporter.log(by + " : Element is Present" + "<br>");
			} else {
				Reporter.log(by + " : Element is Not Present" + "<br>");
			}
		} catch (Throwable e) {
			e.printStackTrace();
			Reporter.log("Element is not found : " + by + "\n" + e.getMessage() + "<br>");
			Assert.fail();
		}
		return status;
	}

	public void sleep(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
			Reporter.log("Sleeping for+" + seconds + "ZZzzzzz" + "<br>");
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log("Sleeping interrupted" + "<br>");
		}

	}

	public String currentURL() {
		String url = BaseClass.driver.getCurrentUrl();
		Reporter.log("Current URL is " + url + "<br>");
		return url;
	}

}
