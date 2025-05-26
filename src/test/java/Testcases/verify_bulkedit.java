package Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.FundsTab;
import PageObjects.Loginpage;
import PageObjects.SearchClient;
import Testbase.testbase;

public class verify_bulkedit extends testbase {

    @Test
    public void login() throws InterruptedException {
        Loginpage lp = new Loginpage(driver);
        lp.setusername("abhi@acmeminds.com");
        lp.setpassword("@#ABHI@#");
        lp.setloginbttn();
        

        SearchClient sc = new SearchClient(driver);  
        Thread.sleep(3000);
        sc.openClientManager();
        sc.openSearchClient();
        sc.enterClientId("36111696");
        sc.clickSearchButton();
        sc.clickClientLink();
        
        

        FundsTab ft = new FundsTab(driver);
        ft.openFundsTab();
        ft.clickBulkEdit();
        Thread.sleep(3000);
        ft.clickFullScheduleChange();
        ft.selectFrequencyByIndex(1);
        ft.enterDepositDate("06/10/2025");
        ft.enterAmount("500.00");
        ft.focusout();
        
        ft.selectReasonByIndex();
        ft.clickGeneratePlan();
         Thread.sleep(3000);
        ft.clickPreview();
        Thread.sleep(5000);
        ft.clickCommitToSchedule();
        
        Thread.sleep(3000);
        String messgae = ft.getconfmsg();
        Assert.assertEquals(messgae, "Updated succesfully.");
    }
}

