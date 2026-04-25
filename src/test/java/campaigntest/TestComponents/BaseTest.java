package campaigntest.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import templates.resources.ExtentReporterNG;



public class BaseTest {

    public WebDriver driver;
    public WebDriverWait wait;

    public static ExtentReports extent =
            ExtentReporterNG.getReportObject();

    public static ThreadLocal<ExtentTest> test =
            new ThreadLocal<>();


    // =============================
    // BEFORE EACH TEST
    // =============================
    @BeforeMethod
    public void setup(Method method) {

        System.setProperty("webdriver.edge.driver",
                "C:\\Users\\Divya\\Desktop\\eclipse folder\\driver\\msedgedriver.exe");

        driver = new EdgeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(10));

        wait = new WebDriverWait(driver,
                Duration.ofSeconds(15));

        driver.get("https://staging.chat360.io/login");

        // ✅ Create Extent Test HERE
        ExtentTest extentTest =
                extent.createTest(method.getName());

        test.set(extentTest);
    }


    // =============================
    // SCREENSHOT
    // =============================
    public String getScreenshot(String testName)
            throws IOException {

        System.out.println("Screenshot Method Called");

        TakesScreenshot ts =
                (TakesScreenshot) driver;

        File source =
                ts.getScreenshotAs(OutputType.FILE);

        String path =
                System.getProperty("user.dir")
                        + "/reports/screenshots/";

        new File(path).mkdirs();

        String finalPath =
                path + testName + ".png";

        FileUtils.copyFile(source,
                new File(finalPath));

        return finalPath;
    }


    // =============================
    // RESULT HANDLER
    // =============================
    @AfterMethod
    public void tearDown(ITestResult result)
            throws IOException {

        if (result.getStatus()
                == ITestResult.FAILURE) {

            test.get().fail(result.getThrowable());

            String screenshot =
                    getScreenshot(
                            result.getMethod()
                                    .getMethodName());

            test.get()
                    .addScreenCaptureFromPath(screenshot);
        }

        else if (result.getStatus()
                == ITestResult.SUCCESS) {

            test.get().pass("Test Passed");
        }

        driver.quit(); // ✅ close per test
    }


    // =============================
    // FINAL REPORT WRITE
    // =============================
    @AfterSuite
    public void flushReport() {

        extent.flush();
    }
    
    
}