package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
WebDriver driver;
	
	public LoginPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@name='username']") private WebElement usernameField;
	@FindBy(xpath="//input[@name='password']") private WebElement passwordField;
	@FindBy(xpath="//button[text()='Sign In']") private WebElement signInButton;
	@FindBy(xpath="//p[text()='Category']//parent::div") private WebElement categoryTile;
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")private WebElement alertMessage;
	
	public void enterUsernameOnUsernameFieldPasswordOnPasswordFieldAndClickOnSignInButton(String username,String password)
	{
		usernameField.sendKeys(username);
		passwordField.sendKeys(password);
		signInButton.click();
	}
	
	public boolean verifyUserIsAbleToNavigateToDashBoard()
	{
		Boolean isCategoryTileDisplayed=categoryTile.isDisplayed();
		return isCategoryTileDisplayed;
	}
	
	public boolean verifyUserisUnableToNavigateToDashboard()
	{
		Boolean isAlertMessageDisplayed=alertMessage.isDisplayed();
		return isAlertMessageDisplayed;
	}
	
	

}
