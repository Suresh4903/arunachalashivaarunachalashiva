
package com.Racpad.Testcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	public static WebDriver driver;
	public static String url;
	public static String username;
	public static String password;
	public static Actions act;
	public static ArrayList<String> arr = new ArrayList<String>();
	public static Logger log;

	@BeforeClass
	public void setUp() throws InterruptedException, IOException {

		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\user\\eclipse-workspace\\Racpad\\data.properties");
		prop.load(fis);
		url = prop.getProperty("url");
		username = prop.getProperty("username");
		password = prop.getProperty("password");

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		log = Logger.getLogger("Base.class");
		DOMConfigurator.configure("log4j.xml");
		log.info("driveraccessed");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		log.info("window maximized");
		act = new Actions(driver);
		driver.get(url);
		driver.findElement(By.tagName("span")).click();
		driver.findElement(By.id("okta-signin-username")).sendKeys(username);
		driver.findElement(By.id("okta-signin-submit")).click();
		driver.findElement(By.xpath("//input[@id='input59']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@value='Verify']")).click();
		Thread.sleep(6000);
	}

	@AfterClass
	public void tearDown() {
		//driver.close();
	}

	public static ArrayList<String> dataDriven() throws IOException {

		FileInputStream fis = new FileInputStream("C:\\Users\\user\\eclipse-workspace\\Racpad\\Book1.xlsx");
		XSSFWorkbook book = new XSSFWorkbook(fis);
		XSSFSheet sheet = book.getSheet("testdata");
		Iterator<Row> rows = sheet.iterator();

		while (rows.hasNext()) {
			Row rr = rows.next();
			Row rr1 = rows.next();
			Row rr2 = rows.next();
			Iterator<Cell> c1 = rr2.iterator();
			while (c1.hasNext()) {
				Cell cc = c1.next();
				if (cc.getCellTypeEnum() == CellType.STRING) {
					String s = cc.getStringCellValue();
					arr.add(s);
				} else {
					String r = NumberToTextConverter.toText(cc.getNumericCellValue());

					arr.add(r);
				}

			}
			System.out.println(arr);
		}
		return arr;
	}

}
