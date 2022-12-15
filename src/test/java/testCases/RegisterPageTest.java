package testCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pageObjectRepo.HomePage;
import pageObjectRepo.RegistrationPage;

public class RegisterPageTest extends TestBase {
	
	HomePage homeP;
	RegistrationPage regP;
	
	@BeforeMethod
	public void start() {
		OpenApplication();
		homeP = new HomePage();
		regP = new RegistrationPage();
	}
	
	
	@AfterMethod
	public void end() {
		driver.quit();
	}
	
	@Test
	public void registerNewUserWithValidEmail_002() throws InterruptedException {
		homeP.clickOnRegister();
		String randomEmail = homeP.generateRandomEmail();
		regP.populateRequiredFieds("John", "Johnson", randomEmail, "123456");
		regP.clickSubmit();
		
		//assertion
		String actMsg = driver.findElement(By.xpath("//*[@class=\"result\"]")).getText();
		String expMsg = "Your registration completed";
		Assert.assertEquals(actMsg, expMsg);
	
	}
	
	@Test
	public void registerNewUserWithInvalidEmail_003() {
		homeP.clickOnRegister();
		regP.populateRequiredFieds("John", "Johnson","janedoe&email.com" , "123456");
		regP.clickSubmit();

		String actMsg = driver.findElement(By.xpath("//span[@id=\"Email-error\"]")).getText();
		String expMsg = "Wrong email";
		Assert.assertEquals(actMsg, expMsg);
	}
	
	
	
	
	
	
	
	
	
	
	

}
