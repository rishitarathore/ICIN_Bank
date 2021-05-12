package org.simplilearn.workshop.user;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class userDashboardTest {
	WebDriver driver;
	String url = "http://localhost:8081";

	@BeforeMethod
	public void login() {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		String url = "http://localhost:8081";
		sleep(1000);
		driver.get(url);

		// login
		driver.findElement(By.xpath("/html//a[@id='navbarDropdown']")).click();
		sleep(500);
		driver.findElement(By.linkText("User")).click();
		sleep(500);
		driver.findElement(By.name("username")).sendKeys("rishita");
		driver.findElement(By.name("password")).sendKeys("rishita");
		driver.findElement(By.id("btn-color")).click();
		sleep(1000);
	}

	@Test(priority = 1)
	public void deposit() {
		// deposit
		sleep(1000);
		driver.findElement(By.xpath("/html//div[@id='btn-color']/a[@href='/user/deposit']")).click();
		sleep(1000);
		driver.findElement(By.xpath("/html//form[@action='/user/depositAction']/input[@name='amount']"))
				.sendKeys("1000");
		driver.findElement(By.xpath(
				"/html/body[@class='default-body']//form[@action='/user/depositAction']//input[@value='Deposit']"))
				.click();
		sleep(2000);
	}

	@Test(priority = 2)
	public void withdraw() {
		// withdraw
		sleep(1000);
		driver.findElement(By.xpath("//div[@id='custom-anchor']//a[@href='/user/withdraw']")).click();
		sleep(1000);
		driver.findElement(By.cssSelector("[type='text']")).sendKeys("100");
		driver.findElement(By.cssSelector("[type='submit']")).click();
		sleep(2000);
	}

	@Test(priority = 3)
	public void transfer() {
		// transfer
		sleep(1000);
		driver.findElement(By.xpath("//div[@id='custom-anchor']//a[@href='/user/transferMoney']")).click();
		sleep(1000);
		driver.findElement(By.name("ifsc")).sendKeys("ICIN1234567");
		driver.findElement(By.name("accno")).sendKeys("39149182013");
		driver.findElement(By.name("amount")).sendKeys("100");
		driver.findElement(By.cssSelector("[type='submit']")).click();
		sleep(2000);
	}

	@Test(priority = 4)
	public void requestCheckBook() {
		// Request check Book
		sleep(1000);
		driver.findElement(By.xpath("//div[@id='custom-anchor']//a[@href='/user/requestChequeBook']")).click();
		sleep(1000);
		Select no_of_pages = new Select(driver.findElement(By.name("no_of_pages")));
		no_of_pages.selectByValue("15");
		driver.findElement(By.xpath(
				"/html/body[@class='default-body']//form[@action='/user/requestChequeBookAction']//input[@value='Confirm']"))
				.click();
		sleep(2000);
	}

	@Test(priority = 5)
	public void transactionHistory() {
		// Transaction History
		sleep(1000);
		driver.findElement(By.xpath("//div[@id='custom-anchor']//a[@href='/user/transactionHistory']")).click();
		sleep(2000);
	}

	@Test(priority = 6)
	public void transferHistory() {
		// Transfer History
		sleep(1000);
		driver.findElement(By.xpath("//div[@id='custom-anchor']//a[@href='/user/transferHistory']")).click();
		sleep(2000);
	}

	@Test(priority = 7)
	public void editProfile() {
		// Edit Profile
		sleep(1000);
		driver.findElement(By.xpath("/html//a[@id='navbarDropdown']")).click();
		sleep(100);
		driver.findElement(By.linkText("Edit Profile")).click();
		sleep(1000);
		driver.findElement(By.name("phone")).sendKeys("1223456789");
		driver.findElement(By.name("email")).sendKeys("rish@gmail.com");
		driver.findElement(By.name("address")).sendKeys("Raipur, (C.G.)");
		driver.findElement(By.xpath("/html//input[@id='btn-color']")).click();
		sleep(2000);
	}

	@Test(priority = 8)
	public void changePassword() {
		// Change Password
		sleep(1000);
		driver.findElement(By.xpath("/html//a[@id='navbarDropdown']")).click();
		sleep(100);
		driver.findElement(By.linkText("Change Password")).click();
		sleep(1000);
		driver.findElement(By.name("password1")).sendKeys("rish");
		driver.findElement(By.name("password2")).sendKeys("rish");
		driver.findElement(By.xpath("/html//input[@id='btn-color']")).click();
		sleep(2000);
	}

	@AfterMethod
	public void logout() {
		// Dashboard
		sleep(1000);
		driver.findElement(By.cssSelector(".nav-link.pr-4.waves-effect.waves-light")).click();
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

};