package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePageObject;

public class MyAccountPage extends BasePageObject<MyAccountPage> {
	
	private By accountContainer = By.id("center_column");
	
	public MyAccountPage(WebDriver driver){
		super(driver);
	}
	
	/**
	 * This method has the purpose of waiting until the elements required are visible in order to use this page
	 */
	public void isPageOpen(){
		waitForVisibilityOf(accountContainer, 10);
	}
	
	/**
	 * This method validates if the URL of this page is the one expected.
	 * @return a boolean
	 */
	public boolean validateURL(){
		return driver.getCurrentUrl().contains("?controller=my-account");
	}
}
