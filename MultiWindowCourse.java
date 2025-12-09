package Lab12_MultiWindowIntractions;

/*
Lab Exercise 2:
Write a Selenium program in Java to perform the following tasks:
1. Open the URL: https://rahulshettyacademy.com/angularpractice/
2. Open a new browser window.
3. In the new window, navigate to https://rahulshettyacademy.com/
4. Extract the name of the second course listed (from the links containing
'https://courses.rahulshettyacademy.com/p').
5. Switch back to the original window and locate the input field with the name
attribute name.
6. Enter the extracted course name into this input field.
7. Take a screenshot of only this input field and save it as logo.png in the project
directory.
8. Print the height and width of the input field in the console.
  
 */

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultiWindowCourse {

	public static void main(String[] args) throws IOException, InterruptedException {

		WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Step 1: Open main site
        driver.get("https://rahulshettyacademy.com/angularpractice/");

        // Store parent window ID
        String parentWindow = driver.getWindowHandle();

        // Step 2: Open new window
        driver.switchTo().newWindow(WindowType.WINDOW);

        // Step 3: Navigate to Rahul Shetty Academy
        driver.get("https://rahulshettyacademy.com/");

        // Step 4: Extract 2nd course name (links containing '/p')
        List<WebElement> courseLinks = driver.findElements(By.cssSelector("a[href*='/p']"));

        String courseName = courseLinks.get(1).getText();  // 2nd course
        System.out.println("Extracted Course Name: " + courseName);

        // Step 5: Switch back to parent window
        driver.switchTo().window(parentWindow);

        // Step 6: Locate name input field and enter course name
        WebElement nameField = driver.findElement(By.name("name"));
        nameField.sendKeys(courseName);

        // Step 7: Take screenshot of only the input field
        File src = nameField.getScreenshotAs(OutputType.FILE);
        File dest = new File("logo.png");
        Files.copy(src.toPath(), dest.toPath());
        System.out.println("Screenshot saved as logo.png");

        // Step 8: Print height and width
        int height = nameField.getSize().getHeight();
        int width = nameField.getSize().getWidth();

        System.out.println("Input Field Height: " + height);
        System.out.println("Input Field Width: " + width);

        Thread.sleep(3000);
        driver.quit();
		
		
	}

}
/* 
 Oyuput
 
Extracted Course Name: Practice
Screenshot saved as logo.png
Input Field Height: 38
Input Field Width: 1110
*/
