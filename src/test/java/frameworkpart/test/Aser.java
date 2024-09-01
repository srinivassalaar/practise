package frameworkpart.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Aser { 
	
	
	@Test()
	public void fort()
	{
	 	WebDriver driver= new ChromeDriver(); 
	 	driver.get("https://rahulshettyacademy.com/");
	 	driver.manage().window().maximize();
	 	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	 	driver.findElement(By.xpath("(//a[text()='Courses'])[1]")).click();
	 	JavascriptExecutor sd=(JavascriptExecutor)driver;
	 	sd.executeScript("window.scrollBy(0,3500)");

	}

}
