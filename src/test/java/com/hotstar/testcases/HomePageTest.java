package com.hotstar.testcases;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hotstar.base.TestBase;
import com.hotstar.pages.HomePage;

public class HomePageTest extends TestBase{
		
	HomePage homePage;
	@BeforeMethod
	public void setUp(){
		initialize();
		homePage=new HomePage();
	}
	
/*	@Test(priority=1)
	public void verifyHomePageElements(){
		homePage.verifyElements();
		
	}*/
	
	@Test(priority=2)
	public void verifyHamburgerOptions(){
		//driver.navigate().refresh();
		homePage.hambugerIcon.click();
		
	/*	for(int i=0; i<=2;i++){
			  try{
				  homePage.hambugerIcon.click();
			     break;
			  }
			  catch(Exception e){
			     System.out.println(e.getMessage());
			  }
			}*/
		
		//homePage.verifyHamburgerOptions();
	}
	
	@AfterMethod
	public void tearDown(){
		//driver.quit();
	}
}
