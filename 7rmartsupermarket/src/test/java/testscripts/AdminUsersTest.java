package testscripts;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;
import pages.AdminUsersPage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class AdminUsersTest extends Base {
	
	@Test(retryAnalyzer=retry.Retry.class,description="verify user is able to add new admin",priority=1)
	public void verifyUserIsAbleToAddNewAdmin()
	{
		String username=ExcelUtility.getString(1, 0, "LoginPage");
		String password=ExcelUtility.getString(1, 1, "LoginPage");
		String adminUsername=ExcelUtility.getString(1, 0, "AdminUserPage");
		String adminPassword=ExcelUtility.getString(1, 1, "AdminUserPage");
		String userType=ExcelUtility.getString(2, 2, "AdminUserPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsernameOnUsernameFieldPasswordOnPasswordFieldAndClickOnSignInButton(username,password);
		AdminUsersPage adminuserspage=new AdminUsersPage(driver);
		adminuserspage.clickOnAdminUsersTile().clickOnNewButton().enterUsernameAndPassword(adminUsername, adminPassword, userType).clickOnSaveButton();
		boolean isAlertMessageDisplayed=adminuserspage.verifyAlertMessage();
		assertTrue(isAlertMessageDisplayed, "user is not able to add a new admin");
	}
	@Test(retryAnalyzer=retry.Retry.class,description="verify user is able to search admin",priority=3)
	public void verifyUserIsAbleToSearchAdmin()
	{
		String username=ExcelUtility.getString(1, 0, "LoginPage");
		String password=ExcelUtility.getString(1, 1, "LoginPage");
		String searchUsername=ExcelUtility.getString(3, 0, "AdminUserPage");
		String userType=ExcelUtility.getString(2, 2, "AdminUserPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsernameOnUsernameFieldPasswordOnPasswordFieldAndClickOnSignInButton(username,password);
		AdminUsersPage adminuserspage=new AdminUsersPage(driver);
		adminuserspage.clickOnAdminUsersTile().clickOnSearchButton().enterUsernameOnSearchUsernameField(searchUsername,userType).clickOnFinalSearchButton();
		boolean isNameDisplayed=adminuserspage.searchNameInTable();
		assertTrue(isNameDisplayed, "admin name is not found in the table");
	}
	@Test(retryAnalyzer=retry.Retry.class,description="verify user is able to delete admin user",priority=2)
	public void verifyUserIsAbleToDeleteAnAdminUser()
	{
		String username=ExcelUtility.getString(1, 0, "LoginPage");
		String password=ExcelUtility.getString(1, 1, "LoginPage");
		String searchUsername=ExcelUtility.getString(4, 0, "AdminUserPage");
		String userType=ExcelUtility.getString(4, 2, "AdminUserPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsernameOnUsernameFieldPasswordOnPasswordFieldAndClickOnSignInButton(username,password);
		AdminUsersPage adminuserspage=new AdminUsersPage(driver);
		adminuserspage.clickOnAdminUsersTile().clickOnSearchButton().enterUsernameOnSearchUsernameField(searchUsername,userType).clickOnFinalSearchButton();
		adminuserspage.clickOnDeleteButton().handleConfirmationAlert();
		boolean isUserDeletedAlertMessageDisplayed=adminuserspage.verifyUserDeletedAlertMessage();
		assertTrue(isUserDeletedAlertMessageDisplayed, "user is not able to delete admin users");
	}
	
	@Test(retryAnalyzer=retry.Retry.class,description="verify user is able to update usertype of an existing user",priority=4)
	public void verifyUserIsAbleToUpdateUserTypeOfAnExistingUser()
	{
		String username=ExcelUtility.getString(1, 0, "LoginPage");
		String password=ExcelUtility.getString(1, 1, "LoginPage");
		String searchUsername=ExcelUtility.getString(5, 0, "AdminUserPage");
		String userType=ExcelUtility.getString(5, 5, "AdminUserPage");
		String updatedUserType=ExcelUtility.getString(2, 2, "AdminUserPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsernameOnUsernameFieldPasswordOnPasswordFieldAndClickOnSignInButton(username,password);
		AdminUsersPage adminuserspage=new AdminUsersPage(driver);
		adminuserspage.clickOnAdminUsersTile().clickOnSearchButton().enterUsernameOnSearchUsernameField(searchUsername,userType).clickOnFinalSearchButton();
		adminuserspage.clickOnEditButton().selectTheNewUserType(updatedUserType).clickOnUpdateButton();
	    boolean isUserUpdatedAlertMessageDisplayed=adminuserspage.verifyUserUpdatedAlertMessage();
		assertTrue(isUserUpdatedAlertMessageDisplayed, "user is not able to update admin userType");
	}
		

}
