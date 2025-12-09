package Lab1_Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Lab1 {

	public static void main(String[] args) {

		    WebDriver driver =new ChromeDriver(); 
		    driver.manage().window().maximize();
			driver.get("https://www.google.com/");
			driver.findElement(By.id("APjFqb")).sendKeys("Selenium Weddriver");
			driver.findElement(By.name("btnK")).submit();
		}

	}


