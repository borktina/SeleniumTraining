package com.springernature;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class OrangeHRM_Testng_HDFC_assign 
{

	ChromeDriver driver;
  
  
	  @Test(groups= {"sanitytest"})
		
	  
	  public void VerifyCustomer() throws InterruptedException 
	  {
		  driver.switchTo().frame(0);
		driver.findElement(By.xpath("//input[@name='fldLoginUserId']")).sendKeys("1000");
		driver.findElement(By.xpath("//a[normalize-space()='CONTINUE']")).click();
		driver.findElement(By.name("Login to NetBanking")).isDisplayed();
		driver.switchTo().defaultContent();
		
	  }

				@BeforeTest(alwaysRun=true)
				public void LaunchBrowser() 
				{
					// Download chromedriver at run time
					// WebDriverManager.chromedriver().setup();
					WebDriverManager.chromedriver().setup();
					driver = new ChromeDriver();
					// ChromeDriver driver = new ChromeDriver();
					driver.navigate().to("https://netbanking.hdfcbank.com/netbanking/");
				}

				@AfterTest(alwaysRun=true)
				public void CloseBrowser() 
				{
					driver.quit();
				}

			
		}

