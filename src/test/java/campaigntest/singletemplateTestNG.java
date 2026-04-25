package campaigntest;

import org.testng.annotations.Test;
import templates.pageobjects.campaignPage;
import templates.pageobjects.loginPage;
import templates.pageobjects.templatePage;
import templates.pageobjects.loginPage;
import templates.pageobjects.campaignPage;
import templates.pageobjects.templatePage;
import campaigntest.TestComponents.BaseTest2;

		public class singletemplateTestNG extends BaseTest2 {

		 @Test
		    public void createCampaignWithTemplate() throws Exception {
			
			
		    	
		    	 singletemplateTestNG test = new singletemplateTestNG();

		         // Initialize driver (assuming BaseTest2 has setup method)
		         //test.setup();  

		        loginPage login = new loginPage(driver);
		        campaignPage campaign = new campaignPage(driver, wait);
		        templatePage template = new templatePage(driver);

		        login.login("divya+test00001@chat360.io", "Admin*123");

		        campaign.openCampaignPage();
		        campaign.createCampaign("dvHybrid1");

		        template.selectTemplate("mayuriimage");
		        
		        Thread.sleep(5000);

		        template.uploadRecipientsFile("C:\\Users\\Divya\\OneDrive\\MM\\xcel\\avi.exe");

		        template.mapParameters();

		        template.sendTestMessage("9980960647");

		        template.launchCampaign(); 
		    }
		}

