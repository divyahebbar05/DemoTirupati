package templates.pageobjects;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import templates.AbstractComponents.abstractComponents;

public class templatePage extends abstractComponents {

	WebDriver driver;
	JavascriptExecutor js;

	public templatePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		this.js = (JavascriptExecutor) driver;
	}

	By addTemplateBtn = By.xpath("//span[text()='Add Template Message']");
	By searchBox = By.cssSelector("input[placeholder='Search for a template']");
	By templateNames = By.cssSelector("div.mantine-Text-root mantine-17yl1ux");
	By upload1 = By.xpath("//span[text()='Continue to Add Recipients']");
	By upload2 = By.xpath("(//span[text()='Upload File'])[2]");
	By map1 = By.cssSelector("input[placeholder='Map Param for country_code']");
	By mayuriImages = By.xpath("//div[contains(text(),'mayuriimage')]");
	By defaultUpload = By.cssSelector("div[class='mantine-Grid-col mantine-1wiscvp']");
	By imageSelect = By.cssSelector("div[class='mantine-Grid-col mantine-1wiscvp']:nth-child(1)");
	By sendImage = By.xpath("//span[text()='Send']");

	public void selectTemplate(String templateName) throws InterruptedException {

		driver.findElement(addTemplateBtn).click();
		driver.findElement(searchBox).sendKeys(templateName);

		By mayuriImages = By.xpath("//div[contains(text(),'mayuriimage')]");
		WebElement results =waitForWebElementToAppear3(mayuriImages);
		// List<WebElement> results=waitForNumberOfElementsToBeMoreThan(mayuriimage,0); 
		List<WebElement> templates = driver.findElements(templateNames);

		By Template = By.xpath("//span[text()='Select Template']");
		js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement((Template)));
		Thread.sleep(5000);
		waitForElementToBeClickableAfterRefresh(Template);
		 driver.findElement(By.xpath("//span[text()='Select Template']")).click();
		}
	

// =========================
// ✅ UPLOAD FILE
// =========================

	public void uploadRecipientsFile(String filePath) throws Exception {

		/*
		 * By Media=By.cssSelector("div[class='mantine-iyuojc']"); //upload media
		 * waitForWebElementToAppear(Media); 
		 * WebElement addMedia=driver.findElement(Media); 
		 * js.executeScript("arguments[0].click();",addMedia);
		 */

		By Media = By.cssSelector("div[class='mantine-iyuojc']"); // upload media
		//By Media = By.xpath("//span[text()='Upload Media']");
		waitForElementToBeClickable(Media).click();
		waitForElementToBeClickable(defaultUpload).click();
		waitForElementToBeClickable(imageSelect).click();
		waitForElementToBeClickable(sendImage).click();
		js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement((upload1)));
	    waitForElementToBeClickable(upload1).click();
		// or driver.findElement(upload1).click();
	    
	    Thread.sleep(7000);
		waitForElementToBeClickable(upload2).click();
		
		Thread.sleep(7000);
		Runtime.getRuntime().exec(filePath); // AutoIT exe path

		Thread.sleep(5000);
	} 

// =========================
// ✅ MAP PARAMETERS
// =========================

	public void mapParameters() throws InterruptedException {

		By countryCodeLocator = By.cssSelector("input[placeholder='Map Param for country_code']");

		waitForWebElementToAppear(countryCodeLocator);
		WebElement countryCode = driver.findElement(countryCodeLocator);
		// or WebElement countryCode = waitForWebElementToAppear3(map1);

		countryCode.click();
		countryCode.sendKeys("country_code");
		Thread.sleep(1000);
		countryCode.sendKeys(Keys.ARROW_DOWN);
		countryCode.sendKeys(Keys.ENTER);

		By whatsappNumberLocator = By.cssSelector("input[placeholder='Map Param for whatsapp_number']");

		waitForWebElementToAppear(whatsappNumberLocator);
		WebElement whatsappNumber = driver.findElement(whatsappNumberLocator);

		whatsappNumber.click();
		whatsappNumber.sendKeys("whatsapp_number");
		Thread.sleep(1000);
		whatsappNumber.sendKeys(Keys.ARROW_DOWN);
		whatsappNumber.sendKeys(Keys.ENTER);

	/*	By orderLocator = By.cssSelector("input[placeholder='Map Param for order']");
		waitForWebElementToAppear(orderLocator);
		WebElement orderField = driver.findElement(orderLocator);

		orderField.click();
		orderField.sendKeys("order");
		Thread.sleep(1000);
		orderField.sendKeys(Keys.ARROW_DOWN);
		orderField.sendKeys(Keys.ENTER); */
		
		By params=By.xpath("//span[text()='Map Parameters']");
		waitForElementToBeClickable(params).click();
	}
