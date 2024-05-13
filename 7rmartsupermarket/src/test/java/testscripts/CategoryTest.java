package testscripts;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.CategoryPage;
import pages.LoginPage;
import utilities.Constants;
import utilities.ExcelUtility;

public class CategoryTest extends Base {
	
	@Test
	public void verifyUserIsAbleToAddNewCategory()
	{
		String username=ExcelUtility.getString(1, 0, "LoginPage");
		String password=ExcelUtility.getString(1, 1, "LoginPage");
		String category=ExcelUtility.getString(2, 0, "CategoryPage");
		String fileUpload=Constants.CATEGORYPAGE;
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsernameOnUsernameFieldPasswordOnPasswordFieldAndClickOnSignInButton(username,password);
		CategoryPage categorypage=new CategoryPage(driver);
		categorypage.clickOnCategoryTile().clickOnNewButton().enterCategoryOnCategoryField(category).clickOnDiscountButton().uploadfileInChooseFileField(fileUpload).clickOnNewButton();
		boolean isAlertMessageDisplayed=categorypage.verifyAlertMessage();
		assertTrue(isAlertMessageDisplayed,"user is not able to add new category");
	}

}
