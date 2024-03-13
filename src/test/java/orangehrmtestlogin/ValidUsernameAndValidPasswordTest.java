package orangehrmtestlogin;

import org.testng.Assert;

import org.testng.annotations.Test;
import orangehrmtest.common.pages.LoginPage;
import orangehrmtest.common.utils.supportBrowser;

public class ValidUsernameAndValidPasswordTest extends supportBrowser {

	@Test(priority = 1)
	public void testValidUsernameInvalidPassword() throws InterruptedException {
	    LoginPage loginPage = getLoginPage();
	    if (loginPage != null) {
	        loginPage.navigateToLoginPage(); 
	        Thread.sleep(3000);
	        loginPage.enterUsername("Admin");
	        Thread.sleep(3000);
	        loginPage.enterPassword("admin123");
	        loginPage.clickButton();
	        Thread.sleep(10000);
	        Assert.assertTrue(loginPage.getDashboard().contains("Dashboard"), "Dashboard is displayed for valid login");


	    }
	    else {
	        Assert.fail("LoginPage is null. Initialization failed.");
	    }
	    
}
}

