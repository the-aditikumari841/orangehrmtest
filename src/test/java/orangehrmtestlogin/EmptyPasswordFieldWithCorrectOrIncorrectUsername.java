package orangehrmtestlogin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EmptyPasswordFieldWithCorrectOrIncorrectUsername {

    private WebDriver driver;

    
    @BeforeClass
    public void setUp() {
        // Setup WebDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }
    
    @Test(priority = 1)
    public void testEmptyPasswordWithCorrectUsername() throws InterruptedException {
        // Navigate to the login page
    	 // Navigate to the login page
    	Thread.sleep(3000);
    	WebElement usernameField = driver.findElement(By.name("username"));
    	usernameField.sendKeys("Admin");

         // Enter correct password
    	WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("");

        Thread.sleep(3000);
        // Click on the login button
        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button"));
        loginButton.click();
        Thread.sleep(3000);

        // Verify error message is displayed
        WebElement errorMessage = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/span"));
        Assert.assertTrue(errorMessage.getText().contains("Required"), "Error message is not displayed for invalid login");
    }

    @Test(priority = 2)
    public void testEmptyPasswordWithIncorrectUsername() throws InterruptedException {
        // Navigate to the login page
    	 // Navigate to the login page
    	Thread.sleep(3000);
    	WebElement usernameField = driver.findElement(By.name("username"));
    	usernameField.sendKeys("Admin1");

         // Enter correct password
    	WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("");

        Thread.sleep(3000);
        // Click on the login button
        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button"));
        loginButton.click();
        Thread.sleep(3000);

        // Verify error message is displayed
        WebElement errorMessage = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/span"));
        Assert.assertTrue(errorMessage.getText().contains("Required"), "Error message is not displayed for invalid login");
    }

    // Add more tests for other scenarios if needed

    @AfterClass
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}
