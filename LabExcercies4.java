package Lab5_CheckBoxAlertBox;

/*
 Lab Exercise 4:
Open the Selenium Web Form web page:
https://www.selenium.dev/selenium/web/web-form.html.
Locate the dropdown element on the page.
Select options from the dropdown using the following methods:
● By index (Select the third option).
● By value (Select the option with value "2").
● By visible text (Select the option labeled "Two").
Print the selected option after each selection
 * */

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class LabExcercies4 {

	public static void main(String[] args) {

		
		  WebDriver driver = new ChromeDriver();
          driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
          
          try {
              // Open a demo flight booking webpage
              driver.get("https://www.selenium.dev/selenium/web/web-form.html");
              driver.manage().window().maximize();

              // Locate the dropdown element
              WebElement dropdownElement = driver.findElement(By.name("my-select"));

              // Create a Select object
              Select dropdown = new Select(dropdownElement);

              // Select option by index
              dropdown.selectByIndex(2);
              System.out.println("Selected by Index: " + dropdown.getFirstSelectedOption().getText());
              Thread.sleep(2000);

              // Select option by value
              dropdown.selectByValue("2");
              System.out.println("Selected by Value: " + dropdown.getFirstSelectedOption().getText());
              Thread.sleep(2000);

              // Select option by visible text
              dropdown.selectByVisibleText("Two");
              System.out.println("Selected by Visible Text: " + dropdown.getFirstSelectedOption().getText());
              Thread.sleep(2000);

          } catch (Exception e) {
              e.printStackTrace();
          } finally {
          //    driver.quit();
          }
    }
	

}
