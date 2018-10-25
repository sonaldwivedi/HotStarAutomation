package com.hotstar.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hotstar.base.TestBase;
import com.hotstar.pages.HomePage;
import com.hotstar.pages.SearchPage;
import com.hotstar.util.TestUtil;

public class SearchPageTest extends TestBase {

	HomePage homePage;
	SearchPage searchPage;

	@BeforeMethod
	public void setUp() {
		initialize();
		homePage = new HomePage();
		searchPage = new SearchPage();
	}

	@Test(priority = 1)
	public void verifySearchhelpText() {
		explicitwaitClick(homePage.homeSearchIcon);
		isElementVisible(homePage.searchHelpTxt);
	}

	@Test(priority = 2)
	public void searchAutoCmplt() {
		explicitwaitClick(homePage.homeSearchIcon);
		homePage.searchTxtBox.sendKeys("Kas");
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);
		isElementVisible(homePage.searchAutoCmplt);
	}

	@Test(priority = 3)
	public void searchCount() {
		explicitwaitClick(homePage.homeSearchIcon);
		homePage.searchTxtBox.sendKeys("Kas");
		isElementVisible(homePage.searchAutoCmplt);
		countElements(homePage.searchPrgmList);
	}

	@Test(priority = 4)
	public void searchResults() {
		explicitwaitClick(homePage.homeSearchIcon);
		homePage.searchTxtBox.sendKeys("Kas");
		homePage.searchTxtBox.sendKeys(Keys.ENTER);
		isElementVisible(searchPage.showingAll);
	}

	@Test(priority = 5)
	public void searchVerifyText() {
		explicitwaitClick(homePage.homeSearchIcon);
		String entered = "Kas";
		homePage.searchTxtBox.sendKeys(entered);
		homePage.searchTxtBox.sendKeys(Keys.ENTER);
		String resulttxt = searchPage.showingAllTxt.getText();
		System.out.println("Entered is: " + entered);
		System.out.println("Result is: " + resulttxt);
		Assert.assertEquals(entered, resulttxt);

	}

	@Test(priority = 6)
	public void verifySearchResultCount() {
		explicitwaitClick(homePage.homeSearchIcon);
		homePage.searchTxtBox.sendKeys("Kas");
		homePage.searchTxtBox.sendKeys(Keys.ENTER);
		countElements(searchPage.totalResults);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
