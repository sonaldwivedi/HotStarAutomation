package com.hotstar.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.xerces.util.SynchronizedSymbolTable;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
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
	public static JavascriptExecutor js = ((JavascriptExecutor) driver);

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

	public static void initialize() {
		String browserName = prop.getProperty("browser");
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "/usr/local/share/chromedriver/chromedriver");
			System.out.println("Browser is set to chrome");

			driver = new ChromeDriver();
		}

		// Initializing EventFiringWebDriver using Firefox/Chrome WebDriver
		// instance
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with
		// EventFiringWebDriver
		eventListener = new EventHandler();

		// register event listener for EventFiringWebDriver instance.
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
		/*
		 * to check an element is visible and enabled such that we can click on
		 * the element. We need to pass wait time and the locator as parameters.
		 */

		System.out.println(
				"\n********************Explicitly Waiting for the element to be clickable********************");
		System.out.println("Waiting for the element: " + element + " to be clickable for 10 secs ");

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(element)).click();
		System.out.println("Element: " + element + "is clickable on page");
	}

	public static boolean isElementVisible(WebElement element) {
		/*
		 * to check if the element is present on the DOM of a page and visible.
		 * Visibility means that the element is not just displayed but also
		 * should also has a height and width that is greater than 0.
		 */

		System.out.println("\n********************Verifying isElementVisible********************");
		try {
			System.out.println("Waiting for the element: " + element + " to be visible for 10 secs ");
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOf(element));
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	//Action class for hover 
	public static void mouseOver(WebElement element){
		System.out.println("Trying to hover on element: " +element);
		Actions builder = new Actions(driver);
		builder.moveToElement(element).build().perform();
	}
	
	public static void countElements(List<WebElement> elements){
		System.out.println("Size is: " + elements.size());
	}
	
	public static void countPrintElements(List<WebElement> elements){
		System.out.println("Size is: " + elements.size());
		System.out.println("************Printing*************");
		for(WebElement e: elements){
			System.out.println("Title of "+e+ "is: "+e.getText());
		}
		
		
	}
	
	public void scrollFullPageDown() {
		js = (JavascriptExecutor) driver;
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");

	}

	public static void scrollslow(WebElement element) {
		try {
			//js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,400)", "");
			Thread.sleep(2000);
			System.out.println("Scrolled slowly by 400 ");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void scrollTo(WebElement element) {
		try {
			for (int second = 0;; second++) {
				if (second >= 10) {
					break;
				}
				js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,400)", "");
				Thread.sleep(3000);

			}
			js.executeScript("arguments[0].scrollIntoView(true);", element);
			js.executeScript("scrollBy(0, -250);");
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

}
