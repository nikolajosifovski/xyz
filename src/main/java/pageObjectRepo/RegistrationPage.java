package pageObjectRepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class RegistrationPage extends TestBase {
	
	@FindBy(xpath = "//*[@id=\"FirstName\"]")
	WebElement firstName;
	
	@FindBy(xpath = "//*[@id=\"LastName\"]")
	WebElement lastName;
	
	@FindBy(name = "Email")
	WebElement email;
	
	@FindBy(id = "Password")
	WebElement password;
	
	@FindBy(xpath = "//input[@name=\"ConfirmPassword\"]")
	WebElement confirmPassswod;
	
	@FindBy(xpath = "(//button[@type=\"submit\"])[2]")
	WebElement submitBtn;
	
	
	public RegistrationPage() {

		PageFactory.initElements(driver, this);
	}
	
	
	
	public void inputFirstName(String arg1) {
		firstName.sendKeys(arg1);
	}
	
	public void inputLastName(String arg1) {
		lastName.sendKeys(arg1);
	}
	public void inputEmail(String arg34343) {
		email.sendKeys(arg34343);
	}
	public void inputPasswod(String arg) {
		password.sendKeys(arg);
	}
	public void inputConfirmPassword(String arg) {
		confirmPassswod.sendKeys(arg);
	}
	public void clickSubmit() {
		submitBtn.click();
				
	}
	  public void populateRequiredFieds(String fName, String lName, String emailAddress, String pass) 
	  {
	    firstName.sendKeys(fName);
	    lastName.sendKeys(lName);
	    email.sendKeys(emailAddress);
	    password.sendKeys(pass);
	    confirmPassswod.sendKeys(pass);
	  }
	  
	  public String validName = "Jonh";

}
