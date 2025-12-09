package Lab5_CheckBoxAlertBox;
/*
 Lab Exercise 1:
A user wants to search for "java thread life cycle" in Google. You need to
automate selecting the suggestion from the search bar.
Exercise:
● Open Google.
● Type ""java thread".
● Select "java thread life cycle" from the auto-suggestions.
*/
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LabExercies1 {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		WebElement searchBox = driver.findElement(By.id("APjFqb"));
		searchBox.sendKeys("Java thread");
		Thread.sleep(1000);

	      List<WebElement> suggestions = driver.findElements(By.xpath("//ul[@role='listbox']//li//span"));
		for(WebElement suggestion: suggestions)
		{
			if(suggestion.getText().contains("life cycle"))
			{
				suggestion.click();
				break;
			}
		}
	}

}
