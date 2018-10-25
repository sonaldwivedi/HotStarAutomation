package com.hotstar.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hotstar.base.TestBase;

public class PlayerPage extends TestBase{
	
	//Player controls
	
	@FindBy(xpath="//div[@class='vjs-play-control-overlay']")
	public WebElement player;
	
	@FindBy(xpath="//div[@class='vjs-play-control-pause ']")
	public WebElement playPause;
	
	@FindBy(xpath="//div[@class='vjs-play-control-seek-backward ']")
	public WebElement seekBack;
	
	@FindBy(xpath="//div[@class='vjs-play-control-seek-forward ']")
	public WebElement seekForward;
	
	// MetaData
	@FindBy(xpath="//h1[@data-reactid='261']")
	public WebElement episodeTitle;
	
	@FindBy(xpath="//p[@class='show-title']")
	public WebElement showTitle;
	
	@FindBy(xpath="//a[@data-reactid='264']")
	public WebElement genre;
	
	@FindBy(xpath="//a[@data-reactid='267']")
	public WebElement language;
	
	@FindBy(xpath="//a[@data-reactid='270']")
	public WebElement channel;
	
	@FindBy(xpath="//div[@class='description']")
	public WebElement description;
	
	@FindBy(xpath="//div[@class='watchlist-icon']")
	public WebElement watchlistIcon;
	
	@FindBy(xpath="//div[@class='share-icon']")
	public WebElement shareIcon;
	
	@FindBy(xpath="//div[@class='like-wrap']")
	public WebElement likeBtn;
	
	@FindBy(xpath="//h2[text()='Comments']")
	public WebElement comments;
	
	public PlayerPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void verifyElements() {
		isElementVisible(player);
		isElementVisible(episodeTitle);
		isElementVisible(showTitle);
		isElementVisible(genre);
		isElementVisible(language);
		isElementVisible(channel);
		isElementVisible(description);
		isElementVisible(watchlistIcon);
		isElementVisible(shareIcon);
		isElementVisible(likeBtn);
		isElementVisible(comments);
	}

}
