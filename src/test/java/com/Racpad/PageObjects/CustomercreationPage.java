package com.Racpad.PageObjects;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.Racpad.Utilities.dropDown;
import com.fasterxml.jackson.databind.deser.Deserializers.Base;

public class CustomercreationPage extends Base {
	public static WebDriver cdriver;
	public  ArrayList<WebElement> dp;
	public ArrayList<String> arr;
	 
	public CustomercreationPage(WebDriver rdriver,ArrayList<String> arr)
	{
		this.arr=arr;
		cdriver=rdriver;
		PageFactory.initElements(rdriver,this);
	}
	
	
	@FindBy(xpath="//input[@name='FirstName' and @maxlength='30']")
	WebElement firstname; 
	@FindBy(xpath="//input[@name='LastName' and @maxlength='30']")
	WebElement lastname;
	@FindBy(xpath="//input[@name='a11y_dob']")
	WebElement dob;
	@FindBy(id="a11y_ssnone")
	WebElement socialsecurity1; 
	@FindBy(id="a11y_ssntwo")
	WebElement socialsecurity2;
	@FindBy(id="a11y_ssnthree")
	WebElement socialsecurity3;
	@FindBy(id="a11y_phonenumber")
	WebElement phonenumber;
	@FindBy(id="a11y_emailaddress")
	WebElement email;
	@FindBy(id="a11y_address-1")
	WebElement address1;
	@FindBy(id="a11y_address-2")
	WebElement address2;
	@FindBy(id="a11y_zip")
	WebElement zip;
	@FindBy(id="a11y_city")
	WebElement city;
	@FindBy(xpath="//div[@id='step-1']/parent::div/div//button//following::button")
	WebElement validate;
	@FindBy(xpath="//span[contains(text(),'Yes')]")
	WebElement pop;
	@FindBy(xpath="//*[contains(text(),'continue')]")
	WebElement validatecontinuepop;
	@FindBy(xpath="//input[@id='inlineRadio1']")
	WebElement validateradiopop;
	@FindBy(xpath="//*[contains(text(),'Override')]")
	WebElement validateoverridepop; 
	@FindBy(xpath="//input[@name='checkbox_0']")
	WebElement checkbox;
	@FindBy(xpath="//span[contains(text(),'New customer')]")
	WebElement newcustomer;
	@FindBy(xpath="//div[@role='dialog']/div[2]/div/div[2]//button")
	WebElement validateaddress;
	@FindBy(xpath="//div[@role='dialog']/div[2]/div/div[2]/button")
	WebElement decision;
	@FindBy(xpath="//div[contains(text(),'Select')]")
    WebElement state;
	@FindBy(xpath="//div[contains(text(),'Select')]")
     WebElement idtype;
	@FindBy(xpath="//span[contains(text(),'Create Agreement')]")
    WebElement cgr;
	@FindBy(xpath="//p[contains(text(),'Co-Customer')]/parent::div/following::div//button")
    WebElement ccgr;
	
	
	
	
	@FindBy(xpath="//button//span[1]")
    WebElement search;
	@FindBy(xpath="//span[contains(text(),'Create customer')]")
    WebElement createcustomer;
	
	
	
	
	public String sid="//li[@role='option']";
	public String gid="//div[@id='menu-']/div[3]/ul/li";

	public void enterFirstname()
	{
		WebDriverWait ww=new WebDriverWait(cdriver, 30);
        ww.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='FirstName' and @maxlength='30']")));
		
