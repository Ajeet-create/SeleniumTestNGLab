package Lab13_TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class snapdeel {

	WebDriver driver;
	
	@BeforeMethod
	void loadDriver()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.snapdeal.com/");
	}
	@Test
	void Test1()
	{
		String title = driver.getTitle();
		System.out.println("Title of the Website: " +title);
		String currentURL = driver.getCurrentUrl();
		System.out.println("Current URL: " + currentURL);
		
	}
	@Test
	void Test2()
	{
		WebElement searchBox = driver.findElement(By.id("inputValEnter"));
		boolean isDisplayed = searchBox.isDisplayed();
		boolean isEnabled =searchBox.isEnabled();
		System.out.println("Search box displayed: " + isDisplayed);
		System.out.println("Search box enabled: " + isEnabled);
		
		Assert.assertTrue(isDisplayed, "Search box is not displayed");
		Assert.assertTrue(isEnabled, "Search box is not enabled");
		
	}

	@AfterMethod
	void closedDriver()
	{
		driver.quit();
	}
	
}
