package AmazonAutomationAssignment.Utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShots {

public static void takeScreenShot(WebDriver driver, String Filename) {
		
		String screenShotFileName = System.getProperty("user.dir") + "//Screenshots//" + Filename +" .jpg";
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		try {
			
			FileUtils.copyFile(srcFile, new File(screenShotFileName));
			
		} catch(IOException e) {
			
			e.printStackTrace();
		}
	}
}
