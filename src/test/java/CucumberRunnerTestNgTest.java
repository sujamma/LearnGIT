import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(glue = "com/photon/lh/StepDefinition", 
features = "src/test/java/com/photon/lh/Feature",
format = {
		"html:target/cucumber-htmlreport", "json:target/cucumber-report.json" },
		/*tags = { "@JPMC_HomeScreen_Scenario,@JPMC_HomeScreen_Search,"
				+ "@JPMC_Navigate_Creditcards,@JPMC_Navigate_Checking" },
				monochrome = true)*/

tags = { "@@LaunchStayHealthyApp" },
		monochrome = true)
public class CucumberRunnerTestNgTest extends AbstractTestNGCucumberTests { 

}
