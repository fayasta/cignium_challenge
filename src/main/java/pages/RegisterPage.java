package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import Utilities.DataGenerator;
import Utilities.Utility;
import base.BasePageObject;

public class RegisterPage extends BasePageObject<RegisterPage> {
	
	//PERSONAL INFORMATION SECTION
	private By mrOption = By.id("id_gender1");
	private By mrsOption = By.id("id_gender2");
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

	/**
	 * This method has the purpose of waiting until the elements required are visible in order to use this page
	 */
	public void isPageOpen(){
		waitForVisibilityOf(customerFirstNameField, 10);
		waitForVisibilityOf(companyField, 10);
	}
	
	/**
	 * Method which selects either Mr or Mrs. If the random returns 1, selects Mr; otherwise, selects Mrs.
	 */
	private void clickOnGenerOption(){
		int option = Utility.getRandomBetween(1, 2);
		if (option==1){
			 clickOnElement(mrOption);
		}else{
			 clickOnElement(mrsOption);
		}
	}
	
	/**
	 * This method completes the Personal Information section.
	 * @param userFirstName
	 * @param userLastName
	 */
	public void completePersonalInformationForm(String userFirstName, String userLastName){
		clickOnGenerOption();
		fillField(customerFirstNameField,userFirstName);
		fillField(customerLastNameField,userLastName);
		fillField(userPasswordField, DataGenerator.generatePassword());
		Utility.selectOneOptionRandomlyFromDropbox(find(daysContainer));
		Utility.selectOneOptionRandomlyFromDropbox(find(monthsContainer));
		Utility.selectOneOptionRandomlyFromDropbox(find(yearsContainer));
	}
	
	/**
	 * This method completes the User Address section.
	 */
	public void completeUserAddress(){
		fillField(companyField, DataGenerator.generateCompanyName());
		fillField(firstAddressField, DataGenerator.generateUserAddress());
		fillField(secondAddressField, DataGenerator.generateUserAddress());
		fillField(cityField,"Lima");
		Utility.selectOneOptionRandomlyFromDropbox(find(stateContainer));
		fillField(postCodeField, DataGenerator.generatePostCode());
		Utility.selectOneOptionRandomlyFromDropbox(find(countryContainer));
		fillField(additionalInformationField, DataGenerator.generateRandomInformation());
		fillField(homePhoneField, DataGenerator.generateHomePhone());
		fillField(mobilePhoneField, DataGenerator.generateMobilePhone());
		fillField(alliasAddressField, DataGenerator.generateUserAddress());	
	}
	
	public MyAccountPage registerNewUser(){
		clickOnElement(registerButton);
		return new MyAccountPage(driver);
	}
}
