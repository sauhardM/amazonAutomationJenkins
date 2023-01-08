package AmazonTestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import AmazonAutomationAssignment.Utilities.ReadingFileProperties;
import AmazonPages.BasePage;
import AmazonPages.LoginPage;
import AmazonPages.PaymentMethodPage;
import AmazonPages.ProductPage;
import AmazonPages.UserPasswordPage;

public class BuyNowTestCases extends BasePage{

	@Test
	public void buyNow() throws Exception {
		
		LoginPage.login(driver, test, ReadingFileProperties.getProperty("username"), ReadingFileProperties.getProperty("password"));
		
		ProductPage.searchProduct(driver,test);
		
		driver.findElement(ProductPage.btn_buyNow).click();
		test.log(LogStatus.INFO, "Buy now button clicked");
		
		Assert.assertEquals(driver.getTitle(), "Select a Payment Method - Amazon.in Checkout");
		test.log(LogStatus.INFO, "Redirected to the payment method page");
		
	}
	
	@Test
	public void codPaymentMethod() throws Exception {
		
		buyNow();
		
		Actions actions = new Actions(driver);
		WebElement payOnDelivery = driver.findElement(PaymentMethodPage.radioBtn_PayOnDelivery);
		actions.moveToElement(payOnDelivery).click().build().perform();
		
//		driver.findElement(PaymentMethodPage.radioBtn_PayOnDelivery).click(); 
		test.log(LogStatus.INFO, "Pay on delivery method selected");
		
		driver.findElement(PaymentMethodPage.btn_Continue).click();
		test.log(LogStatus.INFO, "continue button clicked");
		
		WebElement signInBtn = (new WebDriverWait(driver, 20)).until(ExpectedConditions.presenceOfElementLocated(PaymentMethodPage.btn_placeYourOrder));
		
		Assert.assertEquals(driver.getTitle(), "Place Your Order - Amazon.in Checkout");
		test.log(LogStatus.INFO, "Redirected to place your order page");
		
	}
}
