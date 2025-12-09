package Lab8_Guru99.Com;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
📘 Lab Exercise 1:
Lab Steps:
Step 1: Set Up WebDriver and Open Guru99’s popup demo
"https://demo.guru99.com/popup.php"
Step 2: Identify the Parent Window
Step 3: Click the Link to Open a Child Window
Step 4: Switch to the Child Window
Step 5: Perform Actions in the Child Window and get title of window
Step 6: Switch Back to the Parent Window
Print the parent window’s title to verify the switch was successful 
*/

public class Guru99Demo {

	public static void main(String[] args) throws InterruptedException  {

            WebDriver driver =new ChromeDriver();
            driver.manage().window().maximize();
		
       		driver.get("https://demo.guru99.com/popup.php");
		
       		String parentWindow = driver.getWindowHandle();
       		System.out.println("Parent Window Title: " +driver.getTitle());
       		
       		WebElement link = driver.findElement(By.xpath("//a[normalize-space()='Click Here']"));
       		link.click();
       		Thread.sleep(3000);
       		
       		Set<String> windows = driver.getWindowHandles();
       		
       		if(windows.size() <2)
       		{
       			System.out.println("chiled window did not open. Exiting.");
       			driver.quit();
       			return;
       		}
       		
       		Iterator<String> iterator = windows.iterator();
       		String parentID = iterator.next();
       		String childID = iterator.next();
       		
       		driver.switchTo().window(childID);
       		System.out.println("child window Title: " +driver.getTitle());
       		driver.close();
       		
       		driver.switchTo().window(parentID);
       		System.out.println("Back to Parent window Title: "+driver.getTitle());
      
       		
		}
		
	}


