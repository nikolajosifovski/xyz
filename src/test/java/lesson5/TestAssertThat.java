package lesson5;
import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.WebDriver;

public class TestAssertThat {
	
	WebDriver driver;
	
	public void testAssertions() {
		assertThat(driver.getPageSource().contains("123")).isTrue();
	}

}
