package AmazonTestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import AmazonPages.BasePage;

public class FilterSearch extends BasePage {

	@Test
	public void searchByCategory() {
		
		driver.findElement(BasePage.searchIn_dropdown).click();
		test.log(LogStatus.INFO, "Dropdown box clicked");
		
		driver.findElement(BasePage.dropdown_videoGames).click();
		test.log(LogStatus.INFO, "Video games selected from dropdown");
		
		driver.findElement(BasePage.btn_magnifyingGlass).click();
		test.log(LogStatus.INFO, "submit button got clicked");
		
		Assert.assertEquals(driver.getTitle(),BasePage.javascriptGetTitle(driver));
		test.log(LogStatus.INFO, "Redirected to video games page");
	}
}
