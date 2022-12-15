package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.deser.Deserializers.Base;

import base.TestBase;
import pageObjectRepo.PdpObjects;

public class PdpTestCases extends TestBase {
	
	PdpObjects pdp;
	
	@BeforeMethod
	public void testSetup() {
		OpenApplication();
		pdp = new PdpObjects();
	}
	
	@AfterMethod
	public void testTeardown() {
		//closeTestActivities();
	}
	
	@Test
	public void testSku() {
		driver.navigate().to("https://demo.nopcommerce.com/nike-tailwind-loose-short-sleeve-running-shirt");
		System.out.println(pdp.getProductSKU());
		String temp = pdp.getProductSKU();
		driver.findElement(By.xpath("//input[@aria-label=\"Enter a quantity\"]")).clear();
		driver.findElement(By.xpath("//input[@aria-label=\"Enter a quantity\"]")).sendKeys("4");
		Select s = new Select(driver.findElement(By.id("product_attribute_11")));
		s.selectByVisibleText("3X");
		driver.findElement(By.xpath("//button[starts-with(@id,'add-to-cart')]")).click();
		driver.findElement(By.xpath("//a[@class=\"ico-cart\"]")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//span[@class=\"sku-number\"]")).getText(), temp);
	}
	

}
