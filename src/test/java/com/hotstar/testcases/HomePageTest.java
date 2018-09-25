package com.hotstar.testcases;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.ClickAction;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hotstar.base.TestBase;
import com.hotstar.pages.HomePage;
import com.hotstar.pages.MoviesPage;
import com.hotstar.pages.NewsPage;
import com.hotstar.pages.PremiumPage;
import com.hotstar.pages.PrgDetailPage;
import com.hotstar.pages.SportsPage;
import com.hotstar.pages.TVPage;

public class HomePageTest extends TestBase {

	HomePage homePage;
	TVPage tvPage;
	MoviesPage moviesPage;
	SportsPage sportsPage;
	NewsPage newsPage;
	PremiumPage premiumPage;
	PrgDetailPage pdpPage;

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialize();
		homePage = new HomePage();
		tvPage = new TVPage();
		moviesPage = new MoviesPage();
		sportsPage = new SportsPage();
		newsPage = new NewsPage();
		premiumPage = new PremiumPage();
		pdpPage=new PrgDetailPage();
	}

	@Test(priority = 1)
	public void verifyHomePageElements() {
		homePage.verifyElements();

	}

	@Test(priority = 2)
	public void verifyHamburgerOptions() {
		Actions builder = new Actions(driver);
		builder.moveToElement(homePage.hambugerIcon).build().perform();
		homePage.verifyHamburgerOptions();
	}

	@Test(priority = 3)
	public void verifyTitle() {
		String title = homePage.verifyHomePageTitle();
		Assert.assertEquals(title, "Hotstar - Watch TV Shows, Movies, Live Cricket Matches & News Online");
	}

	@Test(priority = 4)
	public void verifyTVTab() {
		tvPage = homePage.clickOnTV();
		System.out.println("TV Tab launched");
	}

	@Test(priority = 5)
	public void verifyMoviesTab() {
		moviesPage = homePage.clickOnMovies();
		System.out.println("Movies Tab launched");
	}

	@Test(priority = 6)
	public void verifySportsTab() {
		sportsPage = homePage.clickOnSports();
		System.out.println("Sports Tab launched");
	}

	@Test(priority = 7)
	public void verifyNewsTab() {
		newsPage = homePage.clickOnNews();
		System.out.println("News Tab launched");
	}

	@Test(priority = 8)
	public void verifyPremiumTab() {
		premiumPage = homePage.clickOnPremium();
		System.out.println("Premium Tab launched");
	}

	@Test(priority=9)
	public void verifyFooterLinks(){
		scrollFullPageDown();
		
		isElementPresent(homePage.footerFbLogo);
		isElementPresent(homePage.footerTwitterLogo);
		isElementPresent(homePage.footerTPlayStoreLogo);
		isElementPresent(homePage.footerTAppStoreLogo);
	}
	
	@Test(priority=10)
	public void verifyFirstThumbnailTopPicksForYou(){
		pdpPage=homePage.clickOnFirstThumbnail();
		System.out.println("Program Detail Page launched");
	}
	
	@Test(priority=11)
	public void verifySignIn(){
		homePage.clickOnSignIn();
		System.out.println("Sign In Page launched");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
