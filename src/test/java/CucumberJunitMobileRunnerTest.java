

import org.junit.BeforeClass;
import org.junit.runner.RunWith;










import com.photon.lh.MobileStepDefinition.CommonStep;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;



	@RunWith(Cucumber.class)
	@CucumberOptions(features = { "src/test/java/com/photon/lh/MobileFeature" },
			 monochrome = true,plugin = {"html:target/cucumber-html-report", 
					 "json:target/cucumber-json-report.json",
					 "com.cucumber.listener.ExtentCucumberFormatter:output/report.html"},
	                glue = "com/photon/lh/MobileStepDefinition",
	               // tags = {"@LHCP_Regression"}
	 			tags = {"@SplashScreen,@FeelingsScreen"}
	                ) 

public class CucumberJunitMobileRunnerTest {
		@BeforeClass
		public static void Report(){
				CommonStep.reportCucumberTest();
		}
}
