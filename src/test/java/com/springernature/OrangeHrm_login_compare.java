package com.springernature;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.github.dockerjava.api.model.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class OrangeHrm_login_compare {
	
	// Global Declaration
	ChromeDriver driver;

	@SuppressWarnings("deprecation")
	@Test
	public void Login_Valid_Scenario() throws InterruptedException {

		driver.findElement(By.xpath("//button[@id='account-button']//*[name()='svg']")).click();
		driver.findElement(By.linkText("LOGIN")).click();
		Thread.sleep(5000);
		String acturl = driver.getCurrentUrl();
		String acttitle = driver.getTitle();
		String Exptitle = "Login - Spree Demo Site";
		String Expurl= "https://demo.spreecommerce.org/login";
		Assert.assertEquals(acturl,Expurl);
		Assert.assertEquals(acttitle, Exptitle);
	
	}
}
