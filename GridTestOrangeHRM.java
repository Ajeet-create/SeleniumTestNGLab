package Lab25_SeleniumGrid;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class GridTestOrangeHRM {
	
	 @Test
	    @Parameters("browser")
	    public void openOrangeHRM(String browser) throws Exception {

	        DesiredCapabilities cap = new DesiredCapabilities();
	        cap.setBrowserName(browser);

	        WebDriver driver = new RemoteWebDriver(
	                new URL("http://localhost:4444/wd/hub"), cap);

	        driver.get("https://opensource-demo.orangehrmlive.com/");
	        driver.manage().window().maximize();

	        System.out.println("Title on " + browser + " : " + driver.getTitle());

	        driver.quit();
	    }

}
