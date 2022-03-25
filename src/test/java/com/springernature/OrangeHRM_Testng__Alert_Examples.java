package com.springernature;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class OrangeHRM_Testng__Alert_Examples 
{

	ChromeDriver driver;
  
  
	  @Test(priority=1)
		
	  
	  public void VerifyJsAlert() throws InterruptedException 
	  {
		  //JS Alert
		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Alert']")).click();
		Thread.sleep(2000);
		String alerttxt = driver.switchTo().alert().getText();
		String expalrt = "I am a JS Alert";
		Assert.assertEquals(alerttxt, expalrt);
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		String resultname = driver.findElement(By.xpath("//p[@id='result']")).getText();
		String ExpRes = "You successfully clicked an alert";
		Assert.assertEquals(resultname, ExpRes);
		
	  }
	  @Test(priority=2)
	  public void VerifyJsConfirmAlert() throws InterruptedException 
	  {
		//JS Confirm
		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Confirm']")).click();
		Thread.sleep(2000);
		String alerttxt1 = driver.switchTo().alert().getText();
		String expalrt1 = "I am a JS Confirm";
		Assert.assertEquals(alerttxt1, expalrt1);
		driver.switchTo().alert().dismiss();
		Thread.sleep(2000);
		String resultname1 = driver.findElement(By.xpath("//p[@id='result']")).getText();
		String ExpRes1 = "You clicked: Cancel";
		Assert.assertEquals(resultname1, ExpRes1);
	  }
	  
	  @Test(priority=3)
	  public void VerifyJsPromptAlert() throws InterruptedException 
	  {
		//JS Prompt
		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Prompt']")).click();
		Thread.sleep(2000);
		String alerttxt2 = driver.switchTo().alert().getText();
		String expalrt2 = "I am a JS prompt";
		Assert.assertEquals(alerttxt2, expalrt2);
		driver.switchTo().alert().sendKeys("Test");
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		String resultname2 = driver.findElement(By.xpath("//p[@id='result']")).getText();
		String ExpRes2 = "You entered: Test";
		Assert.assertEquals(resultname2, ExpRes2);
		
		
	  }

				@BeforeTest
				public void LaunchBrowser() 
				{
					// Download chromedriver at run time
					// WebDriverManager.chromedriver().setup();
					WebDriverManager.chromedriver().setup();
					driver = new ChromeDriver();
					// ChromeDriver driver = new ChromeDriver();
					driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");
				}

				@AfterTest
				public void CloseBrowser() 
				{
					driver.quit();
				}

			
		}

