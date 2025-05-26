package Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.SearchClient;
import PageObjects.creditortab;
import Testbase.testbase;

public class verify_addaccount extends testbase {
	
	@Test(priority =1)
	public void addacc() throws Exception {
		
	/*	SearchClient sc = new SearchClient(driver);  
        Thread.sleep(3000);
        sc.openClientManager();
        sc.openSearchClient();
        sc.enterClientId("36111696");
        sc.clickSearchButton();
        sc.clickClientLink();*/
		
		creditortab ct = new creditortab(driver);
		ct.opencredtab();
		ct.clickonaddaccbttn();
		ct.clickonaddlink();
		ct.enteratlasid("7");
		ct.clickonsearchbttn();
		ct.clickonselectcred();
		ct.enteraddaccnum("testaxcme4511");
		ct.enterbalance("800");
		ct.selectsettings();
		ct.savebutton();
		
		String mesgtes = ct.getconmsg();
		
		if (mesgtes == "Loan information saved successfully.!!")
		{
		   System.out.println("Test is passed");
		}
		else {
			System.out.println("Test is failed");
		}
		
		ct.textacc();
				
		
	}

}
