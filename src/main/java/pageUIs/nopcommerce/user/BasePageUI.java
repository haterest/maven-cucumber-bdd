package pageUIs.nopcommerce.user;

public class BasePageUI {
    public static final String DYNAMIC_PAGE_AT_MY_ACCOUNT_AREA = "xpath=//div[@class='listbox']//a[text()='%s']";
    public static final String LOGOUT_LINK_AT_ADMIN = "xpath=//a[text()='Logout']";
    public static final String LOADING_ICON_ON_HEADER_ADMIN = "css=#ajaxBusy>span";
    public static final String DYNAMIC_TEXTBOX_BY_ID = "xpath=//input[@id='%s']";
    public static final String DYNAMIC_BUTTON_BY_TEXT = "xpath=//button[text()='%s']";
    public static final String DYNAMIC_DROPDOWN_BY_NAME_VALUE = "xpath=//select[@name='%s']";
    public static final String DYNAMIC_RADIO_BUTTON_BY_LABEL_NAME = "xpath=//label[text()='%s']/preceding-sibling::input";
    public static final String DYNAMIC_CHECKBOX_BY_LABEL_NAME = "xpath=//label[text()='%s']/following-sibling::input";
    public static final String DYNAMIC_MENU_LINK_BY_NAME = "xpath=//div[@class='header-links']//a[text()='%s']";
}
