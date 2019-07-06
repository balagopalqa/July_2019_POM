package com.qa.Pagelayer;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.Baselayer.BaseLayer;

public class LoginPage extends BaseLayer {
@FindBy(name="username")
WebElement username;
@FindBy(name="password")
WebElement passw;

public LoginPage(){
	PageFactory.initElements(driver, this);
}


public void Login() {
	username.sendKeys("Balagopal");
	passw.sendKeys("Test@123");
	driver.close();
}

public void Login2() {
	username.sendKeys("Balagopal");
	passw.sendKeys("Test@123");
	assertTrue(false);
	driver.close();

}
	
}
