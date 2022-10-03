package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SearchedProductPage {
	
WebDriver driver;
	
	@FindBy(xpath="//h1[@class='breadcrumb-hrading']")
	private WebElement pageHeader;
	
	@FindBy(xpath="//div[@id=\"shop-1\"]//article")
	private WebElement productFirst;
	
	
	public SearchedProductPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void pageHeaderValidate(String expectedHeader) {
		String actualHeader=pageHeader.getText();
		Assert.assertEquals(actualHeader, expectedHeader, "Page is validated");
		
		
	}
	public void clickOnProduct() {
		productFirst.click();
		
	}

}
