package Lab9_SummingNValue;

/*
Lab Exercise 2:
Automating Scrolling on a Web Page using Selenium JavaScriptExecutor
Objective:
Learn how to use JavascriptExecutor in Selenium WebDriver to perform scrolling
operations such as scrolling down, scrolling to the bottom, and scrolling back to the top
of a web page.
Write a Selenium automation script using Java that performs the following tasks:
1. Launch the Chrome browser and maximize the window.
2. Navigate to the following website:
https://cosmocode.io/automation-practice-webtable/
3. Use JavascriptExecutor to:
○ Scroll down by 500 pixels.
○ Pause for 2 seconds.
○ Scroll to the bottom of the page.
○ Pause for 2 seconds.
○ Scroll back to the top of the page.
 */


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrollWithJavaScript {

	public static void main(String[] args) throws InterruptedException {

		 // 1. Launch the Chrome browser and maximize the window
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        try {
            // 2. Navigate to the website
            driver.get("https://cosmocode.io/automation-practice-webtable/");

            // 3. Create JavascriptExecutor reference
            JavascriptExecutor js = (JavascriptExecutor) driver;

            // Scroll down by 500 pixels
            js.executeScript("window.scrollBy(0, 500);");
            Thread.sleep(2000); // Pause for 2 seconds

            // Scroll to the bottom of the page
            js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
            Thread.sleep(2000); // Pause for 2 seconds

            // Scroll back to the top of the page
            js.executeScript("window.scrollTo(0, 0);");

        } finally {
            // Optional: Close the browser after a short pause to see final position
            Thread.sleep(4000);
            driver.quit();
        }
	}
}
/*
 Output
 
 
 */
 