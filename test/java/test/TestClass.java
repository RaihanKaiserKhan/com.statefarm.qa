package test;

import org.testng.annotations.Test;

import base.BaseClass;

public class TestClass extends BaseClass{
	@Test
	
public void testerMethod() {
	homePage.typeInsurance(commonAction);
	homePage.zipInput(commonAction, "11230");
	homePage.startQoute(commonAction);
	customerInfo.firstName(commonAction, "Mohammed");
	//customerInfo.middleInitial(commonAction, 'H');
	customerInfo.lastName(commonAction, "Hossain");
	//customerInfo.suffix(commonAction, "Jr");
	customerInfo.address(commonAction, "1804 Ave H");
	customerInfo.apt(commonAction, "1A");
	customerInfo.DateOfBirth(commonAction, "11/05/1990");
	customerInfo.vehicleButton(commonAction);
}
}