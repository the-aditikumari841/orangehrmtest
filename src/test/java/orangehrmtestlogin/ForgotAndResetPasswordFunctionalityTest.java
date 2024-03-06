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

public class ForgotAndResetPasswordFunctionalityTest {
    
    private WebDriver driver;


    @BeforeClass
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/requestPasswordResetCode");
    }

    @Test(priority = 1)
    public void testValidUsernameInvalidPassword() throws InterruptedException {

    	Thread.sleep(3000);
        WebElement usernameField = driver.findElement(By.name("username"));
        usernameField.sendKeys("Admin");

        Thread.sleep(3000);

        WebElement resetPasswordButton = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/div/form/div[2]/button[2]"));
        resetPasswordButton.click();
        Thread.sleep(3000);

        WebElement errorMessage = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/div/h6"));
        Assert.assertTrue(errorMessage.getText().contains("Reset Password link sent successfully"));
    }
    
    
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}



