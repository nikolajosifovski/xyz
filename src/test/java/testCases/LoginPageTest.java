package testCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pageObjectRepo.HomePage;
import pageObjectRepo.LoginPage;

public class LoginPageTest extends TestBase {
	
	HomePage hp;
	LoginPage lp;
	
	@BeforeMethod
	public void setUp() {
		OpenApplication();
		hp = new HomePage();
		lp = new LoginPage();
		
	}
	
	@AfterMethod()
		public void tearDown() {
		driver.quit();
	}
	
	
	@Test
	public void validLogin() {
		
		hp.navigateOnLoginPage();
		lp.loginUser("nikola@iwec.com", "qwerty");
		hp.myAccountTopMenu.isDisplayed();
		String myAcc = hp.myAccountTopMenu.getText();
		Assert.assertEquals(myAcc, "My account");

		
	}
	

	
	
	@Test
	public void loginWithinvalidUserName() {
		hp.navigateOnLoginPage();
		lp.loginUser("test123@mail.com", "password349384");
		
		//Assertion
		String expErrorMsg= "No customer account found";
		String actErrorMsg = driver.findElement(By.xpath("//div[@class=\"message-error validation-summary-errors\"]/ul")).getText();
		System.out.println(actErrorMsg);
		System.out.println(expErrorMsg);
		Assert.assertEquals(expErrorMsg, actErrorMsg );
		
		
		hp.cancelBtn.click();
		lp.cancelBtn.click();

		

		
	}

}
