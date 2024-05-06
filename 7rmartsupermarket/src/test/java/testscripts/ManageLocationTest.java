package testscripts;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ManageLocationPage;
import utilities.ExcelUtility;

public class ManageLocationTest extends Base {
	
	@Test
	public void verifyAParticularNameIsPresentInTable()
	{
		String username=ExcelUtility.getString(1, 0, "LoginPage");
		String password=ExcelUtility.getString(1, 1, "LoginPage");
		String searchName=ExcelUtility.getString(1, 0, "ManageLocationPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsernameOnUsernameFieldPasswordOnPasswordFieldAndClickOnSignInButton(username,password);
		ManageLocationPage managelocationpage=new ManageLocationPage(driver);
		managelocationpage.clickOnManageLocationTile();
	    managelocationpage.findRowSizeOfTable();
	    boolean isNamePresent=managelocationpage.searchAParticularNameIsPresent(searchName);
	    assertTrue(isNamePresent,"Port Kirbyland is not found in the table");
		
	}
	

}
