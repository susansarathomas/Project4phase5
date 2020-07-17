package mydemo;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class MainDemo {
	public static WebDriver driver;
	
		
		@BeforeTest
		public void setURL() {
			System.setProperty("webdriver.chrome.driver","D:\\cd\\chromedriver.exe");
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("http://automationpractice.com/index.php");
			
		}
		@Test(priority=1)
		public void regiternewaccound() {
			driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).click();
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			driver.findElement(By.xpath("//*[@id=\"email_create\"]")).sendKeys("susan123@gmail.com");
			driver.findElement(By.xpath("//*[@id=\"SubmitCreate\"]/span")).click();
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			driver.findElement(By.xpath("//*[@id=\"id_gender2\"]")).click();
			driver.findElement(By.xpath("//*[@id=\"customer_firstname\"]")).sendKeys("Susan");
			driver.findElement(By.xpath("//*[@id=\"customer_lastname\"]")).sendKeys("Thomas");
			driver.findElement(By.xpath("//*[@id=\"passwd\"]")).sendKeys("susant123");
			Select dropdown=new Select(driver.findElement(By.xpath("//*[@id=\"days\"]")));
			dropdown.selectByValue("29");
			Select dropdown2=new Select(driver.findElement(By.xpath("//*[@id=\"months\"]")));
			dropdown2.selectByValue("7");			
			Select dropdown3=new Select(driver.findElement(By.xpath("//*[@id=\"years\"]")));
			dropdown3.selectByValue("1998");
			
			//driver.findElement(By.xpath("//*[@id=\"firstname\"]")).sendKeys("Gim");
			//driver.findElement(By.xpath("//*[@id=\"lastname\"]")).sendKeys("Thomas");
			driver.findElement(By.xpath("//*[@id=\"address1\"]")).sendKeys("Glory Villa,Chunala Bhabola Road");
			
			driver.findElement(By.xpath("//*[@id=\"city\"]")).sendKeys("Goa");
			
			Select dropdown4=new Select(driver.findElement(By.xpath("//*[@id=\"id_state\"]")));
			dropdown4.selectByValue("9");
			driver.findElement(By.xpath("//*[@id=\"postcode\"]")).sendKeys("42022");
			Select dropdown5=new Select(driver.findElement(By.xpath("//*[@id=\"id_country\"]")));
			dropdown5.selectByValue("21");
			driver.findElement(By.xpath("//*[@id=\"phone\"]")).sendKeys("258444213");
			driver.findElement(By.xpath("//*[@id=\"phone_mobile\"]")).sendKeys("969865132");
			//driver.findElement(By.xpath("//*[@id=\"alias\"]")).sendKeys("Mary Villa");
			driver.findElement(By.xpath("//*[@id=\"submitAccount\"]/span")).click();
			System.out.println("New user registered successfully");
		}
		
		@Test(priority=2)
		public void logout1() {
			driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[2]/a")).click();
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			System.out.println("Logged out successfully");
		}
		
		
		@Test(priority=3) 
		public void login() {
		    driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).click(); 
		    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		    driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("susan123@gmail.com");
		    driver.findElement(By.xpath("//*[@id=\"passwd\"]")).sendKeys("susant123");
		    
		    driver.findElement(By.xpath("//*[@id=\"SubmitLogin\"]/span")).click();
		    System.out.println("Successfully logged in");
		     
		}
		  
		@Test(priority=4) 
		public void search() {
			driver.findElement(By.xpath("//*[@id=\"search_query_top\"]")).sendKeys("dresses");
			driver.findElement(By.xpath("//*[@id=\"searchbox\"]/button")).click();
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			JavascriptExecutor js3=(JavascriptExecutor)driver;
			js3.executeScript("scrollBy(0,1500)");
		}
		
		@Test(priority=5)
		  public void addtowishlist() {
			//driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/a")).click();
			
			//JavascriptExecutor js3=(JavascriptExecutor)driver;
			//js3.executeScript("scrollBy(0,700)"); 
			driver.get("http://automationpractice.com/index.php?id_product=2&controller=product&search_query=dresses&results=7");
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			driver.findElement(By.xpath("//*[@id=\"wishlist_button\"]")).click();
			driver.findElement(By.xpath("//*[@id=\"product\"]/div[2]/div/div/a")).click(); 
			driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a/span")).click();
			driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/div[2]/ul/li/a/span")).click();
			//driver.findElement(By.xpath("//*[@id=\"wishlist_21806\"]/td[5]/a")).click();
		  	JavascriptExecutor js4=(JavascriptExecutor)driver;
		  	js4.executeScript("scrollBy(0,670)");
		  	System.out.println("Item added to wishlist");
		  
		 }
		  
		@Test(priority=6) 
		public void addtocard() { 
			driver.get("http://automationpractice.com/index.php?id_category=3&controller=category");
			driver.findElement(By.xpath("//*[@id=\"categories_block_left\"]/div/ul/li[1]/span")).click();
			driver.findElement(By.xpath("//*[@id=\"categories_block_left\"]/div/ul/li[1]/ul/li[1]/a")).click();
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("scrollBy(0,500)"); driver.get("http://automationpractice.com/index.php?id_product=1&controller=product");
			//driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[1]/div/a[2]/span")).click();
		  	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		  	driver.findElement(By.xpath("//*[@id=\"thumb_2\"]")).click();
		  	driver.findElement(By.xpath("//*[@id=\"product\"]/div[2]/div/div/a")).click();
		  
		  	//driver.findElement(By.xpath("//*[@id=\"thumb_3\"]")).click();
		  	driver.findElement(By.xpath("//*[@id=\"color_14\"]")).click(); Select
		  	dropdown=new Select(driver.findElement(By.xpath("//*[@id=\"group_1\"]")));
		  	dropdown.selectByValue("2");
		  	driver.findElement(By.xpath("//*[@id=\"add_to_cart\"]/button/span")).click();
		  	driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span")).click();
		  	JavascriptExecutor js1=(JavascriptExecutor)driver;
		  	js1.executeScript("scrollBy(0,450)");
		  	driver.findElement(By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]/span")).click(); 
		  	JavascriptExecutor js2=(JavascriptExecutor)driver;
		  	js2.executeScript("scrollBy(0,450)");
		  	driver.findElement(By.xpath("//*[@id=\"center_column\"]/form/p/button/span")).click();
		  	driver.findElement(By.xpath("//*[@id=\"form\"]/p/button/span")).click();
		  	driver.findElement(By.xpath("//*[@id=\"order\"]/div[2]/div/div/a")).click();
		  	driver.findElement(By.xpath("//*[@id=\"cgv\"]")).click();
		  	driver.findElement(By.xpath("//*[@id=\"form\"]/p/button/span")).click();
		  	JavascriptExecutor js3=(JavascriptExecutor)driver;
		  	js3.executeScript("scrollBy(0,450)");
		  	driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/p/a/i")).click();
		  //driver.findElement(By.xpath("//*[@id=\"form\"]/p/a/i")).click();
		  //driver.findElement(By.xpath("//*[@id=\"center_column\"]/form/p/a/i")).click(); 
		  //driver.findElement(By.xpath("//*[@id=\"center_column\"]/p[2]/a[2]/i")). click();
		  	driver.findElement(By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a")).click(); 
		  	System.out.println("Item added to card succesfully"); 
		  }
		  
		@Test(priority=7)
		public void logout() {
			driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[2]/a")).click();
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			System.out.println("Logged out successfully");
		}
		  
		  @Test(priority=8)
		  public void invalidlogin() {
			  driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).click(); 
			  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			  driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("aaa123@gmail.com");
			  driver.findElement(By.xpath("//*[@id=\"passwd\"]")).sendKeys("ssss123");
			  driver.findElement(By.xpath("//*[@id=\"SubmitLogin\"]/span")).click();
			  System.out.println("Sorry invalid login Id and password"); 
		}
		 
		
		
		
		@AfterMethod
		public void tearDown() {
			//driver.quit();
		}
}
