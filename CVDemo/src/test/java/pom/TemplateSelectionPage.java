package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TemplateSelectionPage extends BasePage{
	
	//Locators
	String pagetitle = "Choose Your CV Template - Free Online CV Builder";
	By TemplateIMG = By.xpath("//div[@template='14']//img[@alt='CV template']");
	By SelectBTN = By.xpath("//div[@template='14']//div[@class='button']");
	
	//Page Constructor
	public TemplateSelectionPage(WebDriver driver) {
		super (driver);
	}
	
	//Methods
	public void hoverOnTemplateImg() throws Exception {
		this.hover(TemplateIMG);
	}
	
	public void clickOnSelectBTN() throws Exception {
		this.click(SelectBTN);
	}
	
	public void checkTemplateSelectionPage() {
		this.checkTitle(pagetitle);
	}
}
