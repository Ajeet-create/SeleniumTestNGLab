package Lab3_Login;
/*
 Lab Exercise 2:
Task:
1. Open https://practicetestautomation.com/practice-test-login/.
2. Locate the Username field using the ID locator and enter "student".
3. Locate the Password field using Name locator and enter "Password123".
4. Click the Login button using the Class Name locator.
5. Validate that the user is successfully logged in by checking the success
message.
 */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LabEx3{

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://practicetestautomation.com/practice-test-login/");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("student");
		driver.findElement(By.name("password")).sendKeys("Password123");
		driver.findElement(By.className("btn")).click();
		
		WebElement successMassage = driver.findElement(By.tagName("body"));
		if(successMassage.getText().contains("Logged In Successfully"))
		{
			System.out.println("Login Test Passed!");
		}
		else {
			System.out.println("Login Test Failed!");
		}
	}

}
 