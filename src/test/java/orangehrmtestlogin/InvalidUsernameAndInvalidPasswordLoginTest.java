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

public class InvalidUsernameAndInvalidPasswordLoginTest {
    
    private WebDriver driver;


    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

    }


    @Test(priority = 1)
    public void testInvalidUsernameInvalidPassword() throws InterruptedException {

    	Thread.sleep(3000);
        WebElement usernameField = driver.findElement(By.name("username"));
        usernameField.sendKeys("Admin1");

        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("admin1");

        Thread.sleep(3000);
        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button"));
        loginButton.click();
        Thread.sleep(3000);

        WebElement errorMessage = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/div/div[1]/div[1]/p"));
        Assert.assertTrue(errorMessage.getText().contains("Invalid credentials"), "Error message is not displayed for invalid login");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
