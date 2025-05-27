package PageObjects;

import java.time.Duration;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class searchClient extends pageBase {

    WebDriverWait wait;
    Actions actions;
    JavascriptExecutor js;

    public searchClient(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(1000000000));  
        actions = new Actions(driver);
        js = (JavascriptExecutor)driver;
    }

    
    @FindBy(xpath="(//span[normalize-space()='Client Manager'])[1]")
    WebElement clientManager;

    @FindBy(xpath="//span[text()='Search Clients']")
    WebElement searchClient;

    @FindBy(xpath = "//input[@name='contractId']")
    WebElement textClientId;

    @FindBy(xpath = "//input[@value='Search']")
    WebElement buttonSearch;

    @FindBy(xpath = "//a[normalize-space()='52800102']")
    WebElement clientLink;
    
  
    
    

    public void openClientManager() {
    	
    	try {
    		wait.until(ExpectedConditions.elementToBeClickable(clientManager)).click();
        } catch (ElementClickInterceptedException e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", clientManager);
        }
    	//wait.until(ExpectedConditions.visibilityOf(clientManager));
    	//wait.until(ExpectedConditions.elementToBeClickable(clientManager)).click();
    }

    public void openSearchClient() {
    
    	wait.until(ExpectedConditions.visibilityOf(searchClient));
    	wait.until(ExpectedConditions.elementToBeClickable(searchClient)).click();
    	
    }

    public void enterClientId(String clientId) {
    	
    	wait.until(ExpectedConditions.visibilityOf(textClientId)).sendKeys(clientId);
        
    }

    public void clickSearchButton() {
    	//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", buttonSearch);
    	wait.until(ExpectedConditions.visibilityOf(buttonSearch));
    	wait.until(ExpectedConditions.elementToBeClickable(buttonSearch)).click();
        
    }

    public void clickClientLink() {
    	
    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", clientLink);
         wait.until(ExpectedConditions.elementToBeClickable(clientLink)).click();
    }
}
