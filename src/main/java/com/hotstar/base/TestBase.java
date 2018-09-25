package com.hotstar.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.xerces.util.SynchronizedSymbolTable;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import com.hotstar.util.EventHandler;
import com.hotstar.util.TestUtil;


public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static EventHandler eventListener;
	


	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					"/home/sonal/Workspace_Hotstar/Hotstar/src/main/java/com/hotstar/config/config.properties");

			prop.load(ip);
			System.out.println("property file loaded");

		} catch (FileNotFoundException e) {	
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void initialize(){
		String browserName=prop.getProperty("browser");
		if (browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "/usr/local/share/chromedriver/chromedriver");
			System.out.println("Browser is set to chrome");

			driver = new ChromeDriver();
		}
		
		// Initializing EventFiringWebDriver using Firefox/Chrome WebDriver instance
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new EventHandler();
		
		//register event listener for EventFiringWebDriver instance.
		e_driver.register(eventListener);
		driver = e_driver;
		
		System.out.println("Maximising window");
		driver.manage().window().maximize();
		System.out.println("Deleting cookies");
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("hotstar_url"));
	}
	
	public static void explicitwaitClick(WebElement element) {
		System.out.println("\n********************Explicitly Waiting for the element to be clickable********************");
		System.out.println("Waiting for the element: " + element + " to be clickable for 10 secs ");

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(element)).click();
		System.out.println("Element: " + element + "is clickable on page");
	}
	
	public static boolean isElementPresent(WebElement element){
		System.out.println("\n********************Verifying isElementPresent********************");
		try{
			System.out.println("Waiting for the element: " + element + " to be visible for 10 secs ");
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOf(element));
			return true;
		}
		catch (NoSuchElementException e) {
			return false;
		}
	}
	
	public void scrollFullPageDown() {
		JavascriptExecutor js= (JavascriptExecutor)driver;
		System.out.println("js:" +js);
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		
	}
	
}
