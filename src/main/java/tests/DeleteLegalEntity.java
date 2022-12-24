package tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;

public class DeleteLegalEntity extends BaseClass {
	
	@BeforeTest
	public void setFileName() {
		
		excelFileName = "Login";
		
	}
	
	@Test(dataProvider = "fetchData")
	public void deleteLegalEntity(String username, String password) throws Exception {
		
		new LoginPage(driver).enterUserName(username).enterPassword(password).clickLogin()
		.clickMenuButton().clickViewAll().clickLegalEntities()
		.clickLegalEntitiesTab().searchLegalEntity("Entity4").clickDropdown().clickDelete().clickDeleteInPopup().verifyLegalEntityDeleted();
		
	}

}
