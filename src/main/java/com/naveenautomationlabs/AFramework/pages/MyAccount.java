package com.naveenautomationlabs.AFramework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.naveenautomationlabs.AFramework.ProxyDriver.ProxyDriver;

public class MyAccount extends Page {
	public String PAGE_URL = "/opencart/index.php?route=account/account";

	public MyAccount(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private static By wishListBtn = By.cssSelector("a#wishlist-total span");
	private static By myAccountText = By.cssSelector("#content>h2:first-of-type");

	public String getMyAccountText() {
		return ((ProxyDriver) wd).getText(myAccountText);
	}

	public MyWishList clickWishListBtn() {

		((ProxyDriver) wd).click(wishListBtn);
		return new MyWishList(wd,true);
	}

	@Override
	protected void isLoaded() {
		if (!urlContains(wd.getCurrentUrl())) {
			throw new Error();
		}
	}

	@Override
	protected String getPageUrl() {
		return getDomain() + PAGE_URL;
	}

	@Override
	public MyAccount get() {
		return (MyAccount) super.get();
	}

}
