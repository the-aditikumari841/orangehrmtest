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

public class InvalidUsernameAndValidPasswordLoginTest {

    private WebDriver driver;

    
    @BeforeClass
    public void setUp() {
        // Setup WebDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    
    

    @Test(priority = 1)
    public void testInvalidUsernameValidPassword() throws InterruptedException {
        // Navigate to the login page


        // Enter invalid username
    	 Thread.sleep(3000);
        WebElement usernameField = driver.findElement(By.name("username"));
        usernameField.sendKeys("Admin1");

        // Enter valid password

        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("admin123");

        // Click on the login button
        Thread.sleep(3000);
        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button"));
        loginButton.click();

        // Verify error message is displayed
        Thread.sleep(3000);
        WebElement errorMessage = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/div/div[1]/div[1]/p"));
        Assert.assertTrue(errorMessage.isDisplayed(), "Error message is not displayed for invalid username");
    }

    // Add more tests for other scenarios if needed

    @AfterClass
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}





