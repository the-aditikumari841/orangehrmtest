package orangehrmtestlogin;






import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class EmptyPasswordField {
    private WebDriver driver;
    private String baseUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
    
    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "path_to_chrome_driver");
        driver = new ChromeDriver();
        driver.get(baseUrl);
    }
    
    @Parameters({"username", "password"})
    @Test
    public void testLogin(String username, String password) {
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("loginBtn"));
        
        // Input username
        usernameField.sendKeys(username);
        
        // Input password
        passwordField.sendKeys(password);
        
        // Click login button
        loginButton.click();
        
        // Wait for error message
        WebElement errorMessage = driver.findElement(By.id("Required"));
        
        // Assert that error message is displayed if password is empty
        if (password.isEmpty()) {
            Assert.assertTrue(errorMessage.isDisplayed(), "Error message should be displayed for empty password");
        } else {
            // Assert that error message is not displayed if password is not empty
            Assert.assertFalse(errorMessage.isDisplayed(), "Error message should not be displayed for non-empty password");
        }
    }
    
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
