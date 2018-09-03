package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TransactionPage {

	WebDriver driver;

	public TransactionPage(WebDriver driver) {
		this.driver = driver;
	}

	By message = By.className("entry-title");

	public WebElement getMessage() {
		return driver.findElement(message);
	}
}
