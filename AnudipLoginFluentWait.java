package Lab7_LoginMyntra;

/*
ab Exercise 1:
Write a Selenium WebDriver script using Java to automate the login functionality
of the given website:
URL: https://learn.anudip.org/login/index.php
● Open the login page using Chrome browser.
● Enter the username "student" and password "Password123" in their respective
fields.
● Click the "Submit" button.
● Verify if the login is successful by checking for a success message on the page.
● Print the success message in the console.
● Use implicit wait for this program.*/

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class AnudipLoginFluentWait {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver ();
		driver.manage().window().maximize();
		
		driver.get("https://learn.anudip.org/login/index.php");
		driver.findElement(By.id("username")).sendKeys("AF049911332");
        driver.findElement(By.id("password")).sendKeys("aj3123");
        driver.findElement(By.id("loginbtn")).click();
        
      //Fluent Wait declaration
      		Wait<WebDriver> mywait = new FluentWait<WebDriver>(driver)
      				.withTimeout(Duration.ofSeconds(30))
      				.pollingEvery(Duration.ofSeconds(5))
      				.ignoring(NoSuchElementException.class);
      		
			WebElement errorBox = mywait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[role='alert']")));
      		errorBox.getText();
      		System.out.println("Login error massage: "+errorBox);
      		
      		driver.quit();
      	
	
	}

}
