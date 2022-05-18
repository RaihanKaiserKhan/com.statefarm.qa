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
	WebElement suffixElement;
	@FindBy(xpath = "//*[@id='ui-id-14']")
	WebElement srElement;
	@FindBy(xpath = "//*[@name='welcomeAddress.street1']")
	WebElement address;
	@FindBy(xpath = "//*[@id='street2']")
	WebElement apt;
	@FindBy(xpath = "//*[@id='date_of_birth']")
	WebElement dOb;
	@FindBy(id = "btnContinue")
	WebElement vehicleButton;

	public void firstName(CommonAction commonAction, String first) {
		commonAction.sendText(firstName, first);
	}

	public void lastName(CommonAction commonAction, String last) {
		commonAction.sendText(lastName, last);
	}

	public void suffix(CommonAction commonAction) {
		commonAction.clicking(suffixElement);
	}

	public void suffixSr(CommonAction commonAction) {
		commonAction.clicking(srElement);
	}

	public void address(CommonAction commonAction, String addressString) {
		commonAction.sendText(address, addressString);
	}

	public void apt(CommonAction commonAction, String aptString) {
		commonAction.sendText(apt, aptString);
	}

	public void DateOfBirth(CommonAction commonAction, String doBString) {
		commonAction.sendText(dOb, doBString);
	}

	public void vehicleButton(CommonAction commonAction) {
		commonAction.clicking(vehicleButton);
	}

	public void middleInitial(CommonAction commonAction, char charValue) {
		commonAction.inputText(middleIn, charValue);
	}

	public void getURL(CommonAction commonAction) {
		commonAction.currentURL();
	}

//public void customerInfoSteps(CommonAction commonAction, String first, String last,String addressString, String aptString, String doBString,char  charValue) {
//	firstName(commonAction,first);
//	lastName(commonAction, last);
//	address(commonAction,addressString );
//	apt(commonAction,aptString );
//	DateOfBirth(commonAction,doBString);
//	vehicleButton(commonAction);
//	middleInitial(commonAction,charValue);
//	getURL(commonAction);
//}

}