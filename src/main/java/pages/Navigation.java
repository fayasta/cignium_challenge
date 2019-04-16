package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePageObject;

public class Navigation extends BasePageObject<Navigation> {
	
	private By signInButton = By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a");
	private By signOutButton = By.className("logout");
	private By userNameProfile = By.className("account");
	
	public Navigation(WebDriver driver){
		super(driver);
	}
	
	/**
	 * This method has the purpose of waiting until the elements required are visible in order to use this page
	 */
	public void isPageOpen(){
		waitForVisibilityOf(signInButton, 10);
	}
	
	/**
	 * This method clicks on Sign in button and redirects the user to Sign In Page
	 * @return
	 */
	public SignInPage goToSignInPage(){
		clickOnElement(signInButton);
		return new SignInPage(driver);
	}
	
	/**
	 * Verifies if the Sign out option is visible in the page.
	 * @return
	 */
	public boolean isSignOutButtonVisible(){
		return find(signOutButton).isDisplayed();
	}
	
	/**
	 * Verifies if the element that contains the the full name is displayed at the top of the page.
	 * @return
	 */
	public boolean isUserProfileNameVisible(){
		return find(userNameProfile).isDisplayed();
	}
	
	/**
	 * After registering a user, this method validates if the full name is displayed in the top of the page.
	 * @param userName user name
	 * @param userLastName user last name
	 * @return boolean
	 */
	public boolean validateUserAuthenticated(String userName, String userLastName){
		String userFullName = userName + " " + userLastName;
		return userFullName.equals(find(userNameProfile).getText());
	}
}
