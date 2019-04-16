package Utilities;

import java.util.ArrayList;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.github.javafaker.Faker;

/**
 * @author Fernando Ayasta
 *
 */
public class Utility {
	
	/**
	 * Selects one option from a dropbox webElement. 
	 * @param webElement
	 */
	public static void selectOneOptionRandomlyFromDropbox(WebElement webElement){
		webElement.click(); //expand the menu
		ArrayList<WebElement> listOfOptions = (ArrayList) webElement.findElements(By.tagName("option"));
		listOfOptions.remove(0); //Deleting empty option
		int min = 0;
		int max = listOfOptions.size()-1;
		if(max==1){
			listOfOptions.get(0).click();
		}else{
			listOfOptions.get(getRandomBetween(min,max)).click();
		}
	}
	
	/**
	 * Method that returns a random in a range
	 * @param min min value.
	 * @param max max value.
	 * @return
	 */
	public static int getRandomBetween(int min, int max){
		Random r = new Random();
		return  r.nextInt((max - min) + 1) + min;
	}
}
