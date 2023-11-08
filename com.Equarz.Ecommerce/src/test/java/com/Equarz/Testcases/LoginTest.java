package com.Equarz.Testcases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Pageobjects.Login_Functionality;
import com.Utils.Utils;
import com.base.Testbase;

public class LoginTest extends Testbase {
	int testid;
	private Login_Functionality lf;
	
	private final String sheetName = "logindata";

	public LoginTest() {
		super();
	}

	@DataProvider
	public String[][] loginData() throws Throwable {
		return Utils.readData(sheetName);
	}

	@BeforeMethod
	public void Initi() {
		Setup();
		lf = new Login_Functionality(driver);
		
	}


	@Test(priority = 1, dataProvider = "loginData", dataProviderClass = LoginTest.class)
	public void validatelogin(String user, String passcode) throws Throwable {

		// ut.setdata("sheet2");
		testid = 1;
		lf.Verifylogin(user, passcode);
		String url = driver.getCurrentUrl();
		assertEquals(url, "http://e-quarz.co");
	}
	
	
	
	
	@AfterMethod
	public void capturess() throws IOException {
//		if (ITestResult.FAILURE == result.getStatus()) {
//			Utils.capture(driver, testid);

		// Extentreportss.flushExtentReport();
	}

}





//@Test(priority = 1)
//public void Givenurl() 
//{
//	String givenurl = driver.getCurrentUrl();
//	Assert.assertEquals("http://e-quarz.com/customer/auth/login", givenurl);
//}