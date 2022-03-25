package com.springernature;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.github.dockerjava.api.model.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHrm_login {
	ChromeDriver driver;
	
	@Before
	public void LaunchBrowser()
{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/dashboard");
}
	@test
	public void loginvalid()
	{
		
		driver.findElement(By.name("txtUsername")).sendKeys("admin");
		driver.findElement(By.name("txtPassword")).sendKeys("admin123");
		driver.findElement(By.name("Submit")).click();
		driver.findElement(By.id("welcome"));
		driver.quit();
	
	}

	@Test
	public void test() {
		//WebDriverManager.chromedriver().setup();
		//WebDriver driver = new ChromeDriver();
		//driver.get("https://opensource-demo.orangehrmlive.com/index.php/dashboard");
		driver.findElement(By.linkText("Forgot your password?")).click();
		driver.findElement(By.name("Reset Password")).isDisplayed();
		
		}
	@After
	public void CloseBrowser()
	{
		driver.quit();
	}
}
