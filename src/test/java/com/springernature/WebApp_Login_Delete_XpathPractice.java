package com.springernature;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebApp_Login_Delete_XpathPractice {
 
  ChromeDriver driver;
	@BeforeTest
	public void LaunchBrowser()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?ReturnUrl=%2fsamples%2fTestComplete11%2fWebOrders%2fdefault.aspx");
	}
	
@Test(priority=1)
public void Login_WebOrder() throws InterruptedException 
{
	  driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("tester");
	  driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
	  driver.findElement(By.id("ctl00_MainContent_login_button")).click();
	  Thread.sleep(2000);
	  
	  String ActElement = driver.findElement(By.xpath("//h1[normalize-space()='Web Orders']")).getText();
		String ExpElement = "Web Orders";
		Assert.assertEquals(ActElement, ExpElement);
		System.out.println(ActElement);
}

@Test(priority=2)
public void CreateOrder_UpdateOrder_DeleteOrder() throws InterruptedException 
{
	  //Create Order and Verify Order
	driver.findElement(By.linkText("Order")).click();
	Thread.sleep(2000);
	
	driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity")).sendKeys("10");
	driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtName']")).sendKeys("Tim");
	driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox2']")).sendKeys("Street12");
	driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox3']")).sendKeys("Pune");
	
	driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox4']")).sendKeys("Maharashtra");
	driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox5']")).sendKeys("410014");
	driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_cardList_0']")).click();
	driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox6']")).sendKeys("9876543211");
	driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox6']")).sendKeys("03/25");
	driver.findElement(By.xpath("//a[@id='ctl00_MainContent_fmwOrder_InsertButton']")).click();
	driver.findElement(By.xpath("//strong[normalize-space()='New order has been successfully added.']")).isDisplayed();
	//strong[normalize-space()='New order has been successfully added.']
	
	//
	//driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtDiscount")).sendKeys("2");
	/*driver.findElement(By.xpath("//input[@value='Calculate']")).click();
	
	 String ActTotal = driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtTotal")).getText();
	 int quantity=10;
	 int Price=100;
	 int Dis=8;
	 int expTotal;
	 expTotal = (quantity*Price)/Dis;
	 	 
	//String ExpElement = "Web Orders";
	Assert.assertEquals(ActTotal, expTotal);
	System.out.println(expTotal);
	*/
	  
	  //Update order and Verify Order
	  
	  //Delete Order and Verify Order
	  
}

	@AfterTest
	public void CloseBrowser()
	{
		driver.quit();
	}

}
