package frameworkpart.test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import frameworkpart.pageobjects.CartPage;
import frameworkpart.pageobjects.Checkoutpage;
import frameworkpart.pageobjects.Confirmationpage;
import frameworkpart.pageobjects.Landingpage;
import frameworkpart.pageobjects.Orderspage;
import frameworkpart.pageobjects.Productspage;
import frameworkpart.testcomponents.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;
//how are we?
public class EndtoEndtest extends BaseTest {
      //checking in git
	@Test(dataProvider="getdata")
	public void enedtoendtest(String prod,String mail,String pass) throws InterruptedException {
		  
		 String req=prod;
		 String countrymini="ind";
	     Productspage productspage=landingpage.gotologin(mail,pass);
		 productspage.addingreqpro(req);
		 Assert.assertEquals("Product Added To Cart", productspage.addedmessag()); 
		
		 CartPage  cartPage =productspage.gotocartpage(); 
	     Assert.assertTrue(cartPage.checkingproincart(req)); 
	     Checkoutpage checkoutpage=cartPage.gotocheckoutpage(); 
		 checkoutpage.filteredcountry(countrymini);
		  Confirmationpage confirmationpage =checkoutpage.gotoconfirmationpage(); 
		 Assert.assertEquals("THANKYOU FOR THE ORDER.", confirmationpage.gettingthanks() ); 
		 confirmationpage.gotomainhomepage();
		
	     } 
	
	@Test
	public void verifyorderdisplay() {
		 String req="ADIDAS ORIGINAL";
		Productspage productspage=landingpage.gotologin("srinivas.51423@gmail.com","Srinivasrahul5$"); 
		Orderspage orderspage=landingpage.gotoorderspage(); 
		Assert.assertTrue(orderspage.veryfyorderedpro(req));
		
	} 
	
	@DataProvider()
	public Object[][] getdata() {
		return new Object[][]{{"ADIDAS ORIGINAL","srinivas.51423@gmail.com","Srinivasrahul5$"},{"ADIDAS ORIGINAL","sriram.514232@gmail.com","Sriramrahul5$"}};
	}

}
