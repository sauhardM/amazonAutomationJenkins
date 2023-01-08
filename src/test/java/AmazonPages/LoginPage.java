package AmazonPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.logging.log4j.*;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class LoginPage {
	
	public static By txt_username = By.id("ap_email");
	public static By btn_continue = By.id("continue");
	
	public static void login(WebDriver driver, ExtentTest test, String username, String password) {
		driver.findElement(BasePage.btn_signIn).click();
		test.log(LogStatus.INFO,"SignIn link found");

		
		WebElement continueBtn = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(btn_continue));
		driver.findElement(txt_username).sendKeys(username);
		test.log(LogStatus.INFO,"usename enterted");

		
		continueBtn.click();
		test.log(LogStatus.INFO,"continue button clicked");

		
		WebElement signInBtn = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(UserPasswordPage.btn_signIn));
		driver.findElement(UserPasswordPage.txt_password).sendKeys(password);
		test.log(LogStatus.INFO,"entered password");

		
		signInBtn.click();
		test.log(LogStatus.INFO,"SignIn button clicked");

		
		driver.findElement(UserAccountPage.logo_amazon).click();

	}
}
