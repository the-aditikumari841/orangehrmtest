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

public class EmptyUsernameFieldWithCorrectOrIncorrectPassword {

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
    public void testEmptyUsernameWithCorrectPassword() {
        // Navigate to the login page
        driver.get(baseUrl);

        // Enter empty username
        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys("");

        // Enter correct password
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("correctPassword");

        // Click on the login button
        WebElement loginButton = driver.findElement(By.id("loginButton"));
        loginButton.click();

        // Verify error message is displayed
        WebElement errorMessage = driver.findElement(By.id("Required"));
        Assert.assertTrue(errorMessage.isDisplayed(), "Error message is not displayed for empty username");
    }

    @Test(priority = 2)
    public void testEmptyUsernameWithIncorrectPassword() {
        // Navigate to the login page
        driver.get(baseUrl);

        // Enter empty username
        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys("");

        // Enter incorrect password
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("incorrectPassword");

        // Click on the login button
        WebElement loginButton = driver.findElement(By.id("loginButton"));
        loginButton.click();

        // Verify error message is displayed
        WebElement errorMessage = driver.findElement(By.id("errorMessage"));
        Assert.assertTrue(errorMessage.isDisplayed(), "Error message is not displayed for empty username");
    }

    // Add more tests for other scenarios if needed

    @AfterClass
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}
