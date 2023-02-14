package pom;

import java.util.Properties;

import javax.imageio.ImageIO;

import java.awt.datatransfer.StringSelection;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	private WebDriver driver;
	public Properties prop;
	public String resourcesdir = (String) (System.getProperty("user.dir") + "\\src\\test\\java\\resources\\");

	public BasePage(WebDriver driver) {
		this.driver = driver;
	}

	public Properties prepareData() throws IOException {
		((JavascriptExecutor) driver).executeScript("document.body.spellcheck = false;");
		prop = new Properties();
		FileInputStream fis = new FileInputStream(resourcesdir + "data.properties");
		prop.load(fis);
		return prop;
	}

	public String picdir = (String) (System.getProperty("user.dir") + "\\src\\test\\java\\img\\");
	
	public void copyToClipboard(String text) {
		StringSelection stringSelection = new StringSelection(text);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(stringSelection, null);
	}
	
	public void waitForUpload(By element) {
		int i=0;
		while (driver.findElements(element).size() == 0) {
			i++;
			if(i==2) {
				Assert.assertTrue(false);
			}			
		}
	}	//Waits for the upload script to finish. If it takes more than 2 global waits cycles, fails the test.
	
	
	
	public void contactInfo(String contactInfo0, String contactInfo1, String contactDelete, By confirmDelete) {
		//contactInfo0 & 1 are the same locator split in two, leaving the numeric identifier part out for the method to loop on them.
		//contactDelete should be the second part of the locator, after the numeric identifier.
		Actions a = new Actions(driver);
		for(int i=6; i>=0; i--) {
			String data = prop.getProperty("contact"+i);
			if(data.equalsIgnoreCase("NO")) {
				a.moveToElement(driver.findElement(By.xpath(contactInfo0+i+"']"))).pause(500).build().perform();
				a.moveToElement(driver.findElement(By.xpath(contactInfo0+i+"']"))).click().build().perform();
				driver.findElement(By.xpath(contactInfo0+i+contactDelete)).click();
				driver.findElement(confirmDelete).click();
			}else {
				a.moveToElement(driver.findElement(By.xpath(contactInfo0+i+"']"))).pause(500).build().perform();
				driver.findElement(By.xpath(contactInfo0+i+contactInfo1)).clear();
				driver.findElement(By.xpath(contactInfo0+i+contactInfo1)).sendKeys(data);
			}
		}
	}
	
	public void skillsEdit(String skills) {
		Actions a = new Actions(driver);
		for(int id=0; id<6; id++) {
			String name= prop.getProperty("skillName"+id);
			String num = prop.getProperty("skillPoints"+id);
			//Skill dots ids are cero based and inverted. id 0 means 5 dots. id 4 means 1 dot.
			String dot = Integer.toString(-(Integer.parseInt(num)-5));
			By skill = By.xpath(skills+"//*[@item-id='"+id+"']//*[@placeholder='Skill']");
			By point = By.xpath(skills+"//*[@item-id='"+id+"']//*[@point='"+dot+"']");
			a.moveToElement(driver.findElement(skill)).click().sendKeys(name).build().perform();
			if(Integer.parseInt(dot)!=2) {
				a.moveToElement(driver.findElement(point)).click().build().perform();
			}			
		}
	}	//Excludes dot2 because if you click on an already active dot 2, 3 or 4, you disable it. Fot dots 0 and 1 there is no such behaviour.
	
	public void click(By element) throws Exception {
		try {
		WebDriverWait wait = new WebDriverWait(driver, 2);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		driver.findElement(element).click();
		} catch (Exception e) {
			throw new Exception("Failed to click on element: " + element);
		}
	}

	public void hover(By element) throws Exception {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 2);
			wait.until(ExpectedConditions.presenceOfElementLocated(element));
			Actions action = new Actions(driver);
			action.moveToElement(driver.findElement(element)).pause(500).build().perform();
		} catch (Exception e) {
			throw new Exception("Failed to position mouse over element: " + element);
		}
	}
	
	public void sendKeys(By element, String text) throws Exception {
		try {
			driver.findElement(element).sendKeys(text);
		}catch (Exception e) {
			throw new Exception("Failed to write text to element: " + element);
		}
	}
	
	public void checkTitle(String expected) {
		String current = driver.getTitle();
		Assert.assertEquals(expected, current, expected);
	}
	
	public void elementDisplayed(By element) {
		Assert.assertTrue(driver.findElement(element).isDisplayed());
	}
	
	public void cropScrShot(By element) throws IOException {
		WebElement target = driver.findElement(element);
		//Take screenshot
		File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		BufferedImage  fullImg = ImageIO.read(screenshot);
		//Get location and object size
		Point point = target.getLocation();
		int eleWidth = target.getSize().getWidth();
		int eleHeight = target.getSize().getHeight();
		//Crop image
		BufferedImage eleScreenshot= fullImg.getSubimage(point.getX(), point.getY(), eleWidth, eleHeight);
		ImageIO.write(eleScreenshot, "png", screenshot);
		//Paste cropped image
		File screenshotLocation = new File(System.getProperty("user.dir") + "\\src\\test\\java\\img\\CVscreenshot.png");
		FileUtils.copyFile(screenshot, screenshotLocation);
	}

}
