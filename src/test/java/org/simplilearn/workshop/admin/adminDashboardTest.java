package org.simplilearn.workshop.admin;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class adminDashboardTest {
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
	public void selectFeature() {
		// User Account Info - Select Feature
		sleep(1000);
		driver.findElement(By.xpath("/html//div[@id='btn-color']/a[@href='/admin/userAccountInfo']")).click();
		sleep(1000);
		Select featureSelect = new Select(driver.findElement(By.name("featureSelect")));
		featureSelect.selectByValue("2");
		sleep(50);
		driver.findElement(By.xpath(
				"/html/body[@class='default-body']//table[@class='table']/tbody[2]/tr[1]/td[6]/form[@action='/admin/grantAccess']/a[@href='javascript:{}']"))
				.click();
		sleep(2000);
	}

	@Test(priority = 2)
	public void userBlock() {
		// User Account Info - Block
		sleep(1000);
		driver.findElement(By.xpath("/html//div[@id='btn-color']/a[@href='/admin/userAccountInfo']")).click();
		sleep(1000);
		driver.findElement(By.xpath(
				"/html/body[@class='default-body']//table[@class='table']//a[@href='/admin/blockUser?username=rishita']"))
				.click();
		sleep(2000);
	}

	@Test(priority = 3)
	public void userActivate() {
		// User Account Info - Activate
		sleep(1000);
		driver.findElement(By.xpath("/html//div[@id='btn-color']/a[@href='/admin/userAccountInfo']")).click();
		sleep(1000);
		driver.findElement(By.xpath(
				"/html/body[@class='default-body']//table[@class='table']//a[@href='/admin/activateUser?username=rishita']"))
				.click();
		sleep(2000);
	}

	@Test(priority = 4)
	public void chequeBookRequest() {
		// Cheque Book Request
		sleep(1000);
		driver.findElement(By.xpath("//div[@id='custom-anchor']//a[@href='/admin/authorizeChequeBook']")).click();
		sleep(1000);
		driver.findElement(By.xpath(
				"/html/body[@class='default-body']//table[@class='table']//a[@href='/admin/authorizeChequeBookAction?requestId=1']"))
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
