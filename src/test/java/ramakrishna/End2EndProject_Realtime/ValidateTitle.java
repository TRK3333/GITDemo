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

public class ValidateTitle extends Base {
	public static Logger log= (Logger) LogManager.getLogger(Base.class.getName());
	@BeforeTest
	public void initialization() throws IOException {
		driver=initializeBrowser();
		log.info("Driver is initialized");
		
		driver.get(prop.getProperty("url"));
		log.info("Navigated to Home page");
	}

	@Test
	public void basePageNavigation() {
		
		LandingPage lp=new LandingPage(driver);
		Assert.assertEquals(lp.getTitle().getText(), "FEATURED COURSES");
		log.info("Sucessfully validated title");
	}
	
	@AfterTest
	public void teardown() {
		driver.close();
	}
}
