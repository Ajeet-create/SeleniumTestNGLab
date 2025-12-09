package Lab11_TableDataHandling;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
Lab Exercise 1: Web Table Data Handling with Java Streams & Selenium
Website URL:
https://qavbox.github.io/demo/webtable/
1. Open the browser and navigate to the above website using Selenium.
2. Work on the second table (with id='table02').
3. Extract all names listed in the first column of the table.
4. Store the names in a List<String> and sort them using Java Streams.
5. Display all the names after sorting.
6. Compare the original and sorted list and print:
○ "Names are sorted." if the list was already sorted.
○ "Names are not sorted." if the list was not in order.
7. From the same table, filter all employees who work in the Tokyo office (column
index 3).
8. Print the names of these Tokyo-based employees.
 
 */

public class WebTableStreeam {
	
	
	public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // 1. Navigate to website
        driver.get("https://qavbox.github.io/demo/webtable/");

        // 2. Locate the second table by id=table02
        WebElement table = driver.findElement(By.id("table02"));

        // 3. Extract all names from the 1st column
        List<WebElement> nameCells = table.findElements(By.xpath(".//tbody/tr/td[1]"));

        List<String> originalNames = new ArrayList<>();

        for (WebElement cell : nameCells) {
            originalNames.add(cell.getText().trim());
        }

        System.out.println("Original List: " + originalNames);

        // 4. Sort the names using Java Streams
        List<String> sortedNames = originalNames.stream()
                                                .sorted()
                                                .collect(Collectors.toList());

        // 5. Display sorted names
        System.out.println("Sorted List: " + sortedNames);

        // 6. Compare original list with sorted list
        if (originalNames.equals(sortedNames)) {
            System.out.println("Names are sorted.");
        } else {
            System.out.println("Names are not sorted.");
        }

        // 7. Filter all employees working in the Tokyo office (column index = 3)
        List<WebElement> rows = table.findElements(By.xpath(".//tbody/tr"));

        List<String> tokyoEmployees = rows.stream()
                .filter(row -> row.findElement(By.xpath("./td[3]")).getText().equalsIgnoreCase("Tokyo"))
                .map(row -> row.findElement(By.xpath("./td[1]")).getText())
                .collect(Collectors.toList());

        // 8. Print names of Tokyo-based employees
        System.out.println("Tokyo Employees: " + tokyoEmployees);

        driver.quit();
    }
	

}
/* 
Output
Original List: [Tiger Nixon, Garrett Winters, Ashton Cox, Cedric Kelly, Airi Satou, Brielle Williamson, Herrod Chandler, Rhona Davidson, Colleen Hurst, Sonya Frost, Jena Gaines, Quinn Flynn, Charde Marshall, Haley Kennedy, Tatyana Fitzpatrick, Michael Silva, Paul Byrd, Gloria Little, Bradley Greer, Dai Rios, Jenette Caldwell, Yuri Berry, Caesar Vance, Doris Wilder, Angelica Ramos, Gavin Joyce, Jennifer Chang, Brenden Wagner, Fiona Green, Shou Itou, Michelle House, Suki Burks, Prescott Bartlett, Gavin Cortez, Martena Mccray, Unity Butler, Howard Hatfield, Hope Fuentes, Vivian Harrell, Timothy Mooney, Jackson Bradshaw, Olivia Liang, Bruno Nash, Sakura Yamamoto, Thor Walton, Finn Camacho, Serge Baldwin, Zenaida Frank, Zorita Serrano, Jennifer Acosta, Cara Stevens, Hermione Butler, Lael Greer, Jonas Alexander, Shad Decker]
Sorted List: [Airi Satou, Angelica Ramos, Ashton Cox, Bradley Greer, Brenden Wagner, Brielle Williamson, Bruno Nash, Caesar Vance, Cara Stevens, Cedric Kelly, Charde Marshall, Colleen Hurst, Dai Rios, Doris Wilder, Finn Camacho, Fiona Green, Garrett Winters, Gavin Cortez, Gavin Joyce, Gloria Little, Haley Kennedy, Hermione Butler, Herrod Chandler, Hope Fuentes, Howard Hatfield, Jackson Bradshaw, Jena Gaines, Jenette Caldwell, Jennifer Acosta, Jennifer Chang, Jonas Alexander, Lael Greer, Martena Mccray, Michael Silva, Michelle House, Olivia Liang, Paul Byrd, Prescott Bartlett, Quinn Flynn, Rhona Davidson, Sakura Yamamoto, Serge Baldwin, Shad Decker, Shou Itou, Sonya Frost, Suki Burks, Tatyana Fitzpatrick, Thor Walton, Tiger Nixon, Timothy Mooney, Unity Butler, Vivian Harrell, Yuri Berry, Zenaida Frank, Zorita Serrano]
Names are not sorted.
Tokyo Employees: [Garrett Winters, Airi Satou, Rhona Davidson, Shou Itou, Sakura Yamamoto]


*/
 