package seleniumgluecode;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Hooks {
	
	private static WebDriver driver;
	
	@Before
	public void initDriver() {		
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();						//To Do: Use the properties file here as it was on BasePageBKP

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.cv-template.com/en");
		driver.manage().window().maximize();

	}
	
	
	@After
	public void tearDown() {
		driver.quit();
		//To Do: Create method to take ScreenShots of failures.
	}
	
	public static WebDriver getDriver() {
		return driver;
	}

}
