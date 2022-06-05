package com.Racpad.Testcases;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.TimeoutException;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


import com.Racpad.PageObjects.CustomercreationPage;
import com.Racpad.PageObjects.Homepage;



public class TC_openRacpad extends Base {
	static Logger log=Logger.getLogger(TC_openRacpad.class);
	
	@Test
	public void openRacpad() throws InterruptedException, IOException, InvocationTargetException, TimeoutException {
		
		dataDriven();
		Homepage hp = new Homepage(driver, act);
		hp.movecustomer();
		CustomercreationPage ccp = new CustomercreationPage(driver, arr);
		ccp.enterFirstname();
		log.info("first name entered");
		act.sendKeys(Keys.TAB).build().perform();
		ccp.enterLastname();
		log.info("last name entered");
		act.sendKeys(Keys.TAB).build().perform();
		ccp.enterDob();
		log.info("date of birth entered");
		act.sendKeys(Keys.TAB).build().perform();
		ccp.enterSS1name();
		ccp.enterSS2name();
		ccp.enterSS3name();
		act.sendKeys(Keys.TAB).build().perform();
		ccp.enterPhone();
		log.info("phone number entered");
		act.sendKeys(Keys.TAB).build().perform();
		ccp.enterEmailname();
		log.info("email entered");
		act.sendKeys(Keys.TAB).build().perform();
		ccp.enterAddress();
		log.info("address entered");
		act.sendKeys(Keys.TAB).build().perform();
		act.sendKeys(Keys.TAB).build().perform();
		ccp.enterZip();
		log.info("zip code entered");
		act.sendKeys(Keys.TAB).build().perform();
		ccp.enterCityname();
		log.info("city name entered");
		for (int i = 0; i < 2; i++) {
			act.sendKeys(Keys.TAB).build().perform();
		}
		act.sendKeys(Keys.ENTER).build().perform();
		
		ccp.enterState();
		log.info("state name selected");
		for (int i = 0; i < 4; i++) {
			act.sendKeys(Keys.TAB).build().perform();
		}
		act.sendKeys(Keys.ENTER).build().perform();
		//ccp.validatenewcustomer();
		ccp.validatecontinuepopUp();
		ccp.decision();
		Thread.sleep(3000);
		ccp.enterId();
		ccp.cgr();
		ccp.ccgr();
		hp.moveagreement();
		ccp.enterFirstname();
		act.sendKeys(Keys.TAB).build().perform();
		ccp.enterLastname();
		act.sendKeys(Keys.TAB).build().perform();
		ccp.enterDob();
		act.sendKeys(Keys.TAB).build().perform();
		ccp.enterSS1name();
		act.sendKeys(Keys.TAB).build().perform();
		ccp.enterSS2name();
		act.sendKeys(Keys.TAB).build().perform();
		ccp.enterSS3name();
		act.sendKeys(Keys.TAB).build().perform();
		ccp.enterPhone();
		act.sendKeys(Keys.TAB).build().perform();
		act.sendKeys(Keys.ENTER).build().perform();
	    hp.logout();
	}

}
