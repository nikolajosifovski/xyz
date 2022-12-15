package lesson3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitWait {
	
	WebDriver driver;
	
	@Test
	public void implicit() {
		driver = WebDriverManager.chromedriver().create();
		driver.get("https://demoqa.com/dynamic-properties");
		driver.manage().window().maximize();


		WebElement new1 = new WebDriverWait(driver,5).until(ExpectedConditions.elementToBeClickable(By.id("enableAfter")));
		new1.click();
		
		
		
	}
	@Test
	public void implicit2() {
		driver = WebDriverManager.chromedriver().create();
		driver.get("https://bonigarcia.dev/selenium-webdriver-java/loading-images.html");
		driver.manage().window().maximize();


		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement landscape = wait.until(ExpectedConditions
                .presenceOfElementLocated(By.id("landscape")));
		
		Assert.assertTrue(landscape.isDisplayed());
		assertThat(landscape.isDisplayed());
		assertThat(landscape.getAttribute("src")).containsIgnoringCase("land");

	}

	
	
}
