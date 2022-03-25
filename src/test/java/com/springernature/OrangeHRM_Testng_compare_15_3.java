package com.springernature;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class OrangeHRM_Testng_compare_15_3 
{

  ChromeDriver driver;
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
		
		//Grab th text and verify with expected result
		//Grab the text and verify with Expected Result
		
				String ActText = driver.findElement(By.xpath("//h3[normalize-space()='Log in to continue']")).getText();
				String ExpText = "Log in to continue";
				Assert.assertEquals(ActText, ExpText);
	}
}
