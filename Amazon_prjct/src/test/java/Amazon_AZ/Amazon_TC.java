package Amazon_AZ;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon_TC 
{
	WebDriver driver;
	@Test
	@Parameters("browser")
	public void setup(String br)
	{
		if(br.equals("chrome"))
		{WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();}
		
		if (br.equals("edge"))
		{WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();}
		driver.get("https://www.amazon.in/?ref_=nav_signin");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
	}
	@Test(priority=2)
	public void EndToEndTc() throws InterruptedException
	{
		WebElement search_box = driver.findElement(By.id("twotabsearchtextbox"));
		search_box.sendKeys("iphone14 pro max");
		
		WebElement clk_search = driver.findElement(By.id("nav-search-submit-button"));
		clk_search.click();
		
		Thread.sleep(5000);
		WebElement clk_14promax = driver.findElement(By.xpath("//img[@alt='Sponsored Ad - Apple iPhone 14 Pro Max (256 GB) - Deep Purple']"));
		clk_14promax.click();
		
	}
	/*
	@Test(priority=3)
	public void signout()
	{
		
		WebElement Accountlist = driver.findElement(By.id("nav-link-accountList-nav-line-1"));
		WebElement signout = driver.findElement(By.id("nav-item-signout"));
		Actions act=new Actions(driver);
		act.moveToElement(Accountlist).click().perform();
		signout.click();
	}*/
	@Test(priority=4)
	public void teardown()
	{
		driver.quit();
	}
	
	
	
	

}
