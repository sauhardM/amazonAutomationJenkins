package AmazonAutomationAssignment.LoginTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.apache.logging.log4j.*;
import com.relevantcodes.extentreports.LogStatus;

import AmazonPages.BasePage;
import AmazonPages.LoginPage;
import AmazonPages.UserAccountPage;
import AmazonPages.UserPasswordPage;

public class LoginTest extends BasePage {
	
	
	
	 @DataProvider(name = "usersTetsData")
	    public static Object[][] usersInputData(){
	    	
	    	Object[][] data = new Object [][] {{"mishra.sauhard@gmail.com","Sauhard@1"},{"shubh.omer@gmail.com","shubH@1"}};
	    	
	    	return data;
	    }

	@Test(priority = 1,dataProvider = "usersTetsData")
	public void testing_logIn(String username, String password) throws Exception {
		
//		driver.findElement(BasePage.googleSearchBar).sendKeys("Amazon");
//		driver.findElement(BasePage.btn_googleSearch).submit();
//		test.log(LogStatus.INFO, "Searched amazon on google");
//		
//		driver.findElement(BasePage.link_amazon).click();
//		test.log(LogStatus.INFO, "Found amazon link and clicked");
		
		LoginPage.login(driver, test, username, password);
		
		Assert.assertEquals(driver.getTitle(),"Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
		test.log(LogStatus.INFO, "Logged into user account and redirected to amazon home page");
		

	}
}
