package testscripts;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageOfferCodePage;
import utilities.ExcelUtility;

public class ManageOfferCodeTest extends Base {
	
	@Test(retryAnalyzer=retry.Retry.class,description="verify user is able to add Offercode")
	public void verifyUserIsAbleToAddOffercode()
	{
	String username=ExcelUtility.getString(1, 0, "LoginPage");
	String password=ExcelUtility.getString(1, 1, "LoginPage");
	String offerCode=ExcelUtility.getString(3, 0, "ManageOfferCodePage");
	LoginPage loginpage=new LoginPage(driver);
	loginpage.enterUsernameOnUsernameFieldPasswordOnPasswordFieldAndClickOnSignInButton(username,password);
	ManageOfferCodePage manageoffercodepage=new ManageOfferCodePage(driver);
	manageoffercodepage.clickOnManageOfferCodeTile().clickOnNewButton().enterOfferCodeInOfferCodeField(offerCode);
	manageoffercodepage.selectTheTypeOfUser();
	manageoffercodepage.scrollDownToViewSaveButton().clickOnSaveButton();
	boolean isAlertMessageDisplayed=manageoffercodepage.verifyAlertMessage();
	assertTrue(isAlertMessageDisplayed,"user is not able to add offer code");
	
	}
}
