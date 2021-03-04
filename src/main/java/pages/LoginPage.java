package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import base.BrowserFactory;
import helper.DriverOperations;

public class LoginPage extends BrowserFactory {
	
	//Page Factory - OR:
		/*@FindBy(how=How.ID,using="UserName")
		public static WebElement UserNameField;

		@FindBy(how=How.ID,using="Password")
		public static WebElement PasswordField;

		@FindBy(xpath="//button[@id='SignIn']")
		public static WebElement LoginButton;
		
		@FindBy(how=How.XPATH,using="//a[@class='loginLogo col-sm-12']")
		public static WebElement V1Logo;
*/
		
	@FindBy(xpath="//input[@id='UserName']")
	public static WebElement UserNameField;

	@FindBy(xpath="//input[@id='Password']")
	public static WebElement PasswordField; 
	
	
	@FindBy(xpath="//mosaic-button[@id='SignIn']/button[@type='button']")
	public static WebElement LoginButton; 
		
		//Initializing the Page Objects:
		public LoginPage(){
			PageFactory.initElements(driver, this);
		}

		//Actions:
		public String validateLoginPageTitle(){
			return driver.getTitle();
		}
		
		//public boolean validateV1Image(){
		//	return DriverOperations.isDisplayed(V1Logo);
		//}
		
		public HomePage login(String UserName, String Password) throws InterruptedException
		{
			
			DriverOperations.clearFieldAndEnterStringData(UserNameField, UserName);
			DriverOperations.clearFieldAndEnterStringData(PasswordField, Password);
			DriverOperations.clickWhenElementIsClickable(LoginButton);
			Thread.sleep(2000);
			return new HomePage();
		}

}
