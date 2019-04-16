package javaFramework;

import org.testng.Assert;
import org.testng.annotations.Test;
import Utilities.DataGenerator;
import base.BaseTest;
import pages.MyAccountPage;
import pages.Navigation;
import pages.RegisterPage;
import pages.SignInPage;

public class CreateNewUserTest extends BaseTest{
	
	@Test
	public void CreateNewUser(){
		String userFirstName = DataGenerator.generateUserFirstName();
		String userLastName = DataGenerator.generateUserLastName();
		//Wait until the web site is displayed.
		Navigation navigation = new Navigation(driver);
		navigation.isPageOpen();
		//Click on Sign in option and wait until the page is loaded.
		SignInPage signInPage = navigation.goToSignInPage();
		signInPage.isPageOpen();
		signInPage.completeEmail();
		//New Account creation
		RegisterPage registerPage = signInPage.createNewAccount();
		registerPage.isPageOpen();
		//Completes the information required
		registerPage.completePersonalInformationForm(userFirstName, userLastName);
		registerPage.completeUserAddress();
		//Sends the information and goes to My Account Page
		MyAccountPage myAccountPage = registerPage.registerNewUser();
		myAccountPage.isPageOpen();
		Assert.assertTrue(myAccountPage.validateURL(),"URL is not the expected. Account page URL is not displayed");
		navigation = new Navigation(driver);
		Assert.assertTrue(navigation.isSignOutButtonVisible(),"Sign Out button is not displayed");
		Assert.assertTrue(myAccountPage.validateURL(),"URL is not the expected. Account page URL is not displayed");
	}
	
}
