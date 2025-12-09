package Lab6_AutomationAddingEcom;

/*
Lab Exercise 1: Automating Adding Items to Cart in an E-Commerce Website
Objective:
The objective of this lab exercise is to automate the process of adding an item to the
cart on an e-commerce website using Selenium WebDriver in Java. Students will learn
How to:
● Locate web elements using various strategies.
● Interact with web elements such as buttons and input fields.
● Implement explicit waits to handle dynamic content.
● Validate the successful addition of items to the cart.
Prerequisites:
● Java installed on your system
● Maven or Gradle for dependency management
● ChromeDriver installed and set up
● Selenium WebDriver configured in your Java project
● Access to an e-commerce website (e.g., ``)
Task Requirements:
1. Navigate to the e-commerce website.
2. Log in using valid credentials.
3. Search for a specific product by name.
4. Add the product to the cart.
5. Validate the cart update by verifying the number of items.
6. Print the total number of items in the cart.
*/

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class DemoWebShop {

	public static void main(String[] args) {

		
		        WebDriver driver = new ChromeDriver();
		        driver.manage().window().maximize();

		        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		        // 1. Navigate to the e-commerce website (login page)
		        driver.get("https://demowebshop.tricentis.com/login");

		        // 2. Log in using valid credentials
		        driver.findElement(By.id("Email")).sendKeys("monu399@gmail.com");
		        driver.findElement(By.id("Password")).sendKeys("Ajeet123@");
		        driver.findElement(By.cssSelector("input[value='Log in']")).click();

		        // Wait until login completes (account link appears)
		      //.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Log out")));

		        // 3. Search for a specific product
		        WebElement searchBox = driver.findElement(By.id("small-searchterms"));
		        searchBox.sendKeys("Laptop");

		        driver.findElement(By.cssSelector("input[type='submit'][value='Search']")).click();

		        // Wait for results to load
		        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".product-item")));

		        // 4. Add the first product to the cart
		        WebElement addToCartButton = driver.findElement(By.cssSelector("input[value='Add to cart']"));
		        addToCartButton.click();

		        // Wait for cart update
		        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".content")));

		        // 5. Validate cart count
		        WebElement cartQtyElement = driver.findElement(By.cssSelector("span.cart-qty"));
		        String cartText = cartQtyElement.getText();   // Example: "(1)"

		        int itemCount = Integer.parseInt(cartText.replace("(", "").replace(")", ""));

		        // 6. Print total number of items
		        System.out.println("Total items in cart: " + itemCount);

		        // Close browser
		        //driver.quit();
		    }
			
	

}
