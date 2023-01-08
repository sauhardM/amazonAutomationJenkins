package AmazonTestCases;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import AmazonPages.BasePage;
import AmazonPages.ProductPage;

public class ProductQuantityTestCases extends BasePage {

	@Test
	public void FailedTestCaseQuantityOfProductsSelected() {
		
		ProductPage.searchProduct(driver,test);
		
		Select Quantity = new Select(driver.findElement(ProductPage.dropdown_quantity));
        Quantity.selectByValue("3");
	}
}
