package commons;

import java.io.File;

public class GlobalConstant {
    public static final String ADMIN_PAGE_URL = "https://admin-demo.nopcommerce.com/";
    public static final String BANKGURU_PAGE_URL = "https://demo.guru99.com/V1/index.php";
    public static final String USER_PAGE_URL = "https://demo.nopcommerce.com/";
    public static final String STAGING_PAGE_URL = "https://staging.nopcommerce.com/";
    public static final String PRODUCTION_PAGE_URL = "https://production.nopcommerce.com/";
    public static final String PROJECT_PATH = System.getProperty("user.dir");
    public static final String JAVA_VERSION = System.getProperty("java.version");
    public static final String OS_NAME = System.getProperty("os.name");
    public static final String EXTENT_PATH = PROJECT_PATH + File.separator + "extentV2" + File.separator;
    public static final String UPLOAD_FILE = PROJECT_PATH + File.separator + "uploadFiles" + File.separator;
    public static final String DOWNLOAD_FILE = PROJECT_PATH + File.separator + "downloadFiles";
    public static final String BROWSER_EXTENSIONS = PROJECT_PATH + File.separator + "browserExtensions";
    public static final String BROWSER_LOG = PROJECT_PATH + File.separator + "browserLogs";
    public static final String AUTO_IT_SCRIPT = PROJECT_PATH + File.separator + "autoIT";
    public static final String REPORTNG_SCREENSHOT = PROJECT_PATH + File.separator + "ReportNGImage" + File.separator;
    public static final long SHORT_TIMEOUT = 5;
    public static final long LONG_TIMEOUT = 30;

}
