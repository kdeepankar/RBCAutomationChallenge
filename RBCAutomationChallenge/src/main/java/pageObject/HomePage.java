package pageObject;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.demo.automation.utilities.MyLogger;

public class HomePage {

	public WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	// By Locators

	By ProductCategory = By.xpath("//li[@id='menu-item-33']");
	By Accessories = By.xpath("//li[@id='menu-item-34']");
	// By Accessories =
	// By.xpath("//a[@href='http://store.demoqa.com/products-page/product-category/accessories']");
	By BuyNow = By.xpath("//img[@alt='Magic Mouse']");

	/**
	 * Locator Methods
	 * @throws Exception 
	 **/

	public void hoverOverElement() throws Exception {
		try {
			Actions action = new Actions(driver);
			action.moveToElement(driver.findElement(ProductCategory)).build().perform();
		} catch (Exception e) {
			MyLogger.write("Error while hover over the element, element was not found!", true, false);
			throw e;
		}
	}

	public WebElement getProductCategory() {
		return driver.findElement(ProductCategory);
	}

	public WebElement getMagicMouse() {
		return driver.findElement(BuyNow);
	}

	public WebElement getAccessories() throws Exception {
		hoverOverElement();
		return driver.findElement(Accessories);
	}
}