package Lab10_ScreenshotCapture;

/*
Lab Exercise 2: Detecting Broken Links on a Webpage Using Selenium and
Java
Objective:
To develop a Java program using Selenium WebDriver to detect and report broken
hyperlinks on a given webpage by checking the HTTP response code of each link.
Write a Java program that:
1. Launches a web browser and navigates to a http://the-internet.herokuapp.com.
2. Fetches all <a> (anchor) tags from the page.
3. Extracts the href attribute from each anchor tag.
4. Checks the HTTP response code for each link using HttpURLConnection.
5. Prints whether the link is valid or broken based on the response code.
6. Displays the total number of broken links on the webpage.
 
  */

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrockenLink {

	public static void main(String[] args) {

		
        // 1️⃣ Launch browser
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // 2️⃣ Navigate to webpage
        driver.get("http://the-internet.herokuapp.com");

        // 3️⃣ Fetch all anchor tags <a>
        List<WebElement> allLinks = driver.findElements(By.tagName("a"));

        System.out.println("Total links found: " + allLinks.size());
        int brokenLinksCount = 0;

        // 4️⃣ Loop through each link
        for (WebElement link : allLinks) {

            String url = link.getAttribute("href");

            // Skip null or empty links
            if (url == null || url.isEmpty()) {
                System.out.println("Skipping empty or null link...");
                continue;
            }

            try {
                // 5️⃣ Create URL object
                URL linkUrl = new URL(url);

                // Open connection
                HttpURLConnection connection = (HttpURLConnection) linkUrl.openConnection();
                connection.setRequestMethod("HEAD");
                connection.connect();

                int responseCode = connection.getResponseCode();

                // 6️⃣ Print result
                if (responseCode >= 400) {
                    System.out.println(url + " --> ❌ Broken Link (Response Code: " + responseCode + ")");
                    brokenLinksCount++;
                } else {
                    System.out.println(url + " --> ✔ Valid Link (Response Code: " + responseCode + ")");
                }

            } catch (Exception e) {
                System.out.println(url + " --> ❌ Exception occurred, marked as broken.");
                brokenLinksCount++;
            }
        }

        // Final Report
        System.out.println("\n======================================");
        System.out.println("Total Broken Links Found: " + brokenLinksCount);
        System.out.println("======================================");

        driver.quit();
    }

}
/*
 Output
 
Total links found: 46
https://github.com/tourdedave/the-internet --> ✔ Valid Link (Response Code: 200)
https://the-internet.herokuapp.com/abtest --> ✔ Valid Link (Response Code: 200)
https://the-internet.herokuapp.com/add_remove_elements/ --> ✔ Valid Link (Response Code: 200)
https://the-internet.herokuapp.com/basic_auth --> ❌ Broken Link (Response Code: 401)
https://the-internet.herokuapp.com/broken_images --> ✔ Valid Link (Response Code: 200)
https://the-internet.herokuapp.com/challenging_dom --> ✔ Valid Link (Response Code: 200)
https://the-internet.herokuapp.com/checkboxes --> ✔ Valid Link (Response Code: 200)
https://the-internet.herokuapp.com/context_menu --> ✔ Valid Link (Response Code: 200)
https://the-internet.herokuapp.com/digest_auth --> ❌ Broken Link (Response Code: 401)
https://the-internet.herokuapp.com/disappearing_elements --> ✔ Valid Link (Response Code: 200)
https://the-internet.herokuapp.com/drag_and_drop --> ✔ Valid Link (Response Code: 200)
https://the-internet.herokuapp.com/dropdown --> ✔ Valid Link (Response Code: 200)
https://the-internet.herokuapp.com/dynamic_content --> ✔ Valid Link (Response Code: 200)
https://the-internet.herokuapp.com/dynamic_controls --> ✔ Valid Link (Response Code: 200)
https://the-internet.herokuapp.com/dynamic_loading --> ✔ Valid Link (Response Code: 200)
https://the-internet.herokuapp.com/entry_ad --> ✔ Valid Link (Response Code: 200)
https://the-internet.herokuapp.com/exit_intent --> ✔ Valid Link (Response Code: 200)
https://the-internet.herokuapp.com/download --> ✔ Valid Link (Response Code: 200)
https://the-internet.herokuapp.com/upload --> ✔ Valid Link (Response Code: 200)
https://the-internet.herokuapp.com/floating_menu --> ✔ Valid Link (Response Code: 200)
https://the-internet.herokuapp.com/forgot_password --> ✔ Valid Link (Response Code: 200)
https://the-internet.herokuapp.com/login --> ✔ Valid Link (Response Code: 200)
https://the-internet.herokuapp.com/frames --> ✔ Valid Link (Response Code: 200)
https://the-internet.herokuapp.com/geolocation --> ✔ Valid Link (Response Code: 200)
https://the-internet.herokuapp.com/horizontal_slider --> ✔ Valid Link (Response Code: 200)
https://the-internet.herokuapp.com/hovers --> ✔ Valid Link (Response Code: 200)
https://the-internet.herokuapp.com/infinite_scroll --> ✔ Valid Link (Response Code: 200)
https://the-internet.herokuapp.com/inputs --> ✔ Valid Link (Response Code: 200)
Skipping empty or null link...
 */
