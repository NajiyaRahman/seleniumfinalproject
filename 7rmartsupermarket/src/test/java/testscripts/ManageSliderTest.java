package testscripts;

import static org.testng.Assert.assertTrue;
import java.awt.AWTException;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ManageSliderPage;
import utilities.Constants;
import utilities.ExcelUtility;

public class ManageSliderTest extends Base {
	
	@Test(retryAnalyzer=retry.Retry.class,description="verify user is able to add new slider")
	public void verifyUserIsAbleToAddNewSlider() throws AWTException
	{
		String username=ExcelUtility.getString(1, 0, "LoginPage");
		String password=ExcelUtility.getString(1, 1, "LoginPage");
		String link=ExcelUtility.getString(1, 0, "ManageSliderPage");
		String fileUpload=Constants.MANAGESLIDERFILE;
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsernameOnUsernameFieldPasswordOnPasswordFieldAndClickOnSignInButton(username,password);
		ManageSliderPage managesliderpage=new ManageSliderPage(driver);
		managesliderpage.clickOnManageSliderTile().clickOnNewButton().chooseFileToUpload(fileUpload).clickOnLinkField(link).clickOnSaveButton();
		boolean isAlertMessageDisplayed=managesliderpage.verifyAlertMessage();
		assertTrue(isAlertMessageDisplayed,"user is not able to add new slider");
	}
	

}
