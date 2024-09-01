package frameworkpart.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import frameworkpart.abstractcomponents.Abstractcomponets;

public class Confirmationpage extends Abstractcomponets{  
	WebDriver driver;
	public Confirmationpage(WebDriver driver2) {  
		super(driver2);
		this.driver=driver2; 
		PageFactory.initElements(driver2, this);
		
	} 
	
	@FindBy(css=".hero-primary")
	WebElement message; 
	public String gettingthanks() {
		return message.getText();
	}
	
}
