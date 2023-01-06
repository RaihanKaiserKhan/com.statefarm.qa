package base;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;

import common.CommonAction;
import dataProvider.AutoData;
import io.github.bonigarcia.wdm.WebDriverManager;
import object.CustomerInfo;
import object.HomeOwnerInfo;
import object.HomePage;
import object.PracticePage;
import reporting.ExtentManager;
import reporting.ExtentTestManger;
import utils.ReadConfigFile;

public class BaseClass {
	public static WebDriver driver;
	public CommonAction commonAction;
	public HomePage homePage;
	public CustomerInfo customerInfo;
	public HomeOwnerInfo homeOwnerInfo;
	public PracticePage practicePage;
	public ReadConfigFile readConfigFile;
	public ExtentReports extent;

	@BeforeSuite
	public void reportingInitiating() {
		extent = ExtentManager.getInstance();
	}

	@BeforeTest
	public void beforeTest() {
		Reporter.log("Before test annotation.");
	}

	@BeforeClass
	public void beforeClass() {
		Reporter.log("Before Test");
	}

	@Parameters({ "browser" })
	@BeforeMethod
	public void setUp(String browser) {
		settingUpDriver(browser);
		driver.get(ReadConfigFile.getInstance().getUrl());
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(ReadConfigFile.getInstance().getPageLoadTime()));
		driver.manage().timeouts()
				.implicitlyWait(Duration.ofSeconds(ReadConfigFile.getInstance().getImplicitlyWaitTime()));
		initClasses();
	}

	private WebDriver settingUpDriver(String driverName) {
		if (driverName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (driverName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (driverName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		return driver;
	}

	@BeforeMethod
	public void startReport(Method method) {
		String className = method.getDeclaringClass().getSimpleName();
		ExtentTestManger.startTest(method.getName());
		ExtentTestManger.getTest().assignCategory(className);
	}

	@AfterMethod
	public void afterEachTestMethod(ITestResult result) {
		for (String groups : result.getMethod().getGroups()) {
			ExtentTestManger.getTest().assignCategory(groups);
		}
		if (result.getStatus() == ITestResult.SUCCESS) {
			ExtentTestManger.getTest().log(Status.PASS, "Test Passed");
		} else if (result.getStatus() == ITestResult.SKIP) {
			ExtentTestManger.getTest().log(Status.SKIP, "Test Skipped");
		} else if (result.getStatus() == ITestResult.FAILURE) {
			ExtentTestManger.getTest().log(Status.FAIL, "Test Failed \n" + result.getThrowable());
			String ssLocation = commonAction.getScreenShot();
			ExtentTestManger.getTest().addScreenCaptureFromPath(ssLocation);
		}
	}

	public void initClasses() {
		homePage = new HomePage(driver);
		customerInfo = new CustomerInfo(driver);
		commonAction = new CommonAction();
		homeOwnerInfo = new HomeOwnerInfo(driver);
		practicePage = new PracticePage(driver); // For additional page to do any experiment
	}

	@AfterMethod
	public void cleanUp() {
		//driver.quit();
	}

	@AfterClass
	public void afterClass() {
		Reporter.log("After class");
	}

	@AfterTest
	public void afterTest() {
		Reporter.log("After Test");
	}

	@AfterSuite
	public void endReport() {
		extent.flush();
	}
}