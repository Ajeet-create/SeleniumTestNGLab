package Lab7_LoginMyntra;

/*
 Lab Exercise 3:
Open the Chrome browser.
● https://aln.anudip.org/login/index.php.
● Enter incorrect login credentials.
● Click on the login button.
● Use Fluent Wait to check if the error message appears.
● Extract and print the error message.
● Close the browser.
*/
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PracticTestLogin {

	public static void main(String[] args) {

		        WebDriver driver = new ChromeDriver();

		        // Set implicit wait
		        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		        driver.manage().window().maximize();

		        driver.get("https://practicetestautomation.com/practice-test-login/");

		        WebElement usernameField = driver.findElement(By.id("username"));
		        usernameField.sendKeys("student");

		        WebElement passwordField = driver.findElement(By.id("password"));
		        passwordField.sendKeys("Password123");

		        WebElement submitButton = driver.findElement(By.id("submit"));
		        submitButton.click();

		        // Verify if login is successful by checking the success message
		        WebElement successMessage = driver.findElement(By.className("post-title"));
		        String messageText = successMessage.getText();

		        // Print the success message in the console
		        System.out.println("Login success message: " + messageText);

		        driver.quit();
		    }
		

		
	}


