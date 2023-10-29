package com.naveenautomationlabs.AFramework.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.naveenautomationlabs.AFramework.ProxyDriver.ProxyDriver;

public class SideNavBar extends Page{

	public SideNavBar(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void isLoaded() {
		
		
	}
	public Page OpenPageByClickOnSideNavBar(ConsumerSideNavigationBar item) {
		List<WebElement> sideBarItems = wd.findElements(By.cssSelector("div.list-group a"));

		for (WebElement webElement : sideBarItems) {
			if (webElement.getText().trim().equalsIgnoreCase(item.getItem())) {
				((ProxyDriver) wd).click(webElement);
				return (Page) this.waitForPageToLoad(item.getpageClass());
			}
		}
		return null;
	}

}
