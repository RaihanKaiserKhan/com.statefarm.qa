package statefarm.QA_TestClasses;
import java.util.ArrayList;
import java.util.Iterator;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import base.BaseClass;
import dataProvider.AutoData;

public class AutoDataProviderTest extends BaseClass {
	@DataProvider(name = "autoData")
	
	public Iterator<AutoData> autoData() {
		ArrayList<AutoData> list = new ArrayList<AutoData>();
		AutoData autoData = new AutoData("Auto", "11230", "Racheal", "Green", 'K', "1st", "15 FRIENDS Road", "3A",
				"10171980", true);
		list.add(autoData);
		return list.iterator();
	}
	
	@Test(enabled = false, priority = 1, groups = { "externalData", "auto", "autoData" }, dataProvider = "autoData")
	public void autoTestingByDataProvider(AutoData autoData) {
		homePage.homePageSteps(commonAction, autoData);
		customerInfo.customerInfoSteps(commonAction, autoData);
	}
	
	
	
	
	@DataProvider(name = "homeData")
	public Iterator<AutoData> homeData() {
		ArrayList<AutoData> list = new ArrayList<AutoData>();
		AutoData homeData = new AutoData("Homeowners", "11218", "Burney", "Stinson", 'K', "1st", "335 HIMYM Road", "3A",
				"10/17/1980", true);
		list.add(homeData);
		return list.iterator();
	}

	@Test(enabled = true, priority = 1, groups = { "externalData", "home", "autoData" }, dataProvider = "homeData")
	public void homeTestingByDataProvider(AutoData homeData) {
		homePage.homePageSteps(commonAction, homeData);
		homeOwnerInfo.homeOwnerSteps(commonAction, homeData);
	}
	
}
	