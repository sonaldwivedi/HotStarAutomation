package com.hotstar.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hotstar.base.TestBase;
import com.hotstar.pages.HomePage;
import com.hotstar.pages.PlayerPage;
import com.hotstar.pages.PrgDetailPage;

public class PlayerPageTest extends TestBase {

	HomePage homePage;
	PrgDetailPage pdPage;
	PlayerPage playerPage;

	@BeforeMethod
	public void setUp() {
		initialize();
		homePage = new HomePage();
		pdPage = new PrgDetailPage();
		playerPage = new PlayerPage();
		explicitwaitClick(homePage.firstThumbnail);
		explicitwaitClick(pdPage.playIcon);
	}

	@Test
	public void verifyPlayerPageTestElements() {
		playerPage.verifyElements();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
