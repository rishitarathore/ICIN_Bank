package org.simplilearn.workshop.user;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class userRegisterTest {
	@Test
	 public void userRegister() {
			System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			
			driver.manage().window().maximize();
			
			String url="http://localhost:8081";
			sleep(1000);
			
			driver.get(url);
			
			driver.findElement(By.xpath("//nav[@class='navbar navbar-expand-lg navbar-light']/ul//a[@href='/register']")).click();
			
			
			sleep(500);
			driver.findElement(By.name("firstname")).sendKeys("Rishita");
			driver.findElement(By.name("lastname")).sendKeys("Rathore");
			driver.findElement(By.name("username")).sendKeys("rishita");
			driver.findElement(By.name("password")).sendKeys("rishita");
			driver.findElement(By.name("phone")).sendKeys("1238567890");
			driver.findElement(By.name("email")).sendKeys("rishita@gmail.com");
			driver.findElement(By.name("dob")).sendKeys("8-12-2011");
			driver.findElement(By.name("address")).sendKeys("Bhilai, (C.G.)");
			driver.findElement(By.name("identity")).sendKeys("123478458778");
			driver.findElement(By.id("btn-color")).click();
			sleep(1000);
			
			driver.findElement(By.xpath("//nav[@class='navbar navbar-expand-lg navbar-light']/ul//a[@href='/register']")).click();
			
			sleep(500);
			driver.findElement(By.name("firstname")).sendKeys("Riya");
			driver.findElement(By.name("lastname")).sendKeys("Sharma");
			driver.findElement(By.name("username")).sendKeys("riya");
			driver.findElement(By.name("password")).sendKeys("riya");
			driver.findElement(By.name("phone")).sendKeys("1238567997");
			driver.findElement(By.name("email")).sendKeys("riya@gmail.com");
			driver.findElement(By.name("dob")).sendKeys("9-12-2012");
			driver.findElement(By.name("address")).sendKeys("Bhilai, (C.G.)");
			driver.findElement(By.name("identity")).sendKeys("123478598778");
			driver.findElement(By.id("btn-color")).click();
			sleep(1000);
			
			driver.findElement(By.xpath("//nav[@class='navbar navbar-expand-lg navbar-light']/ul//a[@href='/register']")).click();
			
			sleep(500);
			driver.findElement(By.name("firstname")).sendKeys("Priya");
			driver.findElement(By.name("lastname")).sendKeys("Tiwari");
			driver.findElement(By.name("username")).sendKeys("priya");
			driver.findElement(By.name("password")).sendKeys("priya");
			driver.findElement(By.name("phone")).sendKeys("1236767997");
			driver.findElement(By.name("email")).sendKeys("priya@gmail.com");
			driver.findElement(By.name("dob")).sendKeys("10-12-2012");
			driver.findElement(By.name("address")).sendKeys("Bhilai, (C.G.)");
			driver.findElement(By.name("identity")).sendKeys("123471238778");
			driver.findElement(By.id("btn-color")).click();
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
