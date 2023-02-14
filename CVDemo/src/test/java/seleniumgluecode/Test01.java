package seleniumgluecode;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Test01 extends TestBase {
	@Given("^The user is in the main page$")
	public void the_user_is_in_the_main_page() throws Throwable {
	    landingPage.checkLandingPage();
	}

	@When("^Clics the Free CV Builder button$")
	public void clics_the_Free_CV_Builder_button() throws Throwable {
	    landingPage.clickOnFreeCVbuilderBTN();
	}

	@When("^Selects a free template$")
	public void selects_a_free_template() throws Throwable {
		templateSelectionPage.hoverOnTemplateImg();
		templateSelectionPage.clickOnSelectBTN();
	}

	@When("^Chooses a Standard CV skipping the tutorial$")
	public void chooses_a_Standard_CV_skipping_the_tutorial() throws Throwable {
		cvBuilderPage.noCookiesBTN();
		cvBuilderPage.standardBTN();
		cvBuilderPage.skipTutorial();
	}

	@When("^Completes all the data$")
	public void completes_all_the_data() throws Throwable {
		cvBuilderPage.prepareData();
		cvBuilderPage.uploadPhoto();
		cvBuilderPage.aboutMe();
		cvBuilderPage.fullContactInfo();
		cvBuilderPage.name();		
		cvBuilderPage.skillsTitles();
		cvBuilderPage.fullSkillsInfo();
		cvBuilderPage.work();
		cvBuilderPage.studies();
		cvBuilderPage.closeTemplateInfo();
	}

	@When("^Takes a cropped screenshot of the CV$")
	public void takes_a_cropped_screenshot_of_the_CV() throws Throwable {
		cvBuilderPage.cvScreenShot();		
	}

	@Then("^Opens the screenshot$")
	public void opens_the_screenshot() throws Throwable {
		cvBuilderPage.openScreenshot();
	}
}
