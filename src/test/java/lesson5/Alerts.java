package lesson5;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Alerts {
	   WebDriver driver;

	    @BeforeMethod
	    public void setup() {
	        WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();
	        driver.get("https://bonigarcia.dev/selenium-webdriver-java/dialog-boxes.html");
	        driver.manage().window().maximize();
	    }

	    @AfterMethod
	    public void teardown() throws InterruptedException {
	        // FIXME: pause for manual browser inspection
	        Thread.sleep(Duration.ofSeconds(3).toMillis());

	        driver.quit();
	    }
	    
	    @Test
	    public void testAlert1() {
	    	WebDriverWait w = new WebDriverWait(driver, 10);
	    	
	    	driver.findElement(By.id("my-alert")).click();
	    	w.until(ExpectedConditions.alertIsPresent());
	    	Alert alert = driver.switchTo().alert();

	    	Assert.assertEquals(alert.getText(), "Hello world!");
	    	alert.accept();
	    	
	    }
	    @Test
	    public void testConfirmAlert() {
	    	
	    	driver.findElement(By.id("my-confirm")).click();
	    	driver.switchTo().alert().accept();
	    	Assert.assertEquals(driver.findElement(By.xpath("//p[@id=\"confirm-text\"]")).getText(), "You chose: true");
	    }
	    
	    @Test
	    public void testDismissAlert() {
	    	
	    	driver.findElement(By.id("my-confirm")).click();
	    	driver.switchTo().alert().dismiss();
	    	Assert.assertEquals(driver.findElement(By.xpath("//p[@id=\"confirm-text\"]")).getText(), "You chose: false");
	    }
	    @Test
	    public void testPrompt() {
	    	String text1 = "test 123";
	    	driver.findElement(By.id("my-prompt")).click();
	    	driver.switchTo().alert().sendKeys(text1);
	    	driver.switchTo().alert().accept();
	    	Assert.assertEquals(driver.findElement(By.id("prompt-text")).getText(), "You typed: " + text1);
	    }
	    


}
