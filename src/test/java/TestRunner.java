import io.cucumber.testng.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@CucumberOptions(
        features = {"src/test/resource"},
        glue = {"StepDefinitions"},
        plugin = {"pretty",
                "json:target/cucumber-reports/CucumberTestReport.json"
        }
)

public class TestRunner{
        public TestNGCucumberRunner testNGCucumberRunner;

        @BeforeClass(alwaysRun = true)
        public void setUpClass() {
                testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
        }

        @Test(
                groups = {"cucumber"},
                description = "Runs Cucumber Scenarios",
                dataProvider = "scenarios"
        )
        public void runScenario(PickleWrapper pickleWrapper, FeatureWrapper featureWrapper) {
                this.testNGCucumberRunner.runScenario(pickleWrapper.getPickle());
        }

        @DataProvider
        public Object[][] scenarios() {
                return this.testNGCucumberRunner.provideScenarios();
        }

        @AfterClass(
                alwaysRun = true
        )
        public void tearDownClass() {
                testNGCucumberRunner.finish();
        }
}