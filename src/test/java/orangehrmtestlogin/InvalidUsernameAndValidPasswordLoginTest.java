package orangehrmtestlogin;

import org.testng.Assert;

import org.testng.annotations.Test;
//import orangehrmtest.common.pages.LoginPage;
import orangehrmtest.common.utils.supportBrowser;

public class InvalidUsernameAndValidPasswordLoginTest extends supportBrowser {
	
    @Test(priority = 1)
	public void testInvalidUsernameAndValidPassword() throws InterruptedException {
	    //LoginPage loginPage = getLoginPage();
	    if (loginPage != null) {
	        loginPage.navigateToLoginPage(); 
	        Thread.sleep(3000);
	        loginPage.enterUsername("Admin1");
	        Thread.sleep(3000);
	        loginPage.enterPassword("admin123");
	        loginPage.clickButton();
	        Thread.sleep(3000);
	        Assert.assertTrue(loginPage.getErrorMessage().contains("Invalid credentials"), "Error message is not displayed for invalid login");
	    }
	    else {
	        Assert.fail("LoginPage is null. Initialization failed.");
	    }
	}

}

