package com.hotstar.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hotstar.base.TestBase;

public class SignInPage extends TestBase{
	@FindBy(xpath="//h1[text()='Sign In']")
	public WebElement signInTitle;
	
	@FindBy(xpath="//div[@class='login-modal showLogin']//div[@class='close-btn']")
	public WebElement closeBtn;
	
	@FindBy(xpath="//span[text()='Sign In with Facebook']")
	public WebElement signInFBBtn;
	
	@FindBy(xpath="//input[@id='email']")
	public WebElement emailTxtField;
	
	@FindBy(xpath="//input[@id='password']")
	public WebElement passTxtField;
	
	@FindBy(xpath="//button[@type='submit']")
	public WebElement signinBtn;
	
	@FindBy(xpath="//span[text()='Forgot Password']")
	public WebElement forgotPassLink;
	
	@FindBy(xpath="//div[text()='Sign Up']")
	public WebElement signUpLink;
	
	@FindBy(xpath="//p[text()='Please enter a valid email address']")
	public WebElement emailErr;
	
	@FindBy(xpath="//p[text()='Please enter a password']")
	public WebElement passErr;
	
	@FindBy(xpath="//div[text()='This email address is not registered with us. Please try again or create a new account.']")
	public WebElement emailRegError;
	
	public SignInPage(){
		PageFactory.initElements(driver, this);
	}
	
	public void verifyElements(){
		isElementVisible(signInTitle);
		isElementVisible(closeBtn);
		isElementVisible(signInFBBtn);
		isElementVisible(emailTxtField);
		isElementVisible(passTxtField);
		isElementVisible(signinBtn);
		isElementVisible(forgotPassLink);
		isElementVisible(signUpLink);
	}
	
	public void validSignIn(){
		emailTxtField.sendKeys(prop.getProperty("email"));
		passTxtField.sendKeys(prop.getProperty("password"));
		signinBtn.click();
	}
	
	public void invalidSignIn(){
		emailTxtField.sendKeys("jdshdh@gmail.com");
		passTxtField.sendKeys("ddhfjdf");
		signinBtn.click();
		
	}

}
