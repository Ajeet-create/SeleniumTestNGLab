package Lab11_TableDataHandling;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
Lab Exercise 2: Working with Web Tables using Selenium
Objective:
To practice locating elements inside a web table, extracting data, filtering it based on
conditions, and validating the sorted state using Selenium WebDriver and Java
Streams.
You are given a sample webpage that contains a structured web table listing various
world structures with their details. Your task is to:
1. Launch the browser and navigate to:
https://www.techlistic.com/2017/02/automate-demo-web-table-with-selenium.html
2. Locate the table with class "tsc_table_s13".
3. Extract all structure names (1st column of the table).
4. Print whether the original list of structure names is sorted alphabetically.
5. Print all structure names from the list.
6. Filter and print the names of all structures that belong to the country 'UAE'
  
  
  */


public class StructureTable {

	public static void main(String[] args) {


        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // 1. Navigate to the page
        driver.get("https://www.techlistic.com/2017/02/automate-demo-web-table-with-selenium.html");

        // 2. Locate the table by class name
        WebElement table = driver.findElement(By.className("tsc_table_s13"));

        // 3. Extract all structure names (1st column)
        List<WebElement> structureCells = table.findElements(By.xpath(".//tbody/tr/td[1]"));

        List<String> originalList = new ArrayList<>();

        for (WebElement cell : structureCells) {
            originalList.add(cell.getText().trim());
        }

        System.out.println("Original Structure Names:");
        System.out.println(originalList);

        // 4. Validate if the list is alphabetically sorted
        List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());

        if (originalList.equals(sortedList)) {
            System.out.println("The structure names are already sorted alphabetically.");
        } else {
            System.out.println("The structure names are NOT sorted alphabetically.");
        }

        // 5. Print all structure names
        System.out.println("List of All Structure Names:");
        sortedList.forEach(System.out::println);

        // 6. Filter structures belonging to 'UAE'
        List<WebElement> rows = table.findElements(By.xpath(".//tbody/tr"));

        List<String> uaeStructures = rows.stream()
                .filter(row -> row.findElement(By.xpath("./td[3]"))
                        .getText().equalsIgnoreCase("UAE"))
                .map(row -> row.findElement(By.xpath("./td[1]")).getText())
                .collect(Collectors.toList());

        System.out.println("Structures Located in UAE:");
        System.out.println(uaeStructures);

        driver.quit();
    }

}

/*
 Output
 
Original Structure Names:
[UAE, Saudi Arabia, Taiwan, China]

The structure names are NOT sorted alphabetically.
List of All Structure Names:
China
Saudi Arabia
Taiwan
UAE
Structures Located in UAE:
[]

 */
 