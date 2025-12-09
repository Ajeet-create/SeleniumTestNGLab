package Lab4_Navigation;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
1. Launch a browser and maximize the window.
2. Open "https://www.bing.com" in the browser.
3. Navigate to "https://www.wikipedia.org".
4. Go back to the previous page.
5. Move forward to Wikipedia again.
Refresh the current page using the navigate().refresh() method.
6. Resize the browser window to 800x600 pixels using setSize(Dimension).
7. Close the browser after completing all actions.
*/

public class LabExcercies2 {

	public static void main(String[] args) {

		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("Browser window maximize");
		driver.get("https://www.bing.com");
		System.out.println("Opening browser Bing Homepage");
		driver.navigate().to("https://www.wikipedia.org");
		System.out.println("Navigate to wikipedia Homepage");
		driver.navigate().back();
		System.out.println("Navigate to back Bing page");
		driver.navigate().forward();
		System.out.println("Navigate forword to Wikipedia Homepage ");
		driver.navigate().refresh();
		System.out.println("page refreshed");

		driver.manage().window().setSize(new Dimension(800, 600));
		System.out.println("Browser window resized to 800x600");
	}

}
