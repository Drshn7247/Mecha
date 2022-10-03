package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class DetailPageObjects {
	
WebDriver driver;
	
	@FindBy(xpath="//ul[@class=\"breadcrumb-links\"]")
	private WebElement detailPageHeader;
	
	@FindBy(id="productname")
	private WebElement productHeader;
	
	@FindBy(xpath="//a[@id='addtocart']")
	private WebElement addToCartBtn;
	
	public DetailPageObjects(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public String productDetailPage() {
		String detailPage=null;
		if(detailPageHeader.isDisplayed()) {
			 detailPage=detailPageHeader.getText();
		}
		else {
			Assert.fail("Doesn't load product page properly");
		}
		return detailPage;
	}
	
	public String getProductName() {
		String productname=null;
		if(productHeader.isDisplayed()) {
			productname=productHeader.getText();
		}
		else {
			Assert.fail("Product is not displaying");
		}
		return 	productname;
		
	}
	
	public void addToCart() {
		addToCartBtn.click();
		
		
	}

}
