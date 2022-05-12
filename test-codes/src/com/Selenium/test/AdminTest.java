package com.Selenium.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AdminTest {
	public WebDriver driver;

	@BeforeTest()
	public void login() {
		System.setProperty("webdriver.chrome.driver", "C:\\Browser drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8000/");
		driver.findElement(By.name("email")).sendKeys("admin@admin.com");
		driver.findElement(By.name("password")).sendKeys("admin");
		driver.findElement(By.id("login-btn")).click();
		driver.findElement(By.xpath("//table/tbody/tr[2]/th/a")).click();
	}

	@Test(dataProvider = "FilterByMarks", dataProviderClass = DataForTesting.class)
	public void marksFilterTest(int mark) {
		int i;
		driver.findElement(By.id("scoreInput")).sendKeys(String.valueOf(mark));
		driver.findElement(By.xpath("//button")).click();
		List<WebElement> scoreList = driver.findElements(By.xpath("//tbody/tr[@class=\"visible\"]/td[3]"));
		try {
			for (i = 0; i < scoreList.size(); i++) {
				int score = Integer.parseInt(scoreList.get(i).getText());
				if (score < mark)
					Assert.assertEquals(score, mark);
			}
			if (i == scoreList.size())
				Assert.assertEquals(true, true);

		} catch (Exception e) {
			e.printStackTrace();
		}
		driver.findElement(By.id("scoreInput")).clear();
	}

	@Test(dataProvider = "FilterBySubjectName", dataProviderClass = DataForTesting.class)
	public void subjectNameFilterTest(String subName) {
		int i;
		driver.findElement(By.id("subjectInput")).sendKeys(String.valueOf(subName));
		driver.findElement(By.xpath("//button")).click();
		List<WebElement> subList = driver.findElements(By.xpath("//tbody/tr[@class=\"visible\"]/td[2]"));
		try {
			for (i = 0; i < subList.size(); i++) {
				String sub = subList.get(i).getText();
				if (!sub.equalsIgnoreCase(subName))
					Assert.assertEquals(sub.toLowerCase(), subName.toLowerCase());
			}
			if (i == subList.size())
				Assert.assertEquals(true, true);

		} catch (Exception e) {
			e.printStackTrace();
		}
		driver.findElement(By.id("subjectInput")).clear();
	}
	
	@Test(dataProvider = "FilterByStudentName", dataProviderClass = DataForTesting.class)
	public void studentNameFilterTest(String stuName) {
		int i;
		driver.findElement(By.id("nameInput")).sendKeys(String.valueOf(stuName));
		driver.findElement(By.xpath("//button")).click();
		List<WebElement> stuList = driver.findElements(By.xpath("//tbody/tr[@class=\"visible\"]/td[1]"));
		try {
			for (i = 0; i < stuList.size(); i++) {
				String stu = stuList.get(i).getText();
				if (!stu.toLowerCase().contains(stuName.toLowerCase()))
					Assert.assertEquals(stu.toLowerCase().contains(stuName.toLowerCase()),true);
			}
			if (i == stuList.size())
				Assert.assertEquals(true, true);

		} catch (Exception e) {
			e.printStackTrace();
		}
		driver.findElement(By.id("nameInput")).clear();
	}
	@AfterTest()
	public void logout() {
		driver.close();
	}

}
