package org.simplilearn.workshop.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class adminKycTest {
	WebDriver driver;
	String url = "http://localhost:8081";

	@BeforeMethod
	public void login() {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		sleep(1000);
		driver.get(url);

		// login
		sleep(1000);
		driver.findElement(By.xpath("/html//a[@id='navbarDropdown']")).click();
		sleep(500);
		driver.findElement(By.linkText("Admin")).click();
		sleep(500);
		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("admin");
		driver.findElement(By.id("btn-color")).click();
		sleep(2000);
	}
	
	@Test(priority = 1)
	public void kycAccept() {
		// KYC accept
		sleep(1000);
		driver.findElement(By.xpath("//div[@id='custom-anchor']//a[@href='/admin/authorize']")).click();
		sleep(2000);
		driver.findElement(By.xpath(
				"/html/body[@class='default-body']//table[@class='table']//a[@href='/admin/authorizationAccept?username=rishita']"))
				.click();
		sleep(1000);
		driver.findElement(By.xpath(
				"/html/body[@class='default-body']//table[@class='table']//a[@href='/admin/authorizationAccept?username=priya']"))
				.click();
		sleep(2000);
	}

	@Test(priority = 2)
	public void kycReject() {
		// KYC reject
		sleep(1000);
		driver.findElement(By.xpath("//div[@id='custom-anchor']//a[@href='/admin/authorize']")).click();
		sleep(1000);
		driver.findElement(By.xpath(
				"/html/body[@class='default-body']//table[@class='table']//a[@href='/admin/authorizationReject?username=riya']"))
				.click();
		sleep(2000);
	}

	
	@AfterMethod
	public void endTest() {
		// Back to Dashboard
		driver.findElement(
				By.xpath("//nav[@class='navbar navbar-expand-lg navbar-light']/ul//a[@href='/admin/dashboard']"))
				.click();
		sleep(1000);

		// logout
		driver.findElement(By.xpath("/html//a[@id='navbarDropdown']")).click();
		driver.findElement(By.linkText("Logout")).click();
		sleep(1000);

		driver.quit();
	}

	private void sleep(long m) {
		try {
			Thread.sleep(m);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}


}
