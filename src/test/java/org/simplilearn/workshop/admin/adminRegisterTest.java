package org.simplilearn.workshop.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class adminRegisterTest {
	 @Test
	 public void adminRegister() {
			System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			
			driver.manage().window().maximize();
			
			String url="http://localhost:8081/adminr";
			sleep(2000);
			
			driver.get(url);
			driver.findElement(By.name("username")).sendKeys("admin");
			driver.findElement(By.name("password")).sendKeys("admin");
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
