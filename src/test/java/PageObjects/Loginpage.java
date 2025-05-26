package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Loginpage extends PageBase {
	
	public Loginpage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="(//input[@id='username'])[1]")
	WebElement text_username;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement text_Password;
	
	@FindBy(xpath="//a[normalize-space()='Log in']")
	WebElement bttn_login;
	
	public void setusername(String uname) {
		text_username.sendKeys(uname);
		}
	
	public void setpassword(String pass) {
		text_Password.sendKeys(pass);
		}
	
	public void setloginbttn() {
		bttn_login.click();
	}

}
