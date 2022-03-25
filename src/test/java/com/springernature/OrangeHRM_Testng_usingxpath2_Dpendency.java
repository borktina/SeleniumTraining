package com.springernature;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class OrangeHRM_Testng_usingxpath2_Dpendency 
{

	ChromeDriver driver;
  @Test(priority=1)
  public void fLogin() throws InterruptedException 
  {
	  System.out.print("FirstMethod");
	  driver.findElement(By.xpath("txtUsername")).sendKeys("dixit");
		driver.findElement(By.name("txtPassword")).sendKeys("admin123");
		driver.findElement(By.name("Submit")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("welcome")).isDisplayed();
  }
  @BeforeTest
  public void OpenBrowser()
  {
	  WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/dashboard");
  }

  @Test(priority=2)
  public void CloseBrowser()
  {
	  driver.quit();
  }
  
	@Test
	public void Login_Valid_Scenario() throws InterruptedException {

		driver.findElement(By.xpath("//button[@id='account-button']//*[name()='svg']")).click();
		driver.findElement(By.linkText("LOGIN")).click();
		Thread.sleep(5000);
		String acturl = driver.getCurrentUrl();
		String acttitle = driver.getTitle();
		String Exptitle = "Login - Spree Demo Site";
		String Expurl= "https://demo.spreecommerce.org/login";
		Assert.assertEquals(acturl, Expurl);
		Assert.assertEquals(acttitle, Exptitle);

}}
