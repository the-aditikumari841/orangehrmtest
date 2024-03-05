

package orangehrmtestlogin;

import orangehrmtest.common.utils.ConfigReader;
import orangehrmtest.common.utils.supportBrowser;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ValidUsernameAndInvalidPasswordLoginTest {
    
    private WebDriver driver;
    private String baseUrl;

    @BeforeClass
    public void setUp() {
        // Setup WebDriver using supportBrowser
        String browser = ConfigReader.getProperty("browser");
        driver = supportBrowser.getDriver(supportBrowser.BrowserType.valueOf(browser.toUpperCase()));

        baseUrl = ConfigReader.getProperty("loginPageUrl");
    }
    

    @Test(priority = 1)
    public void testValidUsernameInvalidPassword() {
        // Navigate to the login page
        driver.get(baseUrl);

        // Enter valid username
        WebElement usernameField = driver.findElement(By.name("username"));
        usernameField.sendKeys("validUsername");

        // Enter invalid password
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("invalidPassword");

        // Click on the login button
        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button"));
        loginButton.click();

        // Verify error message is displayed
        WebElement errorMessage = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/div/div[1]/div[1]/p"));
        Assert.assertTrue(errorMessage.getText().contains("Invalid credentials"), "Error message is not displayed for invalid login");
    }
    
    
    @AfterClass
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}



