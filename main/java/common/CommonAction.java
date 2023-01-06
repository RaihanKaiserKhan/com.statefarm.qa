package common;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.google.common.io.Files;
import base.BaseClass;
import reporting.Loggers;
import org.openqa.selenium.interactions.Actions;

public class CommonAction {
	WebDriverWait wait = new WebDriverWait(BaseClass.driver, Duration.ofSeconds(20));
	JavascriptExecutor js = (JavascriptExecutor) BaseClass.driver;
	private boolean status;

	public void clicking(WebElement element)  {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(element));
			element.click();
			Loggers.log(" Clicking element is :" + element + "<br>");
		} catch (Exception e) {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			js.executeScript("window.scrollBy(0,100)", ""); // scroll down
			js.executeScript("window.scrollBy(0,-100)", ""); // scroll down
			element.click();
			e.printStackTrace();
			Loggers.log("Element is  unable to click " + element + "\n" + e.getMessage() + "<br>");
			Assert.fail();
		}
	}

	public void inputText(WebElement element, char text) {
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			element.sendKeys(String.valueOf(text));
			Loggers.log(text + " : value passed to element : " + element + "<br>");
		} catch (Throwable e) {
			e.printStackTrace();
			Loggers.log("Element is not found : " + element + "\n" + e.getMessage() + "<br>");
			Assert.fail();
		}
	}

	public void sendText(WebElement element, String value) {
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			element.sendKeys(value);
			Loggers.log("Sending the value is :" + value + "in the field is :" + element + "<br>");
		} catch (Exception e) {
			element.sendKeys(value);
			e.printStackTrace();
			Loggers.log("element not found" + element + e.getMessage() + "<br>");
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
			Loggers.log("drop is visible and value is " + value + "<br>");
		} catch (Exception e) {
			e.printStackTrace();
			Loggers.log("drop is not visible and value is " + value + e.getMessage() + "<br>");
		}
	}

	public void inputUsingJSXforIdLocator(String element, String text) {
		try {
			js.executeScript("document.getElementById('" + element + "').value='" + text + "';");
			Loggers.log(text + " : value passed to element : " + element + "<br>");
		} catch (Throwable e) {
			e.printStackTrace();
			Loggers.log("Element is not found : " + element + "\n" + e.getMessage() + "<br>");
			Assert.fail();
		}
	}

	public boolean isSelected(WebElement element) {
		boolean status = false;
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			status = element.isSelected();
			if (status) {
				Loggers.log(element + " : is selected" + "<br>");
			} else {
				Loggers.log(element + " : is Not selected" + "<br>");
			}
		} catch (Throwable e) {
			e.printStackTrace();
			Loggers.log("Element Not Found : " + element + "\n" + e.getMessage() + "<br>");
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
				Loggers.log(by + " : Element is Present" + "<br>");
			} else {
				Loggers.log(by + " : Element is Not Present" + "<br>");
			}
		} catch (Throwable e) {
			e.printStackTrace();
			Loggers.log("Element is not found : " + by + "\n" + e.getMessage() + "<br>");
			Assert.fail();
		}
		return status;
	}

	public void sleep(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
			Loggers.log("Sleeping for+" + seconds + "ZZzzzzz" + "<br>");
		} catch (Exception e) {
			e.printStackTrace();
			Loggers.log("Sleeping interrupted" + "<br>");
		}

	}

	public String currentURL() {
		String url = BaseClass.driver.getCurrentUrl();
		Loggers.log("Current URL is " + url + "<br>");
		return url;
	}

	public void scrollDownByActionClass(WebElement element) {
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			Actions actions = new Actions(BaseClass.driver);
			actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).build().perform();
			Loggers.log("element is scrolling" + element + "<br>");
		} catch (Exception e) {
			e.printStackTrace();
			Loggers.log(element + "is not visible" + "<br>");
		}

	}

	public void scrollUpByActionClass(WebElement element) {
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			Actions actions = new Actions(BaseClass.driver);
			actions.keyDown(Keys.CONTROL).sendKeys(Keys.HOME).build().perform();
			Loggers.log("element is scrolling" + element + "<br>");
		} catch (Exception e) {
			e.printStackTrace();
			Loggers.log(element + "is not visible" + "<br>");
		}

	}

	public void scrollUpByJs(WebElement element) {
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			js.executeScript("window.scrollBy(0,-300)", ""); // scroll-up
			Loggers.log("element is scrolling" + element + "<br>");
		} catch (Exception e) {
			e.printStackTrace();
			Loggers.log(element + "is not visible" + "<br>");
		}

	}

//	JavascriptExecutor js = (JavascriptExecutor) BaseClass.driver;
//	js.executeScript("arguments[0].scrollIntoView()", continueElement);

	public void scrollDownByJs(WebElement element) {
		try {
			// wait.until(ExpectedConditions.visibilityOf(element));
			js.executeScript("window.scrollBy(0,100)", ""); // scroll down
			Loggers.log("element is scrolling" );
		} catch (Exception e) {
			e.printStackTrace();
			Loggers.log( "element is not visible" + "<br>");
		}
	}

	public String getScreenShot() {
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("MMddyyyy_hh.mm.ss");
		String suffix = dateFormat.format(date);
		File file = new File("screenShots/error_" + suffix + ".png");
		String fileLocation = file.getAbsolutePath();
		TakesScreenshot ss = ((TakesScreenshot) BaseClass.driver);
		File srcFile = ss.getScreenshotAs(OutputType.FILE);
		try {
			Files.copy(srcFile, file.getAbsoluteFile());
			Loggers.log("Test Failed & Sceenshot taken in location : " + fileLocation);
		} catch (IOException e) {
			Loggers.log("Error while taking screen shot");
		}
		return fileLocation;
	}

	public void dismissAlert(WebElement element) {
		try {
			org.openqa.selenium.Alert alert = BaseClass.driver.switchTo().alert();
			alert.dismiss();
		} catch (Exception e) {
			e.printStackTrace();
			Loggers.log("Alert is not displayed");
		}
	}

	public boolean isDisplayed(WebElement element) {
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			status = element.isDisplayed();
			if (status) {
				Loggers.log(element + " : is displayed" + "<br>");
			} else {
				Loggers.log(element + " : is Not displayed" + "<br>");
			}
		} catch (Throwable e) {
			e.printStackTrace();
			Loggers.log("Element Not Found : " + element + "\n" + e.getMessage() + "<br>");
			Assert.fail();
		}
		return status;
	}

	public void switchCurrentWindow() {
		Set<String> windows = BaseClass.driver.getWindowHandles();
		List<String> listOfWindows = new ArrayList<String>(windows);
		BaseClass.driver.switchTo().window(listOfWindows.get(listOfWindows.size() - 1));
	}

}
