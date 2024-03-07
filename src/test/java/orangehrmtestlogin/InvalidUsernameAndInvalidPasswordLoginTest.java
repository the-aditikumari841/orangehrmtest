package orangehrmtestlogin;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.How;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.support.PageFactory;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InvalidUsernameAndInvalidPasswordLoginTest {
	//@FindBy(how=How.NAME, using= "username")
	//private WebElement usnText;
    
    private WebDriver driver;
  
    @FindBy(name = "username")
    private WebElement usernameField;
    
    @FindBy(name = "password")
    private WebElement passwordField;
    
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")
    private WebElement loginButton;
    
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/div/div[1]/div[1]/p")
    private WebElement errorMessage;


    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        PageFactory.initElements(driver, this);
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

    }
    
    @Test(priority = 1)
    public void testInvalidUsernameInvalidPassword() throws InterruptedException {
        Thread.sleep(3000);
        usernameField.sendKeys("Admin1");
        passwordField.sendKeys("admin1");
        Thread.sleep(3000);
        loginButton.click();
        Thread.sleep(3000);
        Assert.assertTrue(errorMessage.getText().contains("Invalid credentials"), "Error message is not displayed for invalid login");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
