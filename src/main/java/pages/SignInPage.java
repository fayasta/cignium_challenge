package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Utilities.Utility;
import base.BasePageObject;

public class SignInPage  extends BasePageObject<SignInPage> {
	
	private By userEmailInputField = By.id("email_create");
	private By createAccountButton = By.id("SubmitCreate");
	
	public SignInPage(WebDriver driver){
		super(driver);
	}
	
	public void isPageOpen(){
		waitForVisibilityOf(userEmailInputField, 10);
		waitForVisibilityOf(createAccountButton, 10);
	}
	
	public void completeEmail(){
		String userEmail = Utility.getUserEmail();
		fillField(userEmailInputField,userEmail);
	}
	
	public RegisterPage createNewAccount(){
		clickOnElement(createAccountButton);
		return new RegisterPage(driver);
	}
}
