package Lab6_AutomationAddingEcom;

/*
 Lab Exercise 2: The objective of this lab exercise is to automate the process of
searching for a product on an e-commerce website and extracting product names
along with their prices using Selenium WebDriver in Java.
● Access to an e-commerce website (e.g., https://demowebshop.tricentis.com/)
Task Requirements:
1. Navigate to the e-commerce website.
2. Search for a specific product using a search bar (e.g., "Laptop").
3. Wait for the search results to load properly.
4. Extract and display the product names from the search results.
5. Extract and display the corresponding prices for each product.
6. Handle cases where some products might not have a visible price.
7. Print all extracted product names and prices to the console.
 * */
	

        import java.time.Duration;
		import java.util.List;
		import org.openqa.selenium.By;
		import org.openqa.selenium.WebDriver;
		import org.openqa.selenium.WebElement;
		import org.openqa.selenium.chrome.ChromeDriver;
		import org.openqa.selenium.support.ui.ExpectedConditions;
		import org.openqa.selenium.support.ui.WebDriverWait;

		public class SearchProduct {
			
			public static void main(String[] args) {

		        // 1. Launch the browser
		        WebDriver driver = new ChromeDriver();
		        driver.manage().window().maximize();

		        // 2. Navigate to the e-commerce website
		        driver.get("https://demowebshop.tricentis.com/");

		        // 3. Search for a product (e.g., Laptop)
		        WebElement searchBox = driver.findElement(By.id("small-searchterms"));
		        searchBox.sendKeys("Laptop");
		        driver.findElement(By.cssSelector("input[type='submit'][value='Search']")).click();

		        // 4. Wait for the search results to load
		        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".product-item")));

		        // 5 & 6. Extract product names and prices
		        List<WebElement> products = driver.findElements(By.cssSelector(".product-item"));

		        System.out.println("\n--- Search Results ---\n");

		        for (WebElement product : products) {

		            // Extract product name
		            String productName = product.findElement(By.cssSelector("h2.product-title")).getText();

		            // Extract price (may not exist)
		            String price = "Price not available";
		            try {
		                price = product.findElement(By.cssSelector(".prices .price")).getText();
		            } catch (Exception e) {
		                // Price not found -> handled
		            }

		            // Print product details
		            System.out.println("Product: " + productName);
		            System.out.println("Price: " + price);
		            System.out.println("---------------------------------------");
		        }

		        // Close the browser
		       driver.quit();
		    }

		
	}

