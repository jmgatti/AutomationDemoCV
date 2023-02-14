package pom;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CVbuilderPage extends BasePage{
	
	//Locators
	String pagetitle = "CV-Template | Template Builder";
	By NoCookiesBTN = By.id("cookie-decline");
	By StandardBTN = By.xpath("//*[@id='overlay']//div[@class='default cvtype']");
	By SkipTutorial = By.id("notutorial");
	By FirstName = By.xpath("//div[@setting='firstName']");
	By LastName = By.xpath("//div[@setting='lastName']");
	By JobTitle = By.xpath("//div[@setting='jobTitle']");
	By AboutMe = By.xpath("//*[@id='5']/section/div[2]/div");
	By WorkTitle = By.xpath("//div[@setting='functionTitle']");
	By WorkCompany = By.xpath("//div[@setting='nameCompany']");
	By WorkDate1 = By.xpath("//section[@id='1']//div[@setting='yearFrom']");
	By WorkDate2 = By.xpath("//section[@id='1']//div[@setting='yearTill']");
	By WorkDescription = By.xpath("//section[@id='1']//div[@setting='workDescription']");
	By StudyTitle = By.xpath("//div[@setting='educationName']");
	By StudyInstitute = By.xpath("//div[@setting='nameInstitution']");
	By StudyCity = By.xpath("//div[@setting='cityInstitution']");
	By StudyDate1 = By.xpath("//section[@id='2']//div[@setting='yearFrom']");
	By StudyDate2 = By.xpath("//section[@id='2']//div[@setting='yearTill']");
	By StudyDesc = By.xpath("//section[@id='2']//div[@setting='educationDescription']");
	By UploadPhoto = By.id("clickHere");
	By UploadHistory = By.xpath("//div[@class='imagehistory']/img");
	By SkillsTitle0 = By.xpath("//*[@id='3']//*[@section-id='0']//*[@setting='sectionTitle']");
	By SkillsTitle1 = By.xpath("//*[@id='3']//*[@section-id='1']//*[@setting='sectionTitle']");
	String Skills = "//*[@id='3']";
	String ContactInfo0 = "//section[@id='6']//*[@item-id='";
	String ContactInfo1 = "']//div[@placeholder='Click on the icon to change']";
	String ContactDelete = "']//*[@class='delete delete-item']";
	By ConfirmDelete = By.xpath("//*[@id='confirmButtons']//*[@class='button blue']");
	By CloseTemplateInfo = By.xpath("//*[@id='layout-quick-select']//div[@class='close']");
	By Page = By.xpath("//div[@class='page']");

	
	//Page Constructor
	public CVbuilderPage(WebDriver driver) {
		super (driver);
	}	
	
	
	//Methods	
	public void fullSkillsInfo() {
		this.skillsEdit(Skills);
	}	
	
	public void fullContactInfo() {
		this.contactInfo(ContactInfo0, ContactInfo1, ContactDelete, ConfirmDelete);
	}

	public void name() throws Exception {
		String first = prop.getProperty("name");
		String last = prop.getProperty("lastName");
		this.sendKeys(FirstName, first);
		this.sendKeys(LastName, last);
	}

	public void work() throws Exception {
		String job = prop.getProperty("job");
		String title = prop.getProperty("workTitle");
		String company = prop.getProperty("workCompany");
		String date1 = prop.getProperty("workDate1");
		String date2 = prop.getProperty("workDate2");
		String desc = prop.getProperty("workDesc");
		this.sendKeys(JobTitle, job);
		this.sendKeys(WorkTitle, title);
		this.sendKeys(WorkCompany, company);
		this.sendKeys(WorkDate1, date1);
		this.sendKeys(WorkDate2, date2);
		this.sendKeys(WorkDescription, desc);
	}

	public void studies() throws Exception {
		String title = prop.getProperty("studyTitle");
		String institute = prop.getProperty("studyInstitute");
		String city = prop.getProperty("studyCity");
		String date1 = prop.getProperty("studyDate1");
		String date2 = prop.getProperty("studyDate2");
		String desc = prop.getProperty("studyDesc");
		this.sendKeys(StudyTitle, title);
		this.sendKeys(StudyInstitute, institute);
		this.sendKeys(StudyCity, city);
		this.sendKeys(StudyDate1, date1);
		this.sendKeys(StudyDate2, date2);
		this.sendKeys(StudyDesc, desc);
	}

	public void skillsTitles() throws Exception {
		String title0 = prop.getProperty("skillsTitle0");
		String title1 = prop.getProperty("skillsTitle1");
		this.sendKeys(SkillsTitle0, title0);
		this.sendKeys(SkillsTitle1, title1);
	}
	
	public void closeTemplateInfo() throws Exception {
		this.click(CloseTemplateInfo);
	}
	
	public void noCookiesBTN() throws Exception {
		this.click(NoCookiesBTN);
	}	
	
	public void standardBTN() throws Exception {
		this.click(StandardBTN);
	}
	
	public void skipTutorial() throws Exception {
		this.click(SkipTutorial);
	}
	
	public void uploadPhoto() throws Exception {
		this.click(UploadPhoto);
		copyToClipboard(picdir);
		Runtime.getRuntime().exec(resourcesdir+"ImageUploadScript.exe");
		waitForUpload(UploadHistory);
	}
	
	public void aboutMe() throws Exception {		
		String data = prop.getProperty("aboutMe");
		this.sendKeys(AboutMe, data);
	}
	
	public void checkCVbuilderPage() {
		this.checkTitle(pagetitle);
	}
	
	public void cvScreenShot() throws IOException {
		this.cropScrShot(Page);
	}
	
	public void openScreenshot() throws IOException {
		File pic = new File(picdir+"CVscreenshot.png");
		Desktop opener = Desktop.getDesktop();
		opener.open(pic);
	}
}
