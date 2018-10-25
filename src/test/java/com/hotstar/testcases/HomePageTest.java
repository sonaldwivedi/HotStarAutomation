package com.hotstar.testcases;

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

	@BeforeMethod
	public void setUp() {
		initialize();
		homePage = new HomePage();
		tvPage = new TVPage();
		moviesPage = new MoviesPage();
		sportsPage = new SportsPage();
		newsPage = new NewsPage();
		premiumPage = new PremiumPage();
		pdpPage = new PrgDetailPage();
	}

	@Test(priority = 1)
	public void verifyHomePageElements() {
		homePage.verifyElements();

	}

	@Test(priority = 2)
	public void verifyHamburgerLinks() {
		mouseOver(homePage.hambugerIcon);
		System.out.println("Hovered over element");
		homePage.verifyHamburgerOptions();
	}

	@Test(priority = 3)
	public void verifyMoviesLinks() {
		mouseOver(homePage.homeMovies);
		homePage.verifyMoviesOptions();
	}

	@Test(priority = 4)
	public void verifyTitle() {
		String title = homePage.verifyHomePageTitle();
		Assert.assertEquals(title, "Hotstar - Watch TV Shows, Movies, Live Cricket Matches & News Online");
	}

	@Test(priority = 5)
	public void verifyTVTab() {
		tvPage = homePage.clickOnTV();
		System.out.println("TV Tab launched");
	}

	@Test(priority = 6)
	public void verifyMoviesTab() {
		moviesPage = homePage.clickOnMovies();
		System.out.println("Movies Tab launched");
	}

	@Test(priority = 7)
	public void verifySportsTab() {
		sportsPage = homePage.clickOnSports();
		System.out.println("Sports Tab launched");
	}

	@Test(priority = 8)
	public void verifyNewsTab() {
		newsPage = homePage.clickOnNews();
		System.out.println("News Tab launched");
	}

	@Test(priority = 9)
	public void verifyPremiumTab() {
		premiumPage = homePage.clickOnPremium();
		System.out.println("Premium Tab launched");
	}

	@Test(priority = 10)
	public void verifyFooterLinks() {
		scrollFullPageDown();

		isElementVisible(homePage.footerFbLogo);
		isElementVisible(homePage.footerTwitterLogo);
		isElementVisible(homePage.footerTPlayStoreLogo);
		isElementVisible(homePage.footerTAppStoreLogo);
	}

	@Test(priority = 11)
	public void verifyFirstThumbnailTopPicksForYou() {
		pdpPage = homePage.clickOnFirstThumbnail();
		isElementVisible(pdpPage.watchText);
		System.out.println("Program Detail Page launched");
	}

	@Test(priority = 12)
	public void verifySignIn() {
		homePage.clickOnSignIn();
		System.out.println("Sign In Page launched");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
