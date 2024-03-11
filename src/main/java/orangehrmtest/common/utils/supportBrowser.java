package orangehrmtest.common.utils;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class supportBrowser {

	public static WebDriver getDriver(BrowserType browserType) {
        WebDriver driver = null;
        if (browserType == BrowserType.CHROME) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browserType == BrowserType.FIREFOX) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browserType == BrowserType.IE) {
            WebDriverManager.iedriver().setup();
            driver = new InternetExplorerDriver();
        } else {
            System.out.println("Unsupported browser type");
        }
        return driver; 
    }

    public enum BrowserType {
        CHROME,
        FIREFOX,
        IE
    }

    // Add a setup method
//    public static WebDriver setupBrowser() {
//        WebDriver driver = getDriver(BrowserType.CHROME); // Defaulting to Chrome here
//        // You can modify this line to use a different browser if needed
//        return driver;
//    }
        
    public static WebDriver setupBrowser(BrowserType browserType) {
    	WebDriver driver = getDriver(browserType);
    	return driver;
    }


}



