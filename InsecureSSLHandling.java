package Lab10_ScreenshotCapture;

/*
Lab Exercise 3: Handling Insecure SSL Certificates using Selenium WebDriver
Objective:
To write a Java program using Selenium WebDriver to open a web page
https://untrusted-root.badssl.com/ with an insecure SSL certificate and retrieve its title.
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class InsecureSSLHandling {

    public static void main(String[] args) {

        // 1️⃣ Create ChromeOptions to accept insecure certificates
        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);   // Important

        // 2️⃣ Launch Chrome with options
        WebDriver driver = new ChromeDriver(options);

        driver.manage().window().maximize();

        // 3️⃣ Open the insecure SSL page
        driver.get("https://untrusted-root.badssl.com/");

        // 4️⃣ Retrieve and print the page title
        String title = driver.getTitle();
        System.out.println("Page Title is: " + title);

        // 5️⃣ Close browser
        driver.quit();
    }
	
}
/*
Output
Page Title is: untrusted-root.badssl.com

*/
