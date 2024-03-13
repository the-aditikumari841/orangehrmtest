

package orangehrmtest.common.pages;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
    private WebDriver driver;
    
    private String loginPageUrl;

    
    @FindBy(how = How.NAME, using = "username")
    private WebElement usernameField;
    
    @FindBy(how = How.NAME, using = "password")
    private WebElement passwordField;
    
    @FindBy(how = How.XPATH, using = "//div[@class='oxd-form-actions orangehrm-login-action']/button")
    private WebElement loginButton;
    
    @FindBy(how = How.XPATH, using = "//p[@class='oxd-text oxd-text--p oxd-alert-content-text']")
    private WebElement errorMessage;
    
    @FindBy(how = How.XPATH, using = "//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']")
    private WebElement dashboard;
    

    
    public LoginPage(WebDriver driver, String loginPageUrl) {
        this.driver = driver;
        this.loginPageUrl = loginPageUrl;
        PageFactory.initElements(driver, this); 
    }
    
    public void navigateToLoginPage() {
        driver.get(loginPageUrl);
    }
           

    
    public void enterUsername(String username) {
        usernameField.sendKeys(username);
    }
    
    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }
    
    public String getErrorMessage() {
        return errorMessage.getText();
    }
    
    public String getDashboard() {
    	return dashboard.getText();
    }
    
    public void clickButton() {
        loginButton.click(); 
    }
    
    public void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}






