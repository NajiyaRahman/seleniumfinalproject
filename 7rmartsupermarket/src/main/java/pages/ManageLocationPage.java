package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class ManageLocationPage {
WebDriver driver;
	
	public ManageLocationPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="(//a[text()='More info '])[11]") private WebElement manageLocationTile;
	@FindBy(xpath="//a[text()=' New']") private WebElement newButton;
	@FindBy(xpath="//select[@id='country_id']") private WebElement countryField;
	@FindBy(xpath="//select[@id='st_id']") private WebElement stateField;
	@FindBy(xpath="//input[@id='location']") private WebElement locationField;
	@FindBy(xpath="//input[@id='delivery']") private WebElement deliveryChargeField;
	@FindBy(xpath="//button[@name='create']") private WebElement saveButton;
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]") private WebElement alertMessage;
	@FindBy(xpath="//a[text()=' Search']") private WebElement searchButton;
	@FindBy(xpath="//button[@name='Search']") private WebElement finalSearchButton;
	@FindBy(xpath="//table[contains(@class,'table-sm')]//tbody") private WebElement row;
	
	public ManageLocationPage clickOnManageLocationTile()
	{
		manageLocationTile.click();
		return this;
	}
	public ManageLocationPage clickOnNewButton()
	{
		newButton.click();
		return this;
	}
	public ManageLocationPage selectCountryFromCountryDropdown(String country)
	{
		PageUtility pageutility=new PageUtility();
		pageutility.selectDropdownByUsingVisibleText(countryField, country);
		return this;
	}
	public ManageLocationPage selectStateFromStateDropdown(String text)
	{
		PageUtility pageutility=new PageUtility();
		pageutility.selectDropdownByUsingVisibleText(stateField, text);
		return this;
	}
	public ManageLocationPage enterlocationInLocationField(String location)
	{
		locationField.sendKeys(location);
		return this;
	}
	public ManageLocationPage enterDeliveryChargeOnDeliveryChargeField(String deliveryCharge)
	{
		deliveryChargeField.sendKeys(deliveryCharge);
		return this;
	}
	public ManageLocationPage clickOnSaveButton()
	{
		saveButton.click();
		return this;
	} 
	public boolean verifyAlertMessage()
	{
		boolean isAlertMessageDisplayed=alertMessage.isDisplayed();
		return isAlertMessageDisplayed;
	}
	
    
	
	
	
}
