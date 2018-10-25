package com.hotstar.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hotstar.base.TestBase;
import com.hotstar.pages.HomePage;
import com.hotstar.pages.SignInPage;

public class SignInPageTest extends TestBase {

	HomePage homePage;
	SignInPage signInPage;

	@BeforeMethod
	public void setUp() {
		initialize();
		homePage = new HomePage();
		signInPage = new SignInPage();
	}

	@Test(priority = 1)
	public void signInValid() {
		explicitwaitClick(homePage.homeSignIn);
		isElementVisible(signInPage.signInTitle);
		signInPage.validSignIn();
		isElementVisible(homePage.homeUserIcon);
	}

	@Test(priority = 2)
	public void signInInvalid() {
		explicitwaitClick(homePage.homeSignIn);
		isElementVisible(signInPage.signInTitle);
		signInPage.invalidSignIn();
		isElementVisible(signInPage.emailRegError);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
