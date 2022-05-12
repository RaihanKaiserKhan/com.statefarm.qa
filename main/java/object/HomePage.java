package object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;
import common.CommonAction;

public class HomePage {
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "productName")
	public WebElement  dropElement;
	@FindBy(xpath = "//input[@id='quote-main-zip-code-input']")
	WebElement zipElement;
	@FindBy(id = "quote-main-zip-btn")
	WebElement startQoutElement;
	
	
	public void typeInsurance(CommonAction commonAction) {
		commonAction.dropDownByvalue(dropElement,"Auto");
	}
	public void zipInput(CommonAction commonAction, String value) {
		commonAction.sendText(zipElement, value);
	}
	public void startQoute(CommonAction commonAction) {
		commonAction.clicking(startQoutElement);
	}
}
