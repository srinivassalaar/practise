package frameworkpart.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import frameworkpart.abstractcomponents.Abstractcomponets;

public class CartPage extends Abstractcomponets{
     WebDriver driver;
	public CartPage(WebDriver driver2) {
		super(driver2);
		this.driver=driver2;
		PageFactory.initElements(driver2, this);
	}  
	@FindBy(css="div[class='cart'] h3")
	List<WebElement> addedpros; 
	@FindBy(xpath="(//button [@class='btn btn-primary'])[3]")
	WebElement checkoutbutton;
	 
	
	public Boolean checkingproincart(String product) {
		 Boolean check=addedpros.stream().anyMatch(a->a.getText().equalsIgnoreCase(product));
		 return check;
	 } 
	
	public Checkoutpage gotocheckoutpage() {
		checkoutbutton.click();
		 Checkoutpage checkoutpage=new Checkoutpage(driver); 
		 return checkoutpage;
	}
	
	
	
   
}
