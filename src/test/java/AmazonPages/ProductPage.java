package AmazonPages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ProductPage{

	public static By btn_addToCart = By.cssSelector("#add-to-cart-button");
	public static By cartValue = By.xpath("//span[@id='nav-cart-count']");
	public static By btn_buyNow = By.xpath("//input[@id='buy-now-button']");
	public static By dropdown_quantity = By.xpath("//select[@id='quantity']");
	
	public static void searchProduct(WebDriver driver,ExtentTest test) {
		
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
	}
}
