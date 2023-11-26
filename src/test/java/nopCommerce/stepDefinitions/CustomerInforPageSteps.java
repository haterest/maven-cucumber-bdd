package nopCommerce.stepDefinitions;

import commons.BasePage;
import cucumber.api.java.en.Then;
import cucumberOptions.Hooks;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageUIs.nopcommerce.user.BasePageUI;

public class CustomerInforPageSteps extends BasePage {
    WebDriver driver;
    TestContext testContext;

    public CustomerInforPageSteps(TestContext testContext) {
        this.driver = Hooks.openAndQuitBrowser();
        this.testContext = testContext;
    }

    @Then("^Display the valid value at radio button with \"([^\"]*)\"$")
    public void displayTheValidValueAtRadioButtonWith(String valueName) {
        waitForElementVisible(driver, BasePageUI.DYNAMIC_RADIO_BUTTON_BY_LABEL_NAME, valueName);
        Assert.assertTrue(isElementSelected(driver, BasePageUI.DYNAMIC_RADIO_BUTTON_BY_LABEL_NAME, valueName));
    }

    @Then("^Display the valid value at \"([^\"]*)\" textbox with \"([^\"]*)\"$")
    public void displayTheValidValueAtTextboxWith(String idTextbox, String textValue) {
        if (idTextbox.equals("Email")) {
            textValue = testContext.getDataContext().getContext(Context.EMAIL).toString();
        }
        waitForElementVisible(driver, BasePageUI.DYNAMIC_TEXTBOX_BY_ID, idTextbox);
        Assert.assertEquals(textValue, getElementAttribute(driver, BasePageUI.DYNAMIC_TEXTBOX_BY_ID, "value", idTextbox));
    }

    @Then("^Display the valid value at \"([^\"]*)\" menu with \"([^\"]*)\"$")
    public void displayTheValidValueAtMenuWith(String menuName, String textSelected) {
        waitForElementVisible(driver, BasePageUI.DYNAMIC_DROPDOWN_BY_NAME_VALUE, menuName);
        Assert.assertEquals(textSelected, getFirstSelectedItemDefaultDropDown(driver, BasePageUI.DYNAMIC_DROPDOWN_BY_NAME_VALUE, menuName));
    }
}
