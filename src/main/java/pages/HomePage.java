package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BrowserFactory;
import helper.DriverOperations;

public class HomePage extends BrowserFactory {

	@FindBy(xpath = "//div[contains(text(),'SmartDeposit')]")
	WebElement SmartDepositLink;
	
	@FindBy(xpath = "//html")
	WebElement blank;
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
		
	}

	public boolean verifydepositlink(){
		blank.click();
		return DriverOperations.isDisplayed(SmartDepositLink);
	}

	public SmartDepositPage clickDepositLink() {
		DriverOperations.expandTopNavigationMenuAndPerformNavitation("Select application", "SmartDeposit");
		return new SmartDepositPage();
	}
}
