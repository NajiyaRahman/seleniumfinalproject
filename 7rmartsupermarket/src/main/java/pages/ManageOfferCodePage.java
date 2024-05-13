package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.PageUtility;

public class ManageOfferCodePage {
WebDriver driver;
	
	public ManageOfferCodePage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="(//a[@class='small-box-footer']//following::a[text()='More info '])[5]") private WebElement manageOfferCodeTile;
	@FindBy(xpath="//a[contains(@class,'rounded btn-danger')]") private WebElement newButton;
	@FindBy(xpath="//input[@id='offer_code']") private WebElement offerCodeField;
	@FindBy(xpath="//input[@value='yes']") private WebElement yesButton;
	@FindBy(xpath="//button[@name='create']") private WebElement saveButton;
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]") private WebElement alertMessage;
	
	public ManageOfferCodePage clickOnManageOfferCodeTile()
	{
		manageOfferCodeTile.click();
		return this;
	}
	public ManageOfferCodePage clickOnNewButton()
	{
		newButton.click();
		return this;
	}
	public ManageOfferCodePage enterOfferCodeInOfferCodeField(String offerCode)
	{
		offerCodeField.sendKeys(offerCode);
		return this;
	}
	public boolean selectTheTypeOfUser()
	{
		yesButton.click();
		boolean isYesButtonSelected=yesButton.isSelected();
		return isYesButtonSelected;
	}
	public ManageOfferCodePage scrollDownToViewSaveButton()
	{
		PageUtility pageutility=new PageUtility();
		pageutility.scrollToBottomUsingJavaScriptExecutor(driver);
		return this;
	}
	public ManageOfferCodePage clickOnSaveButton()
	{
		PageUtility pageutility=new PageUtility();
		pageutility.clickOnElementUsingJavaScriptExecutor(driver, saveButton);
		return this;
	}
	public boolean verifyAlertMessage()
	{
		boolean isAlertMessageDispalyed=alertMessage.isDisplayed();
		return isAlertMessageDispalyed;
	}
	
	

}
