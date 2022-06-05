package com.Racpad.PageObjects;

import java.lang.reflect.InvocationTargetException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Homepage
{
	
public WebDriver ldriver;
public Actions act;

public Homepage(WebDriver rdriver,Actions action)
{
	act=action;
	ldriver=rdriver;
	PageFactory.initElements(rdriver,this);
}

@FindBy(tagName="img")
WebElement logout1;

@FindBy(xpath="//button[contains(text(),'Logout')]")
WebElement logout2;

@FindBy(xpath="//ul//li[3]/a")
WebElement customer;

@FindBy(xpath="//a[contains(text(),'Create Customer')]")
WebElement createcustomer;
@FindBy(xpath="//a[contains(text(),'Create Agreement')]")
WebElement agreement;

public void movecustomer() throws InvocationTargetException
{
	act.moveToElement(customer).build().perform();
	act.moveToElement(createcustomer).click().build().perform();
}
public void moveagreement()
{
	act.moveToElement(customer).build().perform();
	act.moveToElement(agreement).click().build().perform();	
}

public void logout() throws InterruptedException
{
	
	act.moveToElement(logout1).click().build().perform();
	WebDriverWait wt=new WebDriverWait(ldriver,5);
	 wt.until(ExpectedConditions.elementToBeClickable(logout2));
	act.moveToElement(logout2).click().build().perform();
}

}
