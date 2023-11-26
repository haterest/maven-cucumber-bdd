package nopCommerce.stepDefinitions;

import commons.BasePage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumberOptions.Hooks;
import org.openqa.selenium.WebDriver;
import pageUIs.nopcommerce.user.BasePageUI;
import utilities.DataHelper;

public class CommonPageSteps extends BasePage {
    WebDriver driver;
    DataHelper dataHelper;
    TestContext testContext;

    public CommonPageSteps(TestContext testContext) {
        this.driver = Hooks.openAndQuitBrowser();
        this.testContext = testContext;
        dataHelper = DataHelper.getData();
        testContext.getDataContext().setContext(Context.EMAIL, dataHelper.getEmail());
    }

    @Given("^Click to \"([^\"]*)\" menu link$")
    public void clickToMenuLink(String nameMenuLink) {
        waitForElementClickable(driver, BasePageUI.DYNAMIC_MENU_LINK_BY_NAME, nameMenuLink);
        clickToElement(driver, BasePageUI.DYNAMIC_MENU_LINK_BY_NAME, nameMenuLink);
    }

    @When("^Click to \"([^\"]*)\" radio button$")
    public void clickToRadioButton(String valueRadioButton) {
        waitForElementClickable(driver, BasePageUI.DYNAMIC_RADIO_BUTTON_BY_LABEL_NAME, valueRadioButton);
        checkToDefautCheckboxOrRadio(driver, BasePageUI.DYNAMIC_RADIO_BUTTON_BY_LABEL_NAME, valueRadioButton);
    }

    @When("^Input to \"([^\"]*)\" textbox with value \"([^\"]*)\"$")
    public void inputToTextboxWithValue(String textboxValue, String keyToSend) {
        if (textboxValue.equals("Email")) {
            keyToSend = testContext.getDataContext().getContext(Context.EMAIL).toString();
        }
        waitForElementVisible(driver, BasePageUI.DYNAMIC_TEXTBOX_BY_ID, textboxValue);
        sendKeyToElement(driver, BasePageUI.DYNAMIC_TEXTBOX_BY_ID, keyToSend, textboxValue);
    }

    @When("^Select \"([^\"]*)\" dropdown menu with value \"([^\"]*)\"$")
    public void selectDropdownMenuWithValue(String menuValue, String textSelect) {
        waitForElementClickable(driver, BasePageUI.DYNAMIC_DROPDOWN_BY_NAME_VALUE, menuValue);
        selectItemInDefaultDropDown(driver, BasePageUI.DYNAMIC_DROPDOWN_BY_NAME_VALUE, textSelect, menuValue);
    }

    @When("^Click to \"([^\"]*)\" button$")
    public void clickToButton(String textButton) {
        waitForElementClickable(driver, BasePageUI.DYNAMIC_BUTTON_BY_TEXT, textButton);
        clickToElement(driver, BasePageUI.DYNAMIC_BUTTON_BY_TEXT, textButton);
    }
}
