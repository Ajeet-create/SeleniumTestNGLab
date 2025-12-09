package Lab9_SummingNValue;

/*
Lab Exercise 3: Web Page Link Analyzer using Selenium
Objective:
Create a Java Selenium program that automates a browser to analyze hyperlinks in a
webpage. The goal is to:
● Use Selenium WebDriver with ChromeDriver.
● Open the following URL:
https://practice.expandtesting.com/tables
● Find and print the total number of <a> (hyperlink) elements on the entire page.
● Locate the <header> tag and count how many <a> tags are present in that
section only.
● Display the text content of each header link (if it has any).
 */


import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebPageLinkAnalyzer {
	
	
	public static void main(String[] args) {

        // Launch Chrome browser and maximize
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        try {
            // Navigate to the website
            driver.get("https://practice.expandtesting.com/tables");

            // 1. Find and print total number of <a> elements on entire page
            List<WebElement> allLinks = driver.findElements(By.tagName("a"));
            System.out.println("Total number of hyperlinks on page: " + allLinks.size());

            // 2. Locate <header> tag
            WebElement header = driver.findElement(By.tagName("header"));

            // 3. Count <a> tags in header section only
            List<WebElement> headerLinks = header.findElements(By.tagName("a"));
            System.out.println("Number of links in header: " + headerLinks.size());

            // 4. Display text content of each header link
            System.out.println("Header link texts:");
            for (WebElement link : headerLinks) {
                String linkText = link.getText().trim();
                if (!linkText.isEmpty()) {
                    System.out.println("- " + linkText);
                }
            }

        } finally {
            driver.quit();
        }
    }	

}
/*
 Output
 
Total number of hyperlinks on page: 33
Number of links in header: 13
Header link texts:
- Practice
- Demos
- Tools
- Tips
- Test Cases
- API Testing
- About
- Free ISTQB Mock Exams
 */
