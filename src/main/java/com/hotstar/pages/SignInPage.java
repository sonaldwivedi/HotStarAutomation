package com.hotstar.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.hotstar.base.TestBase;

public class SignInPage extends TestBase{
	@FindBy(xpath="//h1[text()='Sign In']")
	public WebElement signInTitle;
	
	
}
