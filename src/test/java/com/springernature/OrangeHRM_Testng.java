package com.springernature;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class OrangeHRM_Testng 
{

	ChromeDriver driver;
  @Test(groups= {"smoketest"})
  public void fLogin() 
  {
	  driver.findElement(By.name("txtUsername")).sendKeys("dixit");
		driver.findElement(By.name("txtPassword")).sendKeys("admin123");
		driver.findElement(By.name("Submit")).click();
		driver.findElement(By.id("welcome")).isDisplayed();
  }
  @BeforeTest(alwaysRun=true)
  public void OpenBrowser()
  {
	  WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/dashboard");
  }

  @AfterTest(alwaysRun=true)
  public void CloseBrowser()
  {
	  driver.quit();
  }

}
