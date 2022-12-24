package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import base.BaseClass;

public class LoginPage extends BaseClass {
	
	public LoginPage(ChromeDriver driver) {
		
		this.driver = driver;
		
	}
	
	public LoginPage enterUserName(String username) {
		
		driver.findElement(By.id("username")).sendKeys(username);
		return this;
	}
	
	public LoginPage enterPassword(String password) {
		
		driver.findElement(By.id("password")).sendKeys(password);
		return this;
	}
	
	public HomePage clickLogin() {
		
		driver.findElement(By.id("Login")).click();
		return new HomePage(driver);
		
	}

}
