package base;


import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilites.ReadExcel;


public class BaseClass {
	
	public ChromeDriver driver;
	public String excelFileName;
	
	@BeforeMethod
	public void startApplication(){
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com");
		
	}
	
	@AfterMethod
	public void closeApplication(ITestResult result) throws Exception {
		
		File src = driver.getScreenshotAs(OutputType.FILE);
		File dest = new File("./images/"+result.getName()+".png");
		FileUtils.copyFile(src, dest);
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
