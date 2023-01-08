package SearchingProductsTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.KeyUpAction;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import AmazonAutomationAssignment.LoginTestCases.LoginTest;
import AmazonPages.BasePage;
import AmazonPages.LoginPage;
import AmazonPages.UserAccountPage;

public class SearchingProduct extends BasePage{

	
	@Test(priority = 1)
	public void productSearch() throws Exception {
		
		driver.findElement(UserAccountPage.search_Box).click();
		test.log(LogStatus.INFO, "Search box found and clicked");
		
		driver.findElement(UserAccountPage.search_Box).sendKeys("oneplus bullets Z2");
		test.log(LogStatus.INFO, "Product name entered");
		
		driver.findElement(UserAccountPage.search_Box).submit();
		test.log(LogStatus.INFO, "Product searched");
		
		JavascriptExecutor jse  = (JavascriptExecutor) driver;
		test.log(LogStatus.INFO, "Javascript executor assigned");
		
		WebElement Element = driver.findElement(By.xpath("//a[@class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal']//span[contains(text(),'OnePlus Buds Z2 Truly Wireless Earbuds with Active Noise Cancellation, 10 Minutes Flash Charge & Upto 38 Hours Battery (Pearl White)')]"));
		jse.executeScript("arguments[0].scrollIntoView();", Element);
		test.log(LogStatus.INFO, "Scrolled down to the product");
		
		Element.click();
		test.log(LogStatus.INFO, "Product clikced and open in new page");
	
		Thread.sleep(6000);
		test.log(LogStatus.INFO, "thread.sleep applied");
		
		Assert.assertEquals(driver.getTitle(), "Amazon.in : oneplus bullets Z2");
		test.log(LogStatus.PASS, "Assertion applied and passed");
		
	}
	
	@Test(priority = 2)
	public void FailedSearch() throws Exception {
		
		driver.findElement(UserAccountPage.search_Box).click();
		test.log(LogStatus.INFO, "Search box found and clicked");
		
		driver.findElement(UserAccountPage.search_Box).sendKeys("oneplus bullets Z2");
		test.log(LogStatus.INFO, "Product name entered");
		
		driver.findElement(UserAccountPage.search_Box).submit();
		test.log(LogStatus.INFO, "Product searched");
		
		JavascriptExecutor jse  = (JavascriptExecutor) driver;
		test.log(LogStatus.INFO, "Javascript executor assigned");
		
		WebElement Element = driver.findElement(By.id("fakePath"));
		jse.executeScript("arguments[0].scrollIntoView();", Element);
		test.log(LogStatus.INFO, "Scrolled down to the product");
		
		Element.click();
		test.log(LogStatus.INFO, "Product clikced and open in new page");
	
		Thread.sleep(6000);
		test.log(LogStatus.INFO, "thread.sleep applied");
		
		Assert.assertEquals(driver.getTitle(), "Amazon.in : oneplus bullets Z2");
		test.log(LogStatus.PASS, "Assertion applied and passed");
		
	}
	
}
