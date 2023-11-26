package cucumberOptions;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/nopCommerce/features",
        glue = "nopCommerce.stepDefinitions",
        monochrome = true,
        dryRun = false,
        plugin = {"pretty", "html:target/site/cucumber-report-default", "json:target/site/cucumber_nopcommerce.json"},
        snippets = SnippetType.CAMELCASE,
        tags = {"@register_login_new_customer"}
)
public class NopCommerceTestRunner {
}
