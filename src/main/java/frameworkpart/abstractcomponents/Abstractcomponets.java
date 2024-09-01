package frameworkpart.abstractcomponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import frameworkpart.pageobjects.CartPage;
import frameworkpart.pageobjects.Orderspage;

public class Abstractcomponets { 
	 WebDriver driver; 
	public Abstractcomponets(WebDriver driver2) {
		// TODO Auto-generated constructor stub 
		this.driver=driver2;
		PageFactory.initElements(driver2, this);
	} 
	@FindBy(xpath="(//button[@class='btn btn-custom'])[2]")
    WebElement orderspage;
	@FindBy(xpath="//button[@routerlink='/dashboard/cart']")
	WebElement cartbuttonheader;  
	@FindBy(xpath="(//button[@class='btn btn-custom'])[1]")
	WebElement homebuttonheader;  
	
	public void waitingToAppear(WebElement one) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5)); 
		wait.until(ExpectedConditions.visibilityOf(one));
	}
	
    public CartPage gotocartpage() {
    	cartbuttonheader.click();
    	CartPage  cartPage =new  CartPage(driver); 
    	return cartPage;
    	
    } 
    
    public void gotomainhomepage() {
    	homebuttonheader.click();
    }
	 
    public Orderspage gotoorderspage() {
    	orderspage.click(); 
    	Orderspage orderspage= new Orderspage(driver); 
    	return orderspage;
    }
	

}
