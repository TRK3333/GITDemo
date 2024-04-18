package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	public WebDriver driver;
	public Properties prop;
	@SuppressWarnings("deprecation")
	public WebDriver initializeBrowser() throws IOException {
		prop=new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\Krishna\\eclipse-workspace\\Automation_Testing\\End2EndProject-Realtime\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		String browserName= prop.getProperty("browser");
		if(browserName.equals("chrome")) {
			
			WebDriverManager.chromedriver().setup();
			 driver= new ChromeDriver();
		}
		else if (browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			 driver=new FirefoxDriver();
		}
		else if (browserName.equals("IE")) {
			WebDriverManager.edgedriver().setup();
			 driver= new EdgeDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
}
