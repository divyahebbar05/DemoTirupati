package campaigntest;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Keys;

public class campaigncases {
	
	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		// Implementation needed	
		
		
		//image without variable and only one template with this name present
		
				String	botName="fullweb-automation-widget";
				System.setProperty("webdriver.edge.driver", "C:\\Users\\Divya\\Desktop\\eclipse folder\\driver\\msedgedriver.exe");
					WebDriver driver=new EdgeDriver();
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
					driver.manage().window().maximize();
					
					///////LandingPage
					
					//driver.get("https://app.chat360.io/page/?h=3628d970-df7d-43b5-94ae-b792fada5c28&preview=1");
					
					driver.get("https://staging.chat360.io/login");
					 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
						JavascriptExecutor js=(JavascriptExecutor)driver;
					driver.findElement(By.name("email")).sendKeys("divya+test00001@chat360.io");
					driver.findElement(By.name("password")).sendKeys("Admin*123");
					driver.findElement(By.cssSelector("button[type='submit']")).click();			
					
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[href='/campaign']"))).click();		
			       // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Close']"))).click();
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Create New Campaign']"))).click();
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[placeholder='Enter Campaign Name']"))).sendKeys("dv1");
					WebElement dropdown=wait.until(ExpectedConditions.visibilityOfElementLocated((By.cssSelector("input[placeholder='Select Number']"))));
					dropdown.click();
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Chat360 AdTech']"))).click();
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Add Template Message']"))).click();
		           
		           // driver.findElement(By.xpath("//span[text()='View all']")).click();

		            By searchInput = By.cssSelector("input[placeholder='Search for a template']");

		            // wait until input is clickable
		            
		            WebElement searchBox = wait.until(ExpectedConditions.elementToBeClickable(searchInput));

		            // clear + type
		          //  searchBox.clear();
		            searchBox.sendKeys("mayuriimage");
		            
		            List<WebElement> results = wait.until( ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//div[contains(text(),'mayuriimage')]"), 0 ) );   //has only one template with this name

		           // List<WebElement> results = wait.until( ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//div[contains(text(),'mayuriimage')]"), 1 ) ); //if has more than one same/contains name of the template
		           // WebElement results = wait.until( ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'mayuriimage')]")));  //hardcoded-only one
		            List<WebElement> products=driver.findElements(By.cssSelector("div[class='mantine-Text-root mantine-17yl1ux']"));
		           
		            
		            By Template=By.xpath("//span[text()='Select Template']");
						js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement((Template)));
						wait.until(ExpectedConditions.elementToBeClickable(Template)); 
						
		           
		            int count=products.size(); //The variable count is the total number of products found on the page:
		            for(int i=0;i<count;i++)
		            {
		            	String name=products.get(i).getText();
		            			if(name.equals("mayuriimage"))
		            			{
		             				
		            				driver.findElements(By.xpath("//span[text()='Select Template']")).get(i).click(); //the actual value of i when the if condition is true (i.e., when the product name contains "Brocolli") depends on the position of "Brocolli" in the list of products. For example:If "Brocolli" is the first item in the list, i will be 0.If it's the third item, i will be 2.And so on...Once that condition is met, it clicks the corresponding "ADD TO CART" button using get(i) and breaks the loop, so the final value of i is the index of the first product that contains "Brocolli".
		            				System.out.println("Found copy_ship at index: " + i);
		            				break;
		      } 
		     }  
		        // By Media=By.cssSelector("div[class='mantine-iyuojc']"); //upload media
		         By Media = By.xpath("//span[text()='Upload Media']");
		            WebElement addMedia=wait.until(ExpectedConditions.visibilityOfElementLocated(Media));
		   	js.executeScript("arguments[0].click();", addMedia);
		   	
		   	//for findelement
		     wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='mantine-Grid-col mantine-1wiscvp']"))).click();  //default
		     wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='mantine-Grid-col mantine-1wiscvp']:nth-child(1)"))).click();
		     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Send']"))).click();
		     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Continue to Add Recipients']"))).click();
		     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='Upload File']) [2]"))).click();
		      Thread.sleep(3000);
		  	Runtime.getRuntime().exec("C:\\Users\\Divya\\OneDrive\\MM\\xcel\\avi.exe"); //Save it from editor- .au3 extenstion, Convert file into .exe by compiling .au3 file by right clicking on it by compile script(*86)
		  //Syntax=ControlFocus("title","text","class+instance=ControlId") text value keep it blank no need of it
		  	
		  	Thread.sleep(5000);

		  	//automatically popsup-if not use this line
		  	//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Map Params']")));
		 //	driver.findElement(By.xpath("//span[text()='Map Params']")).click();	//download file-270

		  	WebElement dropdown1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[placeholder='Map Param for country_code']")));
		  	dropdown1.click();
		  	dropdown1.sendKeys("country_code");
		  	Thread.sleep(1000);
		  	dropdown1.sendKeys(Keys.ARROW_DOWN);
		  	dropdown1.sendKeys(Keys.ENTER);
		  	//dropdown1.sendKeys(Keys.ENTER); or dropdown1.sendKeys(org.openqa.selenium.Keys.ENTER);  //to click enter button in keyboard
		 	
		  	WebElement dropdown2=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Map Param for whatsapp_number']")));  
		    dropdown2.click();
		  	Thread.sleep(2000);
		  	dropdown2.sendKeys("whatsapp_number");
		  	Thread.sleep(2000);
		  	dropdown2.sendKeys(Keys.ARROW_DOWN);
		  	dropdown2.sendKeys(Keys.ENTER);
		  	
		  	/*WebElement dropdown3=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Map Param for order']")));  	
		  	dropdown3.click();
		  	Thread.sleep(2000);
		  	dropdown3.sendKeys("order");
		  	Thread.sleep(2000);
		  	dropdown3.sendKeys(Keys.ARROW_DOWN);
		  	dropdown3.sendKeys(Keys.ENTER);  */
		  	
		  	driver.findElement(By.xpath("//span[text()='Map Parameters']")).click();
		  	
		  	By goTest=By.xpath("//span[text()='Continue To Test']");
		    WebElement TestGo=wait.until(ExpectedConditions.visibilityOfElementLocated(goTest));
		    js.executeScript("arguments[0].scrollIntoView(true);", TestGo);
		 	TestGo.click();
		 	
		 	//Test Message
		 	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[placeholder='1 (702) 123-4567']"))).sendKeys("9980960647");
		 	//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[placeholder='Enter Order value']"))).sendKeys("good");
		 	js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//span[text()='Send Test Message']")));
		 	driver.findElement(By.xpath("//span[text()='Send Test Message']")).click();
		 	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Yes']"))).click();
		 	
		 	//schedule
		 	By immediate=By.xpath("//span[text()='Review And Launch']");
		 	WebElement immediatelyShoot=driver.findElement(immediate);
		 	  js.executeScript("arguments[0].scrollIntoView(true);", immediatelyShoot);
		 	wait.until(ExpectedConditions.visibilityOfElementLocated(immediate)).click();
		 	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Launch']"))).click();
		 	
		 	
		 Thread.sleep(5000);
		 	
			 Thread.sleep(7000);
		 }	
		  	} 
		 
