package campaigntest.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest4 {

    public WebDriver driver;
    public WebDriverWait wait;

    @BeforeClass
    public void setup() {

        System.setProperty("webdriver.edge.driver",
                "C:\\Users\\Divya\\Desktop\\eclipse folder\\driver\\msedgedriver.exe");
        

        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.get("https://staging.chat360.io/login");
        
    }
       
    
    public String getScreenshot(String testCaseName, WebDriver driver) throws IOException
    {
    	TakesScreenshot ts=(TakesScreenshot)driver;	
    File source= ts.getScreenshotAs(OutputType.FILE);
    File file=new File(System.getProperty("user.dir") + "//reports/" + testCaseName + ".png");
    FileUtils.copyFile(source,file);
    return System.getProperty("user.dir") + "//reports/" + testCaseName + ".png";
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}