package exercises;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoSwagLabsTesting {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
	}
	
	@AfterMethod
	private void close() {
		//driver.quit();

	}
	
	@Test
	public void testEmptyCart() {
		driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("//input[@id='login-button']")).click();
		
		String actualURL = driver.getCurrentUrl();
		String expectedURL = "https://www.saucedemo.com/inventory.html";
		Assert.assertEquals(actualURL, expectedURL);
		
		driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();
		driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-onesie']")).click();
		
		driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
		
		int numItems = driver.findElements(By.xpath("//div[@class=\"inventory_item_price\"]/following-sibling::button")).size();
		System.out.println(numItems);
		
		for (int i = 0; i < numItems; i++) {
			driver.findElement(By.xpath("//div[@class=\"inventory_item_price\"]/following-sibling::button")).click();
		}
		Assert.assertEquals(0, driver.findElements(By.xpath("//div[@class=\"cart_item_label\"]")).size());
		

	}
	@Test
	public void testLogout() throws InterruptedException {

		driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
		WebElement logBtn = driver.findElement(By.xpath("//input[@id='login-button']"));
		logBtn.click();
		
		String actualURL = driver.getCurrentUrl();
		String expectedURL = "https://www.saucedemo.com/inventory.html";
		Assert.assertEquals(actualURL, expectedURL);
		
		driver.findElement(By.xpath("//button[@id=\"react-burger-menu-btn\"]")).click();
		//Thread.sleep(1000);
		
		WebElement l = driver.findElement(By.xpath("//a[@id=\"logout_sidebar_link\"]"));
		WebDriverWait wait = new WebDriverWait(driver, 15);
		
		wait.until(ExpectedConditions.elementToBeClickable(l));
		String css = l.getCssValue("font-size");
		System.out.println(css);
		l.click();
		
		String s = driver.getPageSource();
		System.out.println(s);
		//driver.navigate().to(url);
		
		String actualURL1 = driver.getCurrentUrl();
		String expectedURL1 = "https://www.saucedemo.com/";
		Assert.assertEquals(actualURL1, expectedURL1);
		
		//wait.until(ExpectedConditions.elementToBeClickable(logBtn));
		//Thread.sleep(1000);
		//Assert.assertTrue(logBtn.isDisplayed());
		
		
		
		
	}
	@Test
	public void testOrders() throws InterruptedException {
		driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("//input[@id='login-button']")).click();
		
		String actualURL = driver.getCurrentUrl();
		String expectedURL = "https://www.saucedemo.com/inventory.html";
		Assert.assertEquals(actualURL, expectedURL);
		
		driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();
		driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-onesie']")).click();
		
		driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
		
		driver.findElement(By.xpath("//button[@id='checkout']")).click();
		
		driver.findElement(By.xpath("//input[@id='first-name']")).sendKeys("Nikola");
		driver.findElement(By.xpath("//input[@id='last-name']")).sendKeys("Nikolov");
		driver.findElement(By.xpath("//input[@id='postal-code']")).sendKeys("70213");
		
		driver.findElement(By.xpath("//input[@id='continue']")).click();
		
		
	
		driver.findElement(By.xpath("//button[@id='finish']")).click();
		
		Assert.assertEquals(driver.findElement(By.xpath("//h2[@class='complete-header']")).getText(), "THANK YOU FOR YOUR ORDER");
	

	
	}
	
	@Test
	public void testSoring() throws InterruptedException {
		driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("//input[@id='login-button']")).click();
		
		String actualURL = driver.getCurrentUrl();
		String expectedURL = "https://www.saucedemo.com/inventory.html";
		Assert.assertEquals(actualURL, expectedURL);
		
		WebElement menu = driver.findElement(By.xpath("//*[@data-test=\"product_sort_container\"]"));
		
		Select s = new Select(menu);
		s.selectByVisibleText("Price (high to low)");
		
		//String price = driver.findElement(By.xpath("(//*[@class=\"inventory_item_price\"])[1]")).getText();
		//Assert.assertEquals(price, "$49.99");
		
		int pece1 = driver.findElements(By.className("inventory_item_name")).size();

		System.out.println(pece1);
		
		for (int i=1; i<pece1; i++) {
			//String text = driver.findElement(By.xpath("//div[@class=\"inventory_item_name\"]")).getText();
			//System.out.println(text);
			
			//String xpathTemplate = "(//div[@class=\"inventory_item_name\"])[%s]";
			//String xpath = String.format(xpathTemplate,i);
			//String name = driver.findElement(By.xpath(xpath)).getText();
			
			String name = driver.findElement(By.xpath("(//*[@class=\"inventory_item_price\"])["+i+"]")).getText();
			System.out.println("cena prva" + name);
			i++;
			String name1 = driver.findElement(By.xpath("(//*[@class=\"inventory_item_price\"])["+i+"]")).getText();
			System.out.println(name1);
			i--;
			//Assert.assertTrue(false)
			String cenaPrva = name.replace("$", "");
			System.out.println(cenaPrva);
			String cenaVtora = name1.replace("$", "");
			System.out.println(cenaVtora);
			//
			
			double f = Double. parseDouble(cenaPrva);
			double f2 = Double. parseDouble(cenaVtora);
			Assert.assertTrue(f > f2);
		}

		
		
		
	}
	@Test
	public void addProductToCart() {
		driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("//input[@id='login-button']")).click();
		
		String actualURL = driver.getCurrentUrl();
		String expectedURL = "https://www.saucedemo.com/inventory.html";
		Assert.assertEquals(actualURL, expectedURL);
		
		driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();
		
		driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
		
		WebElement prod = driver.findElement(By.xpath("//div[@class='inventory_item_name']"));
		
		boolean result = prod.isDisplayed();
		System.out.println(result);
		if(result == true) {
			System.out.println("Product is added in the cart");
		}
		else {
			System.out.println("Cart is empty");
		}
		
		Assert.assertTrue(prod.isDisplayed());
	}
	@Test
	public void dropDownTest() throws InterruptedException {
		driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("//input[@id='login-button']")).click();
		
		String actualURL = driver.getCurrentUrl();
		String expectedURL = "https://www.saucedemo.com/inventory.html";
		Assert.assertEquals(actualURL, expectedURL);
		
		WebElement filter = driver.findElement(By.xpath("//select[@data-test=\"product_sort_container\"]"));
		
		Select s = new Select(filter);

		s.selectByVisibleText("Name (Z to A)");
	}
	
	
	
	
	
}
