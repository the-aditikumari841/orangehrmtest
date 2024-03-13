package orangehrmtestlogin;

import org.testng.Assert;
import org.testng.annotations.Test;
import orangehrmtest.common.pages.LoginPage;
import orangehrmtest.common.utils.supportBrowser;

public class AllEmptyFieldsTest extends supportBrowser {
	
    @Test(priority = 1)
    public void testInvalidUsernameValidPassword() throws InterruptedException {
    
    LoginPage loginPage = getLoginPage();
    if (loginPage != null) {
        loginPage.navigateToLoginPage(); 
        Thread.sleep(3000);
        loginPage.enterUsername("");
        Thread.sleep(3000);
        loginPage.enterPassword("");
        loginPage.clickButton();
        Thread.sleep(3000);
        Assert.assertTrue(loginPage.getRequiredMessage1().contains("Required"), "Error message is not displayed for invalid username");
        Assert.assertTrue(loginPage.getRequiredMessage2().contains("Required"), "Error message is not displayed for invalid username"); 
    }
    else {
        Assert.fail("LoginPage is null. Initialization failed.");
    }
  }
}


