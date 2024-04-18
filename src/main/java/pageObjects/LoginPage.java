package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	public WebDriver driver;
	

	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}

	By emailid=By.name("email");
	By password=By.id("user_password");
	By login=By.name("commit");
	
	public WebElement getEmailId() {
		return driver.findElement(emailid);
	}
	public WebElement getPassword() {
		return driver.findElement(password);
	}
	public WebElement loginButton() {
		return driver.findElement(login);
	}
			
	
}
