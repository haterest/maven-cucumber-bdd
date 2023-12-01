package nopCommerce.stepDefinitions;

import commons.BasePage;
import cucumber.api.java.en.Then;
import cucumberOptions.Hooks;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageUIs.nopcommerce.user.BasePageUI;

public class HomePageSteps extends BasePage {
    WebDriver driver;

    public HomePageSteps() {
        this.driver = Hooks.openAndQuitBrowser();
    }

    @Then("^Verify \"([^\"]*)\" link displayed$")
    public void verifyLinkDisplayed(String nameMenuLink) {
        waitForElementVisible(driver, BasePageUI.DYNAMIC_MENU_LINK_BY_NAME, nameMenuLink);
        Assert.assertTrue(isElementDisplayed(driver, BasePageUI.DYNAMIC_MENU_LINK_BY_NAME, nameMenuLink));
    }

    public void Just_Another_TestCase(){
        // to do
    }

}
