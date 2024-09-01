package frameworkpart.testcomponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import frameworkpart.pageobjects.Landingpage;
import io.github.bonigarcia.wdm.WebDriverManager;





public class BaseTest { 
	
	public WebDriver driver; 
	public Landingpage landingpage;
	 public WebDriver initialisedriver() throws IOException
	 {    
		 
		 Properties ab= new Properties(); 
		 FileInputStream re= new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\frameworkpart\\resources\\globalproperties.properties");
		 ab.load(re);
		 String browsname=System.getProperty("browser")!=null ? System.getProperty("browser"): ab.getProperty("browser");
		 if( browsname.contains("chrome"))
		 {
			 //WebDriverManager.chromedriver().setup(); 
			 ChromeOptions options = new ChromeOptions();
			 if (browsname.contains("headless")){
			 options.addArguments("headless");
			 }
			 driver=new ChromeDriver(options); 
			 driver.manage().window().setSize(new Dimension(1440,900));
		 } 
		 else if(browsname.equalsIgnoreCase("firefox"))
		 {
			driver=new FirefoxDriver(); 
		 } 
		 else if(browsname.equalsIgnoreCase("edge"))
		 {
			 //System.setProperty("WebDriver.edge.driver", "J:\\pdf\\SRINIVAS\\software\\edge driver\\unzip//EdgeDriver.exe");
			  driver=new EdgeDriver();
		 } 
		 driver.manage().window().setSize(new Dimension(1440,900));
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
		 return driver; 
	} 
	 @BeforeMethod(alwaysRun=true)
	 public Landingpage gotoapp() throws IOException {
		 WebDriver driver=initialisedriver(); 
		 landingpage =  new Landingpage(driver); 
		 landingpage.gotourl();
		 return landingpage;
	 } 
	 @AfterMethod(alwaysRun=true)
	 public void closing() throws InterruptedException {
		 driver.quit();
	 }
	

}
