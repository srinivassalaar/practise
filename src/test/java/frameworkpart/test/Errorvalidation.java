package frameworkpart.test;

import org.testng.annotations.Test;

import frameworkpart.pageobjects.CartPage;
import frameworkpart.pageobjects.Productspage;
import frameworkpart.testcomponents.BaseTest;
import junit.framework.Assert;

public class Errorvalidation extends BaseTest{ 
	@Test (groups= {"lion"})
	public void loginerrorvalidation() throws InterruptedException {
		 
		 String req="ADIDAS ORIGINAL";
		 String countrymini="ind";
	     Productspage productspage=landingpage.gotologin("srinivas.51423@gmail.com","srinivasrahul5$"); 
	     Assert.assertEquals("Incorrect email or password.", landingpage.loginerrormessage());
	 
	     
	} 
	
	@Test
	public void producterrorvalidation()
	{
		 String req="ADIDAS ORIGINAL";
		 String countrymini="ind";
	     Productspage productspage=landingpage.gotologin("srinivas.51423@gmail.com","Srinivasrahul5$");
		 productspage.addingreqpro(req);
		 Assert.assertEquals("Product Added To Cart", productspage.addedmessag()); 
		
		 CartPage  cartPage =productspage.gotocartpage(); 
	     Assert.assertTrue(cartPage.checkingproincart(req)); 
	}
}
