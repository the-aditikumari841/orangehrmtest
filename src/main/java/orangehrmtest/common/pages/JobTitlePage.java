package orangehrmtest.common.pages;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class JobTitlePage {


    private WebDriver driver;
    private String jobTitleUrl;

    @FindBy(how = How.NAME, using = "username")
    private WebElement usernameField;
    
    @FindBy(how = How.NAME, using = "password")
    private WebElement passwordField;
    
    @FindBy(how = How.XPATH, using = "//div[@class='oxd-form-actions orangehrm-login-action']/button")
    private WebElement loginButton;
    
    @FindBy(how = How.XPATH, using = "//button[normalize-space()='Add']")
    private WebElement addButton;
    
    @FindBy(how = How.CLASS_NAME, using = "oxd-input oxd-input--active")
    private WebElement jobTitleField;
    
    @FindBy(how = How.CLASS_NAME, using = "//textarea[@placeholder='Type description here']")
    private WebElement jobDescField;
    
    @FindBy(how = How.CLASS_NAME, using = "oxd-textarea oxd-textarea--active oxd-textarea--resize-vertical")
    private WebElement addNoteField;
    
    @FindBy(how = How.XPATH, using = "document.querySelector(\"button[type='submit']\")")
    private WebElement saveButton;
    
    @FindBy(how = How.XPATH, using = "//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']")
    private WebElement dashboard;
    
    public JobTitlePage(WebDriver driver, String jobTitleUrl) {
        this.driver = driver;
        this.jobTitleUrl = jobTitleUrl;
        PageFactory.initElements(driver, this); 
    }
    
    public void navigateToJobTitle() {
    	driver.get(jobTitleUrl);
    }
           
    public void enterUsername(String username) {
        usernameField.sendKeys(username);
    }
    
    public void enterJobTitle(String jobtitle) {
        jobTitleField.sendKeys(jobtitle);
    }
    
    public void enterJobDesc(String jobdesc) {
    	jobDescField.sendKeys(jobdesc);
    }
    
    public void enterNote(String note) {
    	addNoteField.sendKeys(note);
    }
    
    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }
    
    public void clickButton() {
        loginButton.click(); 
    }
    
    public String getDashboard() {
    	return dashboard.getText();
    }
    
    public void clickAddButton() {
        addButton.click(); 
    }
    
    public void clickSaveButton() {
    	saveButton.click();
    }

    
    public void quitDriver() {
        if (driver != null) {
            driver.quit();
        }   
    }
}



