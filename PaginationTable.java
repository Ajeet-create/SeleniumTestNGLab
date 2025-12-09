package Lab11_TableDataHandling;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
Lab Exercise 3: Automating Pagination Table with Selenium
To automate the process of reading data from a dynamic pagination table and handle
navigation across multiple pages using Selenium WebDriver.
You are required to automate the following task:
1. Open the webpage:
https://practice.expandtesting.com/dynamic-pagination-table
2. Extract all student names from the first column of the table.
3. Keep navigating to the next page using the "Next" button until it is disabled.
4. While traversing, print each student’s name on the console.
 */

public class PaginationTable {
	
	
	 public static void main(String[] args) {

	        WebDriver driver = new ChromeDriver();
	        driver.manage().window().maximize();

	        // 1. Open webpage
	        driver.get("https://practice.expandtesting.com/dynamic-pagination-table");

	        while (true) {

	            // 2. Extract all student names from current page (1st column)
	            List<WebElement> studentNames =
	                    driver.findElements(By.xpath("//table[@id='students']/tbody/tr/td[1]"));

	            for (WebElement name : studentNames) {
	                System.out.println(name.getText());
	            }

	            // 3. Locate NEXT button
	            WebElement nextBtn = driver.findElement(By.xpath("//a[normalize-space()='Next']"));

	            // Check if NEXT button is disabled → break
	            if (!nextBtn.isEnabled() || nextBtn.getAttribute("class").contains("disabled")) {
	                break;
	            }

	            // 4. Click NEXT to go to next page
	            nextBtn.click();

	            // Small wait for table to load
	            try {
	                Thread.sleep(500);
	            } catch (InterruptedException e) {}
	        }

	        driver.quit();
	    }
	 
}
/*
 Output
 
 
 */
 