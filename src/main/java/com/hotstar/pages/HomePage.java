package com.hotstar.pages;



import java.util.List;

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

	@FindBy(xpath = "(//a[@href='/moviess'])[2]")
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
	
	//Movies 
	@FindBy(xpath="//a[text()='Hindi']")
	public WebElement hindi;
	
	@FindBy(xpath="//a[text()='Bengali']")
	public WebElement bengali;
	
	@FindBy(xpath="//a[text()='Telugu']")
	public WebElement telugu;
	
	@FindBy(xpath="//a[text()='Malayalam']")
	public WebElement malayalam;
	
	@FindBy(xpath="//a[text()='Tamil']")
	public WebElement tamil;
	
	@FindBy(xpath="//a[text()='Marathi']")
	public WebElement marathi;
	
	@FindBy(xpath="//a[text()='English']")
	public WebElement english;
	
	@FindBy(xpath="//a[text()='Kannada']")
	public WebElement kannada;
	
	@FindBy(xpath="//a[text()='Gujarati']")
	public WebElement gujarati;
	
	//Search
	
	@FindBy(xpath="//div[@class='search' and text()='SEARCH']")
	public WebElement homeSearchText;
	
	@FindBy(xpath="//div[@class='searchIcon']")
	public WebElement homeSearchIcon;
	
	@FindBy(xpath="//input[@type='search']")
	public WebElement searchTxtBox;
	
	@FindBy(xpath="//div[@class='result-holder element-show']")
	public WebElement searchAutoCmplt;
	
	@FindBy(xpath="//input[@type='search' and @placeholder='Search for shows, movies, sports and TV channels']")
	public WebElement searchHelpTxt;
	
	@FindBy(xpath="//div[@class='search-wrap']//div//div//span[not (@class)]")
	public List<WebElement> searchPrgmList;
	
	
	@FindBy(xpath="(//div[@class='search-wrap']/div/div/span[not (@class)])[1]")
	public WebElement searchFirstPrgmTitle;
	
	@FindBy(xpath="(//div[@class='search-wrap']//span[@class='subtitle'])[1]")
	public WebElement searchFirstSubtitle;
	
	@FindBy(xpath="//div[@class='signIn displayElement' and text()='SIGN IN']")
	public WebElement homeSignIn;
	
	@FindBy(xpath="//div[@class='user-pic displayElement']")
	public WebElement homeUserIcon;
	
	//Carousel
	
	@FindBy(xpath="(//ul[@class='slick-dots']//button)[1]")
	public WebElement pageIndicator1;
	
	@FindBy(xpath="(//div[@class='toptitle']//following-sibling::div[@class='title ellipsize'])[1]")
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
	
	@FindBy(xpath="(//div[@class='card  card-img-container'])[1]")
	public WebElement firstThumbnail;
	
	
			
	public HomePage() {
		
		PageFactory.initElements(driver, this);
	}

	public void verifyElements() {
		isElementVisible(homeTV);
		isElementVisible(hotstarLogo);
		isElementVisible(homeMovies);
		isElementVisible(homeSports);
		isElementVisible(homeNews);
		isElementVisible(homePremium);
		isElementVisible(homeSearchIcon);
		isElementVisible(homeSignIn);
		isElementVisible(pageIndicator1);
		isElementVisible(carouselPrgmTitle);

	}

	public void verifyHamburgerOptions() {
		isElementVisible(hamburgerHome);
		isElementVisible(hamburgerMovies);
		isElementVisible(hamburgerTV);
		isElementVisible(hamburgerSports);
		isElementVisible(hamburgerNews);
		isElementVisible(hamburgerPremium);
		isElementVisible(hamburgerChannels);
		isElementVisible(hamburgerLanguages);
	}
	
	public void verifyMoviesOptions() {
		isElementVisible(hindi);
		isElementVisible(bengali);
		isElementVisible(telugu);
		isElementVisible(malayalam);
		isElementVisible(tamil);
		isElementVisible(marathi);
		isElementVisible(english);
		isElementVisible(kannada);
		isElementVisible(gujarati);
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
	public SignInPage clickOnSignIn(){
		explicitwaitClick(homeSignIn);
		return new SignInPage();
	}
	
	public SearchPage SearchText(){
		explicitwaitClick(homeSearchIcon);
		return new SearchPage();
	}
}
