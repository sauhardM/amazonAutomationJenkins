package AddToCartTestCases;

import java.util.ArrayList;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import AmazonAutomationAssignment.LoginTestCases.LoginTest;
import AmazonPages.BasePage;
import AmazonPages.LoginPage;
import AmazonPages.ProductPage;
import AmazonPages.UserAccountPage;


public class AddToCartTest extends BasePage {

	@Test
	public void testing_logIn() throws Exception {
		// TODO Auto-generated method stub
		LoginPage.login(driver, test, "mishra.sauhard@gmail.com", "Sauhard@1");
	    
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
		
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs.get(1));
		
		WebElement addToCartBtn = driver.findElement(ProductPage.btn_addToCart);
		jse.executeScript("arguments[0].scrollIntoView();", addToCartBtn);
		
		int count = 0;
		Actions actions = new Actions(driver);
		actions.moveToElement(addToCartBtn).click().build().perform();
		count++;
		test.log(LogStatus.INFO, "add to cart button clicked");
		
		String noOfProductsText = driver.findElement(ProductPage.cartValue).getText();
		int noOfProductsInCart = Integer.parseInt(noOfProductsText);
		test.log(LogStatus.INFO, "Number of products in cart: "+noOfProductsInCart);
		
		Assert.assertTrue(noOfProductsInCart>=count);
		test.log(LogStatus.PASS, "Product is added to the cart");
		
		
	}
	
}
