package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class base {
//TODO Cleanup and refactor 
	public static WebDriver driver;			//have to create it only once, and can use globally, doesnt mean its a singleton
	//public Properties prop;
	
	public WebDriver initializeDriver() throws IOException {
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\deepa\\eclipse-workspace\\RBCAutomationChallenge\\src\\main\\java\\resources\\data.properties");
		
		prop.load(fis);
		String browserName=prop.getProperty("browser");
		
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "src/main/java/webdrivers/chromedriver.exe");
			driver = new ChromeDriver();	
		}
		else if(browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "src/main/java/webdrivers/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browserName.equals("IE")) {
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //Waiting time
		return driver;
	}
	
	
	
}
