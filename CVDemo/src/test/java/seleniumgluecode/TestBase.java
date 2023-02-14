package seleniumgluecode;

import org.openqa.selenium.WebDriver;

import pom.CVbuilderPage;
import pom.LandingPage;
import pom.TemplateSelectionPage;

public class TestBase {
	
	protected WebDriver driver = Hooks.getDriver();
	protected LandingPage landingPage = new LandingPage(driver);
	protected TemplateSelectionPage templateSelectionPage = new TemplateSelectionPage(driver);
	protected CVbuilderPage cvBuilderPage = new CVbuilderPage(driver);

}
