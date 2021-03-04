package testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import base.BrowserFactory;

public class TestBase extends BrowserFactory {
	
	public TestBase(){
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("./Properties/v1core.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@BeforeSuite(alwaysRun = true)
	public void initiateSute() throws Exception
	{ 
//		DeleteExcelFile.deleteExcel();
//		ExcelWriteUtility.writeDataToExcel();
//		TestUtility.deleteFilesAndSubFoldersNotTheDirectory();
//		TestUtility.createScreenShotsDirectory();
	}
	
//	@AfterSuite(alwaysRun = true)
//	public void sendReportEmailAndCompleteTestSuite() throws EmailException, Exception
//		{
//		//TestUtility.sendEmail();	
//		}


}
