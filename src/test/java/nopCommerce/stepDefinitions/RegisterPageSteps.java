package nopCommerce.stepDefinitions;

import commons.BasePage;
import cucumber.api.java.en.Then;
import cucumberOptions.Hooks;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageUIs.nopcommerce.user.UserRegisterPageUI;

public class RegisterPageSteps extends BasePage {
    WebDriver driver;

    public RegisterPageSteps() {
        this.driver = Hooks.openAndQuitBrowser();
    }

    @Then("^Register Successful message displayed$")
    public void registerSuccessfulMessageDisplayed() {
        waitForElementVisible(driver, UserRegisterPageUI.REGISTER_SUCCESS_MESSAGE);
        Assert.assertTrue(isElementDisplayed(driver, UserRegisterPageUI.REGISTER_SUCCESS_MESSAGE));
    }
}
