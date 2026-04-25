package templates.AbstractComponents;


import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class abstractComponents {


		
			WebDriver driver;
			public abstractComponents(WebDriver driver)
			
			{
				super();
				this.driver=driver;
				PageFactory.initElements(driver, this);
			}
			
			By results= By.xpath("//section[contains(@class,'ta-results')]");
			
			public void waitForWebElementToAppear(By findBy)
			{
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
			
			}
			
			public void waitForWebElementToAppear1(WebElement findBy)
			{
				WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
				 wait.until(ExpectedConditions.visibilityOf(findBy));
		}
			
			
			
			public void waitForWebElementToAppear2(WebElement element)
			{
				WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
				wait.until(ExpectedConditions.visibilityOf(element));
		}
			
			public WebElement waitForWebElementToAppear3(By findBy)
			{
			    WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
			    return wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
			}
			
			public void waitForWebElementTodisppear(By findBy)
			{
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
			
			}
			
			public void waitForWebElementTodisppear1(WebElement findBy)
			{
				WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
				wait.until(ExpectedConditions.visibilityOf(findBy));
		}
			
			
			
			public void waitForWebElementTodisppear2(WebElement element)
			{
				WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
				wait.until(ExpectedConditions.visibilityOf(element));
		}
			public WebElement waitForElementToBeClickable(By findBy) {
				WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
			     return wait.until(ExpectedConditions.elementToBeClickable(findBy));
			}
			
			public List<WebElement> waitForNumberOfElementsToBeMoreThan(By locator, int number) {
			    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			    return wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(locator, number));
			}
			
			// abstractComponents.java

			public void waitForElementToBeClickableAfterRefresh(By locator) {
				  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			    wait.until(ExpectedConditions.refreshed(
			            ExpectedConditions.elementToBeClickable(locator)
			    ));
			}


	}


