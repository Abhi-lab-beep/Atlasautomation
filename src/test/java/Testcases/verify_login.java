package Testcases;

import org.testng.annotations.Test;

import PageObjects.Loginpage;
import Testbase.testbase;

public class verify_login extends testbase{
	
	
	@Test
	public void login() {
	Loginpage lp = new Loginpage(driver);
	lp.setusername("abhi@acmeminds.com");
	lp.setpassword("12345678");
	lp.setloginbttn();
	}
	
}
