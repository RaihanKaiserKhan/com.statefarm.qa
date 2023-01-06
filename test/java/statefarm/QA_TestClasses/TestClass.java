package statefarm.QA_TestClasses;

import org.testng.annotations.Test;

import base.BaseClass;

public class TestClass extends BaseClass {

	@Test(enabled = true, priority = 1, groups = { "regression" , "auto" })
	public void autoTestingMethod() {
		//homePage.dismissingAlert(commonAction);
		commonAction.sleep(2);
		homePage.dismissPrivacy(commonAction);
		homePage.typeInsurance(commonAction, "Auto");
		homePage.zipInput(commonAction, "11418");
		homePage.startQoute(commonAction);
		customerInfo.popup(commonAction);
		customerInfo.firstName(commonAction, "Joey");
		customerInfo.middleInitial(commonAction, 'T');
		customerInfo.lastName(commonAction, "Tribiani");
		// customerInfo.suffix(commonAction, "SR");
		customerInfo.suffix(commonAction);
		customerInfo.suffixSr(commonAction);
		customerInfo.address(commonAction, "1800 Ave H");
		customerInfo.apt(commonAction, "2A");
		customerInfo.DateOfBirth(commonAction, "11/05/1991");
		customerInfo.getURL(commonAction);
		commonAction.sleep(2);
		customerInfo.vehicleButton(commonAction);
}

	@Test(enabled = false ,priority = 2, groups = { "home" , "Smoke" })
	public void homeTestingMethod() {
		//homePage.dismissingAlert(commonAction);
		
	homePage.dismissPrivacy(commonAction);
		homePage.typeInsurance(commonAction, "Homeowners");
		homePage.zipInput(commonAction, "11230");
		commonAction.sleep(2);
		homePage.startQoute(commonAction);
		homeOwnerInfo.firstName(commonAction, "Ross");
		homeOwnerInfo.lastName(commonAction, "Gellar");
		homeOwnerInfo.middleInitial(commonAction, 'A');
		homeOwnerInfo.suffix(commonAction, "SR");
		homeOwnerInfo.address(commonAction, "Long Island st");
		homeOwnerInfo.apt(commonAction, "South face");
		homeOwnerInfo.dateOfBirth(commonAction, "12/16/1980");
		homeOwnerInfo.radioButoon(commonAction, true);
		commonAction.sleep(2);
		homeOwnerInfo.clickContinue(commonAction);

	}
}