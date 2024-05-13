package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.FileUploadUtility;
import utilities.PageUtility;

public class CategoryPage {
WebDriver driver;
	
	public CategoryPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//a[text()='More info '])[4]") private WebElement categoryTile;
	@FindBy(xpath="//a[text()=' New']") private WebElement newButton;
	@FindBy(xpath="//input[@id='category']") private WebElement categoryField;
	@FindBy(xpath="//li[@id='134-selectable']") private WebElement discountButton;
	@FindBy(xpath="//input[@id='main_img']") private WebElement chooseFileField;
	@FindBy(xpath="//button[@name='create']") private WebElement saveButton;
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]") private WebElement alertMessage;
	
	public CategoryPage clickOnCategoryTile()
	{
		categoryTile.click();
		return this;
	}
	public CategoryPage clickOnNewButton()
	{
		newButton.click();
		return this;
	}
	public CategoryPage enterCategoryOnCategoryField(String category)
	{
		categoryField.sendKeys(category);
		return this;
	}
	public CategoryPage clickOnDiscountButton()
	{
		discountButton.click();
		return this;
	}
	public CategoryPage uploadfileInChooseFileField(String fileUpload)
	{
		FileUploadUtility fileuploadutility=new FileUploadUtility();
		fileuploadutility.fileUploadUsingSendkeys(chooseFileField, fileUpload);
		return this;
	}
	public CategoryPage clickOnSaveButton()
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
