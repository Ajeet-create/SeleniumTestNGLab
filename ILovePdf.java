package Lab4_Navigation;
/*
 Lab Exercise 1:
Write a Java program using Selenium WebDriver to navigate to
https://www.ilovepdf.com/word_to_pdf, upload a Word file (.docx), and initiate the
conversion to a PDF file.
 * */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ILovePdf {

	public static void main(String[] args) {

		 WebDriver driver = new ChromeDriver();
         driver.get("https://www.ilovepdf.com/word_to_pdf");

         try {
             // Wait for the upload button to appear (optional)
             Thread.sleep(3000);

             // Locate the file upload button (Hidden Input Field)
             WebElement uploadButton = driver.findElement(By.xpath("//input[@type='file']"));
             
             // Upload DOC file (Absolute Path)
             uploadButton.sendKeys("C:\\Users\\AJEET VISHWAKARMA\\OneDrive\\Documents\\AJEET VISHWAKARMA.DOCX");

             System.out.println("File Uploaded Successfully!");

             // Wait for file processing
             Thread.sleep(3000);

             // Click on 'Convert to PDF' button
             WebElement convertButton = driver.findElement(By.id("processTask"));
             convertButton.click();

             System.out.println("Conversion Started...");
             
             // Wait for conversion to complete
             Thread.sleep(5000);

             // Click on 'Download PDF' button
             WebElement downloadButton = driver.findElement(By.xpath("//a[@id='pickfiles']"));
           //a[@id='pickfiles']
             downloadButton.click();

             System.out.println("File Downloaded Successfully!");
         } catch (InterruptedException e) {
             e.printStackTrace();
         } finally {
             // Close the browser after execution
        //     driver.quit();
         }
	}

}
/*
 Output
File Uploaded Successfully!
Conversion Started...
File Downloaded Successfully!
 
  */
