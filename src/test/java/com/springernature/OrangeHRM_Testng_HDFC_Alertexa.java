package com.springernature;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class OrangeHRM_Testng_HDFC_Alertexa 
{

	ChromeDriver driver;
  
  
	  @Test
		
	  
	  public void VerifyCustomer() throws InterruptedException 
	  {
		  driver.switchTo().frame(0);
		driver.findElement(By.xpath("//input[@name='fldLoginUserId']")).sendKeys("");
		driver.findElement(By.xpath("//a[normalize-space()='CONTINUE']")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("Login to NetBanking")).isDisplayed();
		driver.switchTo().defaultContent();
		String alerttxt = driver.switchTo().alert().getText();
		String expalrt = "Mouse Right Click Disabled";
		Assert.assertEquals(alerttxt, expalrt);
		
		driver.switchTo().alert().accept();
		
	  }

				@BeforeTest
				public void LaunchBrowser() 
				{
					// Download chromedriver at run time
					// WebDriverManager.chromedriver().setup();
					WebDriverManager.chromedriver().setup();
					driver = new ChromeDriver();
					// ChromeDriver driver = new ChromeDriver();
					driver.navigate().to("https://netbanking.hdfcbank.com/netbanking/");
				}

				@AfterTest
				public void CloseBrowser() 
				{
					driver.quit();
				}

			
		}

