package com.springernature;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class OrangeHRM_Testng_Parmeterize extends ApplicationTestData
{

	ChromeDriver driver;
	@Test (dataProvider = "Login")
  public void fLogin(String Uname, String Pwd) throws InterruptedException 
  {
	  driver.findElement(By.name("txtUsername")).sendKeys(Uname);
		driver.findElement(By.name("txtPassword")).sendKeys(Pwd);
		driver.findElement(By.name("Submit")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("welcome")).isDisplayed();
		Thread.sleep(2000);
		driver.findElement(By.linkText("welcome")).click();
		driver.findElement(By.linkText("Logout")).click();
		driver.findElement(By.id("btnLogin")).isDisplayed();
  }
  @BeforeTest
  public void OpenBrowser() throws InterruptedException
  {
	  WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/dashboard");
		Thread.sleep(2000);
		
  }

  @AfterTest
  public void CloseBrowser()
  {
	  driver.quit();
  }

}
