package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BrowserFactory;
import helper.DriverOperations;
import pages.HomePage;
import pages.LoginPage;
import pages.SmartRetrievePage;
import testbase.TestBase;

public class SmartRetrievePageTest extends TestBase {
	
	
	LoginPage loginPage;
	HomePage homePage;
	SmartRetrievePage smartretrievePage;
	
	public SmartRetrievePageTest()
	{
		super();
	}
	
	@BeforeMethod(groups = { "SmartRetrieve" })
	public void setUp() throws Exception {
		BrowserFactory.launchApplication(prop.getProperty("Browser"), prop.getProperty("URL"));
		loginPage = new LoginPage();
		smartretrievePage = new SmartRetrievePage();
		homePage =  loginPage.login(prop.getProperty("UserName"),prop.getProperty("Password"));	
		Thread.sleep(2000);
		//smartDepositPage = homePage.clickDepositLink();
		DriverOperations.expandTopNavigationMenuAndPerformNavitation("Select application", "SmartRetrieve");
		Thread.sleep(3000);
		
	}
	/* with property value
	@Test(priority = 1, groups = { "SmartRetrieve" })
	public void QuickSearch() throws Throwable {
		smartretrievePage.QuickSearching(prop.getProperty("QuickSearchKeyword"));
		//smartretrievePae.QuickSearching("adm");
		Thread.sleep(3000);
		
	}
	
	@Test(priority = 2, groups = { "SmartRetrieve" }, alwaysRun=true)
	public void AdvSearch() throws Throwable {
		smartretrievePage.AdvanceSearching(prop.getProperty("AdvanceSearchkeyword"));
		Thread.sleep(3000);
		
		
	}
	*/
	//without property value.
	@Test(priority = 1, groups = { "SmartRetrieve" })
	public void QuickSearch() throws Throwable {
		smartretrievePage.QuickSearching();
		Thread.sleep(3000);
		
	}
	@Test(priority = 2, groups = { "SmartRetrieve" }, alwaysRun=true)
	public void AdvSearch() throws Throwable {
		smartretrievePage.AdvanceSearching();
		Thread.sleep(3000);
		
		
	}
	@Test(priority = 3, groups = { "SmartRetrieve" }, alwaysRun=true)
	public void SimpleSaveSearch() throws Throwable {
		smartretrievePage.sipmleSaveSearch(prop.getProperty("AdvanceSearchkeyword"),prop.getProperty("SearchName"));
		Thread.sleep(3000);
		
	}

	@Test(priority = 4, groups = { "SmartRetrieve" })
	public void deletesearch() throws Throwable {
		smartretrievePage.deleteSearch();
		Thread.sleep(3000);
		
	}
	@AfterMethod(groups = { "SmartRetrieve" })
	public void tearDown() throws Exception{
		DriverOperations.logOut();
	}

}
