package testCase;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class IndeedSiteTest {

	public WebDriver driver;
	public String baseUrl;
	
	@Before
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "/Users/Kenan/Documents/Drivers/chromedriver");
		driver = new ChromeDriver();
		baseUrl = "http://www.indeed.com";		
		
	}
	
	@Test
	public void testHome()
	{
		
		driver.get(baseUrl);
		driver.findElement(By.id("what")).sendKeys("Selenium");
		driver.findElement(By.id("where")).clear();
		driver.findElement(By.id("where")).sendKeys("Washington, DC");
		driver.findElement(By.id("fj")).click();
		
		String expectedTitle = "Selenium Jobs, Employment in Washington, DC | Indeed.com";
		String actualTitle =driver.getTitle();
		
		
		assertEquals("Error: Title is wrong" , expectedTitle , actualTitle);
		
	}
	
	@Test
	public void testLogoDisplay()
	{
		
	driver.get(baseUrl);
	assertTrue("Error:Logo is not displayed", driver.findElement(By.xpath("//img[@title='Indeed job search']")).isDisplayed());
	
	}

	@After
	public void tearDown() throws InterruptedException
	{
	
		Thread.sleep(5000);
		driver.quit();
		//driver.close();
		
		
	}
}
