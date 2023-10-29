package com.naveenautomationlabs.AFramework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.naveenautomationlabs.AFramework.ProxyDriver.ProxyDriver;

import java.util.List;

public abstract class Page extends GeneralPage {
	private static final String URL = "https://naveenautomationlabs.com";

	public Page(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	public String getDomain() {
		return URL;
	}

	@Override
	protected String getPageUrl() {
		return getDomain();
	}

	/*
	 * public String rtNavigationBar(RtNavigation n) { List<WebElement> rtCB =
	 * ((ProxyDriver) wd).findElements(By.cssSelector("aside>div>a")); for
	 * (WebElement element : rtCB) { if (element.getText().equals(n.getValue())) {
	 * ((ProxyDriver) wd).click(element); break; } } return n.className; }
	 */

	/*
	 * public enum RtNavigation {
	 * 
	 * LOGIN("Login","AccountLogin"), REGISTER("Register","RegisterAccount"),
	 * FORGOTTEN_PASSWORD("Forgotten Password","ForgotYourPassword"),
	 * 
	 * MY_ACCOUNT("My Account", "My Account"), EDIT_ACCOUNT("Edit Account",
	 * "My Account Information"), PASSWORD("Password", "Change Password"),
	 * ADDRESS_BOOK("Address Book", "Address Book"), WISH_LIST("Wish List",
	 * "My Wish List"), ORDER_HISTORY("Order History", "Order History"),
	 * DOWNLOADS("Downloads", "Account Downloads"),
	 * RECURRING_PAYMENTS("Recurring Payments", "Recurring Payments"),
	 * REWARD_POINTS("Rewards Points", "Your Reward Points"), RETURNS("Returns",
	 * "Products Returns"), TRANSACTIONS("Transactions", "Your Transactions"),
	 * NEWSLETTER("Newsletter", "Newsletter Subscription"), LOGOUT("Logout",
	 * "Account Logout");
	 * 
	 * String value; String className;
	 * 
	 * private RtNavigation(String value, String className) { this.value = value;
	 * this.className = className; }
	 * 
	 * public String getValue() { return value; }
	 * 
	 * public String getClassName() { return className; }
	 * 
	 * }
	 */
}
