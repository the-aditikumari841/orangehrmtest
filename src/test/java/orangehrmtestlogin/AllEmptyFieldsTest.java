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

public class AllEmptyFieldsTest {

    private WebDriver driver;

    @FindBy(name = "username")
    private WebElement usernameField;

    @FindBy(name = "password")
    private WebElement passwordField;

    @FindBy(xpath = "//div[@class='oxd-form-actions orangehrm-login-action']/button")
    private WebElement loginButton;

    @FindBy(xpath = "//div[@class='orangehrm-login-slot-wrapper']//div[1]//div[1]//span[1]")
    private WebElement errorMessage1;
    
    @FindBy(xpath = "//div[@class='orangehrm-login-form']//div[2]//div[1]//span[1]")
    private WebElement errorMessage2;
    
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
        usernameField.sendKeys("");
        passwordField.sendKeys("");
        Thread.sleep(3000);
        loginButton.click();
        Thread.sleep(3000);
        Assert.assertTrue(errorMessage1.getText().contains("Required"), "Error message is not displayed for invalid username");
        Assert.assertTrue(errorMessage2.getText().contains("Required"), "Error message is not displayed for invalid username");
        
    }   

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}






