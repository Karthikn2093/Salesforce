package tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;

public class CreateLegalEntitiesWithoutName extends BaseClass {
	
	@BeforeTest
	public void setFileName() {
		
		excelFileName = "Login";
		
	}
	
	@Test(dataProvider = "fetchData")
	public void createLegalEntitiesWithoutName(String username, String password) throws Exception {
		
		new LoginPage(driver).enterUserName(username).enterPassword(password).clickLogin()
		.clickMenuButton().clickViewAll().clickLegalEntities()
		.clickLegalEntitiesTab().clickLegalEntityDropdown().clickNewLegalEntity().enterCompany().enterDescription("Selenium").clickSave().verifyErrorMessageDisplayed();
		
	}

}
