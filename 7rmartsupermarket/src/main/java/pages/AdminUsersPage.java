package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.PageUtility;
import utilities.WaitUtility;

public class AdminUsersPage {
WebDriver driver;
	
	public AdminUsersPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//a[@class='small-box-footer']//following::a[text()='More info '])[1]") private WebElement adminUsersTile;
	@FindBy(xpath="//a[text()=' New']") private WebElement newButton;
	@FindBy(xpath="//input[@id='username']") private WebElement adminUsernameField;
	@FindBy(xpath="//input[@id='password']") private WebElement adminPasswordField;
	@FindBy(xpath="//select[@id='user_type']") private WebElement selectUserType;
	@FindBy(xpath="//button[@name='Create']") private WebElement saveButton;
	@FindBy(xpath="//div[contains(@class,'success alert-dismissible')]")private WebElement alertMessage;
	@FindBy(xpath="//a[text()=' Search']") private WebElement searchButton;
	@FindBy(xpath="//input[@id='un']") private WebElement searchUsernameField;
	@FindBy(xpath="//select[@id='ut']") private WebElement searchSelectUserType;
	@FindBy(xpath="//button[@name='Search']") private WebElement finalSearchButton;
	@FindBy(xpath="//table[contains(@class,'table')]//tr//td[text()='Naji88']") private WebElement searchName;
	@FindBy(xpath="//div[@class='card']") private WebElement table;
	@FindBy(xpath="//table[contains(@class,'bordered table')]//tbody//tr//td[5]//a[2]") private WebElement deleteButton;
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")private WebElement userDeletedAlertMessage;
	@FindBy(xpath="//table[contains(@class,'bordered table')]//tbody//tr//td[5]//a[2]")private WebElement editButton;
	@FindBy(xpath="//button[@name='Update']")private WebElement updateButton;
	@FindBy(xpath="//div[contains(@class,'alert alert-success')]")private WebElement userUpdatedAlertMessage;
	
	
	public AdminUsersPage clickOnAdminUsersTile()
	{
		adminUsersTile.click();
		return this;
	}
	
	public AdminUsersPage clickOnNewButton()
	{
		newButton.click();
		return this;
	}
	
	public AdminUsersPage enterUsernameAndPassword(String adminUsername,String adminPassword,String userType )
	{
		adminUsernameField.sendKeys(adminUsername);
		adminPasswordField.sendKeys(adminPassword);
		PageUtility pageutility=new PageUtility();
		pageutility.selectDropdownByUsingValue(selectUserType, userType);
		return this;
	}
	public AdminUsersPage clickOnSaveButton()
	{
		saveButton.click();
		return this;
	}
	public boolean verifyAlertMessage()
	{
		Boolean isAlertMessageDisplayed=alertMessage.isDisplayed();
		return isAlertMessageDisplayed;
	}
	public AdminUsersPage clickOnSearchButton()
	{
		searchButton.click();
		return this;
	}
	public AdminUsersPage enterUsernameOnSearchUsernameField(String searchUsername,String userType)
	{
		searchUsernameField.sendKeys(searchUsername);
		PageUtility pageutility=new PageUtility();
		pageutility.selectDropdownByUsingValue(searchSelectUserType, userType);
		return this;
	}
	public AdminUsersPage clickOnFinalSearchButton() 
	{
		finalSearchButton.click();
		return this;
	}
	public boolean searchNameInTable()
	{
		Boolean isNameDisplayed=searchName.isDisplayed();
		return isNameDisplayed;
	}
	public AdminUsersPage clickOnDeleteButton()
	{
		deleteButton.click();
		return this;
	}
	public AdminUsersPage handleConfirmationAlert()
	{
		WaitUtility waitutility=new WaitUtility();
		waitutility.explicitWaitToWaitForAlert(driver);
		PageUtility pageutility=new PageUtility();
		pageutility.toAcceptAlert(driver);
		return this;
	}
	public boolean verifyUserDeletedAlertMessage()
	{
		boolean isUserDeletedAlertMessageDisplayed=userDeletedAlertMessage.isDisplayed();
		return isUserDeletedAlertMessageDisplayed;
	}
	public AdminUsersPage clickOnEditButton()
	{
		editButton.click();
		return this;
	}
	public AdminUsersPage selectTheNewUserType(String updatedUserType)
	{
		PageUtility pageutility=new PageUtility();
		pageutility.selectDropdownByUsingValue(selectUserType, updatedUserType);
		return this;
	}
	public AdminUsersPage clickOnUpdateButton()
	{
		updateButton.click();
		return this;
	}
	public boolean verifyUserUpdatedAlertMessage()
	{
		boolean isUserUpdatedAlertMessageDisplayed=userUpdatedAlertMessage.isDisplayed();
		return isUserUpdatedAlertMessageDisplayed;
	}
	

}
