package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePageObject;

public class Navigation extends BasePageObject<Navigation> {
	
	private By signInButton = By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a");
	private By signOutButton = By.className("logout");
	private By userNameProfile = By.className("account");
//	private By userNameProfile = By.cssSelector("a[class='account']");
	
	public Navigation(WebDriver driver){
		super(driver);
	}
	
	public void isPageOpen(){
		waitForVisibilityOf(signInButton, 10);
	}
	
	public SignInPage goToSignInPage(){
		clickOnElement(signInButton);
		return new SignInPage(driver);
	}
	
	public boolean isSignOutButtonVisible(){
		System.out.println("SIGN OUT"+find(signOutButton).getText());
		return find(signOutButton).isDisplayed();
	}
	
	public boolean isUserProfileNameVisible(){
		System.out.println("USER NAME"+find(userNameProfile).getText());
		return find(userNameProfile).isDisplayed();
	}
	
	public boolean validateUserAuthenticated(String userName, String userLastName){
		System.out.println("USER NAME:::::"+userName);
		System.out.println("USER LAST NAME:::::"+userLastName);
		
		String userFullName = userName + " " + userLastName;
		System.out.println("USER FULL NAME:::::"+userFullName);
		return userFullName.equals(find(userNameProfile).getText());
	}
}
