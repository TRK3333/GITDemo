package ramakrishna.End2EndProject_Realtime;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.Base;

//Adding logs
//Generating html reports
//Screenshots on failures
//Jenkins Interaction


public class ValidateNavigationBar extends Base {
	public static Logger log= (Logger) LogManager.getLogger(Base.class.getName());
	@BeforeTest
	public void initialization() throws IOException {
		driver=initializeBrowser();
		driver.get(prop.getProperty("url"));
	}

	@Test
	public void basePageNavigation() {
		
		
		LandingPage lp=new LandingPage(driver);
		Assert.assertTrue(lp.getNavigationBar().isDisplayed());
		log.info("Navigation bar is displayed");
		
	}
	
	@AfterTest
	public void teardown() {
		driver.close();
	}
}
