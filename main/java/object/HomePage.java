package object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import common.CommonAction;

public class HomePage {
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "productName")
	public WebElement dropElement;
	@FindBy(xpath = "//input[@id='quote-main-zip-code-input']")
	WebElement zipElement;
	@FindBy(id = "quote-main-zip-btn")
	WebElement startQoutElement;

	public void typeInsurance(CommonAction commonAction, String value) {
		commonAction.dropDownByvalue(dropElement, value);
	}

	public void zipInput(CommonAction commonAction, String zipCode) {
		commonAction.sendText(zipElement, zipCode);
	}

	public void startQoute(CommonAction commonAction) {
		commonAction.clicking(startQoutElement);
	}

	public void homePageSteps(CommonAction commonAction, String value1, String zipCode) {
		typeInsurance(commonAction, value1);
		zipInput(commonAction, zipCode);
		startQoute(commonAction);

	}
}
