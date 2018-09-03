package pageObject;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.demo.automation.utilities.MyLogger;

public class CheckoutPage {

	WebDriver driver;

	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
	}

	// Locators
	By magicmouse = By.xpath("//a[text()='Magic Mouse']");
	By quantity = By.xpath("//input[@value='1']");
	By Continue = By.xpath("//span[text()='Continue']");

	/* By locators for billing address */
	By email = By.name("collected_data[9]");
	By firstName = By.name("collected_data[2]");
	By lastName = By.name("collected_data[3]");
	By address = By.name("collected_data[4]");
	By city = By.name("collected_data[5]");
	By province = By.name("collected_data[6]");
	By country = By.xpath("//select[@title='billingcountry']");;
	By postalCode = By.name("collected_data[8]");
	By phone = By.name("collected_data[18]");
	By checkbox = By.name("shippingSameBilling");
	By purchase = By.className("wpsc_make_purchase");

	// Getters
	public WebElement getName() {
		return driver.findElement(magicmouse);
	}

	public WebElement getQuantity() {
		return driver.findElement(quantity);
	}

	public WebElement getContinue() {
		return driver.findElement(Continue);
	}

	public WebElement getCountry() {
		return driver.findElement(country);
	}

	// To compare the product name and the quantity
	public void compare() throws Exception {
		try {
			if (getName().getText().equals("Magic Mouse") && getQuantity().getAttribute("value").equals("1")) {
				getContinue().click();
			} else {
				MyLogger.write("Please check your cart again", true, false);
			}
		} catch (Exception e) {
			MyLogger.write("Error while comparing name and quantity :" + e.toString(), true, false);
			throw e;
		}
	}

	// To select the country from dropdown
	@SuppressWarnings("finally")
	public Select selectCountry() throws Exception {
		Select country = null;
		try {
			country = new Select(driver.findElement(By.xpath("//select[@title='billingcountry']")));
			country.selectByVisibleText("Canada");
			return country;
		} catch (Exception e) {
			MyLogger.write("Failed to select the country" + e.toString(), true, false);
			throw e;
		} finally {
			return country;
		}
	}

	// Getters
	public WebElement getEmail() {
		return driver.findElement(email);
	}

	public WebElement getFirstName() {
		return driver.findElement(firstName);
	}

	public WebElement getLastName() {
		return driver.findElement(lastName);
	}

	public WebElement getAddress() {
		return driver.findElement(address);
	}

	public WebElement getCity() {
		return driver.findElement(city);
	}

	public WebElement getProvince() {
		return driver.findElement(province);
	}

	public WebElement getPostalCode() {
		return driver.findElement(postalCode);
	}

	public WebElement getPhone() {
		return driver.findElement(phone);
	}

	public WebElement getCheckbox() {
		return driver.findElement(checkbox);
	}

	public WebElement getPurchase() {
		return driver.findElement(purchase);
	}
}
