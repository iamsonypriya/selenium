package seleniumTest;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class NewTest {
	
	WebDriver driver;
	
	String url="https://www.amazon.in/";
	
	@BeforeClass
	 public void beforeClass() {
		
		System.setProperty("webdriver.edge.driver", "C:\\Users\\SONYPRIYA\\Downloads\\edgedriver_win64 (2)\\msedgedriver.exe");
	
		  driver=(WebDriver) new EdgeDriver();
		  
		  driver.manage().window().maximize();
		  
		  driver.get(url);
		  
	driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
	  }
	
  @Test
  public void f() throws InterruptedException {
	  driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys("iphone 15 ");
	  
	  driver.findElement(By.xpath("//*[@id=\"nav-search-submit-button\"]")).click();
	  
	  String parent=driver.getWindowHandle();
	  
	  Set<String>children=driver.getWindowHandles();
	  
	  for(String c:children) {
		  
		  String ch=driver.getCurrentUrl();
		  
		  if(!ch.equals(parent)) {
			  
		  driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[3]/div/div/div/div/span/div/div/div/div[2]/div/div/div[1]/h2/a/span")).click();
		  
		  Thread.sleep(2000);
		 
		  driver.findElement(By.name("submit.add-to-cart")).click();
		  
		  driver.findElement(By.xpath("//*[@id=\"attach-sidesheet-checkout-button\"]/span/input")).click();
		  
		  
		  }
	  }
	  
	  
	  
	  
	  
  }
  

  @AfterClass
  public void afterClass() {
	  driver.close();
  }

}
