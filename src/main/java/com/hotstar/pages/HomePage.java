package com.hotstar.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.hotstar.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath="//img[@class='brand-logo']")
	public WebElement hotstarLogo;
	
	@FindBy(xpath="(//a[@href='/tv'])[2]")
	public WebElement homeTV;
	
	@FindBy(xpath="(//a[@href='/movies'])[2]")
	public WebElement homeMovies;
	
	@FindBy(xpath="(//a[@href='/sports'])[2]")
	public WebElement homeSports;		
	
	
	//Hamburger
	@FindBy(xpath="//div[@class='icon-wrapper']")
	public WebElement hambugerIcon;
	
	@FindBy(xpath="//span[@class='link-name' and text()='Home']")
	public WebElement hamburgerHome;
	
	@FindBy(xpath="//span[@class='link-name' and text()='TV']")
	public WebElement hamburgerTV;
	
	@FindBy(xpath="//span[@class='link-name' and text()='Movies']")
	public WebElement hamburgerMovies;
	
	
	
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	
	public void verifyElements(){
		
		isElementPresent(homeTV);
		isElementPresent(hotstarLogo);
		isElementPresent(homeMovies);
		isElementPresent(homeSports);
		/*boolean flag= homeTV.isDisplayed();
		if(flag==true){
			System.out.println("TV tab found");
		}
		else{
			System.out.println("TV tab not found");
		}
		*/
		//Assert.assertTrue(homeTV.isDisplayed(), "TV tab not found");
	}
	public void verifyHamburgerOptions(){
		isElementPresent(hamburgerHome);
		isElementPresent(hamburgerMovies);
		isElementPresent(hamburgerTV);
	}
}
