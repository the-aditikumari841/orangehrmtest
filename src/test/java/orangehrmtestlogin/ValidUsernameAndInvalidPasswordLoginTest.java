

package orangehrmtestlogin;

import org.testng.Assert;
import org.testng.annotations.Test;
import orangehrmtest.common.pages.LoginPage;
import orangehrmtest.common.utils.supportBrowser;
public class ValidUsernameAndInvalidPasswordLoginTest extends supportBrowser {
	@Test(priority = 1)
	public void testValidUsernameInvalidPassword() throws InterruptedException {
	    LoginPage loginPage = getLoginPage();
	    if (loginPage != null) {
	        loginPage.navigateToLoginPage(); 
	        Thread.sleep(3000);
	        loginPage.enterUsername("Admin");
	        Thread.sleep(3000);
	        loginPage.enterPassword("admin1234");
	        loginPage.clickButton();
	        Thread.sleep(3000);
	        Assert.assertTrue(loginPage.getErrorMessage().contains("Invalid credentials"), "Error message is not displayed for invalid login");
	    }
	    else {
	        Assert.fail("LoginPage is null. Initialization failed.");
	    }
	}

}

