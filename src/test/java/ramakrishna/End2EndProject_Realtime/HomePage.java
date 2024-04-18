package ramakrishna.End2EndProject_Realtime;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class HomePage extends Base {
	public static Logger log= (Logger) LogManager.getLogger(Base.class.getName());
	@BeforeTest
	public void initialization() throws IOException {
		driver=initializeBrowser();
		
	}

	@Test(dataProvider = "getData")
	public void basePageNavigation(String Username, String Password){
		driver.get(prop.getProperty("url"));
		LandingPage lp=new LandingPage(driver);
		lp.getLogin().click();
		LoginPage loginpage= new LoginPage(driver);
		loginpage.getEmailId().sendKeys(Username);
		loginpage.getPassword().sendKeys(Password);
		loginpage.loginButton().click();
		log.info("Login is successful");
	}
	
	@AfterTest
	public void teardown() {
		driver.close();
	}
	
	@DataProvider
	public Object[][] getData()
    {
		//Row stands for how many different data types test should run
		//Column stands for the how many values for each test 
	   Object[][] data=new Object[2][2];
	   //0th row
	   data[0][0]="krishna@gmail.com";
	   data[0][1]="12345678";
	   //1st row
	   data[1][0]="kittu@gmail.com";
	   data[1][1]="98765432"; 
	   
	   return data;
	   
    }
}
