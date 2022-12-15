package pageObjectRepo;

import java.util.UUID;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class HomePage extends TestBase {

	
	//Element Location
	
	
	//Home page elements locators
	@FindBy(xpath = "//a[@class='ico-register']")
	WebElement registerTopMenu;
	
	@FindBy(xpath = "//a[@class='ico-login']")
	WebElement loginTopMenu;
	
	@FindBy(xpath = "//a[@class='ico-wishlist']/span")
	WebElement wishlistTopMenu;
	
	@FindBy(xpath = "//li[@id=\"topcartlink\"]/a")
	WebElement cartTopMenu;
	
	@FindBy(xpath = "//input[@id=\"small-searchterms\"]")
	WebElement searchInputField;
	
	@FindBy(xpath = "//button[@type=\"submit\"]")
	WebElement searchBtn;
	
	@FindBy(xpath = "//a[@class='ico-account']")
	public WebElement myAccountTopMenu;
	
	@FindBy(id = "cancel")
	public WebElement cancelBtn;
	

	//Constructor of the class ... Initializing the Page Objects
	public HomePage() {
	// this means current class object
		PageFactory.initElements(driver, this);
	}
	
	
	// Home page methods
	
	public void searchItem(String item) {
		searchInputField.sendKeys(item);
		searchBtn.click();
	}
	
	public void clickOnRegister() {
		registerTopMenu.click();
	}
	
	public void navigateOnLoginPage() {
		loginTopMenu.click();
		
	}
	 public String getUniqueId() {
         return String.format("%s_%s", UUID.randomUUID().toString().substring(0, 5), System.currentTimeMillis() / 1000);
     }
	 
	 public String generateRandomEmail() {
	        return String.format("%s@%s", getUniqueId(), "testing.com");
	    }

	
	
	
}
