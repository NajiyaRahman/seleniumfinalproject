package testscripts;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base{
	
	@Test(groups= {"regression"},retryAnalyzer=retry.Retry.class,description="verify user is able to login with valid username and password")
	public void verifyUserIsAbleToLoginWithValidUsernameAndValidPassword()
	{
		String username=ExcelUtility.getString(1, 0, "LoginPage");
		String password=ExcelUtility.getString(1, 1, "LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsernameOnUsernameFieldPasswordOnPasswordFieldAndClickOnSignInButton(username,password);
		boolean isCategoryTileDisplayed=loginpage.verifyUserIsAbleToNavigateToDashBoard();
		assertTrue(isCategoryTileDisplayed,"User is not able to login with valid username and password");
	}
	
	@Test(groups= {"regression","smoke"},retryAnalyzer=retry.Retry.class,description="verify user is able to login with invalid username and valid password")
	public void verifyUserIsUnableToLoginWithInvalidUsernameAndValidPassword()
	{
		String username=ExcelUtility.getString(2, 0, "LoginPage");
		String password=ExcelUtility.getString(2, 1, "LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsernameOnUsernameFieldPasswordOnPasswordFieldAndClickOnSignInButton(username,password);
		Boolean isAlertMessageDisplayed=loginpage.verifyUserisUnableToNavigateToDashboard();
		assertTrue(isAlertMessageDisplayed,"User is able to login even if invalid username and valid password is entered");
	}
	
	@Test(groups= {"smoke"},retryAnalyzer=retry.Retry.class,description="verify user is able to login with valid username and invalid password")
	public void verifyUserIsUnableToLoginWithvalidUsernameAndInValidPassword()
	{
		String username=ExcelUtility.getString(3, 0, "LoginPage");
		String password=ExcelUtility.getString(3, 1, "LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsernameOnUsernameFieldPasswordOnPasswordFieldAndClickOnSignInButton(username,password);
		Boolean isAlertMessageDisplayed=loginpage.verifyUserisUnableToNavigateToDashboard();
		assertTrue(isAlertMessageDisplayed,"User is able to login even if valid username and invalid password is entered");
	}
	@Test(dataProvider="LoginProvider",retryAnalyzer=retry.Retry.class,description="verify user is able to login with invalid username and password")
	public void verifyUserIsUnableToLoginWithInvalidUsernameAndInValidPassword(String username,String password)
	{
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsernameOnUsernameFieldPasswordOnPasswordFieldAndClickOnSignInButton(username,password);
		Boolean isAlertMessageDisplayed=loginpage.verifyUserisUnableToNavigateToDashboard();
		assertTrue(isAlertMessageDisplayed,"User is able to login even if invalid username and invalid password is entered");
	}
	
	@DataProvider(name = "LoginProvider")
	public Object[][] getDataFromTestData() {
		return new Object[][] { { ExcelUtility.getString(4, 0, "LoginPage"), ExcelUtility.getString(4, 1, "LoginPage") },

		};
	}
}
