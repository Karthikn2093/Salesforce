package base;


import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilites.ReadExcel;


public class BaseClass2 {
	
	public WebDriver driver;
	public String excelFileName;
	
	@BeforeMethod
	public void startApplication() throws Exception {
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com");
		driver.findElement(By.id("username")).sendKeys("karthik.kn2093@gmail.com");
		driver.findElement(By.id("password")).sendKeys("System!123");
		driver.findElement(By.id("Login")).click();
				
		driver.findElement(By.className("slds-icon-waffle")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.xpath("//p[text()='Legal Entities']"))).click().perform();
		
		Thread.sleep(5000);
		
		WebElement element = driver.findElement(By.xpath("//span[text()='Legal Entities']"));
		
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		
	}
	
	@AfterMethod
	public void closeApplication() throws Exception {
		
		Thread.sleep(4000);
		driver.quit();
		
	}
	
	@DataProvider(name = "fetchData")
	public String[][] sendData() throws IOException {

		ReadExcel read = new ReadExcel();
		String[][] data = read.readExcel(excelFileName);
		return data;
		

	}

}
