package orangehrmtestlogin;

import org.testng.Assert;
import org.testng.annotations.Test;

import orangehrmtest.common.pages.JobTitlePage;
import orangehrmtest.common.utils.supportBrowser;

public class JobTitleFunctionalityTest extends supportBrowser{
	
	@Test(priority = 1)
	public void testJobTitleFunctionality() throws InterruptedException {
		
		JobTitlePage jobTitle = getJobTitlePage();
		
	    //if (jobTitle != null) {
	    	jobTitle.navigateToJobTitle();
	    	System.out.println("PASS1");
	    	jobTitle.enterUsername("Admin");
	        jobTitle.enterPassword("admin123");
	        jobTitle.clickButton();
	        System.out.println("PASS");
	       
	        
	        jobTitle.clickAddButton();
	        System.out.println("test");
	        
	        jobTitle.enterJobTitle("JobTitle");
	       
	        jobTitle.enterJobDesc("Jobdesc");
	        jobTitle.enterNote("Note");

	        jobTitle.clickSaveButton();
	        
//	    }
//	    else {
//	        Assert.fail("Job Title Page is null. Initialization failed.");
//	    }
	}
}