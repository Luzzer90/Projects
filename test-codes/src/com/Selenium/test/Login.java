package com.Selenium.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {

	@Test(dataProvider = "loginData", dataProviderClass = DataForTesting.class)
	public void loginTest(String username, String password, String test) {
		System.setProperty("webdriver.chrome.driver", "C:\\Browser drivers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8000/");
		String prevUrl = "http://localhost:8000/";
		driver.findElement(By.name("email")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.id("login-btn")).click();
		try {
		if (test.equals("negative")) {
			Assert.assertEquals(driver.getCurrentUrl(), prevUrl);
			driver.findElement(By.xpath("/html/body/header/div/b/a")).click();
		}
		else
			Assert.assertNotEquals(driver.getCurrentUrl(), prevUrl);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
		driver.close();
		}
	}
	@Test(dataProvider="ProfileTestData",dataProviderClass = DataForTesting.class)
	public void profileCheck(String username,String password)
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Browser drivers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8000/");
		String prevUrl = "http://localhost:8000/";
		driver.findElement(By.name("email")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.id("login-btn")).click();
		String actual = driver.findElement(By.xpath("//*[@id=\"profile-section\"]/div[4]")).getText();
		Assert.assertEquals(actual,username);
	}

}
