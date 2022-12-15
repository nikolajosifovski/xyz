package pageObjectRepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class PdpObjects extends TestBase {
	
	@FindBy(xpath = "//div[@class=\"sku\"]//following::span[1]")
	WebElement skuValuePDP;
	
	
	public PdpObjects() {
		PageFactory.initElements(driver, this);
	}
	
	public String getProductSKU() {
		return skuValuePDP.getText();
	}

}
