package javaFramework;

import org.testng.Assert;
import org.testng.annotations.Test;

import Utilities.Utility;
import base.BaseTest;
import pages.MyAccountPage;
import pages.Navigation;
import pages.RegisterPage;
import pages.SignInPage;

public class CreateNewUserTest extends BaseTest{
	
	
	@Test
	public void CreateNewUser(){
		String userFirstName = Utility.generateUserFirstName();
		String userLastName = Utility.generateUserLastName();
		Navigation navigation = new Navigation(driver);
		navigation.isPageOpen();
		SignInPage signInPage = navigation.goToSignInPage();
		signInPage.isPageOpen();
		signInPage.completeEmail();
		RegisterPage registerPage = signInPage.createNewAccount();
		registerPage.isPageOpen();
		registerPage.completePersonalInformationForm(userFirstName, userLastName);
		registerPage.completeUserAddress();
		MyAccountPage myAccountPage = registerPage.registerNewUser();
		myAccountPage.isPageOpen();
		System.out.println("URL"+myAccountPage.validateURL());
		Assert.assertTrue(myAccountPage.validateURL(),"URL is not the expected. Account page URL is not displayed");
		navigation = new Navigation(driver);
		System.out.println("SIGN OUT"+navigation.isSignOutButtonVisible());
		Assert.assertTrue(navigation.isSignOutButtonVisible(),"Sign Out button is not displayed");
		
		System.out.println("USERPROFILE "+navigation.isUserProfileNameVisible());
		System.out.println("USERPROFILE "+navigation.validateUserAuthenticated(userFirstName, userLastName));
		Assert.assertTrue(myAccountPage.validateURL(),"URL is not the expected. Account page URL is not displayed");
		
		
	}
	
}
