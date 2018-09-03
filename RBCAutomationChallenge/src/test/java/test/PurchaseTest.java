package test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.demo.automation.utilities.DataEntry;
import com.demo.automation.utilities.MyLogger;

import pageObject.Accessories;
import pageObject.CheckoutPage;
//import pageObject.Actions;
import pageObject.HomePage;
import pageObject.TransactionPage;
import resources.base;

public class PurchaseTest extends base {

	@BeforeClass
	public void StartHTMLReporting() {
		MyLogger.initiateHTMLReporting();
	}

	@Test
	public void navigate() throws Exception {
		driver = initializeDriver();
		driver.get("http://store.demoqa.com/");
		HomePage hp = new HomePage(driver);
		Accessories as = new Accessories(driver);
		CheckoutPage co = new CheckoutPage(driver);
		TransactionPage tp = new TransactionPage(driver);

		System.out.println(hp.getAccessories().isDisplayed());

		hp.getAccessories().click();

		System.out.println("# of items displaying in the cart before: " + as.getCartItem().getText());
		as.getAddToCart().click();
		System.out.println("# of items displaying in the cart after: " + as.getCartItem().getText());
		System.out.println("# of items added to cart: " + as.getItemCount());

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.textToBePresentInElement(as.getCartItem(), as.getItemCount()));

		System.out.println("# of items displaying in the cart after wait: " + as.getCartItem().getText());

		as.getCheckOut().click();

		co.compare();
		WebElement c = co.getCountry();
		wait.until(ExpectedConditions.attributeContains(driver.findElement(By.xpath("//div[@class='slide2']")), "style",
				"display: block;"));

		co.selectCountry();

		// Entry is missing
		co.getCheckbox().click();

		wait.until(ExpectedConditions.visibilityOf(co.getPurchase()));

		co.getPurchase().click();

