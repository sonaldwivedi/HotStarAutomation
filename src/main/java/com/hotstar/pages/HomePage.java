package com.hotstar.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.hotstar.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath = "//img[@class='brand-logo']")
	public WebElement hotstarLogo;

	@FindBy(xpath = "(//a[@href='/tv'])[2]")
	public WebElement homeTV;

	@FindBy(xpath = "(//a[@href='/movies'])[2]")
	public WebElement homeMovies;

	@FindBy(xpath = "(//a[@href='/sports'])[2]")
	public WebElement homeSports;

	@FindBy(xpath = "(//a[@href='/news'])[2]")
	public WebElement homeNews;

	@FindBy(xpath = "(//a[@href='/premium'])[2]")
	public WebElement homePremium;
	
	// Hamburger
	@FindBy(xpath = "//div[@class='icon-wrapper']")
	public WebElement hambugerIcon;

	@FindBy(xpath = "//span[@class='link-name' and text()='Home']")
	public WebElement hamburgerHome;

	@FindBy(xpath = "//span[@class='link-name' and text()='TV']")
	public WebElement hamburgerTV;

	@FindBy(xpath = "//span[@class='link-name' and text()='Movies']")
	public WebElement hamburgerMovies;
	
	@FindBy(xpath = "//span[@class='link-name' and text()='Sports']")
	public WebElement hamburgerSports;

	@FindBy(xpath = "//span[@class='link-name' and text()='News']")
	public WebElement hamburgerNews;

	@FindBy(xpath = "//span[@class='link-name' and text()='Premium']")
	public WebElement hamburgerPremium;
	
	@FindBy(xpath = "//span[@class='link-name' and text()='Channels']")
	public WebElement hamburgerChannels;

	@FindBy(xpath = "//span[@class='link-name' and text()='Languages']")
	public WebElement hamburgerLanguages;
	
	@FindBy(xpath="//div[@class='search' and text()='SEARCH']")
	public WebElement homeSearchText;
	
	@FindBy(xpath="//div[@class='searchIcon']")
	public WebElement homeSearchIcon;
	
	@FindBy(xpath="//div[@class='signIn displayElement' and text()='SIGN IN']")
	public WebElement homeSignIn;
	
	//Carousel
	
	@FindBy(xpath="(//ul[@class='slick-dots']//button)[1]")
	public WebElement pageIndicator1;
	
	@FindBy(xpath="(//div[@class='content-holder']//div[@class='toptitle isAd'])[1]")
	public WebElement carouselPrgmTitle;
	
	//Footer WebElements
	
	@FindBy(xpath="//a[@class='fb' and @href='https://www.facebook.com/hotstar']")
	public WebElement footerFbLogo;
	
	@FindBy(xpath="//a[@class='tw' and @href='https://twitter.com/hotstartweets']")
	public WebElement footerTwitterLogo;
	
	@FindBy(xpath="//a[@class='playstore' and @href='https://play.google.com/store/apps/details?id=in.startv.hotstar']")
	public WebElement footerTPlayStoreLogo;
	
	@FindBy(xpath="//a[@class='appstore' and @href='https://itunes.apple.com/in/app/hotstar/id934459219?mt=8']")
	public WebElement footerTAppStoreLogo;

	
	@FindBy(xpath="(//a[text()='Popular TV Shows']/../../../following-sibling::div//article)[1]")
	public WebElement firstThumbnailPopularTVShows;
	
			
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public void verifyElements() {

		isElementPresent(homeTV);
		isElementPresent(hotstarLogo);
		isElementPresent(homeMovies);
		isElementPresent(homeSports);
		isElementPresent(homeNews);
		isElementPresent(homePremium);
		isElementPresent(homeSearchIcon);
		isElementPresent(homeSignIn);
		isElementPresent(pageIndicator1);
		isElementPresent(carouselPrgmTitle);

	}

	public void verifyHamburgerOptions() {
		isElementPresent(hamburgerHome);
		isElementPresent(hamburgerMovies);
		isElementPresent(hamburgerTV);
		isElementPresent(hamburgerSports);
		isElementPresent(hamburgerNews);
		isElementPresent(hamburgerPremium);
		isElementPresent(hamburgerChannels);
		isElementPresent(hamburgerLanguages);
	}

	public String verifyHomePageTitle() {
		return driver.getTitle();
	}

	public TVPage clickOnTV() {
		explicitwaitClick(homeTV);
		return new TVPage();
	}

	public MoviesPage clickOnMovies() {
		explicitwaitClick(homeMovies);
		return new MoviesPage();
	}

	public SportsPage clickOnSports() {
		explicitwaitClick(homeSports);
		return new SportsPage();
	}
	
	public NewsPage clickOnNews(){
		explicitwaitClick(homeNews);
		return new NewsPage();
	}
	
	public PremiumPage clickOnPremium(){
		explicitwaitClick(homeNews);
		return new PremiumPage();
	}
	
	public PrgDetailPage clickOnFirstThumbnail(){
		explicitwaitClick(firstThumbnailPopularTVShows);
		return new PrgDetailPage();
	}
}
