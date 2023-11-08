package com.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.DataProvider;

import com.base.Testbase;

public class Utils extends Testbase {
private static final String filePath=	"./src/main/java/com/testdata/Registration data.xlsx";
	

	public static String[][] readData(String sheetName) throws Throwable {

		File file = new File(filePath);
		FileInputStream stream = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(stream);
		XSSFSheet sheet = workbook.getSheet(sheetName);

		int rows = sheet.getPhysicalNumberOfRows();
		int columns = sheet.getRow(1).getLastCellNum();
		String[][] data = new String[rows - 1][columns];

		for (int i = 0; i < rows - 1; i++) {
			for (int j = 0; j < columns; j++) {
				DataFormatter df = new DataFormatter();
				data[i][j] = df.formatCellValue(sheet.getRow(i + 1).getCell(j));
			}
		}
		return data;
	}

//	public static void capture(WebDriver driver,int testid ) throws IOException{
//		
//		
//		// Get current system date and time
//		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM--dd--HH--mm--ss");		
//		Date date=new Date();
//		
//		String dateTime=sdf.format(date);
//		
//		
//		//Create a filename 
//		String Screenshot=dateTime+"_"+testid;
//		// Take ScreenShot
//		TakesScreenshot ts=(TakesScreenshot)driver;
//		File source=ts.getScreenshotAs(OutputType.FILE);
//		//save Screenshot to file 
//		File dest=new File("./test-output/test.png");
//	    FileHandler.copy(source, dest);	
//		
//	}
	
//	public static void takeScreenshotAtEndOfTest() throws IOException {
//		
//		TakesScreenshot ts=(TakesScreenshot)driver;
//		
//		File src=ts.getScreenshotAs(OutputType.FILE);
//		File target=new File("./screenshots/failedtestcases.png");
//		FileUtils.copyFile(src, target);
		
		
		public static void takeScreenshotAtEndOfTest() throws IOException {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String currentDir = System.getProperty("user.dir");

			FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
		
	}
		
		
//		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//		String currentDir = System.getProperty("user.dir");
//		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}

	


