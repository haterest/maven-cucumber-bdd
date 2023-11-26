package cucumberOptions;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        // Đường dẫn tới file features
        features = "src/test/java/fb/features",
        // Tìm đến step definitions
        glue = "fb.stepDefinitions",
        monochrome = true,
//        dryRun = true,
        plugin = {"pretty", "html:target/site/cucumber-report-default", "json:target/site/cucumber_FB.json"},
        snippets = SnippetType.CAMELCASE,
        tags = {"@displayed"}
)
public class FBTestRunner {
}
