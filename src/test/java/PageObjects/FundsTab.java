package PageObjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FundsTab extends PageBase {

    WebDriverWait wait;
    
    Actions actions;
    JavascriptExecutor js;

    public FundsTab(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(1000000));  // Reasonable timeout
        actions = new Actions(driver);
        js=(JavascriptExecutor)driver;
    }

    @FindBy(xpath = "//a[text()='Funds']")
    WebElement fundsTab;

    @FindBy(xpath = "//input[@value='Bulk Edit']")
    WebElement bulkEditButton;

    @FindBy(xpath="//input[@value='Full Schedule Change']")
    WebElement fullScheduleButton;

    @FindBy(xpath = "//select[@name='frequency']")
    WebElement frequencyDropdown;

    @FindBy(xpath="//input[@placeholder='Enter Date']")
    WebElement depositDateInput;
    
    @FindBy(xpath="//fieldset[@ng-disabled='!vmBulk.fullScheduleChange']")
    WebElement simpleclick;
    
    @FindBy(xpath="//body/div[44]/div[1]/div[1]/button[3]")
    WebElement calclick;
    

    @FindBy(xpath = "//input[@name='depositAmount']")
    WebElement amountInput;

    @FindBy(xpath = "//input[@value='Generate Plan']")
    WebElement generatePlanButton;

    @FindBy(xpath = "//select[@id='ChangeReasonDesc']")
    WebElement reasonDropdown;

    @FindBy(xpath = "//input[@value='Preview']")
    WebElement previewButton;

    @FindBy(xpath="//button[normalize-space()='Commit To Schedule']")
    WebElement commitToScheduleButton;
    
    @FindBy(xpath="//div[@class='toast-message']")
    WebElement confirmation;

    public void openFundsTab() {
        
        wait.until(ExpectedConditions.visibilityOf(fundsTab));

       ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", fundsTab);

        try {
            Thread.sleep(500); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        wait.until(ExpectedConditions.elementToBeClickable(fundsTab));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", fundsTab);
    }

    public void clickBulkEdit() {
    	try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        wait.until(ExpectedConditions.elementToBeClickable(bulkEditButton)).click();
    }

    public void clickFullScheduleChange() {
    	
    	try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        wait.until(ExpectedConditions.elementToBeClickable(fullScheduleButton)).click();
    }

    public void selectFrequencyByIndex(int index) {
        Select frequencySelect = new Select(frequencyDropdown);
        frequencySelect.selectByIndex(index);
    }

    public void enterDepositDate(String date) {
    	
    	wait.until(ExpectedConditions.visibilityOf(depositDateInput)).sendKeys(date);
    	
    }
    
    public void focusout() {
    	 wait.until(ExpectedConditions.elementToBeClickable(simpleclick)).click();
    }
    

    public void enterAmount(String amt) {
    	amountInput.clear();
    	wait.until(ExpectedConditions.visibilityOf(amountInput)).sendKeys(amt);
    }

    public void clickGeneratePlan() {
    	wait.until(ExpectedConditions.visibilityOf(generatePlanButton)).click();
        
    }

    public void selectReasonByIndex() {
        Select reasonSelect = new Select(reasonDropdown);
        reasonSelect.selectByIndex(1);
    }

    public void clickPreview() {
    	wait.until(ExpectedConditions.visibilityOf(previewButton)).click();
       
    }

    public void clickCommitToSchedule() {
    	((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
    	wait.until(ExpectedConditions.visibilityOf(commitToScheduleButton)).click();
        
    }
    
    public  String getconfmsg() {
    	return confirmation.getText();
    }
}
