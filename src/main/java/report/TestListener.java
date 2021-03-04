package report;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import base.BrowserFactory;
//import pages.Module;

public class TestListener extends BrowserFactory implements ITestListener {
	
	//Extent Report Declarations
		private static ExtentReports extent = ExtentManager.createInstance();
		public static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
		
		public synchronized void onStart(ITestContext context) {
			System.out.println("Extent Reports Version 3 Test Suite started!");		
		}

		
		public synchronized void onFinish(ITestContext context) {
			System.out.println(("Extent Reports Version 3  Test Suite is ending!"));
			extent.flush();
		}

		
		public synchronized void onTestStart(ITestResult result) {
			System.out.println((result.getMethod().getMethodName() + " started!"));
			ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName(),result.getMethod().getDescription());
			test.set(extentTest);
		}

		
		public synchronized void onTestSuccess(ITestResult result) {
			System.out.println((result.getMethod().getMethodName() + " passed!"));
			test.get().pass(MarkupHelper.createLabel(result.getName()+ " - Test paased", ExtentColor.GREEN));
			//test.get().pass("Test passed");
		}

		
		public synchronized void onTestFailure(ITestResult result) {
			System.out.println((result.getMethod().getMethodName() + " failed!"));
			test.get().fail(MarkupHelper.createLabel(result.getName()+ " - Test failed due to below issue/error: ", ExtentColor.RED));
			test.get().fail(result.getThrowable());
			
			//Take screenshot and allow automatic saving of media files relative to the report
			//Extentreports log and screenshot operations for failed tests.
			try {
				File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//				String base64Screenshot = "data:image/png;base64,"+((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
				String path=prop.getProperty("Screenshot_Folder")+System.currentTimeMillis()+".png";
				File destination=new File(path);
				FileUtils.copyFile(src, destination);
				test.get().fail("Below is Screen Shot of Error Page/Pop-up: ", MediaEntityBuilder.createScreenCaptureFromPath(path).build());
//				test.get().fail("Below is Screen Shot of Error Page/Pop-up: ", MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Screen-capture has been taken but not attached to Extent report");
			}

		}

		
		public synchronized void onTestSkipped(ITestResult result) {
			System.out.println((result.getMethod().getMethodName() + " skipped!"));
			test.get().skip(MarkupHelper.createLabel(result.getName()+ " - Test skipped due to below issue/error: ", ExtentColor.AMBER));
			test.get().skip(result.getThrowable());
		}

		
		public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
			System.out.println(("onTestFailedButWithinSuccessPercentage for " + result.getMethod().getMethodName()));
		}

}
