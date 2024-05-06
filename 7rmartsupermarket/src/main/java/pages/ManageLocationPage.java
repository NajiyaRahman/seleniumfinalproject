package pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageLocationPage {
WebDriver driver;
	
	public ManageLocationPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="(//a[@class='small-box-footer']//following::a[text()='More info '])[10]") private WebElement manageLocationTile;
	@FindBy(xpath="//table[contains(@class,'table-hover table-sm')]//tbody//child::tr") private List<WebElement> rows;
	@FindBy(xpath="//table[contains(@class,'table-hover table-sm')]//tbody//tr//td[1]") private List<WebElement> firstColumn;
	
	
	public void clickOnManageLocationTile()
	{
		manageLocationTile.click();
	}
	
	public int findRowSizeOfTable()
	{
		int rowsize=rows.size();
		return rowsize;
	}
	
	public boolean searchAParticularNameIsPresent(String searchName)
	{
		Boolean nameFound=false;
		for(WebElement cell:firstColumn)
		{
			if(cell.getText().contains(searchName))
			{
				nameFound=true;
				break;
			}
		}
		return nameFound;
	}
	   
    
	
	
	
}
