package lesson3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Login2 {
	
	public String baseURL = "https://www.saucedemo.com/";
	public String driverValue =  "webdriver.chrome.driver";
	public String driverPath = "C:\\\\chromedriver_win32\\\\chromedriver.exe";
	
	//Test data
	String validUserName = "standard_user";
	String validPassword = "secret_sauce";
	String invalidPassword = "secret_sauce123";
	String expectedUrl = "https://www.saucedemo.com/inventory.html";
	String expextedErrorMessage = "Epic sadface: Username and password do not match any user in this service";
	
	
	WebDriver driver;
	

	
	
	@BeforeMethod
	public void testSetup() {
		System.setProperty(driverValue, driverPath);
		driver = new ChromeDriver();
		driver.get(baseURL);
		driver.manage().window().maximize();
		Assert.assertEquals(driver.getCurrentUrl(), baseURL);
	}
	
	@AfterMethod
	public void testTerdown() {
		driver.quit();
	}
	
	
	
	@Test
	public void loginWithValidCridentials() {
		
		WebElement userNameField = driver.findElement(By.xpath("//input[@id='user-name']"));
		WebElement passwordField = driver.findElement(By.xpath("//input[@id=\"password\"]"));
		WebElement loginBtn = driver.findElement(By.id("login-button"));
		
		
		userNameField.sendKeys(validUserName);
		passwordField.sendKeys(validPassword);
		loginBtn.click();
		
		Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
		
	}
	
	@Test
	public void loginWithInvalidPassword() {
		
		//Locating elements
		WebElement userNameField = driver.findElement(By.xpath("//input[@id='user-name']"));
		WebElement passwordField = driver.findElement(By.xpath("//input[@id=\"password\"]"));
		WebElement loginBtn = driver.findElement(By.id("login-button"));
		
		//Using locators to perform actions
		userNameField.sendKeys(validUserName);
		passwordField.sendKeys(invalidPassword);
		loginBtn.click();
		
		//Assertion
		String errorMsgWrongpassword = driver.findElement(By.xpath("//h3[@data-test=\"error\"]")).getText();
		Assert.assertEquals(errorMsgWrongpassword, expextedErrorMessage);
		
	}
	
	
	
	
	
}
