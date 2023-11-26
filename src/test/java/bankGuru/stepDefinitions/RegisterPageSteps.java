package bankGuru.stepDefinitions;

import commons.BasePage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumberOptions.Hooks;
import org.openqa.selenium.WebDriver;
import pageUIs.bankguru.RegisterPageUI;
import utilities.DataHelper;

public class RegisterPageSteps extends BasePage {
    private WebDriver driver;
    static String username, password;
    DataHelper datatest;

    public RegisterPageSteps() {
        this.driver = Hooks.openAndQuitBrowser();
        datatest = DataHelper.getData();
    }

    @When("^Input to Email textbox$")
    public void inputToEmailTextbox() {
        waitForElementVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
        sendKeyToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, datatest.getEmail());
    }

    @When("^Click to Submit button$")
    public void clickToSubmitButton() {
        waitForElementClickable(driver, RegisterPageUI.SUBMIT_BUTTON);
        clickToElement(driver, RegisterPageUI.SUBMIT_BUTTON);
    }

    @Then("^Get UserID and Password information$")
    public void getUserIDAndPasswordInformation() {
        waitForElementVisible(driver, RegisterPageUI.USER_ID_LABEL);
        waitForElementVisible(driver, RegisterPageUI.PASSWORD_LABEL);
        username = getElementText(driver, RegisterPageUI.USER_ID_LABEL);
        password = getElementText(driver, RegisterPageUI.PASSWORD_LABEL);
    }

    @When("^Back to Login page$")
    public void backToLoginPage() {
        openPageURL(driver, LoginPageSteps.loginPageUrl);
    }

}
