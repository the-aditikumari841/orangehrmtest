package orangehrmtestlogin;


import org.testng.Assert;
import org.testng.annotations.Test;
import orangehrmtest.common.pages.LoginPage;
import orangehrmtest.common.utils.supportBrowser;

public class EmptyPasswordFieldWithCorrectOrIncorrectUsername extends supportBrowser {
    
    @Test(priority = 1)
    public void testEmptyPasswordWithCorrectUsername() throws InterruptedException {
    
    LoginPage loginPage = getLoginPage();
    if (loginPage != null) {
        loginPage.navigateToLoginPage(); 
        Thread.sleep(3000);
        loginPage.enterUsername("Admin");
        Thread.sleep(3000);
        loginPage.enterPassword("");
        loginPage.clickButton();
        Thread.sleep(10000);
        Assert.assertTrue(loginPage.getRequiredMessage2().contains("Required"), "Error message is not displayed for invalid username");
    }
    else {
        Assert.fail("LoginPage is null. Initialization failed.");
    }
  }
    
    @Test(priority = 2)
    public void testEmptyPasswordWithIncorrectUsername() throws InterruptedException {
    
    LoginPage loginPage = getLoginPage();
    if (loginPage != null) {
        loginPage.navigateToLoginPage(); 
        Thread.sleep(3000);
        loginPage.enterUsername("Admin1");
        Thread.sleep(3000);
        loginPage.enterPassword("");
        loginPage.clickButton();
        Thread.sleep(10000);
        Assert.assertTrue(loginPage.getRequiredMessage2().contains("Required"), "Error message is not displayed for invalid username");
    }
    else {
        Assert.fail("LoginPage is null. Initialization failed.");
    }
  }
    
}

