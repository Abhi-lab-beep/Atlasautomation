package PageObjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchClient extends PageBase {

    WebDriverWait wait;
    Actions actions;
    JavascriptExecutor js;

    public SearchClient(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(100000000));  
        actions = new Actions(driver);
        js = (JavascriptExecutor)driver;
    }

    @FindBy(xpath = "//span[text()='Client Manager']")
    WebElement clientManager;

    @FindBy(xpath="//span[text()='Search Clients']")
    WebElement searchClient;

    @FindBy(xpath = "//input[@name='contractId']")
    WebElement textClientId;

    @FindBy(xpath = "//input[@value='Search']")
    WebElement buttonSearch;

    @FindBy(xpath = "//a[normalize-space()='36111696']")
    WebElement clientLink;
    
    

    public void openClientManager() {
    
    	wait.until(ExpectedConditions.elementToBeClickable(clientManager)).click();
  
    }

    public void openSearchClient() {
    	
    	wait.until(ExpectedConditions.visibilityOf(searchClient)).click();
    	js.executeScript("arguments[0].click();", searchClient);
    	
    }

    public void enterClientId(String clientId) {
    	wait.until(ExpectedConditions.visibilityOf(textClientId)).sendKeys(clientId);
        
    }

    public void clickSearchButton() {
    	wait.until(ExpectedConditions.visibilityOf(buttonSearch)).click();
        
    }

    public void clickClientLink() {
    	wait.until(ExpectedConditions.visibilityOf(clientLink)).click();
       
    }
}
