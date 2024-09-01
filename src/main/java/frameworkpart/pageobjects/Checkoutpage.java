package frameworkpart.pageobjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import frameworkpart.abstractcomponents.Abstractcomponets;

public class Checkoutpage extends Abstractcomponets{ 
	WebDriver driver;
	public Checkoutpage(WebDriver driver2)
	{ 
		super(driver2);
		this.driver=driver2; 
		PageFactory.initElements(driver2, this);
	} 
	@FindBy(xpath="//input[@placeholder='Select Country']") 
	WebElement searchengine; 
	@FindBy(xpath="//a[text()='Place Order ']")
	WebElement placeorderbutton;
	
	public void filteredcountry(String country) {
		searchengine.sendKeys(country);
		List<WebElement>searchedsuggestions=driver.findElements(By.xpath("//button[@type='button']")); 
	     WebElement searchedfiltered=searchedsuggestions.stream().filter(as->as.getText().equalsIgnoreCase("india")).findFirst().orElse(null); 
	     searchedfiltered.click();  
//		 	JavascriptExecutor sd=(JavascriptExecutor)driver;
//		 	sd.executeScript("window.scrollBy(0,3500)");
	}
	
	
	public Confirmationpage gotoconfirmationpage() throws InterruptedException
	{ 
		
		placeorderbutton.click();
		
		 Confirmationpage confirmationpage =new Confirmationpage(driver); 
		 return confirmationpage;
	}
     
    
     
	

}
