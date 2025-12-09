package Lab2_DriverMethod;
/*
 Lab Exercise 2:Running Selenium Tests in Microsoft Edge using Edge Driver
Objective:
Understand how to configure and execute Selenium WebDriver tests in Microsoft Edge
using Edge Driver.
Task:
1. Download the latest Edge Driver and set up Selenium WebDriver in Java.
2. Write a Selenium test script that:
○ Launches the Microsoft Edge browser.
○ Navigates to "https://www.google.com".
○ Searches for "Selenium WebDriver" in the Google search bar.
○ Prints the current URL after searching.
○ Closes the browser.
3. Execute the test and validate the output.
4. Explain the role of Edge Driver in automating Edge browser tests.
 * */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class LabEX2 {

	public static void main(String[] args) {

		WebDriver driver = new EdgeDriver();
		
		driver.get("https://www.google.com/");
		driver.findElement(By.id("APjFqb")).sendKeys("Selenium WebDriver");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
	}

}
