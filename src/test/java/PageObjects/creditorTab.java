package PageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class creditorTab extends pageBase{
	
     WebDriverWait wait;
    Actions actions;
    JavascriptExecutor js;

	public creditorTab(WebDriver driver) {
		super(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(100000));  // Reasonable timeout
        actions = new Actions(driver);
        js=(JavascriptExecutor)driver;
	}
	
	@FindBy(xpath="//a[normalize-space()='Creditors']")
	WebElement credtab;
	
	@FindBy(xpath="//input[@value='Add Account']")
	WebElement addaccbttn;
	
	@FindBy(xpath="//a[normalize-space()='Add']")
	WebElement addcred;
	
	@FindBy(xpath="//input[@ng-model='filter.Id']")
	WebElement atlasid;
	
	@FindBy(xpath="//input[contains(@value,'search')]")
	WebElement seacrhcredbttn;
	
	@FindBy(xpath="//a[normalize-space()='Select']")
	WebElement selectcred;
	
	@FindBy(xpath="//input[contains(@name,'inputaccount')]")
	WebElement addaccnum;
	
	@FindBy(xpath="//input[@id='balance']")
	WebElement addbalance;
	
	@FindBy(xpath="//select[@name='status']")
	WebElement selectsettings;
	
	@FindBy(xpath="//input[@class='btn btn-sm btn-primary']")
	WebElement savebttn;
	
	@FindBy(xpath="//div[@class='toast-message']")
	WebElement confmessage;
	
	////div[@class='loan-table-list box-shadow']/table/tbody/tr/td[5]
	
	@FindBy(xpath="div[@class='loan-table-list box-shadow']/table/tbody/tr/td[5]")
	List<WebElement> acclist;
	
	public void opencredtab()
	{
		wait.until(ExpectedConditions.visibilityOf(credtab));

	       ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", credtab);

	        try {
	            Thread.sleep(500); 
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }

	        wait.until(ExpectedConditions.elementToBeClickable(credtab));
	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", credtab);
	}
	
	public void clickonaddaccbttn() {
    	wait.until(ExpectedConditions.elementToBeClickable(addaccbttn)).click();
  
		//wait.until(ExpectedConditions.visibilityOf(addaccbttn)).click();
	}
	
	
	public void clickonaddlink() {
		wait.until(ExpectedConditions.visibilityOf(addcred)).click();
	}
	
	public void enteratlasid(String enterid) {
		wait.until(ExpectedConditions.visibilityOf(atlasid)).sendKeys("7");
		
	}
	
	public void clickonsearchbttn() {
		wait.until(ExpectedConditions.visibilityOf(seacrhcredbttn)).click();
	}
	
	public void clickonselectcred() {
		wait.until(ExpectedConditions.visibilityOf(selectcred)).click();
	}
	//addaccnum
	public void  enteraddaccnum(String accnum) {
		wait.until(ExpectedConditions.visibilityOf(addaccnum)).sendKeys(accnum);
	}
	
	public void  enterbalance(String bal) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addbalance);
		wait.until(ExpectedConditions.visibilityOf(addbalance)).sendKeys(bal);
	}
	
	public void selectsettings() {
		wait.until(ExpectedConditions.visibilityOf(selectsettings));
		Select settingdropdown = new Select(selectsettings);
		settingdropdown.selectByContainsVisibleText("Active");
		//settingdropdown.selectByValue("Active");
	}
	
	public void savebutton()
	{
		wait.until(ExpectedConditions.visibilityOf(savebttn));

	       ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", savebttn);

	        try {
	            Thread.sleep(500); 
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }

	        wait.until(ExpectedConditions.elementToBeClickable(savebttn));
	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", savebttn);
	}
	
	public  String getconmsg() {
    	return confmessage.getText();
    }
	
	public void textacc() {
		List <WebElement> list = acclist;
		
		for(int i =0; i<list.size(); i++) {
			System.out.println(list.get(i).getText());
			if(list.get(i).getText().equals("textasne545")) {
				System.out.println(list.get(i));
				break;
			}
		}
		
	}
}


