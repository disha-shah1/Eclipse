package tests;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BrowserFactory;
import helper.DriverOperations;
import pages.DepositAutoITPage;
import pages.HomePage;
import pages.LoginPage;
import testbase.TestBase;

public class DepositAutoITtest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	DepositAutoITPage depositAutoITPage;
	
	public DepositAutoITtest() {
		// TODO Auto-generated constructor stub
		super();
	}

	
	@BeforeMethod(groups = { "SmartDeposit" })
	public void setUp() throws Exception {
		BrowserFactory.launchApplication(prop.getProperty("Browser"), prop.getProperty("URL"));
		loginPage = new LoginPage();
		depositAutoITPage = new DepositAutoITPage();
		homePage =  loginPage.login(prop.getProperty("UserName"),prop.getProperty("Password"));	
		Thread.sleep(2000);
		//smartDepositPage = homePage.clickDepositLink();
		DriverOperations.expandTopNavigationMenuAndPerformNavitation("Select application", "SmartDeposit");
		Thread.sleep(3000);
		
	}
	@Test()
	public void depositDoc() throws IOException, InterruptedException
	{
		depositAutoITPage.depositDo();
	}
	
}
