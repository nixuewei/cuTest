package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import cucumber.runtime.model.CucumberTagStatement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.List;

@CucumberOptions(   features = {"src/test/java/features/"},
                    glue = {"steps"},
                    format = {"json:target/cucumber-report.json", "html:target/cucumber-reports"}
                    //tags = "@noBefore"  // @FunctionalTest, ~@P2  或者  @SanityTest, @P1
                    )

public class TestRunner extends AbstractTestNGCucumberTests {

    private TestNGCucumberRunner testNGCucumberRunner;

    @BeforeClass(alwaysRun = true)
    public void setUpClasss() {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @Test(dataProvider = "features")
    public void runTests(CucumberFeatureWrapper cucumberFeatureWrapper){
        List<CucumberTagStatement> elements = cucumberFeatureWrapper.getCucumberFeature().getFeatureElements();

        for (Iterator<CucumberTagStatement> element = elements.iterator(); element.hasNext();) {
            //TODo: Get from excel which scenarios need to be executed specifically
            //Customizing which scenarios to be executed

            CucumberTagStatement scenarioName = element.next();
            if(!scenarioName.getVisualName().equals("1Scenario: User make an appointment")){
                element.remove();
            }
        }
        testNGCucumberRunner.runCucumber(cucumberFeatureWrapper.getCucumberFeature());
    }

    @Test(dataProvider = "features")
    public void runAllTests(CucumberFeatureWrapper cucumberFeatureWrapper){
        testNGCucumberRunner.runCucumber(cucumberFeatureWrapper.getCucumberFeature());
    }

    @DataProvider
    public Object[][] features(){
        return testNGCucumberRunner.provideFeatures();
    }

    @AfterClass(alwaysRun = true)
    public void afterClass(){
        testNGCucumberRunner.finish();
    }

}
