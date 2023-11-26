package bankGuru.stepDefinitions;

import commons.BasePage;
import cucumber.api.java.en.Then;
import cucumberOptions.Hooks;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageUIs.bankguru.HomePageUI;

public class HomePageSteps extends BasePage {
    private WebDriver driver;

    public HomePageSteps() {
        this.driver = Hooks.openAndQuitBrowser();
    }

    @Then("^Homepage displayed$")
    public void homepageDisplayed() {
        waitForElementVisible(driver, HomePageUI.WELCOME_MESSAGE);
        Assert.assertFalse(isElementDisplayed(driver, HomePageUI.WELCOME_MESSAGE));
    }

}
