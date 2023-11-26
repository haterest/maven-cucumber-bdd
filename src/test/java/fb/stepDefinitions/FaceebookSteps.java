package fb.stepDefinitions;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Map;
import java.util.concurrent.TimeUnit;

public class FaceebookSteps {
    WebDriver driver;

    @Before
    public void openFacebookApplication() throws Throwable {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Given("^Click to Login menu$")
    public void clickToLoginMenu() {
        driver.findElement(By.className("ico-login")).click();
    }

    @Given("^Input to Username and Password$")
    public void inputToUsernameAndPassword(DataTable customeTable) {
        for (Map<String, String> customer : customeTable.asMaps(String.class, String.class)) {
            driver.findElement(By.cssSelector("input.email")).clear();
            driver.findElement(By.cssSelector("input.email")).sendKeys(customer.get("Username"));
            driver.findElement(By.cssSelector("input.password")).clear();
            driver.findElement(By.cssSelector("input.password")).sendKeys(customer.get("Password"));
        }
    }


    @Then("^Click To Login button$")
    public void clickToLoginButton() {
        driver.findElement(By.xpath("//button[text()='Log in']")).click();
    }


    @After
    public void closeApplication() {
        driver.quit();
    }
}
