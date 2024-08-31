package frameworkpart.test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class StandAloneTest {

	public static void main(String[] args) {
		 WebDriverManager.chromedriver().setup(); 
		 WebDriver driver= new ChromeDriver(); 
		 String req="ADIDAS ORIGINAL";
		 driver.get("https://rahulshettyacademy.com/client/"); 
		 driver.manage().window().maximize(); 
		 driver.manage().window().setSize(new Dimension(1440,900));
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		 driver.findElement(By.id("userEmail")).sendKeys("srinivas.51423@gmail.com"); 
		 driver.findElement(By.id("userPassword")).sendKeys("Srinivasrahul5$"); 
		 driver.findElement(By.id("login")).click(); 
		 List<WebElement>proname=driver.findElements(By.tagName("h5")); 
		 WebElement reqpro=proname.stream().filter(a->a.getText().equalsIgnoreCase(req)).findFirst().orElse(null);
		 reqpro.findElement(By.xpath("following-sibling::button[2]")).click();//addtocartbutton of reqproduct 
		 String addedmessage=driver.findElement(By.xpath("//div[@role='alert']")).getText(); 
		 Assert.assertEquals("Product Added To Cart", addedmessage); 
		 driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();//cart button header
		 List<WebElement>addedpros=driver.findElements(By.cssSelector("div[class='cart'] h3"));
         Boolean check=addedpros.stream().anyMatch(a->a.getText().equalsIgnoreCase(addedmessage));//checking pro in cart 
         driver.findElement(By.xpath("(//button [@class='btn btn-primary'])[3]")).click();//checkout button 
         driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys("ind"); 
         List<WebElement>searchedsuggestions=driver.findElements(By.xpath("//button[@type='button']")); 
         WebElement searchedfiltered=searchedsuggestions.stream().filter(as->as.getText().equalsIgnoreCase("india")).findFirst().orElse(null); 
         searchedfiltered.click(); 
         JavascriptExecutor sd=(JavascriptExecutor)driver;
		 	sd.executeScript("window.scrollBy(0,3500)");
         driver.findElement(By.cssSelector(".btnn.action__submit.ng-star-inserted")).click();//placeorder button 
         String thanksmessage=driver.findElement(By.cssSelector(".hero-primary")).getText();
         Assert.assertEquals("THANKYOU FOR THE ORDER.", thanksmessage); 
         driver.findElement(By.xpath("(//button[@class='btn btn-custom'])[1]")).click();//home button header
	     
	}

}
