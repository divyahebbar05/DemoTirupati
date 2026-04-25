package campaigntest.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest2 {
	

	    public WebDriver driver;
	    public WebDriverWait wait;

	    // ✅ Reusable Driver Initialization
	    public WebDriver initializeDriver() throws IOException {

	        Properties prop = new Properties();
	        FileInputStream fis = new FileInputStream(
	        System.getProperty("user.dir") + "//src//main//java//templates//resources//GlobalData.properties");

	        prop.load(fis);

	        String browserName = System.getProperty("browser") != null
	                ? System.getProperty("browser")
	                : prop.getProperty("browser"); 

	        if (browserName.contains("chrome")) {
	        	ChromeOptions options=new ChromeOptions();
	        	WebDriverManager.chromedriver().setup();
	        	if(browserName.contains("headless"))
	        	{
	        		options.addArguments("headless");
	        	}
	          
	            driver = new ChromeDriver(options);
	            driver.manage().window().setSize(new Dimension(1440,900)); //to run in fullscreen
	        } 
	        
	        
	//in jenkins change edgeheadless, in global properties edgeheadless/chromeheadless, in dropdown select edgeheadless-3 side need to change it as headless          
	        
	        else if (browserName.contains("edgeheadless")) {
	            System.setProperty("webdriver.edge.driver", "C:\\Users\\Divya\\Desktop\\eclipse folder\\driver\\msedgedriver.exe");
	            driver = new EdgeDriver(); 
	            
	            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		        driver.manage().window().maximize();
	        }
			return driver;
	    }
	        
	        
	    /*    if (browserName.equalsIgnoreCase("chromeheadless")) {
	            driver = new ChromeDriver();
	        } 
	       
	            
	            else if (browserName.equalsIgnoreCase("edge")) {
	               // WebDriverManager.edgedriver().clearDriverCache().setup();
	            	System.setProperty("webdriver.edge.driver", "C:\\Users\\Divya\\Desktop\\eclipse folder\\driver\\msedgedriver.exe");
	                driver = new EdgeDriver();          
	        } 

	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        driver.manage().window().maximize();

	       return driver;
	} */

	    // ✅ Setup using initializeDriver()
	    @BeforeClass
	    public void setup() throws IOException {

	        driver = initializeDriver();   // 🔥 Main change here
	        wait = new WebDriverWait(driver, Duration.ofSeconds(15));

	        driver.get("https://staging.chat360.io/login");
	    }

	    // ✅ Screenshot method (unchanged)
	    public String getScreenshot(String testCaseName, WebDriver driver) throws IOException {
	        TakesScreenshot ts = (TakesScreenshot) driver;
	        File source = ts.getScreenshotAs(OutputType.FILE);
	        File file = new File(System.getProperty("user.dir") + "//reports/" + testCaseName + ".png");
	        FileUtils.copyFile(source, file);
	        return System.getProperty("user.dir") + "//reports/" + testCaseName + ".png";
	    }

	    @AfterClass
	    public void tearDown() {
	        driver.quit();
	    }
	}


