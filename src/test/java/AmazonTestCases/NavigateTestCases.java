package AmazonTestCases;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import AmazonPages.BasePage;
import AmazonPages.NavigatePage;

public class NavigateTestCases extends BasePage {

	@Test
	public void navigateTest() {
		
		driver.findElement(NavigatePage.SearchText).sendKeys("oneplus bullets z2");
		test.log(LogStatus.INFO, "product searched");
		
		driver.findElement(NavigatePage.SearchBtn).click();
		test.log(LogStatus.INFO, "serch button clicked");
		
		driver.navigate().to("https://www.amazon.in/OnePlus-Wireless-Earbuds-Active-Cancellation/dp/B07XWB82D9/ref=sr_1_7?keywords=oneplus+bullets+z2&qid=1664732493&qu=eyJxc2MiOiIyLjQ1IiwicXNhIjoiMS4zNSIsInFzcCI6IjEuMDUifQ%3D%3D&sprefix=%2Caps%2C210&sr=8-7");
        driver.navigate().refresh();
        driver.navigate().back();
        driver.navigate().forward();
	}
}
