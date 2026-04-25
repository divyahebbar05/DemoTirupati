package templates.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import templates.AbstractComponents.abstractComponents;

public class campaignPage extends abstractComponents {

	    WebDriver driver;
	    WebDriverWait wait;

	    public campaignPage(WebDriver driver, WebDriverWait wait) {
	    	super(driver);
	        this.driver = driver;
	        this.wait = wait;
	    }

	    By campaignMenu = By.cssSelector("a[href='/campaign']");
	    By createCampaign = By.xpath("//span[text()='Create New Campaign']");
	    By campaignName = By.cssSelector("input[placeholder='Enter Campaign Name']");

	    public void openCampaignPage() {
	        driver.findElement(campaignMenu).click();
	    }

	    public void createCampaign(String name) {
	        driver.findElement(createCampaign).click();
	        driver.findElement(campaignName).sendKeys(name);
	        
	        By businessNumber=By.cssSelector("input[placeholder='Select Number']");
			
			WebElement dropdown=waitForWebElementToAppear3(businessNumber);
			dropdown.click();
			
			By selectNumber=By.xpath("//div[text()='Chat360 AdTech']");
			WebElement NumberSelect= waitForWebElementToAppear3(selectNumber);
			NumberSelect.click();
	    }
	

	}


