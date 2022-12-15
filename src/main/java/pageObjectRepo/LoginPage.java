package pageObjectRepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class LoginPage extends TestBase{
	
	
	@FindBy(id = "Email")
	WebElement emailField;
	
	@FindBy(id = "Password")
	WebElement passwordField;
	
	@FindBy(xpath = "//*[@class=\"button-1 login-button\"]")
	public WebElement cancelBtn;
	
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public void loginUser(String user,String password) {
		emailField.sendKeys(user);
		passwordField.sendKeys(password);
	}

}
