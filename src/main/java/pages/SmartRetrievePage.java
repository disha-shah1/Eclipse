package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BrowserFactory;
import helper.DriverOperations;

public class SmartRetrievePage extends BrowserFactory{
	
	
	@FindBy(xpath = "//input[@id='srch-term']")
	WebElement quickSearch;
	

	@FindBy(xpath = "//button[@id='btnPerformSearch']")
	WebElement ShowResultQuickSearch;
	

	@FindBy(xpath = "//select[@id='retrieveTableSelect']")
	WebElement RetrieveDocumentType;
	
	@FindBy(xpath = "//input[@id='searchValue0']")
	WebElement Searchvalue;
	
	@FindBy(xpath = "//button[@id='btnShowResults']")
	WebElement ShowResult;
	
	@FindBy(xpath = "//button[@id='btnSaveSearch']")
	WebElement SaveSearchButton;
	
	@FindBy(xpath = "//input[@id='searchName']")
	WebElement SearchName;
	
	
	@FindBy(xpath = "/html/body/div[4]/div/div/div[3]/fieldset/button[2]")
	WebElement SaveSearch; 
	
	//@FindBy(xpath = "//*[@id='savedSearches']/div/span[2]/div/a[4]")
	@FindBy(xpath = "//span[contains(text(),'test')]//parent::a//following-sibling::a[@title='Delete']")
	WebElement delete;
	 
	@FindBy(xpath = "/html/body/div[3]/div[2]/div/div[2]/button[2]")
	WebElement YesDelete;
	

	
	public SmartRetrievePage()
	{
		PageFactory.initElements(driver, this);
	}

	
	//using property value
	/*public void QuickSearching(String keyword) throws InterruptedException
	{
		DriverOperations.clearFieldAndEnterStringData(quickSearch, keyword);
		DriverOperations.clickWhenElementIsClickable(ShowResultQuickSearch);
		Thread.sleep(3000);
		//return new SmartRetrievePage();
	}
	
	
	//using property value
	public void AdvanceSearching(String SearchValue) throws InterruptedException
	{
		DriverOperations.selectDropdownOptionByVisibleText(RetrieveDocumentType, "inv_header");
		DriverOperations.clearFieldAndEnterStringData(Searchvalue, SearchValue);
		DriverOperations.clickWhenElementIsClickable(ShowResult);
		Thread.sleep(3000);
	}
	*/
	//direct value
	public void QuickSearching() throws InterruptedException
	{

		DriverOperations.clearFieldAndEnterStringData(quickSearch,"adm");
		DriverOperations.clickWhenElementIsClickable(ShowResultQuickSearch);
		Thread.sleep(3000);
		//return new SmartRetrievePage();
	}
	//direct value
	public void AdvanceSearching() throws InterruptedException
	{
		driver.navigate().back();
		DriverOperations.selectDropdownOptionByVisibleText(RetrieveDocumentType, "newTable");
		DriverOperations.clearFieldAndEnterStringData(Searchvalue, "adm");
		DriverOperations.clickWhenElementIsClickable(ShowResult);
		Thread.sleep(3000);
	}
	
	public void sipmleSaveSearch(String SearchValue, String searchName) throws InterruptedException
	{
		DriverOperations.selectDropdownOptionByVisibleText(RetrieveDocumentType, "inv_header");
		DriverOperations.clearFieldAndEnterStringData(Searchvalue, SearchValue);
		DriverOperations.clickWhenElementIsClickable(SaveSearchButton);
		DriverOperations.clearFieldAndEnterStringData(SearchName, searchName);
		DriverOperations.clickWhenElementIsClickable(SaveSearch);
		Thread.sleep(3000);
	}
	public void deleteSearch() throws InterruptedException
	{
		DriverOperations.clickWhenElementIsClickable(delete);
		DriverOperations.clickWhenElementIsClickable(YesDelete);
		Thread.sleep(3000);
	}
}
