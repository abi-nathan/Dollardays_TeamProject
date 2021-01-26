package com.dollardays.pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.aventstack.extentreports.Status;
import com.dollardays.listners.ExtentTestManager;


public class MywishlistupdatePage {
	public WebDriver driver;	
	public WebDriverWait wait;

	public MywishlistupdatePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver,(20));
	}


	//Finding the WebElements	

	@FindBy(xpath = "//header/div[1]/div[1]/div[1]/div[3]/div[1]/ul[1]/li[2]/a[1]/img[1]")
	WebElement WishlistMenu;


	@FindBy(xpath = "//*[@id=\"aspnetForm\"]/header/div/div/div/div[3]/div/ul/li[2]/ul/li[3]/a")  
	WebElement Createawishlistsubmenu;	


	@FindBy(xpath = "//*[@id=\"aspnetForm\"]/div[3]/h5/a ") 
	WebElement Clickheretomanage;


	@FindBy(xpath = "//body/div[2]/div[1]/section[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/h5[1]/a[1]")
	WebElement YOURORGANIZATIONedit1;


	@FindBy(xpath = "//body/div[2]/div[1]/section[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/h5[1]/a[1]")
	WebElement YOURPROJECTEVENTedit2;

	@FindBy(xpath = "//body/div[2]/div[1]/section[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/h5[1]/a[1]")
	WebElement YOURWISHLISTPRODUCTSedit3;


	@FindBy(xpath = "//a[contains(text(),'View all')]")  
	WebElement YOURWISHLISTORDERSviewall;

	@FindBy(xpath = "/html/body/form/footer/div[2]/div")  
	WebElement Cookiespopup;


	@FindBy(xpath = "/html/body/form/footer/div[2]/div/p/input")  
	WebElement CookiesOkaybutton;


	@FindBy(xpath = "//a[contains(text(),'dollardays.com/firstannual/wishlist.html')]")  
	WebElement YourwishlistURL;

	@FindBy(xpath = "//input[@id='ctl00_cphContent_txtStartDate'] ")
	WebElement startdate;

	@FindBy(xpath = "//body/div[@id='ui-datepicker-div']/div[1]/div[1] ") 
	WebElement getyearfirst;

	@FindBy(xpath = "//input[@id='ctl00_cphContent_txtEndDate']")	 
	WebElement enddate;

	@FindBy(xpath = "//body/div[@id='ui-datepicker-div']/div[1]/div[1] ") 
	WebElement getyearlast;

	@FindBy(xpath = "//*[@id=\"ui-datepicker-div\"]/div/a[2]/span") 
	WebElement Nextbtn;

	@FindBy(xpath = "//body/div[@id='ui-datepicker-div']/div[1]/a[1]") 
	WebElement Prevbtn;

	@FindBy(xpath="//input[@id='ctl00_cphContent_btnFetchOrders']")
	WebElement submitbtn;

	@FindBy(xpath="//*[@id=\"aspnetForm\"]/div[3]/div/section/div/div/div/div[2]/section/div/div[1]/div/div")
	WebElement wishlistorderhistory;


	//After finding the elements, below are the methods to perform actions

	public void clickWishlist() {
		WishlistMenu.click();
	}

	public void clickCreateaWishlist() {
		Createawishlistsubmenu.click();
	}

	public void Clickheretomanage() {
		Clickheretomanage.click();
	}


	public void clickYOURORGANIZATION() {
		YOURORGANIZATIONedit1.click();
	}


	public void clickYOURPROJECTEVENT() {
		YOURPROJECTEVENTedit2.click();
	}


	public void clickYOURWISHLISTPRODUCTS() {
		YOURWISHLISTPRODUCTSedit3.click();
	}	


	public void clickYOURWISHLISTORDERS() {
		YOURWISHLISTORDERSviewall.click();
	}


	public  void getprojstartdate() {
		startdate.click();
	}

	public WebElement getyearfirst() {
		return getyearfirst;
	}

	public void clickPrevbtn() {
		Prevbtn.click();
	}

	public  void getprojEnddate() {
		enddate.click();
	}

	public WebElement getyearlast() {
		return getyearlast;
	}


	public void clickNextbtn() {
		Nextbtn.click();
	}


	public WebElement getsubmitbtn()
	{
		return submitbtn;
	}


	//Cookies popup

	public void waitVisibility(WebElement element) {		
		wait.until(ExpectedConditions.visibilityOf(element));
	}


	public void FindCookiepopup() {
		try {
			waitVisibility(Cookiespopup);
			CookiesOkaybutton.click();
			System.out.println("Cookiespopup Closed");
		}
		catch (Exception e) {
			System.out.println("No popup found"+e);
		}
	}

	//Comparing URL

	public boolean CompareURl(String originalURL) {

		String expectedURL  = driver.getCurrentUrl();

		if (originalURL.equals(expectedURL) )
		{
			//System.out.println("Got Navigated to My Account page");
			return true;
		}
		else
		{
			//System.out.println("By clicking not Navigated to My Account page");
			return false;			
		}
	}

	public void  Updatelog(boolean testscriptrun, String Logmessage) {

		if (testscriptrun)
		{
			Assert.assertTrue(true);
			ExtentTestManager.getTest().log(Status.PASS, Logmessage);
		}

		else
		{
			Assert.assertTrue(false);
			ExtentTestManager.getTest().log(Status.FAIL, Logmessage);		
		}

	}


	//YourwishlistURL check		

	public void clickYOURWISHLISTURl() {
		YourwishlistURL.click();
	}

	//Datepicker check	

	//Autodatepickerstartdate	

	public void Autodatepickerstartdate(String month, String day, String year) throws Exception {
		Thread.sleep(2000);
		//Selecting the month and year.
		while(true) 
		{
			String text =getyearfirst().getText();
			if(text.equals(month+" "+year)) {
				break;
			}
			else
			{
				clickPrevbtn();
			}
		} 
		//Selecting the date

		List<WebElement> days = driver.findElements(By.xpath("//*[@class='ui-datepicker-calendar']/tbody/tr/td/a")); 
		for (WebElement d:days)
		{ 
			System.out.println(d.getText());
			if(d.getText().equals(day))
			{
				d.click();
				Thread.sleep(2000);
				return;
			}
		}
		//Selecting the month

		List<WebElement> months = driver.findElements(By.xpath("//span[contains(text(),'January')] "));
		for (WebElement m:months)
		{ 
			System.out.println(m.getText());

			if(m.getText().equals(months))

			{

				m.click();
				Thread.sleep(2000);
				return;
			}
		}

		//Selecting the year

		List<WebElement> yearstart = driver.findElements(By.xpath("//span[contains(text(),'2018')]"));
		for (WebElement y:yearstart)
		{ 
			System.out.println(y.getText());

			if(y.getText().equals(yearstart))

			{

				y.click();
				Thread.sleep(2000);
				return;
			}
		}

	} 

	//AutodatepickerEnddate

	public void AutodatepickerEnddate(String month, String day, String year) throws Exception {

		Thread.sleep(2000);

		//Selecting the month and year.
		while(true) 
		{
			String text =getyearlast().getText();
			if(text.equals(month+" "+year)) {
				break;
			}
			else
			{
				clickPrevbtn();
			}
		} 
		//Selecting the date

		List<WebElement> days = driver.findElements(By.xpath("//*[@class='ui-datepicker-calendar']/tbody/tr/td/a")); 
		for (WebElement d:days)
		{ 
			System.out.println(d.getText());

			if(d.getText().equals(day))

			{

				d.click();
				Thread.sleep(2000);
				return;
			}
		}

		//Selecting the month

		List<WebElement> months = driver.findElements(By.xpath("//span[contains(text(),'December')] "));
		for (WebElement m:months)
		{ 
			System.out.println(m.getText());

			if(m.getText().equals(months))

			{

				m.click();
				Thread.sleep(2000);
				return;
			}
		}

		//Selecting the year

		List<WebElement> yearend = driver.findElements(By.xpath("//span[contains(text(),'2019')]"));
		for (WebElement y:yearend)
		{ 
			System.out.println(y.getText());

			if(y.getText().equals(yearend))

			{

				y.click();
				Thread.sleep(2000);
				return;
			}
		}
	} 


	public void wishorderhistory() throws Exception
	{
		getprojstartdate();;
		Autodatepickerstartdate("January", "12", "2018"); 
		getprojEnddate(); 
		AutodatepickerEnddate("December", "25", "2019"); 
		//getsubmitbtn().click();
		Thread.sleep(2000);
	}


	//Wishlistorder history submit button check	

	public void clickSubmitbtn() {
		submitbtn.click();
	}

	//Wishlistorder history updated text check	

	public WebElement getwishlistorderhistory() {
		return wishlistorderhistory;
	}
}


































