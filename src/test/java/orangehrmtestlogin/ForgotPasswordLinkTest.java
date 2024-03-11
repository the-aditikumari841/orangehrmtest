package orangehrmtestlogin;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ForgotPasswordLinkTest {
	
    private WebDriver driver;
    
    @FindBy(how = How.XPATH, using = "//p[@class='oxd-text oxd-text--p orangehrm-login-forgot-header']")
    private WebElement ForgotPasswordButton;
    
    @FindBy(how = How.XPATH, using = "//h6[@class='oxd-text oxd-text--h6 orangehrm-forgot-password-title']")
    private WebElement resetMessage;
    
    @FindBy(how = How.NAME, using = "username")
    private WebElement usernameField;
    
    @FindBy(how = How.XPATH, using =  "//button[@type='submit']")
    private WebElement resetPasswordButton;
    
    @FindBy(how = How.XPATH, using = "//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']")
    private WebElement errorMessage;
    
    @FindBy(how = How.XPATH, using = "//h6[@class='oxd-text oxd-text--h6 orangehrm-forgot-password-title']")
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
        usernameField.sendKeys("");

        Thread.sleep(3000);

        resetPasswordButton.click();
        Thread.sleep(3000);

        Assert.assertTrue(errorMessage.getText().contains("Required"));
    }
    

    @Test(priority = 2)
    public void testEmptyPasswordWithIncorrectUsername() throws InterruptedException {

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
