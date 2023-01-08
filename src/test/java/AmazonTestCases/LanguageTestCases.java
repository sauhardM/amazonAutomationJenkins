package AmazonTestCases;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import AmazonPages.BasePage;

public class LanguageTestCases extends BasePage {

	@Test
	public void TestLanguageChange() {
		
		Actions actions = new Actions(driver);
		WebElement language = driver.findElement(BasePage.dropdown_language);
		actions.moveToElement(language).build().perform();
		test.log(LogStatus.INFO, "curser moved to lnguage element");
		
		WebElement HindiLanguage = driver.findElement(BasePage.language_hindi);
		actions.moveToElement(HindiLanguage).click().build().perform();
		test.log(LogStatus.INFO, "Hindi language selected");
		
		Assert.assertEquals(driver.getTitle(),BasePage.javascriptGetTitle(driver));
		test.log(LogStatus.INFO, "Redirected to the Hindi page of amazon");
	}
}
