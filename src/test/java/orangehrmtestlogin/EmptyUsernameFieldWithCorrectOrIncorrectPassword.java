package orangehrmtestlogin;

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

public class EmptyUsernameFieldWithCorrectOrIncorrectPassword {

    private WebDriver driver;
        
    @FindBy(name = "username")
    private WebElement usernameField;
    
    @FindBy(name = "password")
    private WebElement passwordField;
    
    @FindBy(xpath = "//div[@class='oxd-form-actions orangehrm-login-action']/button")
    private WebElement loginButton;
    
    @FindBy(xpath = "//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']")
    private WebElement errorMessage;

    
    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        PageFactory.initElements(driver, this);
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }
    
    @Test(priority = 1)
    public void testEmptyPasswordWithCorrectUsername() throws InterruptedException {
    	Thread.sleep(3000);
    	usernameField.sendKeys("");
        passwordField.sendKeys("admin123");
        Thread.sleep(3000);
        loginButton.click();
        Thread.sleep(3000);

        Assert.assertTrue(errorMessage.getText().contains("Required"), "Error message is not displayed for invalid login");
    }

    @Test(priority = 2)
    public void testEmptyPasswordWithIncorrectUsername() throws InterruptedException {
    	Thread.sleep(3000);
    	usernameField.sendKeys("");
        passwordField.sendKeys("admin1234");
        Thread.sleep(3000);
        loginButton.click();
        Thread.sleep(3000);

        Assert.assertTrue(errorMessage.getText().contains("Required"), "Error message is not displayed for invalid login");
    }
    
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
