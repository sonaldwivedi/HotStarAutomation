package com.hotstar.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hotstar.base.TestBase;

public class SearchPage extends TestBase{
	
	@FindBy(xpath="//h2[text()='Showing all results for ']")
	public WebElement showingAll;
	
	@FindBy(xpath="//h2[text()='Showing all results for ']//span")
	public WebElement showingAllTxt;
	
	@FindBy(xpath="//div[@class='resClass']//div[@class='thumbnail-container']")
	public List<WebElement> totalResults;
	
	public SearchPage() {
		PageFactory.initElements(driver, this);
	}
	
}
