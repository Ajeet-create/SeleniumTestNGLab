package Lab10_ScreenshotCapture;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
Lab Exercise 1: Automating Screenshot Capture Using Selenium
Objective:
To open a specific website using Selenium WebDriver and take a screenshot
1. Setup Selenium in your project.
2. Launch the browser and open a given website (e.g., https://www.wikipedia.org).
3. Capture a screenshot.
4. Save it to a specified location (e.g., D://screenshot.png).
*/
public class ScreenshotCapture {

	public static void main(String[] args) throws Exception {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        try {
            driver.get("https://www.wikipedia.org");

            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);

            Path destination = Path.of("D:/screenshot.png");
            Files.copy(sourceFile.toPath(), destination);

            System.out.println("Screenshot saved to: " + destination);
        } catch (Exception e) {
            System.out.println("Error taking screenshot: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}
/*
 Output
 Screenshot saved to: D:\screenshot.png
 */