package utilities;

import java.time.Duration;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {
	public static final long IMPLICIT_WAIT = 10;
	public static final long EXPLICIT_WAIT = 30;
	public static final long FLUENT_WAIT = 30;
	public static final long POLLING_TIME = 5;
	
	public void implicitWait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT));
	}
	
	public void explicitWaitToWaitUntilTheElementToBeClickable(WebDriver driver,WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	public void explicitWaitToWaitUntilTheLocatorSelectsTheElement(WebDriver driver,WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.elementToBeSelected(element));
	}

	public void explicitWaitToWaitForTextContainedInElement(WebDriver driver,WebElement element,String text)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.textToBePresentInElement(element, text));
	}
	public void explicitWaitToWaitForAlert(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.alertIsPresent());
	}
	public void explicitWaitForCheckingFrameToBeAvailableAndSwitchtoIt(WebDriver driver,WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
	}
	public void explicitWaitForElementToBeVisible(WebDriver driver,WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void fluentWaitForElementToBeVisible(WebDriver driver,WebElement element)
	{
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
		        .withTimeout(Duration.ofSeconds(FLUENT_WAIT))
		        .pollingEvery(Duration.ofSeconds(POLLING_TIME))
		        .ignoring(NoSuchElementException.class);
		
		fluentWait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void fluentWaitForAlert(WebDriver driver)
	{
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
		        .withTimeout(Duration.ofSeconds(FLUENT_WAIT))
		        .pollingEvery(Duration.ofSeconds(POLLING_TIME))
		        .ignoring(NoSuchElementException.class);
		
		fluentWait.until(ExpectedConditions.alertIsPresent());
	}
	public void fluentWaitForFrameToBeAvailableAndSwitchInToIt(WebDriver driver, WebElement element)
	{
	    Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)	
	        .withTimeout(Duration.ofSeconds(FLUENT_WAIT))
	        .pollingEvery(Duration.ofSeconds(POLLING_TIME))
	        .ignoring(NoSuchElementException.class);
	    
	    fluentWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
	}
	public void fluentwaitElementToBeClickable(WebDriver driver, WebElement element)
	{
	    Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)	
	        .withTimeout(Duration.ofSeconds(FLUENT_WAIT))
	        .pollingEvery(Duration.ofSeconds(POLLING_TIME))
	        .ignoring(NoSuchElementException.class);
	    
	    fluentWait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
}
