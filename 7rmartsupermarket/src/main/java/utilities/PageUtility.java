package utilities;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
public class PageUtility {
	
	public void clickAndHoldOnElement(WebElement element, WebDriver driver) 
	{
		Actions actions = new Actions(driver);
		actions.clickAndHold(element).build().perform();
	}
	public void moveToElement(WebElement element, WebDriver driver) 
	{
		Actions actions = new Actions(driver);
		actions.moveToElement(element).build().perform();
	}
	public void doubleClickOnElement(WebElement element, WebDriver driver) 
	{
		Actions actions = new Actions(driver);
		actions.doubleClick(element).build().perform();
	}
	public void rightClickOnElement(WebElement element, WebDriver driver) 
	{
		Actions actions = new Actions(driver);
		actions.contextClick(element).build().perform();
	}
	public void dragAndDropTheElement(WebElement element, WebDriver driver) 
	{
		Actions actions = new Actions(driver);
		actions.dragAndDrop(element, element).build().perform();
	}
	
	
	public void selectDropdownByUsingValue(WebElement element,String value)
	{
		Select select=new Select(element);
		select.selectByValue(value);
	}
	public void selectDropdownByUsingVisibleText(WebElement element,String text)
	{
		Select select=new Select(element);
		select.selectByVisibleText(text);
	}
	public void selectDropdownByUsingIndex(WebElement element,int index)
	{
		Select select=new Select(element);
		select.selectByIndex(index);
	}
	
	public void scrollToTopUsingJavaScriptExecutor(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");
	}
	
	public void scrollToBottomUsingJavaScriptExecutor(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-400)", "");
	}
	public void clickOnElementUsingJavaScriptExecutor(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}
	
	public void scrollUntilTheElementInViewUsingJavaScriptExecutor(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}
	
	public String ToGetAttributeValue(WebElement element,String attribute)
	{
		String attributeValue=element.getAttribute(attribute);
		return attributeValue;
	}
	public void toAcceptAlert(WebDriver driver) 
	{
		driver.switchTo().alert().accept();
	}
	public void toCancelAlert(WebDriver driver) 
	{
		driver.switchTo().alert().dismiss();
	}
	public String getTextOfAlert(WebDriver driver)
	{
		return driver.switchTo().alert().getText();
	}
	public void enterValueToHandleAlert(WebDriver driver,String value)
	{
		driver.switchTo().alert().sendKeys(value);
	}
	public int getRowCount(List<WebElement> rows)
	{
		return rows.size();		
	}
	public int getColumnCount(List<WebElement> columns)
	{
		return columns.size();		
	}
	
	
}
