package com.qa.listener;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.Listeners;

import com.qa.pages.BaseClass;

public class TestUtil2 extends BaseClass{
	
	public static long PAGE_LOAD_TIMEOUT=40;
	public static long IMPLICIT_WAIT=40;
	WebDriverWait wait=new WebDriverWait(driver, 20);
	
	public void Dropdownbox() {
		WebElement addruleconcerning=driver.findElement(By.xpath("//*[@id=\"product_rule_type_1\"]"));
	
	Select s=new Select(addruleconcerning);
	s.selectByVisibleText("Products");
}

	public static String TESTDATA_SHEET_PATH ="C:\\Users\\Lenovo\\Desktop\\Testdata.xlsx";

	static Workbook book;
	static Sheet sheet;
	static JavascriptExecutor js;

	

	public static Object[][] getTestData(String sheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		// System.out.println(sheet.getLastRowNum() + "--------" +
		// sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				// System.out.println(data[i][k]);
			}
		}
		return data;
	}
	

	 public static void takeScreenshotAtEndOfTest() throws IOException 
	 {
		    String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String currentDir = System.getProperty("user.dir");
			FileUtils.copyFile(scrFile, new File(currentDir + "/ErrorScreenshots/" +dateName+ System.currentTimeMillis() + ".png"));
	  }


	}

 	

