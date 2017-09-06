
import org.junit.BeforeClass;
import org.junit.runner.RunWith;




import com.photon.lh.StepDefinition.CommonStep;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;



	@RunWith(Cucumber.class)
	@CucumberOptions(features = { "src/test/java/com/photon/lh/Feature" },
			 monochrome = true,plugin = {"html:target/cucumber-html-report", 
					 "json:target/cucumber-json-report.json",
					 "com.cucumber.listener.ExtentCucumberFormatter:output/report.html"},
	                glue = "com/photon/lh/StepDefinition",
	               // tags = {"@LHCP_Regression"}
	 			tags = {"@LHCP_Regression"}
	                ) 


public class CucumberJunitRunnerTest {
		
		@BeforeClass
		public static void Report(){
				CommonStep.reportCucumberTest();
		}
}






