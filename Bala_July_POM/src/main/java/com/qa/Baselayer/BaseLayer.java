package com.qa.Baselayer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import net.bytebuddy.implementation.bind.annotation.Super;

public class BaseLayer {
public static WebDriver driver;
Properties prop;
static String url_web;
static String browser;


public BaseLayer() {
	
	// TODO Auto-generated constructor stub
	prop =new Properties();
	
	try {
		FileInputStream	fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\qa\\Baselayer\\config.properties");
		prop.load(fis);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	catch (IOException e) {
		// TODO: handle exception
		e.printStackTrace();
	}
   
    url_web=prop.getProperty("url");
    browser=prop.getProperty("browser");
    
}

	public static void browser(){
			if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\chromedriver.exe");
			
			driver=new ChromeDriver();
		}
		else {
System.out.println("Browser properties not config");
		}
	
	
		
		driver.get(url_web);
		
	}
	
	public String getScreenshot() {
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis() + ".png";
		File destination = new File(path);
		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			System.out.println("Capture Failed " + e.getMessage());
		}
		return path;
	}
	
}
