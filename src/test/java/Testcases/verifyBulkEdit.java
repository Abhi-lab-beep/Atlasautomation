package Testcases;




import org.testng.annotations.Test;

import PageObjects.fundsTab;
import PageObjects.loginPage;
import PageObjects.searchClient;
import Testbase.testBase;

public class verifyBulkEdit extends testBase {

    @Test(priority =1)
    public void fullschedulechange() throws InterruptedException {
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
        
        

        fundsTab ft = new fundsTab(driver);
        ft.openFundsTab();
        ft.clickBulkEdit();
      //  Thread.sleep(3000);
        ft.clickFullScheduleChange();
        ft.selectFrequencyByIndex(1);
        ft.enterDepositDate("06/15/2025");
        ft.enterAmount("700.00");
        Thread.sleep(3000);
        ft.focusout();
        
        ft.selectReasonByIndex();
        ft.clickGeneratePlan();
       //  Thread.sleep(3000);
        ft.clickPreview();
      //  Thread.sleep(5000);
        ft.clickCommitToSchedule();
        
       /* String messgae = ft.getconfmsg();
       Assert.assertEquals(messgae, "Updated succesfully.");*/
    }
}

