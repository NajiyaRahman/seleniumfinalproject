package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.FileUploadUtility;
import utilities.PageUtility;

public class MobileSliderPage {
WebDriver driver;
	
	public MobileSliderPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//a[text()='More info '])[12]") private WebElement mobileSliderTile;
	@FindBy(xpath="//i[contains(@class,'fa-edit')]//following::a[text()=' New']") private WebElement newButton;
	@FindBy(xpath="//select[@id='cat_id']") private WebElement selectCategoryField;
	@FindBy(xpath="//input[@id='main_img']") private WebElement chooseFileField;
	@FindBy(xpath="//button[@name='create']") private WebElement saveButton;
	@FindBy(xpath="//div[contains(@class,'alert-success')]") private WebElement alertMessage;
	
	public MobileSliderPage clickOnMobileSliderTile()
	{
		mobileSliderTile.click();
		return this;
	}
	public MobileSliderPage clickOnNewButton()
	{
		newButton.click();
		return this;
	}
	public MobileSliderPage selectCategoryFromCategoryDropdown(String category)
	{
		PageUtility pageutility=new PageUtility();
		pageutility.selectDropdownByUsingVisibleText(selectCategoryField, category);
		return this;
	}
	public MobileSliderPage chooseFileToUpload(String fileUpload)
	{
		FileUploadUtility fileuploadutility=new FileUploadUtility();
		fileuploadutility.fileUploadUsingSendkeys(chooseFileField, fileUpload);
		return this;
	}
	public MobileSliderPage clickOnSaveButton()
	{
		PageUtility pageutility=new PageUtility();
		pageutility.clickOnElementUsingJavaScriptExecutor(driver, saveButton);
		return this;
	}
	public boolean verifyAlertMessage()
	{
		boolean isAlertMessageDisplayed=alertMessage.isDisplayed();
		return isAlertMessageDisplayed;
	}

}
