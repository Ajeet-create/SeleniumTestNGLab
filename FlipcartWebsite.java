package Lab8_Guru99.Com;

/*
Lab Exercise 3:
1. Launch the Flipkart website in a Chrome browser.
2. Handle the login popup (if it appears) by closing it.
3. Hover over the "Electronics" menu using the Actions class.
4. Perform a right-click (context-click) on "Electronics".
5. Locate the search bar and type "MOBILES" in uppercase using the Shift key.
 * */

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import java.time.Duration;

 class FlipcartWebsite {

	public static void main(String[] args) throws InterruptedException {


		        // Launch Chrome
		        WebDriver driver = new ChromeDriver();
		        driver.manage().window().maximize();
		        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		        // 1. Launch Flipkart website
		        driver.get("https://www.flipkart.com/");

		        // 2. Handle login popup (if appears)
		        try {
		            WebElement closeBtn = driver.findElement(By.xpath("//span[contains(text(),'✕')]"));
		            closeBtn.click();
		        } catch (Exception e) {
		            System.out.println("Login popup not displayed.");
		        }

		        // 3. Hover over "Electronics"
		        WebElement electronicsMenu = driver.findElement(By.xpath("//span[text()='Electronics']"));
		        Actions actions = new Actions(driver);
		        actions.moveToElement(electronicsMenu).perform();

		        // 4. Right-click (context-click) on Electronics
		        actions.contextClick(electronicsMenu).perform();

		        // 5. Type "MOBILES" using SHIFT key in search box
		        WebElement searchBar = driver.findElement(By.name("q"));
		        actions.click(searchBar)
		                .keyDown(Keys.SHIFT)
		                .sendKeys("mobiles")
		                .keyUp(Keys.SHIFT)
		                .perform();

		        Thread.sleep(5000);
		        driver.quit();
		    }
		

	}
 