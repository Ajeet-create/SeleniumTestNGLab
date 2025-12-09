package Lab3_Login;
/*
 Lab Exercise 1:
Task:
1. Open https://www.google.com.
2. Locate the Search Box using Name locator and enter a search term (Selenium
WebDriver).
3. Locate and click the Google Search button.
4. Print all search result titles on the first page.

 */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Lab3 {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.findElement(By.id("APjFqb")).sendKeys("Selenium WebDriver");
		driver.findElement(By.className("gNO89b")).submit();
		
	}

}
 