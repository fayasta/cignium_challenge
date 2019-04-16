package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePageObject;

public class MyAccountPage extends BasePageObject<MyAccountPage> {
	
	private By accountContainer = By.id("center_column");
	
	public MyAccountPage(WebDriver driver){
		super(driver);
	}
	
	public void isPageOpen(){
		waitForVisibilityOf(accountContainer, 10);
	}
	
	public boolean validateURL(){
		System.out.println("URL"+driver.getCurrentUrl());
		return driver.getCurrentUrl().contains("?controller=my-account");
	}
}
