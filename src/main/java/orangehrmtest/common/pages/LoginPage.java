package orangehrmtest.common.pages;

import org.openqa.selenium.WebDriver;

import orangehrmtest.common.utils.supportBrowser;

public class LoginPage {
    public static void main(String[] args) {
        // Get Chrome driver
        WebDriver chromeDriver = supportBrowser.getDriver(supportBrowser.BrowserType.CHROME);
        chromeDriver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        // Get Firefox driver
        WebDriver firefoxDriver = supportBrowser.getDriver(supportBrowser.BrowserType.FIREFOX);
        firefoxDriver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        // Get IE driver
        WebDriver ieDriver = supportBrowser.getDriver(supportBrowser.BrowserType.IE);
        ieDriver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        // Close all drivers when done
        chromeDriver.quit();
        firefoxDriver.quit();
        ieDriver.quit();
    }
}
