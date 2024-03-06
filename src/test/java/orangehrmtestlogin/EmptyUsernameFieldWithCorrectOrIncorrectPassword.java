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
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }
 

    @Test(priority = 1)
    public void testEmptyUsernameWithCorrectPassword() throws InterruptedException {

    	Thread.sleep(3000);
    	WebElement usernameField = driver.findElement(By.name("username"));
    	usernameField.sendKeys("");

    	WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("admin123");

        Thread.sleep(3000);

        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button"));
        loginButton.click();
        Thread.sleep(3000);

        WebElement errorMessage = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/span"));
        Assert.assertTrue(errorMessage.getText().contains("Required"), "Error message is not displayed for invalid login");
    }

    @Test(priority = 2)
    public void testEmptyUsernameWithIncorrectPassword() throws InterruptedException {

    	Thread.sleep(3000);
    	WebElement usernameField = driver.findElement(By.name("username"));
    	usernameField.sendKeys("");

    	WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("admin1234");

        Thread.sleep(3000);
        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button"));
        loginButton.click();
        Thread.sleep(3000);

        WebElement errorMessage = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/span"));
        Assert.assertTrue(errorMessage.getText().contains("Required"), "Error message is not displayed for invalid login");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
