package com.dollardays.testcases;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.dollardays.listners.ExtentTestManager;
import com.dollardays.pages.DD_AllLinksPage;

import java.awt.List;
import java.util.concurrent.TimeUnit;

public class TC_DDTotalLinks extends BaseTest {


	@Test
	public void totalLinks() {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		DD_AllLinksPage lp = new DD_AllLinksPage(driver);

		boolean bvalue = lp.countLinks(685);

		try {
			Assert.assertTrue(bvalue);
	
			ExtentTestManager.getTest().log(Status.PASS, "The total number of links in website validated");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "The total number of links in website differs with expected value");
			System.out.println(e);
		}
		
		lp.urlName();
		System.out.println("All the links from Dollar Days website printed Successfully");
		ExtentTestManager.getTest().log(Status.INFO, "Printed all the links of Dollardays website printed in the console");

	}
}
