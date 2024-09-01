package frameworkpart.stepdef;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import frameworkpart.pageobjects.CartPage;
import frameworkpart.pageobjects.Landingpage;
import frameworkpart.pageobjects.Orderspage;
import frameworkpart.pageobjects.Productspage;
import frameworkpart.testcomponents.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class StepDef extends BaseTest{ 
	Orderspage orderspage;
	Productspage productspage;
	CartPage  cartPage ;
	@Given("I landed on E-commerce page")
	public Landingpage gotoapp() throws IOException {
		 WebDriver driver=initialisedriver(); 
		 landingpage =  new Landingpage(driver); 
		 landingpage.gotourl();
		 return landingpage;
	 }  
	@Given("^I logged in with username(.+) and password(.+)$")
	public void logging(String userid,String password) {
	productspage=landingpage.gotologin(userid,password); 
	}  
	@When("I go to orders page")
	public void goingtoorderspage()
	{
	orderspage=landingpage.gotoorderspage(); 
	}
	@Then("^check whether the particular product (.+) is in orders page$") 
	public void checking(String pro)
	{
		Assert.assertTrue(orderspage.veryfyorderedpro(pro));
	} 
	@Then("{string} message is displayed")
	public void loginerrorvalidation(String mess) throws InterruptedException {
		 
		 
	     Assert.assertEquals(mess, landingpage.loginerrormessage());
	 
	    }  
	
	@And("^Going to products page and cart page for the req pro (.+)$")
	public void go_to_Orderspage_productspage(String req)
	{
		 productspage.addingreqpro(req);
		 Assert.assertEquals("Product Added To Cart", productspage.addedmessag()); 
		
         cartPage =productspage.gotocartpage(); 
	}
	
	@Then("^verify the rquired product is in cart page or not (.+)$")
	 public void checking_for_the_match(String req) {
	 Assert.assertTrue(cartPage.checkingproincart(req)); 
	}

}
