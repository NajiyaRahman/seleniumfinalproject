package testscripts;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageLocationPage;
import utilities.ExcelUtility;

public class ManageLocationTest extends Base {
	
	@Test(retryAnalyzer=retry.Retry.class,description="verify user is able to add new location")
	public void verifyUserIsAbleToAddNewLocation()
	{
		String username=ExcelUtility.getString(1, 0, "LoginPage");
		String password=ExcelUtility.getString(1, 1, "LoginPage");
		String country=ExcelUtility.getString(1, 0, "ManageLocationPage");
		String state=ExcelUtility.getString(1, 1, "ManageLocationPage");
		String location=ExcelUtility.getString(1, 2, "ManageLocationPage");
		String deliveryCharge=ExcelUtility.getInteger(1, 3, "ManageLocationPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsernameOnUsernameFieldPasswordOnPasswordFieldAndClickOnSignInButton(username,password);
		ManageLocationPage managelocationpage=new ManageLocationPage(driver);
		managelocationpage.clickOnManageLocationTile().clickOnNewButton().selectCountryFromCountryDropdown(country).selectStateFromStateDropdown(state).enterlocationInLocationField(location).enterDeliveryChargeOnDeliveryChargeField(deliveryCharge).clickOnSaveButton();
		boolean isAlertMessageDisplayed=managelocationpage.verifyAlertMessage();
		assertTrue(isAlertMessageDisplayed,"user is not able to add new location");
	}
}
