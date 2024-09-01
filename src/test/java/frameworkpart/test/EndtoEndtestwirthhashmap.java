package frameworkpart.test;

import java.time.Duration;
import java.util.HashMap;
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

public class EndtoEndtestwirthhashmap extends BaseTest {
      
	@Test(dataProvider="getdata",groups= {"tigershuf"})
	public void enedtoendtest(HashMap<String,String> input) throws InterruptedException {
		  
		 String req=input.get("product");
		 String countrymini="ind";
	     Productspage productspage=landingpage.gotologin(input.get("email"),input.get("password"));
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
	
	@DataProvider 
	public Object[][] getdata() {
		HashMap<String,String>map= new HashMap<String,String>(); 
		map.put("email", "srinivas.51423@gmail.com"); 
		map.put("password", "Srinivasrahul5$"); 
		map.put("product", "ADIDAS ORIGINAL"); 
		
		HashMap<String,String> map1= new HashMap<String,String>(); 
		map1.put("email", "sriram.514232@gmail.com"); 
		map1.put("password", "Sriramrahul5$"); 
	    map1.put("product", "ADIDAS ORIGINAL");
		return new Object[][] {{map},{map1}}; 
		//data provider not only returns arrays but also hashmaps.
	
	}
	
}
