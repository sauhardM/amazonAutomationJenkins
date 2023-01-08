package AmazonTestCases;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import AmazonPages.BasePage;

public class SideBarTestCases extends BasePage {

	@Test
	public void sidebar_DigitalContentAndDevices() {
		
		driver.findElement(BasePage.opt_all).click();
		test.log(LogStatus.INFO, "Side bar option clciked");
		
		driver.findElement(BasePage.li_echoAndAlexa).click();
		test.log(LogStatus.INFO, "Echo and Alexa option is clicked");
		
		driver.findElement(BasePage.echo_4thGen).click();
		test.log(LogStatus.INFO, "All-new Echo (4th Gen) selected");
		
		JavascriptExecutor jse  = (JavascriptExecutor) driver;
		String documentTile = jse.executeScript("return document.title;").toString();
		
		Assert.assertEquals(driver.getTitle(), documentTile);
		test.log(LogStatus.INFO, "redirected to the product page");
	}
	
	@Test()
	public void shopByCategory() {
		
		driver.findElement(BasePage.opt_all).click();
		test.log(LogStatus.INFO, "Side bar option clciked");
		
		driver.findElement(BasePage.li_mensFashion).click();
		test.log(LogStatus.INFO, "Men's fashion option selected under shop by category");
		
		driver.findElement(BasePage.li_sportsShoes).click();
		test.log(LogStatus.INFO, "Sports shoes option selected under mens fashion list");
		
		JavascriptExecutor jse  = (JavascriptExecutor) driver;
		String documentTile = jse.executeScript("return document.title;").toString();
		
		Assert.assertEquals(driver.getTitle(), documentTile);
		test.log(LogStatus.INFO, "redirected to mens sport shoes page");
		
	}
}
