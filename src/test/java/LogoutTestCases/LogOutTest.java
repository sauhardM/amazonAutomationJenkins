package LogoutTestCases;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import AmazonAutomationAssignment.Utilities.ReadingFileProperties;
import AmazonPages.BasePage;
import AmazonPages.LoginPage;
import AmazonPages.UserAccountPage;


public class LogOutTest extends BasePage {
	
	@Test
	public void testing_logout() throws Exception {
		// TODO Auto-generated method stub
		LoginPage.login(driver, test, ReadingFileProperties.getProperty("username"),ReadingFileProperties.getProperty("password"));
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		test.log(LogStatus.INFO, "implicit wait applied");
		
		WebElement navBar = driver.findElement(UserAccountPage.hoverNav_userAccount);
		Actions actions = new Actions(driver);
		
		actions.moveToElement(navBar).build().perform();
		test.log(LogStatus.INFO, "curser moved to user account navigation bar option");
		
		WebElement signOut = driver.findElement(UserAccountPage.btn_signOut);
		actions.moveToElement(signOut).build().perform();
		test.log(LogStatus.INFO, "curser moved to 'signout' i'e; sub options of user account navigation bar option");

		driver.findElement(UserAccountPage.btn_signOut).click();
		test.log(LogStatus.INFO, "user signed out button clicked");
		
		Assert.assertEquals(driver.getTitle(),"Amazon Sign In");
		test.log(LogStatus.INFO, "test case passed 'driver.title' assertion and redirected to SignIn page again.");
		
	}
}
