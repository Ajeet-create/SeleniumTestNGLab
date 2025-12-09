package Lab25_SeleniumGrid;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class RemoteWebDriverTest {

	

    @Test
    @Parameters("browser")
    public void openOrangeHRM(String browserName) throws MalformedURLException {

        DesiredCapabilities cap = new DesiredCapabilities();

        if (browserName.equalsIgnoreCase("chrome")) {
            cap.setBrowserName("chrome");
        } else if (browserName.equalsIgnoreCase("firefox")) {
            cap.setBrowserName("firefox");
        }

        WebDriver driver = new RemoteWebDriver(
                new URL("http://localhost:4444/wd/hub"), cap
        );

        driver.get("https://opensource-demo.orangehrmlive.com");
        driver.manage().window().maximize();

        System.out.println("Page Title: " + driver.getTitle());

        driver.quit();
    }
}
