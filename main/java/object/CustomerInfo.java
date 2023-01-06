package object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import common.CommonAction;
import dataProvider.AutoData;

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
	@FindBy(xpath = "//*[@id='sfx_suffixName_lbl']")
	WebElement suffixDropElement;
	@FindBy(xpath = "//*[@id='street2']")
	WebElement apt;
	@FindBy(xpath = "//*[@id='date_of_birth']")
	WebElement dOb;
	
	@FindBy(xpath = "//*[text()='I have read and acknowledge this disclosure. ']")
	WebElement checkBox;
	
	@FindBy(id = "btnContinue") // id=btnContinue
	WebElement nextVehicle;
	
	@FindBy(xpath = "(//*[@class=\"-oneX-icon--close\"])[5]")
	WebElement dismissElement;

	@FindBy(id = "nyLegacyCloseLinkId")
	WebElement popCancelElement;
	
	
	
	@FindBy(xpath = "//input[@id='termsIDCheckbox']")
	WebElement check;
	
	public void popup(CommonAction commonAction) {
	//if(	popCancelElement.isDisplayed()) {
		commonAction.clicking(popCancelElement);
	}
		
	//}
	
	public void firstName(CommonAction commonAction, String first) {
		commonAction.sleep(2);
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

	public void suffix(CommonAction commonAction, String suffixDrop) {
		commonAction.dropDownByvalue(suffixDropElement, suffixDrop);
	}

	public void address(CommonAction commonAction, String addressString) {
		commonAction.scrollDownByActionClass(address);
		commonAction.sendText(address, addressString);
	}

	public void apt(CommonAction commonAction, String aptString) {
		commonAction.sendText(apt, aptString);
	}

	public void DateOfBirth(CommonAction commonAction, String doBString) {
		commonAction.sendText(dOb, doBString);
	}

	public void vehicleButton(CommonAction commonAction) {
			
			commonAction.clicking(checkBox);
			commonAction.scrollDownByJs(dismissElement);
		commonAction.sleep(2);
		commonAction.clicking(nextVehicle);
	}

	public void middleInitial(CommonAction commonAction, char charValue) {
		commonAction.inputText(middleIn, charValue);
	}
	public void checkBox(CommonAction commonAction) {
		commonAction.clicking(check);
	}
	public void getURL(CommonAction commonAction) {
		commonAction.currentURL();
	}

	// for robust test    
	public void customerInfoSteps(CommonAction commonAction, String first, String last, char middleInit,
			String addressString, String aptString, String doBString) {
		commonAction.sleep(5);
		popup(commonAction);
		commonAction.sleep(2);
		firstName(commonAction, first);
		lastName(commonAction, last);
		middleInitial(commonAction, middleInit);
	//	suffix(commonAction);
	//	suffixSr(commonAction);
		commonAction.scrollDownByJs(address);
		address(commonAction, addressString);
		apt(commonAction, aptString);
		DateOfBirth(commonAction, doBString);
		checkBox(commonAction);
		vehicleButton(commonAction);
	}

	// for auto data testing (with or with out excel)
	public void customerInfoSteps(CommonAction commonAction, AutoData autoData) {
		firstName(commonAction, autoData.getFirstName());
		middleInitial(commonAction, autoData.getMiddleName());
		lastName(commonAction, autoData.getLastName());
		//suffix(commonAction);
		//suffixSr(commonAction);
		commonAction.dismissAlert(dismissElement);
		address(commonAction, autoData.getAddress());
		apt(commonAction, autoData.getApt());
		DateOfBirth(commonAction, autoData.getdOB());
		vehicleButton(commonAction);
	}
}