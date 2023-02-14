package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage extends BasePage{
	
	//Locators
	String pagetitle = "CV-Template | Free Online CV Builder, Best CV Templates.";
	By FreeCVbuilderBTN = By.xpath("//a[@class='cta']");	
	
	//Page Constructor
	public LandingPage(WebDriver driver) {
		super (driver);
	}
	
	//Methods
	public void clickOnFreeCVbuilderBTN() throws Exception {
		this.click(FreeCVbuilderBTN);
	}
	
	public void checkLandingPage() {
		this.checkTitle(pagetitle);
	}

}
