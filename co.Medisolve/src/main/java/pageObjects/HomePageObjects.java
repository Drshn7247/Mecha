package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageObjects {
	
WebDriver driver;
	
	@FindBy (xpath="//div[@class='logo']/a/img")
	private WebElement logo;
	
	@FindBy (xpath="//span[@id='x']")
	private WebElement closebtnIntroPopUp;
	
	@FindBy (xpath="//input[@id='key']")
	private WebElement searchBar;
	
	@FindBy (xpath="//button/i[@class='ion-ios-search-strong']")
	private WebElement searchIcon;
	
	public HomePageObjects(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean isLogoPresent() {
		boolean logoflag=logo.isDisplayed();
		return logoflag;
	}
	
	public void clickOnLogo() {
		logo.click();
	}
	
	public void closeIntroPopUp() {
		if(closebtnIntroPopUp.isDisplayed()) {
			closebtnIntroPopUp.click();
		}
		else {
			System.out.println("IntroPopUp does not displayed");
		}
	}
	
	public boolean searchBarPresent() {
		boolean searchBarFlag=searchBar.isDisplayed();
		return searchBarFlag;
	}
	
	public void setSearchBarField(String input) {
		searchBar.sendKeys(input);
	}
	
	public boolean isSearchiconPresent() {
		boolean iconflagStatus=searchIcon.isDisplayed();
		return iconflagStatus;
		
	}
	public void clickSearchIcon() {
		searchIcon.click();
	}

}
