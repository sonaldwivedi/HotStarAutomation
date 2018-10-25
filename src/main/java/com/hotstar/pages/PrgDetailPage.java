package com.hotstar.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hotstar.base.TestBase;

public class PrgDetailPage extends TestBase {

	@FindBy(xpath = "//div[@class='action-name']")
	public WebElement watchText;

	@FindBy(xpath = "//div[@class='toptitle clear-both']")
	public WebElement progTitle;
	
	@FindBy(xpath="//div[@class='description']")
	public WebElement descText;

	@FindBy(xpath = "//div[@class='action-holder']//a//div[@class='play-icon']")
	public WebElement playIcon;

	@FindBy(xpath = "//div[@class='share-icon']/../../../preceding-sibling::div[@class='add-to-watchlist']//div//div//div[@class='watchlist-icon']")
	public WebElement watchlistIcon;

	@FindBy(xpath = "//div[@class='share-icon']")
	public WebElement shareIcon;

	@FindBy(xpath = "//h2[@class='tray-title']")
	public List<WebElement> traytitle;

	@FindBy(xpath = "//p[text()='Connect with us']")
	public WebElement connectWithUs;
	
	@FindBy(xpath="//span[text()='Like']")
	public WebElement likeBtn;
	

	public PrgDetailPage() {
		PageFactory.initElements(driver, this);
	}

	public void verifyElements() {
		isElementVisible(watchText);
		isElementVisible(progTitle);
		isElementVisible(playIcon);
		isElementVisible(watchlistIcon);
		isElementVisible(shareIcon);
		isElementVisible(likeBtn);
	}
	
	public PlayerPage clickOnPlayIcon(){
		explicitwaitClick(playIcon);
		return new PlayerPage();
	}
}