// =========================
// ✅ SEND TEST MESSAGE
// =========================

	public void sendTestMessage(String testNumber) {

		By continueTest = By.xpath("//span[text()='Continue To Test']");
		
		By overlay = By.cssSelector("mantine-1ryt1ht mantine-Button-label");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(overlay));
		
		waitForWebElementToAppear(continueTest);
		WebElement testBtn = waitForElementToBeClickable(continueTest);
		js.executeScript("arguments[0].scrollIntoView(true);", testBtn);
		testBtn.click();

		By sendTestNumber = By.cssSelector("input[placeholder='1 (702) 123-4567']");
		waitForWebElementToAppear(sendTestNumber);
		WebElement tryingNumber = driver.findElement(sendTestNumber);
		tryingNumber.sendKeys(testNumber);

		js.executeScript("arguments[0].scrollIntoView(true);",
				driver.findElement(By.xpath("//span[text()='Send Test Message']")));

		driver.findElement(By.xpath("//span[text()='Send Test Message']")).click();

		By gotMessage = By.xpath("//span[text()='Yes']");
		waitForWebElementToAppear(gotMessage);
		WebElement messageReceived = driver.findElement(gotMessage);
		messageReceived.click();
	}

// =========================
// ✅ REVIEW & LAUNCH
// =========================

	public void launchCampaign() throws InterruptedException {

		By reviewLaunch = By.xpath("//span[text()='Review And Launch']");
		waitForWebElementToAppear(reviewLaunch);
		WebElement reviewBtn = driver.findElement(reviewLaunch);

		js.executeScript("arguments[0].scrollIntoView(true);", reviewBtn);
		reviewBtn.click();

		By launch = By.xpath("//span[text()='Launch']");
		waitForWebElementToAppear(launch);
		WebElement finalLaunch = driver.findElement(launch);
		finalLaunch.click();
		Thread.sleep(7000);
		}
	
	public void selectTemplate1(String templateName) throws InterruptedException {

		driver.findElement(addTemplateBtn).click();
		driver.findElement(searchBox).sendKeys(templateName);

	/*	By copyShip = By.xpath("//div[contains(text(),'copy_ship')]");
		WebElement results =waitForWebElementToAppear3(copyShip);
		 List<WebElement> results1=waitForNumberOfElementsToBeMoreThan(copyShip,1); 
		List<WebElement> templates = driver.findElements(templateNames);

		By Template = By.xpath("//span[text()='Select Template']");
		js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement((Template)));
		Thread.sleep(5000);
		waitForElementToBeClickableAfterRefresh(Template); */
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		
		List<WebElement> results = wait.until( ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//div[contains(text(),'copy_ship_divi1')]"), 0) );   //has only one template with this name
		
         List<WebElement> products=driver.findElements(By.cssSelector("div[class='mantine-Text-root mantine-17yl1ux']"));
            
         By Template=By.xpath("//span[text()='Select Template']");
				js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement((Template)));
				wait.until(ExpectedConditions.elementToBeClickable(Template)); 
		 
//for more than one template present
		for (int i = 0; i < products.size(); i++) {

			if (products.get(i).getText().equals(templateName)) {
				driver.findElements(By.xpath("//span[text()='Select Template']")).get(i).click();
				break; 
            }
           }
          }
         }
