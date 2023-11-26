package cucumberOptions;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/bankGuru/features",
        glue = "bankGuru.stepDefinitions",
        monochrome = true,
//        dryRun = true,
        plugin = {"pretty", "html:target/site/cucumber-report-default", "json:target/site/cucumber.json"},
        snippets = SnippetType.CAMELCASE,
        tags = {"@resgister_login"}
)
public class BankGuruTestRunner {
}
