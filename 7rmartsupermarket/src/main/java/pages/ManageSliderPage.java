package pages;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.FileUploadUtility;
import utilities.WaitUtility;

public class ManageSliderPage {
WebDriver driver;
	
	public ManageSliderPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//a[@class='small-box-footer']//following::a[text()='More info '])[6]") private WebElement manageSliderTile;
	@FindBy(xpath="//a[contains(@class,'btn-danger')]") private WebElement newButton;
	@FindBy(xpath="//input[@id='main_img']") private WebElement chooseFileField;
	@FindBy(xpath="//input[@id='link']") private WebElement linkField;
	@FindBy(xpath="//button[@name='create']") private WebElement saveButton;
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]") private WebElement alertMessage;
	
	public ManageSliderPage clickOnManageSliderTile()
	{
		manageSliderTile.click();
		return this;
	}
	public ManageSliderPage clickOnNewButton()
	{
		newButton.click();
		return this;
	}
	public ManageSliderPage chooseFileToUpload(String chooseFileField ) throws AWTException
	{
		FileUploadUtility fileuploadutility=new FileUploadUtility();
		fileuploadutility.fileUploadUsingRobotClass(chooseFileField);
		return this;
	}
	public ManageSliderPage clickOnLinkField(String link)
	{
		linkField.sendKeys(link);
		return this;
	}
	public ManageSliderPage clickOnSaveButton()
	{
		WaitUtility waitutility=new WaitUtility();
		waitutility.explicitWaitForElementToBeVisible(driver, saveButton);
		saveButton.click();
		return this;
	}
	public boolean verifyAlertMessage()
	{
		boolean isAlertMessageDisplayed=alertMessage.isDisplayed();
		return isAlertMessageDisplayed;
	}
	
	

}
