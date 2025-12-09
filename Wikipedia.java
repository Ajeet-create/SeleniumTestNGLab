package Lab4_Navigation;
/*
Lab Exercise 3:
In this lab, you will automate a login process using CSS selectors in Selenium
WebDriver. You will locate elements based on different CSS selector strategies, such as
matching attributes with ^, *, and $.
1. Open a browser and navigate to the Wikipedia login page.
2. Locate the username and password fields using CSS selectors.
3. Enter credentials into the fields.
4. Locate and click the login button using CSS selectors.
5. Verify if the login was successful by checking the current URL
 * */
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Wikipedia {

	public static void main(String[] args) {


   	 WebDriver driver = new ChromeDriver();
        
        try {
            driver.get("https://en.wikipedia.org/w/index.php?title=Special:UserLogin");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            
            WebElement usernameField = driver.findElement(By.cssSelector("input[id^='wpName']"));
            WebElement passwordField = driver.findElement(By.cssSelector("input[id*='wpPassword']"));
            WebElement loginButton = driver.findElement(By.cssSelector("button[id$='wpLoginAttempt']"));
            
            usernameField.sendKeys("testuser");
            passwordField.sendKeys("password123");
            loginButton.click();
            
            Thread.sleep(5000);
            
            if (driver.getCurrentUrl().contains("UserLoginSuccess")) {
                System.out.println("Login Successful!");
            } else {
                System.out.println("Login Failed! Check credentials.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
         //   driver.quit();
        }
   }

}
