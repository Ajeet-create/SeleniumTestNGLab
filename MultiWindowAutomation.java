package Lab12_MultiWindowIntractions;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

/*
Lab Exercise 1:
Automating Multi-Window Interaction with Google Translate and Wikipedia Using
Selenium
To automate a real-time interaction between two different browser windows using
Selenium WebDriver:
● Open Wikipedia,("https://www.wikipedia.org) extract a specific text
● Paste the extracted text into the Google Translate("https://translate.google.com")
input box
● Take a screenshot of the input box and print its height and width
*/

public class MultiWindowAutomation {

	public static void main(String[] args) throws IOException, InterruptedException {

	 
		
		 WebDriver driver = new ChromeDriver();
	        driver.manage().window().maximize();

	        // Step 1: Open Wikipedia
	        driver.get("https://www.wikipedia.org");

	        // Extract specific text (Example: The heading below the logo)
	        WebElement extractText = driver.findElement(By.cssSelector("strong"));
	        String text = extractText.getText();
	        System.out.println("Extracted Text: " + text);

	        // Step 2: Open Google Translate in new window
	        driver.switchTo().newWindow(WindowType.WINDOW);
	        driver.get("https://translate.google.com");

	        // Step 3: Paste extracted text in Google Translate input box
	        WebElement inputBox = driver.findElement(By.xpath("//textarea[@aria-label='Source text']"));
	        inputBox.sendKeys(text);

	        // Step 4: Take screenshot of input box
	        File src = inputBox.getScreenshotAs(OutputType.FILE);
	        File dest = new File("translate_inputbox.png");
	        Files.copy(src.toPath(), dest.toPath());
	        System.out.println("Screenshot saved as translate_inputbox.png");

	        // Step 5: Print height and width
	        int height = inputBox.getSize().getHeight();
	        int width = inputBox.getSize().getWidth();

	        System.out.println("Input Box Height: " + height);
	        System.out.println("Input Box Width: " + width);

	        // Optional: Close browser
	        Thread.sleep(3000);
	        driver.quit();
	    }
}
/*
Output

Extracted Text: The Free Encyclopedia
Screenshot saved as translate_inputbox.png
Input Box Height: 32
Input Box Width: 566

 */		
		
		
		
	
