package AmazonPages;

import org.openqa.selenium.By;

public class UserAccountPage {
	
	public static By logo_amazon = By.id("nav-logo-sprites");
	public static By hoverNav_userAccount = By.xpath("//a[@id='nav-link-accountList']");
	public static By btn_signOut = By.xpath("//a[@id='nav-item-signout']//span");
	public static By search_Box = By.xpath("//input[@id='twotabsearchtextbox']");
	
}
