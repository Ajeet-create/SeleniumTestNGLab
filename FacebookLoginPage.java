package Lab20_FacebookLogin;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
Lab Exercise 1: Create Page Class Using POM (Facebook Login)
Objective:
Implement a FacebookLoginPage class using PageFactory and @FindBy.
Steps:
1. Open your IDE and create a new Java class: FacebookLoginPage.
2. Use @FindBy to locate the following elements on https://www.facebook.com:
o Email or phone number field (id = "email")
o Password field (id = "pass")
o Login button (name = "login")
3. Add the following methods:
o enterUsername(String username)
o enterPassword(String password)
o clickLogin()
o login(String username, String password)
*/

public class FacebookLoginPage {
	
	WebDriver driver;
	//WebDriverWait wait;
	
	 public FacebookLoginPage(WebDriver driver){
		
		 this.driver = driver;
		 
	    // PageFactory.initElements(driver, this);
	        
	    // wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    }

	    // Locate elements using @FindBy

	    @FindBy(id = "email")
	    private WebElement emailField;

	    @FindBy(id = "pass")
	    private WebElement passwordField;

	    @FindBy(name = "login")
	    private WebElement loginButton;

	    // Step 3: Methods

	    public void enterUsername(String username) {
	        emailField.clear();
	        emailField.sendKeys(username);
	    }

	    public void enterPassword(String password) {
	        passwordField.clear();
	        passwordField.sendKeys(password);
	    }

	    public void clickLogin() {
	    
	    	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	    	wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
	        ///loginButton.click();
	    }

	    // Combined login method
	    public void login(String username, String password) {
	        enterUsername(username);
	        enterPassword(password);
	        clickLogin();
	    }
	}
