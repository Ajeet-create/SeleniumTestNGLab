package Lab13_TestNG;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Amazon {
	
	WebDriver driver = null;
	
	@BeforeClass
	void loadDriver()
	{
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		System.out.println("Driver loaded....");
		
	}
	@Test
	void Test1()
	{
		String title = driver.getTitle();
		System.out.println("Title of the Website; " +title);
		Assert.assertTrue(title.contains("Amazon"), "Title validation faield!");
	}
	@Test
	void Test2()
	{
		@Nullable
		String CurrentURL= driver.getCurrentUrl();
		System.out.println("Current URL: " + CurrentURL);
		Assert.assertEquals(CurrentURL, "https://www.amazon.in/", "URL validation faield!");
		
	} 
	
	@AfterClass
	void closedDriver()
	{
		driver.quit();
		System.out.println("Driver closed....");
	}

}
