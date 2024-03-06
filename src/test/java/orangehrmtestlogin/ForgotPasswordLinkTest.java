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

public class ForgotPasswordLinkTest {
	
    private WebDriver driver;


    @BeforeClass
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @Test(priority = 1)
    public void testForgotPasswordButton() throws InterruptedException {

        Thread.sleep(3000);
        // Click on the "Forgot Password" link
        WebElement ForgotPasswordButton = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[4]/p"));
        ForgotPasswordButton.click();
        Thread.sleep(3000);

       // WebElement errorMessage = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/div/div[1]/div[1]/p"));
        //Assert.assertTrue(errorMessage.getText().contains("Invalid credentials"), "Error message is not displayed for invalid login");


        // Verify if the page redirects to the Forgot Password page
//        String forgotPasswordPageTitle = driver.getTitle();
//        Assert.assertEquals(forgotPasswordPageTitle, "Reset Password", "Forgot Password page title doesn't match");

     
        WebElement resetMessage = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/div/form/h6"));
        System.out.println(resetMessage.getText());
        Assert.assertTrue(resetMessage.getText().contains("Reset Password"), "Reset Password message is not displayed");
    }
    
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}


