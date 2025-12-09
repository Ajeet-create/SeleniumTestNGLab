package Lab5_CheckBoxAlertBox;

/*
Lab Exercise 2:
Write a Java Selenium program that does the following:
1. Navigate to the webpage "https://the-internet.herokuapp.com/checkboxes".
2. Identify all checkbox elements present on the page.
3. Check if each checkbox is selected or not:
○ If a checkbox is not selected, the program should click on it to select it.
○ If a checkbox is already selected, it should remain unchanged.
4. Print the total number of checkboxes found on the page.
5. Display the count of newly selected checkboxes and those that were already
selected.
*/
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LabExerciese2 {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/checkboxes");
		
		List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));	
		  int totalCheckboxes = checkboxes.size();
	        int selectedCount = 0;
	        int unselectedCount = 0;
	        
	        for (WebElement checkbox : checkboxes) {
	            if (!checkbox.isSelected()) {
	                checkbox.click();  
	                selectedCount++;
	            } else {
	                unselectedCount++;
	            }
	            System.out.println("Total checkboxes: " + totalCheckboxes);
	            System.out.println("Now selected checkboxes: " + selectedCount);
	            System.out.println("Already selected checkboxes: " + unselectedCount);

	}

}
}
