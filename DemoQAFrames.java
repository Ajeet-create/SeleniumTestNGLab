package Lab8_Guru99.Com;

/*
Lab Exercise 2:
you are testing a webpage that contains multiple iFrames. Your task is to:
1. Open the DemoQA Frames page: https://demoqa.com/frames.
2. Switch to an iframe with ID "frame2".
3. Extract the text inside the <h1> element with id="sampleHeading" inside the
iframe.
4. Print the extracted text to the console.
5. Switch back to the main webpage.
6. Print a confirmation message that the text was successfully extracted
 * */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoQAFrames {

	public static void main(String[] args) {

WebDriver driver = new ChromeDriver();
		
		
		driver.get("https://demoqa.com/frames");
		
		driver.manage().window().maximize();
		
		WebElement frame2 = driver.findElement(By.xpath("//iframe[@id='frame2']"));
		
		driver.switchTo().frame(frame2);
		
		WebElement  text = driver.findElement(By.xpath("//h1[@id='sampleHeading']"));
			
		System.out.println("Text inside iframe frame2: "+text.getText());
		
		driver.switchTo().defaultContent();
	
		System.out.println("Successfully extracted text");
		
		driver.close();
		
		
	}

}