		firstname.sendKeys(arr.get(1));
	}
	public void enterLastname()
	{
		lastname.sendKeys(arr.get(2));
	}
	public void enterDob()
	{
	dob.sendKeys(arr.get(3));	
	}
	public void enterSS1name()
	{
		socialsecurity1.sendKeys(arr.get(4));	
	}
	public void enterSS2name()
	{
		socialsecurity2.sendKeys(arr.get(5));	
	}
	public void enterSS3name()
	{
		socialsecurity3.sendKeys(arr.get(6));	
	}
	public void enterPhone()
	{
		phonenumber.sendKeys(arr.get(7));
	}
	public void enterEmailname()
	{
		email.sendKeys(arr.get(8));	
	}
	public void enterAddress( )
	{
		address1.sendKeys(arr.get(9));	
	}
	public void enterZip()
	{
		zip.sendKeys(arr.get(10));
	}
	public void enterCityname()
	{
		city.sendKeys(arr.get(11));	
	}

	 public void validateButton()
	{
	validate.click();
     }
	public void popUp()
	{
		try
		{
		pop.click();
		}catch(Exception e)
		{
			
		}
	}
	public void validateradiopopUp()
	{
		validateradiopop.click();
	}
	public void validatecontinuepopUp()
	{
		WebDriverWait ww=new WebDriverWait(cdriver, 30);
        ww.until(ExpectedConditions.elementToBeClickable(validatecontinuepop));
		validatecontinuepop.click();
	}
	public void validateoverridepopUp()
	{
		validateoverridepop.click();
	}
	public void validatecheckbox()
	{
		checkbox.click();
	}
	public void validatenewcustomer()
	{
		try
		{
			WebDriverWait ww=new WebDriverWait(cdriver, 30);
	        ww.until(ExpectedConditions.elementToBeClickable(newcustomer));	
		newcustomer.click();
		}catch(StaleElementReferenceException e)
		{
		e.printStackTrace();	
		}
	}
	public void validateaddress()
	{
		validateaddress.click();
	}
	public void decision()
	{
		WebDriverWait ww=new WebDriverWait(cdriver, 30);
        ww.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@role='dialog']/div[2]/div/div[2]/button")));
		decision.click();
	}
	
	

	public void enterState()
    {
		try
		{
			Thread.sleep(2000);
		   dp=new  ArrayList<WebElement>() ;
			dp=(ArrayList<WebElement>)cdriver.findElements(By.xpath(sid));
	      for(int i=0;i<dp.size();i++)
	      {

				
	    	if(dp.get(i).getText().equalsIgnoreCase("TX"))
	    	{
	    		WebDriverWait ww=new WebDriverWait(cdriver, 30);
	  	        ww.until(ExpectedConditions.presenceOfElementLocated(By.xpath(sid)));
	    		dp.get(i).click();
	    	
	    	}
	      }
		}catch(Exception e)
		{
		e.printStackTrace();	
		}
    }
	      
	      
	      
	      public void enterId() 
	      {
	    	  try
	    	  {
	    		  
	    	  idtype.click();
	 		   dp=new  ArrayList<WebElement>() ;
	 		  By rdriver;
	 			dp=(ArrayList<WebElement>)cdriver.findElements(By.xpath(gid));
	 	      for(int i=0;i<dp.size();i++)
	 	      {
	 	    	if(dp.get(i).getAttribute("data-value").equalsIgnoreCase("NONE"))
	 	    	{
	 	    		dp.get(i).click();
	 	    	}
	 	    	}
	    	  }catch(StaleElementReferenceException e)
	    	  {
	    		e.printStackTrace();  
	    	  }
     }
	      public void cgr()
	      {
	    	  WebDriverWait ww=new WebDriverWait(cdriver, 30);
	          ww.until(ExpectedConditions.elementToBeClickable(cgr));
	    	  cgr.click();
	      }
	      public void ccgr()
	      {
	    	  try
	    	  {
	    		  WebDriverWait ww=new WebDriverWait(cdriver, 30);
		          ww.until(ExpectedConditions.elementToBeClickable(ccgr));
	    	  ccgr.click();
	    	  }catch(StaleElementReferenceException e)
	    	  {
	    		e.printStackTrace();  
	    	  }
	      
	      }
	      public void search()
	      {
	    	  search.click();
	      }
	      public void createCustomer()
	      {
	    	  try
	    	  {
	    	  createcustomer.click();
	      }catch(Exception e)
	    	  {
	    	  e.printStackTrace();
	    	  }
	      }
	      
	      
	      
}
	
	
	

