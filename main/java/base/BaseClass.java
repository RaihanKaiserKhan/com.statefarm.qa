package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import common.CommonAction;
import io.github.bonigarcia.wdm.WebDriverManager;
import object.CustomerInfo;
import object.HomePage;



public class BaseClass {
	public static WebDriver driver;
	public CommonAction commonAction;
	public HomePage homePage;
	public CustomerInfo customerInfo;

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
		
		homePage=new HomePage(driver);
		customerInfo=new CustomerInfo(driver);
	
		commonAction =new CommonAction();
	}

//	@AfterMethod
//public void cleanUp() {
//	driver.quit();
//	}
}
