package com.dollardays.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DD_AllLinksPage {

	public WebDriver driver;

	public DD_AllLinksPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	//To find the list of elements on a page using @FindBys

	//@FindBys(@FindBy(tagName = "a"))
	//private List<WebElement> links;

	@FindBy(how = How.TAG_NAME, using ="a")
	private List<WebElement> links;

	public  List<WebElement> getallLinks() {
		return  links;
	} 

	public boolean countLinks(int numLinks) {
		java.util.List<WebElement> allLinks = getallLinks();
		int totalLinks = allLinks.size();
		System.out.println("The Total number of links in HomePage == " + totalLinks);
		
		if (totalLinks == numLinks) {
			System.out.println("The total number of links in website validated");
			return true;
		}else {
			System.out.println("The total number of links in website differs with actual");
			return false;
		}
	}
	public List<String> urlName() {
		java.util.List<WebElement> allLinks = getallLinks();
		List<String> names = new ArrayList<String>();
		for (WebElement element : allLinks) {

			System.out.println(element.getText() + " - " + element.getAttribute("href"));
						
		}
		return names;
	}


	//	public boolean linkValidation(int numlinks) {
	//		java.util.List<WebElement> allLinks = getallLinks();
	//		 int totalLinks = allLinks.size();
	//		
	//		if(totalLinks == numlinks && urlName().contains("http")) {
	//			System.out.println("Validated all links Successfully");
	//			return true;
	//		}else 
	//			System.out.println("Not Validated all links Successfully");
	//
	//			return false;
	//	}
}
