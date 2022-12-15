package excercises2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Waits {
	
	@Test
	public void loadingImages() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://bonigarcia.dev/selenium-webdriver-java/loading-images.html");
		driver.manage().window().maximize();
		
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		//WebElement image4=  driver.findElement(By.xpath("//img[@id='landscape']"));
		wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//img[@id='landscape']"))));
		
		
		String doneText = driver.findElement(By.id("text")).getText();
		Assert.assertEquals(doneText, "Done!");
		
		driver.quit();
	}

}
