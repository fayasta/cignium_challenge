package Utilities;

import java.util.ArrayList;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.github.javafaker.Faker;

public class Utility {
	
	public static String getUserEmail() {
		 String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
	        StringBuilder salt = new StringBuilder();
	        Random rnd = new Random();
	        while (salt.length() < 10) { // length of the random string.
	            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
	            salt.append(SALTCHARS.charAt(index));
	        }
	        String saltStr = salt.toString();
	        return saltStr+"@sharky.com";
	}
	
	public static void selectOneOptionFromDropbox(WebElement webElement){
		webElement.click(); //expand the menu
		ArrayList<WebElement> listOfOptions = (ArrayList) webElement.findElements(By.tagName("option"));
		listOfOptions.remove(0); //Deleting empty option
		int min = 0;
		int max = listOfOptions.size();
		if(max==1){
			listOfOptions.get(0).click();
		}else{
			Random r = new Random();
			int pos = r.nextInt((max - min) + 1) + min;
			listOfOptions.get(pos).click();
		}
	}
	
	public static String generateUserFirstName(){
		Faker faker = new Faker();
		return faker.name().firstName();
	}
	
	public static String generateUserLastName(){
		Faker faker = new Faker();
		return faker.name().lastName();
	}
	
	public static String generateUserAddress(){
		Faker faker = new Faker();
		return faker.address().streetAddress();
	}
	
	public static String generateCompanyName(){
		Faker faker = new Faker();
		return faker.company().name();
	}
	
	public static String generateHomePhone(){
		Faker faker = new Faker();
		return faker.number().digits(9);
	}
	
	public static String generateMobilePhone(){
		Faker faker = new Faker();
		return faker.number().digits(9);
	}
	
	public static String generatePassword(){
		Faker faker = new Faker();
		return faker.lorem().characters(10);
	}
	
	public static String generateRandomInformation(){
		Faker faker = new Faker();
		return faker.lorem().characters(30);
	}
	
	public static String generatePostCode(){
		Faker faker = new Faker();
		return faker.number().digits(5);
	}
}
