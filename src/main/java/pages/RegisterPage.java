package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Utilities.Utility;
import base.BasePageObject;

public class RegisterPage extends BasePageObject<RegisterPage> {
	
	//PERSONAL INFORMATION SECTION
	private By mrOption = By.id("id_gender1");
	private By customerFirstNameField = By.id("customer_firstname");
	private By customerLastNameField = By.id("customer_lastname");
	private By userPasswordField = By.id("passwd");
	private By daysContainer = By.id("days");
	private By monthsContainer = By.id("months");
	private By yearsContainer = By.id("years");
	
	//ADDRESS SECTION
	private By companyField = By.id("company");
	private By firstAddressField = By.id("address1");
	private By secondAddressField = By.id("address2");
	private By cityField = By.id("city");
	private By stateContainer = By.id("id_state");
	private By postCodeField = By.id("postcode");
	private By countryContainer = By.id("id_country");
	private By additionalInformationField = By.id("other");
	private By homePhoneField = By.id("phone");
	private By mobilePhoneField = By.id("phone_mobile");
	private By alliasAddressField = By.id("alias");
	
	//Register button
	private By registerButton = By.id("submitAccount");
	
	public RegisterPage(WebDriver driver){
		super(driver);
	}

	public void isPageOpen(){
		waitForVisibilityOf(customerFirstNameField, 10);
		waitForVisibilityOf(companyField, 10);
	}
	
	public void completePersonalInformationForm(String userFirstName, String userLastName){
		clickOnElement(mrOption);
		fillField(customerFirstNameField,userFirstName);
		fillField(customerLastNameField,userLastName);
		fillField(userPasswordField,Utility.generatePassword());
		Utility.selectOneOptionFromDropbox(find(daysContainer));
		Utility.selectOneOptionFromDropbox(find(monthsContainer));
		Utility.selectOneOptionFromDropbox(find(yearsContainer));
	}
	
	public void completeUserAddress(){
		fillField(companyField,Utility.generateCompanyName());
		fillField(firstAddressField,Utility.generateUserAddress());
		fillField(secondAddressField,Utility.generateUserAddress());
		fillField(cityField,"Lima");
		//FALTA SELECCIONAR UN ESTADO
		Utility.selectOneOptionFromDropbox(find(stateContainer));
		fillField(postCodeField,Utility.generatePostCode());
		//FALTA SELECCIONAR UN COUNTRY
		Utility.selectOneOptionFromDropbox(find(countryContainer));
		fillField(additionalInformationField,Utility.generateRandomInformation());
		fillField(homePhoneField,Utility.generateHomePhone());
		fillField(mobilePhoneField,Utility.generateMobilePhone());
		fillField(alliasAddressField,Utility.generateUserAddress());	
	}
	
	public MyAccountPage registerNewUser(){
		clickOnElement(registerButton);
		return new MyAccountPage(driver);
	}
}
