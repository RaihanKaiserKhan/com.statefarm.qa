package object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import common.CommonAction;

public class PracticePage {
	public PracticePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//span[@class='-oneX-icon--close']//parent::button[@id='optclosebtn']")
	public WebElement alertElement;
	
	public void alert(CommonAction commonAction) {
	 boolean status=commonAction.isDisplayed(alertElement);
//	if(status) {
//		commonAction.dismissAlert(alertElement);
//	}
		//commonAction.clicking(alertElement);
	}

}
