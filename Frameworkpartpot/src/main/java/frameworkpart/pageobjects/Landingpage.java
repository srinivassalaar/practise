package frameworkpart.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import frameworkpart.abstractcomponents.Abstractcomponets;

public class Landingpage extends Abstractcomponets { 
	
  WebDriver driver;
	public Landingpage(WebDriver driver2)
	{ 
		super(driver2);
		this.driver=driver2; 
		PageFactory.initElements(driver2, this);
	} 
	
	
	

    @FindBy(xpath="//div[@role='alert']")
    WebElement loginerrormeassage;
	@FindBy(id="userEmail") 
	WebElement email; 
	@FindBy(id="userPassword") 
	WebElement password; 
	@FindBy(id="login") 
	WebElement loginbutton;  
	
	public Productspage gotologin(String gmail,String pass)
	{ 
		
		email.sendKeys(gmail); 
		password.sendKeys(pass);  
		loginbutton.click();
		Productspage productspage = new Productspage(driver); 
		 return  productspage;
		
	}  
	public void gotourl()
	{
		 driver.get("https://rahulshettyacademy.com/client/"); 
		 
	} 
	
	public String loginerrormessage() { 
		waitingToAppear(loginerrormeassage);
		return loginerrormeassage.getText();
		
	}
	  
	
	
	
	
	

}
