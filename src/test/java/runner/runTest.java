package runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "stepDef",
        tags = "@PositiveRegister or @NegativeRegister",
        plugin = {"pretty", "html:target/ReportSelenium.html"}
)
public class runTest {

}
