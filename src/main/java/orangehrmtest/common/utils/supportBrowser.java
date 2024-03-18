
package orangehrmtest.common.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import orangehrmtest.common.pages.JobTitlePage;
import orangehrmtest.common.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class supportBrowser {

    private static WebDriver driver;
    private static LoginPage loginPage;
    private static String loginPageUrl;
    
    private static JobTitlePage jobtitle;
    private static String jobTitleUrl;
    
    @BeforeClass
    public static void setUp() {
        try {
            Properties properties = new Properties();
            FileInputStream file = new FileInputStream("src/main/resources/config.properties");
            properties.load(file);
            String browser = properties.getProperty("browser");
            loginPageUrl = properties.getProperty("loginPageUrl");
            jobTitleUrl = properties.getProperty("jobTitleUrl"); 
            driver = getDriver(browser);
            driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
     
            loginPage = new LoginPage(driver , loginPageUrl); 
            jobtitle = new JobTitlePage(driver, jobTitleUrl);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
	private static WebDriver getDriver(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			return new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			return new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			return new EdgeDriver();
		} else if (browser.equalsIgnoreCase("safari")) {
			WebDriverManager.safaridriver().setup();
			return new SafariDriver();
		} else {
			WebDriverManager.chromedriver().setup();
			return new ChromeDriver();
		}
	}
    
    
	public static WebDriver getDriver() {
		return driver;
	}
	
	public LoginPage getLoginPage() {
		return loginPage;
	}
	
	public JobTitlePage getJobTitlePage() {
		return jobtitle;
	}
    
	@AfterClass
	public static void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}


}



