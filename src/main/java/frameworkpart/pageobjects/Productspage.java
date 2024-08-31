package frameworkpart.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import frameworkpart.abstractcomponents.Abstractcomponets;


public class Productspage extends Abstractcomponets {
    WebDriver driver;  
    public Productspage( WebDriver driver2) {
    	super(driver2);
    	this.driver=driver2; 
    	PageFactory.initElements(driver2, this);
    }
    
	
	
	@FindBy(tagName="h5")
	 List<WebElement> proname; 
	@FindBy(xpath="//div[@role='alert']")
	WebElement addedmessage;
	
	 By addtocartbutton =By.xpath("following-sibling::button[2]"); 
	
	public void addingreqpro(String req) {
		WebElement reqpro=proname.stream().filter(a->a.getText().equalsIgnoreCase(req)).findFirst().orElse(null);
	      reqpro.findElement(addtocartbutton).click();
	} 
	public String addedmessag() {
		return addedmessage.getText(); 
		} 
	
	
	
	
	 
	
	
	
	 
}
