package orangehrmtestlogin;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ForgotPasswordLinkTest {
	
    private WebDriver driver;
    
    
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[4]/p")
    private WebElement ForgotPasswordButton;
    
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[1]/div/form/h6")
    private WebElement resetMessage;
    
    @FindBy(name = "username")
    private WebElement usernameField;
    
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[1]/div/form/div[2]/button[2]")
    private WebElement resetPasswordButton;
    
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[1]/div/h6")
    private WebElement resetPasswordLinkSentMessage;
    
    @BeforeClass
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        PageFactory.initElements(driver, this);
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @Test(priority = 1)
    public void testForgotPasswordButton() throws InterruptedException {

        Thread.sleep(3000);
        ForgotPasswordButton.click();
        Thread.sleep(3000);
     

        System.out.println(resetMessage.getText());
        Assert.assertTrue(resetMessage.getText().contains("Reset Password"), "Reset Password message is not displayed");
        
        Thread.sleep(3000);
        usernameField.sendKeys("Admin");

        Thread.sleep(3000);

        resetPasswordButton.click();
        Thread.sleep(3000);

        Assert.assertTrue(resetPasswordLinkSentMessage.getText().contains("Reset Password link sent successfully"));
    }
    
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}



