package campaigntest;

import org.testng.annotations.Test;
import templates.pageobjects.campaignPage;
import templates.pageobjects.loginPage;
import templates.pageobjects.templatePage;
import templates.pageobjects.loginPage;
import templates.pageobjects.campaignPage;
import templates.pageobjects.templatePage;
import campaigntest.TestComponents.BaseTest2;

		public class singletemplate extends BaseTest2 {

		
			public static void main(String[] args) throws Exception {
		    	
		    	 singletemplate test = new singletemplate();

		         // Initialize driver (assuming BaseTest2 has setup method)
		         test.setup();  //setup is from basetest to initiate browser

		        loginPage login = new loginPage(test.driver);    //
		        campaignPage campaign = new campaignPage(test.driver, test.wait); //driver is nonstatic u need to call it by created object
		        templatePage template = new templatePage(test.driver);

		        login.login("divya+test00001@chat360.io", "Admin*123");

		        campaign.openCampaignPage();
		        campaign.createCampaign("dvHybrid1");

		        template.selectTemplate("mayuriimage");
		        
		        Thread.sleep(5000);

		        template.uploadRecipientsFile("C:\\Users\\Divya\\OneDrive\\MM\\xcel\\avi.exe");

		        template.mapParameters();

		        template.sendTestMessage("9980960647");

		        template.launchCampaign(); 
		        
		        //made changes for test
		    }
		}

