package com.dollardays.pages;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
//import java.time.Duration;
import java.util.Hashtable;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.dollardays.commons.Base64;
import com.dollardays.commons.BrowserUtil;
import com.dollardays.listners.ExtentTestManager;
import com.dollardays.utilities.DDDataProvider;
import com.dollardays.utilities.TestUtil;

public class MyWishlistPage  {

	public WebDriver driver;
	public WebDriverWait wait;

	Boolean tsResult = false;

	public MyWishlistPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver,(5));
	}

	//Finding the WebElements

	//By iconSignin = By.xpath("//header/div[1]/div[1]/div[1]/div[3]/div[1]/ul[1]/li[1]/a[1]/img[1]");

	//@FindBy(how = How.XPATH, using = "//header/div[1]/div[1]/div[1]/div[3]/div[1]/ul[1]/li[1]/a[1]/img[1]\");
	//@CacheLookup
	//WebElement iconSignin;

	@FindBy(xpath="//header/div[1]/div[1]/div[1]/div[3]/div[1]/ul[1]/li[1]/a[1]/img[1]")
	WebElement iconSignin;		

	@FindBy(xpath = "//a[contains(text(),'Sign In')]")
	WebElement drpdownSignin;

	@FindBy(xpath = "//header/div[1]/div[1]/div[1]/div[3]/div[1]/ul[1]/li[2]/a[1]/img[1]")
	WebElement iconWishlist;

	@FindBy(xpath = "//header/div[1]/div[1]/div[1]/div[3]/div[1]/ul[1]/li[2]/ul[1]")
	WebElement drpDownList;

	public WebElement getdrpDownList() {
		return drpDownList;
	}

	@FindBy(linkText = "Learn More")
	WebElement linkLearnMore;

	//@FindBy(partialLinkText = "Donate Tod")
	@FindBy(xpath = "//a[normalize-space()='Donate Today']")
	WebElement linkDonToday;

	@FindBy(xpath = "//body/div[@id='carousel-home']/div[1]/div[1]/a[1]/img[1]")
	WebElement imgBanner1;

	public WebElement getimgBanner1(){
		return imgBanner1;
	}

	@FindBy(xpath = "//body/div[@id='carousel-home']/div[1]/div[2]/a[1]/img[1]")
	WebElement imgBanner2;

	public WebElement getimgBanner2() {
		return imgBanner2;
	}

	@FindBy(xpath = "//body/div[@id='carousel-home']/div[1]/div[3]/a[1]/img[1]")
	WebElement imgBanner3;

	public WebElement getimgBanner3() {
		return imgBanner3;
	}

	@FindBy(xpath = "//body/div[@id='carousel-home']/a[2]/span[1]")
	WebElement rightArrow;

	@FindBy(xpath = "//body/div[3]/div[1]/div[1]/div[1]/div[1]/input[1]")
	WebElement txtSearchWl;

	public WebElement getSearchWl() {
		return txtSearchWl;
	}

	@FindBy(xpath = "//body/div[3]/div[1]/div[1]/div[3]/div[1]/input[1]")
	WebElement txtCityWl;

	public WebElement getCityWl(){
		return txtCityWl;
	}

	@FindBy(xpath = "//button[normalize-space()='SEARCH']")
	WebElement btnSearch;

	public WebElement getSearch() {
		return btnSearch;
	}

	@FindBy(xpath = "//body/div[@id='wishlistmidblock']/div[1]")
	WebElement imgDonationsMadeEasy;

	@FindBy(id = "stats")
	WebElement imgOurImpact;

	//*[text()='any text']
	@FindBy (xpath = "//a[contains(text(),'Create a Wishlist')]")
	WebElement lnkCreateWishlist;

	public WebElement getCreateaWishlist() {
		return lnkCreateWishlist;
	}

	@FindBy(xpath = "//*[@id=\"wishlistmidblock\"]/div[3]/div[1]/div/p/a")
	WebElement lnkViewProjects;

	public WebElement getViewallProjects() {
		return lnkViewProjects;
	}

	@FindBy(xpath = "//body/div[@id='wishlistmidblock']/div[@class='container']/div[@class='row']/div[1]/div[1]")
	WebElement imgChristChild;

	public WebElement getChristChild() {
		return imgChristChild;
	}
	@FindBy(xpath = "//body/div[@id='wishlistmidblock']/div[@class='container']/div[@class='row']/div[2]/div[1]")
	WebElement imgFreeLaun;

	public WebElement getFreeLaun() {
		return imgFreeLaun;
	}

	@FindBy(xpath = "//body/div[@id='wishlistmidblock']/div[@class='container']/div[@class='row']/div[3]/div[1]")
	WebElement imgCoats;

	public WebElement getimgCoats() {
		return imgCoats;
	}

	//tagname[@attribute = 'value']

	@FindBy(xpath = "//a[@href='/thirtysixthannualcoatsforkids/wishlist.html']")
	WebElement lnkDonateNow1;

	@FindBy(xpath = "//a[@href='/wintercarepackages/wishlist.html']")
	WebElement lnkDonateNow2;

	@FindBy(xpath = "//a[@href='/clothingthehomelessorg/wishlist.html']")
	WebElement lnkDonateNow3;


	@FindBy(xpath = "//a[contains(text(),'Click here to manage')]")
	@CacheLookup
	WebElement clearToManage;

	@FindBy(xpath = "//*[@id=\"modal-nonregoffer\"]/div/div/div")
	WebElement popupWindow;

	@FindBy(xpath = "//*[@id=\"close2\"]/span")
	WebElement popupClose;

	@FindBy(xpath = "//body/div[4]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/a[2]")
	WebElement donateNow;

	public WebElement getDonateNow() {
		return donateNow;
	}

	@FindBy(xpath = "/html/body/form/footer/div[2]/div")  
	WebElement Wincookies;

	@FindBy(xpath = "/html/body/form/footer/div[2]/div/p/input")
	WebElement btnCookieOkay;
	//@FindBy(xpath = "/html/body/footer/div[3]/div/p/input")
	//WebElement btnCookieOkay;

	@FindBy(xpath = "//h2[normalize-space()='Wishlist Results']")
	WebElement msgWishResult;

	public WebElement getWishResult() {
		return msgWishResult;
	}
	@FindBy(xpath = "//h2[contains(text(),'No matching wishlist found.')]")
	//@FindBy(xpath = "//*[@class = project-title]/h2")
	WebElement msgWishNoResult;

	public WebElement gettitleWishNoResult() {
		return msgWishNoResult;
	}

	@FindBy(xpath = "//*[@id=\"ctl00_cphContent_wishlistcontainer\"]/div[4]/div[2]/div[2]/div/div[3]/div[1]/input")
	WebElement txtAddCount;

	@FindBy(xpath = "//body/div[@id='ctl00_cphContent_wishlistcontainer']/div[4]/div[2]/div[2]/div[1]/div[3]/div[2]/input[1]")
	WebElement btnDonate;

	public WebElement getBtnDonate() {
		return btnDonate;
	}

	@FindBy(xpath = "//header/div[1]/div[1]/div[1]/div[3]/div[1]/ul[1]/div[1]/div[1]/ul[1]/div[1]/li[2]/div[2]")
	WebElement winCheckout;

	public WebElement getWinCheckout() {
		return winCheckout;
	}

	@FindBy(xpath = "//a[normalize-space()='CHECKOUT']")
	WebElement btnCheckout;

	@FindBy(xpath = "//a[contains(text(),'VIEW CART')]")
	WebElement btnViewcart;

	@FindBy(xpath = "//body/div[@id='ctl00_cphContent_wishlistcontainer']/div[1]/div[1]/div[1]/div[1]/div[1]/a[1]")
	WebElement btnCheckout1;

	@FindBy(xpath = "//body/div[2]/div[1]/div[1]/div[1]/h5[1]/a[1]")
	WebElement lnkReturntoCart;

	@FindBy(xpath = "//*[@id=\"ctl00_cphContent_wishlistcontainer\"]/div[2]/div/div[1]/div[1]/div/h3/span/a")
	WebElement lnkReturntoWishlist;


	//After finding the elements, below are the methods to perform actions
	//Keeping the methods in POM neutral, they can be used in both negative and positive tests.
	public void clickSignin() {
		iconSignin.click();
	}
	public void clickdrpdownSignin() {
		drpdownSignin.click();
	}
	public void clickWishlist() {
		iconWishlist.click();
	}
	public boolean drpDownCount(WebElement drpdown) {
		String[] options = drpdown.getText().split("\n");
		int count = options.length;
		System.out.println("The number of items listed in dropdown list = " + count);
		if (count>0) {
			int i=1;
			for (i=1; i<count; i++ ) 
			{
				System.out.println("The list in the dropdown  - " +options[i]);
			}
			return true;
		}
		else {
			System.out.println("The dropdown not listed");
			return false;
		}

	}
	public void clickLearnMore() {
		linkLearnMore.click();
	}
	public void clickDonToday() {
		linkDonToday.click();
	}
	public boolean displayBanner1(){
		boolean imagePresent;
		waitVisibility(imgBanner1);
		imagePresent = imgBanner1.isDisplayed();
		return imagePresent;
	} 
	public boolean displayBanner2() {
		boolean imagePresent = imgBanner2.isDisplayed();
		return imagePresent;
	} 
	public boolean displayBanner3() {
		boolean imagePresent = imgBanner3.isDisplayed();
		return imagePresent;
	}
	public void clickimgBanner1() {
		imgBanner1.click();
	}
	public void clickimgBanner2() {
		imgBanner2.click();
	}
	public void clickimgBanner3() {
		imgBanner3.click();
	}
	public void clickrightArrow() {
		rightArrow.click();
	}
	public void clickSearchWl() {
		txtSearchWl.click();
	}
	public void clickCityWl() {
		txtCityWl.click();
	}
	public void setSearchWl(String searchOrg) {
		txtSearchWl.sendKeys(searchOrg);
	}
	public void setCityWl(String searchCity) {
		txtCityWl.sendKeys(searchCity);
	}
	public void setBothOrgCity(String searchOrg, String searchCity) {
		txtSearchWl.sendKeys(searchOrg);
		txtCityWl.sendKeys(searchCity);
	}
	/*public void setSearchWl(String sname){
		txtSearchWl.sendKeys(sname);
	}
	public void setCityWl(String cname) {
		txtCityWl.sendKeys(cname);
	}*/
	public void clickSearch() {
		btnSearch.click();
	}
	public void clickCreateWishlist() {
		lnkCreateWishlist.click();
	}
	public void clickClearToManage() {
		clearToManage.click();
	}
	public void clickViewProjects() {
		lnkViewProjects.click();
	}
	public boolean displayDonationsMade() {
		boolean imagePresent = imgDonationsMadeEasy.isDisplayed();
		return imagePresent;
	}
	public boolean displayOurImpact() {
		boolean imagePresent = imgOurImpact.isDisplayed();
		return imagePresent;
	}
	public boolean displayChrist() {
		boolean imagePresent = imgChristChild.isDisplayed();
		return imagePresent;

		/*boolean imagePresent = (boolean)((JavascriptExecutor) driver).executeScript("return arguments[0].complete && typeof argumants[0].naturalWidth !=\"undefined\" && arguments[0].naturalWidth>0",imgChristChild);
		return imagePresent;*/
	}
	public boolean displayFreeLaun() {
		boolean imagePresent = imgFreeLaun.isDisplayed();
		return imagePresent;
	}
	public boolean displayCoats() {
		boolean imagePresent = imgCoats.isDisplayed();
		return imagePresent;
	}
	public void clickDonateNow1() {
		lnkDonateNow1.click();
	}
	public void clickDonateNow2() {
		lnkDonateNow2.click();
	}
	public void clickDonateNow3() {
		lnkDonateNow3.click();
	}
	public void clickDonateNow() {
		donateNow.click();
	}
	public void setAddCount() {
		txtAddCount.sendKeys(""+10);
	}
	public void clickBtnDonate() {
		btnDonate.click();
	}
	public void clickCheckout() {
		btnCheckout.click();
	}
	public void clickViewcart() {
		btnViewcart.click();
	}
	public void clickCheckout1() {
		btnCheckout1.click();
	}
	public void clickReturntoCart() {
		lnkReturntoCart.click();
	}
	public void clickReturntoWishlist() {
		lnkReturntoWishlist.click();
	}

	//Common Methods
	public void waitVisibility(WebElement element) 
	{
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public void findPopup() {
		try 
		{
			waitVisibility(popupWindow);
			popupClose.click();
			System.out.println("Popup closed Successfully");
		}   
		catch (Exception e) {
			System.out.println("Popup not found   " + e);
		}
	}
	public void checkImage(boolean imagePresent) 
	{
		if(!imagePresent) {
			System.out.print("The image ***not*** displayed");
		}else
			System.out.println("The image displayed Sucessfully");
		//return imagePresent;
	}
	public boolean colorValidation(WebElement element)
	{
		String color1 = element.getCssValue("background-color");
		System.out.println("The Color before mouse hover -- " +color1);

		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();

		String color2 = element.getCssValue("background-color");
		System.out.println("The Color after mouse hover -- "+color2);

		if(color1!=color2) {
			return true;
		}else
			return false;
	}

	public void updateLog(Boolean tstScriptRun, String logMessage, String snapname) throws Exception
	{
		try {
			if(tstScriptRun == true)
			{
				Assert.assertTrue(true);
				BrowserUtil.takeSnapShot(driver,"P_" +snapname);
				ExtentTestManager.getTest().log(Status.PASS,logMessage);

			} else
			{
				BrowserUtil.takeSnapShot(driver, "F_" +snapname);
				ExtentTestManager.getTest().log(Status.FAIL,logMessage + "Failed");
			}
		}
		catch (Exception e) {

			System.out.println(e);
		}	
	}
	public boolean compareUrl(String actualUrl) {
		String currentUrl = driver.getCurrentUrl();
		if (currentUrl.equals(actualUrl))
		{
			System.out.println("Got Navigated to targeted Page Successfully");
			return true;
		}
		else
			System.out.println("By clicking not reached the targeted Page");
		return false;
	}

	public boolean compareTitle(String actualTitle) {
		String expectedTitle = driver.getTitle();
		if(actualTitle.equals(expectedTitle))
		{
			System.out.println("The titles of both the pages are same");
			return true;
		} else
			System.out.println("The titles of both the pages are different");
		return false;
	}
	public void clickCookieOkay() {
		try {
			//waitVisibility(Wincookies);
			mouseHover(Wincookies);
			btnCookieOkay.click();
			System.out.println("The cookie alert found and cleared");

		} catch (Exception e) {
			System.out.println("The cookie alert not found" +e);
		}
	}
	public boolean compareText(WebElement element, String actualText) {
		String currentText = element.getText();
		if (actualText.equals(currentText)) {
			return true;
		} else
			return false;
	}
	public void mouseHover(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}

	public boolean containsValidation(String text) {

		if (driver.getPageSource().contains(text)){
			System.out.println(text);
			return true;

		} else
			return false;
	}




}