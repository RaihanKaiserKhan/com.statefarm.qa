package statefarm.QA_TestClasses;

import org.testng.annotations.Test;

import base.BaseClass;
import object.HomeOwnerInfo;

public class RobustTestClasses extends BaseClass {

	@Test(enabled = true, priority = 1, groups = { "regression" , "auto" })
	public void autoTesting() {
		homePage.homePageSteps(commonAction, "Auto", "11230");
		customerInfo.customerInfoSteps(commonAction, "Chandler", "Bing", 'M', "15 Yemen Road", "3A", "10171980");

	}

	@Test(enabled = false, priority = 2, groups = { "home" , "Smoke" })
	public void homeTesting() {
		homePage.homePageSteps(commonAction, "Homeowners", "11230");
		homeOwnerInfo.homeOwnerSteps(commonAction, "Ross", "Geller", 'A', "SR", "long island", "4B", "12/12/1980",
				true);
	}

}
