//package orangehrmtestlogin;
//
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.How;
//import org.openqa.selenium.support.PageFactory;
//import org.testng.Assert;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//import io.github.bonigarcia.wdm.WebDriverManager;
//import orangehrmtest.common.pages.LoginPage;
//import orangehrmtest.common.utils.supportBrowser;S
//
//public class ForgotPasswordLinkTest extends supportBrowser{
//
//    @Test(priority = 1)
//    public void testForgotPasswordButton() throws InterruptedException {
//    	LoginPage loginPage = getLoginPage();
//        Thread.sleep(3000);
//        loginPage.forgotPasswordButton();
//
//        Thread.sleep(3000);
//        System.out.println(loginPage.getText());
//        Assert.assertTrue(loginPage.getText().contains("Reset Password"), "Reset Password message is not displayed");
//        Thread.sleep(3000);
//        loginPage.enterUsername("Admin");
//        Thread.sleep(3000);
//        loginPage.resetPasswordButton();
//        //resetPasswordButton.click();
//        Thread.sleep(3000);
//        Assert.assertTrue(loginPage.getText().contains("Required"));
//        Assert.assertTrue(loginPage.getText().contains("Required"), "Required for Reset");
//
//
//        
//    }
//    
//    @Test(priority = 2)
//    public void testEmptyPasswordWithEmptyUsernameField() throws InterruptedException {
//   
//    LoginPage loginPage = getLoginPage();
//    if (loginPage != null) {
//        loginPage.navigateToLoginPage(); 
//        Thread.sleep(3000);
//        System.out.println(loginPage.getText());
//        Assert.assertTrue(loginPage.getText().contains("Reset Password"), "Reset Password message is not displayed");
//        Thread.sleep(3000);
//        loginPage.enterUsername("");
//        Thread.sleep(3000);
//        resetPasswordButton.clickButton();
//        Thread.sleep(3000);
//        //Assert.assertTrue(resetPasswordLinkSentMessage.getText().contains("Reset Password link sent successfully"));
//        Assert.assertTrue(loginPage.getRequiredForResetMessage().contains("Reset Password link sent successfully"));
//        
//       
//    }
//    else {
//        Assert.fail("LoginPage is null. Initialization failed.");
//    }
//  }
//    
//
//
//    
//    @Test(priority = 2)
//    public void testEmptyPasswordWithUsername() throws InterruptedException {
//   
//    LoginPage loginPage = getLoginPage();
//    if (loginPage != null) {
//        loginPage.navigateToLoginPage(); 
//        Thread.sleep(3000);
//        loginPage.enterUsername("Admin");
//        Thread.sleep(3000);
//        resetPassword.clickButton();
//        Thread.sleep(3000);
//        //Assert.assertTrue(resetPasswordLinkSentMessage.getText().contains("Reset Password link sent successfully"));
//        Assert.assertTrue(loginPage.getResetPasswordLinkSentMessage().contains("Reset Password link sent successfully"));
//        
//    }
//    else {
//        Assert.fail("LoginPage is null. Initialization failed.");
//    }
//  }
//        
//
//}
//
//
//-----------------------------------------------------------------------------
//
/////
//
//
//
//@FindBy(how = How.XPATH, using = "//p[@class='oxd-text oxd-text--p orangehrm-login-forgot-header']")
//private WebElement ForgotPasswordButton;
//
//@FindBy(how = How.XPATH, using = "//h6[@class='oxd-text oxd-text--h6 orangehrm-forgot-password-title']")
//private WebElement resetMessage;
//
//
//
//@FindBy(how = How.XPATH, using =  "//button[@type='submit']")
//private WebElement resetPasswordButton;
//
//@FindBy(how = How.XPATH, using = "//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']")
//private WebElement requiredMessageInResetPassword;
//
//@FindBy(how = How.XPATH, using = "//h6[@class='oxd-text oxd-text--h6 orangehrm-forgot-password-title']")
//private WebElement resetPasswordLinkSentMessage;
//
//
//
/////
//
//public void forgotPasswordButton() {
//	ForgotPasswordButton.click(); 
//}
//
//
//public String getRequiredForResetMessage() {
//	// TODO Auto-generated method stub
//	return null;
//}
//
//public String getResetPasswordLinkSentMessage() {
//	// TODO Auto-generated method stub
//	return null;
//}
//
//public void resetPasswordButton() {
//	// TODO Auto-generated method stub
//	
//}
//
//
//
//-----------------------------------------------------------------------------
////@Test(priority = 2)
////public void testEmptyPasswordWithIncorrectUsername() throws InterruptedException {
////  Thread.sleep(3000);
////  usernameField.sendKeys("Admin");
////  Thread.sleep(3000);
////  resetPasswordButton.click();
////  Thread.sleep(3000);
////  Assert.assertTrue(resetPasswordLinkSentMessage.getText().contains("Reset Password link sent successfully"));
////}
//
////Assert.assertTrue(loginPage.getRequiredMessage1().contains("Required"), "Error message is not displayed for invalid username");
////Assert.assertTrue(loginPage.getRequiredMessage2().contains("Required"), "Error message is not displayed for invalid username"); 
//
////Assert.assertTrue(loginPage.getRequiredMessage1().contains("Required"), "Error message is not displayed for invalid username");
////Assert.assertTrue(loginPage.getRequiredMessage2().contains("Required"), "Error message is not displayed for invalid username");
//
package orangehrmtestlogin;


