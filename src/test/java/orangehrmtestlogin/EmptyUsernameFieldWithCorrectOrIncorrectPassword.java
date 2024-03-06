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

    @BeforeClass
    public void setUp() {
        // Setup WebDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }
 

    @Test(priority = 1)
    public void testEmptyUsernameWithCorrectPassword() throws InterruptedException {
        // Navigate to the login page

        // Enter empty username
    	 // Navigate to the login page
    	Thread.sleep(3000);
    	WebElement usernameField = driver.findElement(By.name("username"));
    	usernameField.sendKeys("");

         // Enter correct password
    	WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("admin123");

        Thread.sleep(3000);
        // Click on the login button
        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button"));
        loginButton.click();
        Thread.sleep(3000);

        // Verify error message is displayed
        WebElement errorMessage = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/span"));
        Assert.assertTrue(errorMessage.getText().contains("Required"), "Error message is not displayed for invalid login");
    }

    @Test(priority = 2)
    public void testEmptyUsernameWithIncorrectPassword() throws InterruptedException {
        // Navigate to the login page
    	Thread.sleep(3000);
    	WebElement usernameField = driver.findElement(By.name("username"));
    	usernameField.sendKeys("");

         // Enter correct password
    	WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("admin1234");

        Thread.sleep(3000);
        // Click on the login button
        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button"));
        loginButton.click();
        Thread.sleep(3000);

        // Verify error message is displayed
        WebElement errorMessage = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/span"));
        Assert.assertTrue(errorMessage.getText().contains("Required"), "Error message is not displayed for invalid login");
    }
    // Add more tests for other scenarios if needed

    @AfterClass
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}
