package testCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pageObjectRepo.HomePage;

public class SearchTest extends TestBase {
	HomePage hp;
	

	@BeforeMethod
	public void setUp() {
		OpenApplication();
		hp = new HomePage();
		
	}
	
	@AfterMethod()
		public void tearDown() {
		driver.quit();
	}
	
	
	
	@Test
	public void searchForExistingProduct_001(){
		hp.searchItem("Pride and Prejudice");
		//verify the results
		String actualItem = driver.findElement(By.xpath("//h2[@class=\"product-title\"]")).getText();
		String expectedItemTitle = "Pride and Prejudice";
				
		Assert.assertEquals(actualItem, expectedItemTitle);
	}
	
	@Test
	public void searchForNonExistingProduct_002() {
		
		hp.searchItem("test123");
		
		String invalidSearchMsg = driver.findElement(By.xpath("//*[@class=\"products-wrapper\"]/div")).getText();
		String expectedSearchErrorMsg = "No products were found that matched your criteria.";
		Assert.assertEquals(invalidSearchMsg, expectedSearchErrorMsg);
	}
	
	@Test
	public void searchForItemWithTwoCharacters004() {
		
		hp.searchItem("HP");
		
		String actualErrorSearchMsg = driver.findElement(By.xpath("//*[@class=\"warning\"]")).getText();
		String expectedSearchErrorMsg = "Search term minimum length is 3 characters";
		Assert.assertEquals(actualErrorSearchMsg, expectedSearchErrorMsg);
		
	}
}
