package testa;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
//fjkllkfjh
public class One {  
	
	@Test
	public void opening()
	{
		WebDriver driver=new ChromeDriver(); 
		driver.get("https://www.facebook.com/login/"); 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));  
		driver.manage().window().maximize(); 
                                   driver.findElement(By.id("email")).sendKeys("hfdhjk");
		
	}

}
