package Lab7_LoginMyntra;

/*Lab Exercise 2:
Write a Java program using explicit wait that does the following:
● Open the Myntra website in a browser.
● Maximize the browser window.
● Locate the search bar and enter "Shoes".
● Wait for the search suggestions to appear*/
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyntraSearchDemo {

	public static void main(String[] args) {

		 WebDriver driver = new ChromeDriver();
	        // Open Myntra website
	        driver.get("https://www.myntra.com/");

	        // Maximize window
	        driver.manage().window().maximize();

	        // Locate the search bar and enter "Shoes"
	        WebElement searchBar = driver.findElement(By.xpath("//input[@placeholder='Search for products, brands and more']"));
	        searchBar.sendKeys("Shoes");

	        WebElement shoesForMen = driver.findElement(By.xpath("//li[normalize-space()='Shoes For Men']"));
	        
	        Actions shoes = new Actions(driver);
	        
	        shoes.moveToElement(shoesForMen).moveToElement(searchBar).click().build().perform();


	        System.out.println("Search suggestions appeared.");

	        // Close browser
	       // driver.quit();
		
	}

}
