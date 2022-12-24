package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import base.BaseClass;

public class LegalEntitiesPage extends BaseClass {
	
	public LegalEntitiesPage(ChromeDriver driver) {
		
		this.driver = driver;
		
	}
	
	public LegalEntitiesPage clickLegalEntitiesTab() {
		
		
		WebElement element = driver.findElement(By.xpath("//span[text()='Legal Entities']"));
		
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		return this;
		
	}
	
	public LegalEntitiesPage searchLegalEntity(String searchTerm) throws Exception {
		
		WebElement search = driver.findElement(By.xpath("//input[@class='slds-input']"));
		search.click();
		Thread.sleep(2000);
		search.sendKeys(searchTerm + Keys.ENTER);
		Thread.sleep(2000);
		return this;
		
	}
	
	public LegalEntitiesPage clickDropdown() {
		
		driver.findElement(By.xpath("//span[@class='slds-icon_container slds-icon-utility-down']//span[1]")).click();
		return this;
	}
	
	public LegalEntitiesPage clickDelete() {
		
		driver.findElement(By.xpath("(//a[@role='menuitem'])[2]")).click();
		return this;
	}
	
	public LegalEntitiesPage clickEdit() {
		
		driver.findElement(By.xpath("//a[@title='Edit']")).click();
		return this;
	}
	
	public LegalEntitiesPage clickDeleteInPopup() {
		
		driver.findElement(By.xpath("//span[text()='Delete']")).click();
		return this;
	}
	
	public LegalEntitiesPage verifyLegalEntityDeleted() {
		
		System.out.println(driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']")).isDisplayed());
		return this;
	}
	
	public LegalEntitiesPage sortLegalEntities() {
		
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//span[@title='Last Modified Date']"))).click().perform();
		return this;
	}
	
	public LegalEntitiesPage enterCompany() {
		
		driver.findElement(By.xpath("(//input[@class=' input'])[2]")).sendKeys("Testleaf");
		return this;
	}
	
	public LegalEntitiesPage enterDescription(String description) {
		
		driver.findElement(By.className("textarea")).sendKeys(description);
		return this;
	}
	
	public LegalEntitiesPage selectStatus() {
		
		driver.findElement(By.className("select")).click();
		driver.findElement(By.xpath("(//a[@role='menuitemradio'])[2]")).click();
		return this;
	}
	
	public LegalEntitiesPage clickSave() {
		
		driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();
		return this;
	}
	
	public LegalEntitiesPage verifyEditSaved() {
		
		boolean isdisplayed = driver.findElement(By.xpath("//span[contains(@class,'toastMessage slds-text-heading--small')]")).isDisplayed();
		Assert.assertTrue(isdisplayed);
		return this;
	}
	
	public LegalEntitiesPage clickLegalEntityDropdown() throws Exception {
		
		Thread.sleep(4000);
		driver.findElement(By.xpath("//a[@title='Legal Entities']/following::a[1]")).click();
		return this;
	}
	
	public LegalEntitiesPage clickNewLegalEntity() throws Exception {
		
		Thread.sleep(2000);
		WebElement createEntity = driver.findElement(By.xpath("//span[text()='New Legal Entity']"));
		JavascriptExecutor exe = (JavascriptExecutor) driver;
		exe.executeScript("arguments[0].click();", createEntity);
		return this;
		
	}

	public LegalEntitiesPage verifyErrorMessageDisplayed() {
		
		System.out.println(driver.findElement(By.className("form-element__help")).isDisplayed());
		return this;
	}
		
}
