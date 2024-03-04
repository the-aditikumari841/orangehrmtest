package orangehrmtestlogin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ValidUsernameAndInvalidPasswordLoginTest {
    private WebDriver driver;
    private String baseUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
    
    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "path_to_chrome_driver");
        driver = new ChromeDriver();
        driver.get(baseUrl);
    }
    
    @Test
    public void testInvalidPassword() {
        String validUsername = "validusername";
        String invalidPassword = "invalidpassword";
        
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("loginBtn"));
        
        // Input valid username
        usernameField.sendKeys(validUsername);
        
        // Input invalid password
        passwordField.sendKeys(invalidPassword);
        
        // Click login button
        loginButton.click();
        
        // Wait for error message
        WebElement errorMessage = driver.findElement(By.id("Invalid credentials"));
        
        // Assert that error message is displayed
        Assert.assertTrue(errorMessage.isDisplayed(), "Error message should be displayed for invalid password");
    }
    
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
