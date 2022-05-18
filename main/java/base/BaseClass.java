package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import common.CommonAction;
import io.github.bonigarcia.wdm.WebDriverManager;
import object.CustomerInfo;
import object.HomePage;

public class BaseClass {
	public static WebDriver driver;
	public CommonAction commonAction;
	public HomePage homePage;
	public CustomerInfo customerInfo;

	@BeforeSuite
	public void beforeSuit() {
		Reporter.log("Running framework");
	}

	@BeforeTest
	public void beforeTest() {
		Reporter.log("Before test annotation.");
	}

	@BeforeClass
	public void beforeClass() {
		Reporter.log("Before Test");
	}

	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.statefarm.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		initClasses();
	}

	public void initClasses() {

		homePage = new HomePage(driver);
		customerInfo = new CustomerInfo(driver);

		commonAction = new CommonAction();
	}

	@AfterMethod
	public void cleanUp() {
		driver.quit();
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
	public void afterSuite() {
		Reporter.log("After suite");
	}
}
