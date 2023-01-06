package statefarm.QA_TestClasses;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseClass;
import common.CommonAction;
import dataProvider.AutoData;
import reporting.ExtentTestManger;
import utils.ExcelUtils;
import utils.ReadConfigFile;

public class ExcelDataProviderTest extends BaseClass {
	@DataProvider(name = "autoData")
	public Object[][] dataObjectAuto() {
		String filePath = ReadConfigFile.getInstance().getExcelPath();
		String sheetName = ReadConfigFile.getInstance().getSheetName();
		ExcelUtils excelUtils = new ExcelUtils(filePath, sheetName);
		return excelUtils.dataTable();
	}

	@Test(dataProvider = "autoData", groups = { "excel", "auto" })
	public void autoTestingByExcel(String insuranceType, String zip, String firstName, String lastName,
			String middleName, String suffix, String address, String apt, String dOB, String radio) {
		homePage.homePageSteps(commonAction, insuranceType, zip);
		customerInfo.customerInfoSteps(commonAction, firstName, lastName, middleName.charAt(0), address, apt, dOB);
	}

	@DataProvider(name = "homeData")
	public Object[][] dataObjectsHome() {
		String filePath = ReadConfigFile.getInstance().getExcelPath();
		String sheetName = ReadConfigFile.getInstance().getSheetName2();
		ExcelUtils excelUtils = new ExcelUtils(filePath, sheetName);
		return excelUtils.dataTable();
	}

	@Test(dataProvider = "homeData", groups = { "excel", "home" })
	public void homeTestingByExcel(String insuranceType, String zip, String firstName, String lastName,
			String middleName, String suffix, String address, String apt, String dOB, String radio) {
		homePage.homePageSteps(commonAction, insuranceType, zip);
		homeOwnerInfo.homeOwnerSteps(commonAction, firstName, lastName, middleName.charAt(0), suffix, address, apt, dOB,
				Boolean.parseBoolean(radio));
	}
}