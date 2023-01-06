package object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import common.CommonAction;
import dataProvider.AutoData;

public class HomeOwnerInfo {
	public HomeOwnerInfo(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='firstName']")
	WebElement firstNamElement;
	@FindBy(xpath = "//input[@id='lastName']")
	WebElement lastNamElement;
	@FindBy(xpath = "//input[@id='middleName']")
	WebElement middleNamElement;
	@FindBy(xpath = "//select[@id='nameSuffix']")
	WebElement suffixElement;
	@FindBy(xpath = "//input[@id='street']")
	WebElement addressElement;
	@FindBy(xpath = "	//input[@id='street2']")
	WebElement address2Element;
	@FindBy(xpath = "	//input[@id='dateOfBirth']")
	WebElement dObElement;
	@FindBy(xpath = "	//*[@id='sameAsRiskAddress']")
	WebElement radioElement;
	@FindBy(xpath = "	//*[@id='continue']")
	WebElement continueElement;
	@FindBy(xpath = "(//*[text()='X'])[1]")
	WebElement dismissElement;

	public void firstName(CommonAction commonAction, String first) {
		commonAction.sleep(5);
		commonAction.scrollDownByJs(firstNamElement);
		commonAction.sendText(firstNamElement, first);
	}

	public void lastName(CommonAction commonAction, String last) {
		commonAction.sendText(lastNamElement, last);
	}

	public void middleInitial(CommonAction commonAction, char middleInit) {
		commonAction.inputText(middleNamElement, middleInit);
	}

	public void suffix(CommonAction commonAction, String suffixDrop) {
		commonAction.dropDownByvalue(suffixElement, suffixDrop);
	}

	public void address(CommonAction commonAction, String addressString) { // s
		commonAction.sendText(addressElement, addressString);
	}

	public void apt(CommonAction commonAction, String aptString) {
		commonAction.sendText(address2Element, aptString);
	}

	public void dateOfBirth(CommonAction commonAction, String doBString) {
		commonAction.sendText(dObElement, doBString);
	}

	public void radioButoon(CommonAction commonAction, boolean isSameAddress) {
		boolean statusOfElement = commonAction.isSelected(radioElement);
		if (!statusOfElement && isSameAddress) {
			commonAction.clicking(radioElement);
		}
	}
	public void clickContinue(CommonAction commonAction) {
		commonAction.scrollDownByJs(continueElement);
		commonAction.scrollDownByJs(continueElement);
		commonAction.sleep(1);
		commonAction.clicking(continueElement);
	}
	// this steps for robust testing
	public void homeOwnerSteps(CommonAction commonAction, String first, String last, char middleInit, String suffixDrop,
			String addressString, String aptString, String doBString, boolean isSameAddress) {
		firstName(commonAction, first);
		lastName(commonAction, last);
		middleInitial(commonAction, middleInit);
		suffix(commonAction, suffixDrop);
		commonAction.dismissAlert(dismissElement);
		commonAction.sleep(2);
		address(commonAction, addressString);
		apt(commonAction, aptString);
		dateOfBirth(commonAction, doBString);
		radioButoon(commonAction, isSameAddress);
		clickContinue(commonAction);
	}
	// this steps for auto data
	public void homeOwnerSteps(CommonAction commonAction, AutoData autoData) {
		firstName(commonAction, autoData.getFirstName());
		lastName(commonAction, autoData.getLastName());
		middleInitial(commonAction, autoData.getMiddleName());
		suffix(commonAction, autoData.getSuffix());
		commonAction.dismissAlert(dismissElement);
		commonAction.sleep(2);
		address(commonAction, autoData.getAddress());
		apt(commonAction, autoData.getApt());
		dateOfBirth(commonAction, autoData.getdOB());
		radioButoon(commonAction, autoData.getisRadioButton());
		clickContinue(commonAction);
	}
}