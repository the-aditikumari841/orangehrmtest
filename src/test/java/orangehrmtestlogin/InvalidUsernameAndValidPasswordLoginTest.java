package orangehrmtestlogin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InvalidUsernameAndValidPasswordLoginTest {

    private WebDriver driver;
    
    @FindBy(how = How.NAME, using = "username")
    private WebElement usernameField;
    
    @FindBy(how = How.NAME, using = "password")
    private WebElement passwordField;
    
    @FindBy(how = How.XPATH, using = "//div[@class='oxd-form-actions orangehrm-login-action']/button")
    private WebElement loginButton;
    
    @FindBy(how = How.XPATH, using = "//p[@class='oxd-text oxd-text--p oxd-alert-content-text']")
    private WebElement errorMessage;
    
    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        PageFactory.initElements(driver, this);
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }
   
    @Test(priority = 1)
    public void testInvalidUsernameValidPassword() throws InterruptedException {
        Thread.sleep(3000);
        usernameField.sendKeys("Admin1");
        passwordField.sendKeys("admin123");
        Thread.sleep(3000);
        loginButton.click();
        Thread.sleep(3000);
        Assert.assertTrue(errorMessage.getText().contains("Invalid credentials"), "Error message is not displayed for invalid username");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}




