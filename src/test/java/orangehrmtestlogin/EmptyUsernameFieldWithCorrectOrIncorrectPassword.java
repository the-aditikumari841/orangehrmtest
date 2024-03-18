package orangehrmtestlogin;

import org.testng.Assert;

import org.testng.annotations.Test;
//import orangehrmtest.common.pages.LoginPage;
import orangehrmtest.common.utils.supportBrowser;

public class EmptyUsernameFieldWithCorrectOrIncorrectPassword extends supportBrowser{
	
	 @Test(priority = 1)
	    public void testEmptyPasswordWithCorrectUsername() throws InterruptedException {
	    
	    //LoginPage loginPage = getLoginPage();
	    if (loginPage != null) {
	        loginPage.navigateToLoginPage(); 
	        Thread.sleep(3000);
	        loginPage.enterUsername("");
	        Thread.sleep(3000);
	        loginPage.enterPassword("admin123");
	        loginPage.clickButton();
	        Thread.sleep(10000);
	        Assert.assertTrue(loginPage.getRequiredMessage1().contains("Required"), "Error message is not displayed for invalid username");
	    }
	    else {
	        Assert.fail("LoginPage is null. Initialization failed.");
	    }
	  }
	    
	    @Test(priority = 2)
	    public void testEmptyPasswordWithIncorrectUsername() throws InterruptedException {
	    
	    //LoginPage loginPage = getLoginPage();
	    if (loginPage != null) {
	        loginPage.navigateToLoginPage(); 
	        Thread.sleep(3000);
	        loginPage.enterUsername("");
	        Thread.sleep(3000);
	        loginPage.enterPassword("admin1234");
	        loginPage.clickButton();
	        Thread.sleep(10000);
	        Assert.assertTrue(loginPage.getRequiredMessage1().contains("Required"), "Error message is not displayed for invalid username");
	    }
	    else {
	        Assert.fail("LoginPage is null. Initialization failed.");
	    }
	  }
}
	    
	
