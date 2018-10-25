package com.hotstar.testcases;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hotstar.base.TestBase;
import com.hotstar.pages.HomePage;
import com.hotstar.pages.PlayerPage;
import com.hotstar.pages.PrgDetailPage;

public class PrgDetailPageTest extends TestBase {

	HomePage homePage;
	PrgDetailPage pdPage;
	PlayerPage playerPage;

	@BeforeMethod
	public void setUp() {
		initialize();
		homePage = new HomePage();
		pdPage = new PrgDetailPage();
		playerPage = new PlayerPage();
	}

	@Test(priority = 1)
	public void verifyPrgDetailPageTestElements() {
		explicitwaitClick(homePage.firstThumbnail);
		isElementVisible(pdPage.progTitle);
		pdPage.verifyElements();
	}

	@Test(priority = 2)
	public void verifyPDPCategories() {
		explicitwaitClick(homePage.firstThumbnail);
		isElementVisible(pdPage.progTitle);
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		scrollTo(pdPage.connectWithUs);
		countPrintElements(pdPage.traytitle);

	}

	@Test(priority = 3)
	public void play() {
		explicitwaitClick(homePage.firstThumbnail);
		isElementVisible(pdPage.progTitle);
		pdPage.clickOnPlayIcon();
		isElementVisible(playerPage.player);
		mouseOver(playerPage.player);
		isElementVisible(playerPage.playPause);
		isElementVisible(playerPage.seekBack);
		isElementVisible(playerPage.seekForward);
	}

	@AfterMethod()
	public void tearDown() {
		driver.quit();
	}

}
