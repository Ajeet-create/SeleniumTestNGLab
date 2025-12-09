package Lab1_Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LabExercise2 {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://practicetestautomation.com/practice-test-login/");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("student");
		driver.findElement(By.name("password")).sendKeys("Password123");
		driver.findElement(By.id("submit")).click();
		
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
