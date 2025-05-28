package Testcases;


import org.testng.annotations.Test;

import PageObjects.searchClient;
import PageObjects.creditorTab;
import PageObjects.loginPage;
import Testbase.testBase;

public class verifyAddAccount extends testBase {
	
	@Test(priority =1)
	public void addacc() throws Exception {
		loginPage lp = new loginPage(driver);
		lp.setusername("abhi@acmeminds.com");
        lp.setpassword("@#ABHI@#");
        lp.setloginbttn(); 
        

        searchClient sc = new searchClient(driver);  
       // Thread.sleep(300);
        sc.openClientManager();
        sc.openSearchClient();
        sc.enterClientId("52800102");
        sc.clickSearchButton();
        sc.clickClientLink();
        
		creditorTab ct = new creditorTab(driver);
		ct.opencredtab();
		Thread.sleep(3000);
		ct.clickonaddaccbttn();
		ct.clickonaddlink();
		ct.enteratlasid("7");
		ct.clickonsearchbttn();
		ct.clickonselectcred();
		ct.enteraddaccnum("testaxcme23546211");
		ct.enterbalance("1000");
		ct.selectsettings();
		ct.savebutton();
		
		/*String mesgtes = ct.getconmsg();
		
		if (mesgtes == "Loan information saved successfully.!!")
		{
		   System.out.println("Test is passed");
		}
		else {
			System.out.println("Test is failed");
		}*/
		
		//ct.textacc();
				
		
	}

}
