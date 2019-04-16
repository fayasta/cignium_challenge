package base;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePageObject<T>{
	protected WebDriver driver;
	protected WebDriverWait wait;
	
	protected BasePageObject(WebDriver driver){
		this.driver = driver;
		wait = new WebDriverWait(driver, 30);
	}
	
	protected void clickOnElement(By elementBy){
		find(elementBy).click();
	}
	
	protected WebElement find(By elementBy){
		return driver.findElement(elementBy);
	}
	
	protected void waitForVisibilityOf(By locator, Integer timeout){
		int attempts = 0;
		while(attempts < 2){
			try{
				waitFor(ExpectedConditions.visibilityOfElementLocated(locator),timeout);
				break;
			}catch (StaleElementReferenceException e) {
				// TODO: handle exception
			}
			attempts++;
		}
	}
	
	private void waitFor(ExpectedCondition<WebElement> condition, Integer timeOutInSeconds){
		timeOutInSeconds = timeOutInSeconds != null ? timeOutInSeconds:30;
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(condition);
	}
	
	protected void fillField(By elementBy, String input){
		WebElement webElement = find(elementBy);
		webElement.clear();
		webElement.sendKeys(input);
	}
}
