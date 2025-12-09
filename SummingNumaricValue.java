package Lab9_SummingNValue;
/*
 Day 9 - LAB

Lab Exercise 1:
Extracting and Summing Numeric Values from a Web Table using Selenium
WebDriver
Objective:
Automate the process of navigating to a web page, locating a table, extracting numeric
values from a specific column, and calculating the total sum using Selenium WebDriver
in Java.
Write a Selenium automation script using Java that performs the following tasks:
1. Launch the Chrome browser and maximize the window.
2. Navigate to the following website:
https://practice.expandtesting.com/tables
3. Locate the table on the page with the id="table1".
4. Read all rows of the table.
5. Extract the numeric values from the "Due" column (4th column).
6. Remove the $ symbol and convert the values to double.
7. Compute the total sum of all the values in the "Due" column.
8. Print the result in the format:
"Total Due Amount: $<sum>"
 
 */
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SummingNumaricValue {

	public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        try {
        	
            driver.get("https://practice.expandtesting.com/tables");

            // Locate the table with id="table1"
            WebElement table = driver.findElement(By.id("table1"));

            // Read all rows of the table body
            List<WebElement> rows = table.findElements(By.xpath(".//tbody/tr"));

            double totalDue = 0.0;

            // Extract numeric values from the "Due" column (4th column)
            for (WebElement row : rows) {
                WebElement dueCell = row.findElement(By.xpath(".//td[4]"));
                String dueText = dueCell.getText();  // e.g. "$50.00"

                // Remove the $ symbol and convert to double
                String amountOnly = dueText.replace("$", "").trim();
                double dueValue = Double.parseDouble(amountOnly);

                // Add to total sum
                totalDue += dueValue;
            }

            System.out.println("Total Due Amount: $" + totalDue);

        } finally {
            // Close browser
            driver.quit();
        }
    }
		
}
/*
 Output
 Total Due Amount: $251.0 
 */