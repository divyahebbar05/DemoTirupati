package campaigntest;

import org.testng.Assert;
import org.testng.annotations.Test;
import templates.pageobjects.campaignPage;
import templates.pageobjects.loginPage;
import templates.pageobjects.templatePage;
import templates.pageobjects.loginPage;
import templates.pageobjects.campaignPage;
import templates.pageobjects.templatePage;
import campaigntest.TestComponents.BaseTest;

		public class multitemplate extends BaseTest {

		    @Test
		    public void createCampaignWithTemplate() throws Exception {

		        loginPage login = new loginPage(driver);
		        campaignPage campaign = new campaignPage(driver, wait);
		        templatePage template = new templatePage(driver);

		        login.login("divya+test00001@chat360.io", "Admin*123");

		        campaign.openCampaignPage();
		        campaign.createCampaign("dvHybrid1");
		        Assert.fail("Force Failure");

		        template.selectTemplate1("copy_ship_divi1");
		        
		        Thread.sleep(5000);

		        template.uploadRecipientsFile("C:\\Users\\Divya\\OneDrive\\MM\\xcel\\avi.exe");
		        
		        Thread.sleep(5000);

		        template.mapParameters();
		        Thread.sleep(5000);
		        Assert.fail("Force Failure");

		        template.sendTestMessage("9980960647");

		        template.launchCampaign(); 
		        Assert.fail("Force Failure");
		        
		        //made changes for test
		    }
		}

