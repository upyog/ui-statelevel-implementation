package stepDefinition;

import org.testng.annotations.BeforeClass;

import cucumber.api.CucumberOptions;
import cucumber.api.java.en.And;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import utilities.BaseTests;
import utilities.DriverUtil;

@CucumberOptions(features = { "src/test/java/features/PT" }, glue = { "stepDefinition/" }, monochrome = true, tags = {
		"@pt14" }, plugin = { "pretty", "html:target/cucumber-reports/cucumber-pretty",
				"json:target/cucumber-reports/CucumberTestReport.json", "rerun:target/cucumber-reports/rerun.txt" })

public class StatelevelMethods extends AbstractTestNGCucumberTests implements BaseTests {
	elementLocators locator = new elementLocators();

//	String path = System.getProperty("user.dir") + "/src/test/java/TestData";
	//String outputFile = System.getProperty("dataPath");
//	String credentailsfile = System.getProperty("credsPath");

	@BeforeClass
	public void eGovlauncher() {
		try {
			DriverUtil.getDefaultDriver();
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	@And("^Enter Punjab Property Details")
	public void punjabPropertyDetails() {
		try {
			String currentUrl = eGovOp.getUrl();
			if (currentUrl.contains("vasika-details")
					&& eGovOp.wait_for_element(locator.plotSize(), "check element") == true) {

				eGovOp.enterData(locator.plotSize(), "400", "Enter Plot Size");
				eGovOp.enterData(locator.builtUpArea(), "300", "Enter Build Up Area");
				eGovOp.scrollToElement(locator.nextbutton());
				eGovOp.clickElement(locator.nextbutton(), "Click on Next Option");
				eGovOp.enterData(locator.plotSize(), "400", "Enter Plot Size");
				eGovOp.clickElement(locator.nextbutton(), "Click on Next Option");
				eGovOp.enterData(locator.plotSize(), "400", "Enter Plot Size");
				eGovOp.clickElement(locator.nextbutton(), "Click on Next Option");

			}

		} catch (Exception e) {
			e.getStackTrace();
		}
	}

}
