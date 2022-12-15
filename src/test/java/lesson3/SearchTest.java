package lesson3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchTest {
	
	WebDriver driver;
	
	@BeforeMethod
	public void start() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
	}
	
	@AfterMethod
	public void end() {
		driver.quit();
	}
	
	@Test
	public void validateSearchResults() {
		WebElement searchField = driver.findElement(By.xpath("//*[@name=\"q\"]"));
		WebElement searchBtn = driver.findElement(By.xpath("//button[@type=\"submit\"]"));
		String searchItemValid = "Gift";
		
		searchField.sendKeys(searchItemValid);
		searchBtn.click();
		
		//Validation
		int countNumElements = driver.findElements(By.xpath("//*[@class=\"product-title\"]")).size();
		System.out.println(countNumElements);
		
		for(int i=1; i<countNumElements+1; i++) {
			
			String text = driver.findElement(By.xpath("(//*[@class=\"product-title\"])[" +i+"]")).getText();
			System.out.println(text);
			Assert.assertTrue(text.contains(searchItemValid));
		}
	}
	
}
