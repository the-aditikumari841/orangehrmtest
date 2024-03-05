package orangehrmtestlogin;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class EmptyPasswordField {

    private WebDriver driver;
    private String baseUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

    @BeforeClass
    public void setUp() {
        // Setup WebDriver using WebDriver Manager
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    public void testEmptyPasswordWithCorrectUsername() {
        // Navigate to the login page
        driver.get(baseUrl);

        // Enter correct username
        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys("correctUsername");

        // Click on the login button
        WebElement loginButton = driver.findElement(By.id("loginButton"));
        loginButton.click();

        // Verify error message is displayed for empty password
        WebElement errorMessage = driver.findElement(By.id("Required"));
        Assert.assertTrue(errorMessage.isDisplayed(), "Error message is not displayed for empty password");
    }

    @Test(priority = 2)
    public void testEmptyPasswordWithIncorrectUsername() {
        // Navigate to the login page
        driver.get(baseUrl);

        // Enter incorrect username
        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys("incorrectUsername");

        // Click on the login button
        WebElement loginButton = driver.findElement(By.id("loginButton"));
        loginButton.click();

        // Verify error message is displayed for empty password
        WebElement errorMessage = driver.findElement(By.id("Required"));
        Assert.assertTrue(errorMessage.isDisplayed(), "Error message is not displayed for empty password");
    }

    // Add more tests for other scenarios if needed

    @AfterClass
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}
