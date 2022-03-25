package com.springernature;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class OrangeHRM_Testng_Priority2_ 
{

	ChromeDriver driver;
  @Test(priority=1)
  public void fLogin() throws InterruptedException 
  {
	  System.out.print("FirstMethod");
	  driver.findElement(By.name("txtUsername")).sendKeys("dixit");
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

}
