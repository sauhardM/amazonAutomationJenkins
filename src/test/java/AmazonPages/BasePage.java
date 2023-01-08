package AmazonPages;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import AmazonAutomationAssignment.Utilities.ExtentManager;
import AmazonAutomationAssignment.Utilities.ReadingFileProperties;
import AmazonAutomationAssignment.Utilities.ScreenShots;
import io.github.bonigarcia.wdm.WebDriverManager;

import com.microsoft.edge.seleniumtools.EdgeDriver;
import org.apache.logging.log4j.*;


public class BasePage {

	public WebDriver driver;
	public static ExtentReports extent;
	public static ExtentTest test;
	private static Logger logger= LogManager.getLogger(BasePage.class.getName());
	
	public static By googleSearchBar = By.xpath("//input[@class='gLFyf gsfi']");
	public static By btn_googleSearch = By.name("btnK");
	public static By link_amazon = By.partialLinkText("Amazon.in");
	public static By btn_signIn = By.xpath("//a[@id='nav-link-accountList']");
	public static By opt_all  = By.xpath("//a[@id='nav-hamburger-menu']//span[contains(text(),'All')]");
	public static By li_echoAndAlexa = By.xpath("//div[contains(text(),'Echo & Alexa')]");
	public static By echo_4thGen = By.xpath("//a[contains(text(),'All-new Echo (4th Gen)')]");
	public static By li_mensFashion = By.xpath("//div[contains(text(),\"Men's Fashion\")]");
	public static By li_sportsShoes = By.xpath("//a[contains(text(),'Sports Shoes')]");
	public static By searchIn_dropdown = By.xpath("//select[@id='searchDropdownBox']");
	public static By dropdown_videoGames = By.xpath("//select[@id='searchDropdownBox']//option[contains(text(),'Video Games')]");
	public static By btn_magnifyingGlass = By.xpath("//input[@id='nav-search-submit-button']");
	public static By dropdown_language = By.xpath("//a[@id='icp-nav-flyout']");
	public static By language_hindi = By.xpath("//a[@href='#switch-lang=hi_IN']");
	
	
	
	public static String javascriptGetTitle(WebDriver driver) {
		JavascriptExecutor jse  = (JavascriptExecutor) driver;
		String documentTitle = jse.executeScript("return document.title;").toString();
		return documentTitle;
	}
	
	
	@BeforeMethod
	@Parameters({"chromedriver","driverpath","browser"})
	public void startTest(Method method,String chromedriver, String driverpath,String browser) {
		
		//for running test cases in headless mode
//		if (browser.equalsIgnoreCase("chrome")) {
////			System.setProperty(chromedriver,ReadingFileProperties.getProperty("driverPath"));
//			WebDriverManager.chromedriver().setup();
//			ChromeOptions options  = new ChromeOptions();
//			options.setHeadless(true);
//			options.addArguments("window-size=1920,1080");
//			driver = new ChromeDriver(options);
//		}else if(browser.equalsIgnoreCase("firefox")) {
////			System.setProperty(ReadingFileProperties.getProperty("ffdriver"),ReadingFileProperties.getProperty("ffdriverpath"));
//			WebDriverManager.firefoxdriver().setup();
//			FirefoxOptions options = new FirefoxOptions();
//			options.setHeadless(true);
//			options.addArguments("window-size=1920,1080");
//			driver = new FirefoxDriver(options);
//		}
		
		
		//to run test cases with browser GUI
		
		 if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty(chromedriver,ReadingFileProperties.getProperty("driverPath"));
			driver = new ChromeDriver();
		}else if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty(ReadingFileProperties.getProperty("ffdriver"),ReadingFileProperties.getProperty("ffdriverpath"));
			driver = new FirefoxDriver();
		}else if(browser.equalsIgnoreCase("edge")) {
			System.setProperty(ReadingFileProperties.getProperty("edgedriver"),ReadingFileProperties.getProperty("edgedriverpath"));
			driver = new EdgeDriver();
		}
		 
		extent = ExtentManager.getInstance("Reports//Extent_demo.html");
		test = extent.startTest(method.getName());
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(ReadingFileProperties.getProperty("AmazonUrl"));
		logger.info("Redirected to amazon url");

	}
	
	@AfterMethod
	public void testStatus(ITestResult result) {
		Logger logger= LogManager.getLogger(result.getName());
		if(result.getStatus() == ITestResult.SUCCESS) {
			test.log(LogStatus.PASS, "Test case got passed");
			
		} else if (result.getStatus() == ITestResult.FAILURE) {
			ScreenShots.takeScreenShot(driver,result.getName());
			test.log(LogStatus.ERROR, test.addScreenCapture(System.getProperty("user.dir") + "//Screenshots//" + result.getName() +" .jpg"));
			test.log(LogStatus.ERROR, result.getThrowable());
			test.log(LogStatus.FAIL, "Test case got failed");
			
		}
		extent.flush();
		driver.quit();
		logger.info("Driver quits");
	}
}
