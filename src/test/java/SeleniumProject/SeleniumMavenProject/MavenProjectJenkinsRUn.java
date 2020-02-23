package SeleniumProject.SeleniumMavenProject;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import static org.testng.Assert.assertTrue;

import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.Logs;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class MavenProjectJenkinsRUn 
{
 
	private WebDriver dr;
	private static Logger log = Logger.getLogger(Logs.class.getName());
	
	  @BeforeTest
	  public void beforeTest() {
		  
		  System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\eclipse-workspace\\JavaSeleniumProject\\Drivers\\chromedriver.exe");
		  dr = new ChromeDriver();
		  dr.get("https://en.wikipedia.org/wiki/India");
		  log.info("Web application launched");
		 
	  }
	    
	  @Test
	  
	  public void waitTest() throws InterruptedException
	  {
		  String title= dr.getTitle();
		  log.info("Web application launched"+title);
		  Assert.assertTrue(title.contains("India - Wikipedia"));
		  dr.findElement(By.id("searchInput")).clear();
		  
		  dr.findElement(By.id("searchInput")).sendKeys("History");
		  log.info("Web application launched 2"+dr.getTitle());
		  dr.findElement(By.id("searchButton")).click();
		 
		  Assert.assertTrue(title.contains("India - Wikipedia"));
		
		  
	  }
	  
	  
	  @AfterTest
	  public void afterTest() {
		  
		   dr.close();
		  
	  }
}
