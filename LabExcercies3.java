package Lab5_CheckBoxAlertBox;
/*
Lab Exercise 3:
1. Launch the Chrome browser and navigate to
https://testpages.eviltester.com/styled/alerts/alert-test.html.
2. Click on the "Show Alert Box" button, capture the alert text, and accept it.
3. Click on the "Show Confirm Box" button, capture the alert text, and dismiss it.
4. Click on the "Show Prompt Box" button, capture the alert text, enter "Selenium
Test", and accept it.
5. Print the alert messages to the console.
 * */
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LabExcercies3 {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Implicit wait
        driver.get("https://testpages.eviltester.com/styled/alerts/alert-test.html");
        driver.manage().window().maximize();

        // Handle Simple Alert
        WebElement alertButton = driver.findElement(By.id("alertexamples"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", alertButton);
        alertButton.click();
        Thread.sleep(2000); // Static wait
        Alert simpleAlert = driver.switchTo().alert();
        System.out.println("Simple Alert Message: " + simpleAlert.getText());
        simpleAlert.accept();
        System.out.println("Simple Alert handled!\n");

        Thread.sleep(2000);

        // Handle Confirmation Alert
        WebElement confirmButton = driver.findElement(By.id("confirmexample"));
        confirmButton.click();
        Thread.sleep(2000);
        Alert confirmAlert = driver.switchTo().alert();
        System.out.println("Confirmation Alert Message: " + confirmAlert.getText());
        confirmAlert.dismiss(); // Clicking 'Cancel'
        System.out.println("Confirmation Alert dismissed!\n");

        Thread.sleep(2000);

        // Handle Prompt Alert (Entering text before accepting)
        WebElement promptButton = driver.findElement(By.id("promptexample"));
        promptButton.click();
        Thread.sleep(2000);
        Alert promptAlert = driver.switchTo().alert();
        System.out.println("Prompt Alert Message: " + promptAlert.getText());
        promptAlert.sendKeys("Selenium Test"); // Entering text in the alert
        promptAlert.accept(); // Clicking 'OK'
        System.out.println("Prompt Alert handled with user input!\n");
   
	}

}
