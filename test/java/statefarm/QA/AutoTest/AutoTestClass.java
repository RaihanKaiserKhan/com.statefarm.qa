package statefarm.QA.AutoTest;

import org.testng.annotations.Test;

import base.BaseClass;

public class AutoTestClass extends BaseClass {
	@Test

	public void testerMethod() throws InterruptedException {
		homePage.typeInsurance(commonAction, "Auto");
		Thread.sleep(1000);
		homePage.zipInput(commonAction, "11418");
		Thread.sleep(1000);
		homePage.startQoute(commonAction); 
		Thread.sleep(1000);
		customerInfo.firstName(commonAction, "Mohamed");
		Thread.sleep(1000);
		customerInfo.middleInitial(commonAction, 'b');
		Thread.sleep(1000);
		customerInfo.lastName(commonAction, "Hosain");
		Thread.sleep(1000);
		customerInfo.suffix(commonAction);
		Thread.sleep(1000);
		customerInfo.suffixSr(commonAction);
		customerInfo.address(commonAction, "1800 Ave H");
		Thread.sleep(1000);
		customerInfo.apt(commonAction, "2A");
		Thread.sleep(1000);
		customerInfo.DateOfBirth(commonAction, "11/05/1991");
		Thread.sleep(1000);
		customerInfo.getURL(commonAction);
		customerInfo.vehicleButton(commonAction);

	}
}