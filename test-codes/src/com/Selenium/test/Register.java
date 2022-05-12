package com.Selenium.test;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Register {
	
	@Test(dataProvider="registerData",dataProviderClass=DataForTesting.class)
	public void registerTest(String fname,String lname,String mobile,String password,String email,String test)
	{
		System.setProperty("webdriver.chrome.driver","C:\\Browser drivers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8000/register/");
		String prevUrl = driver.getCurrentUrl();
		driver.findElement(By.name("first_name")).sendKeys(fname);
		driver.findElement(By.name("last_name")).sendKeys(lname);
		driver.findElement(By.name("mobile")).sendKeys(mobile);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("email")).sendKeys(email);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		try
		{
			if(test.equals("negative"))
				Assert.assertEquals(driver.getCurrentUrl(),prevUrl);
			else
				Assert.assertNotEquals(driver.getCurrentUrl(),prevUrl);
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

}
