package object;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.dockerjava.api.model.Driver;

import base.BaseClass;
import common.CommonAction;
import dataProvider.AutoData;

public class HomePage {
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//p[@id='optpara']")
	public WebElement privacy;
	@FindBy(xpath = "(//span[@class='-oneX-icon--close'])[1]")
	public WebElement privacyX;
	@FindBy(name = "productName")
	public WebElement dropElement;
	@FindBy(xpath = "//input[@id='quote-main-zip-code-input']")
	WebElement zipElement;
	@FindBy(xpath = "//*[@id = \"quote-main-zip-btn\"]")
	WebElement startQoutElement;
	@FindBy(xpath = "//*[@class='-w_link-override--block']")
	WebElement scrollElement;
	@FindBy(xpath = "//span[@class='-oneX-icon--close']//parent::button[@id='optclosebtn']")
	public WebElement alertElement;

	WebDriverWait wait = new WebDriverWait(BaseClass.driver, Duration.ofSeconds(20));
	
	public void dismissPrivacy(CommonAction commonAction) {
	try {
	commonAction.clicking(privacyX);
	} catch (Exception e) {
	}
	}
	

	public void typeInsurance(CommonAction commonAction, String value) {
		commonAction.dropDownByvalue(dropElement, value);
		
	}

	public void zipInput(CommonAction commonAction, String zipCode) {
		commonAction.sendText(zipElement, zipCode);
	}

	public void startQoute(CommonAction commonAction) {
		commonAction.scrollDownByJs(scrollElement);
		commonAction.sleep(1);
		commonAction.clicking(startQoutElement);
	}
	// this steps for robust testing
	public void homePageSteps(CommonAction commonAction, String value, String zipCode) {
	//	dismissingAlert(commonAction);
		dismissPrivacy(commonAction);
		dismissPrivacy(commonAction);
		
		typeInsurance(commonAction, value);
		zipInput(commonAction, zipCode);
		startQoute(commonAction);
	}
	// this steps for auto data
	public void homePageSteps(CommonAction commonAction, AutoData autoData) {
		//dismissingAlert(commonAction);
		dismissPrivacy(commonAction);
		typeInsurance(commonAction, autoData.getInsuranceType());
		zipInput(commonAction, autoData.getZip());
		startQoute(commonAction);
	}
}