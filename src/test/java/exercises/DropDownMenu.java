package exercises;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownMenu {
	
	WebDriver driver;
	String url = "https://rahulshettyacademy.com/AutomationPractice/";
	
	@BeforeMethod
	public void testSetup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		
	}
	@AfterMethod
	public void testTeardown() {
		//driver.quit();
	}
	
	@Test
	public void testMenu() {
		
		Select dropDownMenu = new Select(driver.findElement(By.id("dropdown-class-example")));
		dropDownMenu.selectByVisibleText("Option1");
	
	}
	
	
	@Test
	public void testMenu2() {
		
		Select dropDownMenu = new Select(driver.findElement(By.id("dropdown-class-example")));
		dropDownMenu.selectByIndex(2);
	}
	
	
	@Test
	public void testMenu3() {
		
		Select dropDownMenu = new Select(driver.findElement(By.id("dropdown-class-example")));
		dropDownMenu.selectByValue("option3");
		
		//Assertion
		WebElement option = dropDownMenu.getFirstSelectedOption();
		String actSelection = option.getText();
		System.out.println(actSelection);
		Assert.assertEquals("Option3", actSelection);
	}
}
