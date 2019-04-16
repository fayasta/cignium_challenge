package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import Utilities.DataGenerator;
import base.BasePageObject;

public class SignInPage  extends BasePageObject<SignInPage> {
	
	private By userEmailInputField = By.id("email_create");
	private By createAccountButton = By.id("SubmitCreate");
	
	public SignInPage(WebDriver driver){
		super(driver);
	}
	
	/**
	 * This method has the purpose of waiting until the elements required are visible in order to use this page
	 */
	public void isPageOpen(){
		waitForVisibilityOf(userEmailInputField, 10);
		waitForVisibilityOf(createAccountButton, 10);
	}
	
	/**
	 * Creates a user email randomly and completes the email field.
	 */
	public void completeEmail(){
		String userEmail = DataGenerator.generateUserEmail();
		fillField(userEmailInputField,userEmail);
	}
	
	/**
	 * Creates a new account and redirects the user to Register Page screen.
	 * @return
	 */
	public RegisterPage createNewAccount(){
		clickOnElement(createAccountButton);
		return new RegisterPage(driver);
	}
}
