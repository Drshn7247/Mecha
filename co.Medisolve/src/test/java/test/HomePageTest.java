package test;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageObjects.DetailPageObjects;
import pageObjects.HomePageObjects;
import pageObjects.SearchedProductPage;
import utils.CommonUtility;


public class HomePageTest {
	
	 WebDriver driver;
	    HomePageObjects hpo;
	    SearchedProductPage spp;
	    DetailPageObjects dpo;
	    CommonUtility cu=new CommonUtility();
		
		@BeforeSuite
		@Parameters({"browser","url"})
		void start(String browser, String url) {
			driver=cu.initSetup(browser);
			cu.lauchURL(url);
			
		}
		
		
		@BeforeClass
		void initObjct() {
			hpo=new HomePageObjects(driver);
			spp=new SearchedProductPage(driver);
			dpo=new DetailPageObjects(driver);
		}
		
		@Test(priority=1)
		void urlTest() throws IOException {
			String actualURL=driver.getCurrentUrl();
			CommonUtility.takeSS(driver);
			Assert.assertEquals(actualURL, "https://medisolve.co.in/","URL Test is successfull");
		}
		
		@Test(priority=2)
		void logoTest() {
		 hpo.closeIntroPopUp();
			boolean actualLogo=hpo.isLogoPresent();
			Assert.assertTrue(actualLogo, "Logo Test is Succssesful");
		}
		
		@Test(priority=3)
		void searchbarFieldTest() {
			boolean searchBarStatus=hpo.searchBarPresent();
			Assert.assertTrue(searchBarStatus, "search Bar is displaying on Homepage");
			hpo.setSearchBarField("Blood Pressure");
			Assert.assertTrue(hpo.isSearchiconPresent(), "Search Icon is Present");
			hpo.clickSearchIcon();
			spp.pageHeaderValidate("Searched Products");
			spp.clickOnProduct();
			String actualHeader=dpo.productDetailPage();
			Assert.assertEquals(actualHeader, "Home Product Detail", "Correct page is displaying");
			String actualproduct=dpo.getProductName();
			Assert.assertEquals(actualproduct, "ACCUSURE TD BLOOD PRESSURE MONITORING SYSTEM (1 PC)", "Correct product is displaying");
			dpo.addToCart();
		}
		
		
		@AfterClass
		void closebrowser() {
			driver.quit();
		}

}
