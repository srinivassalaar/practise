package frameworkpart.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import frameworkpart.abstractcomponents.Abstractcomponets;

public class Orderspage extends Abstractcomponets {
	WebDriver driver;

	public Orderspage(WebDriver driver) {
		super(driver); 
		this.driver=driver; 
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	} 
	
	
	@FindBy(xpath="//td[2]")
	List<WebElement> orderedpro; 
	
	public Boolean veryfyorderedpro(String req)
	{
		Boolean requ=orderedpro.stream().anyMatch(a->a.getText().equalsIgnoreCase(req));
		return requ; 
		
	}

}
