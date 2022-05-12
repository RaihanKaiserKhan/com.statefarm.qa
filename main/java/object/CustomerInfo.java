package object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import common.CommonAction;

public class CustomerInfo {
	public CustomerInfo(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='first_name']")
	public WebElement firstName;
	@FindBy(xpath = "//*[@id='middle_name']")
	WebElement middleIn;
	@FindBy(xpath = "//*[@id='last_name']")
	WebElement lastName;
	@FindBy(xpath = "//*[@id='suffix_name-button']")
	WebElement suffix;
@FindBy(xpath = "//*[@name='welcomeAddress.street1']")
WebElement address;
@FindBy(xpath = "//*[@id='street2']")
WebElement apt;
@FindBy(xpath = "//*[@id='date_of_birth']")
WebElement dOb;
@FindBy(id = "btnContinue")
WebElement vehicleButton;

	public void firstName(CommonAction commonAction, String value) {
		commonAction.sendText(firstName, value);
	}

	public void lastName(CommonAction commonAction, String value) {
		commonAction.sendText(lastName, value);
	}
public void address(CommonAction commonAction, String value) {
	commonAction.sendText(address, value);
}
public void apt(CommonAction commonAction, String value) {
	commonAction.sendText(apt, value);
}
public void DateOfBirth(CommonAction commonAction, String value) {
	commonAction.sendText(dOb, value);
}
public void vehicleButton(CommonAction commonAction) {
	commonAction.clicking(vehicleButton);
}
//	public void middleInitial(CommonAction commonAction, char c) {
//		commonAction.sendChar(middleIn, c);
//	}

//public void suffix(CommonAction commonActio, String value) {
//	commonActio.dropDownBy(suffix, value);
//}
//	public void startQoute(CommonAction commonAction) {
//		commonAction.clicking(startQoutElement);
	// }
}