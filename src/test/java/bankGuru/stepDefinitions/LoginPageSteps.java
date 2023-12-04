package bankGuru.stepDefinitions;

import commons.BasePage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumberOptions.Hooks;
import org.openqa.selenium.WebDriver;
import pageUIs.bankguru.LoginPageUI;

public class LoginPageSteps extends BasePage {
    private WebDriver driver;
    static String loginPageUrl;

    public LoginPageSteps() {
        this.driver = Hooks.openAndQuitBrowser();
    }

    @Given("^Get Login Page url")
    public void getLoginPageUrl() {
        loginPageUrl = getPageURL(driver);
    }

    @When("^Open Register page$")
    public void openRegisterPage() {
        waitForElementClickable(driver, LoginPageUI.REGISTER_LINK);
        clickToElement(driver, LoginPageUI.REGISTER_LINK);
//        switchToFrameiFrame(driver, LoginPageUI.IFRAME_SCREEN);
//        clickToElement(driver, LoginPageUI.IFRAME_CLOSE_BUTTON);
//        switchToDefaultContent(driver);
    }

    @When("^Input valid UserID and Password to textbox$")
    public void inputValidUserIDAndPasswordToTextbox() {
        waitForElementVisible(driver, LoginPageUI.USER_ID_TEXTBOX);
        waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
        sendKeyToElement(driver, LoginPageUI.USER_ID_TEXTBOX, RegisterPageSteps.username);
        sendKeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, RegisterPageSteps.password);
    }

    @When("^Click to Login button$")
    public void clickToLoginButton() {
        waitForElementVisible(driver, LoginPageUI.LOGIN_BUTTON);
        clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
    }

}
