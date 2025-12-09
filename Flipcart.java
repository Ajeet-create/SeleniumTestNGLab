package Lab13_TestNG;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Flipcart {

	WebDriver driver ;
	
	@BeforeClass
	void loadedDriver()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		
	
		try {
			WebElement closeBtn = driver.findElement(By.cssSelector("input[placeholder='Search for Products, Brands and More']"));
			if(closeBtn.isDisplayed())
			{
				closeBtn.click();
			}
		}
		catch(Exception e)
		{
			System.out.println("Login popup not displayed");
		}
}
	
	@Test
	void Test1()
	{
		String title = driver.getTitle();
		System.out.println("Website Title: " +title);
		
	}
	
	@Test
	void Test2()
	{
		@Nullable
		String currentUrl = driver.getCurrentUrl();
		System.out.println("Current URL: " +currentUrl);
		
	}
	
	@Test
	void Test3()
	{
		WebElement SearchBox = driver.findElement(By.name("q"));
		Assert.assertTrue(SearchBox.isDisplayed(), "Search Box is Not displayed");
		Assert.assertTrue(SearchBox.isEnabled(), "Search Box is displayed and Enabled");
		
	}
	
	@Test
	void Test4()
	{
		WebElement SearchBox = driver.findElement(By.name("q"));
		SearchBox.sendKeys("Laptops");
		SearchBox.submit();
		System.out.println("Search for Laptops submitted");
		
	}
	
	@AfterClass
	void closeBroweser()
	{
		driver.quit();
	}
}
