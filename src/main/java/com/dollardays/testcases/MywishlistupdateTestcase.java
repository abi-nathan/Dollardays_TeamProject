package com.dollardays.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.dollardays.listners.ExtentTestManager;
import com.dollardays.pages.LoginPage;
import com.dollardays.pages.MywishlistupdatePage;


public class MywishlistupdateTestcase extends BaseTest {

	@Test

	public void MywishlistTc() throws Exception
	{

		LoginPage loginPage = new LoginPage(driver);
		ExtentTestManager.getTest().log(Status.PASS, "Step 1  : Login with Valid credentials");			


		//click Signin dropdown thru signin submenu	
		loginPage.invokeLogin();
		Thread.sleep(3000);

		MywishlistupdatePage Mywishlist = new MywishlistupdatePage(driver);    


		//click okay button when Cookiepopup is display	
		Mywishlist.FindCookiepopup();
		Thread.sleep(3000);


		//click Wishlist menu in Homepoage      
		Mywishlist.clickWishlist();		    
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.PASS, "Step2: Wishlist icon got clicked and dropdown listed");           

		//click WishlistCreateaWishlist sub menu under dropdown 
		Mywishlist.clickCreateaWishlist();		    	    
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.PASS, "Step3: Create a Wishlist link got clicked and got Navigated to Create Your Wishlist page");	    	    

		//click Click here t omanage link
		Mywishlist.Clickheretomanage();		    	    
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.PASS, "Step4: Click here to manage link got clicked and got Navigated to My Wishlist page");

		//clickYour Organization edit link
		Mywishlist.clickYOURORGANIZATION();
		Thread.sleep(3000);
		boolean value = Mywishlist.CompareURl("https://www.dollardays.com/myaccount/wishlistprofile.aspx");
		Assert.assertTrue(true);
		System.out.println("It got navigated to YOUR ORGANIZATION page to update about ORGANIZATION INFORMATION");
		Mywishlist.Updatelog(value, "Step5: YOURORGANIZATION Edit button got clicked and got Navigate to My Account page");

		driver.navigate().back();
		ExtentTestManager.getTest().log(Status.PASS, "Step6:  Navigate back to My Wishlist page");

		//clickYour YOURPROJECTEVENT edit link		    	    
		Mywishlist.clickYOURPROJECTEVENT();		    	    
		Thread.sleep(3000);
		boolean value1 = Mywishlist.CompareURl("https://www.dollardays.com/myaccount/wishlistprojectevent.aspx");
		Assert.assertTrue(true);
		System.out.println("It got navigated to YOUR PROJECT/EVENT page to update about PROJECCT/EVENT INFORMATION");
		Mywishlist.Updatelog(value1, "Step7: YOURPROJECTEVENT Edit button got clicked and got Navigated to My Account page");


		driver.navigate().back();
		ExtentTestManager.getTest().log(Status.PASS, "Step8:  Navigate back to My Wishlist page");	

		//clickYour OURWISHLISTPRODUCTS edit link	
		Mywishlist.clickYOURWISHLISTPRODUCTS();		    	    
		Thread.sleep(3000);
		boolean value2 = Mywishlist.CompareURl("https://www.dollardays.com/myaccount/wishlistproduct.aspx");
		Assert.assertTrue(true);
		System.out.println("It got navigated to YOUR WISHLIST PRODUCTS page to update about UPDATE/REMOVE ITEMS");
		Mywishlist.Updatelog(value2, "Step9: YOURWISHLISTPRODUCTS Edit button got clicked and got Navigated to My Account page");

		driver.navigate().back();
		ExtentTestManager.getTest().log(Status.PASS, "Step10:  Navigate back to My Wishlist page");	

		//clickYour YOUR WISHLIST ORDERS view all link	 
		Mywishlist.clickYOURWISHLISTORDERS();		    	    
		Thread.sleep(3000);
		boolean value3 = Mywishlist.CompareURl("https://www.dollardays.com/myaccount/wishlist-order-history.aspx");
		Assert.assertTrue(true);
		System.out.println("It got navigated to YOUR WISHLIST ORDERS page to update about WISHLIST ORDER HISTORY");
		Mywishlist.Updatelog(value3, "Step11: YOUR WISHLIST ORDERS view all button got clicked and got Navigated to Wishlist Order History page");

		driver.navigate().back();
		ExtentTestManager.getTest().log(Status.PASS, "Step12:  Navigate back to My Wishlist page");	

		//Comparing URL
		Mywishlist.clickYOURWISHLISTURl();		    	    
		Thread.sleep(3000);
		boolean value4 = Mywishlist.CompareURl("https://www.dollardays.com/firstannual/wishlist.html");
		Assert.assertTrue(true);
		System.out.println("YOUR WISHLIST URL got clicked and is displaying as per requested");
		Mywishlist.Updatelog(value4, "Step13: YOUR WISHLISTURL got clicked and got Navigated to display the same URL");


		driver.navigate().back();
		System.out.println("Navigate back to My Wishlist page");
		ExtentTestManager.getTest().log(Status.PASS, "Step13:  Navigate back to My Wishlist page");	

		//clickYour YOUR WISHLIST ORDERS view all link again to check the Navigating page 
		Mywishlist.clickYOURWISHLISTORDERS();		    	    
		Thread.sleep(3000);	
		System.out.println("It got navigated to YOUR WISHLIST ORDERS page to  WISHLIST ORDER HISTORY page");
		ExtentTestManager.getTest().log(Status.PASS, "Step14:  YOUR WISHLIST ORDERS view all button got clicked and got Navigated to Wishlist Order History page");

		//calling Automate datepicker method
		Mywishlist.wishorderhistory();
		Thread.sleep(3000);
		System.out.println(" Start Date and End Date should be pass in the date field");
		ExtentTestManager.getTest().log(Status.PASS, "Step15:  Start Date should be displays in the start date field calender==> 01/12/2018 and End Date should be displays in the end date field calender==> 12/25/2019");
		//Thread.sleep(2000);

		//click My wishlist order history Submit button 
		Mywishlist.clickSubmitbtn();		    	    
		Thread.sleep(3000);

		//After submitiing check  My wishlist order history page updated text is displaying
		Mywishlist.getwishlistorderhistory().getText();
		String Result = "No wishlist orders found between 1/12/2018 and 12/25/2019";
		System.out.println(Result);		
		ExtentTestManager.getTest().log(Status.PASS, "Step16:  Able to see the text of No wishlist orders found between 01/12/2018 and 12/25/2019 text");

	}

}







