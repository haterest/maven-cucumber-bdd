package cucumberOptions;

import commons.GlobalConstant;
import cucumber.api.java.Before;
import org.apache.log4j.Logger;
import java.nio.file.Path;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.UnreachableBrowserException;

import java.io.File;
import java.nio.file.Paths;
import java.time.Duration;

public class Hooks {
    // Run for many thread
    private static WebDriver driver;
    private static final Logger log = Logger.getLogger(Hooks.class.getName());

    @Before // synchronized = handle đồng bộ
    public synchronized static WebDriver openAndQuitBrowser() {
        // Run by Maven command line
        String browser = System.getProperty("BROWSER");
        System.out.println("Browser name run by command line = " + browser);

        // Check driver đã được khởi tạo hay chưa?
        if (driver == null) {

            // Happy path case
            try {
                // Kiem tra BROWSER = null -> gan = chrome/ firefox (browser default for project)
                if (browser == null) {
                    // Get browser name from Environment Variable in OS
                    browser = System.getenv("BROWSER");
                    if (browser == null) {
                        // Set default browser
                        browser = "firefox";
                    }
                }
                switch (browser) {
                    case "chrome":
                        Path path = Paths.get(GlobalConstant.BROWSER_EXTENSIONS + "\\adblock_chrome.crx");
                        File extensionFilePath = new File(path.toUri());
                        ChromeOptions options = new ChromeOptions();
                        options.addExtensions(extensionFilePath);
                        driver = new ChromeDriver();
                        break;
                    case "hchrome":
                        ChromeOptions chromeOptions = new ChromeOptions();
                        chromeOptions.addArguments("--headless=new");
                        chromeOptions.addArguments("window-size=1920x1080");
                        driver = new ChromeDriver(chromeOptions);
                        break;
                    case "firefox":
//                        FirefoxProfile profile = new FirefoxProfile();
//                        File files = new File(GlobalConstant.BROWSER_EXTENSIONS + "\\adblock_firefox.xpi");
//                        profile.addExtension(files);
//                        FirefoxOptions ffOptions = new FirefoxOptions();
//                        ffOptions.setProfile(profile);
                        driver = new FirefoxDriver();
                        break;
                    case "hfirefox":
                        FirefoxOptions firefoxOptions = new FirefoxOptions();
                        firefoxOptions.addArguments("--headless=new");
                        driver = new FirefoxDriver(firefoxOptions);
                        break;
                    case "ie":
                        driver = new InternetExplorerDriver();
                        break;
                    default:
                        driver = new ChromeDriver();
                        break;
                }
                // Browser crash/ stop
            } catch (UnreachableBrowserException e) {
                driver = new ChromeDriver();
                // Driver crash
            } catch (WebDriverException e) {
                driver = new ChromeDriver();
            }
            // Code này luôn luôn được chạy dù pass hay fail
            finally {
                Runtime.getRuntime().addShutdownHook(new Thread(new BrowserCleanup()));
            }

            // driver.get(GlobalConstant.USER_PAGE_URL); -> nopCommerce
            driver.get(GlobalConstant.BANKGURU_PAGE_URL);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
            log.info("------------- Started the browser -------------");
        }
        return driver;
    }

    public static void close() {
        try {
            if (driver != null) {
                openAndQuitBrowser().quit();
                log.info("------------- Closed the browser -------------");
            }
        } catch (UnreachableBrowserException e) {
            System.out.println("Can not close the browser");
        }
    }

    private static class BrowserCleanup implements Runnable {
        @Override
        public void run() {
            close();
        }
    }

}