package PageObjects;


import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class pageBase {
    public WebDriver driver;

   
    public pageBase(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
       // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
}