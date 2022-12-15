package lesson3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckboxesRadioDropDown {
	
	WebDriver driver;
	String browser = "chrome";
	String homePage = "https://bonigarcia.dev/selenium-webdriver-java/web-form.html";
	
	
	
	@BeforeMethod
	public void s() {
		if(browser == "chrome") {
			driver = WebDriverManager.chromedriver().create();
		}
		else if(browser == "ff"){
			driver = WebDriverManager.firefoxdriver().create();
			
		}
		
		driver.get(homePage);
		driver.manage().window().maximize();
	}
	
	@AfterMethod 
	public void e() throws InterruptedException{
		Thread.sleep(3000);
		driver.quit();
	}
	
	@Test
	public void selectRadioBtn() {
		WebElement rBtn1 = driver.findElement(By.id("my-radio-1"));
		WebElement r2 = driver.findElement(By.id("my-radio-2"));
		//r2.click();

		boolean status = r2.isSelected();
		System.out.println(status);
		assertTrue(r2.isSelected(), "Element r2 is not selected");

	}
	
	@Test
	public void selectCheckbox() {
		WebElement check1 = driver.findElement(By.id("my-check-1"));
		WebElement check2 = driver.findElement(By.id("my-check-2"));
		
		assertTrue(check1.isSelected());
		assertFalse(check2.isSelected());
		
		check1.click();
		check2.click();
		assertTrue(check2.isSelected());
		assertFalse(check1.isSelected(), "checkbox is selected");
		

		if(check1.isSelected()) {
			System.out.println("Check box is already selected");
		}
		else {
			check1.click();
		}
		
		
		assertTrue(check1.isSelected(), "Error checkbox is not selected");
	}
	
	@Test
	public void selectFromList() {
		WebElement list = driver.findElement(By.name("my-select"));
		Select s = new Select(list);
		
		s.selectByIndex(1);
		WebElement selection = s.getFirstSelectedOption();
		String text = selection.getText();
		Assert.assertEquals(text, "One");
	}
	
	
	
	
	
	
	
	
	
	

}
