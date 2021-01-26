package com.dollardays.testcases;

import com.dollardays.commons.*;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.Hashtable;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.dollardays.commons.Base64;
import com.dollardays.commons.BrowserUtil;
import com.dollardays.listners.ExtentTestManager;
import com.dollardays.pages.LoginPage;
import com.dollardays.pages.MyWishlistPage;
import com.dollardays.utilities.DDDataProvider;
import com.dollardays.utilities.TestUtil;


//Class for wishlist test cases
public class TC_Wishlist extends BaseTest {



	@DDDataProvider(datafile= "testdata/testdata1.xlsx",sheetName ="Sheet1",testcaseID = "TC1",runmode = "Yes")
	@Test(priority = 1,dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
	//@Test(priority = 1)
	public void wishlistTest_1(Hashtable<String, String> datatable) throws Exception
	{

		MyWishlistPage wl = new MyWishlistPage(driver);

		//Logging in to dollardays webpage
		wl.clickSignin();
		wl.clickdrpdownSignin();

		LoginPage loginpage = new LoginPage(driver);
		//loginpage.invokeLogin();

		loginpage.login(datatable.get("UserName"), Base64.decrypt(datatable.get("Password")));		

		//wl.findPopup();
		Thread.sleep(3000);

		boolean logged = wl.compareUrl("https://www.dollardays.com/");
		wl.updateLog(logged,"TS 01: Logged in Dollar Days webpage Successfully", "TS01_Logged");

		//Clicking WishList and getting dropdown
		wl.clickCookieOkay();
		wl.clickWishlist();
		Thread.sleep(3000);
		boolean result = wl.drpDownCount(wl.getdrpDownList());
		//Thread.sleep(3000);
		wl.updateLog(result,"TS 02: Wishlist icon clicked and dropdown listed", "TS02_WL_DrpDown");

		//Clicking Learn more from drop down and capturing title of the page 
		wl.clickLearnMore();
		String title1 = driver.getTitle();
		Thread.sleep(3000);
		System.out.println("The LearnMore title is "+title1);

		driver.navigate().back();

		wl.clickWishlist();
		Thread.sleep(3000);

		//Clicking Donate today from drop down and capturing title of the page 
		//and validating both the titles
		wl.clickDonToday();
		String title2 = driver.getTitle();
		Thread.sleep(3000);
		System.out.println("The DonateToday title is "+title2);
		boolean title = title1.equals(title2);
		if (title == true) {
			System.out.println("The titles of both pages are same");
			wl.updateLog(title,"TS 03a: By Clicking Learn More/Donate Today - Navigates to same Page","TS03a_Navigation" );
		}else {
			wl.updateLog(title,"TS 03b: By Clicking Learn More/Donate Today -Not Navigates to same Page","TS03b_Navigation" );
		}

		//Capturing BannerImage
		SoftAssert softassert = new SoftAssert();

		//Validating Banner 1
		boolean img1 =  wl.displayBanner1();
		wl.checkImage(img1);
		softassert.assertTrue(img1);
		wl.updateLog(img1, "TS 04: Banner1 image captured Successfully", "TS04_Bnr1");
		softassert.assertAll();
		////////////////////////
		wl.clickimgBanner1();

		wl.clickClearToManage();
		Thread.sleep(3000);

		wl.compareTitle("Account - DollarDays");
		System.out.println("Navigated to ~~MY WISHLIST~~ page" );
		wl.updateLog(logged,"TS 05: By Clicking Banner1, navigated to ~~MY WISHLIST~~ page - Sucessfully","TS05_Bnr1Nav" );

		wl.clickWishlist();
		wl.clickLearnMore();
		Thread.sleep(2000);
		wl.clickrightArrow();
		///////////////////////////////////
		//Thread.sleep(5050);
		Thread.sleep(3000);

		//Validating Banner2
		img1 =  wl.displayBanner2();
		wl.checkImage(img1);
		softassert.assertTrue(img1);
		wl.updateLog(img1, "TS 06: Banner2 image captured Successfully","TS06_Bnr2");
		softassert.assertAll();
		///////////////////////////////////
		wl.clickimgBanner2();
		//Thread.sleep(3000);
		boolean btitle1 = wl.compareUrl("https://www.dollardays.com/landing/wishlisttoolkit");
		System.out.println("Navigated to ~~WISHLIST TOOLKIT~~ page" );

		wl.updateLog(btitle1,"TS 07: By Clicking Banner2, navigated to ~~WISHLIST TOOLKIT~~ page - Sucessfully","TS07_BnrNav");

		driver.navigate().back();
		wl.clickrightArrow();
		Thread.sleep(3000);
		wl.clickrightArrow();
		//wl.clickrightArrow();

		//Thread.sleep(5000);
		Thread.sleep(3000);

		//Validating Banner3
		img1 =  wl.displayBanner3();

		wl.checkImage(img1);
		softassert.assertTrue(img1);
		wl.updateLog(img1, "TS 08: Banner3 image captured Successfully","TS08_Bnr3");
		softassert.assertAll();

		wl.clickimgBanner3();
		boolean btitle2 = wl.compareUrl("https://www.dollardays.com/notredameprep/wishlist.html");
		System.out.println("Navigated to ~~WHY WISHLIST~~ page" );

		wl.updateLog(btitle2,"TS 09: Clicking on Banner3 navigated to ~~WHY WISHLIST~~ page","TS09_Bnr3Nav");
		driver.navigate().back();
		//	wl.findPopup();
		//Thread.sleep(3000);
	}
	@DDDataProvider(datafile= "testdata/Wl_Testdata.xlsx",sheetName ="Wl_Search",testcaseID = "",runmode = "Yes")
	@Test(priority = 2,dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
	public void wishlistTest_2(Hashtable<String, String> datatable) throws Exception
	{

		MyWishlistPage wl = new MyWishlistPage(driver);

		wl.clickWishlist();
		wl.clickLearnMore();
		Thread.sleep(3000);

		boolean bSerfield1,bSerfield2,bSerfield3,bSerfield4,bSerfield5;
		bSerfield1 = false;
		bSerfield2 = false;
		bSerfield3 = false;
		bSerfield4 = false;
		bSerfield5 = false;

		if ((datatable.get("Search by Organization") != null && !(datatable.get("Search by Organization").equals("")))) {
			bSerfield1 = true;

		}
		if ((datatable.get("Wishlist name") != null && !(datatable.get("Wishlist name").equals("")))) {
			bSerfield2 = true;
		}

		if ((datatable.get("City") != null && !(datatable.get("City").equals("")))) {
			bSerfield3= true;
		}

		if ((datatable.get("State") != null && !(datatable.get("State").equals("")))) {
			bSerfield4 = true;
		}

		if ((datatable.get("zipcode") != null && !(datatable.get("zipcode").equals("")))) {
			bSerfield5 = true;
		}

		//Search by Organization
		if(bSerfield1) {
			wl.clickSearchWl();

			//Fetching data from excel sheet
			wl.setSearchWl(datatable.get("Search by Organization"));
			Thread.sleep(3000);
			wl.updateLog(true,"TS 10: Valid data entered in Search bar","TS10_ValidData");

			//Validating color change of Search button during mouse hover
			WebElement tempSearch = wl.getSearch();
			Boolean sResult = wl.colorValidation(tempSearch);
			wl.updateLog(sResult,"TS 11: The ~~Search~~ button color changed during mousehover Successfully","TS11_SerHover");
			Thread.sleep(3000);

			wl.clickSearch();
			Thread.sleep(3000);


			//Capturing the Wishlist Result text and scrolling down to see the result
			boolean btext = wl.compareText(wl.getWishResult(),"Wishlist Results" );

			BrowserUtil.scrollToDown(driver);
			Thread.sleep(3000);
			wl.updateLog(btext,"TS 12: Related search result listed","TS12_Result");

			wl.findPopup();

			//Validating color changes of Donate Now button
			WebElement tempDonate = wl.getDonateNow();
			Thread.sleep(3000);
			Boolean dResult = wl.colorValidation(tempDonate);
			wl.updateLog(dResult,"TS 13: The ~~Donate Now~~ button color changed during mousehover Successfully","TS13_DonHover");


			//Clicking Donate now and validating its navigation
			wl.clickDonateNow();
			Thread.sleep(3000);
			boolean value = wl.compareUrl("https://www.dollardays.com/unitedforasuccessfulschoolyear/wishlist.html");
			wl.updateLog(value,"TS 14: Navigated to targeted page Successfully","TS14_Navigation");

			driver.navigate().back();
			Thread.sleep(3000);

			BrowserUtil.scrollToUp(driver);
			//MyWishlistPage.scrollToUp(driver);
			Thread.sleep(3000);
			wl.getSearchWl().clear();
		}

		//Search by Wishlist name
		if(bSerfield2) {
			wl.clickSearchWl();
			wl.setSearchWl(datatable.get("Wishlist name"));
			Thread.sleep(3000);

			wl.updateLog(true,"TS 15: Valid data entered in the Search bar","TS15_ValidData");

			WebElement tempSearch = wl.getSearch();
			Boolean sResult = wl.colorValidation(tempSearch);
			wl.updateLog(sResult,"TS 16: The ~~Search~~ button color changed during mousehover Successfully","TS16_SerHover");
			Thread.sleep(3000);

			wl.clickSearch();
			Thread.sleep(3000);

			boolean btext = wl.compareText(wl.getWishResult(),"Wishlist Results" );
			BrowserUtil.scrollToDown(driver);
			Thread.sleep(3000);
			wl.updateLog(btext,"TS 17: Related search result listed","TS17_Result");

			//wl.findPopup();
			WebElement tempDonate = wl.getDonateNow();
			Thread.sleep(3000);
			Boolean dResult = wl.colorValidation(tempDonate);
			wl.updateLog(dResult,"TS 18: The ~~Donate Now~~ button color changed during mousehover Successfully","TS18_DonHover");

			wl.clickDonateNow();
			Thread.sleep(3000);

			boolean value = wl.compareUrl("https://www.dollardays.com/firstannualmathexplorationkitdrive/wishlist.html");
			wl.updateLog(value,"TS 19: Navigated to corresponding Page Successfully","TS19_Navigation");

			driver.navigate().back();
			Thread.sleep(3000);

			BrowserUtil.scrollToUp(driver);
			Thread.sleep(3000);

			wl.getSearchWl().clear();

		}

		//Search by City Name
		if (bSerfield3){

			wl.clickCityWl();
			Thread.sleep(3000);
			wl.setCityWl(datatable.get("City"));
			Thread.sleep(3000);
			wl.updateLog(true,"TS 20: Valid data entered in the City/State/Zipcode bar","TS20_ValidData");

			WebElement tempSearch = wl.getSearch();
			Boolean sResult = wl.colorValidation(tempSearch);
			wl.updateLog(sResult,"TS 21: The ~~Search~~ button color changed during mousehover Successfully","TS21_SerHover");
			Thread.sleep(3000);

			wl.clickSearch();
			Thread.sleep(3000);

			boolean btext = wl.compareText(wl.getWishResult(),"Wishlist Results" ); 

			BrowserUtil.scrollToDown(driver);
			Thread.sleep(3000);
			wl.updateLog(btext,"TS 22: Related search result listed","TS22_Result");

			//wl.findPopup();
			WebElement tempDonate = wl.getDonateNow();
			Thread.sleep(3000);
			Boolean dResult = wl.colorValidation(tempDonate);
			wl.updateLog(dResult,"TS 23: The ~~Donate Now~~ button color changed during mousehover Successfully","TS23_DonNav");

			wl.clickDonateNow();
			Thread.sleep(3000);

			boolean value = wl.compareUrl("https://www.dollardays.com/unitedforasuccessfulschoolyear/wishlist.html");
			wl.updateLog(value,"TS 24: Navigated to corresponding Page Successfully","TS24_Navigation");

			driver.navigate().back();
			Thread.sleep(3000);

			BrowserUtil.scrollToUp(driver);
			Thread.sleep(3000);
			wl.getCityWl().clear();
		}

		//Search by State
		if (bSerfield4){

			wl.clickCityWl();
			Thread.sleep(3000);
			wl.setCityWl(datatable.get("State"));
			Thread.sleep(3000);
			wl.updateLog(true,"TS 25: Valid data entered in the City/State/Zipcode bar","TS25_ValidData");

			WebElement tempSearch = wl.getSearch();
			Boolean sResult = wl.colorValidation(tempSearch);
			wl.updateLog(sResult,"TS 26: The ~~Search~~ button color changed during mousehover Successfully","TS26_SerHover");
			Thread.sleep(3000);

			wl.clickSearch();
			Thread.sleep(3000);

			boolean btext = wl.compareText(wl.getWishResult(),"Wishlist Results" );
			BrowserUtil.scrollToDown(driver);
			Thread.sleep(3000);
			wl.updateLog(btext,"TS 27: Related search results listed","TS27_Result");

			//wl.findPopup();
			WebElement tempDonate = wl.getDonateNow();
			Thread.sleep(3000);
			Boolean dResult = wl.colorValidation(tempDonate);
			wl.updateLog(dResult,"TS 28: The ~~Donate Now~~ button color changed during mousehover Successfully","TS28_DonHover");

			wl.clickDonateNow();
			Thread.sleep(3000);

			boolean value = wl.compareUrl("https://www.dollardays.com/unitedforasuccessfulschoolyear/wishlist.html");
			wl.updateLog(value,"TS 29: Navigated to corresponding Page Successfully","TS29_Navigation");

			driver.navigate().back();
			Thread.sleep(3000);

			BrowserUtil.scrollToUp(driver);
			Thread.sleep(3000);
			wl.getCityWl().clear();
		}

		//Search by Zipcode
		if (bSerfield5){

			wl.clickCityWl();
			Thread.sleep(3000);
			wl.setCityWl(datatable.get("zipcode").substring(0,5));
			Thread.sleep(3000);
			wl.updateLog(true,"TS 30: Valid data entered in the City/State/Zipcode bar","TS30_ValidData");

			WebElement tempSearch = wl.getSearch();
			Boolean sResult = wl.colorValidation(tempSearch);
			wl.updateLog(sResult,"TS 31: The ~~Search~~ button color changed during mousehover Successfully","TS31_SerHover");
			Thread.sleep(3000);

			wl.clickSearch();
			Thread.sleep(3000);
			boolean btext = wl.compareText(wl.getWishResult(),"Wishlist Results" );

			BrowserUtil.scrollToDown(driver);
			Thread.sleep(3000);
			wl.updateLog(btext,"TS 32: Related search result listed","TS32_Result");

			//wl.findPopup();
			WebElement tempDonate = wl.getDonateNow();
			Thread.sleep(3000);
			Boolean dResult = wl.colorValidation(tempDonate);
			wl.updateLog(dResult,"TS 33: The ~~Donate Now~~ button color changed during mousehover Successfully","TS33_DonHover");

			wl.clickDonateNow();
			Thread.sleep(3000);

			boolean value = wl.compareUrl("https://www.dollardays.com/unitedforasuccessfulschoolyear/wishlist.html");
			wl.updateLog(value,"TS 34: Navigated to corresponding Page Successfully","TS34_Navigation");

			driver.navigate().back();
			Thread.sleep(3000);

			BrowserUtil.scrollToUp(driver);
			Thread.sleep(3000);
			wl.getCityWl().clear();
		}

		//Search by Organization & Zipcode
		if (bSerfield1 && bSerfield5){

			//Entering both organization name and zipcode
			wl.clickCityWl();
			Thread.sleep(3000);
			wl.setBothOrgCity(datatable.get("Search by Organization"),datatable.get("zipcode").substring(0,5));
			System.out.println("The zipcode" +datatable.get("zipcode"));
			Thread.sleep(3000);
			wl.updateLog(true,"TS 35: Valid data entered in the City/State/Zipcode bar","TS35_ValidData");

			WebElement tempSearch = wl.getSearch();
			Boolean sResult = wl.colorValidation(tempSearch);
			wl.updateLog(sResult,"TS 36: The ~~Search~~ button color changed during mousehover Successfully","TS36_SerHover");
			Thread.sleep(3000);
			wl.clickSearch();
			Thread.sleep(3000);
			boolean btext = wl.compareText(wl.getWishResult(),"Wishlist Results" );

			BrowserUtil.scrollToDown(driver);
			Thread.sleep(3000);
			wl.updateLog(btext,"TS 37: Related search result listed","TS37_Result");

			//wl.findPopup();

			WebElement tempDonate = wl.getDonateNow();
			Thread.sleep(3000);
			Boolean dResult = wl.colorValidation(tempDonate);
			wl.updateLog(dResult,"TS 38: The ~~Donate Now~~ button color changed during mousehover Successfully","TS38_DonHover");

			wl.clickDonateNow();
			Thread.sleep(3000);

			boolean value = wl.compareUrl("https://www.dollardays.com/unitedforasuccessfulschoolyear/wishlist.html");
			wl.updateLog(value,"TS 39: Navigated to corresponding Page Successfully","TS39_Navigation");

			driver.navigate().back();
			Thread.sleep(3000);

			BrowserUtil.scrollToUp(driver);
			Thread.sleep(3000);

			wl.getCityWl().clear();
		}
	}
	@DDDataProvider(datafile= "testdata/Wl_Testdata.xlsx",sheetName ="Wl_Search1",testcaseID = "",runmode = "Yes")
	@Test(priority = 3,dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
	public void wishlistTest_3(Hashtable<String, String> datatable) throws Exception
	{
		MyWishlistPage wl = new MyWishlistPage(driver);

		wl.clickWishlist();
		wl.clickLearnMore();
		Thread.sleep(3000);

		boolean bSerfield1,bSerfield2;
		bSerfield1 = false;
		bSerfield2 = false;

		if ((datatable.get("Search by Organization") != null && !(datatable.get("Search by Organization").equals("")))) {
			bSerfield1 = true;
		}

		if ((datatable.get("City") != null && !(datatable.get("City").equals("")))) {
			bSerfield2= true;
		}

		//Search by Organization - Invalid data
		if(bSerfield1) {
			wl.clickSearchWl();
			wl.setSearchWl(datatable.get("Search by Organization"));
			Thread.sleep(3000);
			wl.clickSearch();
			Thread.sleep(3000);

			//Getting and validating the text of result - scrolling down and showing no result listed with invalid data
			boolean btext = wl.compareText(wl.gettitleWishNoResult(),"No matching wishlist found." );
			BrowserUtil.scrollToDown(driver);
			Thread.sleep(2000);
			System.out.println("Invalid data - No matching Wishlist found");
			wl.updateLog(btext, "TS 40: No matching wishlist found","TS40_NoResult");
			BrowserUtil.scrollToUp(driver);
			wl.getSearchWl().clear();
		}
		//Search by City - Invalid data
		if(bSerfield2) {
			wl.clickCityWl();
			wl.setCityWl(datatable.get("City"));
			Thread.sleep(3000);
			wl.findPopup();
			wl.clickSearch();
			Thread.sleep(3000);

			boolean btext = wl.containsValidation("No matching wishlist found.");

			BrowserUtil.scrollToDown(driver);
			Thread.sleep(2000);
			System.out.println("Invalid data - No matching Wishlist found");
			wl.updateLog(btext, "TS 41: No matching wishlist found","TS41_NoResult");
			BrowserUtil.scrollToUp(driver);
			wl.getCityWl().clear();
		}
		//Search by Organization & City - Invalid Data
		if (bSerfield1 && bSerfield2) {
			wl.clickSearchWl();
			wl.setBothOrgCity(datatable.get("Search by Organization"),datatable.get("City"));
			Thread.sleep(3000);
			wl.clickSearch();
			Thread.sleep(3000);

			boolean btext = wl.containsValidation("No matching wishlist found.");

			BrowserUtil.scrollToDown(driver);
			System.out.println("Invalid data - No matching Wishlist found");
			wl.updateLog(btext, "TS 42: No matching wishlist found","TS42_NoResult");
			BrowserUtil.scrollToUp(driver);
			wl.getSearchWl().clear();
			wl.getCityWl().clear();


			//boolean btext = wl.compareText(wl.gettitleWishNoResult(),"No matching wishlist found." );

		}
	}

	@Test(priority = 4)
	public void wishlistTest_4() throws Exception
	{
		MyWishlistPage wl = new MyWishlistPage(driver);

		wl.clickWishlist();
		wl.clickLearnMore();

		//Checking "Giving & Receiving Donations Made Easy" section is displaying
		BrowserUtil.scrollToDown(driver);
		Thread.sleep(1000);
		boolean image = wl.displayDonationsMade();
		wl.checkImage(image);
		Thread.sleep(3000);

		wl.updateLog(image,"TS 43: The ~~ Donations Made Section ~~ is displaying Successfully","TS43_Display");

		//Validating the color change of "Create a Wishlist" button during mouse hover
		WebElement tempElement = wl.getCreateaWishlist();
		Boolean bresult = wl.colorValidation(tempElement);

		wl.updateLog(bresult,"TS 44: The ~~CREATE A WISHLIST~~ button color changed during mousehover Successfully","TS44_BtnHover");

		Thread.sleep(3000);
		wl.clickCreateWishlist();
		Thread.sleep(3000);
		wl.clickClearToManage();

		//Validating by clicking "Create a Wishlist" button navigates to targeted page
		boolean value = wl.compareUrl("https://www.dollardays.com/myaccount/wishlist.aspx");
		wl.updateLog(value,"TS 45: Navigated to ~~MY WISHLIST~~ Page Successfully","TS45_Navigation");
		Thread.sleep(3000);

		wl.clickWishlist();
		wl.clickLearnMore();
		//wl.findPopup();
		BrowserUtil.scrollToDown(driver);

		//Checking "Our Impact" section is displaying

		boolean images = wl.displayOurImpact();
		wl.checkImage(images);
		wl.updateLog(images,"TS 46: The ~~ Our Impact Section ~~ is displaying Successfully","TS46_Display");

		Thread.sleep(3000);

		WebElement wChange = wl.getViewallProjects();
		boolean bcolor = wl.colorValidation(wChange);
		Thread.sleep(2000);
		wl.updateLog(bcolor,"TS 47: The ~~ View all Projects ~~ button color changed during mousehover Successfully","TS47_BtnHover");

		wl.clickViewProjects();
		BrowserUtil.scrollToUp(driver);
		Thread.sleep(2000);

		//Validating by clicking "View all Projects" button navigates to targeted page
		boolean bLink = wl.compareUrl("https://www.dollardays.com/wishlist/");
		wl.updateLog(bLink,"TS 48: Navigated to ~~ All Projects ~~ Page Successfully","TS48_Navigation");

		driver.navigate().back();
		//wl.clickWishlist();
		//wl.clickLearnMore();
		BrowserUtil.scrollToDown(driver);
		wl.findPopup();
	}
	@Test(priority=5)
	public void wishlistTest_5() throws Exception {

		MyWishlistPage wl = new MyWishlistPage(driver);

		wl.clickWishlist();
		wl.clickLearnMore();
		BrowserUtil.scrollToDown(driver);


		//Checking "Coats for kids Image" section is displaying
		boolean bPresent1 = wl.displayChrist();
		wl.checkImage(bPresent1);
		wl.updateLog(bPresent1,"TS 49: The ~~ Coats for kids Image with info ~~ is displaying Successfully","TS49_Display");

		//Validating by clicking "Donate Now" button navigates to targeted page
		wl.clickDonateNow1(); 
		Thread.sleep(3000);
		boolean bDontitle1 = wl.compareUrl("https://www.dollardays.com/thirtysixthannualcoatsforkids/wishlist.html");
		Thread.sleep(2000);
		wl.updateLog(bDontitle1,"TS 50: BY clicking on Donate Now navigated to targeted page","TS50_Navigation");


		//Validating by adding product and leading to checkout
		wl.setAddCount();
		Thread.sleep(3000);
		WebElement wChange1 = wl.getBtnDonate();
		Thread.sleep(3000);
		boolean bcolor1 = wl.colorValidation(wChange1);
		Thread.sleep(3000);
		wl.updateLog(bcolor1,"TS 51: The ~~ Donate button~~ in Coats For Kids page color changed during mousehover Successfully","TS51_BtnHover");

		wl.clickBtnDonate();
		//Thread.sleep(3000);
		wl.findPopup();

		//Validating - by clicking both "Checkout and View Cart" leads to same checkout page
		wl.mouseHover(wl.getWinCheckout());
		Thread.sleep(2000);

		//Clicking checkout button and validating it navigates to Checkout page
		wl.clickCheckout();
		//Thread.sleep(3000);
		String title1 = driver.getTitle();
		System.out.println("The title of the checkout Page   "  +title1);
		boolean btitle1 = wl.compareTitle("Wishlist");
		wl.updateLog(btitle1, "TS 52: Reached Checkout Page Successfully from Checkout","TS52_Checkout");

		//Returning to the Coats for Kids page
		wl.clickReturntoCart();
		wl.clickReturntoWishlist();
		//driver.navigate().back();

		//Again adding count 
		wl.setAddCount();
		//Thread.sleep(3000);
		wl.findPopup();
		wl.clickBtnDonate();
		Thread.sleep(3000);

		wl.mouseHover(wl.getWinCheckout());
		Thread.sleep(2000);

		//clicking View Cart button and validating it navigates to Checkout page
		wl.clickViewcart();
		wl.clickCheckout1();
		Thread.sleep(3000);
		String title2 = driver.getTitle();
		System.out.println("The title of the checkout Page   "+title2);

		//Validating both view cart and checkout navigates to same page
		boolean btitle2 = wl.compareTitle("Wishlist");
		wl.updateLog(btitle2, "TS 53: Reached Checkout Page Successfully from View Cart","TS53_Checkout");

		if (title1.equals(title2)) {
			System.out.println("The titles of both the pages are same");
			wl.updateLog(true,"TS 54: By Clicking Checkout/View Cart - Navigates to same Checkout Page","TS54_BCheckOut");
		}

		wl.findPopup();
		wl.clickReturntoCart();
		Thread.sleep(2000);
		wl.clickWishlist();
		wl.clickLearnMore();

		//Checking "Winter Care Packages" Image section is displaying

		boolean bPresent2 = wl.displayFreeLaun();
		wl.checkImage(bPresent2);
		wl.updateLog(bPresent2,"TS 55: The ~~Winter care Packages Image with info ~~ is displaying Successfully","TS55_Display");


		wl.clickDonateNow2(); 
		Thread.sleep(3000);
		boolean bDontitle2 = wl.compareUrl("https://www.dollardays.com/wintercarepackages/wishlist.html");
		Thread.sleep(2000);
		wl.updateLog(bDontitle2,"TS 56: BY clicking on Donate Now navigated to targeted page","TS56_Navigation");

<<<<<<< HEAD
		//		//Validating by adding product and leading to checkout
		//		wl.setAddCount();
		//		Thread.sleep(3000);
		//		WebElement wChange2 = wl.getBtnDonate();
		//		Thread.sleep(3000);
		//		boolean bcolor2 = wl.colorValidation(wChange2);
		//		//Thread.sleep(3000);
		//		wl.updateLog(bcolor2,"TS 57: The ~~ Donate button~~ in Winter Care Packages page color changed during mousehover Successfully","TS57_BtnHover");
		//		wl.clickBtnDonate();
		//		Thread.sleep(2000);
		//
		//		//Validating - by clicking both "Checkout and View Cart" leads to same checkout page
		//		wl.mouseHover(wl.getWinCheckout());
		//		Thread.sleep(2000);
		//		wl.clickCheckout();
		//		//Thread.sleep(3000);
		//		String title3 = driver.getTitle();
		//		System.out.println("The title of the checkout Page   "  +title3);
		//		boolean btitle3 = wl.compareTitle("Wishlist");
		//		wl.updateLog(btitle3, "TS 58: Reached Checkout Page Successfully from Checkout","TS58:Checkout");
		//
		//		wl.clickReturntoCart();
		//		wl.clickReturntoWishlist();
		//
		//		wl.setAddCount();
		//		Thread.sleep(3000);
		//		wl.clickBtnDonate();
		//		Thread.sleep(3000);
		//		wl.mouseHover(wl.getWinCheckout());
		//		Thread.sleep(2000);
		//		wl.clickViewcart();
		//		wl.clickCheckout1();
		//		Thread.sleep(3000);
		//		String title4 = driver.getTitle();
		//		System.out.println("The title of the checkout Page   "+title4);
		//
		//		boolean btitle4 = wl.compareTitle("Wishlist");
		//		wl.updateLog(btitle4, "TS 59: Reached Checkout Page Successfully from View Cart","TS59_Checkout");
		//
		//		if (title3.equals(title4)) {
		//			System.out.println("The titles of both the pages are same");
		//			wl.updateLog(true,"TS 60: By Clicking Checkout/View Cart - Navigates to same Page","TS60_BCheckout");
		//		}
		//		wl.clickReturntoCart();
=======
		//Validating by adding product and leading to checkout
		wl.setAddCount();
		Thread.sleep(3000);
		WebElement wChange2 = wl.getBtnDonate();
		Thread.sleep(3000);
		boolean bcolor2 = wl.colorValidation(wChange2);
		//Thread.sleep(3000);
		wl.updateLog(bcolor2,"TS 57: The ~~ Donate button~~ in Free Laundry Events page color changed during mousehover Successfully","TS57_BtnHover");
		wl.clickBtnDonate();
		Thread.sleep(2000);

		//Validating - by clicking both "Checkout and View Cart" leads to same checkout page
		wl.mouseHover(wl.getWinCheckout());
		Thread.sleep(2000);
		wl.clickCheckout();
		//Thread.sleep(3000);
		String title3 = driver.getTitle();
		System.out.println("The title of the checkout Page   "  +title3);
		boolean btitle3 = wl.compareTitle("Wishlist");
		wl.updateLog(btitle3, "TS 58: Reached Checkout Page Successfully from Checkout","TS58:Checkout");

		wl.clickReturntoCart();
		wl.clickReturntoWishlist();

		wl.setAddCount();
		Thread.sleep(3000);
		wl.clickBtnDonate();
		Thread.sleep(3000);
		wl.mouseHover(wl.getWinCheckout());
		Thread.sleep(2000);
		wl.clickViewcart();
		wl.clickCheckout1();
		Thread.sleep(3000);
		String title4 = driver.getTitle();
		System.out.println("The title of the checkout Page   "+title4);

		boolean btitle4 = wl.compareTitle("Wishlist");
		wl.updateLog(btitle4, "TS 59: Reached Checkout Page Successfully from View Cart","TS59_Checkout");

		if (title3.equals(title4)) {
			System.out.println("The titles of both the pages are same");
			wl.updateLog(true,"TS 60: By Clicking Checkout/View Cart - Navigates to same Page","TS60_BCheckout");
		}
		wl.clickReturntoCart();
>>>>>>> 1601a64de6d7e3ab7f596c79fbb70cc2bd0a0a1f
		Thread.sleep(2000);
		wl.clickWishlist();
		wl.clickLearnMore();

		//Checking "Coats for Kids" section is displaying
		boolean bPresent3 = wl.displayCoats();
		wl.checkImage(bPresent3);
		Thread.sleep(2000);
		wl.updateLog(bPresent3,"TS 61: The ~~ Clothing The Homeless with info ~~ is displaying Successfully","TS61_Display");

		wl.clickDonateNow3(); 
		Thread.sleep(3000);
		boolean bDontitle3 = wl.compareUrl("https://www.dollardays.com/clothingthehomelessorg/wishlist.html");
		wl.updateLog(bDontitle3,"TS 62: BY clicking on Donate Now got navigated to targeted page","TS62_Navigation");

		//Validating by adding product and leading to checkout
		wl.setAddCount();
		Thread.sleep(3000);
		WebElement wChange3 = wl.getBtnDonate();
		Thread.sleep(3000);
		boolean bcolor3 = wl.colorValidation(wChange3);
		Thread.sleep(3000);
		wl.updateLog(bcolor3,"TS 63: The ~~ Donate button~~ in Clothing The Homeless color changed during mousehover Successfully","TS63_DonHover");

		wl.clickBtnDonate();
		Thread.sleep(3000);

		//Validating - by clicking both "Checkout and View Cart" leads to same checkout page
		wl.mouseHover(wl.getWinCheckout());
		Thread.sleep(2000);
		wl.clickCheckout();
		//Thread.sleep(3000);
		String title5 = driver.getTitle();
		System.out.println("The title of the checkout Page   "  +title5);
		boolean btitle5 = wl.compareTitle("Wishlist");
		wl.updateLog(btitle5, "TS 64: Reached Checkout Page Successfully from Checkout","TS64_Checkout");
		wl.clickReturntoCart();
		wl.clickReturntoWishlist();

		wl.setAddCount();
		Thread.sleep(3000);
		wl.clickBtnDonate();
		Thread.sleep(3000);
		wl.mouseHover(wl.getWinCheckout());
		Thread.sleep(2000);

		wl.clickViewcart();
		wl.clickCheckout1();
		Thread.sleep(3000);
		String title6 = driver.getTitle();
		System.out.println("The title of the checkout Page   "+title6);
		boolean btitle6 = wl.compareTitle("Wishlist");
		wl.updateLog(btitle6, "TS 65: Reached Checkout Page Successfully from View Cart","TS65_Checkout");
		if (title1.equals(title2)) {
			System.out.println("The titles of both the pages are same");
			wl.updateLog(true,"TS 66: By Clicking ViewCart/Checkout - Navigates to same Page","TS66_BCheckout");
		}
		wl.clickReturntoCart();
		Thread.sleep(2000);
		wl.clickWishlist();
		wl.clickLearnMore();
	}																	
}