		if (tp.getMessage().getText().equals("Transaction Results")) {
			System.out.println("Checkout Successfull!");
		} else {
			System.out.println("Checkout failed, because the fields were empty.");
		}

	}

	@DataProvider
	public Iterator<Object[]> getData() {

		String path = "C:\\Users\\deepa\\eclipse-workspace\\RBCAutomationChallenge\\src\\main\\java\\resources\\TestData.xlsx";
		// create array list
		ArrayList<Object[]> testData = DataEntry.getData(path);

		// return iterator;
		return testData.iterator();
	}

	// MULTIPLE TESTS RUN USING DATA DRIVEN THROUGH SPREADSHEET
	@Test(dataProvider = "getData")
	public void navigation(String email, String f_name, String l_name, String address, String city, String state,
			String country, String postalcode, String phone, String check) throws IOException, InterruptedException {

		driver = initializeDriver();
		WebDriverWait wait = new WebDriverWait(driver, 30);

		// STEP 1: Go to http://store.demoqa.com/
		MyLogger.write("STEP 1: Go to http://store.demoqa.com/", false, false);
		try {
			driver.get("http://store.demoqa.com/");
			MyLogger.write("STEP 1: Go to http://store.demoqa.com/", true, true);
		} catch (Exception e) {
			// e.toString(); FILL IT UPPP
			MyLogger.write("Error while executing STEP 1: Go to http://store.demoqa.com/", true, false);
		} finally {
			MyLogger.write("End of Step 1", false, false);
		}

		// Creating objects for the pageObject classes
		HomePage hp = new HomePage(driver);
		Accessories as = new Accessories(driver);
		CheckoutPage co = new CheckoutPage(driver);
		TransactionPage tp = new TransactionPage(driver);

		// STEP 2: Go to Product category and select Accessories
		MyLogger.write("STEP 2: Go to Product category and select Accessories", false, false);
		try {
			System.out.println(hp.getAccessories().isDisplayed());
			hp.getAccessories().click();
			MyLogger.write("STEP 2: Go to Product category and select Accessories", true, true);
		} catch (Exception e) {
			MyLogger.write(
					"Error while executing STEP 2: Go to Product category and select Accessories " + e.toString(), false,
					false);
			MyLogger.write("STEP 2: Go to Product category and select Accessories", true, false);
		} finally {
			MyLogger.write("End of Step 2", false, false);
		}

		// STEP 3: Click on “Add to Cart” for just Magic Mouse
		MyLogger.write("STEP 3: Click on “Add to Cart” for just Magic Mouse", false, false);
		try {
			MyLogger.write("# of items displaying in the cart before: " + as.getCartItem().getText(), false, false);
			// Clicks on add to cart for magic mouse
			as.getAddToCart().click();
			MyLogger.write("# of items displaying in the cart after: " + as.getCartItem().getText(), false, false);
			MyLogger.write("# of items added to cart: " + as.getItemCount(), false, false);
			MyLogger.write("STEP 3: Click on “Add to Cart” for just Magic Mouse", true, true);
		} catch (Exception e) {
			MyLogger.write("Error while executing STEP 3: Click on “Add to Cart” for just Magic Mouse", true, false);
		} finally {
			MyLogger.write("End of step 3 ", false, false);
		}

		/*
		 * STEP 4: Click on “Checkout” and confirm you have 1 Magic Mouse in your
		 * Check-Out Page && STEP 5: After confirming, click on Continue
		 * 
		 * are combined because click event is triggered while checking the condition
		 */

		MyLogger.write(
				"STEP 4: Click on “Checkout” and confirm you have 1 Magic Mouse"
						+ " in your Check-Out Page &&  STEP 5: After confirming, " + "click on Continue combination",
				false, false);
		try {
			// Using explicit wait, until the required condition is met

			wait.until(ExpectedConditions.textToBePresentInElement(as.getCartItem(), as.getItemCount()));

			MyLogger.write("# of items displaying in the cart after wait: " + as.getCartItem().getText(), false, false);
			// After checking the condition, click on checkout
			as.getCheckOut().click();
			// Checking if there is at least one magic mouse in the cart
			co.compare();
			MyLogger.write("STEP 4: Click on “Checkout” and confirm you have 1 Magic Mouse"
					+ " in your Check-Out Page &&  STEP 5: After confirming, " + "click on Continue combination", true,
					true);
		} catch (Exception e) {
			MyLogger.write("Error while executing Step 4 & Step 5 combination", true, false);
		} finally {
			MyLogger.write("End of Step 4 & Step 5 combination", false, false);
		}

		// STEP 6: Enter test (dummy) data needed for email, billing/contact details and
		// click Purchase
		MyLogger.write("STEP 6: Enter test (dummy) data needed for email, billing/contact details and click Purchase",
				false, false);
		try {
			// WebElement c = co.getCountry(); TO REMOVE
			// Using explicit wait until the slide changes and the UI is available with a
			// change in class attribute
			wait.until(ExpectedConditions.attributeContains(driver.findElement(By.xpath("//div[@class='slide2']")),
					"style", "display: block;"));
			// Exception is being handled within the checkout class
			co.selectCountry();

//			MyLogger.write("Email" + email, false, false);
//			MyLogger.write("First name " + f_name, false, false);
//			MyLogger.write("Last name" + l_name, false, false);
//			MyLogger.write("Phone" + phone, false, false);
//			MyLogger.write(String.valueOf(check), false, false);

			// Sending information through spreadsheet row by row, and a new test case is
			// created for every row
			co.getEmail().sendKeys(email);
			co.getFirstName().sendKeys(f_name);
			co.getLastName().sendKeys(l_name);
			co.getAddress().sendKeys(address);
			co.getCity().sendKeys(city);
			co.getProvince().sendKeys(state);
			co.getPostalCode().sendKeys(postalcode);
			co.getPhone().sendKeys(phone);
			co.getCheckbox().click();

			// After the billing form is filled up, wait for the visibility of the purchase
			// button to be clicked
			wait.until(ExpectedConditions.visibilityOf(co.getPurchase()));
			// Once the button appears, click it
			co.getPurchase().click();
			MyLogger.write(
					"STEP 6: Enter test (dummy) data needed for email, billing/contact details and click Purchase",
					true, true);
		} catch (Exception e) {
			MyLogger.write("Error while executing Step 6", true, false);
		} finally {
			// CHECKING FOR CONTINUE BUTTON IN TRANSACTION PAGE, because it still exists and visible when it redirects you to checkout page, because just the slide is changing.
			try {
				WebElement continueBtn = co.getContinue();
				MyLogger.write("Error while executing Step 6", true, false);
			}catch(Exception e) {
				//Failed to get continue button, this means that information entered into form worked as expected.
				MyLogger.write(
						"STEP 6: Enter test (dummy) data needed for email, billing/contact details and click Purchase",
						true, true);
			}
			MyLogger.write("End of Step 6", false, false);
		}

		// STEP 7: Confirm that you have placed the Order in ‘Transaction Results’ page
		MyLogger.write("STEP 7: Confirm that you have placed the Order in ‘Transaction Results’ page", false, false);
		try {
			if (tp.getMessage().getText().equals("Transaction Results")) {
				MyLogger.write("Checkout Successful", false, false);
				MyLogger.write("STEP 7: Confirm that you have placed the Order in ‘Transaction Results’ page", true, true);
			} else {
				MyLogger.write("Checkout Failed", false, false);
				MyLogger.write("STEP 7: Confirm that you have placed the Order in ‘Transaction Results’ page", true, false);
			}
		} catch (Exception e) {
			MyLogger.write("Error while executing Step 7", true, false);
		} finally {
			MyLogger.write("End of Step 7", false, false);
		}
	}

	@AfterClass
	public void TerminateHTMLReporting() {
		MyLogger.endHTMLReporting();
	}
}
