package com.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Utils.EventListeners;



public class Testbase {

	
	
	FileInputStream file;
	public static Properties props;
	public static WebDriver driver;
	public WebDriverWait wait;
	public  static EventFiringWebDriver e_driver;
	public static EventListeners listenerss;
	

	public Testbase() {
		
		props = new Properties();

		try {
			file = new FileInputStream("./src/main/java/com/PropertiesConfig/Propfile");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			props.load(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void Setup() {

		String browsername = props.getProperty("browser");

		if (browsername.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Jakkam Sairam\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
			driver = new ChromeDriver();
		}

		else if (browsername.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.chrome.driver", "");
			driver = new EdgeDriver();
		}

		else if (browsername.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.chrome.driver", "");
			driver = new FirefoxDriver();
		}

		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		listenerss = new EventListeners();
		e_driver.register(listenerss);
		driver = e_driver;

		
		driver.manage().window().maximize();
		//driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.get(props.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
		//driver.manage().deleteAllCookies();
		
		
	}
}
