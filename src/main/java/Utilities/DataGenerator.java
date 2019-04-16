package Utilities;

import java.util.Random;
import com.github.javafaker.Faker;

/**
 * This Class generates the data required to test the scenarios
 * @author Fernando Ayasta
 *
 */
public class DataGenerator {
	
	public static String generateUserEmail() {
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
	
	public static String selectOneGender(){
		Faker faker = new Faker();
		return faker.name().firstName();
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
