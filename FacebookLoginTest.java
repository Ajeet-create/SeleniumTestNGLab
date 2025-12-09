package Lab20_FacebookLogin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FacebookLoginTest {
	
	
	@Test
	 public void testFacebookLogin() {

	        WebDriver driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.get("https://www.facebook.com/");

	        FacebookLoginPage fb = new FacebookLoginPage(driver);

	        fb.login("monu399@gmail.com", "ajeet143");
	        fb.clickLogin();
	        Assert.assertTrue(driver.getCurrentUrl().contains("Facebook"));

	        driver.quit();
	    }

}
