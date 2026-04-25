package templates.pageobjects;


	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;

	public class loginPage {

	    WebDriver driver;

	    public loginPage(WebDriver driver) {
	        this.driver = driver;
	    }

	    By email = By.name("email");
	    By password = By.name("password");
	    By loginBtn = By.cssSelector("button[type='submit']");

	    public void login(String userEmail, String userPassword) {
	        driver.findElement(email).sendKeys(userEmail);
	        driver.findElement(password).sendKeys(userPassword);
	        driver.findElement(loginBtn).click();
	    }
	}
