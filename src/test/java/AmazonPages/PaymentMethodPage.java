package AmazonPages;

import org.openqa.selenium.By;

public class PaymentMethodPage {

	public static By radioBtn_PayOnDelivery = By.xpath("//span[contains(text(),'Pay on Delivery')]");
	public static By btn_Continue = By.xpath("//input[@name='ppw-widgetEvent:SetPaymentPlanSelectContinueEvent']");
	public static By btn_placeYourOrder = By.xpath("//input[@title='Place your order']");
}
