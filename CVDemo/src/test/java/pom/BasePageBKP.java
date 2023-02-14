package pom;

import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.awt.datatransfer.StringSelection;
import java.io.FileInputStream;
import java.io.IOException;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePageBKP {
	
	public static WebDriver driver;
	public Properties prop;
	public String resourcesdir = (String)(System.getProperty("user.dir") + "\\src\\test\\java\\resources\\");
	private Actions action;
	
	public Properties prepareData() throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream(resourcesdir+"data.properties");
		prop.load(fis);
		return prop;
	}
	
	public WebDriver InitializeDriver() throws IOException {
		String browser = prop.getProperty("browser");

		switch(browser) {	//To Do: Add more cases. Test compatibility.
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		}
		
		String url = prop.getProperty("url");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);
		driver.manage().window().maximize();
		
		return driver;
	}
	
	public void TearDown() {
		driver.quit();
	}
	
	public String picdir = (String)(System.getProperty("user.dir") + "\\src\\test\\java\\img\\");
	
	public void CopyToClipboard(String text) {
		StringSelection stringSelection = new StringSelection(text);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(stringSelection, null);
	}
	
	public void click(By element) {
		action.moveToElement(driver.findElement(element)).click().build().perform();
	}
	
	//To Do: Create method to take ScreenShots
	
}
