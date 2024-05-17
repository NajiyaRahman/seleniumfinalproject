package testscripts;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MobileSliderPage;
import utilities.Constants;
import utilities.ExcelUtility;

public class MobileSliderTest extends Base {
	
	@Test(retryAnalyzer=retry.Retry.class,description="verify user is able to a add new mobile slider")
	public void verifyUserIsAbleToAddNewMobileSlider()
	{
		String username=ExcelUtility.getString(1, 0, "LoginPage");
		String password=ExcelUtility.getString(1, 1, "LoginPage");
		String category=ExcelUtility.getString(1, 0, "MobileSliderPage");
		String fileUpload=Constants.MOBILESLIDERFILE;
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsernameOnUsernameFieldPasswordOnPasswordFieldAndClickOnSignInButton(username,password);
		MobileSliderPage mobilesliderpage=new MobileSliderPage(driver);
		mobilesliderpage.clickOnMobileSliderTile().clickOnNewButton().selectCategoryFromCategoryDropdown(category).chooseFileToUpload(fileUpload).clickOnSaveButton();
		boolean isAlertMessageDisplayed=mobilesliderpage.verifyAlertMessage();
		assertTrue(isAlertMessageDisplayed, "user is not able to add new mobile slider");
	}

}
