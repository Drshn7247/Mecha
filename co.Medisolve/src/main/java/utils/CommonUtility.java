package utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.io.FileHandler;

public class CommonUtility {
	
	WebDriver driver=null;
	
	public WebDriver initSetup(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
	//	WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\DARSHAN\\eclipse-workspace\\co.Medisolve\\Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", "C:\\Users\\DARSHAN\\eclipse-workspace\\co.Medisolve\\Drivers\\msedgedriver.exe");
			driver=new EdgeDriver();
		}
		return driver;
	}


    public void lauchURL(String url) {
	    driver.get(url);
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }
    
    public static void takeSS(WebDriver driver) throws IOException {
    	SimpleDateFormat formatter=new SimpleDateFormat("dd-mm-yy hh-mm-ss");
    	Date date=new Date();
    	String d=formatter.format(date);
    	File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    	File dest=new File("C:\\Users\\DARSHAN\\eclipse-workspace\\co.Medisolve\\src\\test\\resources\\Screenshots"+d +".jpg");
    	FileHandler.copy(src, dest);
    }
}