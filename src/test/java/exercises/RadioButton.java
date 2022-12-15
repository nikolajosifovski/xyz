package exercises;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RadioButton {
	
	String driverKey = "webdriver.chrome.driver";
	String driverLocChrome = "C://chromedriver_win32//chromedriver.exe";
	String baseURL = "https://rahulshettyacademy.com/AutomationPractice/";
	
	@Test
	public void testRadioButtons() {
		//setup driver location
		System.setProperty(driverKey, driverLocChrome);
		
		//open chrome browser
		ChromeDriver driver = new ChromeDriver();
		
		//open home page
		driver.get(baseURL);
		
		//find radio button and click 
		//driver.findElement(By.xpath("//label[@for=\"radio1\"]/input")).click();
		
		// or store the button as web element and then click
		WebElement radioBtn1 = driver.findElement(By.xpath("//label[@for=\"radio1\"]/input"));
		WebElement radioBtn2 = driver.findElement(By.xpath("//*[@id=\"radio-btn-example\"]/fieldset/label[2]/input"));
		WebElement radioBtn3 = driver.findElement(By.xpath("//*[@id=\"radio-btn-example\"]/fieldset/label[3]/input"));
		
		radioBtn2.click();
		
		if(radioBtn1.isSelected()) {
			System.out.println("Radio Button Option 1 Selected");
		}
		else {
			System.out.println("Radio Button Option 1 - is not selected");
		}
		Assert.assertTrue(radioBtn2.isSelected());
		Assert.assertFalse(radioBtn3.isSelected());
		
		driver.quit();
		
		
	}

}
