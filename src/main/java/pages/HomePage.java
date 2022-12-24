package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import base.BaseClass;

public class HomePage extends BaseClass {
	
	public HomePage(ChromeDriver driver) {
		
		this.driver = driver;
		
	}
	
	public HomePage clickMenuButton() {
		
		driver.findElement(By.className("slds-icon-waffle")).click();
		return this;
	}
	
	
	public HomePage clickViewAll() {
		
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		return this;
	}
	
	public LegalEntitiesPage clickLegalEntities() {
		
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.xpath("//p[text()='Legal Entities']"))).click().perform();
		return new LegalEntitiesPage(driver);
	}	
	

}
