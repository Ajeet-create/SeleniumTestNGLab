package Lab17_Parameters;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

public class SmokeTestApp {
	
	WebDriver driver;
	

	@Parameters("url")
	public void openAppplications(String aapUrl)
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(aapUrl);

		
		//System.out.println("Opened URL: " +appUrl);
		
	}
	
	

}
