package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BrowserFactory;
import helper.DriverOperations;

public class DepositAutoITPage extends BrowserFactory {
	
	@FindBy(xpath = "//input[@id='UploadedFileBtn']")
	WebElement upload;
	
	
	@FindBy(xpath = "//select[@id='depositTableSelect']")
	WebElement DocumentType;
	
	@FindBy(xpath = "//button[@id='btnDepositDocument']")
	WebElement depositDoc;
	
	@FindBy(xpath = "//button[@id='btnDepositAllDocument']")
	WebElement depositDocAll;
	
	@FindBy(xpath = "//input[@id='DP_ARCH_DATE']")
	WebElement ArchiveDate;

	@FindBy(xpath = "//div[contains(@class,'ng-binding ng-scope')]")
	WebElement SuccessMessage;
	
	public DepositAutoITPage()
	{
		PageFactory.initElements(driver, this);
	}

	public void depositDo() throws IOException, InterruptedException
	{
		DriverOperations.clickWhenElementIsClickable(upload);
	Thread.sleep(2000);
		Runtime.getRuntime().exec("D:\\AutoIT\\FileUpload.exe");
		Thread.sleep(2000);
		DriverOperations.selectDropdownOptionByVisibleText(DocumentType, "newTable");
		DriverOperations.clearFieldAndEnterStringData(ArchiveDate, "12/24/2018");
		Thread.sleep(2000);
		DriverOperations.waitandClick(depositDoc);
		Thread.sleep(2000);
	}
}
