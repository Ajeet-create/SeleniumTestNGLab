package Lab14_TestNGAnnotationAttribute;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class EcommerceTest {

	WebDriver driver;
	
	@BeforeClass
	public void lunchBroweser()
	{
		driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationpractice.com/index.php");
		System.out.println("Broweser launch and site opened..");
	}
	
	@Test(priority =1)
	public void printTitleAndUrl()
	{
		System.out.println("Title: " + driver.getTitle());
		System.out.println("URL: " + driver.getCurrentUrl());
	}
	
	@Test(priority = 2, dependsOnMethods = "printTitleAndUrl")
	public void printPageSourceLength()
	{
		System.out.println("Page source length: " + driver.getPageSource());
	}
	
	
	@Test(priority = 3, dependsOnMethods = "printPageSourceLength",enabled =false)
	public void checkSerchBox()
	{
		WebElement searchBox = driver.findElement(By.id("earch_query_top"));
		System.out.println("Search box displayed: " +searchBox.isDisplayed());
		
	}
	
	@AfterClass
	public void closeBroweser()
	{
		//driver.quit();
		System.out.println("Browser closed");
	}
	
}
