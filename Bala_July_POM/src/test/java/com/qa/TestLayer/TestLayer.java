package com.qa.TestLayer;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.Baselayer.BaseLayer;
import com.qa.Pagelayer.LoginPage;

public class TestLayer extends BaseLayer{
	LoginPage log;
	
	@BeforeMethod
	public void initialization() {
		browser();
		log=new LoginPage();
		
	}
	
	@Test
	public void Logintest() {
		log.Login();
	}
	
	
	@Test
	public void Logintest2() {
		log.Login2();
	}
	
	
	
}
